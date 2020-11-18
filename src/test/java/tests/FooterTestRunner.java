// package tests;

// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.AfterTest;
// import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.BeforeTest;
// import org.testng.annotations.Test;

// import Sureify.AutomationTemplate.Suite;
// import Sureify.AutomationTemplate.WebActions;
// import modules.Footer;

// /**
//  * @author madhubabu
//  * @date 04-Aug-2020
//  * @desc This is the test runner class for web page footer testing 
//  */
// public class FooterTestRunner 
// {
// 	@Test (enabled = true)
// 	public void footerTest() 
// 	{
// 		Footer ft = new Footer();
// 		WebActions.launchSite();
// 		ft.footerTest();
// 	}
	
// 	@BeforeTest
// 	public void beforeTest() 
// 	{
// 		  /*
// 		   * Start the recorder instance before the every test
// 		   */
		  
// //		 WebActions.startRecorder();	  
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
