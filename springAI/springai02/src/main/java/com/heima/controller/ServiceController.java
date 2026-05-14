package com.heima.controller;

import com.heima.service.AiService;
import com.heima.service.HistoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 服务控制器
 * 处理AI服务相关的HTTP请求
 */
@RestController
@RequestMapping("/ai")
@Slf4j
public class ServiceController {
    
    /**
     * AI服务
     * 用于处理AI服务相关的业务逻辑
     */
    @Resource
    AiService aiService;
    
    /**
     * 历史记录服务
     * 用于管理聊天历史记录
     */
    @Resource
    HistoryService historyService;

    /**
     * 处理服务请求
     * @param prompt 服务提示词
     * @param chatId 聊天会话ID
     * @return 服务响应的流式数据
     */
    @GetMapping(value = "/service", produces = "text/html;charset=utf-8")
    public Flux<String> service(@RequestParam("prompt") String prompt,
                                @RequestParam("chatId") String chatId) {
        // 保存历史会话id
        historyService.saveIds("service", chatId);
        // 调用AI服务处理请求并返回流式响应
        return aiService.service(prompt, chatId);
    }
}