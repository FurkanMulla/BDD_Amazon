package amazonPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	@FindBy(xpath = "//div[@id='nav-cart-count-container123']")
	private WebElement cartIcon;
	
	@FindBy(xpath = "//*[@class='a-carousel-card']//img[@alt='op123']")
	private WebElement smartphones;
	
	@FindBy(xpath = "(//span[text()='Smartphones'])[2]")
	private WebElement resultText;
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	private WebElement signInHowver;
	
	@FindBy(xpath = "(//span[text()='Sign in'])[1]")
	private WebElement signInButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Sign in')]")
	private WebElement signInText;
	
	WebDriverWait wait;
	Actions act;
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		act = new Actions(driver);
	}
	public String fetchTitle()
	{
		String titleOfPage = driver.getTitle();
		return titleOfPage;
	}
	public boolean verifyCartIcon()
	{
		boolean isDisplay = cartIcon.isDisplayed();
		return isDisplay;
	}
	public void clickOnSmartphone()
	{
		wait.until(ExpectedConditions.visibilityOf(smartphones)); 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click",smartphones);
	//	smartphones.click();
		
	}
	public boolean verifyResult() {
		wait.until(ExpectedConditions.visibilityOf(smartphones));
		boolean isDisplay = smartphones.isDisplayed();
		return isDisplay;

	}
	public void hoverOnSignIn()
	{
		act.moveToElement(signInHowver).perform();
		
	}
	public void clickOnSignIn()
	{
		signInButton.click();
	}
	public String verifySignInText()
	{
		String text = signInText.getText();
		return text;
	}
	

}
