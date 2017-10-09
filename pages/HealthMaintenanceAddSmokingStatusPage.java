package pages;
import org.openqa.selenium.By;

import com.iknowmed.framework.selenium.WebDriverUtil;

import supportlibraries.ScriptHelper;

public class HealthMaintenanceAddSmokingStatusPage extends MasterPage{
	
//Constructor:
	public HealthMaintenanceAddSmokingStatusPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.findElement(CurrenteverydaysmokerRadioBTN).getAttribute("id").contains("Currenteverydaysmoker")) {
			throw new IllegalStateException("Set My Location page expected, but not displayed!");
		}

	}
	
//**UI Objects: 
	
	//**PAGE OBJECTS....................................................................
		//Input Boxes
			
		//Buttons
			public static final By SaveBTN = By.id("g2.addEditSmokingStatus.save");
			public static final By CancelBTN = By.id("g2.addEditSmokingStatus.cancel");			
		
		//WebLists
			
		//Links
			
		//WebElement
			public static final By CurrenteverydaysmokerRadioBTN = By.xpath(".//*[@id='g2.addEditSmokingStatus.Currenteverydaysmoker-label']");
			
	//**PAGE OBJECTS END................................................................
/**Name: clickOnBTN
* Created By: Murali Janjanam
* Date: 10/05/2017
* For: To click on any Button in Health Maintenance page
* TabName - Button Name of the Patient
* Updated By:ica
* Update Description:			
*/			
			public void clickOnBTN(String BTNName){
					
					WebDriverUtil wdUtil = new WebDriverUtil(driver);
					if (BTNName.equals("Current every day smoker")) {
						wdUtil.waitUntilElementVisible(CurrenteverydaysmokerRadioBTN, 15);
						driver.findElement(CurrenteverydaysmokerRadioBTN).click();
						}			
					else
					if (BTNName.equals("Save")) {
						wdUtil.waitUntilElementVisible(CurrenteverydaysmokerRadioBTN, 15);
						driver.findElement(CurrenteverydaysmokerRadioBTN).click();
						}
					else {
						throw new IllegalStateException("'+ BTNName +' Expected, but not Displayed!");					
							//return new HealthMaintenanceAddSmokingStatusPage(scriptHelper);	
					}
			}		
}