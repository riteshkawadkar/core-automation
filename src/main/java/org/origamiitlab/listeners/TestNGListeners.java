package org.origamiitlab.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.origamiitlab.manager.ApplicationLogManager;
import org.origamiitlab.manager.DriverFactory;
import org.origamiitlab.manager.ReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners extends ReportManager implements ITestListener{

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription()));
        ApplicationLogManager.info("Starting test " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ApplicationLogManager.info("Test Passed " + result.getMethod().getMethodName());
        test.get().log(Status.PASS, "Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ApplicationLogManager.error("Test Failed " + result.getMethod().getMethodName());
        ApplicationLogManager.error("Exception " + result.getThrowable());

        test.get().log(Status.FAIL, "Exception:");
        test.get().log(Status.FAIL,result.getThrowable());

        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getTlDriver();
        String screenshotAsBase64String = ts.getScreenshotAs(OutputType.BASE64);

        // base64
        test.get().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotAsBase64String).build());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ApplicationLogManager.error("Test Skipped " + result.getMethod().getMethodName());
        test.get().log(Status.SKIP, "Skip:");
        test.get().log(Status.SKIP, result.getTestName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        extent = getExtentReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
