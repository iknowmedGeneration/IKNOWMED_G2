package businesscomponents;

import org.openqa.selenium.By;

import com.iknowmed.framework.Status;

import supportlibraries.*;

/**
 * Class for storing general purpose business components
 * 
 * @author Cognizant
 */
public class GeneralComponentsMobileNative extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public GeneralComponentsMobileNative(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	public void loginEriBank() {
		String userName = dataTable.getData("General_Data", "Username");
		String password = dataTable.getData("General_Data", "Password");
		
		 driver.findElement(
		 By.id("com.experitest.ExperiBank:id/usernameTextField"))
		 .sendKeys(userName);
		 driver.findElement(
		 By.id("com.experitest.ExperiBank:id/passwordTextField"))
		 .sendKeys(password);
		 driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton"))
		 .click();
		report.updateTestLog("LoginEribank", "logging in", Status.PASS);

	}

	public void makePayment() {
		
		 driver.findElement(
		 By.id("com.experitest.ExperiBank:id/makePaymentButton"))
		 .click();
		report.updateTestLog("makePayment", "making the payment", Status.PASS);

	}
}