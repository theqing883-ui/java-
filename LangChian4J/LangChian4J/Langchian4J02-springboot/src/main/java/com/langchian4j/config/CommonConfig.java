package com.langchian4j.config;

import com.langchian4j.repository.RedisChatMemoryStory;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CommonConfig {
    @Resource
    RedisChatMemoryStory redisChatMemoryStory;
    @Resource
    EmbeddingModel embeddingModel;
    @Resource
    RedisEmbeddingStore redisEmbeddingStore;
    /*  @Autowired
      OpenAiChatModel model;
      @Bean
      public ConsultantService consultantService() {
          return AiServices.builder(ConsultantService.class)
                  .chatModel(model)
                  .build();
      }*/
    /*@Bean
    public ChatMemory chatMemory(){
        return MessageWindowChatMemory.builder()
                .maxMessages(20)
                .build();
    }*/

    /**
     * 创建聊天记忆提供者Bean，用于管理多用户的对话历史记忆
     * <p>
     * 该提供者支持基于记忆ID的多会话管理，每个会话独立维护一个消息窗口，
     * 最多保留20条历史消息，适用于多用户并发对话场景。
     * </p>
     *
     * @return ChatMemoryProvider 聊天记忆提供者实例，根据记忆ID提供独立的聊天记忆对象
     */
    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        ChatMemoryProvider chatMemoryProvider = new ChatMemoryProvider() {
            @Override
            public ChatMemory get(Object memoryId) {
                /*匿名内部类*/
                return MessageWindowChatMemory.builder()
                        .maxMessages(20)//最大回话数
                        .chatMemoryStore(redisChatMemoryStory)//会话持久化
                        .id(memoryId)//会话隔离
                        .build();
            }
        };
        return chatMemoryProvider;
    }


    @Bean//把这个当知识库的都已经向量化完成后，而且是外部持久化，就可以把这个Bean注释调，需要再次加载，向量化等操作。
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
                .embeddingModel(embeddingModel)// 向量化模型
                .embeddingStore(redisEmbeddingStore) // 向量数据库持久化Redis
                .build();

        // 4. 执行摄取操作：将加载的 documents 处理并存入向量库
        ingestor.ingest(documents);
        // 5. 返回配置好的向量库，供后续检索使用
        return redisEmbeddingStore;
    }
    /* *//**
     * 配置向量模型 Bean
     * 向量模型的作用是将“自然语言文本”转换为“数学向量（一串数字）”，
     * 这样计算机才能通过计算余弦相似度来查找相关的知识。
     *//*
    @Bean
    public EmbeddingModel embeddingModel() {
        // 使用本地 BGE 模型（Small 英文量化版）。
        // 优点：完全本地运行，不消耗 Token，启动即用。
        // 注意：该模型主要针对英文优化，处理中文百科时效果可能不如专用的中文模型。
        return new BgeSmallEnV15QuantizedEmbeddingModel();
    }

    */

    /**
     * 配置向量存储库 Bean
     * 这里完成了从“抓取网页”到“切分数据”再到“存储向量”的全过程。
     *//*
    @Bean
    public EmbeddingStore<TextSegment> store(EmbeddingModel embeddingModel) throws MalformedURLException {
        // 1. [数据获取] 使用 UrlDocumentLoader 抓取指定的网页内容
        // TextDocumentParser 会将 HTML 网页解析为纯文本 Document 对象
        Document document = UrlDocumentLoader.load(
                new URL("https://programmercarl.com/xunlian/damoxing.html"),
                new TextDocumentParser()
        );

        // 2. [存储媒介] 初始化一个内存向量库
        // 数据存储在 RAM 中，查询速度极快，但程序重启后数据会丢失（适合演示和开发调试）
        InMemoryEmbeddingStore<TextSegment> store = new InMemoryEmbeddingStore<>();

        // 3. [摄取流水线] 配置摄取器，它像是一个自动化加工厂
        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
                .embeddingStore(store)           // 告诉它成品存到哪
                .embeddingModel(embeddingModel) // 告诉它用哪个模型把文字转成向量

                // 4. [文档切分策略]
                // 重点：大模型有上下文长度限制。我们将长文按 500 字一段进行切分，
                // 并且每段之间有 50 字的重叠（防止一句话被从中间切断导致语义丢失）。
                .documentSplitter(DocumentSplitters.recursive(500, 50))
                .build();

        // 5. [执行加工] 开始执行：读取文档 -> 切分 -> 向量化 -> 存入库
        ingestor.ingest(document);

        return store;
    }*/


    /* 构建向量检索器：决定了 AI 查资料的‘严谨程度’和‘广度’ */
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
