package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.iknowmed.framework.Status;
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
			public static final By HealthMaintenanceEntry = By.xpath(".//div[contains(@id,'Currenteverydaysmoker')]");
			
		//WebElement
			
	//**PAGE OBJECTS END................................................................

/**Name: clickOnBTN
* Created By: Murali Janjanam
* Date: 10/05/2017
* For: To click on any Button in Health Maintenance page
* TabName - Button Name of the Patient
* Updated By:ica
* Update Description:			
*/			
			public HealthMaintenanceAddSmokingStatusPage clickOnBTN(String BTNName){
					
					WebDriverUtil wdUtil = new WebDriverUtil(driver);
					if (BTNName.equals("Add Smoking Status")) {
						wdUtil.waitUntilElementVisible(ClinicalProfileHealthMaintenancePage.AddSmokingStatusBTN, 15);
						driver.findElement(ClinicalProfileHealthMaintenancePage.AddSmokingStatusBTN).click();
						}			
					else 
						throw new IllegalStateException("New Patient and Tab Expected, but not Displayed!");					
							return new HealthMaintenanceAddSmokingStatusPage(scriptHelper);						
			}	

/**Name: clickOnBTN
* Created By: Murali Janjanam
* Date: 10/05/2017
* For: To click on any Button in Health Maintenance page
* TabName - Button Name of the Patient
* Updated By:ica
* Update Description:			
*/			
			public void validateHealthMaintenance(String HealthMaintenance){					
					WebDriverUtil wdUtil = new WebDriverUtil(driver);
					if (driver.findElement(ClinicalProfileHealthMaintenancePage.HealthMaintenanceEntry).getAttribute("id").contains(HealthMaintenance)) {
						report.updateTestLog("Add Smoking Status", "Add Smoking Status", Status.PASS);;
					}		
					else 
						report.updateTestLog("Add Smoking Status", "Add Smoking Status", Status.FAIL);					
					}	

			
}