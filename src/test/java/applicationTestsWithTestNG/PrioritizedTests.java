package applicationTestsWithTestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrioritizedTests {
	
	@BeforeTest
	public void BeforeEachTest() {
		System.out.println("--------Cleaned up all data--------");
	}
	
	@Test
	public void WebTest() {
		System.out.println("WEB OK");
	}

	@Test
	public void AppleMobileTest1() {
		System.out.println("MOBILE OK");
	}
	
	@Test
	public void AndroidMobileTest2() {
		System.out.println("MOBILE OK");
	}
}
