package pages;
import org.openqa.selenium.By;
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
			
		//WebElement
			
	//**PAGE OBJECTS END................................................................
		
}