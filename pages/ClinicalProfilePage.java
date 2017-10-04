package pages;
import org.openqa.selenium.By;
import supportlibraries.ScriptHelper;

public class ClinicalProfilePage extends MasterPage{	
//Constructor:
	public ClinicalProfilePage(ScriptHelper scriptHelper) {
		super(scriptHelper);		
		if(!driver.findElement(ProblemsTAB).getAttribute("xpath").contains("Problems")) {
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
		
}
