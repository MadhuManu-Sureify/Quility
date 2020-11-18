package general;

import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.AppData;
import Sureify.AutomationTemplate.WebActions;

/**
 * @author ManuTonyStark
 * @date 21-Sep-2020
 */

public class SuppApp
{
    public static void answer4(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				//Yet to Implement
				Suite.logger.info("Opted to Yes for Have you used tobacco or nicotine products in the past 36 months (excluding chewing tobacco or snuff)?");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no4Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to No for Have you used tobacco or nicotine products in the past 36 months (excluding chewing tobacco or snuff)?");
			}
			
		}catch(Exception cE){ System.out.println("Exception @ 4 question");}
		
    }

    public static void answer5(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				//Yet to Implement
				Suite.logger.info("Opted to Yes for Have you used chewing tobacco or snuff in the past 36 months? If YES, you may apply for Preferred Tobacco rates.");

			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
		    	WebActions.clickXpath(AppData.no5Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to NO for Have you used chewing tobacco or snuff in the past 36 months? If YES, you may apply for Preferred Tobacco rates.");
			}

			WebActions.clickContinue();
			
		}catch(Exception cE){ System.out.println("Exception @ 5 question");}
		
    }

    public static void answer6(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes6Ques);
		    	Thread.sleep(200);
				Suite.logger.info("Opted to Yes for In the past 10 years, if you have taken medication to treat high blood pressure, did your last blood pressure reading exceed 140/90?");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no6Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to No for In the past 10 years, if you have taken medication to treat high blood pressure, did your last blood pressure reading exceed 140/90?");
			}
			
		}catch(Exception cE){ System.out.println("Exception @ 6 question");}
		
    }

    public static void answer7(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes7Ques);
		    	Thread.sleep(200);
				Suite.logger.info("Opted to Yes for In the past 10 years, if you have taken medication to treat high cholesterol, did your last cholesterol reading exceed 240 mg/dl?");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no7Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to No for In the past 10 years, if you have taken medication to treat high cholesterol, did your last cholesterol reading exceed 240 mg/dl?");
			}
			
		}catch(Exception cE){ System.out.println("Exception @ 7 question");}
		
    }

    public static void answer8(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes8Ques);
				Thread.sleep(200);
				Suite.logger.info("Opted to Yes for In the past 10 years, have you, received treatment for or been diagnosed by a medical professional that you have diabetes?");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no8Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to No for In the past 10 years, have you, received treatment for or been diagnosed by a medical professional that you have diabetes?");
			}
			
		}catch(Exception cE){ System.out.println("Exception @ 8 question");}
		
    }

    public static void answer9(String userAnswer)
	{
		try 
		{
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes9Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to Yes for In the past 10 years, have you, received treatment for or been diagnosed by a medical professional that you have cancer or cardiac disease (heart attack, myocardial infarct, angina, cardiac insufficiency, cerebral thrombosis or coronary artery disease)?");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no9Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to No for In the past 10 years, have you, received treatment for or been diagnosed by a medical professional that you have cancer or cardiac disease (heart attack, myocardial infarct, angina, cardiac insufficiency, cerebral thrombosis or coronary artery disease)?");
			}
		}catch(Exception cE){ System.out.println("Exception @ 9 question");}
		
    }

    public static void answer10(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes10Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to Yes for Has more than one member of your family (father, mother, brother or sister) died before age 60 from breast, colon, intestinal or prostate cancer, or from cardiovascular disease (heart attack, myocardial infarct, angina, cardiac insufficiency, cerebral thrombosis or coronary artery disease)?");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no10Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to No for Has more than one member of your family (father, mother, brother or sister) died before age 60 from breast, colon, intestinal or prostate cancer, or from cardiovascular disease (heart attack, myocardial infarct, angina, cardiac insufficiency, cerebral thrombosis or coronary artery disease)?");
			}
			
			WebActions.clickContinue();
			
		}catch(Exception cE){ System.out.println("Exception @ 10 question");}
		
    }

    public static void answer11(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes11Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to Yes for In the past 10 years, have you been treated for alcohol abuse by a medical professional?");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no11Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to No for In the past 10 years, have you been treated for alcohol abuse by a medical professional?");
			}
			
		}catch(Exception cE){ System.out.println("Exception @ 11 question");}
		
    }

    public static void answer12(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes12Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to Yes for In the past 10 years, have you been treated for drug abuse by a medical professional?");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no12Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to No for In the past 10 years, have you been treated for drug abuse by a medical professional?");
			}

			WebActions.clickContinue();
			
		}catch(Exception cE){ System.out.println("Exception @ 12 question");}
		
    }

    public static void answer13(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes13Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to Yes for In the past 5 years, have you either been found guilty of or been convicted of more than two moving motor vehicle violations or any DUI/DWI convictions?");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no13Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to No for In the past 5 years, have you either been found guilty of or been convicted of more than two moving motor vehicle violations or any DUI/DWI convictions?");
			}
			
		}catch(Exception cE){ System.out.println("Exception @ 13 question");}
		
    }

    public static void answer14(String userAnswer)
	{
		try 
		{
            if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes14Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to Yes for In the past 5 years, have you been convicted of a felony or misdemeanor?");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
		    	WebActions.clickXpath(AppData.no14Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to No for In the past 5 years, have you been convicted of a felony or misdemeanor?");
			}

			WebActions.clickContinue();
			
		}catch(Exception cE){ System.out.println("Exception @ 14 question");}
		
    }
    
}