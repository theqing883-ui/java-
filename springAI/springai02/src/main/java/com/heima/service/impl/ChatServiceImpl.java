package com.heima.service.impl;

import com.heima.service.ChatService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.content.Media;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.util.List;


/**
 * 聊天服务实现类
 * 实现ChatService接口，处理聊天相关的业务逻辑
 */
@Slf4j
@Service
public class ChatServiceImpl implements ChatService {

    /**
     * 聊天客户端
     * 用于处理聊天请求
     */
    @Resource
    private ChatClient chatClient;

    /**
     * 处理聊天请求
     *
     * @param prompt 聊天提示词
     * @param chatId 聊天会话ID
     * @return 聊天响应的流式数据
     */
    @Override
    public Flux<String> chatText(String prompt, String chatId) {
        // 检查提示词是否为空
        if (prompt == null || prompt.isEmpty()) {
            return Flux.just("错误：提问内容不能为空");
        }
        // 使用chatClient处理请求
        return chatClient.prompt()
                .user(prompt) // 设置用户提示词
                // 修改了这里：使用最新版 API 的常量
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, chatId)) // 设置会话ID
                .stream()      // 流式调用
                .content(); // 返回内容

    }

    @Override
    public Flux<String> chatMulti(String prompt, String chatId, List<MultipartFile> files) {


        //  只有文本的情况
        if (files == null || files.isEmpty()) {
            return chatText(prompt, chatId);
        }
        //  处理多媒体文件
        List<Media> medias = files.stream()
                .map(file -> {
                    String contentType = file.getContentType();
                    // 增强健壮性：如果获取不到 MimeType，默认给个 application/octet-stream 或跳过
                    MimeType mimeType = (contentType != null) ? MimeType.valueOf(contentType) : MimeTypeUtils.APPLICATION_OCTET_STREAM;
                    return new Media(mimeType, file.getResource());
                })
                .toList();
        // 使用chatClient处理请求
        return chatClient.prompt()
                .user(promptUserSpec -> promptUserSpec.text(prompt).media(medias.toArray(Media[]::new))) // 设置用户提示词
                // 修改了这里：使用最新版 API 的常量
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, chatId)) // 设置会话ID
                .stream()      // 流式调用
                .content(); // 返回内容
    }


}