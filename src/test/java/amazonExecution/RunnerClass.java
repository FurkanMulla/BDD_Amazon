package amazonExecution;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\AmazonFeatureFile\\HomePage.feature"},
		glue = {"amazonExecution"},
		publish = true,
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//tags = "@sanity"
		)

public class RunnerClass extends AbstractTestNGCucumberTests
{
	

}
