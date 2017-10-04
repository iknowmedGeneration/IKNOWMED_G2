package testscripts.LoginScenario;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iknowmed.framework.IterationOptions;
import com.iknowmed.framework.selenium.Browser;
import com.iknowmed.framework.selenium.ExecutionMode;
import com.iknowmed.framework.selenium.SeleniumTestParameters;

import supportlibraries.DriverScript;
import supportlibraries.CRAFTTestCase;

/**
 * Test for login with valid user credentials
 * 
 * @author Cognizant
 */
public class TestForValidLogin_XXXXXX extends CRAFTTestCase {

	@Test(dataProvider = "ValidLoginTestConfigurations")
	public void testRunner(String testInstance, ExecutionMode executionMode,
			Browser browser, int startIteration, int endIteration) {
		SeleniumTestParameters testParameters = new SeleniumTestParameters(
				currentScenario, currentTestcase);
		testParameters
				.setCurrentTestDescription("Test for login with invalid user credentials");
		testParameters.setCurrentTestInstance(testInstance);
		testParameters.setExecutionMode(executionMode);
		testParameters.setBrowser(browser);
		testParameters
				.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setStartIteration(startIteration);
		testParameters.setEndIteration(endIteration);

		DriverScript driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();

		tearDownTestRunner(testParameters, driverScript);
	}

	@DataProvider(name = "ValidLoginTestConfigurations", parallel = true)
	public Object[][] dataTC2() {
		return new Object[][] { { "Instance1", ExecutionMode.LOCAL,
				Browser.CHROME, 1, 1 }, };
	}
}