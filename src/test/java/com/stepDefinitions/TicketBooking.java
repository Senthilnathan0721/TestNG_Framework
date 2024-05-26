package com.stepDefinitions;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Utility.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketBooking extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TicketBooking.class);

    @Given("Customer login to the application")
    public void Customer_login_to_the_application() {
        try {
            Log.info("Bus Application");
            driver.get("https://www.redbus.in");
            System.out.println(driver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw e;
        }
    }

    @When("Customer FROM and TO and DATE")
    public void Customer_FROM_and_TO_and_DATE() throws InterruptedException {

        try {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Bangalore");
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//li[@class='sc-iwsKbI jTMXri'])[10]")).click();

            driver.findElement(By.id("dest")).sendKeys("Erode");
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//li[@class='sc-iwsKbI jTMXri'])[3]")).click();
            Thread.sleep(3000);
            System.out.println("Location selected");

            driver.findElement(By.xpath("//span[normalize-space()='24']")).click();
            System.out.println("Date Selected");
            Log.info("Data Filled");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw e;
        }
    }

    @And("Customer clicks on search")
    public void Customer_clicks_on_search() throws InterruptedException {
           try {

               driver.findElement(By.id("blasl.ns>")).click();
               Thread.sleep(3000);
               Log.info("Search Clicked");
           }
           catch (Exception e) {
               e.printStackTrace();
               log.error(e.getMessage());
               throw e;
           }
    }

    @Then("Customer checking for the seats")
    public void Customer_checking_for_the_seats() throws InterruptedException {

        try {
            BaseTest.ScrollDown(1000);
            Thread.sleep(3000);
            System.out.println("scrolled down");
            Log.info("Checking for the seats");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw e;

        }

    }

}
