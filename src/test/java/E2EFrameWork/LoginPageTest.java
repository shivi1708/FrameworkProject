package E2EFrameWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import resources.InitializeDriverTest;
import resources.PageObjects;

public class LoginPageTest  extends InitializeDriverTest {
	WebDriver driver;
	Logger log;
	
	@BeforeTest
	public void initialing() throws IOException 
	{
		driver= InitializeDriver();
		driver.get(prop.getProperty("URL"));
		log= LogManager.getLogger(LoginPageTest.class.getName());
	 
	}
	@Test
	public void LoginPageTest() {
	PageObjects po= new PageObjects(driver);
	po.Username().sendKeys("user");
	log.info("Entered Username");
	po.Password().sendKeys("pass");
	log.info("Entered password");
	po.Submit().click();
	log.info("Clicked on Submit button");
	
	}
	@AfterTest
	public void closeDriver() 
	{
		driver.close();
		
	}
	
}
