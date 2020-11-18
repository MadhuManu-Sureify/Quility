// package tests;

// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.AfterTest;
// import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.BeforeTest;
// import org.testng.annotations.Test;

// import Sureify.AutomationTemplate.EnvSetup;
// import Sureify.AutomationTemplate.Suite;
// import Sureify.AutomationTemplate.WebActions;
// import regression.TelephonicTests;

// /**
//  * @author madhubabu
//  * @date 28-Aug-2020
//  */
// public class TelephonicTestRunner 
// {
// 	@Test (enabled = true)
// 	public void REG_Quility_0001() 
// 	{
// 		TelephonicTests tt = new TelephonicTests();
// 		tt.teleTestScenario001();
		
// 	}
	
// 	@BeforeTest
// 	public void beforeTest() 
// 	{
// //		WebActions.startRecorder();
// 		EnvSetup.envSetup();
// 		System.out.println("URL got launched");
// 		WebActions.launchSite();
// 	 }

// 	 @AfterTest
// 	 public void afterTest() 
// 	 {
// 		  /*
// 		   * Stops the running recording instance after the every test
// 		   */
// //		  WebActions.stopRecorder();
// 	 }

// 	 @BeforeSuite
// 	 public void beforeSuite() 
// 	 {
// 		  //SuiteUp Driver, WebDriver, Reports 
// 		  Suite.suitUp();
// 	 }
	 
// 	 @AfterSuite
// 	 public void afterSuite() 
// 	 {
// 		  /*
// 		   * Suite tear down, reports flush
// 		   */
// 		  Suite.suitTearDown();
// 	  }


// }
