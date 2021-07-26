package com.course.demo1.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@EnableOpenApi开启SWAGGER3.0
@EnableOpenApi
public class Swagger3Config implements WebMvcConfigurer {
    @Bean
        //同Swagger2相似,主要是配置一个Docket
    Docket docket(){
        //DocumentationType.OAS_30,原Swagger2选择DocumentationType.SWAGGER_2
        return new Docket(DocumentationType.OAS_30)
                .select()
                //通过apis方法配置要扫描的controller的位置
                .apis(RequestHandlerSelectors.basePackage("com.course.demo1.controller"))
                //通过paths方法配置路径
                .paths(PathSelectors.any())
                //设置需要排除的路径(如果需要)
                //.paths(Predicate.not(PathSelectors.regex("/error.*")))
                .build().apiInfo(new ApiInfoBuilder()
                        //设置文档标题
                        .description("Swagger3测试API接口文档")
                        //设置联系人信息
                        .contact(new Contact("lanhanhua","https://www.csdn.net","lanhh@hyxt.com"))
                        //设置版本号
                        .version("1.1")
                        //设置文档抬头
                        .title("API测试文档")
                        //设置授权
                        .license("License By lulu")
                        //设置授权访问网址
                        .licenseUrl("https://swagger.io")
                        .build());
    }
    @Override
    //swagger-ui/index.html在META-INF/resources下面,添加资源映射确保URL能够访问
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }

}