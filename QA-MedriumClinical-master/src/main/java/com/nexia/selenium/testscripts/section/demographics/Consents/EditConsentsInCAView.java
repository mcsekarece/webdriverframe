package com.nexia.selenium.testscripts.section.demographics.Consents;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class EditConsentsInCAView extends AbstractHomeTest{

	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a consent")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib consentCAData = new HomeLib();
		consentCAData.workSheetName = "NewConsentCAView";
		consentCAData.testCaseId = "TC_NCCA_005";
		consentCAData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentCAData);
	}

	/*************************************************************************************************** 
	* @purpose        To Editing consents
	* @action 		  Verifying edit consents
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
	public boolean editConsents(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws Exception{
		boolean returnValue=true;
		Selenium selenium=null;
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
			searchPatientNexiaCA(selenium, consentData.patientID);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Consents and deleting existing Consents       //
			//--------------------------------------------------------------------//
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-4: Create a new Consent                                      //
			//--------------------------------------------------------------------//
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentData.toString(), selenium, ClassName, MethodName);
			assertTrue(createConsentsCAView(selenium,consentData),"Consents creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium); 
			click (selenium,lnkEditConsents);
			waitForPageLoad(selenium); 
			assertTrue(verifyStoredValuesCA(selenium,consentData),"Consents details not saved properly; More Details :"+ consentData.toString(), selenium, ClassName, MethodName);
			 returnValue=true;
			
			consentData.workSheetName = "EditConsentCAView";
			consentData.testCaseId = "TC_NCCA_001";
			consentData.fetchHomeTestData();
			waitForPageLoad(selenium);
			assertTrue(editConsentsCAView(selenium,consentData),"Could not edit the consents data" , selenium, ClassName, MethodName);
			click (selenium,lnkEditConsents);
			waitForPageLoad(selenium); 
			assertTrue(verifyStoredValuesEditConsents(selenium,consentData),"Consents details not saved properly; More Details :"+ consentData.toString(),selenium, ClassName, MethodName);
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}


