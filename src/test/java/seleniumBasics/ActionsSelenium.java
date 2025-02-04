package seleniumBasics;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSelenium {
	
	WebDriver driver;
	
	@BeforeEach
	void BeforeEachTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}
	
	@AfterEach
	void AfterEachTest() {
		driver.quit();
	}
	
	@Test
	public void MoveMouseToElement() throws InterruptedException {
		Actions act = new Actions(driver, Duration.ofSeconds(10));
		act.moveToElement(driver.findElement(By.id("mousehover"))).perform();
		Thread.sleep(3000);
	}
	
	@Test
	public void RightClickOnElement() throws InterruptedException {
		Actions act = new Actions(driver, Duration.ofSeconds(10));
		act.contextClick(driver.findElement(By.id("mousehover"))).perform();
		Thread.sleep(3000);
	}

}
