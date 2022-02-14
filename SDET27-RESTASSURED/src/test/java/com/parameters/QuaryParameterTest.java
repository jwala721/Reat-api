package com.parameters;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class QuaryParameterTest {
	
	@Test
	
	public void param() {
		given()
			.queryParams("page", "8")
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}

}
