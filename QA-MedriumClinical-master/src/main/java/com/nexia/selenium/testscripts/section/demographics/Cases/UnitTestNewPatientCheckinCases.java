package com.nexia.selenium.testscripts.section.demographics.Cases;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Calendar;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestNewPatientCheckinCases extends AbstractHomeTest{
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Program With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void programWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_001";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Start date With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void startDateWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_002";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Case Status With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void caseStatusWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_003";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date Type with Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dateTypeWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_004";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date with Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void datewithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_005";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Description with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void descriptionWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_006";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Reason with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void reasonWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_007";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Start date With Future date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void startDateWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_008";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Discharge date with future date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dischargeDateWithfutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_009";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Discharge date with Invalid date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dischargeDateWithInvalidDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_010";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Dispostion with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dispostionWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_011";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Termination date with future date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void terminationDateWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_012";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Termination date with invalid date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void terminationDateWithInvalidDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_013";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Termination Status with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void terminationStatusWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_014";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dateWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_015";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Cases With Referral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void casesWithReferral(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_016";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Cases With Referral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws InterruptedException, IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_017";
		caseData.fetchHomeTestData();
		verifyDefaultValuesForCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Cases With Referral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUniqueDateType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws InterruptedException, IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_018";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Case Status By Changing Back To Ongoing")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCaseStatusByChangingBackToOngoing(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws InterruptedException, IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Info_Cases";
		caseData.testCaseId = "TC_UC_019";
		caseData.fetchHomeTestData();
		addCases(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
		
	}
	
	/*************************************************************************************************** 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      Feb 09, 2012
	***************************************************************************************************/
	
	public boolean addCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLibUnitTest casesData) throws IOException{
		
		Selenium selenium = null;	
		boolean returnValue = true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + casesData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, casesData.userName, casesData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,casesData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,casesData.patientID);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Cases and deleting existing Cases             //
			//--------------------------------------------------------------------//
			assertTrue(goToCases(selenium), "Could not navigate to Cases Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllCases(selenium), "Could not delete cases", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Unit Test new case                                        //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ casesData.toString(), selenium, ClassName, MethodName);
			assertTrue(addCase(selenium,casesData),"Patient Cases failed", selenium, ClassName, MethodName);
			casesData.validationFieldID = casesData.validationFieldID == null ? casesData.validationFieldID = "" : casesData.validationFieldID.trim();
			if(!casesData.validationFieldID.equals("")){
			assertTrue(isElementPresent(selenium, casesData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, casesData.validationFieldID).contains(casesData.alertMessage), "The expected validation message should contain the text - "+ casesData.alertMessage + " The actual validation message shown - " + getText(selenium, casesData.validationFieldID), selenium, ClassName, MethodName);
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 * 
	 * @param selenium
	 * @param caseData
	 * @return
	 * @throws IOException 
	 */
	
	public boolean addCase(Selenium selenium, HomeLibUnitTest caseData ) throws IOException {
		try{
			assertTrue(type(selenium,txtDescription,caseData.description),"Could not enter Description ; More Details :"+caseData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxListUsingTypeKeys(selenium,ajkProgram, caseData.program);
			
			assertTrue(type(selenium,txtReason,caseData.reason),"Could not enter Reason ; More Details :"+caseData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,lstReferral,caseData.referral);
			assertTrue(enterDate(selenium,txtStartDate,caseData.startdate),"Could not enter the date; More Details :" + caseData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajkCaseStatus, caseData.caseStatus); 
			click(selenium,ajkValueSelect1);
			waitForPageLoad(selenium);
			
			if(caseData.caseStatus.trim().equalsIgnoreCase("Discharged")){
				assertTrue(enterDate(selenium,txtDischargeDate,caseData.dischargeDate),"Could not enter discharge date; More Details :" + caseData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtDisPosition,caseData.disposition),"Could not enter disposition ; More Details :"+caseData.toString(), selenium, ClassName, MethodName);
			}
			
			if(caseData.caseStatus.trim().equalsIgnoreCase("Terminated")){
				click(selenium,ajkValueSelect1);
				assertTrue(enterDate(selenium,txtTerminationDate,caseData.terDate),"Could not enter discharge date; More Details :" + caseData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtTerminationDateReason,caseData.terStatus),"Could not enter disposition ; More Details :"+caseData.toString(), selenium, ClassName, MethodName);
			}
			
			click(selenium,btnAddCaseDates);
			
			if (isElementPresent(selenium, txtDateType)){
				selectValueFromAjaxList(selenium,txtDateType, caseData.datetype1);
				click(selenium,ajkValueSelect1);
				assertTrue(enterDate(selenium,txtDate,caseData.date1),"Could not enter the date; More Details :" + caseData.toString(), selenium, ClassName, MethodName);
			}
			
			if(!caseData.datetype2.trim().equalsIgnoreCase("")){
				click(selenium,btnAddCaseDates);
				selectValueFromAjaxList(selenium,txtDateType1, caseData.datetype2);
				assertTrue(enterDate(selenium,txtDate1,caseData.date2),"Could not enter the date; More Details :" + caseData.toString(), selenium, ClassName, MethodName);		
			}
			
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + caseData.toString(), selenium, ClassName, MethodName);
			if(caseData.testCaseId.equals("TC_UC_019")){
				while(click(selenium,lnkEdit)){
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,ajkCaseStatus, caseData.caseStatus1);
					click(selenium,ajkValueSelect1);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + caseData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					break;
				}
			}
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	
	 /**
	 * verifyDefaultValuesForCases
	 * function to verify Default Values For Cases
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws		: InterruptedException 
	 * @since  	     Feb 09, 2012
	 */  
	
	public boolean verifyDefaultValuesForCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLibUnitTest caseData) throws InterruptedException, IOException{
		Selenium selenium = null;
		try{
			
			String dateNow=null;
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter=	new SimpleDateFormat("MM/dd/yyyy");
			dateNow = formatter.format(currentDate.getTime());
				
			//--------------------------------------------------------------------//
			// Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + caseData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, caseData.userName, caseData.userPassword);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,caseData.switchRole),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,caseData.patientID);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID //
			//--------------------------------------------------------------------// 
			waitForElement(selenium, txtNewPatientCheckin, 4000);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,caseData.patientID);
			waitForPageLoad(selenium);
					
			//--------------------------------------------------------------------//
			//  Step-4: Navigation to the next page and click on Cases Link //
			//--------------------------------------------------------------------// 
			click(selenium,lnkPatientCaseList);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddCase),"Could not Click on Add Cases Button:"+ caseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			assertTrue(getValue(selenium,txtStartDate).trim().equalsIgnoreCase(dateNow.trim()),"Start date not present", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,ajkCaseStatus).trim().equalsIgnoreCase(caseData.caseStatus.trim()),"Status not present", selenium, ClassName, MethodName);
				
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}


