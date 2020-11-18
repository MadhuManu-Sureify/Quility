package general;

import Sureify.AutomationTemplate.AppData;
import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;

public class CovidQuestions 
{
    //As per https://sureify.atlassian.net/browse/SLA-510 
	//COVID questions will be not available only for CA, FL, ND States
	
	public static boolean isCOVIDState() 
	{
		boolean covidHitFlag = false;
		
		String state = Common.dataHash.get("State").toString();

		if(!(state.equalsIgnoreCase("CA") || state.equalsIgnoreCase("FL") || state.equalsIgnoreCase("ND")))
		{
			covidHitFlag = true;
		}

		return covidHitFlag;
	}
                
    public static void answerCOVID1(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yesCOVID1Ques);
		    	Suite.logger.info("Opted to Yes for Within the past 12 months, have you been advised by a medical professional to be quarantined, for any period of time for the novel coronavirus (COVID-19)?");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.noCOVID1Ques);
		    	Suite.logger.info("Opted to NO for Within the past 12 months, have you been advised by a medical professional to be quarantined, for any period of time for the novel coronavirus (COVID-19)?");
			}
			
		}catch(Exception cE){ System.out.println("Exception @ COVID-1 question");}
		
    }

    public static void answerCOVID2(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yesCOVID2Ques);
		    	Suite.logger.info("Opted to Yes for Within the past 12 months, have you been treated for, examined for, diagnosed with, or tested positive for the novel coronavirus (COVID-19) by a medical professional?");
			
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.noCOVID2Ques);
		    	Suite.logger.info("Opted to NO for Within the past 12 months, have you been treated for, examined for, diagnosed with, or tested positive for the novel coronavirus (COVID-19) by a medical professional?");
			}
			
		}catch(Exception cE){ System.out.println("Exception @ COVID-2 question");}
		
    }

    public static void answerCOVID3(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yesCOVID3Ques);
		    	Suite.logger.info("Opted to Yes for Within the past 30 days, have you been advised by a medical professional to get specified medical care (such as any diagnostic testing or hospitalization) which was not completed; as result of fever, cough, shortness of breath, fatigue (excluding HIV/AIDS)?");
			
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.noCOVID3Ques);
		    	Suite.logger.info("Opted to NO for Within the past 30 days, have you been advised by a medical professional to get specified medical care (such as any diagnostic testing or hospitalization) which was not completed; as result of fever, cough, shortness of breath, fatigue (excluding HIV/AIDS)?");
			}
			
		}catch(Exception cE){ System.out.println("Exception @ COVID-3 question");}
		
    }
    
}
