package com.instatus.service;

import static com.instatus.spec.ResponseSpec.getResponseSpec;
import static io.restassured.RestAssured.given;

import com.instatus.spec.RequestSpec;

import io.restassured.response.Response;

public class SubscribersService extends RequestSpec{
	
	public String subscriberId;
	
	public Response addSubscriber (int status_code, String pageId) {
		
		String subscriber = "{\n"
				+ "  \"email\": \"buse@instatus.com\",\n"
				+ "  \"all\": true,\n"
				+ "  \"autoConfirm\": false\n"
				+ "}";
		
		Response res = given()
				.spec(getRequestSpec())
				.pathParam("pageId", pageId)
				.body(subscriber)
				.when()
				.post("{pageId}/subscribers")
				.then()
				.spec(getResponseSpec(status_code))
				.extract()
				.response();
		
		subscriberId = res.path("id");
		return res;
	}

	public Response getSubscribers(int status_code, String pageId) {
		
		return given()
				.spec(getRequestSpec())
				.pathParam("pageId", pageId)
				.when()
				.get("{pageId}/subscribers")
				.then()
				.spec(getResponseSpec(status_code))
				.extract()
				.response();
	}
	
	public Response deleteSubscriber(int status_code, String pageId) {
		
		return given()
				.spec(getRequestSpec())
				.pathParam("pageId", pageId)
				.pathParam("subscriberId", subscriberId)
				.when()
				.delete("{pageId}/subscribers/{subscriberId}")
				.then()
				.spec(getResponseSpec(status_code))
				.extract()
				.response();
	}
}
