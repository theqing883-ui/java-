package com.heima.service.impl;

import com.heima.service.AiService;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


/**
 * AI服务实现类
 * 实现AiService接口，处理AI服务相关的业务逻辑
 */
@Service
public class AiServiceImpl implements AiService {
    
    /**
     * 服务聊天客户端
     * 用于处理服务相关的聊天请求
     */
    @Resource
    private ChatClient serviceClient;

    /**
     * 处理AI服务请求
     * @param prompt 服务提示词
     * @param chatId 聊天会话ID
     * @return 服务响应的流式数据
     */
    @Override
    public Flux<String> service(String prompt, String chatId) {
        // 检查提示词是否为空
        if (prompt == null || prompt.isEmpty()) {
            return Flux.just("错误：提问内容不能为空");
        }
        // 使用serviceClient处理请求
        return serviceClient.prompt()
                .user(prompt) // 设置用户提示词
                // 修改了这里：使用最新版 API 的常量
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, chatId)) // 设置会话ID
                .stream()      // 流式调用
                .content(); // 返回内容

    }


}