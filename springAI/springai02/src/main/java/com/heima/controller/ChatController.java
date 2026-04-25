package com.heima.controller;

import com.heima.service.ChatService;
import com.heima.service.HistoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
@Slf4j
public class ChatController {
    @Resource
    ChatService chatService;
    @Resource
    HistoryService historyService;

    @PostMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(@RequestParam("prompt") String prompt,
                             @RequestParam("chatId") String chatId) {
        // 保存历史会话id
        historyService.saveIds("chat", chatId);
//        log.info("type{},id{}", "chat", chatId);
        return chatService.chat(prompt, chatId);
    }
}
