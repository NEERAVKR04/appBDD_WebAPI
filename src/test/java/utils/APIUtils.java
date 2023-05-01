package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import BaseClass.Base;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIUtils extends Base {

	public static RequestSpecification requestSpec;

	public RequestSpecification requestSpec() throws IOException {

		if(requestSpec==null) {
			
			PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));

			requestSpec=new RequestSpecBuilder().addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setBaseUri(getProperties().getProperty("apiBaseUrl")).setContentType(ContentType.JSON).build();
			
			return requestSpec;
		}
		return requestSpec;
	}
	
	public String getJsonPath(Response response,String key) {
		
		JsonPath js=new JsonPath(response.asString());
		return js.getString(key);
		
	}

}
