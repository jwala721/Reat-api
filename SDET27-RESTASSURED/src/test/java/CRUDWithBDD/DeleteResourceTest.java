package CRUDWithBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteResourceTest {
	
	@Test
	public void delete() {
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_1202")
		.then()
			.assertThat().statusCode(204)
			.log().all();
		
	}

}
