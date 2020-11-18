package general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Sureify.AutomationTemplate.AppData;
import Sureify.AutomationTemplate.DriverSetUP;
import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;

public class DocuSign 
{
    public static boolean signDocument()
    {
        boolean docuSignFlag = false;

        try 
		{
			WebActions.dynamicWait(AppData.docuSignPageHeadingLbl);
			Thread.sleep(200);

			WebElement pdfDoc = WebActions.driver.findElement(By.xpath(AppData.pdfDocument));
			
			DriverSetUP.js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", pdfDoc);
			Suite.logger.info("Scrolled to pdf end page");
			Thread.sleep(500);
			
			WebActions.dynamicWait(AppData.docuSignVerifyChkBox);
			WebActions.clickXpath(AppData.docuSignVerifyChkBox);
			Suite.logger.info("Checked Docu-Sign Verify checkbox");
			Thread.sleep(200);
			
			WebActions.dynamicWait(AppData.submitAppBtn);
			WebActions.clickXpath(AppData.submitAppBtn);
            Suite.logger.info("Application submitted");
            
            docuSignFlag = true;
			
		}catch(Exception cE){ System.out.println("Exception @ DocuSign");}

        return docuSignFlag;
    }
    
}
