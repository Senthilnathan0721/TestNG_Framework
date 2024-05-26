package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ecommerce extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(Ecommerce.class);
    String productName;

    @Given("Customer Login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void Given_Customer_Login_with_username_and_password(String username, String password) throws InterruptedException {

        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
        Thread.sleep(2000);
        log.info(username);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        Thread.sleep(5000);
        log.info(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        log.info("SuccessFully Logged In");
        Thread.sleep(3000);
    }
    //adding to the cart 1

    @When("Customer adding the products to the cart")
    public void Customer_adding_the_products_to_the_cart() throws InterruptedException {

        Thread.sleep(3000);
        productName = driver.findElement(By.xpath("(//div[@data-test='inventory-item-name'])[1]")).getText();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        log.info("Product Name: " + productName + " 1st Product Picked");
        Thread.sleep(2000);


        //Scroll down
        BaseTest.ScrollDown(1000);
        Thread.sleep(3000);

        //adding to the cart 2
        productName = driver.findElement(By.xpath("(//div[@data-test='inventory-item-name'])[4]")).getText();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        Thread.sleep(3000);
        log.info("Product Name: " + productName + " 2nd Product Picked");
        //System.out.println("Product Name: " + productName + " 2nd Product Picked");

        productName = driver.findElement(By.xpath("(//div[@data-test='inventory-item-name'])[6]")).getText();
        driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        Thread.sleep(3000);
        log.info("Product Name: " + productName + " 3rd Product Picked");
        //System.out.println("Product Name: " + productName + " 3rd Product Picked");

        //Scroll Up
        BaseTest.ScrollUp(-1000);
        Thread.sleep(3000);

        //Clicking cart Icon
        driver.findElement(By.cssSelector("span.shopping_cart_badge")).click();
        Thread.sleep(2000);

        BaseTest.getDriver();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button.btn.btn_action.btn_medium.checkout_button")).click();
        Thread.sleep(2000);

        BaseTest.ScrollUp(-1000);
        Thread.sleep(3000);
    }

    @When("Customer giving details for confiriming the order")
    public void Customer_giving_details_for_confiriming_the_order() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Kumar");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Kuttan");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("691235");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js = (JavascriptExecutor) driver; //(scroll up of the page)
        js.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(3000);
        System.out.println("scrolled Down");
    }

    @Then("customer Placed the order SuccessFully")
    public void customer_Placed_the_order_SuccessFully() throws InterruptedException {

        productName = driver.findElement(By.cssSelector("div.summary_subtotal_label")).getText();
        log.info(productName);
        System.out.println(productName);

        productName = driver.findElement(By.cssSelector("div.summary_tax_label")).getText();
        log.info(productName);
        System.out.println(productName);

        productName = driver.findElement(By.cssSelector("div.summary_total_label")).getText();
        log.info(productName);
        System.out.println(productName);


        driver.findElement(By.xpath("//button[@id='finish']")).click();
        Thread.sleep(4000);

        productName = driver.findElement(By.cssSelector("h2.complete-header")).getText();
        log.info(productName);
        System.out.println(productName);

    }

}
