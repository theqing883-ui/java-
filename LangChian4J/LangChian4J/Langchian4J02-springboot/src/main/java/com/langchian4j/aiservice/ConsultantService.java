package com.langchian4j.aiservice;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,//手动装配
        chatModel = "openAiChatModel",// 阻塞式指定模型
        streamingChatModel = "openAiStreamingChatModel",// 流式调用
//        chatMemory = "chatMemory"//会话记忆
        chatMemoryProvider = "chatMemoryProvider",// 会话隔离
        contentRetriever = "contentRetriever",//rag知识库
        tools = "reservationTool"
)
//@AiService
public interface ConsultantService {
    /*用于聊天*/
//    String chat(String message);/*阻塞式*/
    @SystemMessage(fromResource = "system.txt")
//    @SystemMessage("你是特朗普特靠谱！")
//    @UserMessage("你是特朗普特靠谱！{{it}}")
    Flux<String> chat(@UserMessage String message, @MemoryId String memoryId);
}
