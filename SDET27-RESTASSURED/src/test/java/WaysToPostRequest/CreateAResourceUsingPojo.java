package WaysToPostRequest;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateAResourceUsingPojo {
	
	@Test
	
	public void create() {
		PojoClass pojo = new PojoClass("jwalaaa", "IronMan", "completed", 100);
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
				
		
	}

}
