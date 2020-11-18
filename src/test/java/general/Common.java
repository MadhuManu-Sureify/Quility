package general;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;

import Sureify.AutomationTemplate.AppData;
import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;
import dataProviders.JsonFileReader;

/**
 * @author ManuTonyStark
 * @date 14-May-2020
 */

public class Common 
{
	static Boolean teleInterviewHit = false;
	static String sDATE;
	static String baseAmount;
	static JSONObject dataHash;
	
	Logger logger = Suite.logger;

	public static void loadTestData(int index)
	{
		try{
			dataHash =  (JSONObject) JsonFileReader.readJSON().get(index);
	    	System.out.println("Test Data Set Total Records: " + dataHash.size());
		}catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public static void fillBasicInfo(ExtentTest test)
	{
		try 
		{
			if(dataHash.get("State").toString().equalsIgnoreCase("CA"))
			{
				WebActions.dynamicWait(AppData.caPTChkBox);
				WebActions.clickXpath(AppData.caPTChkBox);
				Suite.logger.info("Checked Privacy Notification 3640-CA");

				WebActions.clickContinue();
			}

			WebActions.waitFor(WebActions.driver.findElement(By.id(AppData.firstNameTxt)));

			if(!(dataHash.get("MiddleName") == null))
			{
				WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.middleNameTxt)), dataHash.get("MiddleName").toString());
				Thread.sleep(100);
		    	Suite.logger.info("Entered the middle name");
			}
	    	
	    	WebActions.clickContinue();
	    	
	    	Thread.sleep(100);
	    	
