package pages;
import org.openqa.selenium.By;
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
		
}