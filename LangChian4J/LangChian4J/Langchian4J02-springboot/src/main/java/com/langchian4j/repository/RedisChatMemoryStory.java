package com.langchian4j.repository;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
/**
 * 基于 Redis 的聊天记忆存储实现
 * 用于持久化和管理聊天会话的历史消息
 */
public class RedisChatMemoryStory implements ChatMemoryStore {

    /**
     * Redis 键的前缀，用于区分不同的聊天记忆
     */
    private static final String KEY_PREFIX = "chat:memory:";

    /**
     * Redis 字符串操作模板，用于与 Redis 进行交互
     */
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据记忆 ID 获取聊天消息列表
     *
     * @param memoryId 记忆的唯一标识符
     * @return 聊天消息列表，如果不存在则返回空列表或 null
     */
    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        String json = stringRedisTemplate.opsForValue().get(KEY_PREFIX + memoryId);
        return ChatMessageDeserializer.messagesFromJson(json);
    }

    /**
     * 更新指定记忆 ID 的聊天消息列表
     *
     * @param memoryId 记忆的唯一标识符
     * @param list     要保存的聊天消息列表
     */
    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {
        String json = ChatMessageSerializer.messagesToJson(list);
        stringRedisTemplate.opsForValue().set(KEY_PREFIX + memoryId, json,1L, TimeUnit.DAYS);
    }

    /**
     * 删除指定记忆 ID 的聊天消息
     *
     * @param memoryId 记忆的唯一标识符
     */
    @Override
    public void deleteMessages(Object memoryId) {
        stringRedisTemplate.delete(KEY_PREFIX + memoryId);
    }
}
