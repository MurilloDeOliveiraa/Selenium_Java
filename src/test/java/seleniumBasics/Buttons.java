package seleniumBasics;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Buttons {
	WebDriver driver;

	@BeforeEach
	void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@AfterEach
	void TearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	void ShouldVerifyCorrectUrl() {
		driver.findElement(By.id("")).getDomAttribute(null);
		Assert.assertTrue(driver.getCurrentUrl().contains("/AutomationPractice"));
	}

	@Test
//	@Disabled
	void ShouldClickOnThePrimaryButton() {
		List<WebElement> buttons = driver.findElements(By.cssSelector(".input-group button[type='button']"));

		for (WebElement button : buttons) {
			if (button.getText().equals("Dropdown")) {
				button.click();
				System.out.println(button.getText());
			}
		}
	}
	
	@Test
	void ShouldGetElementDimensions() {
		WebElement countriesInput = driver.findElement(By.cssSelector("input#autocomplete"));
		System.out.println(countriesInput.getRect().getHeight());
		System.out.println(countriesInput.getRect().getWidth());
		System.out.println(countriesInput.getRect().getDimension());
		
	}
}
