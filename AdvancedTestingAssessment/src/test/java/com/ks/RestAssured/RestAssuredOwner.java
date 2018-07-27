package com.ks.RestAssured;

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

public class RestAssuredOwner {
	
	private RequestSpecification request; 
	private ValidatableResponse json;
	private Response response;
	public JSONObject requestParams;
	
	@Before
	public void setup() {
		request = given().contentType(ContentType.JSON);
	}
	
	@After
	public void teardown() {
		
	}
	
	@Test
	public void getOwner() {
		response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners");
		json = response.then().statusCode(200);
	}
	
	@Test
	public void postOwner() {
		
		// JSON 
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/owners";
		requestParams = new JSONObject();
		
		// put into json object
		requestParams.put("address", "1 manchetser road");
		requestParams.put("city", "manchester");
		requestParams.put("firstName", "Kyle");
		requestParams.put("id", 120);
		requestParams.put("lastName", "S");
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/pets/1";
		requestParams.put("telephone", "2432664");

		request.body(requestParams.toString());

		response = request.post("http://10.0.10.10:9966/petclinic/api/owners");
	}

	@Test
	public void getOwnerLastName() {
		response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners/5");
		json = response.then().statusCode(200);
	}
	
	@Ignore @Test
	public void deleteOwnerById() {
		response = request.when().delete("http://10.0.10.10:9966/petclinic/api/owners/120");
		json = response.then().statusCode(200);
	}
	
	@Test
	public void getOwnerById() {
		response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners/5");
		json = response.then().statusCode(200);
	}
	
	@Test
	public void putOwnerById() {
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/owners/1";
		requestParams = new JSONObject();
		
		// put into json object
		requestParams.put("address", "1 manchetser road");
		requestParams.put("city", "manchester");
		requestParams.put("firstName", "Kyle");
		requestParams.put("id", 1);
		requestParams.put("lastName", "S");
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/pets/1";
		requestParams.put("telephone", "2432664");

		request.body(requestParams.toString());
		
		response = request.post("http://10.0.10.10:9966/petclinic/api/owners");
	}
}
