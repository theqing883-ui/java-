package com.heima.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC配置类，实现WebMvcConfigurer接口
 * 主要用于配置跨域资源共享(CORS)设置
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {

    /**
     * 配置跨域资源共享(CORS)映射
     *
     * @param registry CORS注册表，用于添加跨域映射规则
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加跨域映射规则，允许所有路径
        registry.addMapping("/**")
                // 允许所有来源的请求
                .allowedOrigins("*")
                // 允许的HTTP方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 允许所有请求头
                .allowedHeaders("*")
                .exposedHeaders("Content-Disposition");

    }
}