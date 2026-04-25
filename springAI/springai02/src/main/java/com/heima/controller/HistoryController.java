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
    @Resource
    HistoryService historyService;

    @GetMapping("/history/{type}")
    public List<String> getIds(@PathVariable("type") String type) {
//        log.info("type{}", type);
        return historyService.getIds(type);
    }

    @GetMapping("/history/{type}/{chatId}")
    public List<MessageVO> getHistory(@PathVariable("chatId") String chatId, @PathVariable("type") String type) {
//        log.info("chatId{}", chatId);
        return historyService.getHistory(chatId,type);
    }
}
