package com.api.base;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	//BaseURI
	private static final String BASE_URL="http://localhost:3000";
	private RequestSpecification requestSpecification;
	
	public BaseService() {
		requestSpecification=given().baseUri(BASE_URL);
		 
	}
	
	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
}
