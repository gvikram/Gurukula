package com.org.gurukula.common;


import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.google.common.base.Throwables;
//import com.org.gurukula.listener.EventListener;
import com.org.gurukula.pages.LoginPage;





/**
 * The Class Driver Configuration.
 */
public class DriverConfig {

	
	final static Logger logger = LoggerFactory.getLogger(LoginPage.class);

	
	
	/** The web driver thread. */
	private static ThreadLocal<EventFiringWebDriver> webDriverThread = new ThreadLocal<EventFiringWebDriver>();

	/**
	 * Gets the browser driver.
	 * 
	 * @param context
	 *            the context
	 * @return the browser driver
	 */
	@BeforeMethod(alwaysRun = true)
	public static WebDriver initializeDriver(final ITestContext context) {
		
		//InternetExplorerDriverService service;
		String browser = ConfigValues.browserName;
		WebDriver webDriver = null;
		switch (browser) {
		case "firefox":
			webDriver = createFFDriver();
			break;
		case "chrome":
			webDriver = createChromeDriver();
			break;
		case "ie":
			webDriver = createIEDriver();
			break;
		default:
			break;
		}

		registerDriver(webDriver);
		return webDriver;
	}

	/**
	 * After test.
	 *
	 * @param context the context
	 */
	@AfterMethod(alwaysRun = true)
	public void afterTest(final ITestContext context) {
		logger.info("Driver closed and Test completed");
		getDriver().manage().deleteAllCookies();
		getDriver().quit();

	}

	/**
	 * Register driver.
	 * 
	 * @param webDriver
	 *            the web driver
	 */
	public static void registerDriver(final WebDriver webDriver) {

		//final EventListener eventListener = new EventListener();
		final EventFiringWebDriver efd = new EventFiringWebDriver(webDriver);
		//efd.register(eventListener);
		webDriverThread.set(efd);
	}

	/**
	 * Gets the driver.
	 * 
	 * @return the driver
	 */
	public static EventFiringWebDriver getDriver() {

		return webDriverThread.get();
	}

	/**
	 * Creates the ff driver.
	 * 
	 * @return the web driver
	 */
	private static WebDriver createFFDriver() {

		return new FirefoxDriver();
	}

	
	
	/**
	 * Creates the chrome driver.
	 * 
	 * @return the web driver
	 */
	private static WebDriver createChromeDriver() {
		System.out.println("user.dir: "+System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separatorChar + "drivers" + File.separatorChar + "chromedriver.exe");
		return new ChromeDriver();	
	}

	
	
	/**
	 * Creates the ie driver.
	 * 
	 * @return the web driver
	 */
	private static WebDriver createIEDriver() {
		System.out.println("user.dir: "+System.getProperty("user.dir"));
		System.setProperty("webdriver.ie.driver",
				System.getProperty("user.dir") + File.separatorChar + "drivers" + File.separatorChar + "IEDriverServer.exe");
		final InternetExplorerDriverService service;
		service = new InternetExplorerDriverService.Builder()
				.usingAnyFreePort()
				.withLogFile(new File("./TestOutput/Logs/IEDriver.log"))
				.withLogLevel(InternetExplorerDriverLogLevel.TRACE)
				.build();
		try {
			service.start();
		} catch (IOException e) {
			throw Throwables.propagate(e);
		}
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				service.stop();
			}
		});

		DesiredCapabilities capability = DesiredCapabilities
				.internetExplorer();
		capability
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		
		return new InternetExplorerDriver(service, capability);
		
		
	}
}
