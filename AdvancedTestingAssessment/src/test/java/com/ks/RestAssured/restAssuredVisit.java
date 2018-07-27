package com.ks.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class restAssuredVisit {

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
	
	@Test
	public void getVisits() {
		response = request.when().get("http://10.0.10.10:9966/petclinic/api/visits");
		json = response.then().statusCode(200);
	}
	
	@Test
	public void postVisits() {
		
		// SETUP VISIT
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/visits";
		requestParams = new JSONObject();
				
		requestParams.put("date", "2018/05/05");
		requestParams.put("description", "This was a pet visit");
		requestParams.put("id", "0");
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/pets/5";

		request.body(requestParams.toString());
		response = request.post("http://10.0.10.10:9966/petclinic/api/visits");

	}

	@Ignore @Test
	public void deleteVisitByVisitId() {
		response = request.delete("http://10.0.10.10:9966/petclinic/api/visits/4");
	}
	
	@Test
	public void getVisitByVisitId() {
		response = request.get("http://10.0.10.10:9966/petclinic/api/visits/1");
	}
	
	
	@Test
	public void putVisitByVisitId() {
		// SETUP VISIT
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/visits/2";
		requestParams = new JSONObject();
				
		requestParams.put("date", "2018/05/05");
		requestParams.put("description", "This was a pet visit");
		requestParams.put("id", "2");
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/pets/8";

		request.body(requestParams.toString());
		response = request.post("http://10.0.10.10:9966/petclinic/api/visits");

	}
	

}
