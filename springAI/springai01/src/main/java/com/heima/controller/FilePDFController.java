package com.heima.controller;

import com.heima.entity.VO.Result;
import com.heima.service.FilePDFService;
import com.heima.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RestController
@RequestMapping("/ai/pdf")
public class FilePDFController {
    @Autowired
    FilePDFService filePDFService;
    @Autowired
    HistoryService historyService;

    @GetMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(@RequestParam("prompt") String prompt,
                             @RequestParam("chatId") String chatId) {
        // 保存历史会话id
        historyService.saveIds("pdf", chatId);
//        log.info("type{},id{}", "chat", chatId);
        return filePDFService.chat(prompt, chatId);
    }

    @PostMapping("/upload/{chatId}")
    public Result uploadPDF(@PathVariable("chatId") String chatId, @RequestParam("file") MultipartFile fil) {
        return filePDFService.uploadPdf(chatId, fil);
    }

    @GetMapping("/file/{chatId}")
    public ResponseEntity<Resource> download(@PathVariable("chatId") String chatId) throws IOException {
        return filePDFService.download(chatId);
    }
}
