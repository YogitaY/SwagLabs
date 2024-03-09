package com.Swag.ActionI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterfaces {
	public void fluentWait(WebDriver driver,WebElement element, int timeOut);
	public void fluentWaitVisibility(WebDriver driver,WebElement element, int timeOut);
	public boolean JSClick(WebDriver driver, WebElement ele);

}
