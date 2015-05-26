package com.projectname.testutils.genericutility.testDataLib;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.projectname.testutils.genericutility.ReadFromExcel;



/**
 * @class  		ChartPreVisitLib
 * This Class will contain reusable functions which can be used in Nexia Interface
 * @category 	Charts
 * @since  	     Sep 12, 2010
 */
public class ChartPreVisitLib {
	public String CosignProv=null;
	public String testCaseId = null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String userName1 = null;
	public String userPassword1 = null;
	public String patientId = null;
	public String patientId1 = null;
	public String switchRole=null;
	public String  immunizationCA=null;
	public String  VaccineCA=null;
	public String Vaccine1CA = null;
	public String ReportType=null;
	public String Receivingprovider=null;
	public String DocumentType=null;
	public String AccessionNumber=null;
	public String transcriptionist=null;
	public String onBehalf=null;
	public String zipCode=null;
	public String templateName = null;
	public String testName2 = null;
	public String testName3 = null;
	
	public String holdreason=null;
	public String stopreason=null;
	    public 	String DOS=null;
	    public String Sender=null;
	    public String Diagnosis=null;
	    public String Comments=null;
	    public String ReceivingDate=null;
	    public String Ordering=null;	
	    public String Orderingprovider=null;
		public String For=null;
	public String RouteCA=null;
	public String prescribe=null;
	public String prescribeCa =null;
	public String prescribeName=null;
	public String patientNameApprove=null;
	public String prescribeNameCa=null;
	public String medicationName=null;
	public String primaryIngredient=null;
	public String drugClass=null;

	public String provider=null;
	public String editRole = null;
    public String featureName = null;
    public String documentType = null;
    public String sender = null;
    public String corrsReportType = null;
    public  String vaccineUS=null;
    public  String vaccineNameUS =null;
    public String comments1=null;
    	public String comments2=null;
    	public String comments3=null;
	public String provider1=null;
	public String loaction=null;
	public String freeText=null;
	public String direction=null;
	public String directionca=null;
	public String increaseDecreaseDose=null;
	public String refillMethod=null;
	public String refillMethodCa=null;
	public String refillQuantity=null;
	public String refillUnit=null;
	public String TaskInst=null;
	public String refillUnitCa=null;
	public String refillRoute=null;
	public String refillRouteCa=null;
	public String refillFrequency=null;
	public String refillUsage=null;
	public String usage=null;
	public String usageCa=null;
	public String duration=null;
	public String durationIn=null;
	public String refillUsage1=null;
	public String alertName=null;
	public String refillUsage2=null;
	public String refillUsage3=null;
	public String refillUsage5=null;
	public String refillUsage1Ca=null;
	public String refillUsage2Ca=null;
	public String refillUsage3Ca=null;
	public String refillUsage5Ca=null;
	public String multipleDirection=null;
	public String refillduration=null;
	public String refilldurationCa=null;
	public String method=null;
	public String methodCa=null;
	public String quality=null;
	public String unit=null;
	public String unitCa=null;
	public String route=null;
	public String routeCa=null;
	public String frequency=null;
	public String dispense=null;
	public String unitList=null;
	public String fillon=null;
	public String ofRefill=null;
	public String refillDoNot=null;
	public String notesToPharmacy=null;
	public String subPermitted=null;
public String EncounterTypeCo=null;
public String EncountertypeMy=null;
	public String saveList=null;
	public String problemSuggest=null;
	public String internalNote=null;
	public String previousPharmacy=null;
	public String searchDatabase=null;
	public String searchWithin=null;
	public String searchWithinKM=null;
	public String searchWithinMiles=null;
	public String patient=null;
	public String practice =null;
	public String zipcode=null;
	public String zipcodeCa=null;
	public String zipcodecheck=null;
	public String comePackage=null;
	public String weightPreMed=null;
	public String weightUnit=null;
	public String expires=null;
	public String RefilePatient=null;
	public String patientName=null;
	public String providerName=null;
	public String patientAddressCa=null;
	public String providerAddressCa=null;
	public String HealthCardNo=null;
	public String reasonForStop=null;
	public String pharmacyNameUS=null;
	public String licenseNo=null; 
	public String patientAddress=null;
	public String providerAddress=null;
	public String dispenseWord=null;
	public String patientPhone=null;
	public String providerPhone=null;
	public String signPassword=null;
	public String alert=null;

	public String announcements=null;
	public String noteToeSelf=null;

	public String providerType=null;
	public String firstName=null;
	public String lastName=null;
	public String billingInfoCheck=null;
	public String maximumFte=null;
	public String signatureDate=null;

	public String consentCheck=null;
	public String cptOne=null;
	public String saveListCheckBox=null;
	public String showMoreLink=null;
	public String noSignificantHistory=null;
	public String injection=null;
	public String injection1=null;
	public String lotNumber=null;
	public String expiryData=null;
	public String dosage=null;
	public String dosageUnit=null;
	public String consent=null;
	public String site=null;
	public String adminOn=null;
	public String adminBy=null;
	public String cptCode1=null;
	public String cptCode2=null;
	public String reaction=null;
	public String comment=null;
	public String recallFrequency = null;
	public String recallCount = null;
	public String recallUnit = null;
	public String refused=null;
	public String immunization=null;
	public String refusedDate=null;
	public String admin=null;
	public String vaccine=null;
    public String instructions = null;
    public String callerScript = null;