	    	WebActions.logTestPass(test, "Basic Information");
	    	
		}catch(Exception e) {
			
			WebActions.handleException(test, e);
			e.printStackTrace();
		}
	}
	
	public static void fillContactInfo(ExtentTest test)
	{
		try 
		{
			WebActions.waitFor(WebActions.driver.findElement(By.id(AppData.emailAddressTxt)));
			WebActions.waitFor(WebActions.driver.findElement(By.id(AppData.phoneTxt)));

			if(telePhonicCriteria())
			{
				WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.teleInterviewDD)), dataHash.get("BestTimeToCall").toString());
				Suite.logger.info("Choosed Best time to call");
			}			
	    	try{Thread.sleep(2000);}catch(Exception to){};
	    	WebActions.clickContinue();
	    	WebActions.logTestPass(test, "Contact Information");
	    	
		}catch(Exception e) {
			WebActions.handleException(test, e);
			System.out.println("Message at contact info feed " + e.getMessage());
		}
	}
	
	public static void fillPersonalIdInfo(ExtentTest test)
	{
		try {
			
			Thread.sleep(200);
//			WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.ssnTxt)), "999999999");
			WebActions.sendKeys(WebActions.driver.findElements(By.id(AppData.ssnTxt)).get(1), dataHash.get("SSN").toString());
			Suite.logger.info("Entered SSN");
			Thread.sleep(200);
	    	
			if(dataHash.get("DrivingLicence").toString().equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.drivingLYesBtn);
		    	Suite.logger.info("Opted to driving license to Yes");
		    	Thread.sleep(300);
		    	
		    	WebActions.sendKeys(WebActions.driver.findElements(By.id(AppData.drivingLNoTxt)).get(1), dataHash.get("DrivingLicenceNo").toString());
//		    	WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.drivingLNoTxt)), "1234ABCD5678");
		    	Suite.logger.info("Entered License Number");
		    	
		    	WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.drivingLStateofIssueDD)), dataHash.get("DrivingLicenceStateOFIssue").toString());
				Suite.logger.info("Choosed occupation");
			}
			else if(dataHash.get("DrivingLicence").toString().equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.drivingLNoBtn);
				Suite.logger.info("Opted to driving license to No");
				WebActions.sendKeys(WebActions.driver.findElements(By.id(AppData.drivingLNoExplainTxt)).get(1), dataHash.get("DrivingLicenceNoExplain").toString());
				Suite.logger.info("Choosed No to Driving license");
				
				if(dataHash.get("ValidStateID").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.clickXpath(AppData.validStateYesBtn);
					Suite.logger.info("Opted to valid state ID to Yes");
					WebActions.sendKeys(WebActions.driver.findElements(By.id(AppData.stateIDNoTxt)).get(1), dataHash.get("StateIDNo").toString());
					Suite.logger.info("Entered valid state id number");
				}if(dataHash.get("ValidStateID").toString().equalsIgnoreCase("No"))
				{
					WebActions.clickXpath(AppData.validStateNoBtn);
					Suite.logger.info("Opted to valid state ID to No");
				}
			}
			
			//State of Birth
			if(dataHash.get("StateofBirth").toString().equalsIgnoreCase("Not Born In US"))
			{
				WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.stateOfBirthDD)), dataHash.get("StateofBirth").toString());
				Suite.logger.info("Opted to Not born in US");
				
				WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.countryOfBirthDD)), dataHash.get("CountryOfBirth").toString());
				Suite.logger.info("Opted to State of birth");
			}
			else
			{
				WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.stateOfBirthDD)), dataHash.get("StateofBirth").toString());
		    	Thread.sleep(100);
		    	Suite.logger.info("Choosed state of birth");
			}
	    	
	    	WebActions.clickContinue();
	    	WebActions.logTestPass(test, "Personal Identification Information");
	    	
		}catch(Exception e) {
			WebActions.handleException(test, e);
			System.out.println(e.getMessage());
		}
	}	
	
	public static void fillOccupInfo(ExtentTest test)
	{
		try {
			WebActions.dynamicWait(AppData.occupationDD);
			Thread.sleep(200);
	    	
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.occupationDD)), dataHash.get("Occupation").toString());
			Suite.logger.info("Choosed occupation");
			
			WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.annualIncomeTxt)), dataHash.get("Networth").toString());
	    	Thread.sleep(200);
	    	Suite.logger.info("Entered income");
	    	
	    	WebActions.clickContinue();
	    	
	    	WebActions.logTestPass(test, "Occupational Information");
    	
		}catch(Exception e) {
			WebActions.handleException(test, e);
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean fillPersonalInfo(ExtentTest test)
	{
		boolean koSKIP = false;

		try {
			WebActions.waitFor(WebActions.driver.findElement(By.id(AppData.heightFtTxt)));
			Thread.sleep(200);
			
			BuildChart.heightFt = Integer.parseInt(dataHash.get("HeightFt").toString());

			WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.heightFtTxt)), dataHash.get("HeightFt").toString());
	    	Thread.sleep(200);
	    	Suite.logger.info("Entered Height in Ft");
			
			BuildChart.heightInch = Integer.parseInt(dataHash.get("HeightInch").toString());
	    	WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.heightInchTxt)), dataHash.get("HeightInch").toString());
	    	Thread.sleep(200);
	    	Suite.logger.info("Entered Height in inch");
			
			BuildChart.weight = Integer.parseInt(dataHash.get("Weight").toString());
	    	WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.weightTxt)), dataHash.get("Weight").toString());
	    	Thread.sleep(200);
	    	Suite.logger.info("Entered Weight");
	    	
			WebActions.clickContinue();
			
	    	WebActions.logTestPass(test, "Personal Information");
    	
		}catch(Exception e) {
			WebActions.handleException(test, e);
			System.out.println(e.getMessage());
		}

		if(BuildChart.isBuildChartKO())
		{
			koSKIP = true;
		}

		return koSKIP;
	}
	
	public static void answerExistingPolicyQuestions(ExtentTest test)
	{
		boolean existingIns = false;
		boolean existingInsuKO = false;
		
		try 
		{			
			WebActions.dynamicWait(AppData.noOtherPoliciesAndCoveragesQues);
			
			if(dataHash.get("ExisitingInsurance").toString().equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yesOtherPoliciesAndCoveragesQues);
				existingIns = true;
				Thread.sleep(100);
		    	Suite.logger.info("Opted to Yes for Existing Policy question");
				
				if(dataHash.get("ReplaceExistingLife-DisabilityInsurancePolicy").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.clickXpath(AppData.yesReplacementQues);
					existingInsuKO = true;
		    		Suite.logger.info("Opted to Yes for Existing Policy Replacement question. This is the Knock Out Scenario.");
				}else if(dataHash.get("ReplaceExistingLife-DisabilityInsurancePolicy").toString().equalsIgnoreCase("No"))
				{
					WebActions.clickXpath(AppData.noReplacementQues);
		    		Suite.logger.info("Opted to No for Existing Policy Replacement question.");
		    		Thread.sleep(100);
				}
		    	
		    	//State based questions
		    	if(dataHash.get("State").toString().equalsIgnoreCase("CA") || dataHash.get("State").toString().equalsIgnoreCase("ND") || dataHash.get("State").toString().equalsIgnoreCase("FL"))
				{
		    		if(dataHash.get("ReplacementContract").toString().equalsIgnoreCase("Yes"))
					{
						WebActions.clickXpath(AppData.yesReplacementContractQues);
						existingInsuKO = true;
			    		Suite.logger.info("Opted to Yes for Existing Policy Replacement contract question. This is the Knock Out Scenario.");
					}else if(dataHash.get("ReplacementContract").toString().equalsIgnoreCase("No"))
					{
						WebActions.clickXpath(AppData.noReplacementContractQues);
			    		Suite.logger.info("Opted to No for Existing Policy Replacement contract question.");
			    		Thread.sleep(100);
					}
		    		
		    		if(dataHash.get("ReplacingFundsTransfer").toString().equalsIgnoreCase("Yes"))
					{
						WebActions.clickXpath(AppData.yesReplacingFundsTransferQues);
						existingInsuKO = true;
			    		Suite.logger.info("Opted to Yes for Existing Policy Replacement Funds transfer question. This is the Knock Out Scenario.");
					}else if(dataHash.get("ReplacingFundsTransfer").toString().equalsIgnoreCase("No"))
					{
						WebActions.clickXpath(AppData.noReplacingFundsTransferQues);
			    		Suite.logger.info("Opted to No for Existing Policy Replacement funds transfer question.");
			    		Thread.sleep(100);
					}
				}
		    	
			}
		    else if(dataHash.get("ExisitingInsurance").toString().equalsIgnoreCase("No"))
			{
			    	WebActions.clickXpath(AppData.noOtherPoliciesAndCoveragesQues);
			    	Thread.sleep(100);
			    	Suite.logger.info("Opted to NO for Existing Policy question");
			}
			
			if(existingIns == true && existingInsuKO == false)
			{
				WebActions.clickContinue();
				addExistingInsurance();
			}
	    	
	    	WebActions.clickContinue();
	    	Suite.logger.info("Continue to Tobacco Usage Question");
	    	
	    	WebActions.logTestPass(test, "Existing policy Information");
			
		}catch(Exception e) 
		{
			WebActions.handleException(test, e);
			System.out.println(e.getMessage());
		}
	}
	
	public static void answerTobaccoUsageQuestion(ExtentTest test)
	{
		try 
		{
			WebActions.dynamicWait(AppData.noTobaccoQues);
			
			if(dataHash.get("TobaccoUsage").toString().equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yesTobaccoQues);
				Suite.logger.info("Opted to Yes for tobacco question");
				Thread.sleep(100);
				
			}
			else if(dataHash.get("TobaccoUsage").toString().equalsIgnoreCase("No"))
			{
		    	WebActions.clickXpath(AppData.noTobaccoQues);
		    	Thread.sleep(100);
		    	Suite.logger.info("Opted to NO for tobacco question");
			}
	    	
	    	WebActions.clickContinue();
	    	Suite.logger.info("Continue to Medical History Question");
	    	
	    	WebActions.logTestPass(test, "Tobacco usage Information");
			
		}catch(Exception e) {
			WebActions.handleException(test, e);
		System.out.println(e.getMessage());
		}
	}	
	
	public static boolean answerMedicalHistoryQuestion(ExtentTest test)
	{
		boolean koSKIP = false;

		try 
		{
			if(MedicalHistory.answer1A(dataHash.get("1AQues").toString())){
				if(KnockOutMsg.isDisplayed()){
					WebActions.logTestPass(test, AppData.knockOutPopUp);
					koSKIP = true;
					
				}else{
					WebActions.logTestFail(test, AppData.knockOutPopUp);
				}
			}

			if(!koSKIP){
				if(MedicalHistory.answer1B(dataHash.get("1BQues").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}
			
			if(!koSKIP){
				if(MedicalHistory.answer1C(dataHash.get("1CQues").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}

			if(!koSKIP){
				if(MedicalHistory.answer1D(dataHash.get("1DQues").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}

			if(!koSKIP){
				if(MedicalHistory.answer1E(dataHash.get("1EQues").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}

			if(!koSKIP){
				if(MedicalHistory.answer1F(dataHash.get("1FQues").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}

			if(!koSKIP){
				if(MedicalHistory.answer2(dataHash.get("2Ques").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}

			if(!koSKIP){
				if(MedicalHistory.answer3A(dataHash.get("3AQues").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}

			if(!koSKIP){
				if(MedicalHistory.answer3B(dataHash.get("3BQues").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}

			if(!koSKIP){
				if(MedicalHistory.answer3C(dataHash.get("3CQues").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}

			if(!koSKIP){
				if(MedicalHistory.answer3D(dataHash.get("3DQues").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}

			if(!koSKIP){
				if(MedicalHistory.answer3E(dataHash.get("3EQues").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}

			if(!koSKIP){
				if(MedicalHistory.answer3F(dataHash.get("3FQues").toString())){
					if(KnockOutMsg.isDisplayed()){
						WebActions.logTestPass(test, AppData.knockOutPopUp);
						koSKIP = true;
						
					}else{
						WebActions.logTestFail(test, AppData.knockOutPopUp);
					}
				}
			}

			// Supplementary Application Questionnaire 
			if(!koSKIP){
				if(BuildChart.isStandard()) {
					System.out.println("Applicant is Standard No Supp App Question");

				}else if(!BuildChart.isStandard()) {
					System.out.println("Applicant is Preferred Supp App Question will be there");
					SuppApp.answer4(dataHash.get("4Ques").toString());
					SuppApp.answer5(dataHash.get("5Ques").toString());
					SuppApp.answer6(dataHash.get("6Ques").toString());
					SuppApp.answer7(dataHash.get("7Ques").toString());
					SuppApp.answer8(dataHash.get("8Ques").toString());
					SuppApp.answer9(dataHash.get("9Ques").toString());
					SuppApp.answer10(dataHash.get("10Ques").toString());
					SuppApp.answer11(dataHash.get("11Ques").toString());
					SuppApp.answer12(dataHash.get("12Ques").toString());
					SuppApp.answer13(dataHash.get("13Ques").toString());
					SuppApp.answer14(dataHash.get("14Ques").toString());
				}
			}
			
			// CovidQuestionnaire 
			if(!koSKIP) {
				if(CovidQuestions.isCOVIDState()) {
					CovidQuestions.answerCOVID1(dataHash.get("COVID1Ques").toString());
					CovidQuestions.answerCOVID2(dataHash.get("COVID2Ques").toString());
					CovidQuestions.answerCOVID3(dataHash.get("COVID3Ques").toString());
				}

				WebActions.clickContinue();
			}

	    	WebActions.logTestPass(test, "Medical Information");
	    	
		}catch(Exception e) {
			WebActions.handleException(test, e);
		System.out.println(e.getMessage());
		}

		return koSKIP;
	}
		
	public static void fillBeneficiary(ExtentTest test)
	{
		try 
		{
			int benfNo = Integer.parseInt(dataHash.get("BeneficiariesCt").toString());
			if(Beneficiary.addPrimaryBeneficiary(benfNo))
			{
				WebActions.clickContinue();
			}
	    	
	    	//Conti Benf			
			if(dataHash.get("ContBeneficiaries").toString().equalsIgnoreCase("Yes"))
			{
				int contBenfNo = Integer.parseInt(dataHash.get("ContBeneficiariesCt").toString());
				Beneficiary.addContingentBeneficiary(contBenfNo);
			}

			WebActions.clickContinue();

	    	WebActions.logTestPass(test, "Beneficiary Information");
	    	
		}catch(Exception e) {
			WebActions.handleException(test, e);
			System.out.println(e.getMessage());
		}	
	}
	
	public static void reviewPage(ExtentTest test)
	{
		try {
			WebActions.waitFor(AppData.reviewPageHeadingLbl);
			WebActions.clickXpath(AppData.personalExpand);
			WebActions.clickXpath(AppData.insurHistoryExpand);
			WebActions.clickXpath(AppData.medicalHistoryExpand);
			WebActions.clickXpath(AppData.benfExpand);
			Thread.sleep(500);
			
			WebActions.clickContinue();
			Suite.logger.info("Review page continue");
			
			WebActions.logTestPass(test, "Review page");
			
		}catch(Exception e) {
			WebActions.handleException(test, e);
			System.out.println(e.getMessage());
		}	
	}
	
	public static void reQuotePage(ExtentTest test)
	{
		try {
			WebActions.dynamicWait(AppData.finishAppBtn);
			
			// ReQuote.init();

			WebActions.clickXpath(AppData.finishAppBtn);
			
			Suite.logger.info("Requote page continue");
			WebActions.logTestPass(test, "Requote Page");			
		}catch(Exception e) {
			WebActions.handleException(test, e);
			System.out.println(e.getMessage());
		}	
	}
	
	public static void paymentPage(ExtentTest test)
	{
		try 
		{
			WebActions.waitFor(AppData.paymentPageHeadingLbl);
			
			// WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.accountHolderNameTxt)), dataHash.get("AccountHolderName").toString());
			// Thread.sleep(100);
			// Suite.logger.info("Entered account holder name");
			
			WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.bankNameTxt)), dataHash.get("BankName").toString());
			Thread.sleep(100);
			Suite.logger.info("Entered bank name");
			
			WebActions.sendKeys(WebActions.driver.findElements(By.id(AppData.bankRoutingNumberTxt)).get(1), dataHash.get("BankRoutingNumber").toString());
//			WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.bankRoutingNumberTxt)), dataHash.get("BankRoutingNumber"));
			Thread.sleep(100);
			Suite.logger.info("Entered bank routing number");
			
			WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.bankAccountNumberTxt)), dataHash.get("BankAccountNumber").toString());
			Thread.sleep(200);
			Suite.logger.info("Entered bank account number");
			
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.monthlyDraftDateDD)), dataHash.get("BankDraftDate").toString());
			Thread.sleep(200);
			Suite.logger.info("Choosed Monthly Draft date");
			
			if(dataHash.get("AccountType").toString().equalsIgnoreCase("Savings"))
			{
				WebActions.clickXpath(AppData.savingsAccountBtn);
				Suite.logger.info("Opted savings account");
			}
			else if(dataHash.get("AccountType").toString().equalsIgnoreCase("Checking"))
			{
				WebActions.clickXpath(AppData.checkingAccountBtn);
				Suite.logger.info("Opted Checking account");
			}
			
			WebActions.clickXpath(AppData.accountVerifyChkBox);
			Suite.logger.info("Bank information confirmation");
			
			WebActions.dynamicWait(AppData.continueBtn);
			WebActions.clickContinue();
			Thread.sleep(200);

			//Payment third party designate(It's optional)

			if(ThirdPartyDesignee.isThirdPartyDesigneeApplicableState())
			{
				ThirdPartyDesignee.fillThirdPartyDesignee();
			}
			
			WebActions.logTestPass(test, "Payment page");
			Suite.logger.info("Payment page continue");
			
		}catch(Exception e) {
			WebActions.handleException(test, e);
			System.out.println(e.getMessage());
		}	
	}
	
	public static void doDocuSign(ExtentTest test) 
	{
		DocuSign.signDocument();
	}
	
	public static void thankYouPage(ExtentTest test) 
	{
		WebActions.dynamicWait(AppData.thankYouPageHeadingLbl);
		
		Suite.logger.info("Thank you page shown" + "\n" + "Record Number: " + 
				WebActions.driver.findElement(By.xpath(AppData.recordNumberLbl)).getText());
		
	}
	
	public static String getApplicantState() 
	{
		return WebActions.driver.findElement(By.xpath(AppData.stateItemInDD)).getText();
	}
	
	public static void addExistingInsurance()
	{
		int existingInsCount = Integer.parseInt(dataHash.get("ExistingInsuranceNo").toString());
		
		try 
		{
			for(int i=0; i<existingInsCount;i++)
			{
				WebActions.waitFor(WebActions.driver.findElement(By.id(AppData.insCompanyTxt)));
				WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.insCompanyTxt)), dataHash.get("InsuranceCompany").toString());
		    	Thread.sleep(200);
		    	Suite.logger.info("Entered Existing Insurance Company Name");
				
		    	WebActions.sendKeys(WebActions.driver.findElements(By.id(AppData.policyNumTxt)).get(1), dataHash.get("PolicyNumber").toString());
		    	Thread.sleep(200);
		    	Suite.logger.info("Entered Existing Insurance Policy Number");
				
		    	WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.coverageAmtTxt)), dataHash.get("CoverageAmount").toString());
		    	Thread.sleep(200);
		    	Suite.logger.info("Entered Existing Insurance Coverage Amount");
		    	
		    	WebActions.clickSave();
		    	Suite.logger.info("Existing Insurance Added");
		    	
			}
		}catch(Exception e)
		{
			System.out.println("Exception raised while adding beneficiary");
		}
		
	}
	
	public static boolean telePhonicCriteria()
	{
		boolean teleInterviewHit = false;
		String sDATE = dataHash.get("DOB").toString();
		String baseAmount = dataHash.get("CoverageAmount").toString();
		
		try 
		{
			int covAmt = Integer.parseInt(baseAmount.replaceAll("[^\\d.]", ""));

			Date dobDate =  new SimpleDateFormat("MMddyyyy").parse(sDATE);
			
			LocalDate systemDate = LocalDate.now();
			Calendar c = Calendar.getInstance();
			c.setTime(dobDate);
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int date = c.get(Calendar.DATE);
			LocalDate dobLocDate = LocalDate.of(year, month, date);
			Period differenceAGE = Period.between(dobLocDate, systemDate);
			
			if((covAmt>=25000 && covAmt<=100000 && differenceAGE.getYears()>65 && differenceAGE.getYears()<76) || 
					(covAmt>=100001 && covAmt<=200000 && differenceAGE.getYears()>55 && differenceAGE.getYears()<76) ||
					(covAmt>=200001 && covAmt<=300000 && differenceAGE.getYears()>17 && differenceAGE.getYears()<76)
					)
			{
	    		System.out.println("Telephonic should be there");
	    		teleInterviewHit = true;
			}
			
		}catch(Exception e) {
			System.out.println("Error @ Telephonic criteria validation" + e.getMessage());
		}
		
		return teleInterviewHit;
	}

}
