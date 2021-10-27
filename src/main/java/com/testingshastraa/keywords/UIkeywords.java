package com.testingshastraa.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains UI keywords which are applicable for WebElement and
 * general actions This is a singleton class ,to create object of this class
 * ,use{@code getInstance()}
 * 
 * @author Priyanka Vaibhav Pendse
 *
 */

public class UIkeywords {
	public RemoteWebDriver driver = null;
	private static UIkeywords uikeywords;
	static {
		uikeywords = new UIkeywords();
	}

	public static UIkeywords getInstance() {
		return uikeywords;
	}

	private UIkeywords() {
	}

	/**
	 * This keyword is used to launched the specified browser.
	 * 
	 * @param browserName must be one of the following
	 *                    <ul>
	 *                    <li>chrome</li>
	 *                    <li>firefox</li>
	 *                    <li>ie</li>
	 *                    <li>safari</li>
	 *                    </ul>
	 */

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Invalid browser name: " + browserName);
		}
	}

	public void closeBrowse() {
		driver.close();

	}

	public void quitBrowser() {
		driver.quit();

	}

	public void launchUrl(String url) {
		driver.get(url);

	}

	public void click(WebElement element) {
		element.click();

	}

	public void enterText(WebElement element, String textToEnter) {
		element.sendKeys(textToEnter);

	}
	/**
	 * In next version if framework,this method will be deleted .Insted you can use enterText(String object, String text
	 * @param locatorType
	 * @param locatorValue
	 * @param textToEnter
	 */

	@Deprecated
	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);

	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;

		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));

		}

		if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("class")) {
			element = driver.findElement(By.className(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("tag")) {
			element = driver.findElement(By.tagName(locatorValue));

		}
		return element;
	}

	public void switchToFrameAt(int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);

	}

	public void switchTodefaultContent() {
		driver.switchTo().defaultContent();

	}

	public String getTitleOfpage() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

	public void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public void enterText(String object, String textToEnter) {
		String[] parts = object.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);

	}

}
