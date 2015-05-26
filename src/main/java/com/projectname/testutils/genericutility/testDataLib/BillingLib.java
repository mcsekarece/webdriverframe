package com.projectname.testutils.genericutility.testDataLib;

import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.projectname.testutils.genericutility.ReadFromExcel;

/**
 * @class BillingLib
 * This Class will contain reusable functions which can be used in Nexia Interface
 * @category Billing
 * @since Jan 04, 2014
 */

public class BillingLib  {
    
	public String workSheetName = null;
	public String testCaseId = null;
	public String userName = null;
	public String userPassword = null;
	public String switchRole = null;
	//public String userPassword = null;
	
	//Adj
	public String c_DAdjusment=null;
	public String reportCategory=null;
	public String adjusmentReason=null;
	//public String userPassword = null;

	//Billing History
	public String PatientId = null;

	//Fee Schedule
	
	public String payer = null;
	public String plan = null;
	public String practice = null;
	public String location = null;

	public String placeofservice=null;
	public String speciality = null;
	public String provider = null;
	public String modifier = null;
	public String searchServiceCode = null;
	public String codeRangeFrom = null;
	public String CodeRangeTo = null;
	public String allowedAmount = null;
	public String effectiveDate = null;
	public String baseUnits = null;
	public String allowedUnit = null;
	public String allowedAmount1 = null;
	public String effectiveDate1 = null;
	public String baseUnits1 = null;
	public String allowedUnit1 = null;
	public String payer1 = null;
	public String provider1 = null;
	public String allowedType = null;
	
	//SuperBillSetUp
	public String templateName = null;
	public String specialty = null;
	public String sectionLabel = null;
	public String sectionlabel2 = null;
	public String serviceCode = null;
	public String serviceCodeCA = null;
	public String description = null;
	public String description1 = null;
	public String modifiers = null;
	public String modifiers1 = null;
	public String patientID = null;
	public String diagnosisCodes = null;
	
	
	//Service Codes
	public String serviceCode1 = null;
	public String serviceCode2 = null;
	public String serviceCode3 = null;
	public String serviceCode4 = null;
	public String serviceCode5 = null;
	public String serviceCode6 = null;
	public String serviceCode7 = null;
	public String serviceCode8 = null;
	public String serviceCode9 = null;
	public String serviceCode10 = null;
	public String serviceDescription1 = null;
	public String serviceDescription2 = null;
	public String serviceDescription3 = null;
	public String serviceDescription4 = null;
	public String codingSystem = null;
	public String codingSystemCA = null;
	public String currentFees = null;
	public String currentFees1 =null;
	public String newFees = null;
	public String billingProviderUS=null;
	public String placeOfServiceUS=null;
	public String units = null;
	public String unit2= null;
	public String unit3 = null;
	public String unit4 = null;
	public String unit5 = null;
	public String unit6 = null;
	public String unit7 = null;
	public String effectiveOnDateCurrent = null;
	public String effectiveOnDateNew = null;
	public String drugCode = null;
	public String serviceCodeModifier = null;
	public String totalRVU = null;
	public String typeOfService = null;
	public String workRVU = null;
	public String globalPeriod = null;
	public String reportGroup = null;
	public String providerSpeciality = null;
	public String instructionToBiller = null;
	public String percentage = null;
	public String amount = null;
	public String updatedAmt = null;
	public String updatedAmtPercent = null;
	public String updatedAmt1 = null;
	public String updatedAmtPercent1 = null;
	public String ctCode = null;
	public String modifierType = null;
	public String privateFee1 = null;
	public String privateFee2 = null;
	public String endsWithValue = null;
	public String dividedByValue = null;
	//chargeEntry
	public String unitsServiceLine = null;
	public String renderingProvider= null;
	public String referringProvider= null;
	public String billingProvider= null;
	public String caseChargeEntry= null;
	public String program= null;
	public String placeOfService= null;
	public String dateOfService1= null;
	public String dateOfService2= null;
	public String diagnosisCodeSL= null;
	public String fee= null;
	public String chargeAmount= null;
	public String diagnosisCode= null;
	public String accidentType= null;
	public String accidentDate= null;
	public String accidentState= null;
	public String accidentHour= null;
	public String accidentMins= null;
	public String amPm= null;
	public String patientWeight=null;
	public String patientCount=null;
	public String transReason=null;
	public String transDistance=null;
	public String roundTrip=null;
	public String stretcherPurpose=null;
	public String conditionCodes=null;
	public String pickStreet1=null;
	public String pickStreet2=null;
	public String pickCity=null;
	public String pickZip=null;
	public String pickState=null;
	public String pickCountry=null;
	public String dropStreet1=null;
	public String dropStreet2=null;
	public String dropCity=null;
	public String dropZip=null;
	public String dropState=null;
	public String dropCountry=null;
	public String patientCond=null;
	public String condDesc=null;
	public String dateInitialTreat=null;
	public String dateAcuteMan=null;
	public String radYes=null;
	public String radNo=null;
	public String dateLastXray=null;
	public String dMECertificate=null;
	public String equipDuration=null;
	public String certiCondition=null;
	public String certiRevDate=null;
	public String beginTherapyDate=null;
	public String lastCertiDate=null;
	public String patientHeight=null;
	public String dMEPatientWeight=null;
	public String lenMedicalNece=null;
	public String rentalPrice=null;
	public String rentalPriceUnit=null;
	public String purchasePrice=null;
	public String oxyCertificate=null;
	public String oxyDuration=null;
	public String oxyCertiCondition=null;
	public String oxyCertiRevDate=null;
	public String oxyBeginTherapyDate=null;
	public String oxyLastCertiDate=null;
	public String NDCDrugCode=null;
	public String quantity=null;
	public String presciptionType=null;
	public String unitType=null;
	public String prescriptionNum=null;
	public String PrescriptionDate=null;
	public String Comment=null;
	public String Comment1=null;
	public String ProviderType=null;
	public String StartServiceHr=null;
	public String StartServiceMin=null;
	public String EndServiceHr=null;
	public String EndServiceMin=null;
	public String ServiceTimeDuration=null;
	public String ServiceLevelIndicator=null;
	public String DateOfAdmission=null;
	public String authorizationPayer=null;
	public String authorizationToAdd=null;
	public String authorizationToSelect=null;
	public String authorizationVisits=null;
	
