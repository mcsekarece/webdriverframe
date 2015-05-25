package com.nexia.selenium.testscripts.section.demographics.Consents;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class CreateNewConsentsForCAView extends AbstractHomeTest{
	
	@Test(groups = {"AdvancedSmokeCA","RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding New Consent to a patient")	
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewConsentSignedBySubstitutionDecisionMaker(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib consentCAData = new HomeLib();
		consentCAData.workSheetName = "NewConsentCAView";
		consentCAData.testCaseId = "TC_NCCA_001";
		consentCAData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewConsentForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentCAData);
	}
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding New Consent to a patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewConsentEnded(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib consentCAData = new HomeLib();
		consentCAData.workSheetName = "NewConsentCAView";
		consentCAData.testCaseId = "TC_NCCA_002";
		consentCAData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewConsentForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentCAData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Creating new consents
	* @action 		  Creating new consents
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      June 25, 2012
	***************************************************************************************************/
	public boolean createNewConsentForCAView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws Exception{
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
			
			searchPatientNexiaCA(selenium,consentData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Consents and deleting existing Consents       //
			//--------------------------------------------------------------------//
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-4: Create a new Consent                                        //
			//--------------------------------------------------------------------//
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentData.toString(), selenium, ClassName, MethodName);
			assertTrue(createConsentsCAView(selenium,consentData),"Consents creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium); 
			click (selenium,lnkEditConsents);
			waitForPageLoad(selenium); 
			assertTrue(verifyStoredValuesCA(selenium,consentData),"Consents details not saved properly; More Details :"+ consentData.toString(), selenium, ClassName, MethodName);
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
