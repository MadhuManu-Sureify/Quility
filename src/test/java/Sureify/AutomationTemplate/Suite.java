package Sureify.AutomationTemplate;

/**
 * @author Madhu Babu
 * @date 11-Mar-2020
 * @desc This Class for set up the driver instance for given browser with the given configuration
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Suite
{
	public static ExtentReports report;
	public static ArrayList<ExtentTest> Tests;
	public static ExtentTest testInfo;
	// public static boolean cutURL = false;
	
	public static HashMap<String, String> dataHash;
	
	public static Logger logger;
	public static FileHandler fileTxt;
	public static SimpleFormatter formatterTxt;
	
	public static void suitUp()
	{
		try 
		{	        
	        //Reports Setup
	        Tests = new ArrayList<ExtentTest>();
	        Tests.add(testInfo);
	        report = new ExtentReports(System.getProperty("user.dir") + "/target/Report/TestReport_" + new SimpleDateFormat("yyyyMMddHHmm").format(new Date()) + ".html");
	        
	        testInfo = report.startTest("Test Information");
		}
		catch(Exception e){
			System.out.println("Error");
			System.out.println(e.getMessage());
		}
		
		//Logger Setup
		logger = Logger.getLogger("");
	    logger.setLevel(Level.INFO);
	    
	    try {
			fileTxt = new FileHandler("QuilityEventLogs.txt");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	    formatterTxt = new SimpleFormatter();
	    fileTxt.setFormatter(formatterTxt);
	    logger.addHandler(fileTxt);
		
	    //Testdata Setup
		// try 
		// {
		// 	Properties properties = ConfigFileReader.readConfig();

	    // 	dataHash = new HashMap<String, String>();
	    // 	if(properties.getProperty("TelephonicScenario").equalsIgnoreCase("true"))
	    // 	{
		// 		// Read telephonic data
	    // 		dataHash = ExcelFileReader.readExcel(properties.getProperty("TestData"), "TelephonicInterviewTestData");
	    // 	}
	    // 	else if(properties.getProperty("TelephonicScenario").equalsIgnoreCase("false"))
	    // 	{
	    // 		dataHash = ExcelFileReader.readExcel(properties.getProperty("TestData"), "TestData");
	    // 	}
	    // }
	    // catch(Exception e)
	    // {
	    // 	System.out.println(e.getMessage());
	    // }
	}
	
	public static void suitTearDown()
	{
		for(int i = 0; i<Tests.size(); i++)
		{			
			report.endTest(Tests.get(i));
		}
		
		//Reports save
		report.flush();
		
	}
}
