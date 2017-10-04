package com.iknowmed.framework.selenium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.iknowmed.framework.FrameworkException;
import com.iknowmed.framework.Settings;

public class PerfectoDriverFactory {

	private static Properties mobileProperties;

	private PerfectoDriverFactory() {
		// To prevent external instantiation of this class
	}

	private static URL getUrl(String remoteUrl) {
		URL url;
		try {
			url = new URL(remoteUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new FrameworkException(
					"The specified remote URL is malformed");
		}
		return url;
	}

	/**
	 * Function to return the Perfecto MobileCloud {@link RemoteWebDriver}
	 * object based on the parameters passed
	 * 
	 * @param deviceId
	 *            The ID of the Perfecto MobileCloud device to be used for the
	 *            test execution
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @param remoteUrl
	 *            The Perfecto MobileCloud URL to be used for the test execution
	 * @return The corresponding {@link RemoteWebDriver} object
	 */
	public static WebDriver getPerfectoRemoteWebDriver(String deviceId,
			Browser browser, String remoteUrl) {
		DesiredCapabilities desiredCapabilities = getPerfectoExecutionCapabilities(browser);
		desiredCapabilities.setCapability("deviceName", deviceId);

		URL url = getUrl(remoteUrl);

		return new RemoteWebDriver(url, desiredCapabilities);
	}

	private static DesiredCapabilities getPerfectoExecutionCapabilities(
			Browser browser) {
		validatePerfectoSupports(browser);

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName(browser.getValue());
		desiredCapabilities.setPlatform(Platform.ANY);
		desiredCapabilities.setJavascriptEnabled(true); // Pre-requisite for
														// remote execution

		mobileProperties = Settings.getMobilePropertiesInstance();
		desiredCapabilities.setCapability("user",
				mobileProperties.getProperty("PerfectoUser"));
		desiredCapabilities.setCapability("password",
				mobileProperties.getProperty("PerfectoPassword"));

		return desiredCapabilities;
	}

	private static void validatePerfectoSupports(Browser browser) {
		switch (browser) {
		case INTERNET_EXPLORER:
		case FIREFOX:
		case HTML_UNIT:
		case OPERA:
			throw new FrameworkException("The browser " + browser.toString()
					+ " is not supported on the Perfecto MobileCloud");

		default:
			break;
		}
	}

	/**
	 * Function to return the Perfecto MobileCloud {@link RemoteWebDriver}
	 * object based on the parameters passed
	 * 
	 * @param platformName
	 *            The device platform to be used for the test execution (iOS,
	 *            Android, etc.)
	 * @param platformVersion
	 *            The device platform version to be used for the test execution
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @param remoteUrl
	 *            The Perfecto MobileCloud URL to be used for the test execution
	 * @return The corresponding {@link RemoteWebDriver} object
	 */
	public static WebDriver getPerfectoRemoteWebDriverByDevicePlatform(
			String deviceId, String osVersionVersion, Browser browser,
			String remoteUrl, MobileExecutionPlatform executionPlatform) {
		String platformName = "";
		if (executionPlatform.equals("WEB_ANDROID")) {
			platformName = "Android";
		} else if (executionPlatform.equals("WEB_IOS")) {
			platformName = "ios";
		}
		DesiredCapabilities desiredCapabilities = getPerfectoExecutionCapabilities(browser);
		desiredCapabilities.setBrowserName(browser.getValue());
		desiredCapabilities.setCapability("platformName", platformName);
		desiredCapabilities.setCapability("platformVersion", osVersionVersion);

		URL url = getUrl(remoteUrl);

		return new RemoteWebDriver(url, desiredCapabilities);
	}

	/**
	 * Function to return the Perfecto MobileCloud {@link RemoteWebDriver}
	 * object based on the parameters passed
	 * 
	 * @param manufacturer
	 *            The manufacturer of the device to be used for the test
	 *            execution (Samsung, Apple, etc.)
	 * @param model
	 *            The device model to be used for the test execution (Galaxy S6,
	 *            iPad Air, etc.)
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @param remoteUrl
	 *            The Perfecto MobileCloud URL to be used for the test execution
	 * @return The corresponding {@link RemoteWebDriver} object
	 */
	public static WebDriver getPerfectoRemoteWebDriverByDeviceModel(
			String manufacturer, String model, Browser browser, String remoteUrl) {
		DesiredCapabilities desiredCapabilities = getPerfectoExecutionCapabilities(browser);
		desiredCapabilities.setCapability("manufacturer", manufacturer);
		desiredCapabilities.setCapability("model", model);

		URL url = getUrl(remoteUrl);

		return new RemoteWebDriver(url, desiredCapabilities);
	}

	@SuppressWarnings("rawtypes")
	public static AppiumDriver getPerfectoAppiumDriver(
			MobileExecutionPlatform executionPlatform, String deviceName,
			String perfectoURL) {

		AppiumDriver driver = null;
		mobileProperties = Settings.getMobilePropertiesInstance();

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("user",
				mobileProperties.getProperty("PerfectoUser"));
		desiredCapabilities.setCapability("password",
				mobileProperties.getProperty("PerfectoPassword"));
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
					driver = new AndroidDriver(new URL(perfectoURL),
							desiredCapabilities);
				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The android driver invokation has problem, please re-check the capabilities and check the perfecto details URL, Username and Password ");
				}

				break;

			case IOS:

				desiredCapabilities.setCapability("platformName", "ios");
				desiredCapabilities.setCapability("deviceName", deviceName);
				desiredCapabilities.setCapability("newCommandTimeout", 120);
				desiredCapabilities.setCapability("bundleId",
						mobileProperties.getProperty("PerfecttoIosBundleID"));
				// desiredCapabilities.setCapability("app",
				// "PUBLIC:appium/apiDemos.ipa");

				try {
					driver = new IOSDriver(new URL(perfectoURL),
							desiredCapabilities);

				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The IOS driver invokation has problem, please re-check the capabilities and check the perfecto details URL, Username and Password ");
				}
				break;

			case WEB_ANDROID:

				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("deviceName", deviceName);
				desiredCapabilities.setCapability("browserName", "Chrome");

				try {
					driver = new AndroidDriver(new URL(perfectoURL),
							desiredCapabilities);
				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The android driver/browser invokation has problem, please re-check the capabilities and check the perfecto details URL, Username and Password ");
				}
				break;

			case WEB_IOS:

				desiredCapabilities.setCapability("platformName", "ios");
				desiredCapabilities.setCapability("deviceName", deviceName);
				desiredCapabilities.setCapability("automationName", "Appium");
				desiredCapabilities.setCapability("browserName", "Safari");

				try {
					driver = new IOSDriver(new URL(perfectoURL),
							desiredCapabilities);

				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The IOS driver invokation/browser has problem, please re-check the capabilities and check the perfecto details URL, Username and Password ");
				}
				break;

			default:
				throw new FrameworkException("Unhandled ExecutionMode!");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new FrameworkException(
					"The perfecto appium driver invocation created a problem , please check the capabilities");
		}
		return driver;

	}

	public static WebDriver getPerfectoRemoteWebDriver(
			MobileExecutionPlatform executionPlatform, String deviceName,
			String perfectoURL, Browser browser) {

		WebDriver driver = null;
		mobileProperties = Settings.getMobilePropertiesInstance();

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("user",
				mobileProperties.getProperty("PerfectoUser"));
		desiredCapabilities.setCapability("password",
				mobileProperties.getProperty("PerfectoPassword"));
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
				try {
					driver = new RemoteWebDriver(new URL(perfectoURL),
							desiredCapabilities);
				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The android driver invokation has problem, please re-check the capabilities");
				}

				break;

			case IOS:

				desiredCapabilities.setCapability("platformName", "ios");
				desiredCapabilities.setCapability("deviceName", deviceName);
				desiredCapabilities.setCapability("newCommandTimeout", 120);
				desiredCapabilities.setCapability("bundleId",
						mobileProperties.getProperty("PerfecttoIosBundleID"));
				// desiredCapabilities.setCapability("app",
				// "PUBLIC:appium/apiDemos.ipa");

				try {
					driver = new RemoteWebDriver(new URL(perfectoURL),
							desiredCapabilities);

				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The IOS driver invokation has problem, please re-check the capabilities");
				}
				break;

			case WEB_ANDROID:

				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("deviceName", deviceName);
				desiredCapabilities.setCapability("browserName", "Chrome");
				try {
					driver = new RemoteWebDriver(new URL(perfectoURL),
							desiredCapabilities);
				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The android driver/browser invokation has problem, please check the capabilities");
				}
				break;

			case WEB_IOS:

				desiredCapabilities.setCapability("platformName", "ios");
				desiredCapabilities.setCapability("deviceName", deviceName);
				desiredCapabilities.setCapability("automationName", "Appium");
				desiredCapabilities.setCapability("browserName", "Safari");

				try {
					driver = new RemoteWebDriver(new URL(perfectoURL),
							desiredCapabilities);

				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The IOS driver/browser invokation has problem, please check the capabilities");
				}
				break;

			default:
				throw new FrameworkException("Unhandled ExecutionMode!");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new FrameworkException(
					"Failed to launch RemoteWebDriver for Perfecto, please check the Perfecto details");
		}

		return driver;

	}
}
