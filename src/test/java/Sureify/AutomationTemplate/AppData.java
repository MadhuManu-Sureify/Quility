package Sureify.AutomationTemplate;

/**
 * @author ManuTonyStark
 * @date 11-Mar-2020
 * @desc This Class is to have the Elements locators 
 */

public class AppData 
{
	public static String caPrivacyTerms = "//*[contains(text(),'California Privacy Terms')]";
	public static String caPTChkBox = "(//span[@class = 'checkmarkCheckbox'])[1]";

	public static String nextBtn = "//button[text()='Next']";
	public static String backBtn = "//button[text()='Back']";
	public static String saveBtn = "//button[text()='Save']";
	public static String continueBtn = "//button[text()='Continue']";
	public static String submitAppBtn = "//button[text()='SUBMIT APPLICATION']";
	public static String finishAppBtn = "//button[contains(text(), 'Finish My Application')]";
	public static String somethingWentWrongLbl = "//*[contains(text(),'Something went wrong!')]";

	public static String previousBtn = "//button[text()='Previous']";
	public static String sessionExpLbl = "//*[text()='Your Session Has Expired']";
	public static String serverDownLbl = "//*[text()='Please Visit Us Again']";
	public static String reviewPageHeadingLbl = "//*[text()='Review Your Application']";
	public static String paymentPageHeadingLbl = "//span[text()='Payment Information']";
	public static String requotePageHeadingLbl = "//*[text()='Confirm Your Coverage']";
	public static String docuSignPageHeadingLbl = "//*[contains(text(),'Review and confirm your documents')]";
	public static String thankYouPageHeadingLbl = "//*[contains(text(),'Thank you')]";
	public static String knockOutPopUp = "//*[text()[contains(., 'Quility licensed insurance agent')]]";
	public static String getStartBtn = "//button[@id ='submit-button']";
	
	public static String firstNameTxt = "FirstName";
	public static String middleNameTxt = "MiddleName";
	public static String lastNameTxt = "LastName";
	public static String maleRadioButton = "//*[text()='Male']";
	public static String femaleRadioButton = "//*[text()='Female']";
	public static String dob = "//*[@id = 'datePicker_DateofBirth']";
	public static String addressTxt = "//*[@placeholder = 'Enter a location']";
	public static String cityTxt = "City";
	public static String stateDD = "//span[text()='State']/following::*[contains(@class,'css-1hwfws3')]";
	public static String stateItemInDD = "//span[text()='State']/following::*[contains(@class,'css-1mszh4p-singleValue')]";
	public static String zipCodeTxt = "ZipCode";
	
	public static String coverageAmountLbl = "//div[contains(text(),'Coverage Amount')]/following-sibling::div";
	
	public static String emailAddressTxt = "EmailAddress";
	public static String phoneTxt = "Phone";
	
	public static String teleInterviewDD = "//span[contains(text(),'best time to call')]/following::*[contains(@class,'css-1hwfws3')]";
	
	public static String ssnTxt = "SocialSecurityNumber";
	
	public static String stateOfBirthDD = "//span[contains(text(),'State of birth')]/following::*[contains(@class,'css-1hwfws3')]";
	
	public static String drivingLicNumberTxt = "DriversLicenseNo";
	public static String stateOfIssueDD = "//*[@class = 'DriversLicenseState__value-container css-1hwfws3']";
	
	public static String drivingLYesBtn = "//*[@id = 'DriversLicenseValid_Yes']/following-sibling::*[text()='Yes']";
	public static String drivingLNoBtn = "//*[@id = 'DriversLicenseValid_No']/following-sibling::*[text()='No']";
	public static String drivingLNoTxt = "DriversLicenseNo";
	public static String drivingLStateofIssueDD = "(//span[contains(text(),'license Issue State?')]/following::*[contains(@class,'css-1hwfws3')])[1]";
	public static String drivingLNoExplainTxt = "DriversLicenseValidDetails";
	public static String validStateYesBtn = "//*[@id = 'StateIDValid_Yes']/following-sibling::*[text()='Yes']";
	public static String validStateNoBtn = "//*[@id = 'StateIDValid_No']/following-sibling::*[text()='No']";
	public static String stateIDNoTxt = "StateIDNo";
	public static String countryOfBirthDD = "//span[contains(text(),'Country of Birth')]/following::*[contains(@class,'css-1hwfws3')]";
	
