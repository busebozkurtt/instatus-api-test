package com.instatus.service;

import static com.instatus.spec.ResponseSpec.getResponseSpec;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;

import com.instatus.spec.RequestSpec;

import io.restassured.response.Response;


public class ComponentsService extends RequestSpec{

	public HashMap<String, Object> componentMap = new HashMap<String, Object>();
	public static String componentId;
	
	private void createComponent() {
		componentMap.put("name", "Test component");
		componentMap.put("description", "Testing");
		componentMap.put("status", "OPERATIONAL");
		componentMap.put("order", 6);
		componentMap.put("showUptime", true);
		componentMap.put("grouped", false);
	}
	
	public Response addComponent(int status_code, String pageId) {

		createComponent();
		
		return given()
				.spec(getRequestSpec())
				.body(componentMap)
				.pathParam("pageId", pageId)
				.when()
				.post("/{pageId}/components")
				.then()
				.spec(getResponseSpec(status_code))
				.extract()
				.response();
	}
	
   public Response getAllComponent(int status_code, String pageId) {
	   
	   Response res = given()
			   .spec(getRequestSpec())
			   .pathParam("pageId", pageId)
			   .when()
			   .get("/{pageId}/components")
			   .then()
			   .spec(getResponseSpec(status_code))
			   .extract()
			   .response();
	   
	   List<String> ids = res.body().path("id");
	   componentId = ids.get(3);
	   return res;
   }
	
   public Response getComponent (int status_code, String pageId) {
	   
	   return given()
			   .spec(getRequestSpec())
			   .pathParam("pageId", pageId)
			   .pathParam("componentId", componentId)
			   .when()
			   .get("/{pageId}/components/{componentId}")
			   .then()
			   .spec(getResponseSpec(status_code))
			   .extract()
			   .response();
   }
	
   public Response deleteComponent (int status_code, String pageId) {
	   
	   return given()
			   .spec(getRequestSpec())
			   .pathParam("pageId", pageId)
			   .pathParam("componentId", componentId)
			   .when()
			   .delete("/{pageId}/components/{componentId}")
			   .then()
			   .spec(getResponseSpec(status_code))
			   .extract()
			   .response();
   }
}
