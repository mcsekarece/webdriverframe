package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;
public class VerifyAddHouseholdInUnfinishedItem extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Add Household In Unfinished Item")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAddHouseholdInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib householdData = new HomeLib();
		householdData.workSheetName = "NewHousehold";
		householdData.testCaseId = "TC_HH_005";
		householdData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAddHouseholdInUnfinishedItem(seleniumHost, seleniumPort, browser, webSite, userAccount, householdData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Add Household In Unfinished Item
	* @action 		  Verifying Add Household In Unfinished Item
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 09, 2013
	***************************************************************************************************/
	public boolean verifyAddHouseholdInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib householdData) throws Exception{
		Selenium selenium = null;	
		String currentUnfinishedItem="Edit Household for";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + householdData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, householdData.userName, householdData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,householdData.switchRole),"",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ householdData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,householdData.patientID);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			click(selenium,lnkHouseHold);
			waitForPageLoad(selenium);
			while(isElementPresent(selenium,lnkDelete)&&isElementVisible(selenium,lnkDelete)){
				click(selenium,lnkDelete);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Add a household member//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddHouseHold),"Could not Click on Add Family Member Button:"+ householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(createHousehold(selenium,householdData),"Household creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			assertTrue(storeDataInUnfinishedItem(selenium),"Could not Store data in unfinished item; More Details :"+ householdData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to unfinished item							  //
			//--------------------------------------------------------------------//
			//get the current patient name
			String patientName[]= getText(selenium, lblPatientName).split(",");
			
			//customize the patient name for our need
			String patientNameAltered= patientName[1] +" "+ patientName[0];
			
			//append the patient name with the current unfinished item section
			currentUnfinishedItem= currentUnfinishedItem + patientNameAltered ;
			
			assertTrue(navigateToUnfinishedItem(selenium, currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ householdData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Save the unfinished Household item							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnSave),"could not click the save button; More Details:"+householdData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkDelete),"Household member is not saved properly; More Details :"+ householdData.toString(), selenium, ClassName, MethodName);
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}