	public static String occupationDD = "//span[contains(text(),'do for work?')]/following::*[contains(@class,'css-1hwfws3')]";
	public static String annualIncomeTxt = "AnnualIncome";

	public static String yesTobaccoQues = "//*[@id='TobaccoQuestion_Yes']/following-sibling::*[text()= 'Yes']";
	public static String noTobaccoQues = "//*[@id='TobaccoQuestion_No']/following-sibling::*[text()= 'No']";
	
	public static String yesOtherPoliciesAndCoveragesQues = "//*[@id='OtherInsuranceInforce_Yes']/following-sibling::*[text()= 'Yes']";
	public static String noOtherPoliciesAndCoveragesQues = "//*[@id='OtherInsuranceInforce_No']/following-sibling::*[text()= 'No']";
	
	public static String yesReplacementQues = "//*[@id='ReplacementQuestion_YEI_Yes']/following-sibling::*[text()= 'Yes']";
	public static String noReplacementQues = "//*[@id='ReplacementQuestion_YEI_No']/following-sibling::*[text()= 'No']";
	
	public static String yesReplacementContractQues = "//*[@id='ReplacingContract_No']/following-sibling::*[text()= 'No']";
	public static String noReplacementContractQues = "//*[@id='ReplacingContract_Yes']/following-sibling::*[text()= 'Yes']";
	
	public static String yesReplacingFundsTransferQues = "//*[@id='ReplacingFundsTransfer_Yes']/following-sibling::*[text()= 'Yes']";
	public static String noReplacingFundsTransferQues = "//*[@id='ReplacingFundsTransfer_No']/following-sibling::*[text()= 'No']";
	
	public static String insCompanyTxt = "InsuranceCompany";
	public static String policyNumTxt = "PolicyNumber";
	public static String coverageAmtTxt = "AmountofCoverage";
	public static String addInsCompanyList = "//*[contains(@class,'add-btn-text') and contains(text(),'Add Insurance Company')]";
	
	public static String yes1AQues = "//*[@id='MedicalQuestions1ATreatmentMedication_Yes']/following-sibling::*[text()= 'Yes']";
	public static String no1AQues = "//*[@id='MedicalQuestions1ATreatmentMedication_No']/following-sibling::*[text()= 'No']";

	public static String HBPChkBox = "(//span[@class = 'checkmarkCheckbox'])[1]";
	public static String HeartAttackChkBox = "(//span[@class = 'checkmarkCheckbox'])[2]";
	public static String AnginaChkBox = "(//span[@class = 'checkmarkCheckbox'])[3]";
	public static String ArrhythmiaChkBox = "(//span[@class = 'checkmarkCheckbox'])[4]";
	public static String AneurysmChkBox = "(//span[@class = 'checkmarkCheckbox'])[5]";
	public static String StrokeChkBox = "(//span[@class = 'checkmarkCheckbox'])[6]";
	public static String TIAChkBox = "(//span[@class = 'checkmarkCheckbox'])[7]";
	public static String HeartORDisorderChkBox = "(//span[@class = 'checkmarkCheckbox'])[8]";

