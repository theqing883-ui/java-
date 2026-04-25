package com.heima.service.impl;

import com.heima.service.ChatService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class ChatServiceImpl implements ChatService {
    @Resource
    private ChatClient chatClient;


    @Override
    public Flux<String> chat(String prompt, String chatId) {
        if (prompt == null || prompt.isEmpty()) {
            return Flux.just("错误：提问内容不能为空");
        }
        return chatClient.prompt()
                .user(prompt)
                // 修改了这里：使用最新版 API 的常量
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()      // 流式调用
                .content();

    }


}
