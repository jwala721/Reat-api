package WaysToPostRequest;


import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class CreateAResourceUsingHashMapTest {
	
	@Test
	public void created()
	{
		HashMap map = new HashMap();
		
		map.put("createdBy", "jwalakkk");
		map.put("projectName", "helll");
		map.put("stauts", "Created");
		map.put("teamSize", 1234);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	
	
		
	}
}
