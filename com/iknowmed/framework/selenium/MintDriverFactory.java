package com.iknowmed.framework.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.iknowmed.framework.FrameworkException;
import com.iknowmed.framework.Settings;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MintDriverFactory {

	private static Properties mobileProperties;
	private MintDriverFactory() {
		// To prevent external instantiation of this class
	}
	@SuppressWarnings("rawtypes")
	public static AppiumDriver getMintAppiumDriver(
			MobileExecutionPlatform executionPlatform, String deviceName,
			String host,String mobileVersion) {

		AppiumDriver driver = null;
		mobileProperties = Settings.getMobilePropertiesInstance();
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("username",
				mobileProperties.getProperty("MintUsername"));
		desiredCapabilities.setCapability("password",
				mobileProperties.getProperty("MintPassword"));
		try {
			switch (executionPlatform) {

			case ANDROID:

				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("deviceName", deviceName);
				// desiredCapabilities.setCapability("deviceID",deviceName);
				desiredCapabilities.setCapability("version", mobileVersion);
				desiredCapabilities.setCapability("app",
						mobileProperties
								.getProperty("MintAndroidApplicationName"));
				
				try {
					driver = new AndroidDriver(new URL(host),
							desiredCapabilities);

				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The android driver invocation has problem, please re-check the capabilities and check the Mint details URL,username, and password");
				}
				break;

			case IOS:

				desiredCapabilities.setCapability("platformName", "ios");
				desiredCapabilities.setCapability("deviceName", deviceName);
				// desiredCapabilities.setCapability("deviceID",deviceName);
				desiredCapabilities.setCapability("version", mobileVersion);
				desiredCapabilities.setCapability("app",
						mobileProperties.getProperty("MintiOSApplicationName"));
				try {
					driver = new IOSDriver(new URL(host),
							desiredCapabilities);

				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The IOS driver invocation has problem, please re-check the capabilities and check the Mint details URL,username, and password");
				}
				break;

			case WEB_ANDROID:

				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("deviceName", deviceName);
				// desiredCapabilities.setCapability("deviceID",deviceName);
				desiredCapabilities.setCapability("version", mobileVersion);
				desiredCapabilities.setCapability("browserName", "Chrome");
				try {
					driver = new AndroidDriver(new URL(host),
							desiredCapabilities);
				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The android driver invocation has problem, please check the capabilities and check the Mint details URL,username, and password");
				}
				break;

			case WEB_IOS:
				
				desiredCapabilities.setCapability("platformName", "ios");
				desiredCapabilities.setCapability("deviceName", deviceName);
				// desiredCapabilities.setCapability("deviceID",deviceName);
				desiredCapabilities.setCapability("version", mobileVersion);

				desiredCapabilities.setCapability("browserName", "Safari");
				try {
					driver = new IOSDriver(new URL(host),
							desiredCapabilities);

				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The IOS driver invocation has problem, please check the capabilities and check the Mint details URL,username, and password");
				}
				break;

			default:
				throw new FrameworkException("Unhandled ExecutionMode!");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new FrameworkException(
					"The Mint appium driver invocation created a problem , please check the capabilities");
		}

		return driver;

	}
	
}