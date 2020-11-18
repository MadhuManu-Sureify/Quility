package regression;

import com.relevantcodes.extentreports.ExtentTest;

import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;
import general.Common;

/**
 * @author madhubabu
 * @date 04-Sep-2020
 */
public class KeyValuePairTestScenarios 
{
	ExtentTest keyValuePairTest;
	
	public KeyValuePairTestScenarios()
	{
		keyValuePairTest = Suite.report.startTest("TC-103 Scenarios Test");
		Suite.Tests.add(keyValuePairTest);
	}
	
	public void stepI()
	{
		try 
		{
			Common.fillBasicInfo(keyValuePairTest);
			Common.fillContactInfo(keyValuePairTest);
			Common.fillPersonalIdInfo(keyValuePairTest);
		}
		catch (Exception e) 
		{
			WebActions.handleException(keyValuePairTest, e);
		}
	}
	

}
