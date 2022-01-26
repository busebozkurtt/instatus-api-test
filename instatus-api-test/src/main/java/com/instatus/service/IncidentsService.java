package com.instatus.service;

import static com.instatus.spec.ResponseSpec.getResponseSpec;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.instatus.pojo.Incident;
import com.instatus.pojo.Statuses;
import com.instatus.spec.RequestSpec;

import io.restassured.response.Response;

public class IncidentsService extends RequestSpec{
	
	public  String incidentId;
	public Incident incident;
	
	private void createIncident() {
		List<String> components = new ArrayList<String>();
		List<Statuses> statuses = new ArrayList<Statuses>();

		components.add(ComponentsService.componentId);
 		Statuses statuse = new Statuses("ckf01fvnxywz50a35nh1qzssm", "OPERATIONAL");
 		statuses.add(statuse);

		incident = new Incident("Test incident","We're currently investigating an issue with the Website"
				,components,"2020-09-12 05:38:47.998", "INVESTIGATING", true, statuses);
	}
	
	public Response getAllIncidents(int status_code, String petId) {
		   
		   Response res = given()
				   .spec(getRequestSpec())
				   .pathParam("pageId", petId)
				   .when()
				   .get("{pageId}/incidents")
				   .then()
				   .spec(getResponseSpec(status_code))
				   .extract()
				   .response();
		   
		   List<String> ids = res.body().path("id");
		   incidentId = ids.get(0);
		   
		   return res;
	   }
	
	public Response getIncident (int status_code, String pageId) {
		   
		   return given()
				   .spec(getRequestSpec())
				   .pathParam("pageId", pageId)
				   .pathParam("incidentId", incidentId)
				   .when()
				   .get("{pageId}/incidents/{incidentId}")
				   .then()
				   .spec(getResponseSpec(status_code))
				   .extract()
				   .response();
	   }
	
	public Response positiveAddIncident (int status_code, String pageId) {
		
		createIncident();
		
		return given()
				.spec(getRequestSpec())
				.body(incident)
				.pathParam("pageId", pageId)
				.when()
				.post("/{pageId}/incidents")
				.then()
				.spec(getResponseSpec(status_code))
				.extract()
				.response();
	}
	
	public Response negativeAddIncident (int status_code, String pageId) {
				
		return given()
				.spec(getRequestSpec())
				.pathParam("pageId", pageId)
				.when()
				.post("/{pageId}/incidents")
				.then()
				.spec(getResponseSpec(status_code))
				.extract()
				.response();
	}
}
