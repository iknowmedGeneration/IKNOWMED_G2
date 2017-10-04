package pages;

import org.openqa.selenium.By;

import com.iknowmed.framework.FrameworkException;
import com.iknowmed.framework.Status;

import supportlibraries.ScriptHelper;

public class GlobalMenuPage extends MasterPage{
	
	//Constructor..
	public GlobalMenuPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.findElement(LogOut).getAttribute("id").contains("g2.appPage.logout")) {
		throw new IllegalStateException("Log Out Object expected, but not displayed!");
		}	
	}
	
/**
 * UI Map for GlobalMenuPage 
*/
	//Links
		public static final By Messages = By.id("g2.appPage.messages");
		public static final By Calendar = By.id("g2.appPage.calendar");
		public static final By HighlightedPractice = By.id("g2.appPage.praticeName");
		public static final By HighlightedLocation = By.id("g2.appPage.location");
		public static final By WorkListQueues = By.id("g2.appPage.worklist");
		public static final By Manage = By.id("g2.appPage.manage");
		public static final By Admin = By.id("g2.appPage.admin");
		public static final By Links = By.id("g2.appPage.links");	
		public static final By UserPreference = By.id("g2.appPage.userPref");
		public static final By LogOut = By.id("g2.appPage.logout");
	

/**Name: logOut
 * Created By: Palash
 * Date: 09/25/2017
 * For: To LogOut from the Application
 * Updated By:
 * Update Description:			
*/
		public SignOnPage logOut() {
			driver.findElement(LogOut).click();
			report.updateTestLog("Logout", "Click the LOG OUT link", Status.DONE);
			
			//xxReusableActions.waitforElement(SignOnPage.UserName);
			
			if(driver.findElement(SignOnPage.UserName).isDisplayed()) {
				report.updateTestLog("Verify Logout", "Login succeessfully Loged Out", Status.PASS);
			} else {
				frameworkParameters.setStopExecution(true);
				throw new FrameworkException("Verify Login", "Login Can't Logout");
			}		
			return new SignOnPage(scriptHelper);		
		}
		

/**Name: verifyLoginSuccessful
 * Created By: Palash
 * Date: 09/25/2017
 * For: To Verify User Logged in Successfully
 * Updated By:	
 * Update Description:		
*/
		public GlobalMenuPage verifyLoginSuccessful() {
			if(driver.findElement(LogOut).isDisplayed()) {
				report.updateTestLog("Verify Login", "Login succeeded for valid user", Status.PASS);
			} else {
				frameworkParameters.setStopExecution(true);
				throw new FrameworkException("Verify Login", "Login failed for valid user");
			}
			return new GlobalMenuPage(scriptHelper);		
		}	
}