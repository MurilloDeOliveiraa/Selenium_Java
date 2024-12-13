package applicationTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {

	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeAll
	static void OneTimeSetUp() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void SetUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.verifyCorrectPageUrl(loginPage.getPageUrl());
	}

	@AfterEach
	void TearDown() {
		driver.quit();
	}
//	private static Stream<Arguments> LoginCreds() {
//	return Stream.of(Arguments.of(1, "password100"), Arguments.of(2, "password100"),
//			Arguments.of(3, "password100"));
//}
	
	@DisplayName("Positive - Should login with valid credentials")
	@ParameterizedTest
//	@MethodSource("LoginCreds")    									// Primeiro jeito de passar parametros
	@CsvSource({ "Admin, admin123" }) 					// Segundo jeito de passar parametros
	void SuccessfulLoginTest(String username, String password) {
		loginPage.enterCredentials(username, password);
		homePage.verifyHeaderIsPresent();
		homePage.verifyCorrectPageUrl(homePage.getPageUrl());
	}
	
	@DisplayName("Negative - Should not login with invalid credentials")
	@ParameterizedTest
	@CsvSource({"wrongUser, wrongPassword"})
	void UnsuccessfulLogin(String username, String password) {
		loginPage.enterCredentials(username, password);
		loginPage.verifyErrorMessageIsPresent();
	}


}
