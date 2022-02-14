package com.testCase;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoLibrary.PojoClassEmployee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class createAndDeleteUSerTest {
	
	@Test
	public void createDeleteUSer() {
		
		int randomNumber = new Random().nextInt(500);
		String proName = "Airtel"+randomNumber;
		
		
		
	
		PojoClassEmployee empDetails = new PojoClassEmployee("SDET", "25/05/1999", "nithesh@gmail.com", "nithesh", 15, 9888777657L, proName, "ROLE_ADMIN", "nithesh" );
		 Response resp = given()
			.body(empDetails)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/employees");
		resp.then()
		
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(201)
			.time(Matchers.lessThan(2200L), TimeUnit.MILLISECONDS);
			
		
		String empid=resp.jsonPath().get("employeeId");
		System.out.println(empid);
		given()
		.pathParam("userID", empid)
		
		.contentType(ContentType.JSON)
		.get("http://localhost:8084/employees/{userID}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2200L), TimeUnit.MILLISECONDS)
		.log().all();
		
			
	}

}
