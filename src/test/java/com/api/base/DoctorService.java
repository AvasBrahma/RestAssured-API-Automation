package com.api.base;

import java.util.HashMap;
import java.util.Map;

import com.api.models.request.DoctorRegisterReq;

import io.restassured.response.Response;

public class DoctorService extends BaseService {
	
	private static final String BASE_PATH="/doctors";
	
	
	public Response register(DoctorRegisterReq docRegisterReq) {
		return postRequest(docRegisterReq, BASE_PATH+"/register");
	}
	
	public Response login(String username, String password) {
		Map<String, String> queryParams = new HashMap<String, String>();
	    queryParams.put("username", username);
	    queryParams.put("password", password);
	    setQueryParams(queryParams);
		return getRequest(BASE_PATH+"/login");
	}

}
