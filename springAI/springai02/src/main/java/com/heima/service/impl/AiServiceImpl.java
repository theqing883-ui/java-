package com.heima.service.impl;

import com.heima.service.AiService;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class AiServiceImpl implements AiService {
    @Resource
    private ChatClient serviceClient;


    @Override
    public Flux<String> service(String prompt, String chatId) {
        if (prompt == null || prompt.isEmpty()) {
            return Flux.just("错误：提问内容不能为空");
        }
        return serviceClient.prompt()
                .user(prompt)
                // 修改了这里：使用最新版 API 的常量
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()      // 流式调用
                .content();

    }


}
