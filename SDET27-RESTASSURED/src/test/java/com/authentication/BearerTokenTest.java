package com.authentication;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BearerTokenTest {
	
	@Test
	
	public void bearerAuth() {
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.assertThat().statusCode(200)
			.log().all();
		
	}

}
