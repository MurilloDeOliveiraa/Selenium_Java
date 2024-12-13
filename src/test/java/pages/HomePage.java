package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.WaitHelpers;

public class HomePage extends BasePage {
	
	private final String pageUrl = "/dashboard/index";
	private By header = By.cssSelector(".oxd-topbar-header-title h6");
	

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getPageUrl() {
		return pageUrl;
	}
	
	public void verifyHeaderIsPresent() {
		Assertions.assertTrue(WaitHelpers.WaitForElementToBePresent(getDriver(), header).isDisplayed());
	}
}
