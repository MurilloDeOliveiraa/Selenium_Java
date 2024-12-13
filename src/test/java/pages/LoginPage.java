package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.WaitHelpers;

public class LoginPage extends BasePage {

	private final String pageUrl = "/login";
	private By usernameInput = By.cssSelector("input[name='username']");
	private By passwordInput = By.cssSelector("input[name='password']");
	private By loginButton = By.cssSelector("button");
	private By messageError = By.cssSelector("[class*='alert--error']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void clickOnLoginButton() {
		getDriver().findElement(loginButton).click();
	}
	
	public void enterCredentials(String email, String password) {
		WaitHelpers.WaitForElementToBePresent(getDriver(), loginButton);
		getDriver().findElement(usernameInput).sendKeys(email);
		getDriver().findElement(passwordInput).sendKeys(password);
		this.clickOnLoginButton();
	}
	
	public void verifyErrorMessageIsPresent() {
		Assertions.assertTrue(WaitHelpers.WaitForElementToBePresent(getDriver(), messageError).isDisplayed());
	}
	
	
	

}
