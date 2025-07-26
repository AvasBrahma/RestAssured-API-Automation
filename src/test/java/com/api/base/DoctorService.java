package com.api.base;

import com.api.models.request.DoctorRegisterReq;

import io.restassured.response.Response;

public class DoctorService extends BaseService {
	
	private static final String BASE_PATH="/doctors";
	
	
	public Response register(DoctorRegisterReq docRegisterReq) {
		return postRequest(docRegisterReq, BASE_PATH+"/register");
	}

}
