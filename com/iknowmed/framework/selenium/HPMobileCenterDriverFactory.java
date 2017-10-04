package com.iknowmed.framework.selenium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.iknowmed.framework.FrameworkException;
import com.iknowmed.framework.Settings;

public class HPMobileCenterDriverFactory {

	private static Properties mobileProperties;

	private HPMobileCenterDriverFactory() {
		// To prevent external instantiation of this class
	}

	/** 
	 * @param platformName
	 *            The platform to be used for the test execution (Windows, Mac,
	 *            etc.)
	 * @param version
	 *            The browser version to be used for the test execution
	 * @param browserName
	 *            The {@link Browser} to be used for the test execution
	 * @param sauceUrl
	 *            The MobileCenter URL to be used for the test execution
	 * @return The corresponding {@link AppiumDriver} object
	 */

	@SuppressWarnings("rawtypes")
	public static AppiumDriver getMobileCenterAppiumDriver(
			MobileExecutionPlatform executionPlatform, String deviceName,
			String mobileCenterURL) {
		AppiumDriver driver = null;
		mobileProperties = Settings.getMobilePropertiesInstance();

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("userName",
				mobileProperties.getProperty("MobileCenterUser"));
		desiredCapabilities.setCapability("password",
				mobileProperties.getProperty("MobileCenterPassword"));
		try {
			switch (executionPlatform) {

			case ANDROID:
				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("deviceName", deviceName);
				desiredCapabilities.setCapability("appPackage",
						mobileProperties
								.getProperty("Application_Package_Name"));
				desiredCapabilities.setCapability("appActivity",
						mobileProperties
								.getProperty("Application_MainActivity_Name"));
				// desiredCapabilities.setCapability("app",
				// "PUBLIC:appium/apiDemos.apk");
				try {
					driver = new AndroidDriver(new URL(mobileCenterURL),
							desiredCapabilities);
				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The android driver invokation has problem, please re-check the capabilities and check the mobileCenter details URL, Username and Password ");
				}

				break;

			case IOS:

				desiredCapabilities.setCapability("platformName", "ios");
				desiredCapabilities.setCapability("deviceName", deviceName);
				desiredCapabilities.setCapability("newCommandTimeout", 120);
				desiredCapabilities.setCapability("bundleId",
						mobileProperties.getProperty("iPhoneBundleID"));
				// desiredCapabilities.setCapability("app",
				// "PUBLIC:appium/apiDemos.ipa");

				try {
					driver = new IOSDriver(new URL(mobileCenterURL),
							desiredCapabilities);

				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The IOS driver invokation has problem, please re-check the capabilities and check the mobileCenter details URL, Username and Password ");
				}
				break;

			case WEB_ANDROID:

				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("deviceName", deviceName);
				desiredCapabilities.setCapability("browserName", "Chrome");

				try {
					driver = new AndroidDriver(new URL(mobileCenterURL),
							desiredCapabilities);
				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The android driver/browser invokation has problem, please re-check the capabilities and check the mobileCenter details URL, Username and Password ");
				}
				break;

			case WEB_IOS:

				desiredCapabilities.setCapability("platformName", "ios");
				desiredCapabilities.setCapability("deviceName", deviceName);
				desiredCapabilities.setCapability("browserName", "Safari");

				try {
					driver = new IOSDriver(new URL(mobileCenterURL),
							desiredCapabilities);

				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The IOS driver invokation/browser has problem, please re-check the capabilities and check the mobileCenter details URL, Username and Password ");
				}
				break;

			default:
				throw new FrameworkException("Unhandled ExecutionMode!");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new FrameworkException(
					"The mobileCenter appium driver invocation created a problem , please check the capabilities");
		}
		return driver;

	
	}

}
