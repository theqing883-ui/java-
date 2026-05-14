package com.heima.controller;

import com.heima.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 游戏控制器
 * 处理游戏相关的HTTP请求
 */
@RestController
@RequestMapping("/ai")
public class GameController {
    
    /**
     * 游戏服务
     * 用于处理游戏相关的业务逻辑
     */
    @Autowired
    GameService gameService;

    /**
     * 处理游戏请求
     * @param msg 游戏提示信息
     * @param chatId 聊天会话ID
     * @return 游戏响应的流式数据
     */
    @GetMapping("/game")
    public Flux<String> game(@RequestParam("prompt") String msg, @RequestParam("chatId") String chatId) {
        // 调用游戏服务处理请求并返回流式响应
        return gameService.game(msg, chatId);
    }
}