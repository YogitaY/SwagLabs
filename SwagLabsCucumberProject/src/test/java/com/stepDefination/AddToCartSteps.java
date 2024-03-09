package com.stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.swagLabs.ActionDriver.Action;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class AddToCartSteps {
	Action action = new Action();
	WebDriver driver;
	@Given("User is on home page")
	public void user_is_on_home_page() {
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
	}

	@When("User click on Swag Lab Bag to veiw product details")
	public void user_click_on_sauce_labs_backpack_to_veiw_sauce_labs_backpack_details() {
		System.out.println("Step 2: user is click on product to veiw details");
		WebElement product1 = driver.findElement(By.id("item_4_title_link"));
		action.fluentWaitVisibility(driver, product1, 50);
		action.JSClick(driver, product1);
	}

	@And("Click on Add To cart button")
	public void click_on_add_to_cart_button() {
		System.out.println("Step 3: user is click on Add to cart button");
	    WebElement AddtoCartbtn = driver.findElement(By.xpath("//button[text()='Add to cart']"));
	    action.fluentWaitVisibility(driver, AddtoCartbtn, 50);
	    AddtoCartbtn.click();
	}

	@Then("User able to add products in Add to cart")
	public void user_able_to_add_products_in_add_to_cart() {
		System.out.println("Step 4: user is on Add to cart Page");
	    WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
	    action.fluentWait(driver, cartIcon, 50);
	    String AddToCartProduct= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
	    System.out.println("Product added is "+ AddToCartProduct);
	    Assert.assertEquals("Sauce Labs Backpack", AddToCartProduct);
	    System.out.println("product added successfuly");
	    driver.quit();
	}

}
