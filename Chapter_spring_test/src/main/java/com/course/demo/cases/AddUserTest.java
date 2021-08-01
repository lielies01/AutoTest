package com.course.demo.cases;

import com.course.demo.config.TestConfig;
import com.course.demo.model.AddUserCase;
import com.course.demo.utils.DatabaseUtil;
import org.apache.http.client.methods.HttpPost;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {
   // @Test(dependsOnGroups = "logintrue")
    public void addUser() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = session.selectOne("addUser",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);
        String ACTresult = getResult(addUserCase);
        Assert.assertEquals(addUserCase.getExpected(),ACTresult);

    }

    private String getResult(AddUserCase addUserCase) {

        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());

        return null;
    }

}
