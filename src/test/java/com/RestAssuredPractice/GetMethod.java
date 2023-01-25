package com.RestAssuredPractice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;
public class GetMethod {
	
	@Test
	public void test1_get_method() {
		
		given().get("https://reqres.in/api/users?page=2").then().
		statusCode(200). 
		body("data.id[0]", equalTo(7)). 
		body("data.email", hasItems("michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "tobias.funke@reqres.in")). 
		log().all();
	}
	
	
	@Test
	public void test2_get_method() {
		given().get("https://jsonplaceholder.typicode.com/users").then(). 
		statusCode(200). 
		body("id[0]", equalTo(1)). 
		body("name[0]", equalTo("Leanne Graham")). 
		log().all();
	}

}
