package com.heima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.heima.mapper")
public class Springai02Application {

    public static void main(String[] args) {
        SpringApplication.run(Springai02Application.class, args);
    }

}
