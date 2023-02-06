package org.vance.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.vance.Base.ProjectBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportiNG {

    public static ExtentReports extent;
    public static String time;
    public static String extentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh-mm a"));
    public static String path = "ExtentReportResults/"+(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")))+"/";


    public static ExtentReports extentReportGenerator() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(path+extentTime+"/"+System.getProperties().getProperty("os.name")+"_AutomationReport_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh-mm a"))+ ".html");
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Sunil Task Automation");
        reporter.config().setTheme(Theme.DARK);

        time = ProjectBase.time;

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "SK");
        extent.setSystemInfo("Environment", "TestApp");
        extent.setSystemInfo("Version", "Unknown");
        extent.setSystemInfo("Platform", "Android");
        extent.attachReporter(reporter);


        return extent;
    }
}
