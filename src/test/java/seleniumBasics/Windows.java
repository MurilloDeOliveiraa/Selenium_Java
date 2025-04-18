package seleniumBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {
	WebDriver driver;

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
	
	@Test
	void InvokeMultipleWindowsOrTabs() {
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> windows = driver.getWindowHandles();
		Object[] windowsList = windows.toArray();
		String firstTab = windowsList[0].toString();
		String secondTab = windowsList[1].toString();
		
		driver.switchTo().window(secondTab);
		driver.get("https://rahulshettyacademy.com");
		String copiedText = driver.findElement(By.cssSelector("div h3 span")).getText();
		
		driver.switchTo().window(firstTab);
		driver.findElement(By.cssSelector(".form-group [name='name']")).sendKeys(copiedText);
		
		driver.switchTo().newWindow(WindowType.TAB);
		windows = driver.getWindowHandles();
		windowsList = windows.toArray();		
		String thirdTab = windowsList[2].toString();
		
		driver.switchTo().window(thirdTab);
		driver.get("https://www.google.com");
	}
}
