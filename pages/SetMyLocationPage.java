package pages;

import org.openqa.selenium.By;

import com.iknowmed.framework.FrameworkException;
import com.iknowmed.framework.Status;
import com.iknowmed.framework.selenium.WebDriverUtil;

import supportlibraries.ScriptHelper;

public class SetMyLocationPage extends MasterPage{
	
	//Constructor..
	public SetMyLocationPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.findElement(SearchLocations).getAttribute("id").contains("g2.setMyLocation.location")) {
			throw new IllegalStateException("Set My Location page expected, but not displayed!");
		}
	}
		
/**
 * UI Map for SetMyLocation 
*/
	//Input Boxes
		public static final By SearchLocations = By.id("g2.setMyLocation.location");
	
	//Buttons
		public static final By okBTN = By.id("g2.setMyLocation.save");
	
	//WebElements
		String userLocation = dataTable.getData("General_Data", "Location");
		public final By Location = By.xpath("//td[text()='"+ userLocation + "'][contains(@id, 'gwt-uid')]");
	
	
/**Name: setLocation
 * Created By: Palash
 * Date: 09/25/2017
 * For: To Set Up Location to Login for the User
 * location - Location Of the User to Login
 * Updated By:	
 * Update Description:		
*/				
	public GlobalMenuPage setLocation(String location){
			
			WebDriverUtil wdUtil = new WebDriverUtil(driver);
			wdUtil.waitUntilElementEnabled(SearchLocations, 10);
			
			driver.findElement(SearchLocations).clear();
			PauseScript(1);	
			driver.findElement(SearchLocations).sendKeys(location);
			driver.findElement(Location).click();
			driver.findElement(okBTN).click();	
			report.updateTestLog("Search Location", "Object Displayed on Set My Location Page", Status.PASS);			
			PauseScript(3);		
			return new GlobalMenuPage(scriptHelper);						
	}	
}