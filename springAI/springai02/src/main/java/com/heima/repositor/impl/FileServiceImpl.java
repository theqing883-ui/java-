package com.heima.repositor.impl;

import com.heima.repositor.IFileService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

@RequiredArgsConstructor
@Repository
@Slf4j
public class FileServiceImpl implements IFileService {

    private final VectorStore vectorStore;
    private final TokenTextSplitter textSplitter;

    // 会话id 与 文件名的对应关系
    private final Properties chatFiles = new Properties();
    private final String PROPS_FILE_NAME = "chat-pdf.properties";

    @Override
    public boolean save(String chatId, Resource resource) {
        String originalFilename = resource.getFilename();
        if (originalFilename == null) {
            log.error("The uploaded resource has no filename.");
            return false;
        }

        // 修复点 3：拼接 chatId 防止不同用户上传同名文件导致互相覆盖
        String safeFilename = chatId + "_" + originalFilename;
        File target = new File(safeFilename);

        if (!target.exists()) {
            // 修复点 1：使用 try-with-resources 确保输入流被关闭
            try (InputStream in = resource.getInputStream()) {
                Files.copy(in, target.toPath());
                log.info("File saved to local disk: {}", target.getAbsolutePath());
            } catch (IOException e) {
                log.error("Failed to save PDF resource.", e);
                return false;
            }
        }

        // 2.保存映射关系
        chatFiles.put(chatId, safeFilename);

        // 3.写入向量库 
        // 修复点 2：不要传入原始的 resource（流可能被消费完了），传入本地刚存好的 file
        writeToVectorStore(new FileSystemResource(target), chatId);
        return true;
    }

    @Override
    public Resource getFile(String chatId) {
        String filename = chatFiles.getProperty(chatId);
        // 修复点 5：防止查不到文件时抛出空指针异常
        if (filename == null) {
            log.warn("No file found for chat id: {}", chatId);
            return null; // 或者抛出你自定义的业务异常
        }
        return new FileSystemResource(filename);
    }

    @PostConstruct
    private void init() {
        File file = new File(PROPS_FILE_NAME);
        if (file.exists()) {
            // 修复点 1：使用 try-with-resources 确保 BufferedReader 安全关闭
            try (Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
                chatFiles.load(reader);
                log.info("Loaded {} chat file records.", chatFiles.size());
            } catch (IOException e) {
                log.error("Failed to load chat-pdf properties.", e);
            }
        }
    }

    @PreDestroy
    private void persistent() {
        // 修复点 1：使用 try-with-resources 确保流刷入磁盘并关闭，否则文件可能为空
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(PROPS_FILE_NAME), StandardCharsets.UTF_8)) {
            chatFiles.store(writer, "Saved at " + LocalDateTime.now());
            log.info("Chat file records persistently saved.");
        } catch (IOException e) {
            log.error("Failed to save chat-pdf properties.", e);
        }
    }

    private void writeToVectorStore(Resource localResource, String chatId) {
        // 1.创建PDF的读取器
        PagePdfDocumentReader reader = new PagePdfDocumentReader(
                localResource, // 使用本地文件源
                PdfDocumentReaderConfig.builder()
                        .withPageExtractedTextFormatter(ExtractedTextFormatter.defaults())
                        .withPagesPerDocument(1)
                        .build()
        );

        // 2.读取PDF文档
        List<Document> documents = reader.read();
        documents.forEach(document -> document.getMetadata().put("chat_id", chatId));

        // 修复点 4：一定要进行文本切分，否则单页内容过大，转向量会失败或降低准确率
        List<Document> splitDocuments = textSplitter.apply(documents);

        // 3.写入向量库
        vectorStore.add(splitDocuments);
        log.info("Successfully vectorized and added {} chunks for chat {}", splitDocuments.size(), chatId);
    }
}