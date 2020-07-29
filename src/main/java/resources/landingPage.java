package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	WebDriver driver;
	public landingPage(WebDriver driver) 
	{
		
		this.driver = driver;
	}
	By title= By.xpath("//h2[text()='Featured Courses']");
	By homeLink = By.linkText("Home");
	
	public WebElement getTitle() 
	{
		return driver.findElement(title);
		
	}
	public WebElement getHomeLink() {
		
		return driver.findElement(homeLink);
		
	}

}
