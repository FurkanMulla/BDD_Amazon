package amazonBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory 
{
	static WebDriver driver;
	
	public WebDriver initBrowser(String browserName) {

		if(browserName=="chrome") {
			driver = new ChromeDriver();
		}else if(browserName=="firefox"){
			driver = new FirefoxDriver();
		}else if(browserName=="edge"){
			driver = new EdgeDriver();
		}
		return driver;
	}
	public static WebDriver returnDriver() {
		
		return driver;
	}
	
	

}
