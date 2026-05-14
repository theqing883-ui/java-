package com.heima.service.impl;

import com.heima.service.GameService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * 游戏服务实现类
 * 实现GameService接口，处理游戏相关的业务逻辑
 */
@Service
public class GameServiceImpl implements GameService {
    
    /**
     * 游戏聊天客户端
     * 用于处理游戏相关的聊天请求
     */
    @Autowired
    private ChatClient gameClient;

    /**
     * 处理游戏请求
     * @param prompt 游戏提示词
     * @param chatId 聊天会话ID
     * @return 游戏响应的流式数据
     */
    @Override
    public Flux<String> game(String prompt, String chatId) {
        // 使用gameClient处理请求
        return gameClient.prompt()
                .user(prompt) // 设置用户提示词
                // 修改了这里：使用最新版 API 的常量
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, chatId)) // 设置会话ID
                .stream()      // 流式调用
                .content(); // 返回内容
    }
}