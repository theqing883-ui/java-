package com.heima.service.impl;

import com.heima.service.GameService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private ChatClient gameClient;

    @Override
    public Flux<String> game(String prompt, String chatId) {
        return gameClient.prompt()
                .user(prompt)
                // 修改了这里：使用最新版 API 的常量
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()      // 流式调用
                .content();
    }
}
