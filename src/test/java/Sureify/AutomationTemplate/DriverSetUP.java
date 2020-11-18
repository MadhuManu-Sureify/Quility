package Sureify.AutomationTemplate;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author madhubabu
 * @date 04-Sep-2020
 */
public class DriverSetUP 
{
	// public static WebDriver driver = getDriver();
	
	private static int wait;
	public static WebDriverWait w;
	public static JavascriptExecutor js;

	public static WebDriver getDriver() {

		WebDriver drVLocal = null;

		Properties properties = ConfigFileReader.readConfig();

		wait = Integer.parseInt(properties.getProperty("wait"));

		// Browser Setup

		int browserType = Integer.parseInt(properties.getProperty("Browser"));

		switch (browserType) {

			case 0:
				ChromeOptions Coptions = new ChromeOptions();
				// Coptions.setExperimentalOption("useAutomationExtension", false);
				Coptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

				WebDriverManager.chromedriver().setup();
				drVLocal = new ChromeDriver(Coptions);
			break;
			
		case 1:
			WebDriverManager.firefoxdriver().setup();
			drVLocal = new FirefoxDriver();
			break;
			
		case 2:
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			WebDriverManager.iedriver().setup();
			drVLocal = new InternetExplorerDriver();
			break;
		
		case 3:
			WebDriverManager.edgedriver().setup();
			drVLocal = new EdgeDriver();
			break;
			
		case 4:
			drVLocal = new SafariDriver();
			break;
			
		default:
			System.out.println("Invalid Browser");
		}

		w = new WebDriverWait(drVLocal, wait);
		js = (JavascriptExecutor) drVLocal;
	    drVLocal.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);


		return drVLocal;
	}

}
