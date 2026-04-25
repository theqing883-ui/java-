package com.heima.service;

import com.heima.entity.VO.MessageVO;

import java.util.List;

public interface HistoryService {
    List<String> getIds(String type);
    void saveIds(String type, String chatIds);
    List<MessageVO> getHistory(String chatId,String type);
}
