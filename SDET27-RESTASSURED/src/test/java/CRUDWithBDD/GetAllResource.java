package CRUDWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetAllResource {
	
	@Test
	
	public void getResource() {
		
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
	}

}
