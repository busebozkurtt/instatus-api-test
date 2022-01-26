package com.instatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class SubscriberTest extends BaseServiceTest{

	@Test (priority = 1)
	public void postSubscriberRequest() {
		Response response = subscriber.addSubscriber(200, StatusPageTest.pageId);
		Assert.assertEquals(response.path("email"), "buse@instatus.com");
		assertThat(response.path("confirmed"), equalTo(false));
	}
	
	@Test (priority = 2)
	public void getSubcribersRequest() {
		Response response = subscriber.getSubscribers(200, StatusPageTest.pageId);
		assertThat(response.jsonPath().getList("id"), hasItem(subscriber.subscriberId));
	}
	
	@Test (priority = 3)
	public void deleteSubscriberRequest() {
		Response response = subscriber.deleteSubscriber(200, StatusPageTest.pageId);
		assertThat(response.path("id"), equalTo(subscriber.subscriberId));
	}
}
