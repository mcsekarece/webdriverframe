package com.nexia.selenium.genericlibrary.clinicalsettings;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;

public class ClinicalSettingUnitTest {

	//Encounter Template
	public String templateName=null;
	public String switchRole=null;
	
	public String testCaseId = null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String  validationFieldID= null;
	public String  validationMessage = null;
	
	public String provider = null;
	public String fromDate = null;
	public String toDate = null;
	
	
	public String workSheetName = null;
	public String workBookName = "TestData_UnitTest_ClinicalSettings.xls";		
	public String sectionName = "clinicalsettings";
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
		
	public boolean fetchClinicalSettingsTestData(){
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
								if(workSheetName.equalsIgnoreCase("UnitTest_MUMeasures")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
                                    fromDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("From Date")));
                                    toDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("To Date")));
                                    validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;   
								}
							}else if(workSheetName.equalsIgnoreCase("UnitTest_EncounterTemplate")){
								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
								userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
								userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
								switchRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
								templateName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateName")));
								validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
								break;
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
