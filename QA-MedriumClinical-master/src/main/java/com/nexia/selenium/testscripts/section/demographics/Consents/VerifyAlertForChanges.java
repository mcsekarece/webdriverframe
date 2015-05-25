package com.nexia.selenium.testscripts.section.demographics.Consents;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.thoughtworks.selenium.Selenium;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;

public class VerifyAlertForChanges extends AbstractHomeTest{
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "verify alert for the changes")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void defaultStatusValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLib consentTestData = new  HomeLib();
		consentTestData.workSheetName = "NewConsentCAView";
		consentTestData.testCaseId = "TC_NCCA_003";
		consentTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		changeInfo(seleniumHost, seleniumPort, browser, webSite, userAccount, consentTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify alert changes
	* @action 		  Verifying alert changes
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      June 26, 2012
	***************************************************************************************************/
	public boolean changeInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws IOException{

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
			
			searchPatientNexiaCA(selenium,consentData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Consents                                      //
			//--------------------------------------------------------------------//
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-4: Create a new Consent                                      //
			//--------------------------------------------------------------------//
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentData.toString(), selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//Step-5: Verify Alert For the Changes
			//--------------------------------------------------------------------//
			verifyAlertForConsents(selenium,consentData);
		
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
}