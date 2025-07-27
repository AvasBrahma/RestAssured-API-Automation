package com.api.base;

import static io.restassured.RestAssured.*;

import java.util.Map;

import com.api.filters.LoggingFilters;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	//BaseURI
	private static final String BASE_URL="http://localhost:3000";
	private RequestSpecification requestSpecification;
	
	static {
		RestAssured.filters(new LoggingFilters());
	}
	
	public BaseService() {
		requestSpecification=given().baseUri(BASE_URL);
		 
	}
	
	protected void setBearerAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer "+token);
	}
	
	protected void setQueryParams(Map<String, String> queryParams) {
	    for (Map.Entry<String, String> entry : queryParams.entrySet()) {
	        requestSpecification.queryParam(entry.getKey(), entry.getValue());
	    }
	}
	
	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}
	
}