	public static String lastBPDD = "//*[contains(@id,'MedicalQuestionsHighBloodPressureReading')]/descendant::*[contains(@class,'css-1hwfws3')]";
	public static String medicationCountQues0To2 = "//*[@id='MedicalQuestionsHighBloodPressureMedications_0-2']/following-sibling::*[text()= '0-2']";
	public static String bpControlHistoryDD = "//*[contains(@id,'MedicalQuestionsHighBloodPressureControlHistory')]/descendant::*[contains(@class,'css-1hwfws3')]";
	public static String medicationCountQues3OrMore = "//*[@id='MedicalQuestionsHighBloodPressureMedications_3 or more']/following-sibling::*[text()= '3 or more']";
	public static String yesRXDosageInPast12MonthsQues = "//*[@id='MedicalQuestionsHighBloodPressureRXchange_Yes']/following-sibling::*[text()= 'Yes']";
	public static String noRXDosageInPast12MonthsQues = "//*[@id='MedicalQuestionsHighBloodPressureRXchange_No']/following-sibling::*[text()= 'No']";
	public static String yesBPMedicationCompliantQues = "//*[@id='MedicalQuestionsHighBloodPressureCompliant']/descendant::*[text()= 'Yes']";
	public static String noBPMedicationCompliantQues = "//*[@id='MedicalQuestionsHighBloodPressureCompliant']/descendant::*[text()= 'No']";
	public static String yesHBPHospitalizedQues = "//*[contains(@id,'MedicalQuestionsHighBloodPressure12mosHospitalization')]/descendant::*[text()= 'Yes']";
	public static String noHBPHospitalizedQues = "//*[contains(@id,'MedicalQuestionsHighBloodPressure12mosHospitalization')]/descendant::*[text()= 'No']";
	public static String yesHBPLostTimeQues = "//*[contains(@id,'MedicalQuestionsHighBloodPressure12mosLostWork')]/descendant::*[text()= 'Yes']";
	public static String noHBPLostTimeQues = "//*[contains(@id,'MedicalQuestionsHighBloodPressure12mosLostWork')]/descendant::*[text()= 'No']";
	public static String elevatedMedicalPersonQues = "//*[contains(@id,'MedicalQuestionsHighBloodPressureReadingUNK')]/descendant::*[text()= 'Elevated']";
	public static String normalMedicalPersonQues = "//*[contains(@id,'MedicalQuestionsHighBloodPressureReadingUNK')]/descendant::*[text()= 'Normal']";

	public static String daignosedDD = "//*[contains(@id,'MedicalQuestionsTIAdiagnosedWhen')]/descendant::*[contains(@class,'css-1hwfws3')]";
	public static String daignosedDatePicker = "//*[@id = 'datePicker_MedicalQuestionsTIAdiagnosedDate']";
	public static String yesResidualSymptomsQues = "//*[contains(@id,'MedicalQuestionsTIAresidualSymptoms')]/descendant::*[text()= 'Yes']";
	public static String noResidualSymptomsQues = "//*[contains(@id,'MedicalQuestionsTIAresidualSymptoms')]/descendant::*[text()= 'No']";
	public static String residualSymptomsQuesYesExplainTxt = "MedicalQuestionsTIAresidualSymptomsExplain";
	public static String tiaDoctorNameTxt = "TIADoctorName";
	
	public static String yes1BQues = "//*[contains(@id,'MedicalQuestions1BDiabetes')]/following-sibling::*[text()= 'Yes']";
	public static String no1BQues = "//*[@id='MedicalQuestions1BDiabetes_No']/following-sibling::*[text()= 'No']";

	public static String DiabetesChkBox = "(//span[@class = 'checkmarkCheckbox'])[1]";
	public static String PancreaseDisorderChkBox = "(//span[@class = 'checkmarkCheckbox'])[2]";
	public static String HepatitisChkBox = "(//span[@class = 'checkmarkCheckbox'])[3]";
	public static String CrohnDiseaseChkBox = "(//span[@class = 'checkmarkCheckbox'])[4]";
	public static String UIcerativeColitisChkBox = "(//span[@class = 'checkmarkCheckbox'])[5]";
	public static String LiverDisorderChkBox = "(//span[@class = 'checkmarkCheckbox'])[6]";

