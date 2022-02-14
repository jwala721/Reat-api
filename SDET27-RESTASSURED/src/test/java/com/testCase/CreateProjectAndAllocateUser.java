package com.testCase;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import PojoLibrary.PojoClassEmployee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateProjectAndAllocateUser {
	
	@Test
	public void create() {
		int randomNumber = new Random().nextInt(500);
		String proName = "Airtel"+randomNumber;
		PojoClass pojo = new PojoClass("deepak", proName, "Completed", 12);
		
		Response resp = given()
				.body(pojo)
				.contentType(ContentType.JSON)
			.when()
				.post("http://localhost:8084/addProject");
				String projectName = resp.jsonPath().get("projectName");
			resp.then()
				.assertThat().statusCode(201)
				.contentType(ContentType.JSON)
				.time(Matchers.lessThan(600L), TimeUnit.SECONDS)
				.log().all();
			
			Assert.assertEquals(projectName, proName);
			Reporter.log("data Verified succesfully",true);
				
			
		
		PojoClassEmployee pojo1 = new PojoClassEmployee("SDET", "25/05/1999", "nithesh@gmail.com", "nithesh", 15, 9888777657L, proName, "ROLE_ADMIN", "nithesh" );
	
		Response resp1 = given()
				.body(pojo1)
				.contentType(ContentType.JSON)
			.when()
				.post("http://localhost:8084/employees");
				String projectName1 = resp1.jsonPath().get("username");

				resp1.then()
				.assertThat().statusCode(201)
				.contentType(ContentType.JSON)
				.time(Matchers.lessThan(600L), TimeUnit.SECONDS)
				.log().all();
				
	}
}


