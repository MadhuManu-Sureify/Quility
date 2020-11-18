package general;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Sureify.AutomationTemplate.AppData;
import dataProviders.JsonFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.json.simple.JSONObject;

/**
 * @author ManuTonyStark
 * @date 23-Sep-2020
 */
public class UATURLFromQuility 
{
	public static WebDriver driver;
	public static WebDriverWait w;
	public static HashMap<String,String> dataHash;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
    
    public static String getUATURL()
    {
		String url = null;
		
		setDriverUp();
		getSite();
		getQuotePage();
		url = getPremium(0);
		quitDriver();
		
        
        System.out.println("URL : " + url);
        return url;
        
    }

	public static void setDriverUp()
	{
		ChromeOptions Coptions = new ChromeOptions();
		Coptions.setExperimentalOption("useAutomationExtension", false);
		Coptions.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
//		Coptions.addArguments("headless");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		Coptions.setExperimentalOption("prefs", prefs);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(Coptions);
		
		w = new WebDriverWait(driver,60);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void quitDriver()
	{
		driver.quit();
	}

	public static void clickElement(WebElement ele)
	{
		try{
			ele.click();
		}catch(Exception e){
			js.executeScript("arguments[0].scrollIntoView();", ele);
			ele.click();

		}
	}
	
	public static void readData(int index)
	{
		try
		{
			dataHash = new HashMap<String, String>();
	    	dataHash = (JSONObject) JsonFileReader.readJSON("src/main/java/testData/dataAPI.json").get(index);
		}
		catch(Exception e)
		{
			System.out.println("Exception raised at test data reading " + e.getMessage());
		}
	}
	
	public static void getSite()
	{
		driver.get("https://dtc-dev.quility.com");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("password_protected_pass")));
		