	public String practiceA = null;
	public String practiceB = null;
	public String practiceAStatementOption = null;
	public String practiceBStatementOption = null;

	//PostPatientPayment
	public String methodOfPayment = null;
	public String referenceNo = null;
	public String paidAmount = null;
	public String leaveUnallocate = null;
	public String autoallocate = null;
	public String toTalPaidAmount = null;

	
	
	//statementPreferences
	public String minPayment=null;
	public String balanceAtLeast=null;
	public String writeOff=null;
	public String adCode=null;
	public String patientSelection=null;
	public String fromName=null;
	public String toName=null;
	public String interval=null;
	public String monthlyQualifier=null;
	public String dom=null;
	public String daySelect=null;
	

	//statementBatch
	public String patientFirstname=null;
	public String patientLastname=null;
	public String financialStatus = null;

	public String waitDays = null;
	public String badDebt = null;
	public String pendingCollection = null;
	//PayerPayments
	public String insurance = null;
	public String checkAmount = null;
	public String checkNumber = null;
	public String depositDate = null;
	public String totalPaidAmount = null;
	public String adjustmentReason = null;
	public String patientName = null;
	public String groupCode = null;
	public String reasonCode = null;
	public String CASAmount = null;
	public String allowedAmt1 = null;
	public String deductable1 = null;
	public String coInsurance1 = null;
	public String coPayment1 = null;
	public String paidAmt1 = null;
	public String contractualAmt1 = null;
	public String adjustmentAmt1 = null;
	
	public String allowedAmt2 = null;
	public String deductable2 = null;
	public String coInsurance2 = null;
	public String coPayment2 = null;
	public String paidAmt2 = null;
	public String contractualAmt2 = null;
	public String adjustmentAmt2 = null;
	public String credit = null;
	public String debit = null;
	

	//SuperBillEntryQueue
	public String rprovider = null; 
	public String dateoFService =null;
	public String payTo = null;
	public String paymentProgram = null;
	public String billTo = null;
	public String fromDate = null;
	
