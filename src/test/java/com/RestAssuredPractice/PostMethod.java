package com.RestAssuredPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
public class PostMethod {
	
	@Test
	public void test1_post_method() {
		
		JSONObject request = new JSONObject();
		request.put("name", "XYZ");
		request.put("job", "QA");
		
		given().
		body(request.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();	
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test2_put_method() {
		
		JSONObject request = new JSONObject();
		request.put("name", "ABC");
		request.put("job", "Dev");
			
		given().
		body(request.toJSONString())
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();	
	}
	
	@Test
	public void test3_delete_method() {
		given()
		.delete("https://jsonplaceholder.typicode.com/users/11")
		.then()
		.statusCode(200);
	}

}
