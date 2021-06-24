package com.coures.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void  testCase1(){
        System.out.println("TEST 这是测试用例1");
    }

    @BeforeMethod
    public void  beforeMethod(){
        System.out.println("beforeMethod   这是测试方法之前运行");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod 这是测试方法后运行");
    }

    @Test
    public void testCase2(){
        System.out.println("Test 这是测试用例2 ");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite 这是测试套件之前");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite这是测试套件之后");
    }

}
