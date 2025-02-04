package seleniumBasics;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaits {
	
	WebDriver driver;
	
	@BeforeEach
	void BeforeEachTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://saucedemo.com");
	}
	
	@AfterEach
	void AfterEachTest() {
		driver.quit();
	}
	
	@Test
	public void ExplicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement usernameInput = driver.findElement(By.id("user-name"));
		wait.until(ExpectedConditions.visibilityOf(usernameInput));
	}
	
	@Test
	public void FluentWait() {   
		//FluentWait é uma categoria de Explicit Wait
		// A diferença é que no FluentWait eu consigo definir um período regular para checar um elemento (pooling)
		//Exemplo: A cada 2 segundos eu vejo se o elemento está visível
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2));
		WebElement usernameInput = driver.findElement(By.id("user-name"));
		wait.until(ExpectedConditions.visibilityOf(usernameInput));
		
	}

}
