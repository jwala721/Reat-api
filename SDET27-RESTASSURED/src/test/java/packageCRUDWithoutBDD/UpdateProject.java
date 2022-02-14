package packageCRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	
	
	public void updateProject(){
		  //step1-1 create test data
			JSONObject jobj=new JSONObject();
			jobj.put("created by", "jwala");
			jobj.put("projectName", "gig");
			jobj.put("status", "completed");
			jobj.put("teamSize", 12);
			
			//step-2 provide requestSpecification
			
			RequestSpecification req = RestAssured.given();
			req.contentType(ContentType.JSON);
			req.body(jobj);
			
			//step-3 prform the action
			
			Response resp = req.put("http://localhost:8084/projects/TY_PROJ_1002");
			//step-4 verify
			
			ValidatableResponse validate = resp.then();
			validate.assertThat().statusCode(200);
			validate.log().all();
			
	}

}
