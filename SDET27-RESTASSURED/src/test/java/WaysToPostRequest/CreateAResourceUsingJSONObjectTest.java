package WaysToPostRequest;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateAResourceUsingJSONObjectTest {
	@Test
	
	public void create() {
	Random ran = new Random();
	int randomNumber = ran.nextInt(500);
	
	
	JSONObject jobj=new JSONObject();
	jobj.put("created by", "jwala");
	jobj.put("projectName", "gig"+randomNumber);
	jobj.put("status", "created");
	jobj.put("teamSize", 12);
	
	given()
		.body(jobj)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	
		
	}
	
   

}