	public String show=null;
	public String healthCard=null;
	public String series=null;
	public String seriesof=null;
	public String vaccine1=null;
	public String verifyvac1 =null;
	public String immunization1=null;
	public String immunization2=null;
	public String cpt1=null;
	public String cpt2=null;
	public String verifyCpt1=null;
	public String verifyCpt2=null;
	public String copyTo= null;
	public String severity=null;
	public String status=null;
	public String onsetDate=null;
	public String resolvedDate=null;
	public String showAllDetails=null;
	public String lifeStage=null;
	public String noKnownDrugAllergy=null;
	public String intolerance=null;
	public String  ForwardTo=null;
	public String	DiagnosisName=null;
	public String proName=null;
	public String proDate=null;
	public String cpt=null;
	public String accessLevel=null;
	public String medicalCondition=null;
	public String itemStatus=null;
	public String printOn = null;
	public String payer = null;
	public String codingSystem=null;
	public String diagnosis=null;
	public String resDate=null;
	public String medical=null;
	public String cause=null;
	public String relation=null;
	public String age=null;
	public String ageAtDeath=null;
	public String treatment=null;
	public String reason=null;
	public String offEncounter=null;
	public String user=null;
	public String encounterDiagnosis=null;
	public String noSignificant=null;
	public String race = null;
    public String ethnicity = null;
    public String religion = null;
    public String citizenship = null;
    public String studentStatus = null;
    public String householdIncome = null;
    public String employmentStatus = null;
	public String  diagnosis1= null;
	public String allergen=null;
	public String allergenCa=null;
	public String allergyType=null;


	public String startDate=null;
	public String supply=null;
	public String refillUsage4=null;
	public String refillUsage4Ca=null;
	public String prescribeOn=null;
	public String refill=null;
	public String prescribedby=null;
	public String lastRefill=null;
	public String date=null;
	public String role=null;

	public String type=null;
	public String item=null;
	public String detailsNum=null;
	public String detailsText=null;
	public String period=null;
	public String year=null;
	public String startAge=null;
	public String stopAge=null;
	public String historyType=null;
	public String ecDate=null;
	public String other=null;
    public String dataShareLevel = null;
    public String newPractice = null;

	public String prematureCheck = null;
	public String measure = null;

	public String heightInFeet = null;
	public String heightSugBox = null;
	public String heightMU = null;
	public String heightMUCA = null;
	public String heightInCm = null;
	public String weightMU = null;
	public String weightMUCA = null;
	public String weight = null;
	public String systolicRate = null;
	public String diastolicRate = null;
	public String position = null;
	public String limb = null;
	public String cuffSize = null;
	public String time = null;
	public String bPM =null;
	public String description = null;
	public String rhythm = null;
	public String waist = null;
	public String waistMU = null;
	public String waistMUCA = null;
	public String temperature = null;
	public String tempRU = null;
	public String tempRUCA = null;
	public String location = null;
	public String bloodSuger = null;
	public String rR_BPM = null;
	public String bSUnit = null;
	public String repositoryRate = null;
	public String oxygenSaturation = null;
	public String pEFR = null;
	public String pre_bronchodilator = null;
	public String addDirectionCount = null;
	public String htResult = null;
	public String wtResult = null;
	public String bmi = null;
	public String category = null;
	public String concentration=null;
	public String refillQuantityCa= null;
	public String refillFrequencyCa=null;
	public String quantityCa=null;
	public String frequencyCa=null;
	public String refillUsageCa=null;
	public String qualityCa =null;
	public String andThen=null;
	public String headResult  = null;
	public String fatherStatureResult = null;
	public String motherStatureResult = null;
	public String head  = null;
	public String headMU = null;
	public String fatherStature = null;
	public String fatherStatureIn = null;
	public String motherStature = null;
	public String motherStatureIn = null;
	public String interactionWarning= null;
	public String unitListCA=null;

	public String labTestName=null;
	public String labTestComments1=null;
	public String labTestComments2=null;
	public String sendTo=null;
	public String notifyme = null;
	public String notifymein = null;
	public String testResult = null;
	public String dicomment = null;
	public String forwardTo = null;
	public String copiedTo = null;
	public String orderedby = null;
	

	
	

	public String authorization=null;
	public String storedValue=null;

	public String referral1=null;
	public String otherReferral=null;
	
	public String referral=null;
	public String referralNoteText=null;
	public String reasonForRestart=null;

	public String onsetDate1=null;
	public String lifeStage1=null;
	public String onsetDate2=null;
	public String lifeStage2=null;
	public String onsetDate3=null;
	public String lifeStage3=null;
	public String onsetDate4=null;
	public String lifeStage4=null;
	public String reasonForDelete=null;
	public String startDate1=null;
	public String addby=null;
	public String additionalcount= null;

	public String indications=null;
	public String allergenType=null;
	public String vitals=null;
	public String chiefComplaint=null;
	public String chief=null;
	public String review=null;

	public String chief1=null;
	public String medicalCondition1=null;

