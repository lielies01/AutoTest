package com.course.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.oas.annotations.EnableOpenApi;

import javax.annotation.PreDestroy;

@EnableOpenApi
@MapperScan(basePackages = {"com.course.demo"})   //扫描包下的类
@SpringBootApplication  //(exclude= {DataSourceAutoConfiguration.class})
@EnableScheduling

public class Swagger3DemoApplication {

    private  static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Swagger3DemoApplication.context = SpringApplication.run(Swagger3DemoApplication.class,args);
    }

    @PreDestroy
    public void close(){
        Swagger3DemoApplication.context.close();
    }

}