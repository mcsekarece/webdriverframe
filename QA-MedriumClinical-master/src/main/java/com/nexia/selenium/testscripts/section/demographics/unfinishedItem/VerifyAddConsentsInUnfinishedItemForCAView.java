package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddConsentsInUnfinishedItemForCAView extends AbstractHomeTest{
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewConsentInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib consentsCAData = new HomeLib();
		consentsCAData.workSheetName = "NewConsentCAView";
		consentsCAData.testCaseId = "TC_NCCA_006";
		consentsCAData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewConsentForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCAData);
	}

	/*************************************************************************************************** 
	* @purpose        To Creating new consentsFor Ca View 
	* @action 		  Creating new consents  Ca View 
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      July 11, 2012
	***************************************************************************************************/
	
	public boolean createNewConsentForCAView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentsCAData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		String currentUnfinishedItem="Add Consents for";
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentsCAData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, consentsCAData.userName, consentsCAData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,consentsCAData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ consentsCAData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Consents and deleting existing Consents       //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,consentsCAData.patientID);
			waitForPageLoad(selenium);
			
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a new Consent                                        //
			//--------------------------------------------------------------------//
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentsCAData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createConsentsCAView(selenium,consentsCAData),"Consents creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5 Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			assertTrue(storeDataInUnfinishedItem(selenium),"Could not Store data in unfinished item; More Details :"+ consentsCAData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to unfinished item							  //
			//--------------------------------------------------------------------//
			//get the current patient name
			String patientName[]= getText(selenium, lblPatientName).split(",");
			
			//customize the patient name for our need
			String patientNameAltered= patientName[1] +" "+ patientName[0];
			
			//append the patient name with the current unfinished item section
			currentUnfinishedItem= currentUnfinishedItem + patientNameAltered ;
			
			assertTrue(navigateToUnfinishedItem(selenium,currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ consentsCAData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verifying Entered Details are saved properly              //
			//--------------------------------------------------------------------//
			 assertTrue(verifyStoredValuesCA(selenium,consentsCAData),"Consents details not saved properly; More Details :"+ consentsCAData.toString(), selenium, ClassName, MethodName);
			 assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 assertTrue(verifyStoredValuesForSummaryPageAddConsentsInCa(selenium,consentsCAData),"Consents details not saved properly; More Details :"+ consentsCAData.toString(), selenium, ClassName, MethodName);
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}	
}
