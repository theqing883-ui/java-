package com.heima.service;

import reactor.core.publisher.Flux;

public interface GameService {
    Flux<String> game(String msg, String chatId);
}
