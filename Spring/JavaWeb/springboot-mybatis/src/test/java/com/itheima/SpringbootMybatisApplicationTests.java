package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        List<Account> all = userMapper.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

}
