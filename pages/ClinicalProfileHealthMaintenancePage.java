package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.iknowmed.framework.Status;
import com.iknowmed.framework.selenium.CraftDriver;
import com.iknowmed.framework.selenium.WebDriverUtil;

import supportlibraries.ScriptHelper;

public class ClinicalProfileHealthMaintenancePage extends MasterPage {
	
//Constructor:
	public ClinicalProfileHealthMaintenancePage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		if(!driver.findElement(AddSmokingStatusBTN).getAttribute("id").contains("addSmokingStatus")) {
			throw new IllegalStateException("Health Maintenance page expected, but not displayed!");
		}
	}
	
	//**PAGE OBJECTS....................................................................
		//Input Boxes
			
		//Buttons
			public static final By AddSmokingStatusBTN = By.xpath(".//button[contains(@id,'addSmokingStatus')]");
			public static final By AddScreeningBTN = By.xpath(".//button[contains(@id,'addScreening')]");
			public static final By AddImmunizationBTN = By.xpath(".//button[contains(@id,'addImmunization')]");
			
			
		
		//WebLists
			
		//Links
			//public static final By HealthMaintenanceEntry = By.xpath(".//div[contains(@id,'Currenteverydaysmoker')]");
			
		//WebElement
			
	//**PAGE OBJECTS END................................................................

/**Name: clickOnBTN
* Created By: Murali Janjanam
* Date: 10/05/2017
* For: To click on any Button in Health Maintenance page
* TabName - Button Name of the Patient
* Updated By:ica
* Update Description:			
*/			WebDriverUtil wdUtil = new WebDriverUtil(driver);
			public void clickOnBTN(String BTNName){
					
					
					if (BTNName.equals("Add Smoking Status")) {

						wdUtil.waitUntilElementVisible(ClinicalProfileHealthMaintenancePage.AddSmokingStatusBTN, 15);
						driver.findElement(ClinicalProfileHealthMaintenancePage.AddSmokingStatusBTN).click();
						}
					else if (BTNName.equals("Add Screening")) {
						wdUtil.waitUntilElementVisible(ClinicalProfileHealthMaintenancePage.AddScreeningBTN, 15);
						driver.findElement(ClinicalProfileHealthMaintenancePage.AddScreeningBTN).click();
						}
					else 
						throw new IllegalStateException(""+ BTNName +" Button/Tab Expected, but not Displayed!");					
						
						}			
		
			

/**Name: clickOnBTN
* Created By: Murali Janjanam
* Date: 10/05/2017
* For: To click on any Button in Health Maintenance page
* TabName - Button Name of the Patient
* Updated By:ica
* Update Description:			
*/			

			/*public void validateHealthMaintenance(String HealthMaintenance){					
					//WebDriverUtil wdUtil = new WebDriverUtil(driver);
				System.out.println(driver.findElement(ClinicalProfileHealthMaintenancePage.HealthMaintenanceEntry).getAttribute("id"));
					if (driver.findElement(ClinicalProfileHealthMaintenancePage.HealthMaintenanceEntry).getAttribute("id").contains(HealthMaintenance)) {
		public void validateHealthMaintenance(String HealthMaintenance){					
					
					if (driver.findElement(HealthMaintenanceEntry).getAttribute("id").contains(HealthMaintenance)) {

						report.updateTestLog("Add Smoking Status", "Add Smoking Status", Status.PASS);;
					}		

					else 
						report.updateTestLog("Add Smoking Status", "Add Smoking Status", Status.FAIL);					
					}	*/
/*
					else {
						report.updateTestLog("Add Smoking Status", "Add Smoking Status", Status.FAIL);	
					}
					}	*/


				
			
			public static  void addScreening() {
				CraftDriver driver = null ;
			WebDriverUtil wdUtil = new WebDriverUtil(driver);	
			wdUtil.waitFor(500);
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
			//report.updateTestLog("Add Screening", "Add Screening", Status.PASS);
			}
			
			
}