package seleniumBasics;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {
WebDriver driver;
	
	@BeforeAll
	static void oneTimeSetUp() {
		WebDriverManager.chromedriver().setup();
	}
	
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
	public void ShouldVerifyCorrectUrl() {
		Assertions.assertTrue(driver.getCurrentUrl().contains("/AutomationPractice"));
	}
	
	@Test
	@Disabled
	public void ShouldClickOnThePrimaryButton() {
		List<WebElement> buttons = driver.findElements(By.cssSelector(".input-group button[type='button']"));
		
		for (WebElement button : buttons) {
			if(button.getText().equals("Dropdown")) {
				button.click();
				System.out.println(button.getText());
			}
		}
	}
}
