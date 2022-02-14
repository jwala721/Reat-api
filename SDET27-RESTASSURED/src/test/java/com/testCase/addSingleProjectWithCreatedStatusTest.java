package com.testCase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class addSingleProjectWithCreatedStatusTest {
	
	@Test
	
	public void createSingleProject() {
		Random ran = new Random();
		int randomNumber = ran.nextInt(500);
		
JSONObject jobj=new JSONObject();
		
		jobj.put("created by", "jwala1");
		jobj.put("createdOn", "string");
		jobj.put("projectName", "hulk7521"+randomNumber);
		jobj.put("status", "Created");
		jobj.put("teamSize", 12);
		
		Response res = given()
		.body(jobj)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject");
		res.then()
		.assertThat().statusCode(201)
		.log().all();//.body()
		//.extract().response();
		
		String jsonString = res.asString();
		Assert.assertEquals(jsonString.contains("Created"), true);
		
	}

}
