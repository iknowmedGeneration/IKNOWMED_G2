package pages;
import org.openqa.selenium.By;
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
			public static final By SampleEdit = By.id("g2.apppage.edit");
			
		//Buttons
			public static final By CalenderTodayBTN = By.xpath(".//*[@id='g2.pickDate.today']");
			public static final By SaveBTN = By.id("g2.addEditScreening.save");
			public static final By CancelBTN = By.id("g2.addEditScreening.cancel");
			
		//WebLists
			
		//Links
			
		//WebElement
			public static final By ScreeningBilateralRadioBTN = By.xpath(".//*[@id='g2.addEditScreening.Screeningbilateral-label']");
			public static final By MammogramCHECKBOX = By.xpath(".//*[@id='g2.addEditScreening.Mammogram-label']");
			public static final By CalenderICON = By.xpath(".//*[@id='g2.addEditScreening.MammogramDate']");
			
	//**PAGE OBJECTS END................................................................

}

