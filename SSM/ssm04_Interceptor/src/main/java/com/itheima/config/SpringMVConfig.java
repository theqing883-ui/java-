package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.itheima.controller","com.itheima.config"})
//扫描controller，得到bean里面有前端访问的方法
//扫描config 得到SpringMVCSupport的bean
@EnableWebMvc//开启json类型的解读等
public class SpringMVConfig {
}
