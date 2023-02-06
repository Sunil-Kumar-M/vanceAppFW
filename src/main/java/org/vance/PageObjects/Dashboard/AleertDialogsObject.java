package org.vance.PageObjects.Dashboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AleertDialogsObject {
    AppiumDriver driver;

    public AleertDialogsObject(AppiumDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Alert Dialogs")
    @iOSXCUITBy(accessibility = "")
    private WebElement alertDialogsList;

    @AndroidFindBy(accessibility = "OK Cancel dialog with a message")
    @iOSXCUITBy(accessibility = "")
    private WebElement cancelDialogWithMessageCTA;

    @AndroidFindBy(accessibility = "OK Cancel dialog with a long message")
    @iOSXCUITBy(accessibility = "")
    private WebElement cancelDialogWithLongMessageCTA;

    @AndroidFindBy(accessibility = "OK Cancel dialog with ultra long message")
    @iOSXCUITBy(accessibility = "")
    private WebElement cancelDialogWithUltraLongMessageCTA;

    @AndroidFindBy(accessibility = "List dialog")
    @iOSXCUITBy(accessibility = "")
    private WebElement listDialogCTA;

    @AndroidFindBy(accessibility = "Progress dialog")
    @iOSXCUITBy(accessibility = "")
    private WebElement progressDialogCTA;

    @AndroidFindBy(accessibility = "Single choice list")
    @iOSXCUITBy(accessibility = "")
    private WebElement singleChoiceCTA;

    @AndroidFindBy(accessibility = "Repeat alarm")
    @iOSXCUITBy(accessibility = "")
    private WebElement repeatAalarmCTA;

    @AndroidFindBy(accessibility = "Text Entry dialog")
    @iOSXCUITBy(accessibility = "")
    private WebElement textEntryDialogCTA;

    @AndroidFindBy(accessibility = "OK Cancel dialog with traditional theme")
    @iOSXCUITBy(accessibility = "")
    private WebElement traditionalThemeDialogCTA;

    @AndroidFindBy(accessibility = "OK Cancel dialog with traditional theme")
    @iOSXCUITBy(accessibility = "")
    private WebElement holoLightThemeDialogCTA;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITBy(accessibility = "")
    private WebElement modalButton1;

    @AndroidFindBy(id = "android:id/button2")
    @iOSXCUITBy(accessibility = "")
    private WebElement modalButton2;

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITBy(accessibility = "")
    private WebElement modalTitle;

    public String getCancelDialogHandler(){
        cancelDialogWithMessageCTA.click();
        alertDialogsList.click();
        String title = modalTitle.getText(); //Lorem ipsum dolor sit aie consectetur adipiscing Plloaso mako nuto siwuf cakso dodtos anr koop.
        modalButton1.click(); // Click on OK CTA.
        return title;
    }
}