	public String toDate = null;
	public String fee1 = null;
	public String fee2 = null;
	public String fee3 = null;
	public String fee4 = null;
	public String fee5 = null;
	public String fee6 = null;
	public String fee7 = null;
	public String fee8 = null;
	public String fee9 = null;
	public String fee10 = null;
	public String toTalFee1 = null;
	public String toTalFee2 = null;
	public String toTalFee3 = null;
	public String toTalFee4 = null;
	public String toTalFee5 = null;
	public String toTalFee6 = null;
	public String toTalFee7 = null;
	public String toTalFee8 = null;
	public String toTalFee9 = null;
	public String insuranceBalance = null;
	public String patientBalance = null;
	public String unAppliedAmount = null;
	public String patientBalance1=null;
	
	public String ServiceType=null;
	public String Therapy=null;	
	
	
	
	public Hashtable<String, Integer> excelHeaders = new Hashtable<String, Integer>();
	public Hashtable<String, Integer> excelrRowColumnCount = new Hashtable<String, Integer>();
	
	public String workBookName = "TestData_Billing.xls";		
	public String sectionName = "billing";
	
	
	
	/**
	 * fetchCodingInterfaceTestData
	 * function for fetching Test data based on test case id  
	 * @since  	     Apr 30, 2010	  
	 */
	
