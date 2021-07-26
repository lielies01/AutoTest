package com.course.demo.config;

import org.apache.logging.log4j.util.Strings;
//import org.mockito.internal.util.StringUtil;
import org.testng.Reporter;
import java.util.Calendar;

import static org.mockito.internal.util.StringUtil.*;

public class ReportUtil {
    private static String reportName = "自动化测试报告";
    //时间与信息的分隔符
    private static String splitTimeAndMsg = "===";
    //testNG中log的形式
    public static void log(String msg) {
        long timeMillis = Calendar.getInstance().getTimeInMillis();
        Reporter.log(timeMillis + splitTimeAndMsg + msg, true);
        //此处log样式为：1581837152264===XXXXXXXXXXXXXXXXXXXXXXXXXXXX
    }

    public static String getReportName() {
        return reportName;
    }

    public static String getSpiltTimeAndMsg() {
        return splitTimeAndMsg;
    }

    public static void setReportName(String reportName) {
        if(Strings.isNotEmpty(reportName)){
            ReportUtil.reportName = reportName;
        }
    }
}
