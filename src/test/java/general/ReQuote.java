package general;

import Sureify.AutomationTemplate.AppData;
import Sureify.AutomationTemplate.WebActions;

public class ReQuote 
{
    public static void init()
    {
        if(!WebActions.getText(AppData.premiumFor10YearsLbl).equalsIgnoreCase("$")){
            System.out.println(WebActions.getText(AppData.premiumFor10YearsLbl));
        }else{System.out.println("No Premium shown might be Face amount and Tenure is not met with minimum criteria");}

        if(!WebActions.getText(AppData.premiumFor20YearsLbl).equalsIgnoreCase("$")){
            System.out.println(WebActions.getText(AppData.premiumFor20YearsLbl));
        }else{System.out.println("No Premium shown might be Face amount and Tenure is not met with minimum criteria");}

        if(!WebActions.getText(AppData.premiumFor25YearsLbl).equalsIgnoreCase("$")){
            System.out.println(WebActions.getText(AppData.premiumFor25YearsLbl));
        }else{System.out.println("No Premium shown might be Face amount and Tenure is not met with minimum criteria");}

        if(!WebActions.getText(AppData.premiumFor30YearsLbl).equalsIgnoreCase("$")){
            System.out.println(WebActions.getText(AppData.premiumFor30YearsLbl));
        }else{System.out.println("No Premium shown might be Face amount and Tenure is not met with minimum criteria");}

    }
    
}
