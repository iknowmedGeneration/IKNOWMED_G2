package pages;

import org.openqa.selenium.By;

import com.iknowmed.framework.selenium.WebDriverUtil;

import supportlibraries.ScriptHelper;

public class UsersDashboardPage extends MasterPage{
	
	//Constructor..
		public UsersDashboardPage(ScriptHelper scriptHelper) {
			super(scriptHelper);
			
			if(!driver.findElement(AddDashboardBTN).getAttribute("id").contains("g2.userDashboardsPage.addDashboardButton")) {
			throw new IllegalStateException("User Dashboard page expected, but not displayed!");
			}	
		}
	
/**
 * UI Map for UsersDashboardPage 
*/
	//Buttons
		public static final By AddDashboardBTN = By.id("g2.userDashboardsPage.addDashboardButton");
		
		
/**Name: clickAddNewDashboard
 * Created By: Palash
 * Date: 09/25/2017
 * For: To Click "Add New Dashboard" Button
 * Updated By:
 * Update Description:		
*/
	public AddDashboardPage clickAddNewDashboard(){
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		wdUtil.waitUntilElementEnabled(AddDashboardBTN, 10);	
		driver.findElement(AddDashboardBTN).click();
		return new AddDashboardPage(scriptHelper);
	}
	
}