package com.rmgyantra.Test;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseAPIClass;
import GenericUtility.EndPoints;
import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateResourceAndVerifyInDtabase extends BaseAPIClass{
	
	@Test
	public void createResourceAndVerifyInDbTest() throws Throwable {
		
		//Step 1: create test data
		PojoClass pojo = new PojoClass("nimi4", "nimi project4" + jLib.getRandomNum(), "Completed", 40);
		
		//Step 2: execute post request
		Response resp = given()
						.body(pojo)
						.contentType(ContentType.JSON)
					.when()
						.post(EndPoints.createProject);
		
		//Step 3: capture the project id from response
		String expData = rLib.getJSONData(resp, "projectId");
		System.out.println(expData);
		
		//Step 4: verify in db
		String query = "select * from project;";
		String actData = dLib.executeQueryAndGetData(query, 1, expData);
		Reporter.log(actData,true);
		
		Assert.assertEquals(expData, actData);
		Reporter.log("data verification succesfull", true);
		
		

		}
	}


