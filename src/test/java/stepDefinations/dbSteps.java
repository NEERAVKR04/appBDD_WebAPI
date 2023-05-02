package stepDefinations;

import java.io.IOException;

import BaseClass.Base;
import io.cucumber.java.en.Then;
import utils.TestContext;

public class dbSteps extends Base {
	
	TestContext context;
	
	public dbSteps(TestContext context) {
		this.context=context;
	}
	
	@Then("I set query {string}")
	public void i_set_query(String queryName) throws IOException {
		 context.query=getProperties().getProperty(queryName);
		 System.out.println(context.query);
	}
	
	@Then("I connect to db {string} using db query {string} and store output in variables {string}")
	public void i_connect_to_db_using_db_query_and_store_output_in_variables(String string, String string2, String string3) {
		
	}

}
