package com.nexia.selenium.testscripts.section.demographics.Consents;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class CreateNewConsent extends AbstractHomeTest{

	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewConsentSignedByPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ConsentData = new HomeLib();
		ConsentData.workSheetName = "NewConsent";
		ConsentData.testCaseId = "TC_NC_001";
		ConsentData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewConsent(seleniumHost, seleniumPort, browser, webSite, userAccount, ConsentData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewConsentSignedBySubstitutionDecisionMaker(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ConsentData = new HomeLib();
		ConsentData.workSheetName = "NewConsent";
		ConsentData.testCaseId = "TC_NC_002";
		ConsentData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewConsent(seleniumHost, seleniumPort, browser, webSite, userAccount, ConsentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Creating new consents
	* @action 		  Creating new consents
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
	
	public boolean createNewConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
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
			
		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to security setting and create consents       //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickLink),"Could not click on quick action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"securitySettingsAction"),"Could not click the System settings link;More Details:"+consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			HomeLib ssConsentsData = new  HomeLib();
			ssConsentsData.workSheetName = "SSConsents";
			ssConsentsData.testCaseId = "TC_SSC_001";
			ssConsentsData.fetchHomeTestData();
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkConsents),"Could not click the Admin consent; More details"+ssConsentsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddConsents),"Could not click the Admin consent; More details"+ssConsentsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createSSConsents(selenium,ssConsentsData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Consents and deleting existing Consents       //
			//--------------------------------------------------------------------//
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,consentData.patientID);
			waitForPageLoad(selenium);
			
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			if(consentData.testCaseId.equalsIgnoreCase("TC_NC_002")){
				consentData.workSheetName = "NewConsent";
				consentData.testCaseId = "TC_NC_002";
				consentData.fetchHomeTestData();
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Create a new Consent                                        //
			//--------------------------------------------------------------------//
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createConsent(selenium,consentData),"Consents creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkEditConsents);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verifying Entered Details are saved properly              //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForConsents(selenium,consentData)){
				Assert.fail("Consents details not saved properly; More Details :"+ consentData.toString());
				returnValue=false;
			}else
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}	
	
}



