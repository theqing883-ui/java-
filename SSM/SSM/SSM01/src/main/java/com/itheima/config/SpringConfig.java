package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.itheima.service"})//扫描bean
@PropertySource("classpath:jdbc.properties")//jdbc配置文文件
@Import({JdbcConfig.class,MybatisConfig.class})//导入其他配置类
@EnableTransactionManagement//事务管理
public class SpringConfig {
}
