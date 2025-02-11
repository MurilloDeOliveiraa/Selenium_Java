package seleniumBasics;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsSelenium {
	WebDriver driver;

	@BeforeEach
	void SetUp() {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);   // vai aceitar certificados inseguros
		
		
		Proxy testProxy = new Proxy();
//		testProxy.setHttpProxy("127.0.2.500:4444");  //exemplo de um proxy
//		options.setCapability("proxy", testProxy);
		
//		options.addArguments("--headless");  // para rodar sem abrir o navegador
		
//		options.addArguments("start-maximized");  //para abrir maximizado
		
		driver.manage().deleteCookieNamed("testCookie");
		Cookie cookie = new Cookie("MyCookie", "Lopes de Oliveira");
		driver.manage().addCookie(cookie);
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@AfterEach
	void TearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void HandleInsecureHTTPSCertificates() {
		driver.navigate().to("https://expired.badssl.com/");
		
	}
}
