package packageCRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	
	@Test
	
	public void deleteProject() {
		
		int expStatus=204;
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_003");
		
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(expStatus, actStatus);
		System.out.println(resp.prettyPrint());
		
		
	}
	

}
