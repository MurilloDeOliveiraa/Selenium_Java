package applicationTestsWithTestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTests {
	
	@BeforeTest
	public void BeforeAllTests() {
		System.out.println("--------Cleaned up all data--------");
	}
	
	@AfterTest
	public void AfterAllTests() {
		System.out.println("--------Finished all Tests--------");
	}
	
	@Test(description = "Basic Test")
	public void BasicTest() {
		System.out.println("Basic Test 1 Passed!");
	}
	
	@Test()
	public void BasicTest2() {
		System.out.println("Basic Test 2 Passed!");
	}
}
