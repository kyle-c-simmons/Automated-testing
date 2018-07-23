package com.ks.restAssured;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.equalTo;

public class RestTesting {
	
	@Before
	public void setup() {

	}
	
	private RequestSpecification request; 
	private ValidatableResponse json;
	private Response response;
	
	
	/// GUARDIANS ///
	
	@Given("^a film exists with the Title Guardians of the Galaxy Two$")
	public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two() {
		request = given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
	public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy_Two() {
		response = request.when().get("http://www.omdbapi.com/?apikey=50075cee&t=Guardians+of+the+Galaxy");

	}

	@Then("^the status code reads (\\d+)$")
	public void the_status_code_reads(int arg1) {
		json = response.then().statusCode(200);
	    System.out.println("response: " + response.prettyPrint());

	}

	// IT //////
	
	@Given("^a film exists with the Title IT$")
	public void a_film_exists_with_the_Title_IT() {
		request = given().contentType(ContentType.JSON);
		expect().
        statusCode(200).
        body("Title", equalTo("IT"));
     
	}

	@When("^a user retrieves the film by the title IT$")
	public void a_user_retrieves_the_film_by_the_title_IT() {
		response = request.when().get("http://www.omdbapi.com/?apikey=50075cee&t=IT");
	}

	@Then("^the Rated Field is equal to R$")
	public void the_Rated_Field_is_equal_to_R() {
		expect().
		statusCode(200).
		body("Rated", equalTo("R"));
	    System.out.println("response: " + response.prettyPrint());
	}
	
	
	// HOP /////
	
	
	@Given("  Given a film exists with the Title HOP$")
	public void a_film_exists_with_the_Title_HOP() {
		request = given().contentType(ContentType.JSON);
		expect().
        statusCode(200).
        body("Title", equalTo("Hop"));
     
	}

	@When("^a user retrieves the film by the title HOP$")
	public void a_user_retrieves_the_film_by_the_title_HOP() {
		response = request.when().get("http://www.omdbapi.com/?apikey=50075cee&t=Hop");
	}

	@Then("^the Rated Field is equal to PG$")
	public void the_Rated_Field_is_equal_to_PG() {
		expect().
		statusCode(200).
		body("Rated", equalTo("PG"));
	    System.out.println("response: " + response.prettyPrint());

	}
	
	
	// Multiple
	
	
	@Given("^a film exists with the Title \"([^\"]*)\"$")
	public void a_film_exists_with_the_Title(String arg1) {
		request = given().contentType(ContentType.JSON);
	}
	
	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
	public void a_user_retrieves_the_film_by_the_title(String arg1) {

			response = request.when().get("http://www.omdbapi.com/?apikey=50075cee&t=%s" + arg1);
		

	}

	@Then("^the Rated Field is equal to \"([^\"]*)\"$")
	public void the_Rated_Field_is_equal_to(String arg1) {
	
			expect().
			statusCode(200).
			body(
				"Title", equalTo(arg1),
				"Rated", equalTo(arg1)
			);
		
	    System.out.println("response: " + response.prettyPrint());

	}


	
	

}
