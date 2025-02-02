package applicationTestsWithTestNG;

import org.junit.jupiter.params.ParameterizedTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTests {

	@BeforeSuite
	public void BeforeEverything() {
		System.out.println("Running Before Suite");
	}

	@BeforeClass
	public void BeforeEverythingInTheClass() {
		System.out.println("First execution in the class");
	}

	@BeforeMethod
	public void BeforeEachTest() {
		System.out.println("Executed before each test");
	}

	@BeforeTest // Executa antes de cada teste declarado no arquivo xml, executa antes do BeforeClass
	public void BeforeAllTests() {
		System.out.println("--------Cleaned up all data--------");
	}

	@AfterTest
	public void AfterAllTests() {
		System.out.println("--------Finished all Tests--------");
	}

	@Test(groups = {"Smoke"})
	public void BasicTest() {
		System.out.println("Basic Test 1 Passed!");
	}
	
	@Parameters({"URL",  "API_KEY"})
	@Test()
	public void BasicTest2(String url, String key) {
		System.out.println("Basic Test 2 Passed!");
		System.out.println("URL = " + url);
		System.out.println("API KEY = " + key);
	}
	
	
	@Test(dataProvider = "LoginData")
	public void LoginTest(String username, String password) {
		System.out.println("Login Test!");
		System.out.println("Username = " + username);
		System.out.println("Password = " + password);
	}
	
	@DataProvider
	public Object[][] LoginData() {
		Object[][] credentials = new Object[2][2];
		credentials[0][0] = "murillo@gmail.com";
		credentials[0][1] = "Senha123";
		credentials[1][0] = "laryssa@gmail.com";
		credentials[1][1] = "Senha456";
		
		return credentials;
	}
	
	@Test(dataProvider = "GetData")
	public void PrintNames(String name) {
		System.out.println("Name = " + name);
	}
	
	@DataProvider
	public Object[] GetData() {
		Object[] names = {"Murillo", "Lopes", "Oliveira"};
		return names;
	}
	
	
}
