package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class InitializeDriverTest {

	
	 public  WebDriver driver;
	
	public Properties prop;
	

	public WebDriver InitializeDriver() throws IOException 
	{
		prop= new Properties();
		FileInputStream fis = new FileInputStream("D:\\selenium\\E2EFrameWorkTesting\\src\\main\\java\\resources\\GlobalValues.properties");
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Desktop\\kamal\\chromedriver.exe");
			driver =  new ChromeDriver(); 
			
		}
		else if(browser.equals("Firefox")) 
		{
			
			System.setProperty("webdriver.gecko.driver", "D:\\selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browser.equals("ie")) 
		{
			System.setProperty("webdriver.ie.driver", "D:\\selenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		return driver;
		
	}
	
  public void getScreenshot(String methodName) throws IOException 
  {
	  String DestinationFile = System.getProperty("user.dir")+"//resources//"+methodName+".png";
	  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(DestinationFile));

	  
  }

}

	
     
