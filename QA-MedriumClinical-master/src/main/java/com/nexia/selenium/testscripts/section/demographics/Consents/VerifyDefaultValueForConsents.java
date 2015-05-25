package com.nexia.selenium.testscripts.section.demographics.Consents;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValueForConsents extends AbstractHomeTest{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Default status Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void defaultStatusValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_017";
		consentTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		signedByPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Default Relationship value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void defaultRelationshipValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_018";
		consentTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		defaultConsentsValue(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Default first Name value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void defaultFirstNameValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_019";
		consentTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		defaultConsentsValue(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "default Last Name value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void defaultLastNameValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_020";
		consentTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		defaultConsentsValue(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Default Signed value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void defaultDateSignedValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentTestData = new  HomeLibUnitTest();
		consentTestData.workSheetName = "UnitTest_FV_PC_Consents";
		consentTestData.testCaseId = "TC_CI_021";
		consentTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		defaultDate(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify default values for consents
	* @action 		  Verifying default values for consents
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      June 26, 2012
	***************************************************************************************************/
	public boolean signedByPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest consentData) throws IOException{

		boolean returnValue=true;
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
			//  Step-3: Navigate to Consents                                      //
			//--------------------------------------------------------------------//
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-4: Create a new Consent                                      //
			//--------------------------------------------------------------------//
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentData.toString(), selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Default Values
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValuesSignedByPatient(selenium,consentData),"Default value is incorrect; More Details :"+ consentData.toString(), selenium, ClassName, MethodName);
				return returnValue;
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify default date values for consents
	* @action 		  Verifying default date values for consents
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      June 26, 2012
	***************************************************************************************************/
	public boolean defaultDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest consentTestData) throws IOException{
		boolean returnValue=true;
		Selenium selenium = null;
		
		try{
			//--------------------------------------------------------------------//	
			// Step-1: Login to the Application
			//--------------------------------------------------------------------//	
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);		
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentTestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, consentTestData.userName, consentTestData.userPassword);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,consentTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,consentTestData.patientID);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-4: Go to Consent
			//--------------------------------------------------------------------//	
			click(selenium, lnkConsentsPatient);
			waitForPageLoad(selenium);
			click(selenium,btnConsentsAdd);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Default Values
			//--------------------------------------------------------------------//							
			assertTrue(verifydateValue(selenium,consentTestData),"Default value is incorrect; More Details :", selenium, ClassName, MethodName);
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify default date values for consents
	* @action 		  Verifying default date values for consents
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      June 26, 2012
	***************************************************************************************************/
	public boolean defaultConsentsValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest consentTestData) throws IOException{

		boolean returnValue=true;
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//	
			//  Step-1: Login to the Application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);		
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentTestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, consentTestData.userName, consentTestData.userPassword);
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,consentTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,consentTestData.patientID);
			waitForPageLoad(selenium);
						
			HomeLib ContactData = new HomeLib();
			ContactData.workSheetName = "CreateNewContact";
			ContactData.testCaseId = "TC_CPC_001";
			ContactData.fetchHomeTestData();
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a Contact for the Patient
			//--------------------------------------------------------------------//
			click(selenium,lnkContactList);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllContact(selenium), "Could not delete consents", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddContact),"Could not Click on Add Contacts Contacts Button:"+ ContactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createContactWithMandatory(selenium,ContactData,userAccount),"Contact details not saved properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Go to Consent
			//--------------------------------------------------------------------//
			click(selenium, lnkConsentsPatient);
			waitForPageLoad(selenium);
			click(selenium,btnConsentsAdd);
			waitForPageLoad(selenium);
			
			click(selenium,rdoSubstitutionMark);		
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Default Values
			//--------------------------------------------------------------------//
			assertTrue(verifyOtherStoredValues(selenium,ContactData),"Default value is incorrect; More Details :", selenium, ClassName, MethodName);
		
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
