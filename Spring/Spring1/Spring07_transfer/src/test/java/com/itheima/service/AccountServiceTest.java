package com.itheima.service;

import com.itheima.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    public AccountService accountService;

    @Test
    public void serviceTransferTest() {
        accountService.transfer("Jerry","Tom",100);
    }

}
