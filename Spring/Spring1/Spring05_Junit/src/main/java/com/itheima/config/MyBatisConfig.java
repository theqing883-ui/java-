package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Spring 整合 MyBatis 的 Java 配置类
 * 替代传统的 mybatis-config.xml 和 Spring 的 XML 配置
 */
public class MyBatisConfig {

    /**
     * 创建 SqlSessionFactoryBean，用于产生 SqlSessionFactory 对象
     * SqlSessionFactory 是 MyBatis 的核心对象，负责创建 SqlSession（数据库会话）
     *
     * @param dataSource 数据源（由 Spring 容器注入，例如 DruidDataSource）
     * @return SqlSessionFactoryBean 实例，Spring 会调用其 getObject() 获取真正的 SqlSessionFactory
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();

        // 设置类型别名包：扫描 com.itheima.domain 包，为其中的实体类自动注册别名（默认类名首字母小写）
        ssfb.setTypeAliasesPackage("com.itheima.domain");

        // 设置数据源，MyBatis 将通过此数据源获取数据库连接
        ssfb.setDataSource(dataSource);

        return ssfb;
    }

    /**
     * 创建 MapperScannerConfigurer，用于扫描指定包下的 Mapper 接口
     * 将接口动态代理成 Spring Bean 并注册到容器中，这样可以直接通过 @Autowired 注入使用
     *
     * @return MapperScannerConfigurer 实例
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();

        // 设置 Mapper 接口所在的包路径，扫描 com.itheima.dao 包下的所有接口
        // 这些接口会被自动代理并注册为 Spring Bean（无需在每个接口上添加 @Mapper 注解，但通常习惯加上）
        msc.setBasePackage("com.itheima.dao");

        return msc;
    }
}