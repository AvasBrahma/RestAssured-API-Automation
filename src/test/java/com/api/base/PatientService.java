package com.api.base;

import com.api.models.request.PatientRegisterReq;

import io.restassured.response.Response;

public class PatientService extends BaseService{
	
private static final String BASE_PATH="/patients";
	
	
	public Response register(PatientRegisterReq patientRegisterReq, String token) {
		setBearerAuthToken(token);
		return postRequest(patientRegisterReq, BASE_PATH+"/register");
	}

}
