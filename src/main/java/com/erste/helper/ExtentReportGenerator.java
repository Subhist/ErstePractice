package com.erste.helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {

    static ExtentReports extentReports;

    public static ExtentReports extentReportGeneration() throws Exception {
        String path = System.getProperty("user.dir") + "/reports/index.html";
        System.out.println(path);
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(path);
        sparkReporter.config().setReportName(Helper.getValue("deviceDetails","reportName"));
        sparkReporter.config().setDocumentTitle(Helper.getValue("deviceDetails","reporttitleName"));

        extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester", "Subhist");
        return extentReports;

    }
}
