package com.authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2 {
	
	@Test
	
	public void auths() {
		Response response = given()
		.formParams("client_id", "SDET27")
		.formParams("client_secret", "74bf09d166509e69ec50b263e037f3bc")
		.formParams("redirect_uri", "https://example.com")
		.formParams("grant_type", "client_credentials")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		String token = response.jsonPath().get("access_token");
		
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", "2775")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then()
		.log().all();
		
		
	}

}
