package com.windcloud.windupmsbiz.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * file:MybatisPlusConfig.java
 * created by Fanghonghui on 2019/7/18
 * email:a6551142@163.com
 */
@Configuration
@MapperScan("com.windcloud.windupmsbiz.mapper")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
