package businesscomponents;

import java.util.concurrent.TimeUnit;

import supportlibraries.*;

import org.openqa.selenium.*;

import com.iknowmed.framework.Status;

import pages.*;


/**
 * Class for storing business components related to the flight reservation functionality
 * @author Cognizant
 */
public class DashboardComponents extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	public DashboardComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	
	public void addANewDashboard() {
		
		UsersDashboardPage userdash = new UsersDashboardPage(scriptHelper);
		userdash.clickAddNewDashboard();
		report.updateTestLog("Click + Sign", "Click Button to Add New Dashboard", Status.PASS);
		
		String dashboardname = dataTable.getData("General_Data", "Dashboard Name");
		
		AddDashboardPage adddashboard = new AddDashboardPage(scriptHelper);
		adddashboard.createNewDashboard(dashboardname);
		report.updateTestLog("Click OK Button", "Click on OK Button to Create Dashboard", Status.PASS);	
	}
	

	

}