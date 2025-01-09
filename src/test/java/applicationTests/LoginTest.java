package applicationTests;

import static driver.DriverFactory.getDriver;
import static driver.DriverFactory.killDriver;
import static driver.DriverFactory.setUpDriver;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest {

	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeAll
	static void OneTimeSetUp() {
		setUpDriver();
	}

	@BeforeEach
	void SetUp() {
		getDriver().navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.verifyCorrectPageUrl(loginPage.getPageUrl());
	}

	@AfterAll
	static void TearDown(TestInfo test) throws IOException {
		killDriver(test);
	}
	
//	private static Stream<Arguments> LoginCreds() {
//	return Stream.of(Arguments.of(1, "password100"), Arguments.of(2, "password100"),
//			Arguments.of(3, "password100"));
//}
	
	
	@ParameterizedTest
//	@MethodSource("LoginCreds")    						// Primeiro jeito de passar parametros, método acima
	@CsvSource({ "Admin, admin123" }) 					// Segundo jeito de passar parametros
	@DisplayName("Positive - Should login with valid credentials")
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
