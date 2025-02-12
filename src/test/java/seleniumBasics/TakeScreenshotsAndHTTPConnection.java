package seleniumBasics;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshotsAndHTTPConnection {
	
	WebDriver driver;
	
	
	@BeforeEach
	void SetUp() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}
	
	@AfterEach
	void TearDown() {
		driver.quit();
	}
	
	@Test
	void TakeScreenshotOfPage() throws IOException {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File arquivoSrc = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivoSrc, new File("C://Users/Murillo/eclipse-workspace/Curso_Udemy_Selenium/screenshots/screenshot.png"));
	}
	
	@Test
	void TakeScreenshotOfWebElement() throws IOException {
		WebElement searchInput = driver.findElement(By.cssSelector("[name='q']"));
		searchInput.sendKeys("São Paulo FC");
		File arquivoSrc = searchInput.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivoSrc, new File("C://Users/Murillo/eclipse-workspace/Curso_Udemy_Selenium/screenshots/screenshotOfElement.png"));
	}
	
	@Test
	void VerifyURLs() throws IOException {
		HttpsURLConnection request = (HttpsURLConnection) new URL("https://www.google.com").openConnection();
		request.setRequestMethod("GET");
		request.connect();
		System.out.println("STATUS CODE = " + request.getResponseCode());
	}

}
