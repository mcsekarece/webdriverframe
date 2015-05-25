package com.nexia.selenium.testscripts.section.demographics.Consents;
import org.testng.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteConsent extends AbstractHomeTest{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for delete consents")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib deleteconsentData = new HomeLib();
		deleteconsentData.workSheetName = "NewConsent";
		deleteconsentData.testCaseId = "TC_NC_003";
		deleteconsentData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteConsent(seleniumHost, seleniumPort, browser, webSite, userAccount, deleteconsentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To deleting consents
	* @action 		  Verifying delete consents
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
	public boolean deleteConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws Exception{
		
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
			assertTrue(click(selenium,lnkQuickActions),"Could not click on quick actions:" + consentData .toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSecuritysetting),"Could not click the security settings link;More Details:"+consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			HomeLib ssConsentsData = new  HomeLib();
			ssConsentsData.workSheetName = "SSConsents";
			ssConsentsData.testCaseId = "TC_SSC_001";
			ssConsentsData.fetchHomeTestData();
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkConsents),"Could not click the Admin consent; More details"+ssConsentsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddConsents),"Could not click the add consent; More details"+ssConsentsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createSSConsents(selenium,ssConsentsData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Consents and deleting existing Consents       //
			//--------------------------------------------------------------------//
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,consentData.patientID);
			waitForPageLoad(selenium);
			
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-5: Create a new Consent                                      //
			//--------------------------------------------------------------------//
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentData.toString(), selenium, ClassName, MethodName);
			assertTrue(createConsent(selenium,consentData),"Consent creation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verifying deletion of a consent                           //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}	
}
