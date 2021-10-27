package com.testingshastra.uitests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastra.util.Locator;

import com.testingshastraa.keywords.UIkeywords;

public class SignupPageTests extends BaseClass {
	private static final Logger LOG = Logger.getLogger(SignupPageTests.class);
	UIkeywords keywords = UIkeywords.getInstance();

	@Test
	public void validateFullNameFieldForCorrectInput() {
		String url = "https://ijmeet.com/";
		keywords.launchUrl(url);
		LOG.info("url is launched :"+url);
		// Approach 1
		// WebElement signup =
		// keywords.getDriver().findElement(By.cssSelector("li:nth-child(5)
		// a.nav-link"));
		// keywords.click(signup);
		// Approach 2
		keywords.click("css", "li:nth-child(5) a.nav-link");
		LOG.info("Click on register button");

		keywords.enterText(Locator.SIGNUP_FULLNAME, "Priya");
		keywords.enterText(Locator.SIGNUP_COMPANYNAME, "Testing shastra");
		keywords.enterText(Locator.SIGNUP_EMAILID, "info@testing.com");
		keywords.enterText(Locator.SIGNUP_MOBILENUMBER, "9758645825");
		keywords.enterText(Locator.SIGNUP_PASSWORD, "Test@123456");
		keywords.switchToFrameAt(0);
		LOG.info("Switched inside the frame");
		keywords.click("css", "div.recaptcha-checkbox-border");
		keywords.switchTodefaultContent();
		LOG.info("Back to parent frame");
		keywords.click("css", "button[type='submit']");
		String actualUrl = keywords.getCurrentUrl();
		// Assert.assertTrue(actualUrl.contains("dashboard"));
		System.out.println(actualUrl);

	}

}
