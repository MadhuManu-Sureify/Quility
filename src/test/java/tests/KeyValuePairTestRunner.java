package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Sureify.AutomationTemplate.EnvSetup;
import Sureify.AutomationTemplate.Suite;
import general.GetURL;

/**
 * @author madhubabu
 * @date 04-Sep-2020
 */
public class KeyValuePairTestRunner 
{
	@Test (enabled = true)
	public void TC_103_PROD() 
	{
		EnvSetup.siteURL_UAT = GetURL.getURLs(17);
		EnvSetup.siteURL_UAT = GetURL.getURLs(18);
		EnvSetup.siteURL_UAT = GetURL.getURLs(19);
	}
	
	
	@Test (enabled = false)
	public void TC_103_0001() 
	{
		EnvSetup.siteURL_UAT = GetURL.getURLs(27);
//		WebActions.launchSite();
//		TC103TestScenarios tc = new TC103TestScenarios();
//		tc.stepI();
	}
	
	@Test (enabled = false)
	public void TC_103_0002() 
	{
		EnvSetup.siteURL_UAT = GetURL.getURLs(28);
//		WebActions.navigateTo(Suite.siteURL_UAT);
//		TC103TestScenarios tc = new TC103TestScenarios();
//		tc.stepI();
	}
	
	@Test (enabled = false)
	public void TC_103_0003() 
	{
		EnvSetup.siteURL_UAT = GetURL.getURLs(3);
//		WebActions.navigateTo(Suite.siteURL_UAT);
//		TC103TestScenarios tc = new TC103TestScenarios();
//		tc.stepI();
	}
//	
	@Test (enabled = false)
	public void TC_103_0004() 
	{
		EnvSetup.siteURL_UAT = GetURL.getURLs(4);
	}
//	
	@Test (enabled = false)
	public void TC_103_0005() 
	{
		EnvSetup.siteURL_UAT = GetURL.getURLs(5);
	}
//	
//	@Test (enabled = true)
//	public void TC_103_0006() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(6);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0007() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(7);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0008() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(8);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0009() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(23);
////		Suite.siteURL_UAT = GetURL.getURLs(1);
//	}
	
//	@Test (enabled = true)
//	public void TC_103_0010() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(24);
////		Suite.siteURL_UAT = GetURL.getURLs(1);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0011() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(25);
////		Suite.siteURL_UAT = GetURL.getURLs(1);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0012() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(26);
////		Suite.siteURL_UAT = GetURL.getURLs(1);
//	}
	
	
//	@Test (enabled = true)
//	public void TC_103_0010() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(10);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0011() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(11);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0012() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(12);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0013() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(13);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0014() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(14);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0015() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(15);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0016() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(16);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0017() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(17);
//	}
	
//	@Test (enabled = true)
//	public void TC_103_0018() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(18);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0019() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(19);
//	}
//	
//	@Test (enabled = true)
//	public void TC_103_0020() 
//	{
//		Suite.siteURL_UAT = GetURLProd.getURLs(20);
//	}
	
	@BeforeMethod
	public void beforeTest() 
	{
//		WebActions.startRecorder();
	}
	
	@BeforeMethod
	public void afterTest() 
	{
//		  WebActions.stopRecorder();
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
