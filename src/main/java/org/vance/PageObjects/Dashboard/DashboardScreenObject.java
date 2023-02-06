package org.vance.PageObjects.Dashboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DashboardScreenObject {
    AppiumDriver driver;

    public DashboardScreenObject(AppiumDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='API Demos']")
    @iOSXCUITBy(accessibility = "")
    private WebElement dashboardTitle;
    @AndroidFindBy(accessibility = "Access'ibility")
    @iOSXCUITBy(accessibility = "")
    private WebElement firstAccessibilityList;

    @AndroidFindBy(accessibility = "Accessibility")
    @iOSXCUITBy(accessibility = "")
    private WebElement secondAccessibilityList;

    @AndroidFindBy(accessibility = "Animation")
    @iOSXCUITBy(accessibility = "")
    private WebElement animationList;

    @AndroidFindBy(accessibility = "App")
    @iOSXCUITBy(accessibility = "")
    private WebElement appList;

    @AndroidFindBy(accessibility = "Content")
    @iOSXCUITBy(accessibility = "")
    private WebElement contentList;

    @AndroidFindBy(accessibility = "Graphics")
    @iOSXCUITBy(accessibility = "")
    private WebElement graphicsList;

    @AndroidFindBy(accessibility = "Media")
    @iOSXCUITBy(accessibility = "")
    private WebElement mediaList;

    @AndroidFindBy(accessibility = "NFC")
    @iOSXCUITFindBy(accessibility = "")
    private WebElement nfcList;

    @AndroidFindBy(accessibility = "OS")
    private WebElement osList;

    @AndroidFindBy(accessibility = "Preference")
    @iOSXCUITBy(accessibility = "")
    private WebElement preferenceList;

    @AndroidFindBy(accessibility = "Text")
    @iOSXCUITBy(accessibility = "")
    private WebElement textList;

    @AndroidFindBy(accessibility = "Views")
    @iOSXCUITBy(accessibility = "")
    private WebElement viewsList;

    public String getDashboardTitle(){
        return dashboardTitle.getText();
    }

    public void clickApp(){
        appList.click();
    }


}
