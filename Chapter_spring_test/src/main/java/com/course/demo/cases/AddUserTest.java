package com.course.demo.cases;

import com.course.demo.config.TestConfig;
import com.course.demo.model.AddUserCase;
import com.course.demo.model.UserName;
import com.course.demo.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {


    @Test(dependsOnGroups = "loginTrue")
    public void addUser() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = session.selectOne("AddUserCase",3);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);

        //发送请求，获取结果
        String result = getResult(addUserCase);

        //验证返回结果
        UserName user = session.selectOne("AddUser",addUserCase);
        //System.out.println(user.toString());


        System.out.println(result);
        Assert.assertEquals(addUserCase.getExpected(),result);

    }

    private String getResult(AddUserCase addUserCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("age",addUserCase.getAge());
        param.put("sex",addUserCase.getSex());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());

        //设置头信息
        post.setHeader("content-type","application/json");


        //参数装载到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        //fas
        post.setEntity(entity);

        //设置cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        //发送post请求，获取响应信息

        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String ACresult;

        ACresult = EntityUtils.toString(response.getEntity(),"utf-8");

        return ACresult;
    }

}
