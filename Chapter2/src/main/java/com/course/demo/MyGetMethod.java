package com.course.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@RestController  //需要被扫描的类
public class MyGetMethod {
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login" ,"true");
        response.addCookie(cookie);

        return "恭喜你获得cookies信息成功";

    }

    /**
     * 要求客户端携带cookies访问
     */
    public String getWithCookies(HttpServletRequest request){
       Cookie[] cookies = request.getCookies();
       if (Objects.isNull(cookies)){
           return "你必须携带Cookies信息访问";
       }
      for (Cookie cookie : cookies){
          if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
              return "恭喜你访问成功";
          }
      }


    }

}