package regression;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;
import general.Common;

/**
 * @author MadhuTonyStark
 * @date 14-May-2020
 */
public class ApplicationFlowI {
	
	ExtentTest regression;
	
	public ApplicationFlowI()
	{
		regression = Suite.report.startTest("Regression Application Flow I");
		Suite.Tests.add(regression);
	}
	
	public void startFlow(int index)
	{
		Common.loadTestData(index);

		Common.fillBasicInfo(regression);
		
		Common.fillContactInfo(regression);
		
		Common.fillPersonalIdInfo(regression);
		
		Common.fillOccupInfo(regression); 
		
		if(!Common.fillPersonalInfo(regression))
		{
			Common.answerExistingPolicyQuestions(regression);
		
			Common.answerTobaccoUsageQuestion(regression);

			if(!Common.answerMedicalHistoryQuestion(regression))
			{
				Common.fillBeneficiary(regression);
			
				Common.reviewPage(regression);

				Common.reQuotePage(regression);
				
				Common.paymentPage(regression);
				
				Common.doDocuSign(regression);
				
				Common.thankYouPage(regression);

			}else{
				System.out.println("Knockout @ Medical History");
				regression.log(LogStatus.INFO, "Applicant got Knockout @ Medical History, Due to Knockout Scenario");
			}

		}else{
			System.out.println("Knockout @ Build chart validation");
			regression.log(LogStatus.INFO, "Applicant got Knockout @ Personal Information, Due to Height and weight Knockout Scenario");
		}
		
	}

}
