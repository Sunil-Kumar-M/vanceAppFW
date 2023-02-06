package org.vance.TestImplementation;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.vance.Base.InitDriver;
import org.vance.PageObjects.Dashboard.AleertDialogsObject;
import org.vance.PageObjects.Dashboard.DashboardScreenObject;
import org.vance.Report.LoggerLoad;

public class AppSection extends InitDriver {

    DashboardScreenObject dash;
    AleertDialogsObject alrt;

    @Test (priority = 0)
    public void dialogMessageValidation() {
        dash = new DashboardScreenObject(getDriver());
        alrt = new AleertDialogsObject(getDriver());

        Assert.assertTrue(dash.getDashboardTitle().contains("API Demos"));
        LoggerLoad.info("Title validation Completed");
        dash.clickApp();
        LoggerLoad.info("Clicked on App Section from list");
        alrt.getAlertDialogsListClick();
        LoggerLoad.info("Clicked on Alert Dialog");
        Assert.assertTrue(alrt.validateTitle().contains("App/Alert Dialogs"));
        LoggerLoad.info("Validated The Title of the Screen");
        Assert.assertTrue(alrt.getCancelDialogHandler().contains("Lorem"));
        LoggerLoad.info("Modal Title validation complete and accepted");
    }

    @Test (priority = 1)
    public void longDialogMessageValidation(){
        dash = new DashboardScreenObject(getDriver());
        alrt = new AleertDialogsObject(getDriver());

        Assert.assertTrue(alrt.validateTitle().contains("App/Alert Dialogs"));
        LoggerLoad.info("Validated The Title of the Screen");
        Assert.assertTrue(alrt.getCancelLongDialogHandler().contains("Header title"));
        LoggerLoad.info("Modal title Validated and Accepted");
    }

    @Test
    public void listDialogActionValidation(){
        dash = new DashboardScreenObject(getDriver());
        alrt = new AleertDialogsObject(getDriver());

        Assert.assertTrue(alrt.validateTitle().contains("App/Alert Dialogs"));
        LoggerLoad.info("Validated The Title of the Screen");
        Assert.assertTrue(alrt.getListDialogHandler(getDriver()).contains("Header title"));
        LoggerLoad.info("Modal title Validated and Accepted");
    }

    @Test
    public void textEntryDialogValidation(){
        dash = new DashboardScreenObject(getDriver());
        alrt = new AleertDialogsObject(getDriver());

        Assert.assertTrue(alrt.validateTitle().contains("App/Alert Dialogs"));
        LoggerLoad.info("Validated The Title of the Screen");
        Assert.assertTrue(alrt.getTextEntryDialogHandler("Sunil", "12345").contains("Text Entry dialog"));
        LoggerLoad.info("Validated the Title of the Modal and Provided some Inputs");
    }

    @Test
    public void traditionalThemeModalValidation(){
        dash = new DashboardScreenObject(getDriver());
        alrt = new AleertDialogsObject(getDriver());

        Assert.assertTrue(alrt.validateTitle().contains("App/Alert Dialogs"));
        LoggerLoad.info("Validated The Title of the Screen");
        Assert.assertTrue(alrt.getTraditionalModalHandler().contains("Lorem ipsum"));
        LoggerLoad.info("Modal title Validated and Accepted");
    }

}
