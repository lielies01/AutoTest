package com.course.demo.utils;

import com.course.demo.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String adders = bundle.getString("test.url");
        String uir = "";

        //拼接最终测试接口地址
        String testUrl;
        if (name == InterfaceName.GETUSERLIST){ //查询
          uir =bundle.getString("getUserList.uir");
        }
        if(name == InterfaceName.LOGIN){  //登录
            uir = bundle.getString("login.uri");

        }
        if (name == InterfaceName.ADDUSERINFO){   //新增
            uir = bundle.getString("addUser.uri");
        }
        if(name == InterfaceName.UPDATEUSERINFO){   //修改
            uir = bundle.getString("updateUserInfo.uri");

        }


        testUrl = adders + uir;
        return testUrl;


    }

}
