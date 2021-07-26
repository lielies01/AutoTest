package com.course.demo1.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
//@Api：用在类上，用来描述整个Controller接口信息。
@Api(tags = "用户数据接口")
public class ApiController {

    @ApiOperation(value = "通过这个方法获取cookies",notes = "无参数访问get请求")
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
    @ApiOperation(value = "携带cookies信息访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (Objects.isNull(cookies)) {
            return "你必须携带cookies信息才可以访问";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "这是一个需要携带cookies信息才可以访问的get请求，访问成功"+cookie.getName() +  cookie.getValue();
            } else {
                return "这是一个需要携带cookies信息才可以访问的get请求，cookies异常";
            }
        }

        return "你必须携带cookies信息才可以访问";
    }




    //@ApiOperation：用在方法上，用来描述方法的基本信息
    @ApiOperation(value = "查询用户" ,notes = "根据ID查询用户")
    //@ApiImplicitParam：用在方法上，用来描述方法的参数
    @ApiImplicitParam(paramType = "path",name = "id",value = "用户id",required = true,dataType = "String",dataTypeClass = String.class)
    @GetMapping("/user/{id}")
    public String getUserByID(@PathVariable Integer id){
        return "userid:"+ id;
    }

    //@ApiResponse：对响应结果的描述
    @ApiResponses({@ApiResponse(code = 200,message = "删除成功！"),@ApiResponse(code = 500,message = "删除失败！")})
    @ApiOperation(value = "删除用户", notes = "删除用户BYid")
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable Integer id){
        return "删除用户："+id;
    }

    @ApiOperation(value = "添加用户",notes = "添加一个用户，传入用户名和地址")
    //@ApiImplicitParams：如果是多参数，可将多个参数@ApiImplicitParam放在@ApiImplicitParams中
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query",name = "username",value = "传入用户名",required = true,defaultValue = "lulu",dataType = "String",dataTypeClass = String.class),
            @ApiImplicitParam(paramType = "query",name = "address",value = "传入地址",required = true,defaultValue = "深圳",dataType = "String",dataTypeClass = String.class)})
    @PostMapping("/user")
    public String addUser(@RequestParam String username,@RequestParam String address){
        return "添加用户："+username+" 地址："+address;
    }

    @ApiOperation(value = "修改用户",notes = "修改用户，传入用户信息")
    @PutMapping("/user")
    public String updateUser(@RequestBody Users user){
        return "修改用户"+user.getUsername()+user.getAddress();
    }

    //@ApiIgnore：表述不对某个接口生成文档
    @GetMapping("/ignore")
    @ApiIgnore
    public void ignore(){
    }

    //@ApiModel：一般用于响应类上，表示一个返回响应数据的信息
    @ApiModel(value = "用户实体类",description = "用户信息描述")
    public static class Users{
        //@ApiModelProperty：用在属性上，描述响应类的属性
        @ApiModelProperty(value = "用户名")
        private String username;
        @ApiModelProperty(value = "用户地址")
        private String address;
        public String getUsername() {
            return username;
        }
        public String getAddress() {
            return address;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public void setAddress(String address) {
            this.address = address;
        }
    }
}