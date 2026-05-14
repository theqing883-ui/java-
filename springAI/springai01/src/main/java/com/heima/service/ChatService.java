package com.heima.service;

import com.heima.entity.VO.MessageVO;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ChatService {
    Flux<String> chat(String msg, String chatId);

}
