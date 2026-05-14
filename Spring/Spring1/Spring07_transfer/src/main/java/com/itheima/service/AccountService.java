package com.itheima.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface AccountService {
    @Transactional
    void transfer(String from, String to, double money);
}
