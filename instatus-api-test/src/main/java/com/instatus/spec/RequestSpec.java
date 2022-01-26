package com.instatus.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
	
	String baseUrl = "https://api.instatus.com";
	String basePath = "/v1";
	String apiKey = "b6622abd465a28b7f0980dfa3a78921e";
	String pageId = "ckyt8zadw1466379yllsi76huhb";
	
	public RequestSpecification getRequestSpec() {
		return new RequestSpecBuilder()
				.setBaseUri(baseUrl)
				.setBasePath(basePath)
				.addHeader("Authorization", "Bearer " + apiKey)
				.setContentType("application/json")
				.log(LogDetail.ALL)
				.build();
	}

}
