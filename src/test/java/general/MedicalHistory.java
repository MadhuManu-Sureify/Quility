package general;

import org.openqa.selenium.By;

import Sureify.AutomationTemplate.AppData;
import Sureify.AutomationTemplate.Suite;
import Sureify.AutomationTemplate.WebActions;

/**
 * @author ManuTonyStark
 * @date 21-Sep-2020
 */
public class MedicalHistory 
{	
	public static boolean answer1A(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
			//1A
			WebActions.dynamicWait(AppData.no1AQues);
			
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes1AQues);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to Yes for High blood pressure, Heart attack, Angina, Arrhythmia, Aneurysm, Stroke, TIA, Heart or circulatory disease or disorder?");
				
				if(Common.dataHash.get("HighBP").toString().equalsIgnoreCase("Yes"))
				{
					if(fillHighBP())
					{
						KnockOut = true;
					}
				}

				if(Common.dataHash.get("HeartAttack").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.dynamicWait(AppData.HeartAttackChkBox);
					WebActions.clickXpath(AppData.HeartAttackChkBox);
					Suite.logger.info("Checked Heart Attack");
				}

				if(Common.dataHash.get("Angina").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.dynamicWait(AppData.AnginaChkBox);
					WebActions.clickXpath(AppData.AnginaChkBox);
					Suite.logger.info("Checked Angina");
				}
				
				if(Common.dataHash.get("Aneurysm").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.dynamicWait(AppData.AneurysmChkBox);
					WebActions.clickXpath(AppData.AneurysmChkBox);
					Suite.logger.info("Checked Aneurysm");
				}

				if(Common.dataHash.get("Stroke").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.dynamicWait(AppData.StrokeChkBox);
					WebActions.clickXpath(AppData.StrokeChkBox);
					Suite.logger.info("Checked Stroke");
				}

				if(Common.dataHash.get("TIA").toString().equalsIgnoreCase("Yes"))
				{
					if(fillTIA())
					{
						KnockOut = true;
					}
				}

