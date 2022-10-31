package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.*;

import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    WebDriver driver;
    WebElement element_shipping;
    WebElement element_tracking;
    WebElement element_support;
    WebElement element_account;

    @Before(order=1)
    @Given("I launch Chrome Browser")
    public void i_launch_chrome_browser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
    }
    @Before(order=2)
    @When("I open Fedex homepage")
    public void i_open_fedex_homepage(){
        driver.get("https://www.fedex.com/en-gb/home.html");
    }
    @When("I click on login icon from dropdown")
    public void i_click_on_login_icon_from_dropdown(){
        driver.findElement(By.xpath("//span[contains(@class,'fxg-user-options__sign-in-text')]")).click();
        driver.findElement(By.xpath("//a[contains(@data-analytics,'link|Log In')]")).click();
    }

    @Then("I verify that the home page is visible")
    public void i_verify_that_the_home_page_is_visible(){
        driver.findElement(By.xpath("//body[contains(@class, 'page basicpage')]")).isDisplayed();
    }

    @And("I select English from India")
    public void i_select_English_from_India(){
        driver.findElement(By.xpath("//a[@data-country-code='in']//span[@class='fxg-geo-locator__button-label']")).click();
    }
    @And("I select English from UK")
    public void i_select_English_from_UK(){
        driver.findElement(By.xpath("//a[@data-country-code='gb']//span[@class='fxg-geo-locator__button-label']")).click();
    }
    @And("I close the popup if exists")
    public void i_close_the_popup(){
        try {
            WebElement element = driver.findElement(By.xpath("//button[@class='close']//a[@data-analytics='link|close']"));
            element.click();
        } catch (NoSuchElementException e) {
        }
        try{
            WebElement element = driver.findElement(By.xpath("//button[contains(@class,'fxg-cookie-consent__accept')]"));
            element.click();
        }catch (NoSuchElementException e) {
        }
    }
    @Then("I verify that the logo is present on Page")
    public void i_verify_that_the_logo_present_on_page(){
        boolean logo_status = driver.findElement(By.xpath("//img[@class='fxg-header__logo']")).isDisplayed();
        Assert.assertEquals (true,logo_status);
    }
    @After("@DoAfterScenario")
    public void close_browser(){
        driver.quit();
    }

    @When("I enter the valid login credentials")
    public void i_enter_the_valid_login_credentials() {
        driver.findElement(By.id("userId")).sendKeys("4ayushsinghal");
        driver.findElement(By.id("password")).sendKeys("Quechua@123");
    }
    @When("I enter the invalid login credentials")
    public void i_enter_the_invalid_login_credentials() {
        driver.findElement(By.id("userId")).sendKeys("4ayush");
        driver.findElement(By.id("password")).sendKeys("Quechua@123");
    }

    @Then("I verify the error message is shown")
    public void i_verify_the_error_message_is_shown() {
        String error = driver.findElement(By.id("invalidCredentials")).getText();
        Assert.assertTrue(error.contains("Login incorrect"));
    }
    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.id("login-btn")).click();
    }
    @Then("I verify the login is successful")
    public void i_verify_the_login_is_successful() {
        String login_name = driver.findElement(By.id("//span[@class='fxg-user-options__sign-in-text']")).getText();
        Assert.assertEquals("Ayush", login_name);
    }

    @When("I enter any valid tracking id")
    public void i_enter_any_valid_tracking_id() {
        driver.findElement(By.id("trackingnumber")).sendKeys("TODO");
    }

    @When("I enter any invalid tracking id")
    public void i_enter_any_invalid_tracking_id() {
        driver.findElement(By.id("trackingnumber")).sendKeys("1234");
    }

    @When("I enter any invalid tracking id in search")
    public void i_enter_any_invalid_tracking_id_in_search() {
        driver.findElement(By.id("fxg-search-text")).sendKeys("1234");
    }

    @When("I click on Track button")
    public void i_click_on_Track_button() {
        driver.findElement(By.id("btnSingleTrack")).click();
    }

    @Then("I verify that the tracking details are displayed")
    public void i_verify_that_the_tracking_details_are_displayed() {
        //TODO
    }

    @Then("I verify that the error page with no records is displayed")
    public void iVerifyThatTheErrorPageWithNoRecordsIsDisplayed() {
        String track_error = driver.findElement(By.xpath("//div[contains(@class,'notification__message')]")).getText();
        Assert.assertTrue(track_error.contains("unable to retrieve your tracking results"));
    }

    @And("I click on Forgot Your userid or password")
    public void iClickOnForgotYourUseridOrPassword() {
        i_click_on_login_icon_from_dropdown();
        driver.findElement(By.id("requestCode-btn")).click();
    }

    @And("I land on the forgot password page")
    public void iLandOnTheForgotPasswordPage() {
        boolean forgot_page = driver.findElement(By.id("loginSolutionsTitle")).isDisplayed();
        Assert.assertTrue(forgot_page);
    }

    @And("I click on Reset Password button")
    public void iClickOnResetPasswordButton() {
        driver.findElement(By.id("reset-btn")).click();
    }

    @Then("I land on the Reset Password Page")
    public void iLandOnTheResetPasswordPage() {
        boolean reset_pwd_page = driver.findElement(By.id("userId-title")).isDisplayed();
        Assert.assertTrue(reset_pwd_page);
    }

    @And("I click on Retrieve User ID button")
    public void iClickOnRetrieveUserIDButton() {
        driver.findElement(By.id("retrieve-btn")).click();
    }

    @Then("I land on Retrieve User ID Page")
    public void iLandOnRetrieveUserIDPage() {
        boolean retrieve_user_page = driver.findElement(By.id("emailId-title")).isDisplayed();
        Assert.assertTrue(retrieve_user_page);
    }

    @When("I navigate through the toolbar")
    public void iNavigateThroughTheToolbar() {
        driver.findElement(By.xpath("//a[contains(@data-analytics,'Shipping')][contains(@class,'fxg-dropdown-js')]")).click();
        driver.findElement(By.xpath("//a[contains(@data-analytics,'Tracking')][contains(@class,'fxg-dropdown-js')]")).click();
        driver.findElement(By.xpath("//a[contains(@data-analytics,'Support')][contains(@class,'fxg-dropdown-js')]")).click();
        driver.findElement(By.xpath("//a[contains(@data-analytics,'Account')][contains(@class,'fxg-dropdown-js')]")).click();
    }

    @Then("I verify all the options are available")
    public void iVerifyAllTheOptionsAreAvailable() {
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@data-analytics,'Shipping')][contains(@class,'fxg-dropdown-js')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@data-analytics,'Tracking')][contains(@class,'fxg-dropdown-js')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@data-analytics,'Support')][contains(@class,'fxg-dropdown-js')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@data-analytics,'Account')][contains(@class,'fxg-dropdown-js')]")).isDisplayed());
    }

    @When("I click on Search button")
    public void iClickOnSearchButton() {
        driver.findElement(By.xpath("//span[@class='fxg-mouse']//img[@class='fxg-user-options__icon']"));
    }

    @And("I press enter")
    public void iPressEnter() {
        driver.findElement(By.id("fxg-search-text")).sendKeys("\n");
    }

    @And("Click on search input field")
    public void clickOnSearchInputField() {
        driver.findElement(By.id("fxg-search-text")).click();
    }
}
