package stepDefinations;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.asynchttpclient.webdav.WebDavCompletionHandlerBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ActionsUtils.ActionUtils;
import BaseClass.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.offersPage;
import utils.TestContext;

import org.junit.Assert;

public class OffersPageStepDef extends Base {

	TestContext context;

	public OffersPageStepDef(TestContext context) {
		this.context=context;
	}


	@When("I go to top deals offer page and search {string} product")
	public void i_go_to_top_deals_offer_page(String shortName) throws InterruptedException {
		//		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();

		offersPage op = new offersPage();
		op.goToTopDeals();
		Thread.sleep(2000);

		ActionUtils act = new ActionUtils();

//		act.switchWindow();
		act.switchToWindowIndex(1);

		//search product
//		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		
		op.searchOfferProd(shortName);
		
		Thread.sleep(2000);
		String getFullName = driver.findElement(By.xpath("//td[1]")).getText();
		//System.out.println(getFullName);
		//System.out.println(context.getFullProdName);

		Assert.assertEquals(context.getFullProdName,getFullName);

	}

}
