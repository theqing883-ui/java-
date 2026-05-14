package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.itheima.controller")//扫描controller，得到bean里面有前端访问的方法
@EnableWebMvc//开启json解读等
public class SpringMVConfig {
}
