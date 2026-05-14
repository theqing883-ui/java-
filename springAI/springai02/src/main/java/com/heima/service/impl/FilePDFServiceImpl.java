package com.heima.service.impl;

import com.heima.entity.VO.Result;
import com.heima.repositor.IFileService;
import com.heima.service.FilePDFService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * PDF文件服务实现类
 * 实现FilePDFService接口，处理PDF文件上传、下载和聊天相关的业务逻辑
 */
@Service
@Slf4j
public class FilePDFServiceImpl implements FilePDFService {
    
    /**
     * 文件服务
     * 用于处理文件的保存和读取操作
     */
    @Autowired
    IFileService fileService;
    
    /**
     * RAG聊天客户端
     * 用于处理基于PDF内容的聊天请求
     */
    @Autowired
    ChatClient ragChatClient;

    /**
     * 上传PDF文件
     * @param chatId 聊天会话ID
     * @param file 要上传的PDF文件
     * @return 上传结果
     */
    @Override
    public Result uploadPdf(String chatId, MultipartFile file) {
        try {
            // 1. 校验文件是否为PDF格式
            if (!Objects.equals(file.getContentType(), "application/pdf")) {
                return Result.fail("只能上传PDF文件！");
            }
            // 2.保存文件
            boolean success = fileService.save(chatId, file.getResource());
            if (!success) {
                return Result.fail("保存文件失败！");
            }
            return Result.ok();
        } catch (Exception e) {
            log.error("Failed to upload PDF.", e);
            return Result.fail("上传文件失败！");
        }
    }

    /**
     * 下载PDF文件
     * @param chatId 聊天会话ID
     * @return 包含PDF文件的响应实体
     */
    @Override
    public ResponseEntity<Resource> download(String chatId) {
        // 1.读取文件
        Resource resource = fileService.getFile(chatId);
        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }
        // 2.文件名编码，写入响应头
        String filename = URLEncoder.encode(Objects.requireNonNull(resource.getFilename()), StandardCharsets.UTF_8);
        // 3.返回文件
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }

    /**
     * 处理PDF聊天请求
     * @param msg 聊天提示词
     * @param chatId 聊天会话ID
     * @return 聊天响应的流式数据
     */
    @Override
    public Flux<String> chat(String msg, String chatId) {
        // 检查提示词是否为空
        if (msg == null || msg.isEmpty()) {
            return Flux.just("错误：提问内容不能为空");
        }
        System.out.println("-----当前查询ID------: " + chatId);
        // 使用ragChatClient处理请求
        return ragChatClient
                .prompt(msg) // 设置提示词
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId)) // 设置会话ID
//                .advisors(a -> a.param(QuestionAnswerAdvisor.FILTER_EXPRESSION, "chat_id.keyword == '" + chatId + "'"))
//                .advisors(a -> a.param(QuestionAnswerAdvisor.FILTER_EXPRESSION, "chat_id == '" + chatId + "'"))
                .stream() // 流式调用
                .content(); // 返回内容
    }
}