package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditConsentsInUnifinishedItemForUsView extends AbstractHomeTest{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void EditConsentsInUnFinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ConsentData = new HomeLib();
		ConsentData.workSheetName = "NewConsent";
		ConsentData.testCaseId = "TC_NC_006";
		ConsentData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		updateNewConsent(seleniumHost, seleniumPort, browser, webSite, userAccount, ConsentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Creating new consents
	* @action 		  Creating new consents
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
	
	public boolean updateNewConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		String currentUnfinishedItem="Edit Consents for";
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
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to System setting create Enter pries variable    //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickActions),"Could not click on quick actions:" + consentData .toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkShowMoreLink),"Could not click show more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingAction),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			HomeLib epData = new  HomeLib();
			epData.workSheetName = "ConsentsEnterPrise";
			epData.testCaseId = "TC_CEP_001";
			epData.fetchHomeTestData();
			
			assertTrue(createEnterPriseForConsents(selenium,epData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to security setting and create consents       //
			//--------------------------------------------------------------------//
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click on quick action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSecuritysetting),"Could not click the System settings link;More Details:"+consentData.toString(), selenium, ClassName, MethodName);
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
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,consentData.patientID);
			waitForPageLoad(selenium);
			
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-6: Create a new Consent                                        //
			//--------------------------------------------------------------------//
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createConsent(selenium,consentData),"Consents creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verifying Entered Details are saved properly              //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForSummaryPageAddConsentsInUS(selenium,consentData)){
				Assert.fail("Consents details not saved properly; More Details :"+ consentData.toString());
				returnValue=false;
			}
			//--------------------------------------------------------------------//
			//  Step-8: Edit Consent							  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkEditConsents),"Could not click the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			HomeLib ConsentsData = new HomeLib();
			ConsentsData.workSheetName = "NewConsent";
			ConsentsData.testCaseId = "TC_NC_005";
			ConsentsData.fetchHomeTestData();
			
			assertTrue(createConsent(selenium,ConsentsData),"Consents creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			assertTrue(storeDataInUnfinishedItem(selenium),"Could not Store data in unfinished item; More Details :"+ consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Navigate to unfinished item							  //
			//--------------------------------------------------------------------//
			//get the current patient name
			String patientName[]= getText(selenium, lblPatientName).split(",");
			
			//customize the patient name for our need
			String patientNameAltered= patientName[1] +" "+ patientName[0];
			
			//append the patient name with the current unfinished item section
			currentUnfinishedItem= currentUnfinishedItem + patientNameAltered ;
			
			assertTrue(navigateToUnfinishedItem(selenium,currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-11: Verifying Entered Details are saved properly              //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForConsents(selenium,ConsentsData)){
				Assert.fail("Consents details not saved properly; More Details :"+ consentData.toString());
				returnValue=false;
			}
			
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			//----------------------------------------------------------------------------//
			//  Step-12: Verifying Completed unfinished item Details are saved properly//
			//----------------------------------------------------------------------------//
			if(!verifyStoredValuesForSummaryPageAddConsentsInUS(selenium,ConsentsData)){
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
