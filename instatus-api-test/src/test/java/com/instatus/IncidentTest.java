package com.instatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class IncidentTest extends BaseServiceTest {

	@Test(priority = 1)
	public void positivePostIncidentRequest() {
		Response response = incident.positiveAddIncident(200, StatusPageTest.pageId);
		assertThat(response.path("name"), equalTo(incident.incident.getName()));
		assertThat(response.body().path("status"), equalTo(incident.incident.getStatus()));
		assertThat(response.path("notify"), equalTo(incident.incident.isNotify()));
	}

	@Test(priority = 2)
	public void getAllIncidentRequest() {
		Response response = incident.getAllIncidents(200, StatusPageTest.pageId);
		assertThat(response.jsonPath().getList(""), hasSize(greaterThan(0)));
	}

	@Test(priority = 3)
	public void getIncidentRequest() {
		Response response = incident.getIncident(200, StatusPageTest.pageId);
		assertThat(response.path("id"), equalTo(incident.incidentId));
	}

	@Test(priority = 4)
	public void negativePostIncidentRequest() {
		incident.negativeAddIncident(403, StatusPageTest.pageId);
	}
}
