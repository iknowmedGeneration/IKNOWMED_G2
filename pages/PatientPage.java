package pages;
import org.openqa.selenium.By;
import supportlibraries.ScriptHelper;
public class PatientPage extends MasterPage {
	
//Constructor:
	public PatientPage(ScriptHelper scriptHelper) {
		super(scriptHelper);		
		if(!driver.findElement(PatientTab).getAttribute("id").contains("g2.appPage.tab")) {
			throw new IllegalStateException("Patient page expected, but not displayed!");
		}
	}
	

	//**PAGE OBJECTS....................................................................
		//Input Boxes
			public static final By SampleEdit = By.id("g2.apppage.edit");
			
		//Buttons
			public static final By ClinicalProfileTab = By.xpath(".//div[contains(@id,'ClinicalProfile')]");
			public static final By FlowSheetTab = By.xpath(".//div[contains(@id,'Flowsheet')]");
			public static final By PatientTab = By.xpath("//table[@class='patientTab'][contains(@id, 'g2.appPage.tab')]");
		
		//WebLists
			//public static final By SampleLIST = By.id("g2.apppage.list");
			
		//Links
			//public static final By SampleLink = By.id("g2.apppage.link");
			
		//WebElement
			//public static final By PatientBanerName = By.xpath(".//*[@id='g2.appPage.tab2.'"+ GeneralComponents.PatientName +"']");
	
	//**PAGE OBJECTS END................................................................
}