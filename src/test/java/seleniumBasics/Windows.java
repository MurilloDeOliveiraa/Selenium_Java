package seleniumBasics;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {
	WebDriver driver;

	@BeforeAll
	static void oneTimeSetUp() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@AfterEach
	public void TearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void ShouldHandleANewWindow() {
		driver.findElement(By.id("opentab")).click();
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			WebDriver newPage = driver.switchTo().window(window);
			
			if (newPage.getCurrentUrl().contains("qaclickacademy.com")) {
				driver = newPage;
				break;
			}
		}
		System.out.println(driver.getCurrentUrl());
	}
}
