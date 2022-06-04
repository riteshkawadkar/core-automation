package org.origamiitlab.base;

import com.aventstack.extentreports.ExtentTest;
import org.origamiitlab.manager.ApplicationLogManager;
import org.origamiitlab.manager.DriverFactory;
import org.origamiitlab.manager.ReportManager;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
;

public class BaseTest {

    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    @Parameters(value={"browser"})
    public void setUp(@Optional("chrome") String browser, ITestResult result) {
        DriverFactory.setTlDriver(browser);

        DriverFactory.getTlDriver().get("https://www.saucedemo.com");
        DriverFactory.getTlDriver().manage().window().maximize();

        ApplicationLogManager.info("Setup Operation completed");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        DriverFactory.disposeDriver();
    }


}
