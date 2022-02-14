package packageCRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Createproject {
	
	@Test
	public void createProject(){
	  //step1-1 create test data
		JSONObject jobj=new JSONObject();
		jobj.put("created by", "jwala");
		jobj.put("projectName", "gig");
		jobj.put("status", "created");
		jobj.put("teamSize", 12);
		
		//step-2 provide requestSpecification
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		//step-3 prform the action
		
		Response resp = req.post("http://localhost:8084/addProject");
		//step-4 print in the console and verify
		
		System.out.println(resp.asPrettyString());
		System.out.println(resp.asString());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.getContentType());
		System.out.println(resp.prettyPeek());
		
		
		
	}

}
