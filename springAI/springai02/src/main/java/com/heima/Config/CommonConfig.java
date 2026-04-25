package com.heima.Config;

import com.heima.repositor.RedisChatMemory;
import com.heima.repositor.RedisGameMemory;
import com.heima.repositor.RedisPDFMemory;
import com.heima.repositor.RedisServiceMemory;
import com.heima.tool.CourseTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@Configuration
public class CommonConfig {
    // 手动加载 classpath 下的文件
    Resource systemGamePromptResource = new ClassPathResource("gamesystem.txt");
    Resource systemServicePromptResource = new ClassPathResource("servicesystem.txt");


    @Bean
    public ChatClient chatClient(OllamaChatModel model, RedisChatMemory chatMemory) {
        return ChatClient
                .builder(model) // 使用Ollama模型构建ChatClient
                .defaultSystem("你是我的学习助手，每次回答最后面都空两行后跟一条java/mysql/agent/Redis相关的面试常问知识点，并给出答案。")
//                .defaultSystem("你是我的java学习助手") // 设置默认系统提示
                .defaultAdvisors(
                        new SimpleLoggerAdvisor(),// 开启日志记录
                        MessageChatMemoryAdvisor.builder(chatMemory).build() // 配置聊天记忆顾问
                )
                .build();
    }

    @Bean
    public ChatClient gameClient(OllamaChatModel model, RedisGameMemory chatMemory) {
        return ChatClient
                .builder(model) // 使用Ollama模型构建ChatClient
                .defaultSystem(systemGamePromptResource)
                .defaultAdvisors(
                        new SimpleLoggerAdvisor(),// 开启日志记录
                        MessageChatMemoryAdvisor.builder(chatMemory).build() // 配置聊天记忆顾问
                )
                .build();
    }

    @Bean
    public TokenTextSplitter tokenTextSplitter() {
        // 使用默认的文本切分器配置
        // 默认配置通常是：每个块(chunk) 800 个 Token，重叠(overlap) 400 个 Token
        return new TokenTextSplitter();

        // 如果你想自定义切分大小，可以像下面这样写（注释掉上面那行，用下面这行）：
        // return new TokenTextSplitter(1000, 200, 5, 10000, true);
    }

    @Bean
    public ChatClient serviceClient(OllamaChatModel model, RedisServiceMemory chatMemory, CourseTool tool) {
        return ChatClient
                .builder(model) // 使用Ollama模型构建ChatClient
                .defaultSystem(systemServicePromptResource)
                .defaultAdvisors(
                        new SimpleLoggerAdvisor(),// 开启日志记录
                        MessageChatMemoryAdvisor.builder(chatMemory).build() // 配置聊天记忆顾问
                )
                .defaultTools(tool)
                .build();
    }

    @Bean
    public ChatClient ragChatClient(OllamaChatModel model, RedisPDFMemory chatMemory, VectorStore vectorStore) {
        return ChatClient
                .builder(model)
                .defaultSystem("你是一个智能助手，请根据提供的上下文信息回答问题。如果上下文中没有相关信息，不要瞎编乱造。")
                .defaultAdvisors(
                        new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),
                        QuestionAnswerAdvisor
                                .builder(vectorStore)
                                .searchRequest(
                                        SearchRequest.builder() // 向量检索的请求参数
                                                .similarityThreshold(0.2d) // 相似度阈值
                                                .topK(2) // 返回的文档片段数量
                                                .build()
                                ).build()
                )
                .build();
    }

}