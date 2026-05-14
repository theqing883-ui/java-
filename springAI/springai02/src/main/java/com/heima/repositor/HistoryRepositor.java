package com.heima.repositor;

import com.heima.entity.VO.MessageVO;

import java.util.List;

public interface HistoryRepositor {
    void saveIds(String type, String chatIds);

    List<String> getIds(String type);

    List<MessageVO> getHistory(String chatId, String type);
}
