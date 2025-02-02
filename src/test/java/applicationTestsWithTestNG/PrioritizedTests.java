package applicationTestsWithTestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class PrioritizedTests {
	
	@BeforeTest
	public void BeforeEachTest() {
		System.out.println("--------Cleaned up all data--------");
	}
	
	//Originalmente o TestNG roda os testes por ordem alfabética
	//Para melhorar isso, posso usar o atributo dependsOnMethos
	
	@Ignore
	@Test(groups = {"Smoke", "Regression"},		// Uso de groups é o mesmo conceito de Tags
		  dependsOnMethods = {"AppleMobileTest1", "AndroidMobileTest1"}
		  )
	public void WebTest() {
		System.out.println("WEB OK");
	}

	@Test(groups = {"Smoke", "Regression"})
	public void AppleMobileTest1() {
		System.out.println("APPLE MOBILE OK");
	}
	
	@Test(groups = {"Smoke"})
	public void AndroidMobileTest1() {
		System.out.println("ANDROID MOBILE OK");
	}
	
	@Test(timeOut = 15000)
	public void SlowTest() {
		System.out.println("Executed Slow Test");
	}
}
