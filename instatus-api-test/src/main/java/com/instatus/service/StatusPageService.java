package com.instatus.service;

import static com.instatus.spec.ResponseSpec.getResponseSpec;
import static io.restassured.RestAssured.given;

import java.io.File;

import com.instatus.spec.RequestSpec;

import io.restassured.response.Response;

public class StatusPageService extends RequestSpec{

	public Response getPages(int status_code) {
		return given()
				.spec(getRequestSpec())
				.when()
				.get("/pages")
				.then()
				.spec(getResponseSpec(status_code))
				.extract()
				.response(); 
	}
	
	public Response updatePage(int status_code, String pageId) {
		
		File page = new File ("src/main/resources/StatusPage.json");
		
		return given()
				.spec(getRequestSpec())
				.body(page)
				.pathParam("pageId", pageId)
				.when()
				.put("/{pageId}")
				.then()
				.spec(getResponseSpec(status_code))
				.extract()
				.response();
	}
}
