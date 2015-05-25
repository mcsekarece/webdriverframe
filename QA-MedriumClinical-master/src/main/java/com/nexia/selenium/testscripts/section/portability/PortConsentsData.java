package com.nexia.selenium.testscripts.section.portability;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class PortConsentsData extends AbstractHomeTest {
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewConsentSignedByPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ConsentData = new HomeLib();
		ConsentData.workSheetName = "NewConsent";
		ConsentData.testCaseId = "TC_NC_001";
		ConsentData.fetchHomeTestData();
		createNewConsent(seleniumHost, seleniumPort, browser, webSite, userAccount, ConsentData);
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	}
	
	/**
	 * createNewConsent
	 * function to create New Consent
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Apr 02, 2012
	 */
	
	public boolean createNewConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
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
			//  Step-3: Navigate to System setting create Enter pries variable    //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickActions),"Could not click on the quick action link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkShowMoreLink),"Could not click on the show more action link" ,selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingAction),"Could not click the systemSettings link;More Deatils:" ,selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			HomeLib epData = new  HomeLib();
			epData.workSheetName = "ConsentsEnterPrise";
			epData.testCaseId = "TC_CEP_001";
			epData.fetchHomeTestData();
			
			assertTrue(createEnterPriseForConsents(selenium,epData),"Could not create Enterprise for consents",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to security setting and create consents       //
			//--------------------------------------------------------------------//
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			 assertTrue(click(selenium,lnkQuickActions),"Could not click on the quick action link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkShowMoreLink),"Could not click on the quick action link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSecuritySetting),"Could not click the systemSettings link;More Deatils:", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
			HomeLib ssConsentsData = new  HomeLib();
			ssConsentsData.workSheetName = "SSConsents";
			ssConsentsData.testCaseId = "TC_SSC_001";
			ssConsentsData.fetchHomeTestData();
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkConsents),"Could not click the Admin consent; More details"+ssConsentsData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String ssConsentData = "Privacy and Consent to Treat - print(30 days) (Valid For 30 months)Practice";
			
			//String s1= getText(selenium,"//td[2]");
			
			if(getText(selenium,"ConsentTypeList").contains(ssConsentData)){
				return returnValue;
			}
			else{
				assertTrue(click(selenium,btnAddConsents),"Could not click the Admin consent; More details"+ssConsentsData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(createSSConsents(selenium,ssConsentsData),"Could not create SSconsents",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
		}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());
			}
			return returnValue;
		}	
}

