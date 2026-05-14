package com.heima.service;

import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ChatService {
    Flux<String> chatText(String prompt, String chatId);

    Flux<String> chatMulti(String prompt, String chatId, List<MultipartFile> files);

}
