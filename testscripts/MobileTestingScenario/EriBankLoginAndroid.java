package testscripts.MobileTestingScenario;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iknowmed.framework.IterationOptions;
import com.iknowmed.framework.selenium.ExecutionMode;
import com.iknowmed.framework.selenium.MobileExecutionPlatform;
import com.iknowmed.framework.selenium.MobileToolName;
import com.iknowmed.framework.selenium.SeleniumTestParameters;

import supportlibraries.DriverScript;
import supportlibraries.CRAFTTestCase;

/**
 * Test for login with invalid user credentials
 * 
 * @author Cognizant
 */
public class EriBankLoginAndroid extends CRAFTTestCase {

	@Test(dataProvider = "TestConfigurations")
	public void testRunner(String testInstance, ExecutionMode executionMode,
			MobileToolName mobileToolName,
			MobileExecutionPlatform executionPlatform, String deviceName) {
		SeleniumTestParameters testParameters = new SeleniumTestParameters(
				currentScenario, currentTestcase);
		testParameters
				.setCurrentTestDescription("Test for login with invalid user credentials");
		testParameters.setCurrentTestInstance(testInstance);
		testParameters.setExecutionMode(executionMode);
		testParameters.setMobileToolName(mobileToolName);
		testParameters.setMobileExecutionPlatform(executionPlatform);
		testParameters.setDeviceName(deviceName);
		testParameters
				.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);

		DriverScript driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();

		tearDownTestRunner(testParameters, driverScript);
	}

	@DataProvider(name = "TestConfigurations", parallel = true)
	public Object[][] dataTC2() {
		return new Object[][] { { "Instance1", ExecutionMode.MOBILE,
				MobileToolName.APPIUM, MobileExecutionPlatform.ANDROID,
				"4d005cb2c4938197" } };
	}

}