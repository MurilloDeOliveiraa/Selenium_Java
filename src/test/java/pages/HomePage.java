package pages;

import static driver.DriverFactory.getDriver;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import helpers.WaitHelpers;

public class HomePage extends BasePage {
	
	private final String pageUrl = "/dashboard/index";
	private By header = By.cssSelector(".oxd-topbar-header-title h6");
	

	public String getPageUrl() {
		return pageUrl;
	}
	
	public void verifyHeaderIsPresent() {
		Assertions.assertTrue(WaitHelpers.WaitForElementToBePresent(getDriver(), header).isDisplayed());
	}
}