	public static String yesMedicalQuestionsDiabetesAge35Ques = "//*[contains(@id,'MedicalQuestionsDiabetesAge35')]/following-sibling::*[text()= 'Yes']";
	public static String noMedicalQuestionsDiabetesAge35Ques = "//*[contains(@id,'MedicalQuestionsDiabetesAge35')]/following-sibling::*[text()= 'No']";
	public static String yesMedicalQuestionsTobaccoQues = "//*[contains(@id,'MedicalQuestionsTobacco')]/following-sibling::*[text()= 'Yes']";
	public static String noMedicalQuestionsTobaccoQues = "//*[contains(@id,'MedicalQuestionsTobacco')]/following-sibling::*[text()= 'No']";
	public static String MedicalQuestionsDiabetesTreatedOralMedicationQues = "//*[contains(@id,'MedicalQuestionsDiabetesTreated')]/following-sibling::*[contains(text(), 'Oral Medication')]";
	public static String MedicalQuestionsDiabetesTreatedDietOnlyQues = "//*[contains(@id,'MedicalQuestionsDiabetesTreated')]/following-sibling::*[contains(text(), 'Diet Only')]";
	public static String MedicalQuestionsDiabetesTreatedInsulinQues = "//*[contains(@id,'MedicalQuestionsDiabetesTreated')]/following-sibling::*[contains(text(), 'Insulin')]";
	public static String MedicalQuestionsDiabetesRecentA1C84ORLessQues = "//*[contains(@id,'MedicalQuestionsDiabetesRecentA1C')]/following-sibling::*[contains(text(), '8.4 or less')]";
	public static String MedicalQuestionsDiabetesRecentA1C85ORGreaterQues = "//*[contains(@id,'MedicalQuestionsDiabetesRecentA1C')]/following-sibling::*[contains(text(), '8.5 or greater')]";
	public static String MedicalQuestionsDiabetesRecentA1CUnknownQues = "//*[contains(@id,'MedicalQuestionsDiabetesRecentA1C')]/following-sibling::*[contains(text(), 'Unknown')]";
	public static String MedicalQuestionsDiabetesRecentA1CUnknownSubElevatedQues = "//*[contains(@id,'MedicalQuestionsDiabetesRecentA1CUnknownSub')]/descendant::*[text()= 'Elevated']";
	public static String MedicalQuestionsDiabetesRecentA1CUnknownSubNormalQues = "//*[contains(@id,'MedicalQuestionsDiabetesRecentA1CUnknownSub')]/descendant::*[text()= 'Normal']";
	public static String diabetesControlHistoryDD = "//*[contains(@id,'MedicalQuestionsDiabetesControlHx')]/descendant::*[contains(@class,'css-1hwfws3')]";
	public static String yesMedicalQuestionsDiabetesChangeRxQues = "//*[contains(@id,'MedicalQuestionsDiabetesChangeRx')]/following-sibling::*[text()= 'Yes']";
	public static String noMedicalQuestionsDiabetesChangeRxQues = "//*[contains(@id,'MedicalQuestionsDiabetesChangeRx')]/following-sibling::*[text()= 'No']";
	public static String yesMedicalQuestionsDiabetesCompliantQues = "//*[contains(@id,'MedicalQuestionsDiabetesCompliant')]/following-sibling::*[text()= 'Yes']";
	public static String noMedicalQuestionsDiabetesCompliantQues = "//*[contains(@id,'MedicalQuestionsDiabetesCompliant')]/following-sibling::*[text()= 'No']";
	public static String yesMedicalQuestionsDiabetesGoutQues = "//*[contains(@id,'MedicalQuestionsDiabetesGout')]/following-sibling::*[text()= 'Yes']";
	public static String noMedicalQuestionsDiabetesGoutQues = "//*[contains(@id,'MedicalQuestionsDiabetesGout')]/following-sibling::*[text()= 'No']";
	public static String yesMedicalQuestionsDiabetesHospitalized12mosQues = "//*[contains(@id,'MedicalQuestionsDiabetesHospitalized12mos')]/following-sibling::*[text()= 'Yes']";
	public static String noMedicalQuestionsDiabetesHospitalized12mosQues = "//*[contains(@id,'MedicalQuestionsDiabetesHospitalized12mos')]/following-sibling::*[text()= 'No']";
	
