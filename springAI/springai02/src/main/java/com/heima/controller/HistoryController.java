package com.heima.controller;

import com.heima.entity.VO.MessageVO;
import com.heima.service.HistoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class HistoryController {
    /**
     * 历史记录服务
     * 用于处理历史记录相关的业务逻辑
     */
    @Resource
    HistoryService historyService;

    /**
     * 获取指定类型的的历史记录ID列表
     *
     * @param type 历史记录类型
     * @return 历史记录ID列表
     */
    @GetMapping("/history/{type}")
    public List<String> getIds(@PathVariable("type") String type) {
//        log.info("type{}", type);
        return historyService.getIds(type);
    }

    /**
     * 获取指定类型和聊天ID的历史消息
     *
     * @param chatId 聊天会话ID
     * @param type   历史记录类型
     * @return 历史消息列表
     */
    @GetMapping("/history/{type}/{chatId}")
    public List<MessageVO> getHistory(@PathVariable("chatId") String chatId, @PathVariable("type") String type) {
//        log.info("chatId{}", chatId);
        return historyService.getHistory(chatId, type);
    }
}
