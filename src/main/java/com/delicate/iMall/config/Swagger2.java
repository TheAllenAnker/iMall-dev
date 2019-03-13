package com.delicate.iMall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.management.modelmbean.RequiredModelMBean;

@Configuration
@EnableSwagger2
public class Swagger2 {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("iMall's RESTful Documentation with Swagger2")
                .contact(new Contact("Allen Anker",
                        "https://github.com/TheAllenAnker", "linyuhang1999scu@gmail.com"))
                .description("RESTful API Documentation for iMall")
                .version("2.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.delicate.iMall.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