	public static String yesQues = "";
	public static String noQues = "";

	public static String yes1CQues = "";
	public static String no1CQues = "//*[@id='MedicalQuestions1CCancer_No']/following-sibling::*[text()= 'No']";
	public static String yes1DQues = "";
	public static String no1DQues = "//*[@id='MedicalQuestions1DKidneys_No']/following-sibling::*[text()= 'No']";
	public static String yes1EQues = "";
	public static String no1EQues = "//*[@id='MedicalQuestions1EDisorderJointsMuscles_No']/following-sibling::*[text()= 'No']";
	
	public static String yes1FQues = "//*[@id='MedicalQuestions1FOtherDiseaseSurgery24mos_Yes']/following-sibling::*[text()= 'Yes']";
	public static String no1FQues = "//*[@id='MedicalQuestions1FOtherDiseaseSurgery24mos_No']/following-sibling::*[text()= 'No']";
	public static String dateDiagnosedStartDP = "//*[@id = 'datePicker_MedicalQuestionsOtherDiseaseSurgery24mosDiagnosedDate']";
	public static String dateDiagnoseLastdDP = "//*[@id = 'datePicker_MedicalQuestionsOtherDiseaseSurgery24mosLastDate']";
	public static String provDoctName = "MedicalQuestionsOtherDiseaseSurgery24mosDoctorName";
	public static String commentsMedTreatTxt = "MedicalQuestionsOtherDiseaseSurgery24mosDetails";
	
	public static String yes2Ques = "//*[@id='MedicalQuestions2HazardousSports_Yes']/following-sibling::*[text()= 'Yes']";
	public static String no2Ques = "//*[@id='MedicalQuestions2HazardousSports_No']/following-sibling::*[text()= 'No']";
	
	public static String MotorizedRacingChkBox = "(//span[@class = 'checkmarkCheckbox'])[1]";
	public static String HangGlidingChkBox = "(//span[@class = 'checkmarkCheckbox'])[2]";
	public static String RockORMountainClimbingChkBox = "(//span[@class = 'checkmarkCheckbox'])[3]";
	public static String RodeoEventsChkBox = "(//span[@class = 'checkmarkCheckbox'])[4]";
	public static String SkyDivingChkBox = "(//span[@class = 'checkmarkCheckbox'])[5]";
	public static String SkinORScubaDivingChkBox = "(//span[@class = 'checkmarkCheckbox'])[6]";
			
	public static String yes3AQues = "//*[contains(@id,'MedicalQuestion3AAidsArc')]/following-sibling::*[text()= 'Yes']";
	public static String no3AQues =  "//*[contains(@id,'MedicalQuestion3AAidsArc')]/following-sibling::*[text()= 'No']";
	public static String yes3BQues = "";
	public static String no3BQues =  "//*[contains(@id,'MedicalQuestion3B')]/following-sibling::*[text()= 'No']";
	public static String yes3CQues = "";
	public static String no3CQues =  "//*[contains(@id,'MedicalQuestions3C')]/following-sibling::*[text()= 'No']";
	public static String yes3DQues = "";
	public static String no3DQues =  "//*[contains(@id,'MedicalQuestions3D')]/following-sibling::*[text()= 'No']";
	public static String yes3EQues = "";
	public static String no3EQues =  "//*[contains(@id,'MedicalQuestions3E')]/following-sibling::*[text()= 'No']";
	public static String yes3FQues = "";
	public static String no3FQues =  "//*[contains(@id,'MedicalQuestions3F')]/following-sibling::*[text()= 'No']";

