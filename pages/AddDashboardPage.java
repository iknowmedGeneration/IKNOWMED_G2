package pages;

import org.openqa.selenium.By;

import com.iknowmed.framework.selenium.WebDriverUtil;

import supportlibraries.ScriptHelper;

public class AddDashboardPage extends MasterPage {
	
	//Constructor..
	public AddDashboardPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.findElement(DashboardName).getAttribute("id").contains("g2.addDashboardPage.DashboardName")) {
		throw new IllegalStateException("Log In page expected, but not displayed!");
		}	
	}

/**
 * UI Map for AddDashboardPage 
*/
	//Buttons
		public static final By OKBTN = By.id("g2.addDashboardPage.select");
	
	//Input Boxes
		public static final By DashboardName = By.id("g2.addDashboardPage.DashboardName");
	

/**Name: createNewDashboard
 * Created By: Palash
 * Date: 09/25/2017
 * For: To Create a New Dashboard
 * dashboardname - Name of the New Dashboard
 * Updated By:
 * Update Description:		
*/
	public UsersDashboardPage createNewDashboard(String dashboardname){
		
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		wdUtil.waitUntilElementEnabled(DashboardName, 10);
		
		driver.findElement(DashboardName).clear();
		driver.findElement(DashboardName).sendKeys(dashboardname);
		driver.findElement(OKBTN).click();		
		return new UsersDashboardPage(scriptHelper);
	}
}