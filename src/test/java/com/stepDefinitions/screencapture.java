package com.stepDefinitions;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class screencapture {

    private static final Logger log = LoggerFactory.getLogger(screencapture.class);

    public static String scenarioName, FeatureName;


    @Before
    public static void TestName(Scenario scenario) {
        scenarioName = scenario.getName();
        FeatureName = (new File(scenario.getUri()).getName());
        FeatureName = FeatureName.substring(0,FeatureName.lastIndexOf(".feature"));

    }

    @After
    public static void screenshot(Scenario scenario) {

        //validate if scenario has failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            log.info("Test Failed");

        }

        else {
            log.info("Test Success");
        }

        BaseTest.closeBrowser();

    }

}
