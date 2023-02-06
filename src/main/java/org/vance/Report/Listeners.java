package org.vance.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.vance.Base.ProjectBase;

import javax.swing.text.Document;
import java.io.File;
import java.io.IOException;

public class Listeners implements ITestListener {


    public static ExtentReports extent = ExtentReportiNG.extentReportGenerator();

    public static ExtentTest test;
    public File file;
    static Document doc;
    public void onTestStart(ITestResult iTestResult) {
        test = extent.createTest(iTestResult.getMethod().getMethodName());
        LoggerLoad.info("START: " + iTestResult.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS, "COMPLETED: - " + iTestResult.getMethod().getMethodName());
        LoggerLoad.info("TESTING COMPLETED: - " + iTestResult.getMethod().getMethodName());

    }

    public void onTestFailure(ITestResult iTestResult) {

        test.log(Status.FAIL, "FAILED : - " + iTestResult.getMethod().getMethodName());
        LoggerLoad.error("FAILED : - " + iTestResult.getMethod().getMethodName());

//        file = null;
//        String path = file.getAbsolutePath();
//        try {
//            test.addScreenCaptureFromPath(path, iTestResult.getMethod().getMethodName()+" - FAILED");
//            System.out.println("Screenshot added >>>>>>>>>>>>>>>");
//        } catch (IOException ignored) {}

    }

    public void onTestSkipped(ITestResult iTestResult) {
        test.skip(iTestResult.getSkipCausedBy().toString());
        LoggerLoad.debug("SKIPPED : - " + iTestResult.getMethod().getMethodName());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        LoggerLoad.info("TEST STOPPED");
        extent.flush();
    }

    public static void statusPass(String details) {
        test.log(Status.PASS, MarkupHelper.createLabel(details , ExtentColor.GREEN));
    }

    public static void info(String details){
        test.log(Status.INFO, MarkupHelper.createLabel(details , ExtentColor.TRANSPARENT));
    }

//    public static void testCaseName(String name){
//        ExtentTest testName = Listeners.extent.createTest(name);
//        extentTest.set(testName);
//        test.
//    }

}


