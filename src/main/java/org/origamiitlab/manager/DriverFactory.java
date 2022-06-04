package org.origamiitlab.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getTlDriver() {
        if (tlDriver.get() == null) {
            throw new IllegalStateException("WebDriver Instance is null! Please create instance of WebDriver using setWebDriver!");
        }
        return tlDriver.get();
    }

    public static void setTlDriver(String browser) {
        switch (browser.toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                tlDriver.set(new ChromeDriver(options));
                break;

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
                break;

            case "IE":
                WebDriverManager.iedriver().setup();
                tlDriver.set(new InternetExplorerDriver());
                break;

            default:
                throw new IllegalStateException("MESSAGE_UNKNOWN_BROWSER");
        }

    }

    public static void disposeDriver() {
        tlDriver.get().quit();
        tlDriver.remove();

    }



}
