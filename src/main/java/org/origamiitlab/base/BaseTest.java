package org.origamiitlab.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.origamiitlab.manager.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected static Logger appLog;

    public BaseTest() {
        appLog = LogManager.getLogger(this.getClass());
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters(value={"browser"})
    public void setUp(@Optional("chrome") String browser) {
        DriverFactory.setTlDriver(browser);

        DriverFactory.getTlDriver().get("https://www.saucedemo.com");
        DriverFactory.getTlDriver().manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.disposeDriver();
    }


}
