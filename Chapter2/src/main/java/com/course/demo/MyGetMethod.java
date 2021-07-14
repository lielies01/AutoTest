package com.course.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController  //需要被扫描的类
public class MyGetMethod {
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login" ,"true");
        response.addCookie(cookie);

        return "恭喜你获得cookies信息成功";

    }

    

}