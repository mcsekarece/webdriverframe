package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddCasesInUnfinishedItem extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Cases in unfinished item")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAddCasesInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib CaseData = new HomeLib();
		CaseData.workSheetName = "NewCases";
		CaseData.testCaseId = "TC_NC_006";
		CaseData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCreateCaseInUnfinishedItem(seleniumHost, seleniumPort, browser, webSite, userAccount, CaseData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose       verify Add Cases In UnfinishedItem
	* @action 		 verify Add Cases In UnfinishedItem
	* @author        Aspire QA
	* @state         developing
	* @useraccount   Both
	* @since  	     July 09, 2013
	***************************************************************************************************/

	public boolean verifyCreateCaseInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib CaseData) throws Exception{
		Selenium selenium = null;
		String currentUnfinishedItem="Add Cases for";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + CaseData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, CaseData.userName, CaseData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,CaseData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ CaseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,CaseData.patientID);
			waitForPageLoad(selenium);
			
			assertTrue(goToCases(selenium), "Could not navigate to Cases Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Deleting existing contacts for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllCases(selenium),"Cases  details not saved properly; More Details :"+ CaseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Create a new Contact //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Click on Add Cases  Button:"+ CaseData.toString(), selenium, ClassName, MethodName);
			assertTrue(createCases(selenium,CaseData, userAccount),"Cases details not saved properly; More Details :"+ CaseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			assertTrue(storeDataInUnfinishedItem(selenium),"Could not Store data in unfinished item; More Details :"+ CaseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to unfinished item							  //
			//--------------------------------------------------------------------//
			//get the current patient name
			String patientName[]= getText(selenium, lblPatientName).split(",");
			
			//customize the patient name for our need
			String patientNameAltered= patientName[1] +" "+ patientName[0];
			
			//append the patient name with the current unfinished item section
			currentUnfinishedItem= currentUnfinishedItem + patientNameAltered ;
			
			assertTrue(navigateToUnfinishedItem(selenium, currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ CaseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValuesAddCases(selenium,CaseData,userAccount),"Cases  details not saved properly in summary section; More Details :"+ CaseData.toString(), selenium, ClassName, MethodName);
		
			// Complete the unfinished item
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + CaseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------------//
			//  Step-10: Verifying Completed unfinished item Details are saved properly  //
			//---------------------------------------------------------------------------//
			assertTrue(verifyStoredValuesInSummaryAddCases(selenium,CaseData, userAccount),"Cases  details not saved properly in summary section; More Details :"+ CaseData.toString(), selenium, ClassName, MethodName);
		
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}
