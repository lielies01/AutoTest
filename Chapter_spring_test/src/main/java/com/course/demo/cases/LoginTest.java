package com.course.demo.cases;

import com.course.demo.config.TestConfig;
import com.course.demo.model.InterfaceName;
import com.course.demo.model.LoginCase;
import com.course.demo.utils.ConfigFile;
import com.course.demo.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

@Component
public class LoginTest {

    //用例层 配置层、model层 工具层

    @BeforeTest(groups = "loginTrue", description = "测试准备工作")
    public void beforeTest() {
        TestConfig.defaultHttpClient = new DefaultHttpClient();
//        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);  //获取URL
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
//        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
//        TestConfig.updateUserInfoUrl =ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.defaultHttpClient =new DefaultHttpClient();

       // System.out.println(TestConfig.loginUrl);
    }


    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void loginTrue() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase LoginCase = session.selectOne("loginCase",2);  // S 为mapper对应SQL语句中对应的ID，取ID为1的数据
        System.out.println(LoginCase.toString());  //打出取值
        System.out.println(TestConfig.loginUrl);  //打出URL

////        //下边的代码为写完接口的测试代码
        String result = getResult(LoginCase);
////        //处理结果，就是判断返回结果是否符合预期
       //
        //
       Assert.assertEquals(LoginCase.getExpected(),result);
        System.out.println(TestConfig.loginUrl);
        System.out.println("1111实际结果："+result );
        System.out.println("预期结果："+ LoginCase.getExpected());
    }



    @Test(description = "用户登陆失败接口")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase LoginCase = session.selectOne("loginCase",1);  // S 为mapper对应SQL语句中对应的ID，取ID为1的数据
        System.out.println(LoginCase.toString());  //打出取值
        System.out.println(TestConfig.loginUrl);  //打出URL
        System.out.println("预期结果："+ LoginCase.getExpected());




        //下边的代码为写完接口的测试代码
        String result = getResult(LoginCase);
//        处理结果，就是判断返回结果是否符合预期
        System.out.println("实际结果："+result );
        System.out.println("失败预期结果："+LoginCase.getExpected());
        Assert.assertEquals(LoginCase.getExpected(),result);

    }

    private String getResult(LoginCase loginCase) throws IOException {
        //下边的代码为写完接口的测试代码
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());
        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //执行post方法
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        //获取响应结果  // 从响应中提取出响应主体
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();
        return result;
    }


}