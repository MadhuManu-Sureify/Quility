package regression;

import com.relevantcodes.extentreports.ExtentTest;

import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;
import general.Common;

/**
 * @author madhubabu
 * @date 08-Sep-2020
 */
public class KnockOutTests
{
	ExtentTest koTest;
	
	public KnockOutTests()
	{
		koTest = Suite.report.startTest("Knock-Out Scenarios");
		Suite.Tests.add(koTest);
	}
	
	public void stepI()
	{
		try 
		{
			Common.fillBasicInfo(koTest);
			Common.fillContactInfo(koTest);
			Common.fillPersonalIdInfo(koTest);
			Common.fillOccupInfo(koTest);
			Common.fillPersonalInfo(koTest);
		}
		catch (Exception e) 
		{
			WebActions.handleException(koTest, e);
		}
	}
	
	

}