				if(Common.dataHash.get("HeartORDisorder").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.dynamicWait(AppData.HeartORDisorderChkBox);
					WebActions.clickXpath(AppData.HeartORDisorderChkBox);
					Suite.logger.info("Checked Heart or disorder");
				}
		    	
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
		    	WebActions.clickXpath(AppData.no1AQues);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to NO for High blood pressure, Heart attack, Angina, Arrhythmia, Aneurysm, Stroke, TIA, Heart or circulatory disease or disorder?");
			}

			WebActions.clickContinue();

		}catch(Exception cE){ System.out.println("Exception @ 1A question : " + cE.getMessage());}

		return KnockOut;
	}

	public static boolean answer1B(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
			//1B
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.dynamicWait(AppData.yes1BQues);
				WebActions.clickXpath(AppData.yes1BQues);
				Suite.logger.info("Opted to Yes for Diabetes, Pancreas Disorder, Hepatitis, Crohn's Disease, Ulcerative Colitis, Liver or Digestive disease or disorder?");

				if(Common.dataHash.get("Diabetes").toString().equalsIgnoreCase("Yes"))
				{
					if(fillDiabetes())
					{
						KnockOut = true;
					}
				}

				if(Common.dataHash.get("PancreasDisorder").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.dynamicWait(AppData.PancreaseDisorderChkBox);
					WebActions.clickXpath(AppData.PancreaseDisorderChkBox);
					Suite.logger.info("Checked Pancreas Disorder");
				}

				if(Common.dataHash.get("Hepatitis").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.dynamicWait(AppData.HepatitisChkBox);
					WebActions.clickXpath(AppData.HepatitisChkBox);
					Suite.logger.info("Checked Hepatitis");
				}

				if(Common.dataHash.get("CrohnsDisease").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.dynamicWait(AppData.CrohnDiseaseChkBox);
					WebActions.clickXpath(AppData.CrohnDiseaseChkBox);
					Suite.logger.info("Checked Crohns Disease");
				}

				if(Common.dataHash.get("UlcerativeColitis").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.dynamicWait(AppData.UIcerativeColitisChkBox);
					WebActions.clickXpath(AppData.UIcerativeColitisChkBox);
					Suite.logger.info("Checked UIcerative Colitis");
				}

				if(Common.dataHash.get("LiverDisorder").toString().equalsIgnoreCase("Yes"))
				{
					WebActions.dynamicWait(AppData.LiverDisorderChkBox);
					WebActions.clickXpath(AppData.LiverDisorderChkBox);
					Suite.logger.info("Checked Liver Disorder");
				}
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
		    	WebActions.clickXpath(AppData.no1BQues);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to NO for Diabetes, Pancreas Disorder, Hepatitis, Crohn's Disease, Ulcerative Colitis, Liver or Digestive disease or disorder?");
			}

			WebActions.clickContinue();
			
		}catch(Exception cE){ System.out.println("Exception @ 1B question");}
		
		return KnockOut;
	}

	public static boolean answer1C(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
			//1C
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				//Yet to Implement
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
		    	WebActions.clickXpath(AppData.no1CQues);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to NO for Cancer in any form, lung disease or disorder, seizures, mental or nervous disorder, Bi-Polar disorder, paralysis, blindness?");
			}

			WebActions.clickContinue();
			
		}catch(Exception cE){ System.out.println("Exception @ 1C question");}
		
		return KnockOut;
	}
	
	public static boolean answer1D(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
			//1D
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				//Yet to Implement
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
		    	WebActions.clickXpath(AppData.no1DQues);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to NO for Any disease or disorder of the Kidneys, Urinary Bladder, Prostate, Reproductive Organs, or Sexually Transmitted Disease?");
			}

			WebActions.clickContinue();
			
		}catch(Exception cE){ System.out.println("Exception @ 1D question");}
		
		return KnockOut;
	}
	
	public static boolean answer1E(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
			//1E
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				//Yet to Implement
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
		    	WebActions.clickXpath(AppData.no1EQues);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to NO for Connective Tissue Disease, Systemic Lupus (SLE), Anemia, Arthritis, or Any disorder of the back, joints, muscles?");
			}

			WebActions.clickContinue();
			
		}catch(Exception cE){ System.out.println("Exception @ 1E question");}
		
		return KnockOut;
	}
	
	public static boolean answer1F(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
			//1F
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes1FQues);
		    	Suite.logger.info("Opted to Yes for Any other disease or disorder, injury, surgery within the past 24 months?");
		    	Thread.sleep(200);
		    	
		    	WebActions.selectDOB(WebActions.driver.findElement(By.xpath(AppData.dateDiagnosedStartDP)), 14, 02, 2019);
		    	Thread.sleep(500);
		    	Suite.logger.info("Entered Date Diagnosed start date");
		    	
		    	WebActions.selectDOB(WebActions.driver.findElement(By.xpath(AppData.dateDiagnoseLastdDP)), 14, 03, 2019);
		    	Thread.sleep(500);
		    	Suite.logger.info("Entered Date Diagnosed Last date");
		    	
		    	WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.provDoctName)), Common.dataHash.get("ProvidedDoctorName").toString());
		    	Thread.sleep(200);
		    	Suite.logger.info("Entered Provided Doctor Name");
		    	
		    	WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.provDoctName)), Common.dataHash.get("CommentsMedication").toString());
		    	Thread.sleep(200);
		    	Suite.logger.info("Entered List Applicable Comments/Medications/Treatments");
		    	
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
		    	WebActions.clickXpath(AppData.no1FQues);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to NO for Any other disease or disorder, injury, surgery within the past 24 months?");
			}

			WebActions.clickContinue();

		}catch(Exception cE){ System.out.println("Exception @ 1F question");}
		
		return KnockOut;
	}
	
	public static boolean answer2(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
	    	//2
			if(userAnswer.equalsIgnoreCase("Yes"))
			{				
				WebActions.clickXpath(AppData.yes2Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to Yes for Within the past 2 years has any proposed insured participated in motorized racing, hang gliding, rock or mountain climbing,rodeo events, sky diving, or skin or scuba diving?");
		    	
		    	if(Common.dataHash.get("MotorizedRacing").toString().equalsIgnoreCase("Yes"))
		    	{
		    		WebActions.clickXpath(AppData.MotorizedRacingChkBox);
					Suite.logger.info("Checked Motorized Racing checkbox");
					Thread.sleep(200);
					KnockOut = true;
		    	}
		    	
		    	if(Common.dataHash.get("HangGliding").toString().equalsIgnoreCase("Yes"))
		    	{
		    		WebActions.clickXpath(AppData.HangGlidingChkBox);
					Suite.logger.info("Checked Hang Gliding checkbox");
					Thread.sleep(200);
					KnockOut = true;
		    	}
		    	
		    	if(Common.dataHash.get("RockORMountainClimbing").toString().equalsIgnoreCase("Yes"))
		    	{
		    		WebActions.clickXpath(AppData.RockORMountainClimbingChkBox);
					Suite.logger.info("Checked Rock or Mountain Climbing checkbox");
					Thread.sleep(200);
					KnockOut = true;
		    	}
		    	
		    	if(Common.dataHash.get("RodeoEvents").toString().equalsIgnoreCase("Yes"))
		    	{
		    		WebActions.clickXpath(AppData.RodeoEventsChkBox);
					Suite.logger.info("Checked Rodeo Events checkbox");
					Thread.sleep(200);
					KnockOut = true;
		    	}
		    	
		    	if(Common.dataHash.get("SkyDiving").toString().equalsIgnoreCase("Yes"))
		    	{
		    		WebActions.clickXpath(AppData.SkyDivingChkBox);
					Suite.logger.info("Checked Sky Diving checkbox");
					Thread.sleep(200);
					KnockOut = true;
		    	}
		    	
		    	if(Common.dataHash.get("SkinORScubaDiving").toString().equalsIgnoreCase("Yes"))
		    	{
		    		WebActions.clickXpath(AppData.SkinORScubaDivingChkBox);
					Suite.logger.info("Checked Skin or Scuba Diving checkbox");
					Thread.sleep(200);
					KnockOut = true;
		    	}		    	
		    	
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
		    	WebActions.clickXpath(AppData.no2Ques);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to NO for Within the past 2 years has any proposed insured participated in motorized racing, hang gliding, rock or mountain climbing,rodeo events, sky diving, or skin or scuba diving?");
			}

			WebActions.clickContinue();

		}catch(Exception cE){ System.out.println("Exception @ 2 question");}
		
		return KnockOut;
	}
	
	public static boolean answer3A(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
	    	//3A
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				WebActions.clickXpath(AppData.yes3AQues);
				Thread.sleep(200);
				Suite.logger.info("Opted to Yes for Been medically treated or diagnosed by a medical professional as having Acquired Immune Deficiency Syndrome (AIDS), AIDS related complex (ARC), or any immune deficiency related disorder or tested positive for the Human Immunodeficiency Virus (HIV)?");
				WebActions.clickContinue();
				Suite.logger.info("This is Knock Out Scenario.");
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
		    	WebActions.clickXpath(AppData.no3AQues);
				Thread.sleep(200);
				Suite.logger.info("Opted to NO for Been medically treated or diagnosed by a medical professional as having Acquired Immune Deficiency Syndrome (AIDS), AIDS related complex (ARC), or any immune deficiency related disorder or tested positive for the Human Immunodeficiency Virus (HIV)?");
				WebActions.clickContinue();
			}
		}catch(Exception cE){ System.out.println("Exception @ 3A question");}
		
		return KnockOut;
	}
	
	public static boolean answer3B(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
			//3B
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				//Yet to Implement
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no3BQues);
				Thread.sleep(200);
				Suite.logger.info("Opted to NO for Within the past 5 years, pled guilty to or been convicted of a felony or misdemeanor (including DUI or DWI) or do you have such charge currently pending against you or have you had a driver’s license suspended or revoked or is currently suspended or revoked or within the past 6 months, been on probation or parole?");
				WebActions.clickContinue();
			}
			
		}catch(Exception cE){ System.out.println("Exception @ 3B question");}
		
		return KnockOut;
	}
	
	public static boolean answer3C(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
			//3C
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				//Yet to Implement
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no3CQues);
				Thread.sleep(200);
				Suite.logger.info("Opted to NO for Within the past 5 years, used illegal drugs, or abused alcohol or drugs, or had or been recommended by a medical professional or a licensed counselor to discontinue the use of alcohol or drugs or to have treatment or counseling for alcohol or drugs?");
				WebActions.clickContinue();
			}
			
		}catch(Exception cE){ System.out.println("Exception @ 3C question");}
		
		return KnockOut;
	}
	
	public static boolean answer3D(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
			//3D
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				//Yet to Implement
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no3DQues);
				Thread.sleep(200);
				Suite.logger.info("Opted to NO for ");
				WebActions.clickContinue();
			}
			
		}catch(Exception cE){ System.out.println("Exception @ 3D question");}
		
		return KnockOut;
	}
	
	public static boolean answer3E(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
			//3E
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				//Yet to Implement
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no3EQues);
				Thread.sleep(200);
				Suite.logger.info("Opted to NO for Within the past 12 months, consulted a physician, had surgery, been hospitalized, or had diagnostic tests (excluding AIDS/HIV tests) such as EKG, Xray, MRI, CAT scan? (select all that apply)");
				WebActions.clickContinue();
			}
			
		}catch(Exception cE){ System.out.println("Exception @ 3E question");}
		
		return KnockOut;
	}
	
	public static boolean answer3F(String userAnswer)
	{
		boolean KnockOut = false;
		try 
		{
			//3F
			if(userAnswer.equalsIgnoreCase("Yes"))
			{
				//Yet to Implement
			}
			else if(userAnswer.equalsIgnoreCase("No"))
			{
				WebActions.clickXpath(AppData.no3FQues);
		    	Thread.sleep(200);
		    	Suite.logger.info("Opted to NO for Within the past 12 months, had diagnostic testing (excluding AIDS/HIV tests), surgery, or hospitalization recommended by a medical professional which has not been completed or for which the results have not been received, or been referred to a medical professional?");
		    	WebActions.clickContinue();
			}
			
		}catch(Exception cE){ System.out.println("Exception @ 3F question");}
		
		return KnockOut;
	}

	private static Boolean fillHighBP() throws Exception
	{
		boolean subKO = false;

		WebActions.dynamicWait(AppData.HBPChkBox);
		WebActions.clickXpath(AppData.HBPChkBox);
		Suite.logger.info("Checked High BP");

		// 149/89 or less - 0-2 - Not KnockOut
		// 149/89 or less - 3 or more - KnockOut
		// 150/90 or greater - KnockOut
		// Unknown - Normal - Not - KnockOut
		// Unknown - Elevated - KnockOut

		//Nested Dependent Question-1
		WebActions.dynamicWait(AppData.lastBPDD);
		String lBP = Common.dataHash.get("LastBloodPressure").toString();

		if(lBP.equalsIgnoreCase("149/89 or less")) {
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.lastBPDD)), lBP);
			Suite.logger.info("Choosed last blood pressure " + lBP);
		}else if(lBP.equalsIgnoreCase("150/90 or greater")) {
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.lastBPDD)), lBP);
			Suite.logger.info("Choosed last blood pressure " + lBP);
			subKO = true;
		}else if(lBP.equalsIgnoreCase("Unknown")) {
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.lastBPDD)), lBP);
			Suite.logger.info("Choosed last blood pressure " + lBP);
 
			String medicalPersonQuesAnswer = Common.dataHash.get("MedicalPersonElevatedNormal").toString();
			WebActions.dynamicWait(AppData.elevatedMedicalPersonQues);

			if(medicalPersonQuesAnswer.equalsIgnoreCase("Elevated")){
				WebActions.dynamicWait(AppData.elevatedMedicalPersonQues);
				WebActions.clickXpath(AppData.elevatedMedicalPersonQues);
				Suite.logger.info("Opted Yes to ");
				subKO = true;
			}else if(medicalPersonQuesAnswer.equalsIgnoreCase("Normal")){
				WebActions.dynamicWait(AppData.normalMedicalPersonQues);
				WebActions.clickXpath(AppData.normalMedicalPersonQues);
				Suite.logger.info("Opted No to ");
			}

		}else {System.out.println("Invalid value @ last High BP");}

		//Nested Dependent Question-2
		String medicationCt = Common.dataHash.get("HowManyMedication").toString();
		WebActions.dynamicWait(AppData.medicationCountQues0To2);
		if(medicationCt.equalsIgnoreCase("0-2"))
		{
			WebActions.clickXpath(AppData.medicationCountQues0To2);
			Suite.logger.info("Opted to 0-2 medication count");
		}else if(medicationCt.equalsIgnoreCase("3 or More")) {
			WebActions.clickXpath(AppData.medicationCountQues3OrMore);
		    Thread.sleep(200);
			Suite.logger.info("Opted to 3 or More medication count");
			subKO = true;
		}else{System.out.println("Invalid High BP Medication");}

		//Nested Dependent Question-3
		String hbpControlHistory = Common.dataHash.get("HBPControlHistory").toString();
		WebActions.dynamicWait(AppData.bpControlHistoryDD);
		if(hbpControlHistory.equalsIgnoreCase("Excellent")){
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.bpControlHistoryDD)), hbpControlHistory);
			Suite.logger.info("Choosed High BP Control History " + hbpControlHistory);
		}else if(hbpControlHistory.equalsIgnoreCase("Good")){
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.bpControlHistoryDD)), hbpControlHistory);
			Suite.logger.info("Choosed High BP Control History " + hbpControlHistory);
		}else if(hbpControlHistory.equalsIgnoreCase("Fair")){
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.bpControlHistoryDD)), hbpControlHistory);
			Suite.logger.info("Choosed High BP Control History " + hbpControlHistory);
		}else if(hbpControlHistory.equalsIgnoreCase("Poor")){
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.bpControlHistoryDD)), hbpControlHistory);
			Suite.logger.info("Choosed High BP Control History " + hbpControlHistory);
			subKO = true;
		}else{System.out.println("Invalid High BP Control History");}
		
		//Nested Dependent Question-4
		String rxDosageQuesAnswer = Common.dataHash.get("RXDosageInPast12Months").toString();
		if(rxDosageQuesAnswer.equalsIgnoreCase("Yes")){
			WebActions.dynamicWait(AppData.yesRXDosageInPast12MonthsQues);
			WebActions.clickXpath(AppData.yesRXDosageInPast12MonthsQues);
			Suite.logger.info("Opted Yes to RX dosage within the past 12 months");
			subKO = true;
		}else if(rxDosageQuesAnswer.equalsIgnoreCase("No")){
			WebActions.dynamicWait(AppData.noRXDosageInPast12MonthsQues);
			WebActions.clickXpath(AppData.noRXDosageInPast12MonthsQues);
			Suite.logger.info("Opted No to RX dosage within the past 12 months");
		}else{System.out.println("Invalid RX dosage value");}
		
		//Nested Dependent Question-5
		String bpCompliantQuesAnswer = Common.dataHash.get("BPMedicalCompliant").toString();
		if(bpCompliantQuesAnswer.equalsIgnoreCase("Yes")){
			WebActions.dynamicWait(AppData.yesBPMedicationCompliantQues);
			WebActions.clickXpath(AppData.yesBPMedicationCompliantQues);
			Suite.logger.info("Opted Yes to compliant with taking your blood pressure medications");
		}else if(bpCompliantQuesAnswer.equalsIgnoreCase("No")){
			WebActions.dynamicWait(AppData.noBPMedicationCompliantQues);
			WebActions.clickXpath(AppData.noBPMedicationCompliantQues);
			Suite.logger.info("Opted No to compliant with taking your blood pressure medications");
			subKO = true;
		}else{System.out.println("Invalid BP Compliant value");}

		//Nested Dependent Question-6
		String hbpHospitalizedQuesAnswer = Common.dataHash.get("HBPHospitalized").toString();
		if(hbpHospitalizedQuesAnswer.equalsIgnoreCase("Yes")){
			WebActions.dynamicWait(AppData.yesHBPHospitalizedQues);
			WebActions.clickXpath(AppData.yesHBPHospitalizedQues);
			Suite.logger.info("Opted Yes to hospitalized due to high blood pressure within the past 12 months");
			subKO = true;
		}else if(hbpHospitalizedQuesAnswer.equalsIgnoreCase("No")){
			WebActions.dynamicWait(AppData.noHBPHospitalizedQues);
			WebActions.clickXpath(AppData.noHBPHospitalizedQues);
			Suite.logger.info("Opted No to hospitalized due to high blood pressure within the past 12 months");
		}else{System.out.println("Invalid Hospitalized value");}

		//Nested Dependent Question-7
		String lostTimeFromWorkDueToHBPQuesAnswer = Common.dataHash.get("LostTimeFromWorkDueToHBP").toString();
		if(lostTimeFromWorkDueToHBPQuesAnswer.equalsIgnoreCase("Yes")){
			WebActions.dynamicWait(AppData.yesHBPLostTimeQues);
			WebActions.clickXpath(AppData.yesHBPLostTimeQues);
			Suite.logger.info("Opted Yes to lost time from work due to high blood pressure");
			subKO = true;
		}else if(lostTimeFromWorkDueToHBPQuesAnswer.equalsIgnoreCase("No")){
			WebActions.dynamicWait(AppData.noHBPLostTimeQues);
			WebActions.clickXpath(AppData.noHBPLostTimeQues);
			Suite.logger.info("Opted No to lost time from work due to high blood pressure");
		}else{System.out.println("Invalid lost time from work due to Hight BP value");}

		return subKO;
	}

	private static Boolean fillTIA() throws Exception
	{
		boolean subKO = false;

		WebActions.dynamicWait(AppData.TIAChkBox);
		WebActions.clickXpath(AppData.TIAChkBox);
		Suite.logger.info("Checked TIA");

		//TIA diagnose - Within 6 months - KO
		//Residual Symptoms - Yes - KO

		//Nested Dependent Question-1
		WebActions.dynamicWait(AppData.daignosedDD);
		String daignosedDUE = Common.dataHash.get("TIADiagnosed").toString();
		if(daignosedDUE.equalsIgnoreCase("Greater than 6 months"))
		{
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.daignosedDD)), daignosedDUE);
			Suite.logger.info("Choosed duration of TIA diagnosed " + daignosedDUE);
		}else if(daignosedDUE.equalsIgnoreCase("Within 6 months")) {
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.daignosedDD)), daignosedDUE);
			Suite.logger.info("Choosed duration of TIA diagnosed " + daignosedDUE);
			subKO = true;
		}else{System.out.println("Invalid duration of TIA diagnosed");}
		
		//Nested Dependent Question-2
		WebActions.dynamicWait(AppData.daignosedDatePicker);
		String daignosedDATE = Common.dataHash.get("TIADiagnosedDate").toString();
		WebActions.enterDATE(AppData.daignosedDatePicker, daignosedDATE);
		Suite.logger.info("Entered diagnosed date " + daignosedDUE);

		//Nested Dependent Question-3
		String residualSymptomsQuesAnswer = Common.dataHash.get("ResidualSymptoms").toString();
		if(residualSymptomsQuesAnswer.equalsIgnoreCase("Yes")){
			WebActions.dynamicWait(AppData.yesResidualSymptomsQues);
			WebActions.clickXpath(AppData.yesResidualSymptomsQues);
			Suite.logger.info("Opted Yes to residual symptoms");

			String residualSymptomsYesExplain = Common.dataHash.get("ResidualSymptomsExplain").toString();
			WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.residualSymptomsQuesYesExplainTxt)), residualSymptomsYesExplain);
			Suite.logger.info("Entered residual symptoms explaination " + residualSymptomsYesExplain);
			
			subKO = true;

		}else if(residualSymptomsQuesAnswer.equalsIgnoreCase("No")){
			WebActions.dynamicWait(AppData.noResidualSymptomsQues);
			WebActions.clickXpath(AppData.noResidualSymptomsQues);
			Suite.logger.info("Opted No to residual symptoms");

			String docDetails = Common.dataHash.get("DoctorDetails").toString();
			WebActions.sendKeys(WebActions.driver.findElement(By.id(AppData.tiaDoctorNameTxt)), docDetails);
			Suite.logger.info("Entered residual symptoms explaination " + docDetails);

		}else{System.out.println("Invalid residual symptoms");}
		
		return subKO;
	}

	private static Boolean fillDiabetes() throws Exception
	{
		boolean subKO = false;

		WebActions.dynamicWait(AppData.DiabetesChkBox);
		WebActions.clickXpath(AppData.DiabetesChkBox);
		Suite.logger.info("Checked Diabetes");

		// MedicaltionsDiabetesAge35 - Yes - KO
		// Medication Tobacco - Yes -KO
		// Insulin - Yes - KO
		// 1AC - 8.5 Greater - KO
		// Unknown - Elevated - KO
		// Diabetes History - Poor - KO
		// Gout - Yes - KO
		// Medicaltions Diabetes Hospitalized12mos - Yes - KO

		//Nested Dependent Question-1
		String medicaltionsDiabetesAge35QuesAnswer = Common.dataHash.get("MedicaltionsDiabetesAge35").toString();
		if(medicaltionsDiabetesAge35QuesAnswer.equalsIgnoreCase("Yes")){
			WebActions.dynamicWait(AppData.yesMedicalQuestionsDiabetesAge35Ques);
			WebActions.clickXpath(AppData.yesMedicalQuestionsDiabetesAge35Ques);
			Suite.logger.info("Opted Yes to diabetes diagnosed prior to age 35");
			subKO = true;
		}else if(medicaltionsDiabetesAge35QuesAnswer.equalsIgnoreCase("No")){
			WebActions.dynamicWait(AppData.noMedicalQuestionsDiabetesAge35Ques);
			WebActions.clickXpath(AppData.noMedicalQuestionsDiabetesAge35Ques);
			Suite.logger.info("Opted No to diabetes diagnosed prior to age 35");
		}else{System.out.println("Invalid diabetes diagnosed prior to age 35");}

		//Nested Dependent Question-2
		String medicaltionTobaccoQuesAnswer = Common.dataHash.get("MedicaltionsTobacco").toString();
		if(medicaltionTobaccoQuesAnswer.equalsIgnoreCase("Yes")){
			WebActions.dynamicWait(AppData.yesMedicalQuestionsTobaccoQues);
			WebActions.clickXpath(AppData.yesMedicalQuestionsTobaccoQues);
			Suite.logger.info("Opted Yes to tobacco in the past 12 months?");
			subKO = true;
		}else if(medicaltionTobaccoQuesAnswer.equalsIgnoreCase("No")){
			WebActions.dynamicWait(AppData.noMedicalQuestionsTobaccoQues);
			WebActions.clickXpath(AppData.noMedicalQuestionsTobaccoQues);
			Suite.logger.info("Opted No to tobacco in the past 12 months?");
		}else{System.out.println("Invalid tobacco in the past 12 months?");}

		//Nested Dependent Question-3
		String medicaltionsDiabetesTreatedQuesAnswer = Common.dataHash.get("MedicaltionsDiabetesTreated").toString();
		WebActions.dynamicWait(AppData.MedicalQuestionsDiabetesTreatedOralMedicationQues);
		if(medicaltionsDiabetesTreatedQuesAnswer.equalsIgnoreCase("Oral Medication"))
		{
			WebActions.clickXpath(AppData.MedicalQuestionsDiabetesTreatedOralMedicationQues);
			Suite.logger.info("Opted to " + medicaltionsDiabetesTreatedQuesAnswer);
		}else if(medicaltionsDiabetesTreatedQuesAnswer.equalsIgnoreCase("Diet Only")) {
			WebActions.clickXpath(AppData.MedicalQuestionsDiabetesTreatedDietOnlyQues);
			Suite.logger.info("Opted to " + medicaltionsDiabetesTreatedQuesAnswer);
		}else if(medicaltionsDiabetesTreatedQuesAnswer.equalsIgnoreCase("Insulin")) {
			WebActions.clickXpath(AppData.MedicalQuestionsDiabetesTreatedInsulinQues);
			Suite.logger.info("Opted to " + medicaltionsDiabetesTreatedQuesAnswer);
			subKO = true;
		}else{System.out.println("Invalid Medical Questions Diabetes Treated");}

		//Nested Dependent Question-4
		String medicaltionsDiabetesRecentA1CQuesAnswer = Common.dataHash.get("MedicaltionsDiabetesRecentA1C").toString();
		WebActions.dynamicWait(AppData.MedicalQuestionsDiabetesTreatedOralMedicationQues);
		if(medicaltionsDiabetesRecentA1CQuesAnswer.equalsIgnoreCase("8.4 or less"))
		{
			WebActions.clickXpath(AppData.MedicalQuestionsDiabetesRecentA1C84ORLessQues);
			Suite.logger.info("Opted to " + medicaltionsDiabetesRecentA1CQuesAnswer);
		}else if(medicaltionsDiabetesRecentA1CQuesAnswer.equalsIgnoreCase("8.5 or greater")) {
			WebActions.clickXpath(AppData.MedicalQuestionsDiabetesRecentA1C85ORGreaterQues);
			Suite.logger.info("Opted to " + medicaltionsDiabetesRecentA1CQuesAnswer);
			subKO = true;
		}else if(medicaltionsDiabetesRecentA1CQuesAnswer.equalsIgnoreCase("Unknown")) {
			WebActions.clickXpath(AppData.MedicalQuestionsDiabetesRecentA1CUnknownQues);
			Suite.logger.info("Opted to " + medicaltionsDiabetesRecentA1CQuesAnswer);

			String medicaltionsDiabetesRecentA1CUnknownSUBQuesAnswer = Common.dataHash.get("MedicaltionsDiabetesRecentA1CUnknownSUB").toString();
			WebActions.dynamicWait(AppData.MedicalQuestionsDiabetesRecentA1CUnknownSubElevatedQues);

			if(medicaltionsDiabetesRecentA1CUnknownSUBQuesAnswer.equalsIgnoreCase("Elevated")){
				WebActions.dynamicWait(AppData.MedicalQuestionsDiabetesRecentA1CUnknownSubElevatedQues);
				WebActions.clickXpath(AppData.MedicalQuestionsDiabetesRecentA1CUnknownSubElevatedQues);
				Suite.logger.info("Opted " + medicaltionsDiabetesRecentA1CUnknownSUBQuesAnswer);
				subKO = true;
			}else if(medicaltionsDiabetesRecentA1CUnknownSUBQuesAnswer.equalsIgnoreCase("Normal")){
				WebActions.dynamicWait(AppData.MedicalQuestionsDiabetesRecentA1CUnknownSubNormalQues);
				WebActions.clickXpath(AppData.MedicalQuestionsDiabetesRecentA1CUnknownSubNormalQues);
				Suite.logger.info("Opted " + medicaltionsDiabetesRecentA1CUnknownSUBQuesAnswer);
			}

		}else{System.out.println("Invalid most recent A1c reading");}

		//Nested Dependent Question-5
		String diabetesControlHistory = Common.dataHash.get("DiabetesControlHistory").toString();
		WebActions.dynamicWait(AppData.diabetesControlHistoryDD);
		if(diabetesControlHistory.equalsIgnoreCase("Excellent")){
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.diabetesControlHistoryDD)), diabetesControlHistory);
			Suite.logger.info("Choosed High BP Control History " + diabetesControlHistory);
		}else if(diabetesControlHistory.equalsIgnoreCase("Good")){
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.diabetesControlHistoryDD)), diabetesControlHistory);
			Suite.logger.info("Choosed High BP Control History " + diabetesControlHistory);
		}else if(diabetesControlHistory.equalsIgnoreCase("Fair")){
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.diabetesControlHistoryDD)), diabetesControlHistory);
			Suite.logger.info("Choosed High BP Control History " + diabetesControlHistory);
		}else if(diabetesControlHistory.equalsIgnoreCase("Poor")){
			WebActions.selectItem(WebActions.driver.findElement(By.xpath(AppData.diabetesControlHistoryDD)), diabetesControlHistory);
			Suite.logger.info("Choosed High BP Control History " + diabetesControlHistory);
			subKO = true;
		}else{System.out.println("Invalid High BP Control History");}

		//Nested Dependent Question-6
		String medicaltionsDiabetesChangeRxQuesAnswer = Common.dataHash.get("MedicaltionsDiabetesChangeRx").toString();
		if(medicaltionsDiabetesChangeRxQuesAnswer.equalsIgnoreCase("Yes")){
			WebActions.dynamicWait(AppData.yesMedicalQuestionsDiabetesChangeRxQues);
			WebActions.clickXpath(AppData.yesMedicalQuestionsDiabetesChangeRxQues);
			Suite.logger.info("Opted Yes to RX dosage within the past 12 months");
		}else if(medicaltionsDiabetesChangeRxQuesAnswer.equalsIgnoreCase("No")){
			WebActions.dynamicWait(AppData.noMedicalQuestionsDiabetesChangeRxQues);
			WebActions.clickXpath(AppData.noMedicalQuestionsDiabetesChangeRxQues);
			Suite.logger.info("Opted No to RX dosage within the past 12 months");
		}else{System.out.println("Invalid RX dosage within the past 12 months");}

		//Nested Dependent Question-7
		String medicaltionsDiabetesCompliantQuesAnswer = Common.dataHash.get("MedicaltionsDiabetesCompliant").toString();
		if(medicaltionsDiabetesCompliantQuesAnswer.equalsIgnoreCase("Yes")){
			WebActions.dynamicWait(AppData.yesMedicalQuestionsDiabetesCompliantQues);
			WebActions.clickXpath(AppData.yesMedicalQuestionsDiabetesCompliantQues);
			Suite.logger.info("Opted Yes to compliant with taking your diabetes medications");
		}else if(medicaltionsDiabetesCompliantQuesAnswer.equalsIgnoreCase("No")){
			WebActions.dynamicWait(AppData.noMedicalQuestionsDiabetesCompliantQues);
			WebActions.clickXpath(AppData.noMedicalQuestionsDiabetesCompliantQues);
			Suite.logger.info("Opted No to compliant with taking your diabetes medications");
		}else{System.out.println("Invalid compliant with taking your diabetes medications");}

		//Nested Dependent Question-8
		String medicaltionsDiabetesGoutQuesAnswer = Common.dataHash.get("MedicaltionsDiabetesGout").toString();
		if(medicaltionsDiabetesGoutQuesAnswer.equalsIgnoreCase("Yes")){
			WebActions.dynamicWait(AppData.yesMedicalQuestionsDiabetesGoutQues);
			WebActions.clickXpath(AppData.yesMedicalQuestionsDiabetesGoutQues);
			Suite.logger.info("Opted Yes to conditions: Gout, retinopathy, or protein in urine?");
			subKO = true;
		}else if(medicaltionsDiabetesGoutQuesAnswer.equalsIgnoreCase("No")){
			WebActions.dynamicWait(AppData.noMedicalQuestionsDiabetesGoutQues);
			WebActions.clickXpath(AppData.noMedicalQuestionsDiabetesGoutQues);
			Suite.logger.info("Opted No to conditions: Gout, retinopathy, or protein in urine?");
		}else{System.out.println("Invalid conditions: Gout, retinopathy, or protein in urine?");}

		//Nested Dependent Question-9
		String medicaltionsDiabetesHospitalized12mosQuesAnswer = Common.dataHash.get("MedicaltionsDiabetesHospitalized12mos").toString();
		if(medicaltionsDiabetesHospitalized12mosQuesAnswer.equalsIgnoreCase("Yes")){
			WebActions.dynamicWait(AppData.yesMedicalQuestionsDiabetesHospitalized12mosQues);
			WebActions.clickXpath(AppData.yesMedicalQuestionsDiabetesHospitalized12mosQues);
			Suite.logger.info("Opted Yes to hospitalized or been seen in the emergency room due to diabetes within the past 12 months?");
			subKO = true;
		}else if(medicaltionsDiabetesHospitalized12mosQuesAnswer.equalsIgnoreCase("No")){
			WebActions.dynamicWait(AppData.noMedicalQuestionsDiabetesHospitalized12mosQues);
			WebActions.clickXpath(AppData.noMedicalQuestionsDiabetesHospitalized12mosQues);
			Suite.logger.info("Opted No to hospitalized or been seen in the emergency room due to diabetes within the past 12 months?");
		}else{System.out.println("Invalid hospitalized or been seen in the emergency room due to diabetes within the past 12 months?");}

		return subKO;
	}


}
