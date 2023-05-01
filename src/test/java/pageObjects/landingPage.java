package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.Base;

public class landingPage extends Base {
	
	@FindBy (xpath=("//input[@type='search']"))
	WebElement prodSearch;
	
	@FindBy (css = "h4.product-name")
	WebElement prodName;
	
	public landingPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void productSearch(String value) {
		prodSearch.click();
		prodSearch.sendKeys(value);
	}
	
	public String getProductName() {
		return prodName.getText();
	}
	

}
