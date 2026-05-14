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

@Slf4j
@Repository
public class HistoryRepositorImpl implements HistoryRepositor {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    RedisChatMemory redisChatMemory;
    @Resource
    RedisServiceMemory redisServiceMemory;
    @Resource
    RedisPDFMemory redisPDFMemory;

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
        stringRedisTemplate.opsForList().leftPush(key + type, chatId);
        stringRedisTemplate.expire(key + type, 1L, TimeUnit.MINUTES);
    }

    @Override
    public List<String> getIds(String type) {
        String key = CHAT_IDS_KEY;
        if ("chat".equals(type)) {
            key = CHAT_IDS_KEY;
        } else if ("service".equals(type)) {
            key = SERVICE_IDS_KEY;
        }
        return stringRedisTemplate.opsForList().range(key + type, 0, -1);
    }

    @Override
    public List<MessageVO> getHistory(String chatId, String type) {
        if ("chat".equals(type)) {
            return getMessageVOS(redisChatMemory.get(chatId, Integer.MAX_VALUE));
        } else if ("service".equals(type)) {
            return getMessageVOS(redisServiceMemory.get(chatId, Integer.MAX_VALUE));
        } else if ("pdf".equals(type)) {
            return getMessageVOS(redisPDFMemory.get(chatId, Integer.MAX_VALUE));
        }
        return getMessageVOS(redisChatMemory.get(chatId, Integer.MAX_VALUE));
    }

    private List<MessageVO> getMessageVOS(List<Message> messages) {
        List<MessageVO> messageVOs = new ArrayList<>();
        for (Message message : messages) {
            MessageVO vo = new MessageVO(message);
            messageVOs.add(vo);
        }
        return messageVOs;
    }
}
