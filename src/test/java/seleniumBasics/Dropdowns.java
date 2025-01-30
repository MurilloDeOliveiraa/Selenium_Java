package seleniumBasics;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {
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
	@Disabled
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
	
	@Test
	void ShouldCheckAndUncheckAndVerifyStatus() {
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
	}
	
	@Test
	void ShouldGetCountOfCheckboxes() {
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkbox-example label"));
		Assert.assertEquals(3, checkboxes.size());
	}
}
