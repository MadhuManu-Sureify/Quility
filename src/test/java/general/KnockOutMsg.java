package general;

import org.openqa.selenium.By;

import Sureify.AutomationTemplate.AppData;
import Sureify.AutomationTemplate.DriverSetUP;
import Sureify.AutomationTemplate.WebActions;

public class KnockOutMsg 
{
    public static boolean isDisplayed()
    {
        return WebActions.isDisplayed(AppData.knockOutPopUp);
    }

    public static boolean isEnabled()
    {   
        return DriverSetUP.getDriver().findElement(By.xpath(AppData.knockOutPopUp)).isEnabled();
    }
    
}
