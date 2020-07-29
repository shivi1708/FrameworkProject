package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {

	WebDriver driver;
	public PageObjects(WebDriver driver) 
	{
		this.driver = driver;
		
	}
	
	By username = By.id("login1");
	By password = By.id("password");
	By submit = By.cssSelector("input[type ='submit']");

	public WebElement Username() 
	{
		return driver.findElement(username);
		
	}
	public WebElement Password() 
	{
		return driver.findElement(password);
		
	}
	public WebElement Submit() 
	{
		return driver.findElement(submit);
		
	}
}
