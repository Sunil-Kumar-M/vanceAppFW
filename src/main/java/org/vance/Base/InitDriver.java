package org.vance.Base;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.vance.PageObjects.Dashboard.AleertDialogsObject;
import org.vance.PageObjects.Dashboard.DashboardScreenObject;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class InitDriver extends  ProjectBase{

    public static String appPackage;
    public static String plat;
    public static String platformName;
    public DashboardScreenObject dash;
    public AleertDialogsObject alrt;
    public WebDriverWait wait;

    @Parameters({"platform", "appPackage", "deviceName", "udid", "OSversion", "wda", "port"})
    @BeforeTest(alwaysRun = true)
    public void initDriver(String platform, String pack, String device, String udid, String version, long wda, String port) throws IOException, InterruptedException {

        this.appPackage = pack;
        this.plat = platform;
//        this.run = runID;
        platformName = platform;

        if (platform.contains("Android")) {
            androidCapabilitiesSetup(pack, device, udid, version, port);
        } else if (platform.contains("iOS")){
            iOSCapabilitiesSetup(pack, device, udid, version, wda, port);
        } else {
            System.out.println("ALERT: Please check the platform name, it's case sensitive");
            getDriver().quit();
            build.stop();
        }
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @BeforeSuite
    public void beforeSuiteInit(){
        System.out.println("Before Suite got invoked");
    }

    @BeforeClass
    public void beforeClassInvoke(){
        System.out.println("Before Class got invoked");
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
    }

    @AfterSuite
    public void afterSuiteCompilation(){
//        getDriver().close();
        getDriver().quit();
    }
}
