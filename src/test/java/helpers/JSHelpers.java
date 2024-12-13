package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JSHelpers {
	
	public static void ScrollToElement(WebDriver driver, By element) {
		WebElement elementToScroll = driver.findElement(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0])", elementToScroll.getLocation().toString());
		
		Actions action = new Actions(driver);
		action.moveToElement(elementToScroll).perform();
	}
}
