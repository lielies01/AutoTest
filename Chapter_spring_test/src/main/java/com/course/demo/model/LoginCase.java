package com.course.demo.model;

import lombok.Data;

@Data
public class LoginCase {
        private   int  id;
        private String userName;
        private String password;
        private String age;
        private String sex;
        private String expected;
        private String isDelete;

        public String toString(){
                return (
                        "{id:"+id+","+
                                "userName:" +userName +","+
                                "password:"+password+","+
                                "age:"+age+","+
                                "sex:"+sex+","+
                                "expected:"+expected+","+
                                "isDelete:"+isDelete+"}"
                );

        }

}
