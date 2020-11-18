package general;

import Sureify.AutomationTemplate.AppData;
import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;

import org.openqa.selenium.By;

public class Beneficiary 
{
    public static boolean addPrimaryBeneficiary(int benfCt)
    {
        boolean benfAddFlag = false;
        try
        {
            if(benfCt == 1)
            {
                benfAddFlag = addBenficiary();
            }
            else
            {
                for(int nestedBenf = 1; nestedBenf <= benfCt; nestedBenf++)
                {
                    benfAddFlag = addBenficiary();

                    if(nestedBenf != benfCt)
                    {
                        WebActions.dynamicWait(AppData.addBenfBtn);
                        WebActions.clickXpath(AppData.addBenfBtn);
                    }
                    
                }
            }

        } catch (Exception e) {
            System.out.println("Exceptin occured @ Adding Beneficiary");
        }

        return benfAddFlag;
    }

    public static boolean addContingentBeneficiary(int contBenfCt)
    {
        boolean benfAddFlag = false;
        try
        {
            if(contBenfCt == 1)
            {
                benfAddFlag = addContingentBenficiary();
            }
            else
            {
                for(int nestedBenf = 1; nestedBenf <= contBenfCt; nestedBenf++)
                {
                    benfAddFlag = addContingentBenficiary();
                }
            }

        } catch (Exception e) {
            System.out.println("Exceptin occured @ Adding Beneficiary");
        }

        return benfAddFlag;
    }

    private static boolean addBenficiary()
    {
        boolean benfAddFlag = false;

        try
        {
            WebActions.waitFor(WebActions.driver.findElement(By.id(AppData.benfFirstNameTxt)));
			
            WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.benfFirstNameTxt)), Common.dataHash.get("BeneficiaryName").toString());
            Thread.sleep(200);
            Suite.logger.info("Entered benf first name");
            
            WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.benfRelationDD)), Common.dataHash.get("BeneficiaryRelation").toString());
            Thread.sleep(200);
            Suite.logger.info("Entered benf relation");
            
            WebActions.sendKeys(WebActions.driver.findElements(By.id(AppData.benfSSNTxt)).get(1), Common.dataHash.get("BenfSSN").toString());
            // WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.benfSSNTxt)), "999999999");
            Thread.sleep(200);
            Suite.logger.info("Entered benf SSN");
            
            WebActions.sendKeys(WebActions.driver.findElements(By.id(AppData.benfShareAllocTxt)).get(1), Common.dataHash.get("BenfAllocation").toString());
            // WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.benfShareAllocTxt)), "100");
            Thread.sleep(200);
            Suite.logger.info("Entered benf share allocation");
            
            WebActions.dynamicWait(AppData.saveBtn);
            WebActions.clickXpath(AppData.saveBtn);
            Thread.sleep(200);
            Suite.logger.info("Benf added");

            benfAddFlag = true;

        }catch(Exception e){
            System.out.println("Exceptin occured @ Adding Beneficiary");
        }

        return benfAddFlag;
    }

    private static boolean addContingentBenficiary()
    {
        boolean benfAddFlag = false;

        try
        {
            WebActions.dynamicWait(AppData.addContBenfBtn);
            WebActions.clickXpath(AppData.addContBenfBtn);

            WebActions.waitFor(WebActions.driver.findElement(By.id(AppData.contBenfFirstNameTxt)));
        
            WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.contBenfFirstNameTxt)), Common.dataHash.get("ContBeneficiaryName").toString());
            Thread.sleep(200);
            Suite.logger.info("Entered contingent benf first name");
            
            WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.contBenfRelationDD)), Common.dataHash.get("ContBeneficiaryRelation").toString());
            Thread.sleep(200);
            Suite.logger.info("Entered contingent benf relation");
            
            WebActions.sendKeys(WebActions.driver.findElements(By.id(AppData.contBenfSSNTxt)).get(1), Common.dataHash.get("ContBenfSSN").toString());
            Thread.sleep(200);
            Suite.logger.info("Entered contingent benf SSN");
            
            WebActions.sendKeys(WebActions.driver.findElements(By.id(AppData.contBenfShareAllocTxt)).get(1), Common.dataHash.get("ContBenfAllocation").toString());
            Thread.sleep(200);
            Suite.logger.info("Entered contingent benf share allocation");
            
            WebActions.dynamicWait(AppData.saveBtn);
            WebActions.clickXpath(AppData.saveBtn);
            Thread.sleep(200);
            Suite.logger.info("Contingent Benf added");

            benfAddFlag = true;

        }catch(Exception e){
            System.out.println("Exceptin occured @ Adding Contingent Beneficiary");
        }

        return benfAddFlag;
    }

}
