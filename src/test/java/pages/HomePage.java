package pages;

import static driver.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helpers.WaitHelpers;

public class HomePage extends BasePage {

	private final String pageUrl = "/dashboard/index";
	private By header = By.cssSelector(".oxd-topbar-header-title h6");
	private By searchBar = By.cssSelector(".oxd-main-menu-search input");
	private By menuOptions = By.cssSelector(".oxd-main-menu li span");

	public String getPageUrl() {
		return pageUrl;
	}

	public void typeOnSearchBar(String text) {
		getDriver().findElement(searchBar).sendKeys(text);
	}

	public void verifyAllOptionsArePresent() {
		List<String> expectedOptions = Arrays.asList(
				"Admin", "PIM", "Leave", "Time", "Recruitment", 
				"My Info", "Performance","Dashboard","Directory",
				"Maintenance", "Claim", "Buzz");
		List<WebElement> options = getDriver().findElements(menuOptions);
		
		for (WebElement element : options) {
			String elementText = element.getText();
			Assertions.assertTrue(expectedOptions.contains(elementText));
		}
		
	}

	public void verifyHeaderIsPresent() {
		Assertions.assertTrue(WaitHelpers.WaitForElementToBePresent(getDriver(), header).isDisplayed());
	}
	
	public void searchForASpecificMenuOption(String option) {
		WaitHelpers.WaitForElementToBeClickable(getDriver(), searchBar);
		getDriver().findElement(searchBar).sendKeys(option);
	}
	
	public void verifyMenuOptionIsDisplayedAndShowCorrectOption(String option) {
		WebElement menuOption = getDriver().findElement(menuOptions);
		Assertions.assertTrue(menuOption.isDisplayed());
		String text = menuOption.getText();
		Assertions.assertTrue(text.equals(option));
		
	}
}
