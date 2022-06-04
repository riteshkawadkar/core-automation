package org.origamiitlab.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.origamiitlab.manager.DriverFactory;
import org.origamiitlab.manager.ReportManager;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
;

public class BaseTest {

    protected static Logger appLog;
    protected static ExtentReports reports;
    protected static ExtentTest test;

    public BaseTest() {
        appLog = LogManager.getLogger(this.getClass());
        // Initialize ExtentReport and attach it to reporter
        reports = new ExtentReports();
        reports.attachReporter(ReportManager.getSparkReporter());
    }


    @BeforeMethod(alwaysRun = true)
    @Parameters(value={"browser"})
    public void setUp(@Optional("chrome") String browser, ITestResult result) {
        DriverFactory.setTlDriver(browser);

        DriverFactory.getTlDriver().get("https://www.saucedemo.com");
        DriverFactory.getTlDriver().manage().window().maximize();

        test = reports.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        appLog.info(result.getMethod().getMethodName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {

        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,result.getThrowable());

            TakesScreenshot ts = (TakesScreenshot) DriverFactory.getTlDriver();
            String screenshotAsBase64String = ts.getScreenshotAs(OutputType.BASE64);

            // base64
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotAsBase64String).build());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getTestName());
        }
        else {
            test.log(Status.SKIP, result.getTestName());
        }
        reports.flush();

        DriverFactory.disposeDriver();
    }


}
