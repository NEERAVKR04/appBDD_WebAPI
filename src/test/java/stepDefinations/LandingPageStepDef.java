package stepDefinations;

import java.io.IOException;
import ActionsUtils.ActionUtils;
import BaseClass.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.landingPage;
import utils.Log4J;
import utils.TestContext;

import org.junit.Assert;

public class LandingPageStepDef extends Base {
	
	public String getFullProdName;
	TestContext context;
	ActionUtils actionUtils;
//	Log4J log;
	
	public LandingPageStepDef(TestContext context) {
		this.context=context;
	}
	
	@Given("I open web browser") 
	public void i_open_web_browser() throws IOException {
		
	    System.out.println("Browser open step");
	    launchBrowser();
	    actionUtils = new ActionUtils();
//	    actionUtils.waitImplicitly(30);
	    
//	    log=new Log4J();
	    
//	    logging.info()
	    
	}
	
	@When("I browse to url {string} from properties and I validate title with {string}")
	public void i_browse_to_url_from_properties(String variable, String title) throws IOException {
	    
		actionUtils = new ActionUtils();
		actionUtils.openApplication(variable);
	    
	    String homeTitle = actionUtils.getTitle();
	    System.out.println(".."+homeTitle);
	    Assert.assertEquals(homeTitle, title); 
	    
	}
	
	@When("I browse to  url {string} from properties and I validate title with {string}")
	public void i_browse_to_url_from_properties_and_i_validate_title_with(String string, String string2) {
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("I search {string} product on object {string} of homepage")
	public void i_search_product_on_object_of_homepage(String shortName, String objectName) throws InterruptedException {
	    
	    landingPage lpObject=new landingPage();
	    lpObject.productSearch(shortName);
	    Thread.sleep(2000);
	    context.getFullProdName=lpObject.getProductName();
	    context.getFullProdName=context.getFullProdName.split("-")[0].trim();
	    System.out.println(context.getFullProdName);
	    
	}
	
	@When("I close current browser window")
	public void close_current_browser_window() {
		System.out.println("Closing current browser window...");
		driver.quit();
	}
	
}
