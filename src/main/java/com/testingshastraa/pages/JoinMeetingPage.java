package com.testingshastraa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastraa.keywords.UIkeywords;

public class JoinMeetingPage {
	UIkeywords keyword = UIkeywords.getInstance();

	// other way to create POM*********
	// public By quickJoinMeetingTitle = By.cssSelector("div#navbarContent
	// li:nth-child(1)");
	// public void getQuickJoinMeetingtitle() {
	// return keyword.driver.findElement(quickJoinMeetingTitle).getText();
	// }

	
	@FindBy(css = "div.joinmeeting")
	public WebElement quickJoinMeetingtitle;

	public JoinMeetingPage() {
		PageFactory.initElements(keyword.driver, this);
	}

	public String getQuickJoinMeetingtitle() {
		return quickJoinMeetingtitle.getText();
	}
}
