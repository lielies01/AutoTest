package com.course.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.oas.annotations.EnableOpenApi;


@EnableOpenApi
@MapperScan(basePackages = {"com.course.demo"})   //扫描包下的类

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
//@ComponentScan("com.course.demo")  //  扫描包下的类



public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);


    }
}
