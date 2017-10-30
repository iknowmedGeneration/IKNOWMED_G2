package businesscomponents;
import com.iknowmed.framework.selenium.*;

import pages.*;
import supportlibraries.DriverScript;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import com.iknowmed.framework.FrameworkException;
import com.iknowmed.framework.Status;

/**
 * Class for storing business components related to the ClinicalProfile component
 * @author ef3pdql
 */
public class ClinicalProfileComponent extends ReusableLibrary {
	public ClinicalProfileComponent(ScriptHelper scriptHelper) {
		super(scriptHelper);		
		}

	
/**Name: addSmoking status
 * Created By: Murali Janjanam
 * Date: 10/05/2017
 * For: To add the smoking status in Health Maintenance
 * Updated By:	
 * Update Description:	
 * @throws InterruptedException 
*/	
 public  void addSmokingStatus() throws InterruptedException {	
	 PatientPage PatientPage=new PatientPage(scriptHelper);	 
	 PatientPage.clickOnTab("Clinical Profile");
	 ClinicalProfilePage ClinicalProfilePage=new ClinicalProfilePage(scriptHelper);	 
	 ClinicalProfilePage.clickOnTab("Health Maintenance");
	 //String Smoking_Class = dataTable.getData("General_Data", "Smoking_Class");
	 ClinicalProfileHealthMaintenancePage ClinicalProfileHealthMaintenancePage =new ClinicalProfileHealthMaintenancePage(scriptHelper);
	 ClinicalProfileHealthMaintenancePage.clickOnBTN("Add Smoking Status");			
	 HealthMaintenanceAddSmokingStatusPage HealthMaintenanceAddSmokingStatusPage=new HealthMaintenanceAddSmokingStatusPage(scriptHelper);
	 Thread.sleep(2000);
	 HealthMaintenanceAddSmokingStatusPage.clickOnBTN("Current every day smoker");		
	 HealthMaintenanceAddSmokingStatusPage.clickOnBTN("Save");
	// ClinicalProfileHealthMaintenancePage.validateHealthMaintenance("Current");		
			report.updateTestLog("Add Smoking Status", "Add Smoking Status", Status.PASS);
			//return new ClinicalProfileHealthMaintenancePage(scriptHelper);		
		}	

/**Name: addScreening
 * Created By: Murali Janjanam
 * Date: 10/05/2017
 * For: To add the screening in Health Maintenance
 * Updated By:	
 * Update Description:	
*/


	public  void addScreening() {	
									
		 PatientPage PatientPage=new PatientPage(scriptHelper);	 
		 PatientPage.clickOnTab("Clinical Profile");
		 ClinicalProfilePage ClinicalProfilePage=new ClinicalProfilePage(scriptHelper);	 
		 ClinicalProfilePage.clickOnTab("Health Maintenance");
		 //String Screening_Class = dataTable.getData("General_Data", "Screening_Class");
		 ClinicalProfileHealthMaintenancePage ClinicalProfileHealthMaintenancePage =new ClinicalProfileHealthMaintenancePage(scriptHelper);
		 ClinicalProfileHealthMaintenancePage.clickOnBTN("Add Screening");
		 HealthMaintenanceAddScreeningPage HealthMaintenanceAddScreeningPage= new HealthMaintenanceAddScreeningPage(scriptHelper);
		 HealthMaintenanceAddScreeningPage.addScreening();
		 
}
}


