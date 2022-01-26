package com.instatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class ComponentTest extends BaseServiceTest{
	
	@Test (priority = 1)
	public void postComponentRequest() {
		Response response = components.addComponent(200, StatusPageTest.pageId);
		Assert.assertEquals(response.path("name"), components.componentMap.get("name"));
		Assert.assertEquals(response.path("status"), components.componentMap.get("status"));
	}
	
	@Test (priority = 1)
	public void getAllComponentsRequest() {
		Response response = components.getAllComponent(200, StatusPageTest.pageId);
        assertThat(response.jsonPath().getList(""), hasSize(greaterThan(0)));
	}
	
	@Test (priority = 2)
	public void getComponentRequest() {
		Response response = components.getComponent(200, StatusPageTest.pageId);
        assertThat(response.path("id"), equalTo(components.componentId));
	}
	
	@Test (priority = 3)
	public void deleteComponentRequest() {
		Response response = components.deleteComponent(200, StatusPageTest.pageId);
		assertThat(response.path("id"), equalTo(components.componentId));
	}
}
