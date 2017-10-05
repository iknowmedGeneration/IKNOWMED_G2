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

	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 * @return 
	 */	
	
	
	public  ClinicalProfileHealthMaintenancePage addSmokingStatus() {		
		//CraftDriver driver = null;
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		wdUtil.waitFor(500);
		
		/*if(!driver.findElement(PatientPage.ClinicalProfileTab).getAttribute("id").contains("ClinicalProfile")) {
			wdUtil.waitUntilElementVisible(PatientPage.PatientTab, 15);		
			driver.findElement(PatientPage.PatientTab).click();
		}*/
		wdUtil.waitUntilElementVisible(PatientPage.ClinicalProfileTab, 15);
		driver.findElement(PatientPage.ClinicalProfileTab).click();
		wdUtil.waitUntilElementVisible(ClinicalProfilePage.HealthMaintenanceTAB, 15);
		driver.findElement(ClinicalProfilePage.HealthMaintenanceTAB).click();
		driver.findElement(ClinicalProfileHealthMaintenancePage.AddSmokingStatusBTN).click();
		
		wdUtil.waitUntilElementVisible(HealthMaintenanceAddSmokingStatusPage.CurrenteverydaysmokerRadioBTN, 15);
		driver.findElement(HealthMaintenanceAddSmokingStatusPage.CurrenteverydaysmokerRadioBTN).click();
		driver.findElement(HealthMaintenanceAddSmokingStatusPage.SaveBTN);
		//report.updateTestLog("Add Smoking Status","Add Smoking Status", Status.PASS);
		report.updateTestLog("Add Smoking Status", "Add Smoking Status", Status.PASS);
		return new ClinicalProfileHealthMaintenancePage(scriptHelper);		
	}
	
	
	public  ClinicalProfileHealthMaintenancePage addScreening() {		
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
		return new ClinicalProfileHealthMaintenancePage(scriptHelper);		
	}
}


