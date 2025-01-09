package pages;

import static driver.DriverFactory.getDriver;

import org.junit.jupiter.api.Assertions;

public class BasePage {
	
	public void verifyCorrectPageUrl(String url) {
		Assertions.assertTrue(getDriver().getCurrentUrl().contains(url));
	}
	
}
