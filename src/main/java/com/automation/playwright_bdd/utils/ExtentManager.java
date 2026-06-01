package com.automation.playwright_bdd.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    
    public static ExtentReports getInstance() {

        if (extent == null) 
        {
            String reportDir = System.getProperty("user.dir") + "/target";
            File dir = new File(reportDir);
            if (!dir.exists()) 
            {
                dir.mkdirs();
            }
            ExtentSparkReporter spark = new ExtentSparkReporter(reportDir + "/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}