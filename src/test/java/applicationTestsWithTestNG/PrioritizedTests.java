package applicationTestsWithTestNG;

import org.testng.annotations.Test;

public class PrioritizedTests {
	
	@Test
	public void testOne() {
		System.out.println("OK");
	}

	@Test
	public void testTwo() {
		System.out.println("OK");
	}
}
