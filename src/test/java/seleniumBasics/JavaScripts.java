package seleniumBasics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScripts {
	WebDriver driver;

	@BeforeEach
	void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@AfterEach
	void TearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void ExecuteAlertWithJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Testando js via selenium')");
	}

	@Test
	public void ScrolltWithJS() {
		WebElement brokenLink = driver.findElement(By.cssSelector("a[href*='broken']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0])", brokenLink.getLocation().toString());
		brokenLink.click();
	}
	
	@Test
	public void ScrollOnSpecificElementtWithJS() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollBy(0, 500)");
	}
}
