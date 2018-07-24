package com.ks.SpingRestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;



public class Testing {
	
	private RequestSpecification request; 
	private ValidatableResponse json;
	private Response response;
	private JSONObject requestParams;
	
	@Before
	public void setup() {
		request = given().contentType(ContentType.JSON);
	}
	
	@After
	public void teardown() {
		
	}
		
	// POST
	@Test
	public void postSwagger() {
		
		// JSON 
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels";
		requestParams = new JSONObject();
		
		// put into json object
		requestParams.put("id", "1");
		requestParams.put("city", "Manchester");
		requestParams.put("description", "This is a test");
		requestParams.put("name", "ANTHIA");
		requestParams.put("rating", 10);
		request.body(requestParams.toString());

		response = request.post("http://localhost:8090/example/v1/hotels/");


		System.out.println(response.getStatusCode() + " push");
		
	}
	
	// DELETE
	@Test
	public void deleteSwagger() {
		request = given().contentType(ContentType.JSON);
		response = request.delete("http://localhost:8090/example/v1/hotels/13");
		System.out.println(response.getStatusCode() + " delete");
	}
	
	// GET
	@Test
	public void getSwagger() {
		response = request.when().get("http://localhost:8090/example/v1/hotels?page=1&size=100");
		json = response.then().statusCode(200);
	
		System.out.println(response.getStatusCode() + " get");
	}
	
	// PUT
	@Test
	public void putSwagger() {
		request = given().contentType(ContentType.JSON);
		requestParams = new JSONObject();
		
		requestParams.put("id", "20");
		requestParams.put("city", "London");
		requestParams.put("description", "This is a test");
		requestParams.put("name", "ANTHIA");
		requestParams.put("rating", 10);
		
		request.body(requestParams.toString());

		response = request.put("http://localhost:8090/example/v1/hotels/20");
		response = request.get("http://localhost:8090/example/v1/hotels/20");

		System.out.println(response.getStatusCode() + " put");

	}
	
	
	
	
}
