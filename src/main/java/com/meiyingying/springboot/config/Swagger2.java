package com.meiyingying.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                去哪儿扫描API文档
                .apis(RequestHandlerSelectors.basePackage("com.meiyingying.springboot"))
//                哪些接口对外开放
                .paths(PathSelectors.regex("/rest/.*"))
                .build();
    }
    public ApiInfo apiInfo(){
//        Info的描述
        return new ApiInfoBuilder()
                .title("SpringBoot利用Swagger构建API文档")
                .description("简单优雅构建文档")
                .termsOfServiceUrl("http://meiyingying.com")
                .version("1.0")
                .build();
    }
}
