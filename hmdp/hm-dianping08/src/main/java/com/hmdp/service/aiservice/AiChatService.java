package com.hmdp.service.aiservice;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,//手动装配
        chatModel = "openAiChatModel",//指定模型
        streamingChatModel = "openAiStreamingChatModel",
        chatMemoryProvider = "chatMemoryProvider", // 配置会话记忆提供者对象
        contentRetriever = "contentRetriever",// 配置向量数据库检索对象
        tools = {"shopTool", "reservationTool", "voucherTool"}
)

public interface AiChatService {
    @SystemMessage(fromResource = "system.txt")
        // 确保消息列表至少有一条系统消息
    Flux<String> chat(@MemoryId String memoryId, @UserMessage String message);
}
