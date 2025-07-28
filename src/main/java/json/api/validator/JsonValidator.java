package json.api.validator;
import org.json.JSONObject;

public class JsonValidator {
	
	public static void validateJsonResponse(String responseBody, String jsonPath, String expectedValue) {
        JSONObject json = new JSONObject(responseBody);

            if(json.has(jsonPath)) {
               String actualValue=json.get(jsonPath).toString();
               if(actualValue==expectedValue) {
            	   System.out.println("Validation Passed:  Expected : "+expectedValue+" and Actual value : "+actualValue);
               }else {
                 System.out.println("Validation Fail, Mismatch Expected : "+expectedValue+" and Actual value : "+actualValue);
               }
            }else {
            	System.out.println("JSON does not contain path: " + jsonPath);
            }
           
	}

}
