package com.iknowmed.framework.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.iknowmed.framework.FrameworkException;
import com.iknowmed.framework.Settings;

public class BrowserStackDriverFactory {

	private BrowserStackDriverFactory() {
		// To prevent external instantiation of this class
	}

	/**
	 * Function to return the BrowserStack DesktopCloud {@link RemoteWebDriver}
	 * object based on the parameters passed
	 * 
	 * @param platformName
	 *            The platform to be used for the test execution (Windows, Mac,
	 *            etc.)
	 * @param version
	 *            The browser version to be used for the test execution
	 * @param browserName
	 *            The {@link Browser} to be used for the test execution
	 * @param BrowserStackURL
	 *            The BrowserStack URL to be used for the test execution
	 * @return The corresponding {@link RemoteWebDriver} object
	 */

	public static WebDriver getBrowserStackRemoteWebDriver(String browserStackURL,
			Browser browser, String browserVersion, Platform platformName,
			SeleniumTestParameters testParameters) {
		WebDriver driver = null;
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platform", platformName);
		desiredCapabilities.setCapability("browser_version", browserVersion);
		desiredCapabilities.setCapability("browser", browser);
		// desiredCapabilities.setCapability("screen-resolution","800x600");
		try {
			driver = new RemoteWebDriver(new URL(browserStackURL), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new FrameworkException(
					"The RemoteWebDriver/Browser invokation has problem, please re-check the capabilities and check the BrowserStack details URL, Username and accessKey ");
		}
		return driver;
	}

	
	public static WebDriver getBrowserStackRemoteWebDriverMobile(
			MobileExecutionPlatform executionPlatform, String deviceName,
			String browserStackURL, SeleniumTestParameters testParameters) {

		WebDriver driver = null;
		Settings.getMobilePropertiesInstance();

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		try {
			switch (executionPlatform) {

			case WEB_ANDROID:

				desiredCapabilities.setCapability("browser", "Android");
				//	desiredCapabilities.setCapability("platform", "WINDOWS");
					desiredCapabilities.setCapability("device", deviceName);
				//	desiredCapabilities.setCapability("browserstack.debug", "true");
					desiredCapabilities.setCapability("build",
							testParameters.getCurrentTestcase());

				try {
					driver = new RemoteWebDriver(new URL(browserStackURL), desiredCapabilities);
				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The RemoteWebDriver/browser invokation has problem, please re-check the capabilities and check the BrowserStack details URL, Username and accessKey ");
				}
				break;

			case WEB_IOS:

				desiredCapabilities.setCapability("browser", "iPhone");
			//	desiredCapabilities.setCapability("platform", "MAC");
				desiredCapabilities.setCapability("device", deviceName);
			//	desiredCapabilities.setCapability("browserstack.debug", "true");
				desiredCapabilities.setCapability("build",
						testParameters.getCurrentTestcase());

				try {
					driver = new RemoteWebDriver(new URL(browserStackURL), desiredCapabilities);

				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The RemoteWebDriver invokation/browser has problem, please re-check the capabilities and check the BrowserStack details URL, Username and accessKey ");
				}
				break;

			default:
				throw new FrameworkException("Unhandled ExecutionMode!");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new FrameworkException(
					"The BrowserStack driver invocation created a problem , please check the capabilities");
		}
		return driver;

	}

}
