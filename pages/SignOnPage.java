package pages;

import org.openqa.selenium.By;

import com.iknowmed.framework.selenium.WebDriverUtil;

import supportlibraries.ScriptHelper;

public class SignOnPage extends MasterPage{
	
	//Constructor..
	public SignOnPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.findElement(UserName).getAttribute("id").contains("g2.loginPage.userName")) {
				throw new IllegalStateException("Log In Page expected, but not displayed!");
		}	
	}
	
/**
 * UI Map for SignOnPage 
*/
	//Input Boxes
		public static final By UserName = By.id("g2.loginPage.userName");
		public static final By Password = By.id("g2.loginPage.password");
	
	//Buttons
		public static final By LoginBTN = By.id("g2.loginPage.login");	
	
		
/**Name: g2Login
 * Created By: Palash
 * Date: 09/25/2017
 * For: To Login to G2 Application
 * userID - User Name to Login
 * passWord - Password of the User
 * Updated By:	
 * Update Description:	
 */				
	public GlobalMenuPage g2Login(String userID, String passWord){
		
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		wdUtil.waitUntilElementVisible(UserName, 10);
			
		driver.findElement(UserName).sendKeys(userID);
		driver.findElement(Password).sendKeys(passWord);
		driver.findElement(LoginBTN).click();
		return new GlobalMenuPage(scriptHelper);
	}
	
}