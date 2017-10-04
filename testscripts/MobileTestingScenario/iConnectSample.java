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
public class iConnectSample extends CRAFTTestCase {

	@Test(dataProvider = "TestConfigurations")
	public void testRunner(String testInstance, ExecutionMode executionMode,
			MobileToolName mobileToolName,
			MobileExecutionPlatform executionPlatform, String osVersion,
			String deviceName) {
		SeleniumTestParameters testParameters = new SeleniumTestParameters(
				currentScenario, currentTestcase);
		testParameters
				.setCurrentTestDescription("Test for login with invalid user credentials");
		testParameters.setCurrentTestInstance(testInstance);
		testParameters.setExecutionMode(executionMode);
		testParameters.setMobileExecutionPlatform(executionPlatform);
		testParameters.setMobileToolName(mobileToolName);
		testParameters.setmobileOSVersion(osVersion);
		testParameters.setDeviceName(deviceName);
		testParameters
				.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);

		DriverScript driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();

		tearDownTestRunner(testParameters, driverScript);
	}

	@DataProvider(name = "TestConfigurations", parallel = true)
	public Object[][] dataTC2() {
		return new Object[][] {

		{ "Instance3", ExecutionMode.MOBILE, MobileToolName.APPIUM,
				MobileExecutionPlatform.IOS, "9.2", "00E6FB9156B3C267" } };
	}
}