package com.heima.repositor.impl;

import com.heima.entity.VO.MessageVO;
import com.heima.repositor.HistoryRepositor;
import com.heima.repositor.RedisChatMemory;
import com.heima.repositor.RedisPDFMemory;
import com.heima.repositor.RedisServiceMemory;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.Message;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.heima.tool.Constants.*;

/**
 * 历史记录仓库实现类
 * 实现HistoryRepositor接口，使用Redis存储和管理历史记录
 */
@Slf4j
@Repository
public class HistoryRepositorImpl implements HistoryRepositor {
    
    /**
     * Redis字符串模板
     * 用于操作Redis中的字符串数据
     */
    @Resource
    StringRedisTemplate stringRedisTemplate;
    
    /**
     * Redis聊天记忆
     * 用于存储聊天历史记录
     */
    @Resource
    RedisChatMemory redisChatMemory;
    
    /**
     * Redis服务记忆
     * 用于存储服务历史记录
     */
    @Resource
    RedisServiceMemory redisServiceMemory;
    
    /**
     * Redis PDF记忆
     * 用于存储PDF聊天历史记录
     */
    @Resource
    RedisPDFMemory redisPDFMemory;

    /**
     * 保存聊天ID到Redis
     * @param type 历史记录类型
     * @param chatId 聊天会话ID
     */
    @Override
    public void saveIds(String type, String chatId) {
        String key = CHAT_IDS_KEY;
        if ("chat".equals(type)) {
            key = CHAT_IDS_KEY;
        } else if ("service".equals(type)) {
            key = SERVICE_IDS_KEY;
        } else if ("pdf".equals(type)) {
            key = PDF_IDS_KEY;
        }
//        log.info("类型{}，id{}", type, chatId);
        // 将聊天ID添加到Redis列表的左侧
        stringRedisTemplate.opsForList().leftPush(key + type, chatId);
        // 设置过期时间为1分钟
        stringRedisTemplate.expire(key + type, 1L, TimeUnit.MINUTES);
    }

    /**
     * 从Redis获取聊天ID列表
     * @param type 历史记录类型
     * @return 聊天ID列表
     */
    @Override
    public List<String> getIds(String type) {
        String key = CHAT_IDS_KEY;
        if ("chat".equals(type)) {
            key = CHAT_IDS_KEY;
        } else if ("service".equals(type)) {
            key = SERVICE_IDS_KEY;
        }
        // 从Redis列表中获取所有元素
        return stringRedisTemplate.opsForList().range(key + type, 0, -1);
    }

    /**
     * 获取指定聊天ID的历史消息
     * @param chatId 聊天会话ID
     * @param type 历史记录类型
     * @return 历史消息列表
     */
    @Override
    public List<MessageVO> getHistory(String chatId, String type) {
        if ("chat".equals(type)) {
            return getMessageVOS(redisChatMemory.get(chatId));
        } else if ("service".equals(type)) {
            return getMessageVOS(redisServiceMemory.get(chatId));
        } else if ("pdf".equals(type)) {
            return getMessageVOS(redisPDFMemory.get(chatId));
        }
        // 默认返回聊天历史记录
        return getMessageVOS(redisChatMemory.get(chatId));
    }

    /**
     * 将Message对象列表转换为MessageVO对象列表
     * @param messages Message对象列表
     * @return MessageVO对象列表
     */
    private List<MessageVO> getMessageVOS(List<Message> messages) {
        List<MessageVO> messageVOs = new ArrayList<>();
        for (Message message : messages) {
            MessageVO vo = new MessageVO(message);
            messageVOs.add(vo);
        }
        return messageVOs;
    }
}