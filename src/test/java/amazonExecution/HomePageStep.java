package amazonExecution;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import amazonBase.DriverFactory;
import amazonPOM.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStep {
	
	HomePage homePage= new HomePage(DriverFactory.returnDriver());
	
	@Given("User is at landing page")
	public void user_is_at_landing_page() {
		WebDriver driver=DriverFactory.returnDriver();
		driver.get("https://www.amazon.in/");
	}
	@Then("Page title should contains {string}")
	public void page_title_should_contains(String titleText) {
		String title =homePage.fetchTitle();
		boolean isPresent = title.contains(titleText);
		Assert.assertTrue(isPresent); 
	}

	@Then("Cart icon should get displayed")
	public void cart_icon_should_get_displayed() {
		boolean isdisplay = homePage.verifyCartIcon();
	    Assert.assertTrue(isdisplay);
	}

	@When("User click on smartphones deal")
	public void user_click_on_smartphones_deal() {
	    homePage.clickOnSmartphone();
	}

	@Then("Deal section should get open")
	public void deal_section_should_get_open() 
	{
	   boolean isDisplayed = homePage.verifyResult();
	   Assert.assertEquals(isDisplayed, true);
	}

	@When("User hover on sign in")
	public void user_hover_on_sign_in() {
	    homePage.hoverOnSignIn();
	}

	@When("click on sign in button")
	public void click_on_sign_in_button() {
	    homePage.clickOnSignIn();
	}

	@Then("sign in page should get open")
	public void sign_in_page_should_get_open() {
	    String signInText = homePage.verifySignInText();
	    Assert.assertEquals(signInText, "Sign in");
	}

}
