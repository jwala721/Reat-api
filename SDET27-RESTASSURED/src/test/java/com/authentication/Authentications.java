package com.authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Authentications {
	@Test
	
	public void preemptiveAuth() {
		given()
			.auth().preemptive().basic("rmgyantra", "rmgy@9999")
			.when()
			.get("http://localhost:8084/login")
		.then()
			.assertThat().statusCode(202)
			.log().all();
			
		}
	@Test
	public void digestiveAuth() {
		given()	
			.auth().digest("rmgyantra", "rmgy@9999")
			.when()
			.get("http://localhost:8084/login")
		.then()
			.assertThat().statusCode(202)
			.log().all();
	}

}
