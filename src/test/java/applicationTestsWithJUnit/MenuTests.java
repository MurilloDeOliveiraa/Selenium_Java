package applicationTestsWithJUnit;

import org.junit.jupiter.api.Test;

import hooks.Hooks;
import pages.HomePage;
import pages.LoginPage;

public class MenuTests extends Hooks {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test
	public void ShouldVerifyAllOptionsAreVisible() {
		loginPage.enterCredentialsAndLogin("Admin", "admin123");
		homePage.verifyCorrectPageUrl(homePage.getPageUrl());
		homePage.verifyAllOptionsArePresent();
	}

	@Test
	public void ShouldSearchAndDisplayASpecificMenuOption() {
		loginPage.enterCredentialsAndLogin("Admin", "admin123");
		homePage.verifyCorrectPageUrl(homePage.getPageUrl());
		homePage.searchForASpecificMenuOption("Time");
		homePage.verifyMenuOptionIsDisplayedAndShowCorrectOption("Time");
	}
}