		driver.findElement(By.id("password_protected_pass")).sendKeys("Sfglife2020");
		driver.findElement(By.id("wp-submit")).click();
	}
	
	public static void getQuotePage()
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/term-life/' and contains(text(),'Term')]")));
		driver.findElement(By.xpath("//*[@href='/term-life/' and contains(text(),'Term')]")).click();;
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Get Covered'])[1]")));
		driver.findElement(By.xpath("(//span[text()='Get Covered'])[1]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-23")));
	}
	
	public static String getPremium(int index)
	{
		readData(index);

		enterDOB(dataHash.get("DOB"));
		
		selectAmount(dataHash.get("CoverageAmount"));
		
		selectTenure(dataHash.get("PlanTenure"));
		
		selectGender(dataHash.get("Gender"));
		
		selectTobaccoUsage(dataHash.get("IsNicotineUser"));
		
		driver.findElement(By.xpath("//*[@id='input-58']")).sendKeys(dataHash.get("Zipcode"));
		
		clickElement(driver.findElement(By.xpath("//*[contains(text(), 'Calculate my quote')]")));
		
		try {Thread.sleep(2500);} catch (InterruptedException e) {}
		
		//?? Screen-1 Form Filled ??//
		
		driver.findElement(By.xpath("//*[@id='input-81']")).sendKeys(dataHash.get("FirstName"));
		
		driver.findElement(By.xpath("//*[@id='input-84']")).sendKeys(dataHash.get("LastName"));
		
		String email = dataHash.get("Email");
		email = email.replace("@sureify.com", "+" + dataHash.get("FirstName").toLowerCase() + 
				dataHash.get("LastName").toLowerCase() + "@sureify.com");
		driver.findElement(By.xpath("//*[@id='input-87']")).sendKeys(email);
		
		driver.findElement(By.xpath("//*[@id='input-90']")).sendKeys(dataHash.get("Phone"));
		
		enterAddress(dataHash.get("Address"), dataHash.get("City"));
		try{ Thread.sleep(500); }catch(Exception e) {}
		
		driver.findElement(By.xpath("//*[@class='v-btn__content' and contains(text(),'Next')]")).click();
		try{ Thread.sleep(500); }catch(Exception e) {}
		
		//?? Screen-2 Form Filled ??//
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content' and contains(text(),'Apply Now')]")));
		premiumAmountWriteToFile(dataHash.get("FirstName"));
		driver.findElement(By.xpath("//*[@class='v-btn__content' and contains(text(),'Apply Now')]")).click();
		
		// //**?? Here the Extra code later remove it ??**//
		// driver.findElement(By.xpath("//*[@class='v-btn__content' and contains(text(),'Next')]")).click();
		// w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content' and contains(text(),'Apply Now')]")));
		// premiumAmountWriteToFile(dataHash.get("FirstName"));
		// driver.findElement(By.xpath("//*[@class='v-btn__content' and contains(text(),'Apply Now')]")).click();
		// //**?? Here the Extra code later remove it ??**//
		
		// w.until(ExpectedConditions.visibilityOfElementLocated(By.id(AppData.firstNameTxt)));

		while(true)
		{
			if(driver.getCurrentUrl().contains("quility.sureify.com"))
			{
				urlInfoWriteToFile("URL for : " + dataHash.get("FirstName") + " - " + dataHash.get("State") 
							+ "\n" + driver.getCurrentUrl());
				urlInfoWriteToFile("----------------------------------------------------------------------");
				break;
			}
		}
        
        return driver.getCurrentUrl();
	}
	
	private static void premiumAmountWriteToFile(String applicantName) 
	{
		while(true)
		{
			if(!driver.findElement(By.xpath("(//div[@class='quote-number'])[1]/child::div")).getAttribute("innerHTML").contains("stupid-blank-line"))
			{
				String premiumStatus = "Premium is for : " + applicantName + " - "
						+ driver.findElement(By.xpath("(//div[@class='quote-number'])[1]/child::div")).getAttribute("innerHTML") 
						+ "\n";

				File file = new File("C:/Users/Madhubabu A/Desktop/Stuff/premiumForApplication.txt");
				FileWriter fr;
				try {
					fr = new FileWriter(file, true);
					fr.write(premiumStatus);
					fr.close();
				} catch (IOException e) {e.printStackTrace();}
				
				break;
			}
		}
	}
	
	private static void urlInfoWriteToFile(String txtInfo) 
	{
		File file = new File("C:/Users/Madhubabu A/Desktop/Stuff/GenaratedURLs.txt");
		FileWriter fr;
		try {
			fr = new FileWriter(file, true);
			fr.write(txtInfo + "\n");
			fr.close();
		} catch (IOException e) {e.printStackTrace();}
		
	}

	private static void selectAmount(String faceAmount) 
	{		
		driver.findElement(By.xpath("(//*[@class='v-select__selections'])[1]")).click();
		
		if(faceAmount.equals("100000"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='$ 100,000']")).click();
		}else if(faceAmount.equals("300000"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='$ 300,000']")).click();
		}else if(faceAmount.equals("200000"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='$ 200,000']")).click();
		}else if(faceAmount.equals("150000"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='$ 150,000']")).click();
		}else if(faceAmount.equals("250000"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='$ 250,000']")).click();
		}else if(faceAmount.equals("74999") || faceAmount.equals("75000"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='$ 75,000']")).click();
		}
	}
	
	private static void selectTenure(String tenureLength) 
	{		
		driver.findElement(By.xpath("(//*[@class='v-select__selections'])[2]")).click();
		
		if(tenureLength.equalsIgnoreCase("20 Years"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='20 Years']")).click();
		}else if(tenureLength.equalsIgnoreCase("10 Years"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='10 Years']")).click();
		}else if(tenureLength.equalsIgnoreCase("30 Years"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='30 Years']")).click();
		}else if(tenureLength.equalsIgnoreCase("25 Years"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='25 Years']")).click();
		}
	}
	
	private static void selectGender(String gender) 
	{		
		driver.findElement(By.xpath("(//*[@class='v-select__selections'])[3]")).click();
		
		if(gender.equalsIgnoreCase("Male"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='Male']")).click();
		}else if(gender.equalsIgnoreCase("Female"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='Female']")).click();
		}
	}
	
	private static void selectTobaccoUsage(String nicotineUse) 
	{		
		driver.findElement(By.xpath("(//*[@class='v-select__selections'])[4]")).click();
		
		if(nicotineUse.equalsIgnoreCase("false") || nicotineUse.equalsIgnoreCase("No"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='No']")).click();
		}else if(nicotineUse.equalsIgnoreCase("true") || nicotineUse.equalsIgnoreCase("Yes"))
		{
			driver.findElement(By.xpath("//*[@class='v-list-item__title' and text()='Yes']")).click();
		}
	}
	
	private static void enterAddress(String add, String city) 
	{
		Actions builder=new Actions(driver);
		
		WebElement streetAddressTxt = driver.findElement(By.xpath("//*[@id='map']"));
		String address = add + " " + city;
		
		streetAddressTxt.sendKeys(address);
		try{ Thread.sleep(1000); }catch(Exception e) {}
		builder.sendKeys(Keys.ARROW_DOWN).click().build().perform();
		builder.sendKeys(Keys.ENTER).click().build().perform();
		
		try{ Thread.sleep(500); }catch(Exception e) {}
	}
	
	private static void enterDOB(String dob) 
	{
		String stringDOB = null;
		
		try
		{
			Date dobDate =  new SimpleDateFormat("yyyy-MM-dd").parse(dob);
			SimpleDateFormat format = new SimpleDateFormat("MMddyyyy");
			stringDOB = format.format(dobDate).toString();
			
			LocalDate systemDate = LocalDate.now();
			Calendar c = Calendar.getInstance();
			c.setTime(dobDate);
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int date = c.get(Calendar.DATE);
			LocalDate dobLocDate = LocalDate.of(year, month, date);
			Period differenceAGE = Period.between(dobLocDate, systemDate);
			
			urlInfoWriteToFile("Age Difference : " + differenceAGE.getYears() + " Years " + differenceAGE.getMonths() 
			+ " Months " + differenceAGE.getDays() + " Days");
			
			if(differenceAGE.getMonths() > 6 || (differenceAGE.getMonths() == 6 && differenceAGE.getDays() > 0))
			{
				int roundedAge = differenceAGE.getYears() + 1;
				urlInfoWriteToFile("Applicant nearest age : " + roundedAge);
			}else if(differenceAGE.getMonths() < 6 || (differenceAGE.getMonths() == 6 && differenceAGE.getDays() == 0))
			{
				int roundedAge = differenceAGE.getYears();
				urlInfoWriteToFile("Applicant nearest age : " + roundedAge);
			}
			
		}
		catch(Exception e){System.out.println(e.getMessage());}
		
		driver.findElement(By.xpath("//*[@id='input-23']")).sendKeys(stringDOB);
		
	}

}