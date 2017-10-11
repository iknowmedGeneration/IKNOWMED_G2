package pages;
import org.openqa.selenium.By;

import com.iknowmed.framework.Status;
import com.iknowmed.framework.selenium.WebDriverUtil;

import supportlibraries.ScriptHelper;

//**Page/Tab Naming Format:
 
public class HealthMaintenanceAddScreeningPage extends MasterPage{
	
//**Constructor:

	public HealthMaintenanceAddScreeningPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		if(!driver.findElement(MammogramCHECKBOX).getAttribute("id").contains("Mammogram")) {
			throw new IllegalStateException("Add screening page expected, but not displayed!");
		}	
	}
	
//**UI Objects:
	
	//**PAGE OBJECTS....................................................................
		//Input Boxes
			
			
		//Buttons
			public static final By CalenderTodayBTN = By.xpath(".//*[@id='g2.pickDate.today']");
			public static final By SaveBTN = By.id("g2.addEditScreening.save");
			public static final By CancelBTN = By.id("g2.addEditScreening.cancel");
			
		//WebLists
			
		//Links
			
		//WebElement
			public static final By ScreeningBilateralRadioBTN = By.xpath(".//*[@id='g2.addEditScreening.Screeningbilateral-label']");
			public static final By MammogramCHECKBOX = By.id("g2.addEditScreening.Mammogram-label");
			public static final By CalenderICON = By.xpath(".//*[@id='g2.addEditScreening.MammogramDate']");
			
	//**PAGE OBJECTS END................................................................

			public void clickOnBTN(String BTNName){
				
				WebDriverUtil wdUtil = new WebDriverUtil(driver);
				if (BTNName.equals("Screening Bilateral")) {
					wdUtil.waitUntilElementVisible(ScreeningBilateralRadioBTN, 15);
					driver.findElement(ScreeningBilateralRadioBTN).click();
					}
				else
				if (BTNName.equals("Mammogram")) {
					wdUtil.waitUntilElementVisible(MammogramCHECKBOX, 15);
					driver.findElement(MammogramCHECKBOX).click();
					}
				else
				if (BTNName.equals("CalenderIcon")) {
					wdUtil.waitUntilElementVisible(CalenderICON, 15);
					driver.findElement(CalenderICON).click();
					}
				else
				if (BTNName.equals("CalenderToday")) {
					wdUtil.waitUntilElementVisible(CalenderTodayBTN, 15);
					driver.findElement(CalenderTodayBTN).click();
					}
				else
				if (BTNName.equals("Save")) {
					wdUtil.waitUntilElementVisible(SaveBTN, 15);
					driver.findElement(SaveBTN).click();
					}
				else
				if (BTNName.equals("Cancel")) {
					wdUtil.waitUntilElementVisible(CancelBTN, 15);
					driver.findElement(CancelBTN).click();
					}
				else
				{
					throw new IllegalStateException("'"+ BTNName +"' Expected, but not Displayed!");
				}
				//BTNName=null;
												
		}	
			 
		public void addScreening()	{
				
			 //HealthMaintenanceAddScreeningPage HealthMaintenanceAddScreeningPage1=new HealthMaintenanceAddScreeningPage(scriptHelper);
			 clickOnBTN("Mammogram");
			clickOnBTN("CalenderIcon");
			clickOnBTN("CalenderToday");
			 clickOnBTN("Screening Bilateral");
			 clickOnBTN("Save");		
			report.updateTestLog("Add Screening", "Add Screening", Status.PASS);
			//return new ClinicalProfileHealthMaintenancePage(scriptHelper);
}
}
