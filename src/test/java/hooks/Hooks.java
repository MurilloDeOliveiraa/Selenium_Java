package hooks;

import static driver.DriverFactory.getDriver;
import static driver.DriverFactory.killDriver;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public class Hooks {

//	@BeforeAll
//	static void OneTimeSetUp() {
//		setUpDriver();
//	}

	@BeforeEach
	void SetUp() {
		getDriver().navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterEach
	void CloseDriver(TestInfo test) throws IOException {
		killDriver(test);
	}
	
//	@AfterAll
//	static void TearDown(TestInfo test) throws IOException {
//		killDriver(test);
//	}
}
