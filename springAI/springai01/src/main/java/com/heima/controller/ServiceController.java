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

@RestController
@RequestMapping("/ai")
@Slf4j
public class ServiceController {
    @Resource
    AiService aiService;
    @Resource
    HistoryService historyService;

    @GetMapping(value = "/service", produces = "text/html;charset=utf-8")
    public Flux<String> service(@RequestParam("prompt") String prompt,
                                @RequestParam("chatId") String chatId) {
        // 保存历史会话id
        historyService.saveIds("service", chatId);
        return aiService.service(prompt, chatId);
    }
}
