package login.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.DoctorService;
import com.api.base.PatientService;
import com.api.models.request.PatientRegisterReq;
import com.api.models.response.DoctorLoginResponse;

import io.restassured.response.Response;

public class PatientTest {
	
	
	@Test(description="Verify Patient is able to register or not")
	void register() {
		/* In Oder to create new patient register first doctor needs to login and
		 * generate the authorization token then only new patient can be register
		 *  with the help of the token. */
		
		DoctorService docService=new DoctorService();
		
		Response resDc=docService.login("manthan","123");
		System.out.println(resDc.asPrettyString());
		DoctorLoginResponse docLoginRes=resDc.as(DoctorLoginResponse.class);
		Assert.assertTrue(docLoginRes.getIsAuthenticated()==true);
		String token=docLoginRes.getToken();
		PatientRegisterReq patientRegisReq=new PatientRegisterReq.Builder()
				.name("RK")
				.dateofbirth("1997-11-24")
				.gender("M")
				.phone("2222332233").build();
		
		
		PatientService patientService=new PatientService();
		Response res=patientService.register(patientRegisReq, token);
		System.out.println(res.asPrettyString());			
		
	}

}
