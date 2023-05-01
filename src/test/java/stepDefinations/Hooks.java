package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;

import BaseClass.Base;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.opentelemetry.context.Context;
import utils.TestContext;

public class Hooks extends Base {

	TestContext context;

	public Hooks(TestContext context) {
		this.context=context;
	}

	@After
	public void afterScenario() {
		System.out.println("Executing after scenario");

		//print all context variables stored
		System.out.println("Context variables stored till the scenario: "+context.variables);

		try {
			driver.quit();
		}
		catch (Exception e) {
			System.out.println("No chrome driver invoked...Can't close.");
		}

	}

	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException {

		//take screenshot after step fails
		if(scenario.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source= ts.getScreenshotAs(OutputType.FILE);

			byte[] fileContent = FileUtils.readFileToByteArray(source);

			scenario.attach(fileContent, "image/png", "image");
		}
	}

//	@AfterAll
//	public void printContextVariables() {
//
//		//print all context variables stored
//
//		System.out.println("After Test....");
//		System.out.println("All context variables stored: "+context.variables);
//	}

}
