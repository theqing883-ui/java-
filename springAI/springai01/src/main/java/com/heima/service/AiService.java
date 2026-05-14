package com.heima.service;

import com.heima.entity.VO.MessageVO;
import reactor.core.publisher.Flux;

import java.util.List;

public interface AiService {
    Flux<String> service(String msg, String chatId);

}