	public String accNumber=null;
	public String rProvider=null;
	public String oProvider=null;
	public String labName=null;
	public String labNameCA = null;
	public String cDate=null;

	public String ftpHostStage=null;
	public String ftpUserStage=null;
	public String ftpPasswordStage=null;
	public String ftpHost=null;
	public String ftpUser=null;
	public String ftpPassword=null;
	public String sourcePath=null;
	public String destDir=null;
	public String sourcePath2=null;
	public String destDir2=null;
	public String numLabs=null;

	public String normal=null;
	public String providerID=null;                                	
	public String patientHCN=null;                                	
	public String labTest=null;
	public String labTest1=null;
	public String facilityName=null;	
	public String ssNumber=null;

	
	

	public String cTime=null;
	public String notes=null;
	public String testName=null;
	public String testName1=null;
	public String result=null;
	public String low=null;
	public String high=null;
	public String comments=null;
	public String units=null;
	public String dob=null;
	public String dobCa=null;

	public String graph1=null;
	public String graph2=null;
	public String graph3=null;
	public String graph4=null;
	public String graph5=null;
	public String graph6=null;
	public String graph7=null;
	public String abnormal=null;
	public String reportStatus=null;
	public String pharmacyName=null;

	public String errorMessage=null;
	public String sex=null;
	public String enImmunization=null;
	public String quickListCheck=null;
	public String quickList=null;
	public String switchRoleNurse=null;
	public String finalCheck=null;

	public String reference = null;
	public String bookMark = null;

	//Chart Disclosure
	public String TaskType = null;
	public String Instruction = null;
	public String DueIn = null;
	public String AssignTo = null;
	public String Requestedby = null;
	public String Recipienttype = null;
	public String Deliverymethod = null;	
	public String Consentname = null;
	public String Show = null;
	public String DueInCount=null;
	public String DueInUnit=null; 
	public String AssignToChartDis=null;
	public String RequesterName=null;
	public String RequesterRel=null;
	public String ContactPhone=null;
	public String Extn=null;
	public String RecipientName=null;
	public String RecipientRel=null;
	public String RepConPhn=null;
	public String RepExtn=null;
	public String Add1=null;
	public String Add2=null;
	public String City=null;
	public String State=null;
	public String Zip=null;
	public String Country=null;
	public String Fax=null;
	public String MailOnFile=null;
	public String OtherFax=null;
	public String OtherMail=null;
	public String FaxOnFile=null;

	//Implement referral
	public String letterTemplateName = null; 
	public String templateNameToCopy = null;
	public String templateNameToRename = null;
	public String refLetterTaskType = null;	
	public String refLetterTaskName = null;	
	public String refLetterTaskAssignTo = null;
	public String templatePageSize = null;
	public String templateType = null;
	public String allTemplateFields = null;	
	public String templateHTML = null;
	public String editTemplateFields = null;
    public String editTemplateHTML = null;
    public String  ReportType1=null;
    public String primaryPhone = null;
    public String  primaryPhoneExtn =null;
    public String  BussinessPhone =null;
	public String  BussinessPhoneExtn = null;
	public String  addressLine1 = null;
	public String  addressLine2 = null;
	public String  city = null;
	public String  state =null;
	
    //EMR Security
    public String emergencyAccessDuration = null;
    public String emergencyAccessReason = null;    


	public String workSheetName = null;
	public String workBookName = "TestData_ChartPrevisit.xls";		
	public String sectionName = "chartprevisit";


	public Hashtable<String, Integer> excelHeaders = new Hashtable<String, Integer>();
	public Hashtable<String, Integer> excelrRowColumnCount = new Hashtable<String, Integer>();



	public String toString() {
		StringBuffer listOfValues  = new StringBuffer();
		@SuppressWarnings("rawtypes")
		Class cls = this.getClass();
		Field[] fields = cls.getDeclaredFields( );

		Field field = null;
		try {
			for (int i=0; i < fields.length; i++) {
				field = fields[i];
				Object subObj = field.get(this);
				if (subObj != null && !field.getName().equals("logger") ) {
					listOfValues.append(":");
					listOfValues.append(field.getName());
					listOfValues.append("=");
					listOfValues.append(subObj.toString());
				}
			}
		}
		catch (RuntimeException e) {
			Assert.fail("toString",e);
		} catch (IllegalAccessException e) {
			Assert.fail("Error During Execution; Execution Failed More detaisl " + e);
		}   
		return listOfValues.toString();
	}
	/**
	 * fetchCodingInterfaceTestData
	 * function for fetching Test data based on test case id  
	 * @since  	     Apr 30, 2010	  
	 */

