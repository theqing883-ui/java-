package com.kaer.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.ai.zhipuai.ZhiPuAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//当程序启动自动执行的，自动创建客户端，并自动注入ChatClientRegistry到map中
public class MultiChatClientConfig {
    // deepseek
    @Bean("deepseek-chat")
    public ChatClient deepSeekChatClient(DeepSeekChatModel model) {
        return ChatClient.create(model);
    }

    // zhipuai
    @Bean("glm-4.6")
    public ChatClient zhipuAiChatClient(ZhiPuAiChatModel model) {
        return ChatClient.create(model);
    }
}
