package com.rmgyantra.Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseAPIClass;
import GenericUtility.EndPoints;
import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UpdateResourceAndVerifyInDtabase extends BaseAPIClass{
	
	@Test
	public void updateResourceAndVerifyInDb() throws Throwable {
		
		
		//String proId = "TY_PROJ_008";
		PojoClass pojo = new PojoClass("jwalakkk", "helll", "Completed", 100);
		
		Response resp = given()
				.body(pojo)
				.contentType(ContentType.JSON)
				
			.when()
				.put(EndPoints.updateProjects+"/TY_PROJ_008");
		
		
		String expData = rLib.getJSONData(resp, "createdBy");
		System.out.println(expData);
	
		String query = "select * from project;";
		String actData = dLib.executeQueryAndGetData(query, 2, expData);
		Reporter.log(actData,true);
		
		Assert.assertEquals(expData, actData);
		Reporter.log("data verification succesfull", true);
		
	}
	}



