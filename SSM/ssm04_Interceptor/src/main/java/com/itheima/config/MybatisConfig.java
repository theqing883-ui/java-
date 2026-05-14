package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    /**
     * 指定操作数据源和类型别名包（domain 实体类）
     * @param dataSource 数据源
     * @return sqlSessionFactoryBean
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.itheima.domain");
        return sqlSessionFactoryBean;
    }

    /**
     * 配置 Mapper 扫描器
     * - 扫描指定包下的 Mapper 接口
     * - 自动注册为 Spring Bean，无需手动配置
     */
    @Bean//指定Mapping映射的dao类,里面包含操作数据库的SQl方法
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.itheima.dao");
        return mapperScannerConfigurer;
    }
}
