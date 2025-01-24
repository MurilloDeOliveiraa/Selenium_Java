package seleniumBasics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	WebDriver driver;

// NÃO É MAIS PRECISO, AGORA TEMOS O SELEMIUM MANAGER QUE JÁ FAZ O DOWNLOAD DO DRIVER MAIS RECENTE
//	@BeforeAll
//	static void oneTimeSetUp() {
//		WebDriverManager.chromedriver().setup();
//	}

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
	public void ShouldHandleTheAlert() {
		driver.findElement(By.id("name")).sendKeys("Murillo");
		driver.findElement(By.id("alertbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
}
