package com.langchian4j.controller;

import com.langchian4j.aiservice.ConsultantService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/chat", produces = "text/html;charset=utf-8")
public class ChatController {
    @Resource
    ConsultantService consultantService;

    @GetMapping
    public Flux<String> chatAi(@RequestParam("message") String message,
                               @RequestParam("memoryId") String memoryId) {
        return consultantService.chat(message, memoryId);
    }
   /* @GetMapping// 阻塞式
    public String chatAi(@RequestParam("message") String message) {
        return consultantService.chat(message);
    }*/

    /*@Resource
    OpenAiChatModel openAiChatModel;
    @GetMapping
    public String chatAi(@RequestParam("context") String context) {
        return openAiChatModel.chat(context);
    }*/
}
