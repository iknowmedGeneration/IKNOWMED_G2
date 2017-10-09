package pages;
import org.openqa.selenium.By;

import com.iknowmed.framework.selenium.WebDriverUtil;

import supportlibraries.ScriptHelper;

public class ClinicalProfilePage extends MasterPage{	
//Constructor:
	public ClinicalProfilePage(ScriptHelper scriptHelper) {
		super(scriptHelper);		
		if(!driver.findElement(HealthMaintenanceTAB).getAttribute("id").contains("HealthMaintenance")) {
			throw new IllegalStateException("Problems page expected, but not displayed!");
		}	
	}
	
//UI Objects:
	
	//**PAGE OBJECTS....................................................................
		//Input Boxes
				
		//Buttons
			
		//WebLists
			
		//Links
			
		//WebElement
			public static final By ProblemsTAB = By.xpath(".//div [contains(@id,'ClinicalProfile.tab')][substring(@id, string-length(@id) - string-length('Problems') +1) ='Problems']");
			public static final By HealthMaintenanceTAB = By.xpath(".//div[contains(@id,'HealthMaintenance')]");
			public static final By ObservationsTAB = By.xpath(".//div[contains(@id,'Observations')]");
	
	//**PAGE OBJECTS END................................................................
		
/**Name: clickOnTab
* Created By: Murali Janjanam
* Date: 10/05/2017
* For: To click on any tab in Clinical Profile page
* TabName - Tab Name of the Patient
* Updated By:
* Update Description:			
*/			
			public void clickOnTab(String TabName){
					
					WebDriverUtil wdUtil = new WebDriverUtil(driver);
					if (TabName.equals("Health Maintenance")) {
						wdUtil.waitUntilElementVisible(HealthMaintenanceTAB, 15);
						driver.findElement(HealthMaintenanceTAB).click();
						}			
					//else 
						//throw new IllegalStateException("'+ TabName +' Tab Expected, but not Displayed!");					
							//return new ClinicalProfileHealthMaintenancePage(scriptHelper);						
			}
}
