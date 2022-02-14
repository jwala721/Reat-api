package com.RequestChaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingPostDeleteTest {
	@Test
	
	public void postDelete() {
		Random ran= new Random();
		int randomNumber = ran.nextInt(100);		
		
		
		JSONObject jobj=new JSONObject();
		jobj.put("created by", "jwala");
		jobj.put("projectName", "gig"+randomNumber);
		jobj.put("status", "created");
		jobj.put("teamSize", "12");
		
	   given()
			.body(jobj);
			Response response = when()
			.post("http://localhost:8084/addProject");
		
		//String proID = response.jsonPath().get(".projectId");
		//System.out.println(proID);
		
	}

}
