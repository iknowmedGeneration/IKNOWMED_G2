package pages;
import org.openqa.selenium.By;
import supportlibraries.ScriptHelper;


/**Page/Tab Naming Format:
 * Page Class Name must match exactly as the page/tab name displayed in the application
 * If the tab name is "New Patient" then the class name will be "NewPatientPage.Java"
 * MasterPage need to be extended in all the page classes
*/
public class ClinicalProfileObservationsPage extends MasterPage{
	
/**Constructor:
 * All Pages/Tabs Must have a Constructor.
 * Within the constructor there will be a UI/page object validation which must present within the page/tab to verify user reached to the right place.	
*/
	public ClinicalProfileObservationsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.findElement(SampleEdit).getAttribute("id").contains("g2.apppage.edit")) {
				throw new IllegalStateException("Template Page/Tab page expected, but not displayed!");
		}	
	}
	
/**UI Objects:
 * All UI objects need to be defined in this section categorized them under different sections e.g. WebElement, Links, Buttons, WebEdits etc.
 * Place the objects in Alphabetic Order	
*/	
	
	//**PAGE OBJECTS....................................................................
		//Input Boxes
			public static final By SampleEdit = By.id("g2.apppage.edit");
			
		//Buttons
			public static final By SampleBTN = By.id("g2.apppage.button");
		
		//WebLists
			public static final By SampleLIST = By.id("g2.apppage.list");
			
		//Links
			public static final By SampleLink = By.id("g2.apppage.link");
			
		//WebElement
			public static final By SampleWebElement = By.id("g2.apppage.element");
	
	//**PAGE OBJECTS END................................................................
		
	
/**Page Functions/Methods:
 * All Page functions will be placed here in Alphabetic order
 * Functions must have a return/output which should be another pageclass to verify user navigate to the right place after a single/set of operations
 * All the Functions must have descriptions including: Created By, Date, Argument Description, Purpose, Updated By etc.
 * Place the functions/methods in Alphabetic Order.
 * In the given example bellow it is returning GlobalMenuPage which means user will reach to that page once this method will be called.
*/		

/**Name: g2SampleFunction
* Created By: Your Name
* Date: MM/DD/YYYY
* For: Purpose of Creating this Method
* SampleData1 - Argument Description
* SampleData2 - Argument Description
* Updated By:			
*/				
	public GlobalMenuPage g2SampleFunction(String SampleData1, String SampleData2){

		driver.findElement(SampleEdit).sendKeys(SampleData1);
		driver.findElement(SampleLink).click();
		driver.findElement(SampleBTN).click();
		driver.findElement(SampleWebElement).click();
		return new GlobalMenuPage(scriptHelper);
	}
}
