package com.heima.repositor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.heima.tool.Constants.GAME_MEMORY_KEY;

@Repository
public class RedisGameMemory implements ChatMemory {

    private StringRedisTemplate redisTemplate;
    private ObjectMapper objectMapper;

    public RedisGameMemory(StringRedisTemplate redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    /**
     * 添加消息到指定会话的聊天记忆
     *
     * @param sessionId 会话ID，用于唯一标识一个聊天会话
     * @param messages  要添加的消息列表
     */
    @Override
    public void add(String sessionId, List<Message> messages) {
        try {
            // 获取现有消息
            List<Message> existingMessages = this.get(sessionId);

            // 添加新消息
            existingMessages.addAll(messages);

            // 限制消息数量，最多保留50条
            if (existingMessages.size() > 50) {
                existingMessages = existingMessages.subList(existingMessages.size() - 50, existingMessages.size());
            }

            // 序列化消息列表
            String updatedJson = objectMapper.writeValueAsString(existingMessages);

            // 存储到Redis，设置1小时过期时间
            redisTemplate.opsForValue().set(GAME_MEMORY_KEY + sessionId, updatedJson, 1L, TimeUnit.HOURS);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize messages", e);
        }
    }

    /**
     * 获取指定会话的聊天消息
     *
     * @param sessionId 会话ID，用于唯一标识一个聊天会话
     * @return 消息列表，包含该会话的所有历史消息
     */
    @Override
    public List<Message> get(String sessionId) {
        try {
            // 从Redis获取消息
            String jsonMessages = redisTemplate.opsForValue().get(GAME_MEMORY_KEY + sessionId);

            // 如果没有消息，返回空列表
            if (jsonMessages == null || jsonMessages.trim().isEmpty()) {
                return new ArrayList<>();
            }

            // 解析JSON数据
            JsonNode jsonArray = objectMapper.readTree(jsonMessages);
            List<Message> resultMessages = new ArrayList<>();

            // 遍历解析每个消息
            for (JsonNode jsonObj : jsonArray) {
                // 安全地获取消息类型
                String type = jsonObj.has("messageType") ? jsonObj.get("messageType").asText() : "";

                // 兼容处理：获取消息内容（支持content和text字段）
                String content = "";
                if (jsonObj.has("content")) {
                    content = jsonObj.get("content").asText();
                } else if (jsonObj.has("text")) {
                    content = jsonObj.get("text").asText();
                }

                // 根据消息类型创建对应的消息对象
                if ("USER".equalsIgnoreCase(type)) {
                    resultMessages.add(new UserMessage(content));
                } else if ("ASSISTANT".equalsIgnoreCase(type)) {
                    resultMessages.add(new AssistantMessage(content));
                } else if ("SYSTEM".equalsIgnoreCase(type)) {
                    resultMessages.add(new SystemMessage(content));
                }
            }

            return resultMessages;
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize messages", e);
        }
    }

    /**
     * 清空指定会话的聊天记忆
     *
     * @param sessionId 会话ID，用于唯一标识一个聊天会话
     */
    @Override
    public void clear(String sessionId) {
        // 从Redis删除指定会话的消息
        redisTemplate.delete(GAME_MEMORY_KEY + sessionId);
    }
}
