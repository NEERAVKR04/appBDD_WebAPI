package cucumber.Options;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="/Users/b0221715/Downloads/app/src/test/java/Features",glue="stepDefinations",monochrome = true, dryRun = false
,tags = "@apiTests or @deletePlaceId or @getPlaceId", plugin = {"html:target/cucumber.html","json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class testNGRunner extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel = true)
//	
//	synchronized public Object[][] scenarios(){
//		return super.scenarios();
//	}

}
