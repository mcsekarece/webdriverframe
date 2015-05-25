package com.nexia.selenium.genericlibrary.taskManagement;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;

public class TaskManagementLib {

	public String testCaseId = null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String switchRole=null;
	public String patientID = null;

	
	
	public String dueDateFormat = null;
	public String notifyFormat = null;
	public String assignTo = null;
	public String intervalperiod = null;
	public String endAfterOccurences = null;
	public String assignToUser = null;
	public String assignToPassword = null;
	public String recurringEndDate = null;
	public String recurringDailyDate = null;
	public String anotherPractice = null;
	public String anotherUserOrUserRole = null;
	public String onBehalfOf = null;
	public String taskType = null;
	public String taskName = null;
	public String instructions = null;
	public String dueIn=null;
	public String dueDateUnit = null;
	public String notifyMe = null;
	public String notifyUnit = null;
	public String otherPractice = null;
	public String reason = null;
	
	public String workSheetName = null;
	public String workBookName = "TestData_TaskManagement.xls";		
	public String sectionName = "taskmanagement";
		
	public String reference=null;
	public String bookMark=null;
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

	 * @since  	    Sep 03, 2013	  
	 */
    
	public boolean fetchTaskManagementTestData(){
		
		ReadFromExcel readTestData = new ReadFromExcel();
		boolean isDataFound = false;
		testCaseId = testCaseId != null ? testCaseId.trim() : "";
		try{
			  //******************************************************************//
			  //Fetching the test data for New Nexia Interface
			  //******************************************************************//

			HSSFSheet sheet = null;
			// function call to initiate a connection to an excel sheet
			sheet = readTestData.initiateExcelConnectionNexia(workSheetName,sectionName,workBookName);

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
					for(int c = 0; c < excelrRowColumnCount.get("ColumnCount"); c++) {						
						cell = row.getCell(excelHeaders.get("TestID"));
						if(cell != null){
							temptestCaseId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestID")));
							if(temptestCaseId.equals(testCaseId)){
								isDataFound = true;
								if(workSheetName.equalsIgnoreCase("CreateGeneralTask")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    switchRole =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    taskName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaskName")));
                                    instructions=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Instructions")));
                                    dueIn=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DueIn")));
                                    dueDateUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DueDateUnit")));
                                    notifyMe=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotifyMe")));
                                    notifyUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotifyUnit")));
                                    assignTo =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignTo")));
                                    recurringDailyDate =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecurringDailyDate")));
                                    endAfterOccurences =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndAfterOccurences")));
                                    otherPractice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OtherPractice")));
                                    assignToUser =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignToUser")));
                                    assignToPassword =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignToPassword")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("createPatientTask")){
									
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    switchRole =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    taskType =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaskType")));
                                    taskName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaskName")));
                                    instructions=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Instructions")));
                                    dueIn=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DueIn")));
                                    dueDateUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DueDateUnit")));
                                    notifyMe=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotifyMe")));
                                    notifyUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotifyUnit")));
                                    assignTo =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignTo")));
                                    endAfterOccurences =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndAfterOccurences")));
                                    intervalperiod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Intervalperiod")));
                                    anotherPractice = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AnotherPractice")));
                                    anotherUserOrUserRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AnotherUser/UserRole")));
                                    reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
                                    assignToUser =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignToUser")));
                                    assignToPassword =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignToPassword")));
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
			e.printStackTrace();
			Assert.fail("Error During Execution; Execution Failed More details " + e);
		}
		return isDataFound;
	}

	/**
	 * checkAlertMessage
	 * function for checking the alert message with the expected one  

	 * @since  	     Aug 28, 2013	  
	 */
	
	public boolean checkAlertMessage(String alertText, String actualText){
		
		if(alertText == null || actualText.equals("") ){
			return false;
		}
		alertText = alertText.replaceAll("\\s","");
		actualText = actualText.replaceAll("\\s", "");
		
		if(alertText.toLowerCase(new java.util.Locale("en", "US")).contains(actualText.toLowerCase(new java.util.Locale("en", "US")))){
			return true;
		}else {
			return false;
		}
	}	
}
