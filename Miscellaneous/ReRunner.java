package Miscellaneous;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;

/**
 * Test for login with valid user credentials
 * 
 * @author Cognizant
 */
public class ReRunner {

	@Test
	public void testRunner() {
		TestNG runner = new TestNG();
		List<String> list = new ArrayList<String>();
		list.add(".\\Miscellaneous\\build\\testreports\\testng-failed.xml");
		runner.setTestSuites(list);
		runner.run();
	}
}