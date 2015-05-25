package com.nexia.selenium.testscripts.section.portability;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class PortICDCode extends AbstractHomeTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the default Code set")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultICDCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ConsentData = new HomeLib();
		ConsentData.workSheetName = "NewConsent";
		ConsentData.testCaseId = "TC_NC_001";
		ConsentData.fetchHomeTestData();
		verifyDefaultICDCodes(seleniumHost, seleniumPort, browser, webSite, userAccount, ConsentData);
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	}
	
	/**
	 * verifyDefaultICDCodes
	 * function to verify the default Code set
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Apr 20, 2015
	 */

	public boolean verifyDefaultICDCodes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws Exception{
		Selenium selenium = null;
		try{

			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, consentData.userName, consentData.userPassword),"Login Failed",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,consentData.switchRole),"Could not change swith role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Practice Preferences						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSettings),"Could not click on the Settings link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalSettings),"Could not click on the Clinical Settings link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPracticePreference),"Could not click on the Practice Preference link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Set the default Code set								  //
			//--------------------------------------------------------------------//
			if(!getText(selenium,lblCode).contains("ICD(ONT)"))
			{
				assertTrue(click(selenium,btnEditPracticePreferences),"Could not click on the Edit button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,rdoICD),"Could not click on the radio button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSaveCode),"Could not click on the radio button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());
		}
		return true;
	}	


}
