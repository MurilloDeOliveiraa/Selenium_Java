package applicationTestsWithTestNG;

import org.testng.annotations.Test;

public class SampleTests {
	
	@Test(description = "Basic Test")
	public void BasicTest() {
		System.out.println("Test 1 Passed!");
	}
	
	@Test(priority = 2)
	public void BasicTest2() {
		System.out.println("Test 2 Passed!");
	}
}
