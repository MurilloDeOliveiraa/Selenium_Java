package seleniumBasics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScripts {
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
}
