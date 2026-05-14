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

/**
 * PDF文件控制器
 * 处理PDF文件上传、下载和聊天相关的HTTP请求
 */
@RestController
@RequestMapping("/ai/pdf")
public class FilePDFController {
    
    /**
     * PDF文件服务
     * 用于处理PDF文件相关的业务逻辑
     */
    @Autowired
    FilePDFService filePDFService;
    
    /**
     * 历史记录服务
     * 用于管理聊天历史记录
     */
    @Autowired
    HistoryService historyService;

    /**
     * 处理PDF聊天请求
     * @param prompt 聊天提示词
     * @param chatId 聊天会话ID
     * @return 聊天响应的流式数据
     */
    @GetMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(@RequestParam("prompt") String prompt,
                             @RequestParam("chatId") String chatId) {
        // 保存历史会话id
        historyService.saveIds("pdf", chatId);
//        log.info("type{},id{}", "chat", chatId);
        // 调用PDF服务处理聊天请求并返回流式响应
        return filePDFService.chat(prompt, chatId);
    }

    /**
     * 上传PDF文件
     * @param chatId 聊天会话ID
     * @param fil 要上传的PDF文件
     * @return 上传结果
     */
    @PostMapping("/upload/{chatId}")
    public Result uploadPDF(@PathVariable("chatId") String chatId, @RequestParam("file") MultipartFile fil) {
        // 调用PDF服务上传文件
        return filePDFService.uploadPdf(chatId, fil);
    }

    /**
     * 下载PDF文件
     * @param chatId 聊天会话ID
     * @return 包含PDF文件的响应实体
     * @throws IOException IO异常
     */
    @GetMapping("/file/{chatId}")
    public ResponseEntity<Resource> download(@PathVariable("chatId") String chatId) throws IOException {
        // 调用PDF服务下载文件
        return filePDFService.download(chatId);
    }
}