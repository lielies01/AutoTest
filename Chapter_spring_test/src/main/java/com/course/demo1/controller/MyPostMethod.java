package com.course.demo1.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(tags = "这是我的全部Post请求")
@RequestMapping("/v1")
public class MyPostMethod {

   //这个变量装载Cookies信息
   private static Cookie cookie;

   /**
    *  用户登录成功获取到cookies，然后再访问其他接口
    */



   @ApiOperation(value = "登录接口,登录成功后获取cookies信息",httpMethod = "POST")
   @RequestMapping(value = "/login",method = RequestMethod.POST)
   public String login(HttpServletResponse response,
                       @RequestParam(value = "username",required = true ) String username,
                       @RequestParam(value = "password",required = true) String password){
      if (username.equals("lanhanhua") && password.equals("123456")){

         cookie = new Cookie("login","true");
         response.addCookie(cookie);

         return "恭喜你登录成功";
      }
      return "用户名或者密码错误";



   }



}
