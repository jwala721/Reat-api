package com.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParametersTest {
	@Test
	
	public void params() {
		given()
			.pathParam("username", "jkkk")
			.queryParam("sort", "created")
			.queryParam("per_page", "100")
		.when()
			.get("https://api.github.com/users/{username}/repos")
		.then()
			.assertThat().statusCode(200)
			.log().all();
				
	}

}
