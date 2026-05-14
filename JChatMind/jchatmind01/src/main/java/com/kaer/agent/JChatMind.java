package com.kaer.agent;

import com.kaer.converter.ChatMessageConverter;
import com.kaer.message.SseMessage;
import com.kaer.model.dto.ChatMessageDTO;
import com.kaer.model.dto.KnowledgeBaseDTO;
import com.kaer.model.response.CreateChatMessageResponse;
import com.kaer.model.vo.ChatMessageVO;
import com.kaer.service.ChatMessageFacadeService;
import com.kaer.service.SseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.ToolResponseMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.tool.DefaultToolCallingChatOptions;
import org.springframework.ai.model.tool.ToolCallingManager;
import org.springframework.ai.model.tool.ToolExecutionResult;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class JChatMind {
    // 最多循环次数
    private static final Integer MAX_STEPS = 20;
    private static final Integer DEFAULT_MAX_MESSAGES = 20;
    // AI 返回的，已经持久化，但是需要 sse 发给前端的消息
    private final List<ChatMessageDTO> pendingChatMessages = new ArrayList<>();
    // 智能体 ID
    private String agentId;
    // 名称
    private String name;
    // 描述
    private String description;
    // 默认系统提示词
    private String systemPrompt;
    // 交互实例
    private ChatClient chatClient;
    // 状态
    private AgentState agentState;
    // 可用的工具
    private List<ToolCallback> availableTools;
    // 可访问的知识库
    private List<KnowledgeBaseDTO> availableKbs;
    // 工具调用管理器
    private ToolCallingManager toolCallingManager;
    // 模型的聊天记录
    private ChatMemory chatMemory;
    // 模型的聊天会话 ID
    private String chatSessionId;
    // SpringAI 自带的 ChatOptions, 不是 AgentDTO.ChatOptions
    private ChatOptions chatOptions;
    // SSE 服务, 用于发送消息给前端
    private SseService sseService;
    private ChatMessageConverter chatMessageConverter;
    private ChatMessageFacadeService chatMessageFacadeService;
    // 最后一次的 ChatResponse
    private ChatResponse lastChatResponse;

    public JChatMind() {
    }

    public JChatMind(String agentId, String name, String description, String systemPrompt, ChatClient chatClient, Integer maxMessages, List<Message> memory, List<ToolCallback> availableTools, List<KnowledgeBaseDTO> availableKbs, String chatSessionId, SseService sseService, ChatMessageFacadeService chatMessageFacadeService, ChatMessageConverter chatMessageConverter) {
        this.agentId = agentId;
        this.name = name;
        this.description = description;
        this.systemPrompt = systemPrompt;

        this.chatClient = chatClient;

        this.availableTools = availableTools;
        this.availableKbs = availableKbs;

        this.chatSessionId = chatSessionId;
        this.sseService = sseService;

        this.chatMessageFacadeService = chatMessageFacadeService;
        this.chatMessageConverter = chatMessageConverter;

        this.agentState = AgentState.IDLE;

        // 保存聊天记录
        this.chatMemory = MessageWindowChatMemory.builder().maxMessages(maxMessages == null ? DEFAULT_MAX_MESSAGES : maxMessages).build();
        this.chatMemory.add(chatSessionId, memory);

        // 添加系统提示
        if (StringUtils.hasLength(systemPrompt)) { // Agent 设置时添加的系统提示词
            this.chatMemory.add(chatSessionId, new SystemMessage(systemPrompt));
        }

        // 关闭 SpringAI 自带的内部的工具调用自动执行功能
        this.chatOptions = DefaultToolCallingChatOptions.builder().internalToolExecutionEnabled(false).build();
        /*剥夺 Spring AI 的“自动决定权”，将工具执行的控制权完全握在开发者自己手中。*/

        // 工具调用管理器
        this.toolCallingManager = ToolCallingManager.builder().build();
    }

    /**
     * 启动 Agent 的主循环
     * 
     * Agent 会在以下条件之一满足时停止：
     * 1. 达到最大循环次数（MAX_STEPS = 20）
     * 2. AI 决定结束对话（agentState 变为 FINISHED）
     * 3. 发生异常（agentState 变为 ERROR）
     *
     * @throws IllegalStateException 当 Agent 状态不是 IDLE 时抛出
     * @throws RuntimeException      当执行过程中发生异常时抛出
     */
    public void run() {
        // 校验 Agent 状态必须为 IDLE（空闲）
        if (agentState != AgentState.IDLE) {
            throw new IllegalStateException("Agent 状态不为 idle(空闲) ");
        }

        try {
            // Agent 主循环：最多执行 MAX_STEPS 次，或直到状态变为 FINISHED
            for (int i = 0; i < MAX_STEPS && agentState != AgentState.FINISHED; i++) {
                // 当前步骤编号（从1开始）
                int currentStep = i + 1;

                // 执行单步：思考（think）+ 执行（execute）
                step();

                // 检查是否达到最大步骤限制
                if (currentStep >= MAX_STEPS) {
                    agentState = AgentState.FINISHED;
                    log.warn("Agent {} reached max steps of {}", agentId, MAX_STEPS);
                }
            }

            // 循环正常结束，设置状态为 FINISHED
            agentState = AgentState.FINISHED;
        } catch (Exception e) {
            // 捕获异常，设置状态为 ERROR
            agentState = AgentState.ERROR;
            log.error("Error running agent", e);
            throw new RuntimeException("Error running agent", e);
        }
    }

    private void step() {
        if (think()) {
            execute();
        } else {
            this.agentState = AgentState.FINISHED;
        }
    }

    /**
     * Agent 的「思考」方法，负责与 AI 模型进行对话并决定下一步动作
     *
     * @return 如果存在工具调用则返回 true，否则返回 false（表示对话结束）
     */
    private boolean think() {
        // 构建决策模块的系统提示词，告知 AI 当前可用的知识库列表
        String thinkPrompt = """
                现在你是一个智能的的具体「决策模块」
                请根据当前对话上下文，决定下一步的动作。
                                \s
                【额外信息】
                - 你目前拥有的知识库列表以及描述：%s
                - 如果有缺失的上下文时，优先从知识库中进行搜索
                """.formatted(this.availableKbs);

        // 构建 Prompt 对象，包含聊天历史和配置选项
        Prompt prompt = Prompt.builder()
                .chatOptions(this.chatOptions)
                .messages(this.chatMemory.get(this.chatSessionId))
                .build();

        // 调用 AI 客户端执行聊天请求，使用链式 API 构建完整对话
        this.lastChatResponse = this.chatClient.prompt(prompt)              // 设置包含聊天历史和选项的 Prompt
                .system(thinkPrompt)         // 设置系统提示词（定义角色、知识库等上下文）
                .toolCallbacks(this.availableTools)  // 注册可用工具回调（支持工具调用）
                .call()                     // 发起 AI 聊天请求
                .chatClientResponse()       // 获取LLM响应包装对象
                .chatResponse();            // 提取核心的聊天响应内容

        // 校验 AI 响应不为空，为空则抛出 IllegalArgumentException 异常
        Assert.notNull(this.lastChatResponse, "AI 聊天响应为空");

        // 提取 AI 的输出消息
        AssistantMessage output = this.lastChatResponse.getResult().getOutput();
        // 获取 AI 决定调用的工具列表
        List<AssistantMessage.ToolCall> toolCalls = output.getToolCalls();

        // 持久化 AI 响应消息到数据库
        saveMessage(output);
        // 将新消息推送给前端（通过 SSE）
        refreshPendingChatMessages();
        // 记录工具调用日志
        logToolCalls(toolCalls);

        // 返回是否存在工具调用：true 表示需要执行工具，false 表示对话结束
        return !toolCalls.isEmpty();
    }

    /**
     * Agent 的「执行」方法，负责执行 AI 决定调用的工具
     */
    private void execute() {
        // 校验 AI 响应不为空
        Assert.notNull(this.lastChatResponse, "AI 聊天响应为空");

        // 如果没有工具调用，则直接返回（无需执行）
        if (!this.lastChatResponse.hasToolCalls()) {
            return;
        }

        // 构建包含当前对话历史的 Prompt
        Prompt prompt = Prompt.builder()
                .chatOptions(this.chatOptions)
                .messages(this.chatMemory.get(this.chatSessionId))
                .build();

        // 使用工具调用管理器执行 AI 指定的工具调用
        ToolExecutionResult toolExecutionResult = toolCallingManager.executeToolCalls(prompt, lastChatResponse);

        // 清空旧的对话历史，更新为包含工具执行结果的新历史
        this.chatMemory.clear(this.chatSessionId);
        this.chatMemory.add(this.chatSessionId, toolExecutionResult.conversationHistory());

        // 从工具执行结果中提取最后一条工具响应消息
        // 工具执行完成后，conversationHistory 的最后一条消息即为工具响应
        ToolResponseMessage toolResponseMessage = (ToolResponseMessage) toolExecutionResult
                .conversationHistory()
                .get(toolExecutionResult.conversationHistory().size() - 1);

        String collect = toolResponseMessage.getResponses()
                .stream()
                .map(resp -> "工具" + resp.name() + "的返回结果为：" + resp.responseData())
                .collect(Collectors.joining("\n"));
        log.info("调用工具结果：{}", collect);

        // 保存工具调用结果
        saveMessage(toolResponseMessage);
        // 将新消息推送给前端（通过 SSE）
        refreshPendingChatMessages();

        if (toolResponseMessage.getResponses()
                .stream()
                .anyMatch(resp -> resp.name().contains("terminate"))) {
            this.agentState = AgentState.FINISHED;
            log.info("任务完成");
        }
    }

    /**
     * 将 AI 请求的工具调用（Tool Calls）列表格式化并输出到日志中。
     *
     * @param toolCalls 大模型返回的工具调用指令列表
     */
    private void logToolCalls(List<AssistantMessage.ToolCall> toolCalls) {

        // 如果 AI 这一轮没有要求调用任何工具，直接记录一条简单日志并退出方法，避免空指针异常。
        if (toolCalls == null || toolCalls.isEmpty()) {
            log.info("\n\n[ToolCalling] 无工具调用");
            return;
        }

        // 2. 【流式处理】使用 Java 8 Stream API 进行数据加工：
        // 我们不使用普通的 for 循环，而是使用 IntStream 来处理索引，这样方便给工具调用编号。
        String collect = IntStream.range(0, toolCalls.size()) // 生成一个 0 到 size-1 的整数流
                .mapToObj(i -> {
                    // 根据当前的索引 i，从原始列表中获取具体的工具调用对象
                    AssistantMessage.ToolCall toolCall = toolCalls.get(i);

                    // 3. 【字符串格式化】：
                    // 使用 String.format 构建多行文本，增强可读性：
                    // %d 代表整数（序号），从 1 开始计数
                    // %s 代表字符串（工具名和 JSON 格式的参数）
                    return String.format(
                            "[ToolCalling #%d]\n- name      : %s\n- arguments : %s",
                            i + 1,               // 序号展示给人类看，所以加 1
                            toolCall.name(),      // 获取工具名称（如 "databaseQuery"）
                            toolCall.arguments()  // 获取工具参数（通常是 JSON 字符串）
                    );
                })
                // 4. 【聚合操作】：
                // 将流中每一条格式化好的字符串，使用“换行符(\n)”作为分隔符，拼接成一整个大字符串。
                .collect(Collectors.joining("\n"));

        // 5. 【日志输出】：
        log.info("\n\n[ToolCalling] 工具调用结果：{}", collect);
    }

    // 发送消息到前端
    private void refreshPendingChatMessages() {
        // 从pendingChatMessages中获取最新的聊天记录
        for (ChatMessageDTO message : this.pendingChatMessages) {
            ChatMessageVO chatMessageVO = chatMessageConverter.toVO(message);
            SseMessage sseMessage = SseMessage.builder().type(SseMessage.Type.AI_GENERATED_CONTENT)
                    .payload(SseMessage.Payload.builder()
                            .message(chatMessageVO).build())
                    .metadata(SseMessage.Metadata.builder()
                            .chatMessageId(message.getId())
                            .build()).build();
            sseService.send(this.chatSessionId, sseMessage);
        }
        pendingChatMessages.clear();
    }

    // 需要 Agent 持久化的 Message 子类有以下两类
    // AssistantMessage //AI 生成的消息
    // ToolResponseMessage //工具调用后的相应结果
    // AI生成的消息和工具调用后的相应结果都会返回到Spring AI框架中，我们持久化的消息都是从spring ai框架中获取的
    // SystemMessage 不需要持久化
    // UserMessage 在每次用户发送问题之间就已经持久化过了
    private void saveMessage(Message message) {
        // 1. 创建 ChatMessageDTO 的构建器实例（通常由 Lombok 的 @Builder 注解生成）
        ChatMessageDTO.ChatMessageDTOBuilder builder = ChatMessageDTO.builder();

        // 2. 使用 Java 16+ 的 instanceof 模式匹配：如果 message 是 AssistantMessage 类型，
        //    则将其自动转换为 assistantMessage 变量（无需显式强制转换）
        if (message instanceof AssistantMessage assistantMessage) {
            // 3. 链式调用构建器方法设置各种属性
            ChatMessageDTO chatMessageDTO = builder.role(ChatMessageDTO.RoleType.ASSISTANT)          // 设置角色为 ASSISTANT
                    .content(assistantMessage.getText())             // 从 AssistantMessage 获取文本内容
                    .sessionId(this.chatSessionId)                   // 设置会话 ID（来自当前对象的字段）
                    .metadata(                                       // 设置元数据，这里使用内嵌的构建器
                            ChatMessageDTO.MetaData.builder()            // 创建 MetaData 的构建器
                                    .toolCalls(assistantMessage.getToolCalls()) // 设置工具调用信息
                                    .build()                                 // 完成 MetaData 对象的构建
                    ).build();// 4. 最终构建 ChatMessageDTO 对象
            // 真正持久话操作
            CreateChatMessageResponse chatMessage = chatMessageFacadeService.createChatMessage(chatMessageDTO);
            chatMessageDTO.setId(chatMessage.getChatMessageId());// 这里是id 不是 sessionId
            // 将新消息添加到 pendingChatMessages 中
            pendingChatMessages.add(chatMessageDTO);
        } else if (message instanceof ToolResponseMessage toolResponseMessage) {
            // 持久化 ToolResponseMessage
            List<ToolResponseMessage.ToolResponse> toolResponses = toolResponseMessage.getResponses();
            for (ToolResponseMessage.ToolResponse toolResponse : toolResponses) {
                ChatMessageDTO chatMessageDTO = builder.role(ChatMessageDTO.RoleType.TOOL).content(toolResponse.responseData()).sessionId(this.chatSessionId).metadata(ChatMessageDTO.MetaData.builder().toolResponse(toolResponse).build()).build();
                CreateChatMessageResponse chatMessage = chatMessageFacadeService.createChatMessage(chatMessageDTO);
                chatMessageDTO.setId(chatMessage.getChatMessageId());
                pendingChatMessages.add(chatMessageDTO);
            }
        } else {
            // 其他 Message 类型，抛出异常
            throw new IllegalArgumentException("不支持的 Message 类型: " + message.getClass().getName());
        }
    }


    @Override
    public String toString() {
        return "JChatMind {" + "name = " + name + ",\n"
                + "description = " + description + ",\n"
                + "agentId = " + agentId + ",\n"
                + "systemPrompt = " + systemPrompt + "}";
    }

}