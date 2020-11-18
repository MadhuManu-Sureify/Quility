package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Sureify.AutomationTemplate.DriverSetUP;
import Sureify.AutomationTemplate.EnvSetup;
import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;
import dataProviders.JsonFileReader;
import regression.KnockOutTests;

/**
 * @author ManuTonyStark
 * @date 08-Sep-2020
 */

public class KnockOutTestRunner 
{
	@Test (enabled = true, dataProvider = "KODataSets")
	public void REG_Quility_0001() 
	{
		KnockOutTests k = new KnockOutTests();
		k.stepI();
	}

	@DataProvider(name = "KODataSets")
	public JSONObject readTestData() 
	{
		return (JSONObject) JsonFileReader.readJSON().get(0);
    }
	
	@BeforeMethod
	
	public void beforeTest() 
	{
//		WebActions.startRecorder();
		EnvSetup.envSetup();
		// WebActions.launchSite(D);
	}

	@AfterMethod
	public void am() 
	{
		// DriverSetUP.closeDriver(WebActions.driver);
		// WebActions.stopRecorder();
	}

	@BeforeSuite
	public void beforeSuite() 
	{
		Suite.suitUp();
	}
	 
	@AfterSuite
	public void afterSuite() 
	{
		Suite.suitTearDown();
	}

}
