package com.course.demo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@RequestMapping("/USER")
@Api(tags = "这是我的全部GET方法")
public class  MyGetMethod {

    @ApiOperation(value = "通过这个方法获取cookies")
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response) {

        //HttpserverletRequest
        //HttpserverletResponse
        Cookie cookie = new Cookie("login", "true");

        response.addCookie(cookie);
        return "恭喜你获取Cookies信息成功";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个需要cookies信息才能访问的GET请求
     *
     * @return
     */


    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "必须携带cookies信息才可以访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (Objects.isNull(cookies)) {
            return "你必须携带cookies信息才可以访问";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "这是一个需要携带cookies信息才可以访问的get请求，cook";
            } else {
                return "这是一个需要携带cookies信息才可以访问的get请求，cookies异常";
            }
        }

        return "你必须携带cookies信息才可以访问";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种方式：URL：key=value&key=value
     * 获取商品列表
     */
    @ApiOperation(value = "开发一个需要携带参数才能访问的get请求",httpMethod = "GET")
    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    public Map<String, Integer> getList(@RequestParam Integer start,
                                        @RequestParam Integer end) {
        Map<String, Integer> mylist = new HashMap<>();

        mylist.put("鞋", 400);
        mylist.put("裤子", 200);
        mylist.put("衣服", 20);
        return mylist;
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种方式：URL：ip:port/get/with/param/1/2
     * 获取商品列表     *
     */

    @ApiOperation(value = "开发一个需要携带参数才能访问的get请求 第2种",httpMethod = "GET")
    @RequestMapping(value = "/get/with/param/{start}/{end}", method = RequestMethod.GET)
    public Map<String, Integer> mygetList(@PathVariable Integer start,
                                          @PathVariable Integer end) {
        Map<String, Integer> mylist = new HashMap<>();

        mylist.put("鞋子", 400);
        mylist.put("裤子", 200);
        mylist.put("衣服", 20);
        return mylist;

    }
}