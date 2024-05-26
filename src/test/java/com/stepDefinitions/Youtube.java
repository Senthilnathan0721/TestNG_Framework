package com.stepDefinitions;


import Utility.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;


public class Youtube extends BaseTest
{
    @Given("user entering into the youtube")
    public void user_is_on_login_page () throws  InterruptedException
    {
        Log.info("User entered into the youtube");
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }


    @When("searching for the video")
    public void searching_for_the_video () throws InterruptedException {
        Log.info("searching for the video");
        System.out.println("searching for the video");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("input[id='search']")).sendKeys("illumunati");
        driver.findElement(By.cssSelector("button#search-icon-legacy")).click();
        System.out.println("Video searched");
        Thread.sleep(3000);
    }


    @Then("video played")
    public void video_played () throws InterruptedException {
        Log.info("video Page");
        driver.findElement(By.xpath("(//div[@class='style-scope ytd-video-renderer'])[3]")).click();
        System.out.println("Video Clicked");
        //driver.findElement(By.xpath("//span[@class='ytp-skip-ad-button__icon']")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("span.ytp-ad-skip-button-icon-modern")).click();
        Thread.sleep(15000);
        Log.info("video played ");
        BaseTest.closeBrowser();


    }

}

