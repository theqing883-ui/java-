package com.heima.controller;

import com.heima.service.ChatService;
import com.heima.service.HistoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 聊天控制器
 * 处理AI聊天相关的HTTP请求
 */
@RestController
@RequestMapping("/ai")
@Slf4j
public class ChatController {

    /**
     * 聊天服务
     * 用于处理聊天业务逻辑
     */
    @Resource
    ChatService chatService;

    /**
     * 历史记录服务
     * 用于管理聊天历史记录
     */
    @Resource
    HistoryService historyService;

    /**
     * 处理聊天请求
     *
     * @param prompt 聊天提示词
     * @param chatId 聊天会话ID
     * @return 聊天响应的流式数据
     */
    @PostMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(@RequestParam("prompt") String prompt,
                             @RequestParam("chatId") String chatId,
                             @RequestParam(value = "files", required = false) List<MultipartFile> files) {
        // 保存历史会话id
        historyService.saveIds("chat", chatId);
//        log.info("type{},id{}", "chat", chatId);
        // 调用聊天服务处理请求并返回流式响应
        if (files != null && !files.isEmpty()) {
            return chatService.chatMulti(prompt, chatId, files);
        }
        return chatService.chatText(prompt, chatId);
    }
}