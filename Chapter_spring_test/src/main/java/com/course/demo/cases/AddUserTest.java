package com.course.demo.cases;

import com.course.demo.config.TestConfig;
import com.course.demo.model.AddUserCase;
import com.course.demo.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {
   // @Test(dependsOnGroups = "logintrue")
    public void addUser() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = session.selectOne("addUser",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);
    }

}
