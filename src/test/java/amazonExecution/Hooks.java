package amazonExecution;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import amazonBase.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks 
{
	WebDriver driver;
	@Before
	public void launchBrowser() throws IOException
	{
		Properties prop = new Properties();
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		
//		FileInputStream file = new FileInputStream(path);
//		prop.load(file);
//				
//		df = new DriverFactory();
//		String browsername = prop.getProperty("browser");
//		String maven_browser=System.getProperty("clibrowser");
//		if(maven_browser!=null)
//		{
//			browserName=maven_browser;
//		}
		DriverFactory df = new DriverFactory();
		driver=df.initBrowser("edge");
	//	driver.manage().window().maximize();
	}
	
	@After(order=2)
	public void screenShot(Scenario scenario)
	{
		boolean isfail = scenario.isFailed();
		if(isfail)
		{
			String scenarioName = scenario.getName();
			String screenShotName = scenarioName.replaceAll(" ", "_");
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", screenShotName);
		}
	}
	@After(order=1)
	public void closeBrowser()
	{
		WebDriver driver = DriverFactory.returnDriver();
		  driver.quit();
	}

}
