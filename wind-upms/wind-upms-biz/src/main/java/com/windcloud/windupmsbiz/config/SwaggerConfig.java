package com.windcloud.windupmsbiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * file:SwaggerConfig.java
 * created by Fanghonghui on 2019/7/19
 * email:a6551142@163.com
 */
@Configuration
public class SwaggerConfig {
    /**
     * 创建swagger ui的摘要
     *
     * @return
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 扫描的class的包路径
                .apis(RequestHandlerSelectors.basePackage("com.windcloud.windupmsbiz"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * swagger ui的标题信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("标题")
                .description("副标题")
                .version("1.0")
                .build();
    }

}
