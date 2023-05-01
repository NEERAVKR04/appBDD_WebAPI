package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.Base;

public class offersPage extends Base {
	
	@FindBy(xpath=("//a[text()='Top Deals']"))
	WebElement topDeals;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement offerSearch;
	
	public offersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void goToTopDeals() throws InterruptedException {
		topDeals.click();
		Thread.sleep(1000);
	}
	
	public void searchOfferProd(String prodName) throws InterruptedException {
		offerSearch.sendKeys(prodName);
		Thread.sleep(1000);
	}
	
	

}
