package seleniumBasics;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.testng.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RelativeLocators {
	WebDriver driver;

	@BeforeEach
	void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
	}

	@AfterEach
	void TearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	void ShouldGetLabelTextAboveElement() {
		String text = driver.findElement(with(By.tagName("label")).above(By.cssSelector("[name='name']:nth-child(2)"))).getText();
		System.out.println(text);
	}
	
	@Test
	void ShouldClickButtonBelowElement() {
		WebElement element = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(element)).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
	}
	
	@Test
	void ShouldClickOnCheckboxOnTheLeftOfElement() {
		WebElement element = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(element)).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#exampleCheck1")).isSelected());
	}
	
	// Também tem o RightOf
}
