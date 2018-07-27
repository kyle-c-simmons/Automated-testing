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

public class RestAssuredPet {
	
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
	public void getPets() {
		response = request.when().get("http://10.0.10.10:9966/petclinic/api/pets");
		json = response.then().statusCode(200);
	}
	
	@Test
	public void postPet() {
		
		// JSON 
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/pets";
		requestParams = new JSONObject();
				
		requestParams.put("birthDate", "2018-07-20837");
		requestParams.put("id", "0");
		requestParams.put("name", "petName");
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/owners/4";

		request.body(requestParams.toString());
		response = request.post("http://10.0.10.10:9966/petclinic/api/pets");
		

	}

	@Test
	public void getPetType() {
		response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners/5");
		json = response.then().statusCode(200);
	}
	
	@Ignore @Test
	public void deletePetById() {
		response = request.when().delete("http://10.0.10.10:9966/petclinic/api/owners/10");
		json = response.then().statusCode(200);
	}
	
	@Test
	public void getPetById() {
		response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners/5");
		json = response.then().statusCode(200);
	}
	
	@Test
	public void putPetById() {
		// JSON 
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/pets/5";
		requestParams = new JSONObject();
								
		requestParams.put("birthDate", "2018-07-20837");
		requestParams.put("id", "5");
		requestParams.put("name", "petName");
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/owners/4";

		request.body(requestParams.toString());
		response = request.post("http://10.0.10.10:9966/petclinic/api/pets");
	}
}
