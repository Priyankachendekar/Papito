package com.testingshastra.uitests.homepagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastraa.keywords.UIkeywords;

public class HomePageTests extends BaseClass {

	String expectedTitle = "Testing Shastra | Training | Placement";
	UIkeywords keyword = UIkeywords.getInstance();

	@Test
	public void toVerifyHomepageTitle() {
		keyword.launchUrl("https://www.testingshastra.com");
		String title = keyword.getTitleOfpage();
		Assert.assertEquals(title, expectedTitle);// to check obj eql or not(AssertionError without a message is thrown)

	}

}
