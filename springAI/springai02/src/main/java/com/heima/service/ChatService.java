package com.heima.service;

import reactor.core.publisher.Flux;

public interface ChatService {
    Flux<String> chat(String msg, String chatId);

}
