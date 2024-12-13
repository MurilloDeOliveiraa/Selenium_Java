package helpers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelpers {
	
	private static WebDriverWait wait;
	
	public static WebElement WaitForElementToBeVisible(WebDriver driver, By element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element2 = driver.findElement(element);
		return wait.until(ExpectedConditions.visibilityOf(element2));
	}
	
	public static WebElement WaitForElementToBeClickable(WebDriver driver, By element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element2 = driver.findElement(element);
		return wait.until(ExpectedConditions.elementToBeClickable(element2));
	}
	
	public static WebElement WaitForElementToBePresent(WebDriver driver, By element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	
	public static void WaitForPageLoads(WebDriver driver,  By element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element2 = driver.findElement(element);
		wait.until(d -> element2.isDisplayed());
	}

}
