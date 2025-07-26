package login.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.DoctorService;
import com.api.models.request.DoctorRegisterReq;
import com.api.models.response.DoctorRegisterResponse;

import io.restassured.response.Response;

public class DoctorTest {
	

     @Test(description="Validate doctor able to register or not")
     public void testRegister() {
    	 
    	 DoctorRegisterReq docReq=new DoctorRegisterReq("DDTD", "DDTD ", "AB123");
    	 DoctorService docService=new DoctorService();
    	 Response res=docService.register(docReq);
    	 System.out.println(res.asPrettyString()); 
    	 DoctorRegisterResponse docRegisRes= res.as(DoctorRegisterResponse.class); // return DoctorRegisterResponse object
    	 System.out.println("isRegister : "+ docRegisRes.isRegistered());
    	 Assert.assertTrue(docRegisRes.isRegistered()==true);
     }
}
