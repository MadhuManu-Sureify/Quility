package regression;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;

import Sureify.AutomationTemplate.AppData;
import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;

/**
 * @author madhubabu
 * @date 28-Aug-2020
 */

public class TelephonicTests 
{
	ExtentTest telePhonicTest;
	
	public TelephonicTests()
	{
		telePhonicTest = Suite.report.startTest("Telephonic Interview Scenarios Test");
		Suite.Tests.add(telePhonicTest);
	}
	
	public void teleTestScenario001()
	{
		try 
		{			
			WebActions.waitFor(AppData.continueBtn);
			String sDATE = WebActions.driver.findElement(By.xpath(AppData.dob)).getAttribute("Value");
			String baseAmount = WebActions.driver.findElement(By.xpath(AppData.coverageAmountLbl)).getText();
			
			WebActions.clickContinue();
			
			if(validateAge(sDATE, baseAmount))
			{
				WebActions.waitFor(WebActions.driver.findElement(By.id(AppData.emailAddressTxt)));
				try {
					if(WebActions.driver.findElement(By.xpath(AppData.teleInterviewDD)).isDisplayed())
					{
						WebActions.logTestPass(telePhonicTest, "Best time to call display");
					}
				}catch(Exception ex) {
					WebActions.handleException(telePhonicTest, ex);
				}
			}else 
			{
				WebActions.waitFor(WebActions.driver.findElement(By.id(AppData.emailAddressTxt)));
				try {
					if(WebActions.driver.findElement(By.xpath(AppData.teleInterviewDD)).isDisplayed())
					{
						
					}
				}catch(Exception ex) {
					WebActions.logTestPass(telePhonicTest, "Best time to call Not displayed");
				}
			}
			
		} 
		catch (Exception e) 
		{
			WebActions.handleException(telePhonicTest, e);
		}
	}
	
	
	public boolean validateAge(String sDATE, String baseAmount)
	{
		boolean teleRound = false;
		
		try 
		{
			int covAmt = Integer.parseInt(baseAmount.replaceAll("[^\\d.]", ""));
			
			LocalDate systemDate = LocalDate.now();
			Date dobDATE =  new SimpleDateFormat("MM/dd/YYYY").parse(sDATE);
			Calendar c = Calendar.getInstance();
			c.setTime(dobDATE);
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1; //Mount numbers so that'y we are adding one 
			int date = c.get(Calendar.DATE);
			LocalDate dobLocDate = LocalDate.of(year, month, date);
			
			Period differenceAGE = Period.between(dobLocDate, systemDate);
			
			//ExpressTerm Non-MED Limits Validations
			
			if((covAmt>=25000 && covAmt<=100000 && differenceAGE.getYears()>65 && differenceAGE.getYears()<76) || 
					(covAmt>=100001 && covAmt<=200000 && differenceAGE.getYears()>55 && differenceAGE.getYears()<76) ||
					(covAmt>=200001 && covAmt<=300000 && differenceAGE.getYears()>17 && differenceAGE.getYears()<76)
					)
			{
	    		System.out.println("Telephonic should be there");
	    		teleRound = true;
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return teleRound;
	}

}
