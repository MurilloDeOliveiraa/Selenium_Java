package pages;

import static driver.DriverFactory.getDriver;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import helpers.WaitHelpers;

public class LoginPage extends BasePage {

	private final String pageUrl = "/login";
	private By usernameInput = By.cssSelector("input[name='username']");
	private By passwordInput = By.cssSelector("input[name='password']");
	private By loginButton = By.cssSelector("button");
	private By messageError = By.cssSelector("[class*='alert--error']");
	private By requiredInputMessageError = By.cssSelector("div[class='oxd-form-row']:nth-child(2) span[class*='input-field-error-message']");

	public String getPageUrl() {
		return pageUrl;
	}

	public void clickOnLoginButton() {
		getDriver().findElement(loginButton).click();
	}
	
	public void enterCredentialsAndLogin(String email, String password) {
		WaitHelpers.WaitForElementToBePresent(getDriver(), loginButton);
		getDriver().findElement(usernameInput).sendKeys(email);
		getDriver().findElement(passwordInput).sendKeys(password);
		this.clickOnLoginButton();
	}
	
	public void verifyErrorMessageIsPresent() {
		Assertions.assertTrue(WaitHelpers.WaitForElementToBePresent(getDriver(), messageError).isDisplayed());
	}
	
	public void verifyRequiredErrorMessageIsPresent() {
		Assertions.assertTrue(WaitHelpers.WaitForElementToBePresent(getDriver(), requiredInputMessageError).isDisplayed());
	}
}
