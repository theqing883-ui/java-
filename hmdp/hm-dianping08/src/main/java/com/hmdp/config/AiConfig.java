package com.hmdp.config;

import com.hmdp.repository.RedisChatMemoryStore;
import dev.langchain4j.community.store.embedding.redis.RedisEmbeddingStore;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentSplitter;
import dev.langchain4j.data.document.loader.ClassPathDocumentLoader;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AiConfig {
    @Resource
    RedisEmbeddingStore redisEmbeddingStore;
    @Autowired
    private RedisChatMemoryStore redisChatMemoryStore;
    @Resource
    private EmbeddingModel embeddingModel;

    // 构建ChatMemoryProvider 对象
    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        ChatMemoryProvider chatMemoryProvider = new ChatMemoryProvider() {
            @Override
            public ChatMemory get(Object memoryId) {
                return MessageWindowChatMemory.builder()
                        .id(memoryId)
                        .maxMessages(20)
                        .chatMemoryStore(redisChatMemoryStore)
                        .build();
            }
        };
        return chatMemoryProvider;
    }

//    @Bean//把这个当知识库的都已经向量化完成后，而且是外部持久化，就可以把这个Bean注释调，需要再次加载，向量化等操作。
    public EmbeddingStore store() {
        // 1. 从类路径（resources）下的 "context" 目录加载所有文档
        List<Document> documents = ClassPathDocumentLoader.loadDocuments("context");

        // 2. 构建文本分割器
        DocumentSplitter splitter = DocumentSplitters.recursive(500, 100);
        /*内存版本的向量数据库*/
//        InMemoryEmbeddingStore<TextSegment> store = new InMemoryEmbeddingStore<>();

        // 3. 构建一个“数据摄取器” (Ingestor)
        // 它负责：切分文档 -> 调用 Embedding Model 转换成向量 -> 存入 store
        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
                .documentSplitter(splitter)
                .embeddingStore(redisEmbeddingStore)
                .embeddingModel(embeddingModel)// 向量化模型
                .build();

        // 4. 执行摄取操作：将加载的 documents 处理并存入向量库
        ingestor.ingest(documents);
        // 5. 返回配置好的向量库，供后续检索使用
        return redisEmbeddingStore;
    }

    @Bean
    public ContentRetriever contentRetriever(/*EmbeddingStore store*/) {
        return EmbeddingStoreContentRetriever.builder()
                .embeddingStore(redisEmbeddingStore)      // 指定要查哪一个向量库
                .minScore(0.5)              // 相似度阈值：只有相似度大于 0.5 的内容才会被采纳（过滤掉无关信息）
                .maxResults(3)              // 每次查询最多返回前 3 条最相关的片段
                .embeddingModel(embeddingModel)//向量化模型
                .build();
    }
}
