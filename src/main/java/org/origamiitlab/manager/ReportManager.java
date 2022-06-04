package org.origamiitlab.manager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
    private static ExtentSparkReporter sparkReporter;

    public static ExtentSparkReporter getSparkReporter() {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/reports/MyOwnReport.html");

        sparkReporter.config().setDocumentTitle("Core Automation");
        sparkReporter.config().setReportName("Daily Sanity Report");
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        sparkReporter.config().setTheme(Theme.DARK);

        return sparkReporter;

    }
}
