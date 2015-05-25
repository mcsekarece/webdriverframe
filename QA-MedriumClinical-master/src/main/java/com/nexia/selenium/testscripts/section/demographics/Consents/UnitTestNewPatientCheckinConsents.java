package com.nexia.selenium.testscripts.section.demographics.Consents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.thoughtworks.selenium.Selenium;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;

public class UnitTestNewPatientCheckinConsents extends AbstractHomeTest{
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Consent description is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void consentTypeBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_001";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Signed date is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void consentNameBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_002";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dateSignedBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_003";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Last Name is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void reasonForInactivationBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_004";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Relationship is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dateSignedGreaterValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_005";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Reason for inactivation is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dateSignedInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_006";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Consent description is alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void firstNameBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_007";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Signed date is greater than present date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void firstNameInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_008";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Signed date is invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void lastNameBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_009";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First name is alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void lastNameInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_010";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Last name is alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void relationshipBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_011";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Last name is alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dateSignedFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_012";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Last name is alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void firstNameMaxCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_013";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Last name is alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void lastNameMaxCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_014";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To deleting consents
	* @action 		  Verifying delete consents
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      May 02, 2012
	***************************************************************************************************/
	public void addConsents(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest consentData) throws IOException{
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, consentData.userName, consentData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,consentData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium, consentData.patientID);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Consents and deleting existing Consents       //
			//--------------------------------------------------------------------//
			
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-4: Create a new Consent                                      //
			//--------------------------------------------------------------------//
			
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentData.toString(), selenium, ClassName, MethodName);
			assertTrue(submitConsent(selenium,consentData),"Patient Consents failed", selenium, ClassName, MethodName);
			consentData.validationFieldID = consentData.validationFieldID == null ? consentData.validationFieldID = "" : consentData.validationFieldID.trim();
			if(!consentData.validationFieldID.equals("")){
			assertTrue(isElementPresent(selenium, consentData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, consentData.validationFieldID).contains(consentData.alertMessage), "The expected validation message should contain the text - "+ consentData.alertMessage + " The actual validation message shown - " + getText(selenium, consentData.validationFieldID), selenium, ClassName, MethodName);
			
			}
			
		}catch (RuntimeException e) {
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
	
 }