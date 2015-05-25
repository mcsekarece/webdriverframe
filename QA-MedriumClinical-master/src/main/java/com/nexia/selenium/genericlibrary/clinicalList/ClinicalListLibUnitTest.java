package com.nexia.selenium.genericlibrary.clinicalList;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;

public class ClinicalListLibUnitTest {
	public String testCaseId = null;
	public String  searchType = null;
	public String  durationCondition= null;
	public String  timeCondition= null;
	public String  periodNumber= null;
	public String  period= null;
	public String  sex= null;
	public String  allergen= null;
	public String  diagnosis= null;
	public String  medication= null;
	public String  date= null;
	public String  minYear= null;
	public String  maxYear= null;
	public String  count= null;
	public String  labResult= null;
	public String  validationFieldID= null;
	public String  validationMessage = null;
	public String  test= null;
	public String  maxLength = null;
	 
	public String provider = null;
	public String fromDate = null;
	public String toDate = null;

	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String taskName = null;
	public String assignTaskUnit = null;
	public String assignTaskDate = null;
	public String assignTo = null;
	
	public String role = null;
	
	
	
	
	
	public String workSheetName = null;
	public String workBookName = "TestData_UnitTest_ClinicalList.xls";		
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
								if(workSheetName.equalsIgnoreCase("UnitTest_MatchAll")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    searchType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Search Type")));
                                    durationCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration Condition")));
                                    minYear= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Min Year")));
                                    maxYear= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Max Year")));
                                    count= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Count")));
                                    sex= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex Condition")));
                                    diagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Problem List")));
                                    allergen= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
                                    timeCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Time Condition")));
                                    periodNumber= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period Number")));
                                    period= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period")));
                                    date= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date")));
                                    labResult= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Lab Result")));
                                    medication= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medication")));
                                    validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
                                    test= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Test")));
                                    maxLength= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxLength")));
                                    break;   
								}
								if(workSheetName.equalsIgnoreCase("UnitTest_MatchOneOrMore")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    searchType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Search Type")));
                                    durationCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration Condition")));
                                    minYear= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Min Year")));
                                    maxYear= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Max Year")));
                                    count= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Count")));
                                    sex= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex Condition")));
                                    diagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Problem List")));
                                    allergen= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
                                    timeCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Time Condition")));
                                    periodNumber= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period Number")));
                                    period= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period")));
                                    date= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date")));
                                    labResult= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Lab Result")));
                                    medication= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medication")));
                                    validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
                                    break;   
								}
								if(workSheetName.equalsIgnoreCase("UnitTest_DoNotInclude")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    searchType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Search Type")));
                                    durationCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration Condition")));
                                    minYear= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Min Year")));
                                    maxYear= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Max Year")));
                                    count= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Count")));
                                    sex= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex Condition")));
                                    diagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Problem List")));
                                    allergen= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
                                    timeCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Time Condition")));
                                    periodNumber= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period Number")));
                                    period= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period")));
                                    date= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date")));
                                    labResult= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Lab Result")));
                                    medication= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medication")));
                                    validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
                                    break;   
								}
								if(workSheetName.equalsIgnoreCase("UnitTest_CQM")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
                                    fromDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FromDate")));
                                    toDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToDate")));
                                    validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
                                    break;   
								}
								if(workSheetName.equalsIgnoreCase("UnitTest_AutomatedRecall")){
								    userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                        		    taskName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaskName")));
									assignTaskUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignTaskUnit")));
									assignTaskDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignTaskDate")));
									assignTo = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignTo")));
									validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
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
