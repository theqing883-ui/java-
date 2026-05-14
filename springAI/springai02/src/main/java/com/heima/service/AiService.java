package com.heima.service;

import reactor.core.publisher.Flux;

public interface AiService {
    Flux<String> service(String msg, String chatId);

}
