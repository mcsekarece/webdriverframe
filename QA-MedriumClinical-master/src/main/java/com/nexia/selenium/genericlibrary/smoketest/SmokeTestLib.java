package com.nexia.selenium.genericlibrary.smoketest;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;




/**
 * @class  		SmokeTestLib
 * This Class will contain reusable functions which can be used in Nexia Interface
 * @category 	SmokeTests
 * @since  	     
 */
public class SmokeTestLib {
	
	public String testCaseId = null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String patientId = null;
	public String patientIdCA = null;
	public String switchRole=null;
	
	public String accNumber=null;
	public String rProvider=null;
	public String oProvider=null;
	public String labName=null;
	public String cDate=null;
	public String cTime=null;
	public String notes=null;
	public String testName=null;
	public String result=null;
	public String low=null;
	public String high=null;
	public String comments=null;
	public String units=null;
	public String dob=null;
	
	
	public String abnormal=null;
	public String patientName=null;
	public String reportStatus=null;
	public String show=null;
	public String firstName=null;
	public String lastName=null;
	public String provider=null;
	
	public String userName1=null;
	public String externalEmr=null;
	public String UserProvider=null;
	public String password=null;
	public String userRole=null;
	public String userRole1=null;
	public String practise=null;
	public String resetPassword=null;
	public String changedPassword=null;
	
	public String password1=null;
	public String startDate=null;
	
	
	public String searchType1 = null;
	public String searchType2 = null;
	public String searchType3 = null;
	public String searchType4 = null;
	public String searchType5 = null;
	public String searchType6 = null;
	public String durationCondition1 = null;
	public String year1 = null;
	public String prescribe = null;
	public String timeCondition1 = null ;
	public String allergen = null;
	public String allergenCA = null;
	public String timeCondition2 = null;
	public String labResult = null;
	public String durationCondition2 = null;
	public String year2 = null;
	public String timeCondition3 = null;
	public String medical= null;
	public String medicalCA= null;
	public String medicalCondition = null;
	public String timeCondition4 = null;
	public String firstSortBy= null;
	public String sex = null;	
	
	
	public String reaction= null;
	public String comment= null;
	public String severity= null;
	public String status= null;
	public String onsetDate= null;
	public String lifeStage= null;
	public String reason= null;
	public String onsetDate1 = null;
	public String lifeStage1= null;
	public String onsetDate2= null;
	public String lifeStage2= null;
	public String onsetDate3= null;
	public String lifeStage3= null;
	public String onsetDate4= null;
	public String lifeStage4= null;	
	public String allergyType = null;
	
	
	public String item = null;
	public String detailsNum = null;
	public String detailsText = null;
	public String period = null;
	public String year = null;
	public String startAge = null;
	public String historyType = null;
	public String stopAge = null;	
	public String type = null;
	
	
	public String loaction = null;
	public String freeText = null;
	public String direction = null;
	public String addDirectionCount = null;
	public String increaseDecreaseDose = null;
	public String refillMethod = null;
	public String refillQuantity = null;
	public String refillUnit = null;
	public String refillRoute = null;
	public String refillFrequency = null;
	public String refillUsage = null;
	public String usage = null;
	public String duration = null;
	public String refillUsage1 = null;
	public String refillUsage2 = null;
	public String refillUsage3 = null;
	public String multipleDirection = null;
	public String refillduration = null;
	public String method = null;
	public String quality = null;
	public String unit = null;
	public String route = null;
	public String frequency = null;
	public String dispense = null;
	public String unitList = null;
	public String fillon = null;
	public String ofRefill = null;
	public String notesToPharmacy = null;
	public String subPermitted = null;
	public String comePackage = null;
	public String saveList = null;
	public String problemSuggest = null;
	public String internalNote = null;
	public String searchWithin = null;
	public String searchWithinKM = null;
	public String searchWithinMiles = null;
	public String patient = null;
	public String practice  = null;
	public String zipcodecheck = null;
	public String zipcode = null;
	public String pharmacyName = null;
	public String prescribeName = null;
	public String providerName = null;
	public String signPassword = null;
	public String alert = null;
	
	public String patientAddress = null;
	public String providerAddress = null;
	public String dispenseWord = null;
	public String patientPhone = null;
	public String providerPhone = null;
	public String reasonForRestart = null;
	public String reasonForDelete = null;
	
		
	public String workSheetName = null;
	public String workBookName = "TestData_SmokeTest.xls";		
	public String sectionName = "smoketest";
	
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
		
	public boolean fetchSmokeTestData(){
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
								if(workSheetName.equalsIgnoreCase("VerifyExistingPatients")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));									
									patientIdCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientIdCA")));
									break;
								}
								
								else if(workSheetName.equalsIgnoreCase("CreateNewReport" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
                                    accNumber=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccessionNumber")));
                                	rProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Rprovider")));
                                	oProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Oprovider")));
                                	labName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportingLab")));
                                	cDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CollectionDate")));
                                	cTime=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CollectionTime")));
                                	notes=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Notes")));
                                	testName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName")));
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

								}								
								else if(workSheetName.equalsIgnoreCase("UnsignedEncounter" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));                                    
                                    break;
                                 }
								else if(workSheetName.equalsIgnoreCase("ForcePasswordReset" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									externalEmr=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExternalEMR")));
									resetPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResetPassword")));
									userName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName1")));
									password1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password1")));
									startDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("VerifySecurityOption")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("verifySearchWithAllCombination")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									sex = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
									dob = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOB")));
									searchType1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType1")));
									searchType2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType2")));
									searchType3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType3")));
									searchType4 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType4")));
									searchType5 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType5")));
									searchType6 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType6")));
									durationCondition1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DurationCondition1")));
									year1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Year1")));
									prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
									timeCondition1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition1")));
									allergen = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
									allergenCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergenCA")));
									timeCondition2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition2")));
									labResult = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabResult")));
									durationCondition2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DurationCondition2")));
									year2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Year1")));
									timeCondition3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition3")));
									medical= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical")));
									medicalCA= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicalCA")));
									medicalCondition = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicalCondition")));
									timeCondition4 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition4")));
									firstSortBy= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstSortBy")));
									break;
								}								
								else if(workSheetName.equalsIgnoreCase("CreateAllergy")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									allergyType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergyType")));
									allergen = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
									allergenCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergenCA")));
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
									break;
								}
								else if(workSheetName.equalsIgnoreCase("SearchPharmacy")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
									provider= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									loaction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Loaction")));
									freeText = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeText")));
									direction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Direction")));
									addDirectionCount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdditionalDirectionCount")));
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
									dispense = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Dispense")));
									unitList = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UnitList")));
									fillon = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fillon")));
									ofRefill = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OfRefill")));
									notesToPharmacy = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotesToPharmacy")));
									subPermitted = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SubPermitted")));
									comePackage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ComePackage")));
									saveList = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SaveList")));
									problemSuggest = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProblemSuggest")));
									internalNote = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InternalNote")));
									/*previousPharmacy = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PreviousPharmacy")));
									searchDatabase = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchDatabase")));*/
									searchWithin = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchWithin")));
									searchWithinKM = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchWithinKM")));
									searchWithinMiles = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchWithinMiles")));
									patient = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Patient")));
									practice  = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
									zipcodecheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zipcodecheck")));
									zipcode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zipcode")));
									pharmacyName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Pharmacyname")));
									prescribeName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeName")));
									patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
									providerName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderName")));
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
									break;
								}
								else if(workSheetName.equalsIgnoreCase("CreateSocialHistory")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									//switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
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
									
									break;
								}
								
								else if(workSheetName.equalsIgnoreCase("AboutBox")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
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
