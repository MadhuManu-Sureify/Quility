package regression;

import com.relevantcodes.extentreports.ExtentTest;

import Sureify.AutomationTemplate.Suite;
import general.Common;

/**
 * @author madhubabu
 * @date 04-Sep-2020
 */

public class ApplicationFlowII 
{
	ExtentTest regression;	
	
	public ApplicationFlowII()
	{
		regression = Suite.report.startTest("Regression Application Flow II");
		Suite.Tests.add(regression);
	}
	
	public void startFlow(int index)
	{
		Common.loadTestData(index);
		
		Common.fillBasicInfo(regression);
		
		Common.fillContactInfo(regression);
		
		Common.fillPersonalIdInfo(regression);
		
		Common.fillOccupInfo(regression); 
		
		Common.fillPersonalInfo(regression);
		
		Common.answerExistingPolicyQuestions(regression);
		
		Common.answerTobaccoUsageQuestion(regression);
		
//		Common.answerMedicalHistoryQuestion(regression);
//		
//		Common.fillBeneficiary(regression);
//		
//		Common.reviewPage(regression);
//		
//		Common.paymentPage(regression);
		
//		Common.doDocuSign();
//		WebActions.logTestPass(regression, "Docusign page");
		
	}

}
