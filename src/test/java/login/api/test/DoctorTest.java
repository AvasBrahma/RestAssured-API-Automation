package login.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.DoctorService;
import com.api.models.request.DoctorRegisterReq;
import com.api.models.response.DoctorRegisterResponse;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import json.api.validator.JsonValidator;



@Listeners(com.api.listeners.TestListener.class)
public class DoctorTest {
	

     @Test(description="Validate doctor able to register or not")
     public void testRegister() {
    	 
    	 DoctorRegisterReq docReq=new DoctorRegisterReq("DD1 DD", "DD1 DD", "AB123");
    	 DoctorService docService=new DoctorService();
    	 Response res=docService.register(docReq);
    	// System.out.println(res.asPrettyString()); 
    	 DoctorRegisterResponse docRegisRes= res.as(DoctorRegisterResponse.class); // return DoctorRegisterResponse object
    	 System.out.println("isRegister : "+ docRegisRes.isRegistered());
    	 Assert.assertTrue(docRegisRes.isRegistered()==true);
     }
     

     @Test(description="Validate if doctor is already register")
     public void testAlreadyRegister() {
    	 
    	 DoctorRegisterReq docReq=new DoctorRegisterReq("DD79", "DD79", "AB123");
    	 DoctorService docService=new DoctorService();
    	 Response res=docService.register(docReq);
    	 System.out.println(res.asPrettyString());
    	 Assert.assertEquals(res.statusCode(),200);
    	 Assert.assertEquals(res.getStatusCode(), 200);
    	 System.out.println("Status Code: "+res.statusCode());
    	 System.out.println("Get Status Code: "+res.getStatusCode());
    	 JsonPath jsonPath=res.jsonPath();
    	 System.out.println("Registered :"+jsonPath.getBoolean("isRegistered"));
    	 System.out.println("message :"+jsonPath.getString("message"));
    	 JsonValidator.validateJsonResponse(res.getBody().asString(), "isRegistered", "true");
    	 JsonValidator.validateJsonResponseUsingJSONPath(res.getBody().asString(), "data.fullname", "DD79");
    	 

     }

}
