package com.nexia.selenium.genericlibrary.clinicalList;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;

/**
 * @class  		ClinicalListLib
 * This Class will contain reusable functions which can be used in Nexia Interface
 * @category 	Clinical
 * @since  	    Nov 21, 2012
 */

public class ClinicalListLib {
	
	public String testCaseId = null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String patientId = null;
	public String workSheetName = null;
	public String  currentValue = null;
	public String authorization=null;
	
	public String searchType=null;
	public String sex=null;
	public String sex1=null;
	
	public String prescribe=null;
	public String prescribeca=null;
	public String prescribeName=null;
	public String prescribeNameCa=null;
	public String prescribeNameCa1=null;
	public String provider=null;
	public String provider1=null;
	public String loaction=null;
	public String freeText=null;
	public String direction=null;
	public String increaseDecreaseDose=null;
	public String refillMethod=null;
	public String refillQuantity=null;
	public String refillUnit=null;
	public String refillRoute=null;
	public String refillFrequency=null;
	public String refillUsage=null;
	public String usage=null;
	public String duration=null;
	public String duration1=null;
	public String refillUsage1=null;
	public String refillUsage2=null;
	public String refillUsage3=null;
	public String multipleDirection=null;
	public String refillduration=null;
	public String method=null;
	public String quality=null;
	public String unit=null;
	public String route=null;
	public String frequency=null;
	public String dispense=null;
	public String unitList=null;
	public String fillon=null;
	public String ofRefill=null;
	public String notesToPharmacy=null;
	public String subPermitted=null;
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
	public String zipcodecheck=null;
	public String comePackage=null;
	public String patientName=null;
	public String providerName=null;
	public String patientAddress=null;
	public String providerAddress=null;
	public String dispenseWord=null;
	public String patientPhone=null;
	public String providerPhone=null;
	public String dobCa=null;
	
	
	public String consentCheck=null;
	public String injection=null;
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
	
	public String severity=null;
	public String status=null;
	public String onsetDate=null;
	public String lifeStage=null;
	
	
	public String medicalCondition=null;
	public String medicalConditionCA=null;
	public String itemStatus=null;
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
	public String sortBy=null;
	
	public String startDate=null;
	public String supply=null;
	public String refillUsage4=null;
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

	public String prescribe1=null;
	public String prescribeName1=null;
	public String searchField=null;
	public String periodNumber=null;
	public String timeCondition=null;
	
	public String period1=null;
	public String searchField1=null;
	public String periodNumber1=null;
	public String timeCondition1=null;
	public String timeCondition2=null;
	public String timeCondition3=null;
	public String timeCondition4=null;
	public String date1=null;

	
	public String durationCondition = null;
	public String durationCondition1 = null;
	public String durationCondition2 = null;
	
	public String medicalCondition1=null;
	public String diagnosis1=null;
	public String diagnosis2=null;
	public String diagnosis3=null;
	
	public String dob = null;
	public String firstName = null;
	public String lastName = null;
	public String searchName=null;
	public String note=null;
	
	
	
	public String year1=null;
	public String year2=null;
	public String maxYear=null;
	public String searchName1=null;
	
	public String allergen=null;
	public String allergen1=null;
	public String allergenCa=null;
	public String allergen1Ca=null;
	public String periodCondition=null;
	
	public String labResult=null;
	public String accessionNumber=null;
	public String lab=null;
	public String labCA=null;
	public String test=null;
	public String test1=null;
	public String time=null;
	public String result=null;
	public String result1=null;

	public String description=null;
	
	public String searchType1=null;
	public String searchType2=null;
	public String searchType3=null;
	public String searchType4=null;
	public String searchType5=null;
	public String searchType6=null;
	public String switchRole=null;
	
	
	public String primaryLocation=null;
	public String responsibleProvider=null;
	public String telephoneType1=null;
	public String telephoneNo1=null; 
	public String telephoneextnNo1=null;
	public String firstSortBy=null;
	
	public String fromDate=null;
	public String checkBox=null;
	
	public String recurringPeriod=null;
	public String deleteReason=null;
	public String recurringUnit=null;
	public String patientID=null;
	public String editDate=null;
	
	
	
	public String workBookName = "TestData_ClinicalList.xls";		
	public String sectionName = "clinicalList";
	
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
		
