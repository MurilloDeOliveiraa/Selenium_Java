package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
	
	private WebDriver driver;
	

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void verifyCorrectPageUrl(String url) {
		Assertions.assertTrue(driver.getCurrentUrl().contains(url));
	}
	
}
