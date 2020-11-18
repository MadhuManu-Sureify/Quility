package general;

import Sureify.AutomationTemplate.AppData;
import Sureify.AutomationTemplate.WebActions;

public class ThirdPartyDesignee 
{
    public static boolean isThirdPartyDesigneeApplicableState()
    {
        boolean thirdPartyDesigneeflag = false;

        String state = Common.dataHash.get("State").toString();
        if((state.equalsIgnoreCase("CA") || state.equalsIgnoreCase("CT") || state.equalsIgnoreCase("RI") || 
            state.equalsIgnoreCase("ID") || state.equalsIgnoreCase("FL")))
		{
			thirdPartyDesigneeflag = true;
		}

        return thirdPartyDesigneeflag;
    }

    public static void fillThirdPartyDesignee()
    {
        try{
            WebActions.dynamicWait(AppData.continueBtn);
            // WebActions.clickXpath(AppData.nothirdPartyDesignateQues);
            WebActions.clickContinue();
        }catch(Exception ec){System.out.println("Exception @ Third Party Designee question");}
    }
    
}
