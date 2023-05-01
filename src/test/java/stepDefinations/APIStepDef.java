package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIDataBuilder;
import resources.APIPaths;
import utils.APIUtils;
import utils.TestContext;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.Assert;

import BaseClass.Base;

public class APIStepDef extends Base {
	JsonPath js;
	Response response;
	RequestSpecification reqSpec;
	
	static String place_id;
	
	TestContext context;
	
	APIUtils utils=new APIUtils();
	APIDataBuilder dataPayload = new APIDataBuilder();
	
	public APIStepDef(TestContext context) {
		this.context=context;
	}


	@Given("I set Add Place api payload with {string} and {string} and {string} and {string}")
	public void i_set_api_add_place_api_payload_with_and_and(String name, String phone_no, String address, String language) throws IOException {

		reqSpec=utils.requestSpec();

		reqSpec= given().spec(reqSpec).log().all()
				.body(dataPayload.addPlaceDataPayload(name, phone_no,language, address));

	}
	
	@Given("I set Delete Place api payload with place_id")
	public void delete_place_api() throws IOException {

		reqSpec=utils.requestSpec();

		reqSpec= given().spec(reqSpec).log().all()
				.body(dataPayload.deletePlacePayload(place_id));

	}
	
	@Given("I set Get Place api payload with place_id")
	public void get_place_api() throws IOException {

		reqSpec=utils.requestSpec();

		reqSpec= given().spec(reqSpec).queryParam("place_id", place_id).log().all();

	}
	@When("I hit {string} api with {string} request")
	public void i_hit_api_with_request(String resource, String method) {
		
		APIPaths path=APIPaths.valueOf(resource);

		if(method.equalsIgnoreCase("POST")) {

			response=reqSpec.when().post(path.getAPIPath()).then().log().all().statusCode(200).extract().response();
		}

		if(method.equalsIgnoreCase("DELETE")) {
			
//			System.out.println("Fetched place id:"+ place_id);

			response=reqSpec.when().delete(path.getAPIPath()).then().log().all().statusCode(200).extract().response();
		}
		
		if(method.equalsIgnoreCase("GET")) {
			
//			System.out.println("Fetched place id:"+ place_id);

			response=reqSpec.when().get(path.getAPIPath()).then().log().all().statusCode(200).extract().response();
		}
		

	}
	@Then("I validate response status with status code {string}")
	public void i_validate_response_status_with_status_code(String status) {

		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, Integer.parseInt(status));
		
		// De-Serilization pojos classes for AddLocation API responses
		
		// AddPlaceResponses resp= response.as(AddPlaceResponses.class);
		// System.out.println("Place Id of the API: "+resp.getPlace_id());

	}
	@Then("I store value of response param {string} in {string} variable")
	public void store_resp_param_value(String param, String var) {		
		String paramValue;
		
		paramValue=utils.getJsonPath(response, param);
		
		//use this for context variables where ever required
		context.variables.put(var, paramValue);
		
	}
	
	@Then("I validate response param {string} with value {string}")
	public void i_validate_response_param_with_value(String param, String value) {

		
		place_id=utils.getJsonPath(response, "place_id");
//		System.out.println("Place Id created: "+place_id);
		
		String paramValue=utils.getJsonPath(response, param);
		Assert.assertEquals(paramValue, value);

	}
	
	@Then("I validate response param variable {string} value with {string}")
	public void validate_reponse_param_value_with_defined_value(String variableKey, String value) {
		
		String valueKey = context.variables.get(variableKey);
		
		Assert.assertEquals(valueKey, value);
		
		System.out.println("Validated !!");
		
	}

}
