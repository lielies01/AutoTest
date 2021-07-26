package com.course.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@MapperScan(basePackages = {"com.course.demo"})   //扫描包下的类
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Swagger3DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Swagger3DemoApplication.class, args);
    }

}