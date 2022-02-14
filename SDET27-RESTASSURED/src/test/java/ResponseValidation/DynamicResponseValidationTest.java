package ResponseValidation;

import static org.testng.Assert.assertEquals;

import java.util.List;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DynamicResponseValidationTest {
	
	@Test
	public void verify() {
		String expectedProjectName="hell";
		Response response=when()
				.get("http://localhost:8084/projects");
		List<String> proNames = response.jsonPath().get("projectName");
		boolean flag =false;
		for (String pNmaes : proNames) {
			try {
				if(pNmaes.equals(expectedProjectName)) {
					flag=true;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		response.then()
		.assertThat()
		.contentType(ContentType.JSON).and().statusCode(200)
		.log().all();	
		Assert.assertEquals(flag, true);
		}

}
