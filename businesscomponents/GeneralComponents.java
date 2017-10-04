package businesscomponents;


import pages.GlobalMenuPage;
import pages.MasterPage;
import pages.NewPatientPage;
import pages.PatientChartTabPage;
import pages.PatientSearchWidgetPage;
import pages.SetMyLocationPage;
import pages.SignOnPage;
import supportlibraries.DriverScript;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.iknowmed.framework.FrameworkException;
import com.iknowmed.framework.Status;
import com.iknowmed.framework.selenium.WebDriverUtil;


/**
 * Class for storing general purpose business components
 * @author Cognizant
 */
public class GeneralComponents extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	public GeneralComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
/**Name: invokeApplication
 * Created By: Exists in the Framework
 * Date: 09/25/2017
 * For: To Launch the Application
 * Updated By:	
 * Update Description:	
*/	
	public void invokeApplication() {
		report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
									properties.getProperty("ApplicationUrl"), Status.DONE);
		
		driver.get(properties.getProperty("ApplicationUrl"));
	}
	
/**Name: g2ValidLogin
 * Created By: Palash
 * Date: 09/25/2017
 * For: To Login to the Application
 * Updated By:	
 * Update Description:	
*/	
	public GlobalMenuPage g2ValidLogin() {
		String userName = dataTable.getData("General_Data", "Username");
		String password = dataTable.getData("General_Data", "Password");
		
		SignOnPage g2signonpage = new SignOnPage(scriptHelper);
		g2signonpage.g2Login(userName, password);
	
		report.updateTestLog("Enter user credentials", "Specify " +
									"username = " + userName + ", " +
									"password = " + password, Status.PASS);
				
		report.updateTestLog("Login", "Click the sign-in button", Status.SCREENSHOT);
		PauseScript(5);
		
		WebDriverUtil wdUtil = new WebDriverUtil(driver);		
		if (wdUtil.objectExists(SetMyLocationPage.SearchLocations)){
			setUserLocation();
		}	
		return new GlobalMenuPage(scriptHelper);
	}
	

/**Name: setUserLocation
 * Created By: Palash
 * Date: 09/25/2017
 * For: To Set Up User Location
 * Updated By:	
 * Update Description:	
*/	
	public void setUserLocation(){
		String location = dataTable.getData("General_Data", "Location");

		SetMyLocationPage setmylocation = new SetMyLocationPage(scriptHelper);
		setmylocation.setLocation(location);
	}
	

/**Name: verifySuccessfulLogin
* Created By: Palash
 * Date: 09/25/2017
 * For: To Set Up User Location
 * Updated By:	
 * Update Description:	
*/
	public void verifySuccessfulLogin() {
		GlobalMenuPage gMenu = new GlobalMenuPage(scriptHelper);
		gMenu.verifyLoginSuccessful();
	}
	

/**Name: logOut
 * Created By: Palash
 * Date: 09/25/2017
 * For: To Logout from the Application
 * Updated By:	
 * Update Description:	
*/	
	public void logOut() {
		GlobalMenuPage gMenu = new GlobalMenuPage(scriptHelper);
		gMenu.logOut();
	}
	

/**Name: createNewPatientWithRequiredFields
 * Created By: Palash
 * Date: 09/25/2017
 * For: To Create a New Patient
 * Updated By:	
 * Update Description:	
*/
	public void createNewPatientWithRequiredFields() {
		PatientSearchWidgetPage ptsrcwgd = new PatientSearchWidgetPage(scriptHelper);
		ptsrcwgd.clickNewPatient();
		
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		String first_name = "FN"+wdUtil.createRandomNumber(8);
		String last_name = "LN"+wdUtil.createRandomNumber(8);
		String dob = dataTable.getData("General_Data", "DOB");
		String sex = dataTable.getData("General_Data", "SEX");				
		String mrn = "MRN"+wdUtil.createRandomNumber(8);		
		NewPatientPage nwptpg = new NewPatientPage(scriptHelper);
		nwptpg.createPatientWithRequiredFields(first_name, last_name, dob, sex, mrn);
		PauseScript(5);
	}
	
}