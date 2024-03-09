package com.stepDefination;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.swagLabs.ActionDriver.Action;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class LoginSteps {
	Action action = new Action();
	WebDriver driver;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Step1: user is on Login Page");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		System.out.println("Welcome to log in page");   
	}

	@When("user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) {
		System.out.println("Step2: user entering username and password");
		WebElement username1 = driver.findElement(By.id("user-name"));
		action.fluentWaitVisibility(driver, username1, 50);
		username1.sendKeys(username);
		
		WebElement password1 = driver.findElement(By.id("password"));
		action.fluentWaitVisibility(driver, password1, 50);
		password1.sendKeys(password);
	}

	@And("click on login button")
	public void click_on_login_button() {
		System.out.println("Step3: user clicking on login button");
	    WebElement loginBtn = driver.findElement(By.id("login-button"));
	    action.fluentWait(driver, loginBtn, 50);
	}

	@Then("user should land on Home page")
	public void user_should_land_on_home_page() {
	    System.out.println("step4:user lands on Home page");
	    String url1 = driver.getCurrentUrl();
	    System.out.println(url1);
	    Assert.assertEquals("https://www.saucedemo.com/inventory.html", url1);
	    driver.quit();
	}


}
