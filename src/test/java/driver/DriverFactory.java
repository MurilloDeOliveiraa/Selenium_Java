package driver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	// Implementação de um Driver Centralizado, ao invés de passar o driver para cada classe
	private static WebDriver driver;
	
	
	public static void setUpDriver() {
		WebDriverManager.chromedriver().setup();
	}
	
	public static WebDriver getDriver() {
		if (driver == null) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void killDriver(TestInfo test) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(test.getDisplayName() + ".png"));
		if (driver != null) {
			getDriver().quit();
		}
	}
}