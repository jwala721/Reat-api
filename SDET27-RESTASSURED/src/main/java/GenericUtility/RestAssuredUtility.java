package GenericUtility;

import io.restassured.response.Response;
/**
 * 
 * @author JWALA KUMAR
 *
 */

public class RestAssuredUtility {
	
	public String getJSONData(Response resp, String jsonPath)
	{
		String jsonData = resp.jsonPath().get(jsonPath);
		return jsonData;
	}

}
