package com.testingshastra.uitests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastraa.keywords.UIkeywords;
import com.testingshastraa.pages.HomePage;
import com.testingshastraa.pages.JoinMeetingPage;

public class HomePageTests2 extends BaseClass {
	UIkeywords keyword = UIkeywords.getInstance();

	public void verifiTitleOfHomePage() {
		String expectedTitle = "IJmeet";
		Assert.assertEquals(keyword.driver.getTitle(), expectedTitle);

	}

	@Test
	public void verifyIfUserRedirectsToJoinMeetingPage() {
		HomePage home = new HomePage();
		home.clickOnJoinMeetingTab();
		JoinMeetingPage joinmeeting = new JoinMeetingPage();
		String actual = joinmeeting.getQuickJoinMeetingtitle();
		Assert.assertTrue(actual.contains("Quick"));

	}

	@Test
	public void printAllInfoLinks() {
		HomePage home = new HomePage();
		home.getTextLinkOfInfoLinks();
	}

}
