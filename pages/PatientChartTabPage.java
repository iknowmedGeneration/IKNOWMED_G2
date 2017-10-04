package pages;

import org.openqa.selenium.By;

import com.iknowmed.framework.Status;
import com.iknowmed.framework.selenium.WebDriverUtil;

import supportlibraries.ScriptHelper;

public class PatientChartTabPage extends MasterPage{
	
	//Constructor..
	public PatientChartTabPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.findElement(PatientTab).getAttribute("id").contains("g2.appPage.tab")) {
			throw new IllegalStateException("Patient Chart Tab Expected, but not Displayed!");
		}
	}

/**
 * UI Map for PatientChartTabPage 
*/
			
	//WebElements
		public static final By PatientTab = By.xpath("//table[@class='patientTab'][contains(@id, 'g2.appPage.tab')]");	//Works for any Patient	
			
		
}