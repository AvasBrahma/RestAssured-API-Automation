package com.api.filters;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilters implements Filter{
	
	private static final Logger logger=LogManager.getLogger(LoggingFilters.class);

	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
	       logRequest(requestSpec);
	       Response response=ctx.next(requestSpec, responseSpec);// request is going to execute
	       logResponse(response);
		return response;
	}
	//FilterableRequestSpecification : provide the information of the request
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("Base URI: "+requestSpec.getBaseUri());
		logger.info("Request Header: "+requestSpec.getHeaders());
		logger.info("Request Body: "+requestSpec.getBody());
	}
	
	public void logResponse(Response response) {
		logger.info("Response Status: {}", response.getStatusCode());
        logger.info("Response Body: {}", response.getBody().asString());
		logger.info("Response Header: "+response.getHeaders());
		
	}

}
