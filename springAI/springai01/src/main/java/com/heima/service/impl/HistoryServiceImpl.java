package com.heima.service.impl;

import com.heima.entity.VO.MessageVO;
import com.heima.repositor.HistoryRepositor;
import com.heima.service.HistoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Resource
    private HistoryRepositor historyRepositor;

    @Override
    public List<String> getIds(String chatId) {
        return historyRepositor.getIds(chatId);
    }

    @Override
    public void saveIds(String type, String chatId) {

        historyRepositor.saveIds(type, chatId);
    }

    @Override
    public List<MessageVO> getHistory(String chatId,String type) {
        return historyRepositor.getHistory(chatId,type);
    }
}
