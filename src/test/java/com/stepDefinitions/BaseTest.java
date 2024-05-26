package com.stepDefinitions;

import static com.stepDefinitions.screencapture.FeatureName;
import static com.stepDefinitions.screencapture.scenarioName;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Utility.Log;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest{

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    public static WebDriver driver;
    private static Properties GlobalData;

    public BaseTest() {
        Log.startTestCase("Test Started");
        Log.info("Test Name:"+scenarioName);
        Log.info("Feature Name:"+FeatureName);
        GlobalData = loadConfig();
        String Browser = GlobalData.getProperty("Browser");
        if (Browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (Browser.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {
            throw new IllegalArgumentException("Unsupported browser! Only 'chrome' and 'firefox' are supported.");
        }

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Integer.parseInt(GlobalData.getProperty("implicit_wait")), java.util.concurrent.TimeUnit.SECONDS);

    }


    private static Properties loadConfig() {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("GlobalData.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static void ScrollDown(int pixels)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver; //(scroll down of the page)
        js.executeScript("window.scrollBy(0," + pixels + ")");
        System.out.println("Scroll Down");
    }

    public static void ScrollUp(int pixels)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
        System.out.println("Scroll Up");
    }


    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
    Log.endTestCase("Test Ended");
        if (driver != null) {
            driver.quit();
        }
    }

    public static void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }


	public static Logger getLog() {
		return log;
	}

}