	public static String yes4Ques = "";
	public static String no4Ques =  "//*[@id='MedicalQuestionsSupAppTobacco_No']/following-sibling::*[text()= 'No']";
	public static String yes5Ques = "";
	public static String no5Ques =  "//*[@id='MedicalQuestionsSupAppChew_No']/following-sibling::*[text()= 'No']";
	public static String yes6Ques = "";
	public static String no6Ques =  "//*[@id='MedicalQuestionsSupAppHighBloodMeds_No']/following-sibling::*[text()= 'No']";
	public static String yes7Ques = "";
	public static String no7Ques =  "//*[@id='MedicalQuestionsSupAppChol_No']/following-sibling::*[text()= 'No']";
	public static String yes8Ques = "";
	public static String no8Ques =  "//*[contains(@id,'MedicalQuestionsSupAppDiab')]/following-sibling::*[text()= 'No']";
	public static String yes9Ques = "";
	public static String no9Ques =  "//*[contains(@id,'MedicalQuestionsSupAppCancerCardiac')]/following-sibling::*[text()= 'No']";
	public static String yes10Ques = "";
	public static String no10Ques =  "//*[contains(@id,'MedicalQuestionsSupAppFamilyHistory')]/following-sibling::*[text()= 'No']";
	public static String yes11Ques = "";
	public static String no11Ques =  "//*[contains(@id,'MedicalQuestionsSupAppAlcohol')]/following-sibling::*[text()= 'No']";
	public static String yes12Ques = "";
	public static String no12Ques =  "//*[contains(@id,'MedicalQuestionsSupAppDrugs')]/following-sibling::*[text()= 'No']";
	public static String yes13Ques = "";
	public static String no13Ques = "//*[contains(@id,'MedicalQuestionsSupAppDrivingDUI')]/following-sibling::*[text()= 'No']";
	public static String yes14Ques = "";
	public static String no14Ques = "//*[contains(@id,'MedicalQuestionsSupAppFelony')]/following-sibling::*[text()= 'No']";

	public static String yesCOVID1Ques = "//*[contains(@id,'MedicalQuestionsCOVIDQuarantinedPast12mosDESD')]/following-sibling::*[text()= 'Yes']";
	public static String noCOVID1Ques =  "//*[contains(@id,'MedicalQuestionsCOVIDQuarantinedPast12mosDESD')]/following-sibling::*[text()= 'No']";
	public static String yesCOVID2Ques = "//*[contains(@id,'MedicalQuestionsCOVIDTreatedPast12mosDESD')]/following-sibling::*[text()= 'Yes']";
	public static String noCOVID2Ques =  "//*[contains(@id,'MedicalQuestionsCOVIDTreatedPast12mosDESD')]/following-sibling::*[text()= 'No']";
	public static String yesCOVID3Ques = "//*[contains(@id,'MedicalQuestionsCOVIDSymptomsPast14daysDESD')]/following-sibling::*[text()= 'Yes']";
	public static String noCOVID3Ques =  "//*[contains(@id,'MedicalQuestionsCOVIDSymptomsPast14daysDESD')]/following-sibling::*[text()= 'No']";

	public static String heightFtTxt = "HeightFeet";
	public static String heightInchTxt = "HeightInches";
	public static String weightTxt = "Weight";
	
	public static String benfFirstNameTxt = "BeneficiaryFullName";
	public static String benfRelationDD = "//span[contains(text(),'Beneficiary Relationship')]/following::*[contains(@class,'css-1hwfws3')]";
	public static String benfSSNTxt = "BeneficiarySocialSecurityNumber";
	public static String benfShareAllocTxt = "BeneficiaryShareAllocation";

	public static String addBenfBtn = "//*[contains(text(),'Add Beneficiary')]";

	public static String addContBenfBtn = "//*[contains(text(),'Add Contingent Beneficiary')]";

	public static String contBenfFirstNameTxt = "ContingentBeneficiaryFullName";
	public static String contBenfRelationDD = "//span[contains(text(),'Beneficiary Relationship')]/following::*[contains(@class,'css-1hwfws3')]";
	public static String contBenfSSNTxt = "ContingentBeneficiarySocialSecurityNumber";
	public static String contBenfShareAllocTxt = "ContingentBeneficiaryShareAllocation";

