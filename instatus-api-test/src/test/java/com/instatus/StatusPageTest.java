package com.instatus;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StatusPageTest extends BaseServiceTest{

	public static String pageId;

	@Test(priority = 1)
	public void getPagesRequest() {
		Response response = statusPage.getPages(200);
		Map<String, String> resMap = (Map<String, String>) response.jsonPath().getList("").get(0);
		pageId = resMap.get("id");
		Assert.assertEquals(resMap.get("name"), "buse");
		Assert.assertEquals(resMap.get("subdomain"), "buseinstatus");
	}
	
	@Test(priority = 2)
	public void putPageRequest() {
		Response response = statusPage.updatePage(200, pageId);
		assertThat(response.body().path("id"), equalTo(pageId));
	}
}
