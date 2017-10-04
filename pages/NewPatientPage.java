package pages;

import org.openqa.selenium.By;

import com.iknowmed.framework.Status;
import com.iknowmed.framework.selenium.WebDriverUtil;

import supportlibraries.ScriptHelper;

public class NewPatientPage extends MasterPage{
	
	//Constructor..
	public NewPatientPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.findElement(Save).getAttribute("id").contains("g2.saveDemograpics")) {
			throw new IllegalStateException("New Patient Tab Expected, but not Displayed!");
		}
	}
		
/**
 * UI Map for NewPatientPage 
*/
	//Input Boxes
		public static final By FirstName = By.id("g2.newPatient.patientInfo.firstName");
		public static final By LastName = By.id("g2.newPatient.patientInfo.lastName");
		public static final By DOB = By.id("g2.newPatient.patientInfo.dob");	
		public static final By MRN = By.id("g2.newPatient.patientInfo.mrn");					
		
	//DropDown Lists
		public static final By SexAtBirth = By.id("g2.newPatient.patientInfo.gender");
		public static final By PatientStatus = By.id("g2.newPatient.patientInfo.status");
			
	//Buttons
		public static final By Save = By.id("g2.saveDemograpics");

	
/**Name: createPatientWithRequiredFields
 * Created By: Palash
 * Date: 09/25/2017
 * For: To Set Up Location to Login for the User
 * first_name - First Name of the Patient
 * last_name - Last Name of the Patient
 * dob - Date of Birth of the Patient
 * sex - Sex of the Patient
 * mrn - MRN of the Patient
 * Updated By:
 * Update Description:			
*/			
	public PatientChartTabPage createPatientWithRequiredFields(String first_name, String last_name, String dob, String sex, String mrn){
			
			WebDriverUtil wdUtil = new WebDriverUtil(driver);
			wdUtil.waitUntilElementEnabled(FirstName, 10);
					
			driver.findElement(FirstName).sendKeys(first_name);
			driver.findElement(LastName).sendKeys(last_name);
			driver.findElement(DOB).sendKeys(dob);	
			wdUtil.selectListItem(SexAtBirth, sex);
			driver.findElement(MRN).sendKeys(mrn);
			wdUtil.selectListItem(PatientStatus, "Active");
			PauseScript(2);
			driver.findElement(Save).click();
			report.updateTestLog("Click Save Button", "Object Clicked on New Patient Tab", Status.PASS);		
			PauseScript(5);
			String dynamic_data = first_name + "  " + last_name;
			String dynamic_data2 = first_name + " " + last_name;
						
			if(!driver.findElement(By.xpath("//table[@class='patientTab'][contains(@id, 'g2.appPage.tab')]//span[contains(text(), '"+ dynamic_data + "')]")).getText().contains(dynamic_data2)) {
				throw new IllegalStateException("New Patient and Tab Expected, but not Displayed!");
			}else {
				driver.findElement(By.xpath("//table[@class='patientTab'][contains(@id, 'g2.appPage.tab')]//span[contains(text(), '"+ dynamic_data + "')]")).click();
				PauseScript(2);					
			}
			return new PatientChartTabPage(scriptHelper);						
	}
	
	
}
