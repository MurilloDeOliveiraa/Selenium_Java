package seleniumBasics;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {
	
	WebDriver driver;
	
	@BeforeEach
	public void BeforeEach() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //Definição de um implicit wait
	}
	
	@Test
	public void ImplicitWait() {
		driver.navigate().to("https://saucedemo.com");		
		WebElement element = driver.findElement(By.id("user-name"));
		element.sendKeys("Muca");
	}

}