	public boolean fetchClinicalListTestData(){
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
								if(workSheetName.equalsIgnoreCase("verifySearchForSex" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    searchType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Search Type")));
                                    sex= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
                                    sex1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex1")));
                                    searchName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchName")));
                                    searchName1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchName1")));
                                    currentValue = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CurrentPossition")));
                                    break;
								}
								else if(workSheetName.equalsIgnoreCase("SearchProblemList")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									medicalCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical Condtion")));
									medicalCondition1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical Condtion1")));
									onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Onset Date")));
									itemStatus= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Item Status")));
									lifeStage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage")));
									resDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resloved Date")));
									codingSystem= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Coding System")));
									diagnosis1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis1")));
									diagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis")));
									diagnosis2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis2")));
									diagnosis3= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis3")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									searchField = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType")));
									timeCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition")));
									periodNumber= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PeriodNumber")));
									period= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period")));
									date= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date")));
									timeCondition1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition1")));
									periodNumber1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PeriodNumber1")));
									period1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period1")));
									date1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date1")));
									timeCondition2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition2")));
									currentValue = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CurrentPossition")));
									break;
								}else if(workSheetName.equalsIgnoreCase("SearchMedication")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
									prescribeca = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeCA")));
									prescribeName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeName")));
									prescribeNameCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeNameCA")));
									prescribeNameCa1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeNameCA1")));
									prescribe1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe1")));
									prescribeName1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeName1")));
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
									searchField = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType")));
									timeCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition")));
									periodNumber= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PeriodNumber")));
									period= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period")));
									date= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date")));
									timeCondition1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition1")));
									periodNumber1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PeriodNumber1")));
									period1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period1")));
									date1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date1")));
									timeCondition2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition2")));
									sex= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
									lastName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									sortBy= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SortBy")));
									currentValue = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CurrentPossition")));
									break;
								}

								 if(workSheetName.equalsIgnoreCase("verifySearchForAge")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										searchType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Search Type")));
										durationCondition = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration Condition")));
										durationCondition1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration Condition1")));
										durationCondition2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration Condition2")));
										year = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Year")));
										maxYear = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxYear")));
										year1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Years1")));
										year2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Years2")));
										currentValue = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CurrentPossition")));
										break;
									}

									else if(workSheetName.equalsIgnoreCase("NewPatientCheckIn" )){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                    dob=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrematureCheck")));
										sex=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
										lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
	                                    firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
	                                    status=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
	                                    break;
									}else if(workSheetName.equalsIgnoreCase("VerifySearchForAllergy")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										searchType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Search Type")));
										allergen = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
										allergen1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen1")));
										allergenCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergenCA")));
										allergen1Ca = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen1CA")));
										timeCondition = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Time Condition")));
										timeCondition1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Time Condition1")));
										timeCondition2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Time Condition2")));
										periodNumber = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period Number")));
										periodCondition = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period Condition")));
										date = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date")));
										reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
										currentValue = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CurrentPossition")));
										break;
									}else if(workSheetName.equalsIgnoreCase("verifySearchWithAllCombination")){
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
										allergenCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergenCA")));
										timeCondition2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition2")));
										labResult = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabResult")));
										durationCondition2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DurationCondition2")));
										year2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Year1")));
										timeCondition3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition3")));
										medical= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical")));
										medicalCondition = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicalCondition")));
										medicalConditionCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicalConditionCA")));
										timeCondition4 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition4")));
										firstSortBy= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstSortBy")));
										break;
									}
									else if(workSheetName.equalsIgnoreCase("verifySearchWithCombination")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										sex = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
										sex1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex1")));
										searchType1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType1")));
										searchType2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType2")));
										searchType3 =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType3")));
										durationCondition1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DurationCondition1")));
										year1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Year1")));
										searchType4 =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchType4")));
										durationCondition2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DurationCondition2")));
										year2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Year2")));
										break;
									}
									else if(workSheetName.equalsIgnoreCase("SearchLabReport")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										searchField = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchFields")));
										accessionNumber = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccessionNumber")));
										provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
										provider1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider1")));
										lab = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Lab")));
										labCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabCA")));
										date = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date")));
										test = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Test")));
										test1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Test1")));
										time = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Time")));
										labResult = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabResult")));
										result = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Result")));
										result1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Result1")));
										duration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
										duration1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration1")));
										timeCondition = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition")));
										timeCondition1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeCondition1")));
										periodNumber = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PeriodNumber")));
										period = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period")));
										currentValue = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CurrentPossition")));
										break;
									}else if(workSheetName.equalsIgnoreCase("VerifySecurityOption")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
										break;
									}else if(workSheetName.equalsIgnoreCase("NewpatientInfo")){
										primaryLocation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrimaryLocation")));	
	                                    responsibleProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResponsibleProvider")));
	                                    lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
	                                    firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
	                                    dob=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOB")));		
										sex=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
	                                    telephoneType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneNoType1")));
										telephoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelNum1")));
										telephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNum1")));
										break;
									}else if(workSheetName.equalsIgnoreCase("ClinicalQualityMeasures")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
	                                    description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));		
	                                    provider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
										break;
									}else if(workSheetName.equalsIgnoreCase("CQM")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
										lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
										status=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
										sex = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
										dob=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOB")));
										type = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Type")));
										item=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Item")));
										date=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date")));
										fromDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FromDate")));
										checkBox=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CheckBox")));
										provider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
										note=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Note")));
										role=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
										description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));	
										break;
									}else if(workSheetName.equalsIgnoreCase("ManageCareAlerts")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										
										firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
										lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
										deleteReason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DeleteReason")));
										patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
									    recurringPeriod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecurringPeriod")));
										recurringUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecurringUnit")));
										reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
										editDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EditDate")));
										role = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
										break;
									} else if(workSheetName.equalsIgnoreCase("ReconciliationList")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										
										firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
										lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
										deleteReason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DeleteReason")));
										patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
									    recurringPeriod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecurringPeriod")));
										recurringUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecurringUnit")));
										reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
										editDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EditDate")));
										role = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
										break;
									}else if(workSheetName.equalsIgnoreCase("CreateMedReconcilationList")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
										lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
										deleteReason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DeleteReason")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
									    recurringPeriod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecurringPeriod")));
										recurringUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecurringUnit")));
										reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
										editDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EditDate")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
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

