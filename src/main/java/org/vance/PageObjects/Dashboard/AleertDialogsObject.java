package org.vance.PageObjects.Dashboard;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.TouchAction;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class AleertDialogsObject {
    AppiumDriver driver;

    public AleertDialogsObject(AppiumDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App/Alert Dialogs']")
    @iOSXCUITBy(accessibility = "")
    private WebElement alertPageTitle;
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

    @AndroidFindBy(id = "android:id/button1") // OK
    @iOSXCUITBy(accessibility = "")
    private WebElement modalButton1;

    @AndroidFindBy(id = "android:id/button2") // CANCEL
    @iOSXCUITBy(accessibility = "")
    private WebElement modalButton2;

    @AndroidFindBy(id = "android:id/button3") // OTHERS
    @iOSXCUITBy(accessibility = "")
    private WebElement modalButton3;

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITBy(accessibility = "")
    private WebElement modalTitle;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITBy(accessibility = "")
    private WebElement modalMessage;

    @AndroidFindBy(id = "android:id/text1")
    @iOSXCUITBy(accessibility = "")
    private List<WebElement> modalLists;

    @AndroidFindBy(id = "io.appium.android.apis:id/username_edit")
    @iOSXCUITBy(accessibility = "")
    private WebElement nameTextField;

    @AndroidFindBy(id = "io.appium.android.apis:id/password_edit")
    @iOSXCUITBy(accessibility = "")
    private WebElement passwordTextField;

    public void getAlertDialogsListClick(){
        alertDialogsList.click();
    }

    public String validateTitle(){
        return alertPageTitle.getText();
    }

    public String getCancelDialogHandler(){
        cancelDialogWithMessageCTA.click();
        String title = modalTitle.getText(); //Lorem ipsum dolor sit aie consectetur adipiscing Plloaso mako nuto siwuf cakso dodtos anr koop.
        modalButton1.click(); // Click on OK CTA.
        return title;
    }

    public String getCancelLongDialogHandler(){
        cancelDialogWithLongMessageCTA.click();
        String title = modalTitle.getText(); // Header title
        modalButton1.click(); // OK
        return title;
    }

    public String getListDialogHandler(AppiumDriver driver){
        listDialogCTA.click();
        String title = modalTitle.getText(); // Header title
        modalLists.get(1).click(); // First List from the index
        new TouchAction((PerformsTouchActions) driver).tap(TapOptions.tapOptions().withPosition(PointOption.point(250,250))).perform();
        return title;
    }

    public String getTextEntryDialogHandler(String name, String password){
        textEntryDialogCTA.click();
        String title = modalTitle.getText(); // Text Entry dialog
        nameTextField.click();
        nameTextField.sendKeys(name);
        passwordTextField.click();
        passwordTextField.sendKeys(password);
        modalButton1.click(); // OK
        return title;
    }

    public String getTraditionalModalHandler(){
        traditionalThemeDialogCTA.click();
        String title = modalTitle.getText(); // Lorem ipsum
        modalButton1.click(); // OK
        return title;
    }


}
