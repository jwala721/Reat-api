package com.testCase;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoLibrary.PojoClassEmployee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateUser {
	
	@Test
	public void create() {
		int randomNumber = new Random().nextInt(500);
		String proName = "nithesh"+randomNumber;
		PojoClassEmployee pojo = new PojoClassEmployee("SDET", "25/05/1999", "nithesh@gmail.com", proName, 15, 9888777657L , "hdfc", "ROLE_ADMIN", "nithesh" );
	
		Response resp = given()
		.body(pojo)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/employees");
		String projectName = resp.jsonPath().get("username");
	resp.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(600L), TimeUnit.SECONDS)
		.log().all();
		
	
	
	}

}
