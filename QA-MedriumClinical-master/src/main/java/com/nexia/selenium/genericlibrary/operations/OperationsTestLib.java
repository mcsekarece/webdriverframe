package com.nexia.selenium.genericlibrary.operations;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;

public class OperationsTestLib {

	
	public String testCaseId = null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	
	public String switchRole=null;
	public String templateName=null;
	public String validationFieldID= null;
	public String validationMessage = null;
	public String visitType = null;
	public String startDate = null;
	public String endDate = null;
	public String duration = null;
	public String showTime = null;
	public String resource  = null;
	public String searchResource = null;
	public String searchResource1 = null;
	public String resource1  = null;
	public String resourceName  = null;
	public String resourceName1  = null;
	public String patientName  = null;
	public String location  = null;
	public String startDateCA = null;
	public String endDateCA = null;
	public String reason = null;
	public String comment = null;
	public String cycle  = null;
	public String patternStartsDate=null;
	public String patternStartsMonth=null;	
	public String startMin=null;
	public String endMin=null;
	
	//wait list management
	public String patientID = null;
	public String callBackNum = null;
	public String priority =null;
	public String concerning=null;
	
	public String workSheetName = null;
	public String workBookName = "TestData_Operations.xls";		
	public String sectionName = "operations";
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
		
	public boolean fetchSchedulingSettingsTestData(){
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
									if(workSheetName.equalsIgnoreCase("SearchBookingAssistant")){
									
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    visitType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType")));
                                    duration= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
                                    resource= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resource")));
                                    searchResource= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchResource")));
                                    searchResource1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchResource1")));
                                    resource1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resource1")));
                                    resourceName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResourceName")));
                                    resourceName1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResourceName1")));
                                    location= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
                                    patientName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
                                    reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
                                    comment = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                    cycle = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cycle")));
                                    callBackNum=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CallBackNum")));
                                    
									break;   
								}else if(workSheetName.equalsIgnoreCase("VerifySecurityOption")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									break;
								}else if(workSheetName.equalsIgnoreCase("VerifyCheckInAssistant")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    visitType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType")));
                                    resource= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resource")));
                                    resource1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resource1")));
                                    resourceName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResourceName")));
                                    location= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
                                    patientName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
                                    reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
                                    comment = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                    cycle = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cycle")));
	                                patternStartsDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatternDate")));
									patternStartsMonth = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatternMonth")));
									startMin = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartMin")));
									endMin = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndMin")));
									break;   
								}else if(workSheetName.equalsIgnoreCase("CreateGeneralTask")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("VerifyWaitList")){
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
                                    callBackNum=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CallBackNum")));
                                    priority=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Priority")));
                                    visitType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType")));
                                    resource=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resource")));
                                    location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
                                    duration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
                                    reason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
                                    comment=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                    concerning=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Concerning")));
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