	public boolean fetchBillingTestData(){
		
		ReadFromExcel readTestData = new ReadFromExcel();
		boolean isDataFound = false;
		testCaseId = testCaseId != null ? testCaseId.trim() : "";
		
		try{
			//******************************************************************//
			//Fetching the test data for New Clinical Interface
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
								if(workSheetName.equalsIgnoreCase("AdjustmentCodes")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									adjusmentReason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdjusmentReason")));
									description = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									c_DAdjusment = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("C/DAdjusment")));
									reportCategory = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportCategory")));
									break;
								}else if(workSheetName.equalsIgnoreCase("FeeSchedule")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									payer= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Payer")));
									payer1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Payer1")));
									plan=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Plan")));
									practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
									location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Locations")));
									speciality=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Speciality")));
									provider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									provider1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider1")));
									modifier=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Modifier")));
									searchServiceCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchServiceCode")));
									serviceCodeCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodeCA"))); 
									codeRangeFrom=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CodeRangeFrom")));
									CodeRangeTo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CodeRangeTo")));
									allowedAmount=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllowedAmount")));
									effectiveDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EffectiveDate")));
									baseUnits=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BaseUnits")));
									allowedUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllowedUnits")));
									allowedAmount1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllowedAmount1")));
									effectiveDate1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EffectiveDate1")));
									baseUnits1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BaseUnits1")));
									allowedUnit1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllowedUnits1")));
									allowedType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllowedType")));
									break;
								}else if(workSheetName.equalsIgnoreCase("SuperBillSetUp")){

									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									templateName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateName")));
									specialty= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Specialty")));
									sectionLabel= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sectionlabel")));
									sectionlabel2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sectionlabel2")));
									serviceCode= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCode")));
									serviceCode2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Servicecode2")));
									description= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									modifiers= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Modifiers")));
									modifiers1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Modifiers1")));
									
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
									location= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
									placeOfService= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PlaceOfService")));
									diagnosisCodes = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiagnosisCodes"))); 
									serviceCodeCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodeCA"))); 
									break;
								}else if(workSheetName.equalsIgnoreCase("ServiceCodes")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									serviceCode1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCode1")));
									serviceCode2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCode2")));
									serviceCode3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCode3")));
									serviceCode4 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCode4")));
									serviceDescription1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceDescription1")));
									serviceDescription2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceDescription2")));
									serviceDescription3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceDescription3")));
									codingSystem = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CodingSystem")));
									codingSystemCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CodingSystemCA")));
									currentFees = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CurrentFees")));
									currentFees1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CurrentFees1")));
									newFees = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NewFees")));
									units = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Units")));
									effectiveOnDateCurrent = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EffectiveOnDateCurrent")));
									effectiveOnDateNew = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EffectiveOnDateNew")));
									drugCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DrugCode")));
									serviceCodeModifier = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodeModifier")));
									totalRVU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TotalRVU")));
									typeOfService = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TypeOfService")));
									workRVU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WorkRVU")));
									globalPeriod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GlobalPeriod")));
									reportGroup = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportGroup")));
									providerSpeciality = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderSpeciality")));
									instructionToBiller = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InstructionToBiller")));
									amount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Amount")));
									percentage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Percentage")));
								
								    updatedAmt =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UpdatedAmt")));
								    updatedAmtPercent =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UpdatedAmtPercent")));
								    updatedAmt1 =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UpdatedAmt1")));
								    updatedAmtPercent1 =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UpdatedAmtPercent1")));
								    patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
								    modifierType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ModifierType")));
								    privateFee1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrivateFee1")));
								    privateFee2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrivateFee2")));
								    endsWithValue = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndsWithValue")));
								    dividedByValue = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DividedByValue")));
									break;
								}else if(workSheetName.equalsIgnoreCase("BillingHistory")){
								    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									break;
								}else if(workSheetName.equalsIgnoreCase("ChargeEntry")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									unitsServiceLine=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Units")));
									renderingProvider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RenderingProvider")));
									specialty = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Specialty")));
									billingProvider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingProvider")));
									referringProvider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferringProvider")));
									location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
									placeOfService = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PlaceOfService")));
									caseChargeEntry = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Case")));
									program = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
									dateOfService1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateOfService1")));
									dateOfService2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateOfService2")));
									serviceCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCode")));
									serviceCodeCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodeCA")));
									modifiers = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Modifiers")));
									diagnosisCodeSL = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiagnosisCodesSL")));
									fee = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee")));
									chargeAmount=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ChargeAmount")));
									diagnosisCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiagnosisCode")));
									accidentType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccidentType")));
									accidentDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccidentDate")));
									accidentHour = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccidentHour")));
									accidentMins=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccidentMins")));
									accidentState = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccidentState")));
									amPm = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AM/PM")));
									patientWeight=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientWeight")));
									patientCount=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientCount")));
									transReason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TransDistance")));
									transDistance=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TransReason")));
									roundTrip=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RoundTrip")));
									stretcherPurpose=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StretcherPurpose")));
									conditionCodes=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConditionCodes")));
									pickStreet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PickStreet1")));
									pickStreet2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PickStreet2")));
									pickCity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PickCity")));
									pickZip=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PickZip")));
									pickState=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PickState")));
									pickCountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PickCountry")));
									dropStreet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DropStreet1")));
									dropStreet2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DropStree2")));
									dropCity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DropCity")));
									dropZip=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DropZip")));
									dropState=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DropState")));
									dropCountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DropCountry")));
									patientCond=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientCond")));
									condDesc=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CondDesc")));
									dateInitialTreat=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InitialTreatDate")));
									dateAcuteMan=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AcuteManiDate")));
									radYes=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("XrayYes")));
									radNo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("XrayNo")));
									dateLastXray=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastXrayDate")));
									dMECertificate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DMECerti")));
									ctCode =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CTCode")));
									equipDuration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EquipDuration")));
									certiCondition=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CertiCondition")));
									certiRevDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CertiRevDate")));
									beginTherapyDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BeginTheraphyDate")));
									lastCertiDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastCertiDate")));
									patientHeight=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientHeight")));
									dMEPatientWeight=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DMEPatientWeight")));
									lenMedicalNece=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LenMedicalNec")));
									rentalPrice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RentalPrice")));
									rentalPriceUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RentalPriceUnit")));
									purchasePrice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PurchasePrice")));
									oxyCertificate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OxyCertificate")));
									oxyDuration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OxyDuration")));
									oxyCertiCondition=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OxyCertiCondition")));
									oxyCertiRevDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CertiRevDate")));
									oxyBeginTherapyDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OxyBeginTheraphyDate")));
									oxyLastCertiDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastCertiDate")));
									NDCDrugCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DrugCode")));
									quantity = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Quantity")));
									presciptionType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PriscriptionType")));
									unitType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UnitType")));
									prescriptionNum = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescriptionNum")));
									PrescriptionDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescriptionDate")));
									ProviderType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderType")));
									StartServiceHr=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartServiceTimeHr")));
									StartServiceMin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartServiceTimeMin")));
									EndServiceHr=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndServiceTimeHr")));
									EndServiceMin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndServiceTimeMin")));
									ServiceTimeDuration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceTimeDuration")));
									transDistance=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TransDistance")));
									transReason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TransReason")));
									ServiceType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceType")));
									Therapy=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Therapy")));
									ServiceLevelIndicator=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceLevelIndicator")));
									DateOfAdmission=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateOfAdmission")));
									units=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Units")));
									billingProviderUS=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingProviderUS")));
									placeOfServiceUS=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PlaceOfServiceUS")));
									payTo = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayTo")));
									authorizationPayer = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AuthorizationPayer")));
									authorizationToAdd = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AuthorizationToAdd")));
									authorizationToSelect = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AuthorizationToSelect")));
									authorizationVisits = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AuthorizationVisits")));
									practiceA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeA"))); 
									practiceB = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeB"))); 
									practiceAStatementOption = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeAStatementOption")));
									practiceBStatementOption = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeBStatementOption")));
									financialStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FinancialStatus")));
									
									
									
									break;
								}else if(workSheetName.equalsIgnoreCase("SuperBillEntry")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
									templateName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateName")));
									modifiers= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Modifiers")));
									modifiers1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Modifiers1")));
									serviceCode= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCode")));
									serviceCode2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodes2")));
									serviceCode3= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodes3")));
									serviceCode4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodes4")));
									serviceCode5= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodes5")));
									serviceCode6= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodes6")));
									serviceCode7= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodes7")));
									serviceCode8= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodes8")));
									serviceCode9= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodes9")));
									serviceCode10= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodes10")));
									diagnosisCodes = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiagnosisCodes"))); 
									rprovider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Rprovider"))); 
									location = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location"))); 
									specialty = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Specialty"))); 
									placeOfService = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PlaceOfService"))); 
									dateoFService = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateoFService"))); 
									payTo = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayTo"))); 
									paymentProgram = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PaymentProgram")));
									billTo = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillTo")));
									units = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Units")));
									unit2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit2")));
									unit3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit3")));
									unit4 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit4")));
									unit5 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit5")));
									unit6 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit6")));
									unit7 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit7")));
									fee1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee1"))); 
									fee2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee2"))); 
									fee3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee3"))); 
									fee4 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee4"))); 
									fee5 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee5"))); 
									fee6 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee6"))); 
									fee7 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee7"))); 
									fee8 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee8"))); 
									fee9 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee9"))); 
									fee10 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee10"))); 
									
									
									
									toTalFee1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TotalFee1"))); 
									toTalFee2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToTalFee2"))); 
									toTalFee3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToTalFee3"))); 
									toTalFee4 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToTalFee4"))); 
									toTalFee5 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToTalFee5"))); 
									toTalFee6 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToTalFee6"))); 
									toTalFee7 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToTalFee7"))); 
									toTalFee8 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToTalFee8"))); 
									toTalFee9 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToTalFee9"))); 
									insuranceBalance = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InsuranceBalance")));
									patientBalance = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientBalance")));
									patientBalance1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientBalance1")));
									unAppliedAmount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UnAppliedAmount")));
									serviceCodeCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodeCA"))); 
									
									
									break;
								}else if(workSheetName.equalsIgnoreCase("PostPatientPayment")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
									methodOfPayment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MethodOfPayment")));
									referenceNo= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferenceNo")));
									paidAmount= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PaidAmount")));
									provider= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									location = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location"))); 
									leaveUnallocate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LeaveUnallocate")));
									autoallocate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Autoallocate")));
									toTalPaidAmount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToTalPaidAmount")));
									break;
								}else if(workSheetName.equalsIgnoreCase("StatementPreferences")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									minPayment = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MinimumPayment")));
									balanceAtLeast = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BalanceAtLeast")));
									writeOff = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WriteOff")));
									break;
								}else if(workSheetName.equalsIgnoreCase("PayerPayments")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									insurance = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Insurance")));
									checkAmount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CheckAmount")));
									checkNumber = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CheckNumber")));
									depositDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DepositDate")));
									totalPaidAmount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TotalPaidAmount")));
									adjustmentReason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdjustmentReason")));
									patientName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
									groupCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupCode")));
									reasonCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonCode")));
									CASAmount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CASAmount")));
									
									allowedAmt1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllowedAmt1")));
									deductable1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Deductable1")));
									coInsurance1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoInsurance1")));
									coPayment1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoPayment1")));
									paidAmt1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PaidAmt1")));
									contractualAmt1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContractualAmt1")));
									adjustmentAmt1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdjustmentAmt1")));
									
									allowedAmt2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllowedAmt2")));
									deductable2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Deductable2")));
									coInsurance2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoInsurance2")));
									coPayment2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoPayment2")));
									paidAmt2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PaidAmt2")));
									contractualAmt2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContractualAmt2")));
									adjustmentAmt2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdjustmentAmt2")));
									credit  = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credit"))); 
									debit  = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Debit"))); 
									break;
								}else if(workSheetName.equalsIgnoreCase("PostChargePortablity")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									unitsServiceLine=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Units")));
									renderingProvider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RenderingProvider")));
									specialty = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Specialty")));
									billingProvider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingProvider")));
									location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
									placeOfService = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PlaceOfService")));
									dateOfService1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateOfService1")));
									dateOfService2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateOfService2")));
									serviceCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCode")));
									modifiers = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Modifiers")));
									diagnosisCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiagnosisCode")));
									units = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Units")));
									fee = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee")));
									fromDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FromDate")));
									toDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToDate")));
									serviceCodeCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodeCA")));
									break;
								}else if(workSheetName.equalsIgnoreCase("VerifySecurityOption")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("AdminStatements")){
								    	userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									minPayment = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MinimumPayment")));
									balanceAtLeast = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BalanceAtLeast")));
									writeOff = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WriteOff")));
									adCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdCode")));
									patientSelection=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientSelection")));
									fromName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FromName")));
									toName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToName")));
									interval=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Interval")));
									dom=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOM")));
									monthlyQualifier=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MonthlyQualifier")));
									daySelect=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DaySelection")));
									break;
								}else if(workSheetName.equalsIgnoreCase("BatchStatements")){
								    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientFirstname = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientFirstName")));
									patientLastname = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientLastName")));
									financialStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FinancialStatus")));
									waitDays = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WaitDays")));
									badDebt = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BadDebt")));
									pendingCollection = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PendingCollection")));
									
									break;
								}else if(workSheetName.equalsIgnoreCase("EndToEnd")){
									toTalFee1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TotalFee1")));
									toTalFee2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TotalFee2")));
									toTalFee3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TotalFee3")));
									toTalFee4 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TotalFee4")));
									break;
								}
								else {
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
	
	public boolean WriteBillingTestData(){

		ReadFromExcel writeTestData = new ReadFromExcel();
		boolean isDataFound = false;
		testCaseId = testCaseId != null ? testCaseId.trim() : "";
		try{
			//******************************************************************//
			//Fetching the test data for New Clinical Interface
			//******************************************************************//

			HSSFSheet sheet = null;
			// function call to initiate a connection to an excel sheet
			sheet = writeTestData.initiateExcelConnectionNexia(workSheetName, sectionName, workBookName); 
	
			// function to find number of rows and columns
			excelrRowColumnCount = writeTestData.findRowColumnCount(sheet, excelrRowColumnCount);
			
			// function call to find excel header fields
			excelHeaders = writeTestData.readExcelHeaders(sheet, excelHeaders, excelrRowColumnCount);
			
			HSSFRow row = null;
			HSSFCell cell = null;			
			String temptestCaseId = null;
	
			for(int r = 0; r < excelrRowColumnCount.get("RowCount"); r++) {
				row = sheet.getRow(r);  
				if(row != null) {
					for(int c = 0; c < excelrRowColumnCount.get("ColumnCount"); ) {						
						cell = row.getCell(excelHeaders.get("TestID"));
						if(cell != null){
							temptestCaseId = writeTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestID")));
							if(temptestCaseId.equals(testCaseId)){
								isDataFound = true;
								if(workSheetName.equalsIgnoreCase("EndToEnd")){
									writeTestData.writeDataToExcel(sectionName, workBookName, workSheetName, r, excelHeaders.get("TotalFee1"), toTalFee1);
									writeTestData.writeDataToExcel(sectionName, workBookName, workSheetName, r, excelHeaders.get("TotalFee2"), toTalFee2);
									writeTestData.writeDataToExcel(sectionName, workBookName, workSheetName, r, excelHeaders.get("TotalFee3"), toTalFee3);
									writeTestData.writeDataToExcel(sectionName, workBookName, workSheetName, r, excelHeaders.get("TotalFee4"), toTalFee4);
									break;
								}
								else {
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

// Comments - Verify Merge