	public static String carrierInfoExpand = "//span[text()='Carrier Information']/parent::h4";
	public static String personalExpand = "//span[text()='Personal']/parent::h4";
	public static String insurHistoryExpand = "//span[text()='Insurance History']/parent::h4";
	public static String medicalHistoryExpand = "//span[text()='Medical History']/parent::h4";
	public static String benfExpand = "//span[text()='Beneficiary']/parent::h4";
	
	public static String faceAmountSlider = "//div[contains(@class,'rangeslider rangeslider-horizontal')]";
	public static String tenYearsPlanCard = "//div[contains(text(),'10 Years')]";
	public static String twentyYearsPlanCard = "//div[contains(text(),'20 Years')]";
	public static String twentyFiveYearsPlanCard = "//div[contains(text(),'25 Years')]";
	public static String thirtyYearsPlanCard = "//div[contains(text(),'30 Years')]";

	public static String premiumFor10YearsLbl = "(//div[contains(@class, 'sc-dvXXZy eqfPow')])[1]/child::div/child::*[2]";
	public static String premiumFor20YearsLbl = "(//div[contains(@class, 'sc-dvXXZy eqfPow')])[2]/child::div/child::*[2]";
	public static String premiumFor25YearsLbl = "(//div[contains(@class, 'sc-dvXXZy eqfPow')])[3]/child::div/child::*[2]";
	public static String premiumFor30YearsLbl = "(//div[contains(@class, 'sc-dvXXZy eqfPow')])[4]/child::div/child::*[2]";

	public static String accountHolderNameTxt = "AccountHolderName";
	public static String bankNameTxt = "BankName";
	public static String bankRoutingNumberTxt = "BankRoutingNumber";
	public static String bankAccountNumberTxt = "BankAccountNumber";
	public static String monthlyDraftDateDD = "//span[contains(text(),'Please choose a monthly draft')]/following::*[contains(@class,'css-1hwfws3')]";
	
	public static String checkingAccountBtn = "//*[contains(@id,'AccountType_Checking')]/following-sibling::*[text()= 'Checking']";
	public static String savingsAccountBtn = "//*[contains(@id,'AccountType_Savings')]/following-sibling::*[text()= 'Savings']";

	public static String accountVerifyChkBox = "//*[@class='checkmarkCheckbox']";
	
	public static String yesthirdPartyDesignateQues = "";
	public static String nothirdPartyDesignateQues = "//*[contains(@id,'SecondaryAddresseeDesignate')]/following-sibling::*[text()= 'No']";
	
	public static String pdfDocument = "//div[@class='react-pdf__Document']";
	public static String docuSignVerifyChkBox = "//*[@class='checkmarkCheckbox']";
	
	public static String recordNumberLbl = "//p[contains(text(),'Your application has been submitted')]/child::b";
	
	//Footer
	public static String number = "//a[text()='1-888-784-5489']";
	
	public static String home_Link = "//*[contains(@class,'footer-links')]/descendant::*[text()='Home']";
	public static String aboutUS_Link = "//*[contains(@class,'footer-links')]/descendant::*[text()='About Us']";
	public static String getAQuote_Link = "//*[contains(@class,'footer-links')]/descendant::*[text()='Get a Quote']";
	public static String news_Link = "//*[contains(@class,'footer-links')]/descendant::*[text()='In the News']";
	public static String blog_Link = "//*[contains(@class,'footer-links')]/descendant::*[text()='Blog']']";
	public static String li101_Link = "//*[contains(@class,'footer-links')]/descendant::*[text()='Life Insurance 101']";
	public static String helpCenter_Link = "//*[contains(@class,'footer-links')]/descendant::*[text()='Help Center']";
	public static String contactUS_Link = "//*[contains(@class,'footer-links')]/descendant::*[text()='Contact Us']";
	
	public static String rights_text = "//*[contains(text(),'All Rights Reserved')]";
	
}
