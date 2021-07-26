package com.course.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.course.Controller"))	// 为当前包路径
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("FH Admin Swagger3 RESTful API") 	// 页面标题
				.version("3.0")								// 版本号
                .contact(new Contact("lanhanhua","","278065822@qq.com"))
				.description("www.baidu.com")				    // 描述
				.build();

    }

}