	public boolean fetchChartPreVisitTestData(){
		ReadFromExcel readTestData = new ReadFromExcel();
		boolean isDataFound = false;
		testCaseId = testCaseId != null ? testCaseId.trim() : "";
		try{
			//******************************************************************//
			//Fetching the test data for New Nexia Interface
			//******************************************************************//
			HSSFSheet sheet = null;

			// function call to initiate a connection to an excel sheet
			sheet = readTestData.initiateExcelConnectionNexia(workSheetName, sectionName, workBookName); 

			// function to find number of rows and columns
			excelrRowColumnCount = readTestData.findRowColumnCount(sheet, excelrRowColumnCount);

			// function call to find excel header fields
			excelHeaders = readTestData.readExcelHeaders(sheet, excelHeaders, excelrRowColumnCount);
			HSSFRow row = null;
			HSSFCell cell = null;			
			String temptestCaseId = null;
			for(int r = 0; r < excelrRowColumnCount.get("RowCount"); r++) {
				row = sheet.getRow(r);  
				if(row != null) {
					for(int c = 0; c < excelrRowColumnCount.get("ColumnCount"); ) {						
						cell = row.getCell(excelHeaders.get("TestID"));
						if(cell != null){
							temptestCaseId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestID")));
							if(temptestCaseId.equals(testCaseId)){
								isDataFound = true;	
								if(workSheetName.equalsIgnoreCase("PrescribeMedi")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
									prescribeCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeCa")));
									provider= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									loaction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Loaction")));
									freeText = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeText")));
									direction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Direction")));
									addDirectionCount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdditionalDirectionCount")));
									increaseDecreaseDose = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IncreaseDecreaseDose")));
									multipleDirection = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MultipleDirection")));

									ofRefill = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OfRefill")));
									refillDoNot = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillDoNot")));
									refillUsage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage")));
									refillUsageCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsageCa")));
									refillMethod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillMethod")));
									refillMethodCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillMethodCa")));
									refillQuantity = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillQuantity")));
									refillQuantityCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillQuantityCa")));
									refillUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUnit")));
									refillUnitCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUnitCa")));
									refillRoute = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillRoute")));
									refillRouteCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillRouteCa")));
									refillFrequency = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillFrequency")));
									refillFrequencyCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillFrequencyCa")));
									refillduration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Refillduration")));
									refilldurationCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefilldurationCa")));


									refillUsage1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage1")));
									refillUsage2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage2")));
									refillUsage3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage3")));
									refillUsage4 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage4")));
									refillUsage5 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage5")));
									refillUsage1Ca = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage1Ca")));
									refillUsage2Ca = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage2Ca")));
									refillUsage3Ca = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage3Ca")));
									refillUsage4Ca = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage4Ca")));
									refillUsage5Ca = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage5Ca")));

									quality = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Quality")));
									qualityCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QualityCa")));
									andThen = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AndThen")));
									unit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit")));
									unitCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UnitCa")));
									route = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Route")));
									routeCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RouteCa")));
									frequency = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Frequency")));
									frequencyCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FrequencyCa")));
									duration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									durationIn = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DurationIn")));
									method = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Method"))); 
									usage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Usage")));
									usageCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UsageCa")));
									methodCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MethodCa")));

									dispense = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Dispense")));
									unitList = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UnitList")));
									fillon = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fillon")));

									notesToPharmacy = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotesToPharmacy")));
									subPermitted = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SubPermitted")));
									comePackage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ComePackage")));
									weightPreMed=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ChkWeight")));
									weight=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Weight")));
									weightUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WeightUnit")));
									expires=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Expires")));
									saveList = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SaveList")));
									problemSuggest = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProblemSuggest")));
									internalNote = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InternalNote")));

									searchWithin = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchWithin")));
									searchWithinKM = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchWithinKM")));
									searchWithinMiles = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchWithinMiles")));
									patient = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Patient")));
									practice  = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
									zipcodecheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zipcodecheck")));
									zipcode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zipcode")));
									zipcodeCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipcodeCA")));
									pharmacyName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Pharmacyname")));
									prescribeName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeName")));
									prescribeNameCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeNameCa")));
									patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
									providerName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderName")));
									patientAddressCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientAddressCA")));
									providerAddressCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderAddressCA")));
									HealthCardNo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HealthCardNoCa")));
									reason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									patientAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientAddress")));
									providerAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderAddress")));
									dispenseWord=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DispenseWord")));
									patientPhone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientPhone")));
									providerPhone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderPhone")));
									reasonForRestart=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForRestart")));
									reasonForDelete=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDelete")));
									show=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Show")));
									signPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SignPassword")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									healthCard=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HealthCard")));
									patientNameApprove=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientNameApprove")));
									interactionWarning=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InteractionWarning")));
									unitListCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UnitListCA")));
									reasonForStop = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForStop")));
									pharmacyNameUS = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PharmacynameUS")));
									licenseNo = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LicenseNum")));
									medicationName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicationName")));
									primaryIngredient=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrimaryIngredient")));
									drugClass=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DrugClass")));
									break;
								}else if(workSheetName.equalsIgnoreCase("ProviderHomePage")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									announcements=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Announcements")));
									noteToeSelf=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NoteToeSelf")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateProvider")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									providerType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderType")));
									firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									billingInfoCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingInfoCheck")));
									maximumFte=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaximumFte")));
									signatureDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SignatureDate")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateInjection")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									consentCheck= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentCheck")));
									injection= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Injection")));
									injection1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Injection")));
									lotNumber= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LotNumber")));
									expiryData = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpiryData")));
									dosage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Dosage")));
									dosageUnit= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DosageUnit")));
									consent= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Consent")));
									site= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Site")));
									adminOn= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdminOn")));
									adminBy= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdminBy")));
									cptCode1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CptCode1")));
									cptCode2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CptCode2")));
									reaction= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reaction")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									route= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Route")));
									reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									verifyCpt1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VerifyCPT1")));
									verifyCpt2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VerifyCPT2")));
									quickList= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuickList")));
									break;

								}else if(workSheetName.equalsIgnoreCase("CreateImmunization")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									refused= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Refused")));
									vaccineUS= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("vaccineUS")));
									vaccineNameUS= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("vaccineNameUS")));
									

									immunization= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Immunization")));
									refusedDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefusedDate")));
									admin= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Admin")));
									vaccine= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Vaccine")));
									series= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Series")));
									seriesof= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("seriesof")));
									consentCheck= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentCheck")));
									lotNumber= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LotNumber")));
									expiryData = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpiryData")));
									dosage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Dosage")));
									dosageUnit= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DosageUnit")));
									consent= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Consent")));
									site= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Site")));
									adminOn= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdminOn")));
									adminBy= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdminBy")));
									cptCode1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CptCode1")));
									cptCode2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CptCode2")));
									reaction= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reaction")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									route= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Route")));
									saveList= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SaveList")));
									vaccine1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Vaccine1")));
									verifyvac1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VerifyVac1")));
									immunization1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Immunization1")));
									immunization2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Immunization2")));
									cpt1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cpt1")));
									cpt2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cpt2")));
									enImmunization=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EnImmunization")));
									immunizationCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Immunizationca")));
									VaccineCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VaccineCA")));												
									RouteCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RouteCA")));		
									Vaccine1CA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Vaccine1CA")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									break;
								}

								else if(workSheetName.equalsIgnoreCase("CreateAllergy")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									allergyType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergyType")));
									allergen = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
									allergenCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergenCA")));
									reaction= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reaction")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									severity= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Severity")));
									status= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date")));
									lifeStage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage")));
									reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDeletion")));
									onsetDate1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date1")));
									lifeStage1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage1")));
									onsetDate2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date2")));
									lifeStage2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage2")));
									onsetDate3= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date3")));
									lifeStage3= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage3")));
									onsetDate4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date4")));
									lifeStage4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage4")));
									noKnownDrugAllergy= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NoKnownDrugAllergy")));
									intolerance= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Intolerance")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));

									break;
								}
								else if(workSheetName.equalsIgnoreCase("CreateProcedure")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									proName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProcedureName")));
									proDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProcedureDate")));
									onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSetDate")));
									cpt= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CPT")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									consent= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Consent")));
									reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									consentCheck = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentCheck")));
									cptOne= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CPTONE")));
									saveListCheckBox= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SaveListCheckBox")));
									showMoreLink= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ShowMoreLink")));
									noSignificantHistory= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NoSignificantHistory")));
									
									break;
								}
								else if(workSheetName.equalsIgnoreCase("CreateProblemList")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									medicalCondition1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical Condtion")));
									medicalCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical Condtion")));
									onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Onset Date")));
									itemStatus= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Item Status")));
									lifeStage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage")));
									resDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resloved Date")));
									codingSystem= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Coding System")));
									diagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									user= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
									encounterDiagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EncounterDiagnosis")));
									quickList =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuickList")));
									quickListCheck =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuickListCheck")));
									finalCheck =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FinalCheck")));
									noSignificant =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NoSignificantProblemList")));
									resolvedDate =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resloved Date")));
									showAllDetails =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Show All Details")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("CreateFamilyHistory")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									medical= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical")));
									cause= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cause")));
									relation= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Relation")));
									lifeStage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LifeStage")));
									codingSystem= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CodingSystem")));
									age= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Age")));
									diagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis")));
									diagnosis1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis1")));
									ageAtDeath= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Ageatdeath")));
									treatment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Treatment")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									saveList= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SaveList")));
									reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));

									break;
								}else if(workSheetName.equalsIgnoreCase("CreateMedication")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									/*holdreason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("holdreason")));
									stopreason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("stopreason")));*/
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
									prescribeCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeCa")));
									freeText = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeText")));
									direction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Direction")));
									increaseDecreaseDose = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IncreaseDecreaseDose")));
									refillMethod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillMethod")));
									refillQuantity = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillQuantity")));
									refillUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUnit")));
									refillRoute = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillRoute")));
									refillRouteCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillRouteCa")));
									refillFrequency = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillFrequency")));
									refillUsage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage")));
									usage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Usage")));
									//usageCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UsageCa")));
									duration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									refillUsage1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage1")));
									refillUsage2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage2")));
									refillUsage3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage3")));
									multipleDirection = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MultipleDirection")));
									refillduration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Refillduration")));
									method = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Method")));
									quality = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Quality")));
									unit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit")));
									route = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Route")));
									frequency = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Frequency")));
									startDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
									supply= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Supply")));
									refillUsage4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage4")));
									prescribeOn= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeOn")));
									refill= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Refill")));
									prescribedby= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribedby")));
									lastRefill= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastRefill")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									//startDate1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate1")));
									//addby= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Addby")));
									prescribeName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeName")));
									prescribeNameCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeNameCa")));
									concentration =	readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Concentation")));
									refillQuantityCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillQuantityCa")));
									refillFrequencyCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillFrequencyCa")));
									quantityCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuantityCa")));
									frequencyCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FrequencyCa")));
									refillUsageCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsageCa")));
									quickList =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuickList")));
									//quickListCheck =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuickListCheck")));
									//finalCheck =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FinalCheck")));
									switchRoleNurse=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRoleNurse")));

									break;
								}
								else if(workSheetName.equalsIgnoreCase("VerifySecurityOption")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("CreateSocialHistory")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									type = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Type")));
									status = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									item = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Item")));
									detailsNum = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DetailsNum")));
									detailsText = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DetailsText")));
									period = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period")));
									year = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("year")));
									startAge = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartAge")));
									historyType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HistoryType")));
									stopAge = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StopAge")));
									lifeStage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LifeStage")));
									comment=  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									other=  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Other")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("EditMedication")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
									freeText = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeText")));
									direction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Direction")));
									increaseDecreaseDose = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IncreaseDecreaseDose")));
									refillMethod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillMethod")));
									refillQuantity = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillQuantity")));
									refillUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUnit")));
									refillRoute = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillRoute")));
									refillFrequency = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillFrequency")));
									refillUsage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage")));
									usage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Usage")));
									duration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									refillUsage1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage1")));
									refillUsage2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage2")));
									refillUsage3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage3")));
									multipleDirection = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MultipleDirection")));
									refillduration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Refillduration")));
									method = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Method")));
									quality = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Quality")));
									unit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit")));
									route = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Route")));
									frequency = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Frequency")));
									startDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
									supply= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Supply")));
									refillUsage4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage4")));
									prescribeOn= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeOn")));
									refill= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Refill")));
									prescribedby= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribedby")));
									lastRefill= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastRefill")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("UnsignedEncounterQueue")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
									ecDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EncounterDate")));
									providerName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderName")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("NewPatientCheckIn" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									prematureCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrematureCheck")));
									duration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									measure=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Measure")));
									lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									status=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									sex=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
									dob=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOB")));

									break;
								}
								else if(workSheetName.equalsIgnoreCase("CreateVitals")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									heightInFeet = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightInFeet")));
									heightInCm = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightInCmOrInches")));
									heightMU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightMU")));
									heightMUCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightMUCA")));
									htResult = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightConversion")));
									weight = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Weight")));
									weightMU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WeightMU")));
									weightMUCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WeightMUCA")));
									wtResult = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WeightConversion")));
									bmi = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BMI")));
									category = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Category")));
									systolicRate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SystolicRate")));
									diastolicRate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiastolicRate")));
									position = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Position")));
									limb = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Limb")));
									cuffSize = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cuff Size")));
									time = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Time")));
									bPM = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BPM")));
									description = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									rhythm = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Rhythm")));
									waist = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Waist")));
									waistMU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WaistMU")));
									waistMUCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WaistMUCA")));
									temperature = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Temperature")));
									tempRU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TempRU")));
									tempRUCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TempRUCA")));
									location = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
									bloodSuger = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BloodSuger")));
									bSUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BSUnit")));
									repositoryRate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Repository Rate")));
									rR_BPM = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RR-BPM")));
									oxygenSaturation = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OxygenSaturation")));
									pEFR = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PEFR")));
									pre_bronchodilator = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Pre-bronchodilator")));
									graph1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Graph1")));
									graph2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Graph2")));
									graph3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Graph3")));
									graph4 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Graph4")));
									graph5 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Graph5")));
									graph6 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Graph6")));
									graph7 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Graph7")));
									headResult = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeadResult")));
									fatherStatureResult = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FatherStatureResult")));
									motherStatureResult = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MotherStatureResult")));
									head = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Head")));
									headMU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeadMU")));
									fatherStature = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FatherStature")));
									fatherStatureIn = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FatherStatureIn")));
									motherStature = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MotherStature")));
									motherStatureIn = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MotherStatureIn")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("CreateLabOrder" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									labTestName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabTestName")));
									labTestComments1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("labTestComments1")));
									labTestComments2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("labTestComments2")));
									sendTo= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SendTo")));
									notifyme = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Notifyme")));
									notifymein = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotifymeIn")));
									authorization = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Authorization")));
									
									templateName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateName")));
									onBehalf = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnBehalf")));
									practice = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
									printOn = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrintOn")));
									testName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName")));
									testName1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName1")));
									testName2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName2")));
									testName3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName3")));

									break;
								}
								else if(workSheetName.equalsIgnoreCase("EncounterOverAll")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									providerName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderName")));
									provider1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider1")));
									vitals = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Vitals")));
									chiefComplaint= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ChiefComplaint")));
									chief = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Chief")));
									chief1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ChiefComplaint1")));
									historyType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HistoryType")));
									review = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Review")));
									notes = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Notes")));
									medicalCondition = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicalCondition")));
									medicalCondition1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicalCondition1")));
									itemStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									diagnosis = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis")));
									prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
									reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									offEncounter = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OffEncounter")));
									show=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Show")));


									break;
								}
								else if(workSheetName.equalsIgnoreCase("CreateDiganosticImaging" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									labTestName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabTestName")));
									labTestComments1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("labTestComments1")));
									labTestComments2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("labTestComments2")));
									authorization= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Authorization")));
									medicalCondition = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical Condtion")));
									itemStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Item Status")));
									printOn = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrintOn")));
									payer =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Payer")));
									provider =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									copyTo =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CopyTo")));
									location = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));


									break;
								}

								else if(workSheetName.equalsIgnoreCase("PatientMeds")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									prescribe=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("VerifyCommentsIcon" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									labTestName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabTestName")));
									labTestComments1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("labTestComments1")));
									labTestComments2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("labTestComments2")));
									break;
								}

								else if(workSheetName.equalsIgnoreCase("CreateReferralOrder" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									referral= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferralSearchName")));
									referral1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referral")));
									referralNoteText= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferralNote")));
									authorization= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Authorization")));
									storedValue = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StoredValue")));

									break;
								}
								else if(workSheetName.equalsIgnoreCase("FileLabReport" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									accNumber=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccessionNumber")));
									rProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Rprovider")));
									oProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Oprovider")));
									labName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportingLab")));
									labNameCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportingLabCA")));
									cDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CollectionDate")));
									cTime=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CollectionTime")));
									notes=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Notes")));
									testName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName")));
									testName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName1")));
									result=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Result")));
									low=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Low")));
									high=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("High")));
									comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
									units=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Units")));
									abnormal=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Abnormal")));
									patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
									reportStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportStatus")));
									show=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Show")));
									firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									provider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									break;
								}else if(workSheetName.equalsIgnoreCase("ElectronicFileLabReport" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									ftpHostStage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FtpHostStage")));
									ftpUserStage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FtpUserStage")));
									ftpPasswordStage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FtpPasswordStage")));
									ftpHost=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FtpHost")));
									ftpUser=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FtpUser")));
									ftpPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FtpPassword")));
									sourcePath=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SourcePath")));
									destDir=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DestinationDir")));
									numLabs=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumLabs")));                                	
									normal=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Normal")));
									providerID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderID")));                                	
									patientHCN=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientHCN")));                                	
									labTest=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabTest")));
									labTest1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabTest1")));
									facilityName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FacilityName")));
									ssNumber=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SSNumber")));
									break;
								}else if(workSheetName.equalsIgnoreCase("VerifyGrowthChart" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									errorMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ErrorMessage")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("PatientHandouts" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									medical = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical")));
									medicalCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical Condtion")));
									onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Onset Date")));
									itemStatus= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Item Status")));
									lifeStage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage")));
									resDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resloved Date")));
									codingSystem= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Coding System")));
									diagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									break;
								}else if(workSheetName.equalsIgnoreCase("MedWarnings" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									prescribe= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
									prescribeName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeName")));
									reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									indications= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Indication")));
									prescribeName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeName")));
									severity= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Severity")));
									provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									loaction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Loaction")));
									allergen = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
									allergenCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergenCA")));
									prescribeCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeCA")));
									status = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateEncounterReference" )){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									reference = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reference")));
									bookMark = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BookMark")));
									break;
								}else if(workSheetName.equalsIgnoreCase("PatientSummary" )){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));

									break;
								}

								else if(workSheetName.equalsIgnoreCase("CreatePatientTask" )){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									TaskType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaskType")));
									Instruction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Instruction")));
									DueIn = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DueIn")));
									AssignTo = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignTo")));                                    
									Requestedby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Requestedby")));
									Recipienttype = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Recipienttype")));
									Deliverymethod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Deliverymethod")));
									Consentname = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Consentname")));
									Show = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Show")));
									DueInCount=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DueInCount")));
									DueInUnit= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DueInUnit")));
									AssignToChartDis=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignToChartDis")));
									RequesterName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RequesterName")));
									RequesterRel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RequesterRel")));
									ContactPhone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContactPhone")));
									Extn=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Extn")));
									RecipientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecipientName")));
									RecipientRel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecipientRel")));
									RepConPhn=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RepConPhn")));
									RepExtn=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RepExtn")));
									Add1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Add1")));
									Add2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Add2")));
									City=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
									State=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
									Zip=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zip")));
									Country=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
									//Fax=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax")));                      
									break;
								}
								else if(workSheetName.equalsIgnoreCase("CreateDiganosticImaging" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									labTestName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabTestName")));
									labTestComments1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("labTestComments1")));
									labTestComments2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("labTestComments2")));
									authorization= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Authorization")));
									medicalCondition = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical Condtion")));
									itemStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Item Status")));
									printOn = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrintOn")));
									payer =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Payer")));
									provider =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									copyTo =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CopyTo")));

									break;
								}
								else if(workSheetName.equalsIgnoreCase("Cosign")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									providerName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderName")));
									provider1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider1")));
									vitals = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Vitals")));
									chiefComplaint= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ChiefComplaint")));
									chief = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Chief")));
									chief1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ChiefComplaint1")));
									historyType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HistoryType")));
									review = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Review")));
									notes = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Notes")));
									medicalCondition = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicalCondition")));
									medicalCondition1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicalCondition1")));
									itemStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									diagnosis = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis")));
									prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
									reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									offEncounter = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OffEncounter")));
									show=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Show")));
									EncountertypeMy=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EncountertypeMy")));
									EncounterTypeCo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EncounterTypeCo")));
									CosignProv=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cosign")));

									break;
								}else if(workSheetName.equalsIgnoreCase("EMRSecurity" )){  
									loaction =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Loaction")));
								     userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
	                                    prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
	                                    prescribeCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeCa")));
	                                    provider= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
	                                    practice = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
	                                    newPractice = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NewPractice")));                                    
	                                    dataShareLevel = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DataShareLevel")));

	                                    emergencyAccessDuration= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EmergencyAccessDuration")));
	                                    emergencyAccessReason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EmergencyAccessReason")));
	                                    race = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Race")));
										ethnicity = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Ethnicity")));
										religion = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Religion")));
										citizenship = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Citizenship")));
										studentStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StudentStatus")));
										householdIncome = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HouseholdIncome")));
										employmentStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EmploymentStatus")));
										comments = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
	                                    break;							
								
								}else if(workSheetName.equalsIgnoreCase("ImplementReferrals" )){  //implement referral
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
                                    referral1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referral")));
                                    //otherReferral=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OtherReferral")));
									provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									providerName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderName")));									
									letterTemplateName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LetterTemplateName")));
									templateNameToCopy = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateNameToCopy")));;
									templateNameToRename = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateNameToRename")));									
									templatePageSize = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplatePageSize")));
									templateType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateType")));									
									refLetterTaskType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaskType")));
									refLetterTaskName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaskName")));	
									refLetterTaskAssignTo = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaskAssignTo")));
									allTemplateFields = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllTemplateFields")));
									templateHTML = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateHTML")));
									editTemplateFields = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EditTemplateFields")));
									editTemplateHTML = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EditTemplateHTML")));
									reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									practice = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
									primaryPhone = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrimaryPhone")));
									primaryPhoneExtn = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrimayExtn")));
									BussinessPhone = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BussinessPhone")));
									BussinessPhoneExtn = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BussinessExtn")));
									addressLine1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address1")));
									addressLine2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address2")));
									city = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
									state = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
									zipCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
									
									
                                    break;
                                    }
								else if(workSheetName.equalsIgnoreCase("PreventiveCare")){ 
									  provider =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									  instructions =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Instructions")));
									  callerScript =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CallerScript")));                               

                              	  userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
                                    reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
                                    recallFrequency = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecallFrequency")));
                                    recallCount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecallCount")));
                                    recallUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecallUnit")));
                                    alertName =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertName")));
                                    
                                    break;
                                }
								
								else if(workSheetName.equalsIgnoreCase("SigningAuthority")){ 
									provider =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									editRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EditRole")));
									featureName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FeatureName")));
									documentType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FileDocumentType")));									 
									sender = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sender")));
									corrsReportType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CorrsReportType")));		
									rProvider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Rprovider")));
									oProvider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Oprovider")));
									labName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportingLab")));
									labNameCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportingLabCA")));
									testName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName")));									
									result=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Result")));
									facilityName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Facility")));
									location =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Loaction")));
									accessLevel = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccessLevel")));

									break;
								}else if(workSheetName.equalsIgnoreCase("CreateCorresReport")){ 
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									ReportType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Report Type")));
									Receivingprovider= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Receiving provider")));
									DocumentType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DocumentType")));									 
									AccessionNumber = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Accession Number")));
									DOS= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOS")));		
									ReceivingDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Receiving Date")));
									Sender= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sender")));
									Orderingprovider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Ordering provider")));
									Diagnosis=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis")));
									Comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));									
									Show=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Show")));			
									For=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("For")));	
									comments1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("comments1")));	
									comments2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("comments2")));	
									comments3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("comments3")));	
									ReportType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Report Type1")));
									TaskInst=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaskInst")));
									DiagnosisName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiagnosisName")));	
									ForwardTo=	readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ForwardTo")));	
									RefilePatient =	readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefilePatient")));
									break;						
								
									
								}else if(workSheetName.equalsIgnoreCase("PortOrderTemplate_CA")){
									
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									templateName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateName")));
									testName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName")));
									testName1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName1")));
									testName2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName2")));
									testName3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName3")));
									
									break;
								}
								
								else if(workSheetName.equalsIgnoreCase("CreateDiagnosticReport")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									userName1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName1")));
									userPassword1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password1")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									patientId1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId1")));
									ReportType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Report Type")));
									Receivingprovider= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Receiving provider")));
									Orderingprovider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Ordering provider")));
									DocumentType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DocumentType")));									 
									AccessionNumber = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Accession Number")));
									facilityName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Facility")));
									transcriptionist = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Transcriptionist")));
									comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
									labTestName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabTestName")));	
									testResult=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestResult")));	
									dicomment =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DIcomment")));
									forwardTo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Forwardto")));
									copiedTo =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Copiedto")));	
									orderedby =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Orderedby")));	
									break;
								}
							}else {
								break;
							}							
						}else {
							break;
						}
					}
				}
				if(isDataFound){					
					break;
				}
			}

			if(!isDataFound){
				Assert.fail("\nTest Data not found in test data sheet for Test Case Id  : " + testCaseId);
			}
		}catch (RuntimeException e) {
			Assert.fail("Error During Execution; Execution Failed More detaisl " + e);
			e.printStackTrace();
		}
		return isDataFound;
	}
}
