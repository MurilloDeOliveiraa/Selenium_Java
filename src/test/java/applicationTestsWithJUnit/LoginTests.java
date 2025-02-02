package applicationTestsWithJUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import hooks.Hooks;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends Hooks {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
			
//	private static Stream<Arguments> LoginCreds() {
//	return Stream.of(Arguments.of(1, "password100"), Arguments.of(2, "password100"),
//			Arguments.of(3, "password100"));
//}
			
	@ParameterizedTest
//	@MethodSource("LoginCreds")    						// Primeiro jeito de passar parametros, método acima
	@CsvSource({ "Admin, admin123" }) 					// Segundo jeito de passar parametros
	@DisplayName("Positive - Should login with valid credentials")
	void ShouldLoginWithValidCredentials(String username, String password) {
		loginPage.verifyCorrectPageUrl(loginPage.getPageUrl());
		loginPage.enterCredentialsAndLogin(username, password);
		homePage.verifyHeaderIsPresent();
		homePage.verifyCorrectPageUrl(homePage.getPageUrl());
	}
	
	@DisplayName("Negative - Should not login with invalid credentials")
	@ParameterizedTest
	@CsvSource({"wrongUser, wrongPassword"})
	void ShouldNotLoginWithInvalidCredentials(String username, String password) {
		loginPage.enterCredentialsAndLogin(username, password);
		loginPage.verifyErrorMessageIsPresent();
	}
	
	@DisplayName("Negative - Should not login with no credentials")
	@ParameterizedTest
	@CsvSource({"'',''"})
	void ShouldNotLoginWithoutCredentials(String username, String password) {
		loginPage.enterCredentialsAndLogin(username, password);
		loginPage.verifyRequiredErrorMessageIsPresent();
	}
}
