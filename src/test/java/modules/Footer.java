package modules;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import Sureify.AutomationTemplate.AppData;
import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;

/**
 * @author madhubabu
 * @date 21-Apr-2020
 */
public class Footer {
	
	ExtentTest footerTest;
	WebDriver dr = WebActions.driver;
	
	public Footer()
	{
		footerTest = Suite.report.startTest("Footer Test");
		Suite.Tests.add(footerTest);
	}
	
	public void footerTest()
	{
		///////////////////////////////////////
		//			Link Section - 1		//
		//	Quility Communication Links		//
		//////////////////////////////////////
		
		Suite.logger.info("Validating number");
		validateUI(AppData.number, "Number");
		
		///////////////////////////////////////
		//			Link Section - 2		//
		//		Quility Generic Links		//
		//////////////////////////////////////
		
		Suite.logger.info("Validating Home link");
		validateUI(AppData.home_Link, "Home");
		validateFC(AppData.home_Link, "About Us");
		
		Suite.logger.info("Validating About Us link");
		validateUI(AppData.aboutUS_Link, "About Us Link");
		validateFC(AppData.aboutUS_Link, "About Us");
		
		Suite.logger.info("Validating Get a Quote link");
		validateUI(AppData.getAQuote_Link, "Get a Quote Link");
		validateFC(AppData.getAQuote_Link, "");
		
		Suite.logger.info("Validating News link");
		validateUI(AppData.news_Link, "News Link");		
		validateFC(AppData.news_Link, "");
		
		Suite.logger.info("Validating Blog link");
		validateUI(AppData.blog_Link, "Blog Link");		
		validateFC(AppData.blog_Link, "");
		
		Suite.logger.info("Validating Life Insurance 101 link");
		validateUI(AppData.li101_Link, "Life Insurance 101 Link");		
		validateFC(AppData.li101_Link, "");
		
		Suite.logger.info("Validating Help Center link");
		validateUI(AppData.helpCenter_Link, "Help Center Link");		
		validateFC(AppData.helpCenter_Link, "");
		
		Suite.logger.info("Validating Contact Us link");
		validateUI(AppData.contactUS_Link, "ContactUS Link");
		validateFC(AppData.contactUS_Link, "Contact Us");
		
		///////////////////////////////////////
		//			Link Section - 3		//
		//			Quility LIC Rights		//
		//////////////////////////////////////
		
		Suite.logger.info("Validating Contact Us link");
		validateUI(AppData.rights_text, "Rights");

	}
	
	public void validateUI(String loc, String ele_Desc)
	{
		try {
			if(WebActions.validateElement(loc)) {
				WebActions.logTestPass(footerTest, ele_Desc);
			}else {
				WebActions.logTestFail(footerTest, loc);
			}
		}catch(Exception e) {
			WebActions.handleException(footerTest, e);
		}
	}
	
	public void validateFC(String loc, String ele_Desc)
	{
		try {
			WebActions.clickXpath(loc);
			Thread.sleep(500);
			
			String parentWinHandle = dr.getWindowHandle();
			Set<String> allWindowHandles = dr.getWindowHandles();
			System.out.println(allWindowHandles.size());
			
			for(String handle: allWindowHandles) {
				if(!handle.equals(parentWinHandle)) {
					dr.switchTo().window(handle);
					Thread.sleep(1000);

		            if(dr.getTitle().contains(ele_Desc)) {
		            	WebActions.logTestPass(footerTest, ele_Desc + " Functional ");
					}else {
						WebActions.logTestFail(footerTest, loc);
					}
	            }
	        }
			
			dr.close();
	        dr.switchTo().window(parentWinHandle);
	        
		}catch(Exception e) {
			System.out.println(e.getMessage());
			WebActions.handleException(footerTest, e);
			
		}
	}
	
}
