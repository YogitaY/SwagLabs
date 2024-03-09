package com.stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.swagLabs.ActionDriver.Action;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class CheckoutSteps {

	Action action = new Action();
	WebDriver driver;

	@Given("User is on add to cart page")
	public void user_is_on_add_to_cart_page() {
		System.out.println("Step1: user is on Home Page");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		System.out.println("Welcome to log in page");  
		
		WebElement username1 = driver.findElement(By.id("user-name"));
		action.fluentWaitVisibility(driver, username1, 50);
		username1.sendKeys("standard_user");
		
		WebElement password1 = driver.findElement(By.id("password"));
		action.fluentWaitVisibility(driver, password1, 50);
		password1.sendKeys("secret_sauce");
		
		WebElement loginBtn = driver.findElement(By.id("login-button"));
	    action.fluentWait(driver, loginBtn, 50);
	    
	    WebElement product1 = driver.findElement(By.id("item_4_title_link"));
		action.JSClick(driver, product1);
		
		WebElement AddtoCartbtn = driver.findElement(By.xpath("//button[text()='Add to cart']"));
	    action.fluentWaitVisibility(driver, AddtoCartbtn, 50);
	    AddtoCartbtn.click();
	    
	    WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
	    action.fluentWait(driver, cartIcon, 50);
	}

	@When("User click on checkout butoon")
	public void user_click_on_checkout_butoon() {
		System.out.println("Step 2: user is click on checkout button");
		WebElement checkoutbtn = driver.findElement(By.id("checkout"));
		action.fluentWait(driver, checkoutbtn, 50);
		
	}

	@And("User enters FirstName, LastName and Address")
	public void user_enters_first_name_last_name_and_address() {
		System.out.println("Step 3: user enters FirstName, LastName and Address");
		WebElement fname = driver.findElement(By.id("first-name"));
		action.fluentWaitVisibility(driver, fname, 50);
		fname.sendKeys("Elon");
		driver.findElement(By.id("last-name")).sendKeys("Musk");
		driver.findElement(By.id("postal-code")).sendKeys("USA");
		driver.findElement(By.id("continue")).click();
	}

	@And("User click on finish button")
	public void user_click_on_finish_button() {
		System.out.println("Step 4: user click on finish button");
		WebElement finishBtn = driver.findElement(By.id("finish"));
		action.fluentWait(driver, finishBtn, 50);
	}

	@Then("User Completed ordering product")
	public void user_completed_ordering_product() {
		System.out.println("Step 5: User Completed ordering product");
		String ActualConfirmationMsg = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();
		String ExpectedMsg = "Thank you for your order!";
		System.out.println("ExpectedMsg "+ExpectedMsg+"ActualConfirmationMsg "+ActualConfirmationMsg);
		Assert.assertEquals(ExpectedMsg, ActualConfirmationMsg);
		driver.quit();
	}

}
