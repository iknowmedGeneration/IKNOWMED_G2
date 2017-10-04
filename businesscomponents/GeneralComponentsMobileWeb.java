package businesscomponents;

import org.openqa.selenium.By;

import com.iknowmed.framework.Status;

import supportlibraries.*;

/**
 * Class for storing general purpose business components
 * 
 * @author Cognizant
 */
public class GeneralComponentsMobileWeb extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public GeneralComponentsMobileWeb(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	public void searchGoogle() {
		driver.get("http://google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Cognizant");
		report.updateTestLog("SearchText", "Searching the text", Status.PASS);
	}

}