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
*/	
	
	public  void addSmokingStatus() {
		WebDriverUtil wdUtil = new WebDriverUtil(driver);	
		wdUtil.waitFor(500);
		PatientPage PatientPage=new PatientPage(scriptHelper);
		PatientPage.clickOnTab("Clinical Profile");
		wdUtil.waitFor(500);
		ClinicalProfilePage ClinicalProfilePage=new ClinicalProfilePage(scriptHelper);
		ClinicalProfilePage.clickOnTab("Health Maintenance");
		wdUtil.waitFor(500);
		ClinicalProfileHealthMaintenancePage ClinicalProfileHealthMaintenancePage=new ClinicalProfileHealthMaintenancePage(scriptHelper);
		ClinicalProfileHealthMaintenancePage.clickOnBTN("Add Smoking Status");	
		
		HealthMaintenanceAddSmokingStatusPage HealthMaintenanceAddSmokingStatusPage=new HealthMaintenanceAddSmokingStatusPage(scriptHelper);
		HealthMaintenanceAddSmokingStatusPage.clickOnBTN("Current every day smoker");		
		HealthMaintenanceAddSmokingStatusPage.clickOnBTN("Save");
		ClinicalProfileHealthMaintenancePage.validateHealthMaintenance("Current");		
		//report.updateTestLog("Add Smoking Status", "Add Smoking Status", Status.PASS);
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
		//CraftDriver driver = null;
		WebDriverUtil wdUtil = new WebDriverUtil(driver);	
		wdUtil.waitFor(500);						
		
		/*if(!driver.findElement(PatientPage.PatientBanerName).getAttribute("id").contains(PatientName)) {
			wdUtil.waitUntilElementVisible(PatientPage.PatientTab, 15);		
			driver.findElement(PatientPage.PatientTab).click();
		}*/
		
		wdUtil.waitUntilElementVisible(PatientPage.ClinicalProfileTab, 15);
		driver.findElement(pages.PatientPage.ClinicalProfileTab).click();
		wdUtil.waitUntilElementVisible(ClinicalProfilePage.HealthMaintenanceTAB, 15);
		driver.findElement(ClinicalProfilePage.HealthMaintenanceTAB).click();
		driver.findElement(ClinicalProfileHealthMaintenancePage.AddScreeningBTN).click();
		wdUtil.waitUntilElementVisible(HealthMaintenanceAddScreeningPage.MammogramCHECKBOX, 15);
		driver.findElement(HealthMaintenanceAddScreeningPage.MammogramCHECKBOX).click();
		driver.findElement(HealthMaintenanceAddScreeningPage.CalenderICON).click();
		driver.findElement(HealthMaintenanceAddScreeningPage.CalenderTodayBTN).click();
		driver.findElement(HealthMaintenanceAddScreeningPage.ScreeningBilateralRadioBTN).click();		
		driver.findElement(HealthMaintenanceAddScreeningPage.SaveBTN);
		report.updateTestLog("Add Screening", "Add Screening", Status.PASS);
		//return new ClinicalProfileHealthMaintenancePage(scriptHelper);		
	}
}


