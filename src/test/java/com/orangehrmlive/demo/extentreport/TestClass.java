package com.orangehrmlive.demo.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestClass {
    @Test
    public void extentTest() throws IOException {
        //Create the object of ExtentReport
        ExtentReports reports = new ExtentReports();
        //spark Reporter
        ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");//html file will be generated


        //Report Theme, Report Title, and Report Name
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Orange Hrm Live");
        spark.config().setDocumentTitle("Automation");

        //Attach spark to Report
        reports.attachReporter(spark);

        //Add System information
        reports.setSystemInfo("OS",System.getProperty("os.name"));
        reports.setSystemInfo("Java version",System.getProperty("Java.version"));
        reports.setSystemInfo("Browser","Chrome");
        reports.setSystemInfo("Browser Version", "119.1.2");

        //Create the test
        ExtentTest test = reports.createTest("Login Test").assignAuthor("Hansa").assignCategory("Smoke");
        test.pass("Login Test start Successfully");
        test.info("Url is loaded");
        test.info("Values entered");
        test.pass("Login test completed successfully");

        //How to highlight the steps
        test.pass(MarkupHelper.createLabel("Login Test completed successfully", ExtentColor.GREEN));


        ExtentTest test1 = reports.createTest("HomePage Test").assignAuthor("Hansa").assignCategory("Sanity");
        test1.pass(" Login Test start Successfully");
        test1.info("Url is loaded");
        test1.info("Values entered");
        test1.fail("Login test completed successfully");
        //How to highlight the steps
        test1.fail(MarkupHelper.createLabel("HomePage test completed successfully", ExtentColor.RED));

        reports.flush();//Unless you can call this method report will not be written the logs
        Desktop.getDesktop().browse(new File("extent.html").toURI()); //This will open the file in the Desktop default browser

    }
}
