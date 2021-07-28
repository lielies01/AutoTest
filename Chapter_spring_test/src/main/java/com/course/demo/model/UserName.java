package com.course.demo.model;


import lombok.Data;

@Data
public class UserName {

    private   int  id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String isDelete;

//    public String toString(){
//        return (
//                "{id:"+id+","+
//                "userName:" +userName +","+
//                "password:"+password+","+
//                "age:"+age+","+
//                "sex:"+sex+","+
//                "isDelete:"+isDelete+"}"
//        );

//    }

}
