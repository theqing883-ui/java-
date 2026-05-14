package com.heima.service;

import com.heima.entity.VO.Result;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

public interface FilePDFService {
    Result uploadPdf(String chatId, MultipartFile file);
    ResponseEntity<Resource> download(String chatId);
    Flux<String> chat(String msg, String chatId);
}
