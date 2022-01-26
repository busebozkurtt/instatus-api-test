package com.instatus.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {

	public static ResponseSpecification getResponseSpec(int status_code) {
		return new ResponseSpecBuilder()
				.expectStatusCode(status_code)
				.log(LogDetail.ALL)
				.build();
	}
}
