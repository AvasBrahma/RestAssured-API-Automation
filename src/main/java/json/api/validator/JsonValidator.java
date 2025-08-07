package json.api.validator;
import org.json.JSONObject;
import com.jayway.jsonpath.JsonPath;
import org.testng.Assert;

public class JsonValidator {
	
	
	//JSON Path value validation using JSON Objects
	public static void validateJsonResponse(String responseBody, String jsonPath, String expectedValue) {
		try {
	        JSONObject json = new JSONObject(responseBody);
	        String[] pathParts = jsonPath.split("\\.");
	        Object current = json;

	        for (String key : pathParts) {
	            if (current instanceof JSONObject && ((JSONObject) current).has(key)) {
	                current = ((JSONObject) current).get(key);
	            } else {
	                System.out.println("JSON does not contain path: " + jsonPath);
	                return;
	            }
	        }

	        String actualValue = current.toString();
	        if (actualValue.equals(expectedValue)) {
	            System.out.println("Validation Passed: Expected: " + expectedValue + ", Actual: " + actualValue);
	        } else {
	            System.out.println("Validation Failed: Mismatch. Expected: " + expectedValue + ", Actual: " + actualValue);
	        }
	    } catch (Exception e) {
	        System.out.println("Error while validating JSON: " + e.getMessage());
	    }

           
	}
	

    // json path validation using
	public static void validateJsonResponseUsingJSONPath(String responseBody, String jsonPath, String expectedValue) {
	    try {
	        String actualValue = JsonPath.read(responseBody, "$." + jsonPath).toString();

	        if (actualValue.equals(expectedValue)) {
	            System.out.println("Validation Passed: Expected: " + expectedValue + ", Actual: " + actualValue);
	        } else {
	            //System.out.println("Validation Failed: Mismatch. Expected: " + expectedValue + ", Actual: " + actualValue);
	            Assert.assertEquals(actualValue, expectedValue, "Validation Failed");
	        }
	    } catch (Exception e) {
	        System.out.println("Error extracting value with path: " + jsonPath + " => " + e.getMessage());
	    }
	}


}
