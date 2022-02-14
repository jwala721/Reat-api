package CRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;
public class UpdateTest {
	@Test
	
	public void update() {
		Random ran= new Random();
		int randomNumber = ran.nextInt(500);		
		
		
		JSONObject jobj=new JSONObject();
		jobj.put("created by", "Raushan");
		jobj.put("projectName", "gig"+randomNumber);
		jobj.put("status", "created");
		jobj.put("teamSize", 121);
		
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1202")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
		
	}

}
