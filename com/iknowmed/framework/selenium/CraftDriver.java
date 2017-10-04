package com.iknowmed.framework.selenium;

/*import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;*/

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;

import java.net.URL;
import java.util.List;
import java.util.Map;
//import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.remote.ExecuteMethod;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import com.experitest.client.Client;
import com.experitest.selenium.MobileDevice;
/*import com.experitest.client.Client;
import com.experitest.selenium.MobileDevice;
import com.experitest.selenium.MobileWebDriver;
import com.google.gson.JsonObject;*/
import com.experitest.selenium.MobileWebDriver;
import com.google.gson.JsonObject;
import com.iknowmed.framework.Status;

public class CraftDriver {

	private SeleniumTestParameters testParameters;
	private SeleniumReport report;
	private WebDriver driver;
	private MobileWebDriver seeTestDriver;
	//private Map<String, Object> perfObject;

	public CraftDriver(WebDriver driver) {
		this.driver = driver;
	}

	public SeleniumTestParameters getTestParameters() {
		return testParameters;
	}

	public void setTestParameters(SeleniumTestParameters testParameters) {
		this.testParameters = testParameters;
	}

	public void setRport(SeleniumReport report) {
		this.report = report;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	@SuppressWarnings("rawtypes")
	public AppiumDriver getAppiumDriver() {
		return (AppiumDriver) driver;
	}

	public RemoteWebDriver getRemoteWebDriver() {
		return (RemoteWebDriver) driver;
	}

	public void setSeeTestDriver(MobileWebDriver seeTestDriver) {
		this.seeTestDriver = seeTestDriver;
	}

	public MobileWebDriver getSeeTestDriver() {
		return seeTestDriver;
	}

	public boolean isPerfecto() {
		boolean isPerfecto = false;
		if (testParameters.getExecutionMode().toString().equals("PERFECTO")) {
			isPerfecto = true;
		}
		return isPerfecto;
	}

	public boolean isAppium() {
		boolean isAppium = false;
		if (testParameters.getMobileToolName().toString().equals("APPIUM")) {
			isAppium = true;
		}
		return isAppium;
	}

	public boolean isDefaultPerfecto() {
		boolean isDefaultPerfecto = false;
		if (testParameters.getMobileToolName().toString().equals("DEFAULT")) {
			isDefaultPerfecto = true;
		}
		return isDefaultPerfecto;
	}

	public boolean isSeeTest() {
		boolean isSeeTest = false;
		if (testParameters.getExecutionMode().toString().equals("SEETEST")) {
			isSeeTest = true;
		}
		return isSeeTest;
	}

	// WebDriver Methods
	/**
	 * Function to close the driver Object {@link WebDriver}
	 */
	public void close() {
		driver.close();
	}

	/**
	 * Function to identity the Element
	 * 
	 * @param by
	 *            The locator used to identify the element {@link WebDriver}
	 */
	public boolean equals(Object obj) {
		return driver.equals(obj);
	}

	/**
	 * Function to Find the first {@link WebElement} using the given method.
	 * 
	 * @param by
	 *            The locator used to identify the element {@link WebDriver}
	 */
	public WebElement findElement(By arg0) {
		return driver.findElement(arg0);
	}

	/**
	 * Function to Find the first {@link WebElement}, also take screen shot and
	 * wait until the specified element is visible
	 * 
	 * @param by
	 *            The locator used to identify the element {@link WebDriver}
	 */
	public WebElement findElementnTakescreenShot(By arg0) {
		WebElement element;
		if (driver.findElement(arg0).isDisplayed() || isElementVisible(arg0)) {
			report.updateTestLog("Action", "Action Performed Successfully",
					Status.PASS);
			element = driver.findElement(arg0);
		} else {
			report.updateTestLog("Action",
					"Action Failed to Perform, please check the Locators",
					Status.FAIL);
			element = null;
		}
		return element;
	}

	/**
	 * Function to wait until the specified element is visible
	 * 
	 * @param by
	 *            The locator used to identify the element {@link WebDriver}
	 */
	public boolean isElementVisible(By arg0) {
		boolean elementVisible = false;
		try {
			(new WebDriverWait(driver, 60)).until(ExpectedConditions
					.visibilityOfElementLocated(arg0));
			elementVisible = true;

		} catch (TimeoutException ex) {
			elementVisible = false;
		}
		return elementVisible;
	}

	/**
	 * Function to take screen shot and update in report {@link WebDriver}
	 */
	public void capture() {
		report.updateTestLog("Screen Shot", "Screen Shot Captured Successfuly",
				Status.SCREENSHOT);
	}

	/**
	 * Function to Find all elements within the current page using the given
	 * mechanism
	 * 
	 * @param by
	 *            The locator used to identify the list of elements
	 *            {@link WebDriver}
	 */
	public List<WebElement> findElements(By arg0) {
		return driver.findElements(arg0);
	}

	/**
	 * Function to Load a new web page in the current browser window.
	 * {@link WebDriver}
	 */
	public void get(String arg0) {
		driver.get(arg0);
	}

	public Class<?> getClass_Driver() {
		return driver.getClass();
	}

	/**
	 * Function to Get a string representing the current URL that the browser is
	 * looking at. {@link WebDriver}
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Function to Get the source of the last loaded page. {@link WebDriver}
	 */
	public String getPageSource() {
		return driver.getPageSource();
	}

	/**
	 * Function to get The title of the current page. {@link WebDriver}
	 */
	public String getTitle() {
		return driver.getTitle();
	}

	/**
	 * Function to Return an opaque handle to this window that uniquely
	 * identifies it within this driver instance {@link WebDriver}
	 */
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	/**
	 * Function to Return a set of window handles which can be used to iterate
	 * over all open windows of this WebDriver instance by passing them to
	 * {@link switchTo} {@link WebDriver}
	 */
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public int hashCode() {
		return driver.hashCode();
	}

	/**
	 * Function to Gets the Option interface. {@link WebDriver}
	 */
	public Options manage() {
		return driver.manage();
	}

	/**
	 * Function to GetAn abstraction allowing the driver to access the browser's
	 * history and to navigate to a given URL. {@link WebDriver}
	 */
	public Navigation navigate() {
		return driver.navigate();
	}

	public void notify_Driver() {
		driver.notify();
	}

	public void notifyAll_Driver() {
		driver.notifyAll();
	}

	/**
	 * Function to Quit this driver, closing every associated window..
	 * {@link WebDriver}
	 */
	public void quit() {
		driver.quit();
	}

	/**
	 * Function to Send future commands to a different frame or window.
	 * {@link WebDriver}
	 */
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	public String toString() {
		return driver.toString();
	}

	public void wait_Driver() throws InterruptedException {
		driver.wait();
	}

	public void wait_Driver(long timeout) throws InterruptedException {
		driver.wait(timeout);
	}

	public void wait_Driver(long timeout, int nanos)
			throws InterruptedException {
		driver.wait(timeout, nanos);
	}

	// Perfecto Scripts

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public Object executeAsyncScript(String arg0, Object... arg1) {

		if (isAppium()) {
			return ((AppiumDriver) driver).executeAsyncScript(arg0, arg1);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public Object executeScript(String arg0, Object... arg1) {
		if (isAppium()) {
			return ((AppiumDriver) driver).executeScript(arg0, arg1);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver} OR <b>SEETEST i.e., {@link MobileWebDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public WebElement findElementById(String arg0) {
		if (isSeeTest()) {
			return ((MobileWebDriver) driver).findElementById(arg0);
		} else if (isAppium()) {
			return ((AppiumDriver) driver).findElementById(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is OR <b>APPIUM i.e.,
	 * {@link AppiumDriver} OR <b>SEETEST i.e., {@link MobileWebDriver}.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WebElement> findElementsById(String arg0) {
		if (isSeeTest()) {
			return ((MobileWebDriver) driver).findElementsById(arg0);
		} else if (isAppium()) {
			return ((AppiumDriver) driver).findElementsById(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public WebElement findElementByName(String arg0) {
		if (isAppium()) {
			return ((AppiumDriver) driver).findElementByName(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is OR <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WebElement> findElementsByName(String arg0) {
		if (isAppium()) {
			return ((AppiumDriver) driver).findElementsByName(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver} OR <b>SEETEST i.e., {@link MobileWebDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public WebElement findElementByXPath(String arg0) {
		if (isSeeTest()) {
			return ((MobileWebDriver) driver).findElementByXPath(arg0);
		} else if (isAppium()) {
			return ((AppiumDriver) driver).findElementByXPath(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver} OR <b>SEETEST i.e., {@link MobileWebDriver}.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WebElement> findElementsByXPath(String arg0) {
		if (isSeeTest()) {
			return ((MobileWebDriver) driver).findElementsByXPath(arg0);
		} else if (isAppium()) {
			return ((AppiumDriver) driver).findElementsByXPath(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is < <b>APPIUM i.e.,
	 * {@link AppiumDriver} OR <b>SEETEST i.e., {@link MobileWebDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public WebElement findElementByLinkText(String arg0) {
		if (isSeeTest()) {
			return ((MobileWebDriver) driver).findElementByLinkText(arg0);
		} else if (isAppium()) {
			return ((AppiumDriver) driver).findElementByLinkText(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver} OR <b>SEETEST i.e., {@link MobileWebDriver}.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WebElement> findElementsByLinkText(String arg0) {
		if (isSeeTest()) {
			return ((MobileWebDriver) driver).findElementsByLinkText(arg0);
		} else if (isAppium()) {
			return ((AppiumDriver) driver).findElementsByLinkText(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver} OR <b>SEETEST i.e., {@link MobileWebDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public WebElement findElementByPartialLinkText(String arg0) {
		if (isSeeTest()) {
			return ((MobileWebDriver) driver)
					.findElementByPartialLinkText(arg0);
		} else if (isAppium()) {
			return ((AppiumDriver) driver).findElementByPartialLinkText(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver} OR <b>SEETEST i.e., {@link MobileWebDriver}.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WebElement> findElementsByPartialLinkText(String arg0) {
		if (isSeeTest()) {
			return ((MobileWebDriver) driver)
					.findElementsByPartialLinkText(arg0);
		} else if (isAppium()) {
			return ((AppiumDriver) driver).findElementsByPartialLinkText(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public WebElement findElementByClassName(String arg0) {
		if (isAppium()) {
			return ((AppiumDriver) driver).findElementByClassName(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver} OR <b>SEETEST i.e., {@link MobileWebDriver}.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WebElement> findElementsByClassName(String arg0) {
		if (isAppium()) {
			return ((AppiumDriver) driver).findElementsByClassName(arg0);
		} else if (isSeeTest()) {
			return ((MobileWebDriver) driver).findElementsByClassName(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public WebElement findElementByTagName(String arg0) {
		if (isAppium()) {
			return ((AppiumDriver) driver).findElementByTagName(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<WebElement> findElementsByTagName(String arg0) {
		if (isAppium()) {
			return ((AppiumDriver) driver).findElementsByTagName(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public WebElement findElementByCssSelector(String arg0) {
		if (isAppium()) {
			return ((AppiumDriver) driver).findElementByCssSelector(arg0);
		} else {
			return null;
		}
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WebElement> findElementsByCssSelector(String arg0) {
		if (isAppium()) {
			return ((AppiumDriver) driver).findElementsByCssSelector(arg0);
		} else {
			return null;
		}
	}

	// Appium Methods

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public Capabilities getCapabilities() {
		return ((AppiumDriver) driver).getCapabilities();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public CommandExecutor getCommandExecutor() {
		return ((AppiumDriver) driver).getCommandExecutor();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public ErrorHandler getErrorHandler() {
		return ((AppiumDriver) driver).getErrorHandler();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public ExecuteMethod getExecuteMethod() {
		return ((AppiumDriver) driver).getExecuteMethod();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public FileDetector getFileDetector() {
		return ((AppiumDriver) driver).getFileDetector();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public Keyboard getKeyboard() {
		return ((AppiumDriver) driver).getKeyboard();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public Mouse getMouse() {
		return ((AppiumDriver) driver).getMouse();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public WebDriver context(String arg0) {
		return ((AppiumDriver) driver).context(arg0);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response execute(String driverCommand, Map<String, ?> parameters) {
		return ((AppiumDriver) driver).execute(driverCommand, parameters);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void performMultiTouchAction(MultiTouchAction arg0) {
		((AppiumDriver) driver).performMultiTouchAction(arg0);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public TouchAction performTouchAction(TouchAction arg0) {
		return ((AppiumDriver) driver).performTouchAction(arg0);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public String getContext() {
		return ((AppiumDriver) driver).getContext();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Set<String> getContextHandles() {
		return ((AppiumDriver) driver).getContextHandles();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public ScreenOrientation getOrientation() {
		return ((AppiumDriver) driver).getOrientation();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public URL getRemoteAddress() {
		return ((AppiumDriver) driver).getRemoteAddress();
	}

	// public X getScreenshotAs(OutputType<X>outputType){
	//
	// }

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public SessionId getSessionId() {
		return ((AppiumDriver) driver).getSessionId();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public JsonObject getSetting() {
		return ((AppiumDriver) driver).getSettings();
	}

	// @SuppressWarnings("rawtypes")
	// public int getW3StandardComplainaceLevel() {
	// return ((AppiumDriver) driver).getW3CStandardComplianceLevel();
	// }

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void rotate(ScreenOrientation arg0) {
		((AppiumDriver) driver).rotate(arg0);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public WebElement findElementByAccessibilityId(String arg0) {

		return ((AppiumDriver) driver).findElementByAccessibilityId(arg0);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<WebElement> findElementsByAccessibilityId(String arg0) {

		return ((AppiumDriver) driver).findElementsByAccessibilityId(arg0);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public Location location() {
		return ((AppiumDriver) driver).location();
	}

	// public int lockScreen(int seconds){
	// return ((AppiumDriver) driver).lockScreen(seconds);
	// }

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void setLocation(Location arg0) {
		((AppiumDriver) driver).setLocation(arg0);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void hideKeyboard() {
		((AppiumDriver) driver).hideKeyboard();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void pinch(WebElement arg0) {
		((AppiumDriver) driver).pinch(arg0);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void pinch(int x, int y) {
		((AppiumDriver) driver).pinch(x, y);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void setErrorHandler(ErrorHandler handler) {
		((AppiumDriver) driver).setErrorHandler(handler);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void setFileDetector(FileDetector detector) {
		((AppiumDriver) driver).setFileDetector(detector);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void setLogLevel(Level level) {
		((AppiumDriver) driver).setLogLevel(level);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void swipe(int startx, int starty, int endx, int endy, int duration) {
		((AppiumDriver) driver).swipe(startx, starty, endx, endy, duration);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void tap(int fingers, WebElement element, int duration) {
		((AppiumDriver) driver).tap(fingers, element, duration);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void tap(int fingers, int x, int y, int duration) {
		((AppiumDriver) driver).tap(fingers, x, y, duration);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void zoom(WebElement el) {
		((AppiumDriver) driver).zoom(el);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void zoom(int x, int y) {
		((AppiumDriver) driver).zoom(x, y);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public byte[] pullFile(String remotePath) {
		return ((AppiumDriver) driver).pullFile(remotePath);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public byte[] pullFolder(String remotePath) {
		return ((AppiumDriver) driver).pullFolder(remotePath);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void closeApp() {
		((AppiumDriver) driver).closeApp();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void installApp(String appPath) {
		((AppiumDriver) driver).installApp(appPath);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public boolean isAppInstalled(String bundleId) {
		return ((AppiumDriver) driver).isAppInstalled(bundleId);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void launchApp() {
		((AppiumDriver) driver).launchApp();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void removeApp(String bundleId) {
		((AppiumDriver) driver).removeApp(bundleId);
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void resetApp() {
		((AppiumDriver) driver).resetApp();
	}

	/**
	 * Function Applicable only when the tool used is <b>APPIUM i.e.,
	 * {@link AppiumDriver}.
	 */
	@SuppressWarnings("rawtypes")
	public void runAppInBackground(int seconds) {
		((AppiumDriver) driver).runAppInBackground(seconds);
	}

	// seeTest Methods

	/**
	 * Function Applicable only when the tool used is <b>SEETEST i.e.,
	 * {@link MobileWebDriver}.
	 */
	public Client client() {
		return ((MobileWebDriver) driver).client;
	}

	/**
	 * Function Applicable only when the tool used is <b>SEETEST i.e.,
	 * {@link MobileWebDriver}.
	 */
	public void application(String appPath) {
		((MobileWebDriver) driver).application(appPath);
	}

	/**
	 * Function Applicable only when the tool used is <b>SEETEST i.e.,
	 * {@link MobileWebDriver}.
	 */
	public MobileDevice device() {
		return ((MobileWebDriver) driver).device();
	}

	/**
	 * Function Applicable only when the tool used is <b>SEETEST i.e.,
	 * {@link MobileWebDriver}.
	 */
	public void generateReport() {
		((MobileWebDriver) driver).generateReport();
	}

	/**
	 * Function Applicable only when the tool used is <b>SEETEST i.e.,
	 * {@link MobileWebDriver}.
	 */
	public String getDeviceInformation() {
		return ((MobileWebDriver) driver).getDeviceInformation();
	}

	/**
	 * Function Applicable only when the tool used is <b>SEETEST i.e.,
	 * {@link MobileWebDriver}.
	 */
	public MobileDevice setDevice(String deviceName) {
		return ((MobileWebDriver) driver).setDevice(deviceName);
	}

	/**
	 * Function Applicable only when the tool used is <b>SEETEST i.e.,
	 * {@link MobileWebDriver}.
	 */
	public void startVideoRecord() {
		((MobileWebDriver) driver).startVideoRecord();
	}

	/**
	 * Function Applicable only when the tool used is <b>SEETEST i.e.,
	 * {@link MobileWebDriver}.
	 */
	public void stopVideoRecord() {
		((MobileWebDriver) driver).stopVideoRecord();
	}

	/**
	 * Function Applicable only when the tool used is <b>SEETEST i.e.,
	 * {@link MobileWebDriver}.
	 */
	public void useNativeIdentification() {
		((MobileWebDriver) driver).useNativeIdentification();
	}

	/**
	 * Function Applicable only when the tool used is <b>SEETEST i.e.,
	 * {@link MobileWebDriver}.
	 */
	public void useWebIdentification() {
		((MobileWebDriver) driver).useWebIdentification();
	}

	/**
	 * Function Applicable only when the tool used is <b>SEETEST i.e.,
	 * {@link MobileWebDriver}.
	 */
	public MobileDevice webForDevice(String deviceName, int timeout) {
		return ((MobileWebDriver) driver).webForDevice(deviceName, timeout);
	}
	
	//Uncomment below for Perf Insight Integration

	/**
	 * Function to Capture Performance from PerfInsight tool, applicable for WEB
	 * application
	 * 
	 *//*
	public void capturePerformance() {
		if (isWebAutomation()) {
			String methodName = getParentMethodName();
			perfObject = MetricsCollector.collectPerformanceData(methodName,
					driver.getCurrentUrl(), driver);
			if (perfObject.get("UploadStatus") == "Success") {
				report.updateTestLog(methodName,
						"Performance Captured Succuesfully", Status.DONE,
						perfObject);
			} else {
				report.updateTestLog(methodName,
						"Performance data coudlnot be Captured", Status.DONE,
						perfObject);
			}
		}
	}

	*//**
	 * Function to Capture Performance from PerfInsight tool passing Transaction
	 * Name, applicable for WEB application * @param transactionName
	 *//*
	public void capturePerformance(String transactionName) {
		if (isWebAutomation()) {
			transactionName = transactionName.replaceAll("\\s", "");
			perfObject = MetricsCollector.collectPerformanceData(
					transactionName, driver.getCurrentUrl(), driver);
			if (perfObject.get("UploadStatus") == "Success") {
				report.updateTestLog(transactionName,
						"Performance Captured Succuesfully", Status.DONE,
						perfObject);
			} else {
				report.updateTestLog(transactionName,
						"Performance data coudlnot be Captured", Status.DONE,
						perfObject);
			}
		}
	}

	private boolean isWebAutomation() {
		boolean isWebAutomation = false;
		Properties properties = Settings.getInstance();
		if ((testParameters.getMobileExecutionPlatform().toString()
				.contains("WEB") || testParameters.getExecutionMode().equals(
				ExecutionMode.LOCAL))
				&& Boolean.parseBoolean(properties
						.getProperty("InvokePerfInsightEngineForPerformance"))) {
			isWebAutomation = true;
		}
		return isWebAutomation;
	}
	
	private String getParentMethodName() {
		String methodName;
		try {
			StackTraceElement[] stacktrace = Thread.currentThread()
					.getStackTrace();
			StackTraceElement e = stacktrace[3];// maybe this number needs to be
												// corrected
			methodName = e.getMethodName();
		} catch (Exception ex) {
			methodName = "RandomTransactionName";
		}
		return methodName;
	}
*/
}
