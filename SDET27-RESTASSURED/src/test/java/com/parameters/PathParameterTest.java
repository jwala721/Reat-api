package com.parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PathParameterTest {
	@Test
	
	public void param() {
		String proId="TY_PROJ_004";
		given()
			.pathParam("projectId", proId)
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		.then()
			.log().all();
		
	}

}
