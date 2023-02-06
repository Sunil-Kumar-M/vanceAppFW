package org.vance.TestImplementation;

import org.testng.annotations.Test;
import org.vance.Base.InitDriver;
import org.vance.Report.LoggerLoad;

public class FirstTest extends InitDriver {

    @Test
    public void dummyTest() {

        LoggerLoad.info("Entered this block");
        System.out.println("Dummy testing has been printed... ->");
        LoggerLoad.info("Dummy Load test Printed");
    }

}
