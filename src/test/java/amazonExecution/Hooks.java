package amazonExecution;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import amazonBase.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks 
{
	//WebDriver driver;
	@Before
	public void launchBrowser() throws IOException
	{
//		Properties prop = new Properties();
//		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
//		
//		FileInputStream file = new FileInputStream(path);
//		prop.load(file);
//				
//		df = new DriverFactory();
//		String browserName = prop.getProperty("browser");
//		String maven_browser=System.getProperty("clibrowser");
//		if(maven_browser!=null)
//		{
//			browserName=maven_browser;
//		}
		DriverFactory df = new DriverFactory();
		WebDriver driver=df.initBrowser("edge");
		driver.manage().window().maximize();
	}
	@After
	public void closeBrowser()
	{
		WebDriver driver = DriverFactory.returnDriver();
		  driver.quit();
	}

}
