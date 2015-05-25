package com.nexia.selenium.genericlibrary.billing;

import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;

/**
 * @class BillingUnitTestLib
 * This Class will contain reusable functions which can be used in Nexia Interface
 * @category Billing
 * @since Jan 04, 2014
 */

public class BillingUnitTestLib {
    
	public String workSheetName = null;
	public String testCaseId = null;
	public String userName = null;
	public String userPassword = null;
	public String switchRole = null;
	public String description=null;
	public String c_DAdjusment=null;
	public String reportCategory=null;
	public String adjusmentReason=null;
	
	//Admin Super Bill
	public String templateName = null;
	public String specialty = null;
	public String sectionLabel = null;
	
	public String serviceCode = null;
	public String description1 = null;
	public String modifiers = null;
	public String modifiers1 = null;
	public String elementId = null;
	
	
	
	//public String userPassword = null;
	
	
	//Fee Schedule
	
	public String payer = null;
	public String plan = null;
	public String practice = null;
	public String location = null;
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
	public String amountType = null;
	public String existingPayer = null;
	public String alert = null;
	public String alertMessage = null;
	
	
	//Service Code
	public String customServiceCode= null;
	public String customServiceDescription= null;
	public String fees = null;
	public String units = null;
	public String effectiveOnDate = null;
	public String drugCode = null;
	public String serviceCodeModifier = null;
	public String totalRVU = null;
	public String typeOfService = null;
	public String workRVU = null;
	public String globalPeriod = null;
	public String reportGroup = null;
	public String providerSpeciality = null;
	public String instructionToBiller = null;
	
	public Hashtable<String, Integer> excelHeaders = new Hashtable<String, Integer>();
	public Hashtable<String, Integer> excelrRowColumnCount = new Hashtable<String, Integer>();
	
	public String workBookName = "TestData_UnitTest_Billing.xls";		
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
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("UnitTest_FeeSchedule")){
							    	userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									payer= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Payer")));
									plan=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Plan")));
									practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
									location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Locations")));
									speciality=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Speciality")));
									provider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									modifier=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Modifier")));
									searchServiceCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchServiceCode")));
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
									amountType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AmountType")));
									existingPayer=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExistingPayer")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
								break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_ServiceCode")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									customServiceCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CustomServiceCode")));
									customServiceDescription = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CustomServiceDescription")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SetServiceDefault")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									customServiceCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CustomServiceCode")));
									customServiceDescription = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CustomServiceDescription")));
									fees = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fees")));
									units = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Units")));
									effectiveOnDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EffectiveOnDate")));
									drugCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DrugCode")));
									serviceCodeModifier = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCodeModifier")));
									totalRVU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TotalRVU")));
									typeOfService = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TypeOfService")));
									workRVU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WorkRVU")));
									globalPeriod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GlobalPeriod")));
									reportGroup = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportGroup")));
									providerSpeciality = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderSpeciality")));
									instructionToBiller = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InstructionToBiller")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_AdminSuperBill")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									templateName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateName")));
									specialty = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Specialty")));
									sectionLabel = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sectionlabel")));
									serviceCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ServiceCode")));
									description = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									modifiers = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Modifiers")));
									modifiers1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Modifiers1")));
									elementId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ElementId")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
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
