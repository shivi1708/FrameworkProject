package E2EFrameWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.InitializeDriverTest;
import resources.landingPage;

public class ValidateTitleTest extends InitializeDriverTest{
	WebDriver driver;
	Logger log  = LogManager.getLogger(ValidateTitleTest.class.getName());
	@BeforeTest
	public void initialing() throws IOException 
	{
		driver= InitializeDriver();
		driver.get(prop.getProperty("URL1"));
		
	}
	
	@Test
	public void ValiteTitleTest() throws IOException
	{
		 
		landingPage lp = new landingPage(driver);
		String title= lp.getTitle().getText();
	    log.info("Fething the title");
		Assert.assertEquals(title, "FEATURED COURSES");
		log.info("Title matched");
	}
	@AfterTest
	public void closeDriver() 
	{
		driver.close();
		
	}
	
	
}
