package seleniumBasics;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	WebDriver driver;

	@BeforeEach
	void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@AfterEach
	void TearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void ShouldVerifyCorrectUrl() {
		Assertions.assertTrue(driver.getCurrentUrl().contains("/AutomationPractice"));
	}

	@Test
	public void ShouldSelectCorrectDropdownOption() {
		WebElement locator = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(locator);
		dropdown.selectByVisibleText("Option2");
		List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
		Assertions.assertEquals(1, selectedOptions.size());
	}
	
	@Test //Preciso arrumar
	public void ShouldSelectOptionOnDynamicDropdown() {
		WebElement dynamicDropdown = driver.findElement(By.cssSelector("input#autocomplete"));
		dynamicDropdown.sendKeys("Br");
		dynamicDropdown.sendKeys(Keys.RETURN);
		List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item div"));
		
		for(WebElement option : options) {
			if(option.getText().equals("Brazil")) {
				option.click();
				System.out.println("Current Text = " + dynamicDropdown.getText());
				break;
			}
		}
		
		Assertions.assertTrue(dynamicDropdown.getText().equals("Brazil"));
		
	}
}
