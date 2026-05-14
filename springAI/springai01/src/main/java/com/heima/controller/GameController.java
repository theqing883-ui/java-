package com.heima.controller;

import com.heima.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("/game")
    public Flux<String> game(@RequestParam("prompt") String msg, @RequestParam("chatId") String chatId) {

        return gameService.game(msg, chatId);
    }
}
