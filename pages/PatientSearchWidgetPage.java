package pages;

import org.openqa.selenium.By;

import com.iknowmed.framework.Status;
import com.iknowmed.framework.selenium.WebDriverUtil;

import supportlibraries.ScriptHelper;


public class PatientSearchWidgetPage extends MasterPage{
	
	//Constructor..
	public PatientSearchWidgetPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.findElement(PatientNameOrID).getAttribute("id").contains("g2.userDashboardsPage.DefaultView.item1.PatientSearch.patientNameId")) {
			throw new IllegalStateException("Patient Search Widget Expected, but not Displayed!");
		}
	}

/**
 * UI Map for PatientSearchWidgetPage 
*/
	//Input Boxes
		public static final By PatientNameOrID = By.id("g2.userDashboardsPage.DefaultView.item1.PatientSearch.patientNameId");
	
	//Buttons
		public static final By NewPatient = By.id("g2.userDashboardsPage.DefaultView.item1.PatientSearch.newPatientButton");
		
			
/**Name: clickNewPatient
 * Created By: Palash
 * Date: 09/25/2017
 * For: To Click New Patient button from Search Patient Widget
 * Updated By:	
 * Update Description:		
*/		
	public NewPatientPage clickNewPatient(){
			
			WebDriverUtil wdUtil = new WebDriverUtil(driver);
			wdUtil.waitUntilElementEnabled(NewPatient, 10);
		
			driver.findElement(NewPatient).click();;
			report.updateTestLog("Click New Patient Button", "Object Displayed on Patient Search Widget", Status.PASS);		
			PauseScript(5);			
			return new NewPatientPage(scriptHelper);						
	}
}
