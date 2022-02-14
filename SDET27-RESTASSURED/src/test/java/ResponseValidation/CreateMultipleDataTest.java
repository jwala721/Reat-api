package ResponseValidation;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

public class CreateMultipleDataTest {
	@Test(dataProvider = "getData")
	public void create(String createdBy,String projectName, String status, int teamSize) {
		PojoClass pojo = new PojoClass(createdBy, projectName, status, teamSize);
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
	@DataProvider
	public Object[][] getData() {
		Object[][] objArray = new Object[2][4];
		objArray[0][0]="Niru";
		objArray[0][1]="Nishu project123";
		objArray[0][2]="Completed";
		objArray[0][3]=123;
				
		objArray[1][0]="Nirmala";
		objArray[1][1]="Nishu project321";
		objArray[1][2]="Completed";
		objArray[1][3]=30;
		
		return objArray;
	}
}