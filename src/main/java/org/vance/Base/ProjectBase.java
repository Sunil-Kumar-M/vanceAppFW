package org.vance.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.vance.Report.Listeners;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class ProjectBase extends Listeners {

    DesiredCapabilities capabilities;
    AppiumDriverLocalService build;
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
    public static ThreadLocal<String> case_id = new ThreadLocal<String>();

    //    public static

    public static String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));


    public void androidCapabilitiesSetup(String appPackage, String deviceName, String udid, String version, String port) throws IOException {

        File file = new File(new File("Resources").getAbsolutePath());

        capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "./src/main/resources/APIApp.apk");
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceId", udid);
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appPackage);
//        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, new ServerSocket(0).getLocalPort());
//        capabilities.setCapability(AndroidMobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
//        capabilities.setCapability(AndroidMobileCapabilityType.TAKES_SCREENSHOT, true);

        build = new AppiumServiceBuilder().usingPort(Integer.parseInt(port)).withArgument(GeneralServerFlag.BASEPATH, "/wd/hub").build();
        build.start();

        driver.set(new AndroidDriver(build.getUrl(), capabilities));
        System.out.println("The URL which got started is ---------->>>>>>>>>>   " + build.getUrl());
    }

    public void iOSCapabilitiesSetup(String appPackage, String deviceName, String udid, String version, long wda, String port) throws IOException {

        File file = new File(new File("Resources").getAbsolutePath());

        capabilities = new DesiredCapabilities();
        capabilities.setCapability("bundleId", appPackage);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
        capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, wda);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
        capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, new ServerSocket(0).getLocalPort());

        build = new AppiumServiceBuilder().usingPort(Integer.parseInt(port)).build();
        build.start();

        driver.set(new IOSDriver(build.getUrl(), capabilities));
        System.out.println("The URL which got started is ---------->>>>>>>>>>   " + build.getUrl());
    }


    public static AppiumDriver getDriver() {
        return driver.get();
    }
}
