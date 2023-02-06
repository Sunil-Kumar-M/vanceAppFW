package org.vance.TestImplementation;

import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.vance.Base.InitDriver;
import org.vance.PageObjects.Dashboard.AleertDialogsObject;
import org.vance.PageObjects.Dashboard.DashboardScreenObject;
import org.vance.Report.LoggerLoad;

public class AppSection extends InitDriver {

    DashboardScreenObject dash;
    AleertDialogsObject alrt;
//    AppiumDriver driver;

    @Test
    public void appSectionFlowTest() {
        dash = new DashboardScreenObject(getDriver());
        alrt = new AleertDialogsObject(getDriver());

        Assert.assertTrue(dash.getDashboardTitle().contains("API Demos"));
        LoggerLoad.info("Title validation Completed");
        dash.clickApp();
        LoggerLoad.info("Clicked on App Section from list");
        Assert.assertTrue(alrt.getCancelDialogHandler().contains("Lorem"));
        LoggerLoad.info("Modal Title validation complete");
    }

}
