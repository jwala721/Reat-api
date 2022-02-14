package com.testCase;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddProjectWithDuplicateID {
	
	@Test
	
	public void addProjectwithDuolicateID() {
		
		JSONObject jobj=new JSONObject();
		
		jobj.put("created by", "jwala1");
		jobj.put("createdOn", "string");
		jobj.put("projectName", "hulk752");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 12);
		jobj.put("projectId", "TY_PROJ_212");
		
		
		Response resp = given()
		.body(jobj)  
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject");
		
	resp.then()
	.assertThat().statusCode(409)
	.log().all();//.body()
	//.extract().response();
	
	String jsonString = resp.asString();
	Assert.assertEquals(jsonString.contains("409"), true);
	System.out.println("Conflict");
		
		
	}

}
