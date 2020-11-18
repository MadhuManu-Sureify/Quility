package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Sureify.AutomationTemplate.DriverSetUP;
import Sureify.AutomationTemplate.EnvSetup;
import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;
import regression.ApplicationFlowI;

/**
 * @author ManuTonyStark
 * @date 14-May-2020
 * @desc This is the main runner class for regression test cases execution
 */
public class RegressionTestRunner 
{
	protected JSONObject dataHash;
	
	@Test (enabled = true)
	public void REG_Quility_0001() 
	{
		ApplicationFlowI f1 = new ApplicationFlowI();
		f1.startFlow(0);
	}
	
	@Test (enabled = true)
	public void REG_Quility_0002() 
	{
		ApplicationFlowI f1 = new ApplicationFlowI();
		f1.startFlow(1);
	}

	@Test (enabled = true)
	public void REG_Quility_0003() 
	{
		ApplicationFlowI f1 = new ApplicationFlowI();
		f1.startFlow(2);
	}

	@Test (enabled = true)
	public void REG_Quility_0004() 
	{
		ApplicationFlowI f1 = new ApplicationFlowI();
		f1.startFlow(3);
	}

	@Test (enabled = true)
	public void REG_Quility_0005() 
	{
		ApplicationFlowI f1 = new ApplicationFlowI();
		f1.startFlow(4);
	}

	@Test (enabled = true)
	public void REG_Quility_0006() 
	{
		ApplicationFlowI f1 = new ApplicationFlowI();
		f1.startFlow(5);
	}

	@Test (enabled = true)
	public void REG_Quility_0007() 
	{
		ApplicationFlowI f1 = new ApplicationFlowI();
		f1.startFlow(6);
	}

	@Test (enabled = true)
	public void REG_Quility_0008() 
	{
		ApplicationFlowI f1 = new ApplicationFlowI();
		f1.startFlow(7);
	}

	@Test (enabled = true)
	public void REG_Quility_0009() 
	{
		ApplicationFlowI f1 = new ApplicationFlowI();
		f1.startFlow(8);
	}

	@Test (enabled = true)
	public void REG_Quility_0010() 
	{
		ApplicationFlowI f1 = new ApplicationFlowI();
		f1.startFlow(9);
	}

	@BeforeMethod
	public void bm() 
	{
		EnvSetup.envSetup();
		WebActions.launchSite(DriverSetUP.getDriver());
		// WebActions.startRecorder();
	}
	
	@AfterMethod
	public void am() 
	{
		WebActions.quit();
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
