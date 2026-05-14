package com.hmdp.controller;

import com.hmdp.service.aiservice.AiChatService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping(value = "/chat", produces = "text/html;charset=utf-8")
public class AiChatController {
    @Resource
    AiChatService aiChatService;

    @GetMapping
    public Flux<String> chat(@RequestParam("message") String message,
                             @RequestParam("memoryId") String memoryId) {
        // 1. 严格校验参数
        if (message == null || message.trim().isEmpty()) {
            return Flux.error(new IllegalArgumentException("消息内容不能为空"));
        }
        if (memoryId == null || memoryId.trim().isEmpty()) {
            return Flux.error(new IllegalArgumentException("memoryId 不能为空"));
        }
        return aiChatService.chat(memoryId, message);
    }
}
