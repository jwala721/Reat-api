package com.testCase;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class addProjectWitONGoingStatus {
	
	@Test
	
	public void onGoingProject() {
		
		Random ran = new Random();
		int randomNumber = ran.nextInt(500);
		
JSONObject jobj=new JSONObject();
		
		jobj.put("created by", "jwala1");
		jobj.put("createdOn", "string");
		jobj.put("projectName", "hulk7521"+randomNumber);
		jobj.put("status", "On Going");
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
		Assert.assertEquals(jsonString.contains("On Going"), true);
		
		
		
	}

}
