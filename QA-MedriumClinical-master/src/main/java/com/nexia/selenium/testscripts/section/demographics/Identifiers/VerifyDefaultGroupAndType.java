package com.nexia.selenium.testscripts.section.demographics.Identifiers;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultGroupAndType extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Default group and type created in system settings is present in Patient Identifiers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultIdentifierGroupAndType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "CreateIdentifiers";
		identifierTestData.testCaseId = "TC_ID_010";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyDefaultGroupAndType(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}

	/*******************************************************************************************************************
	* @purpose        To verifying Default group and type created in system settings is present in Patient Identifiers
	* @action 		  verifying Default group and type created in system settings is present in Patient Identifiers
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 27, 2012
	*********************************************************************************************************************/
	public boolean verifyDefaultGroupAndType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib identifierData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + identifierData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, identifierData.userName, identifierData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,identifierData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create Identifer Group and Type at Admin section //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
			assertTrue(click(selenium,"systemSettingsAction"),"Could not click the System settings link;More Details:"+identifierData.toString(), selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkIdentifierGroup),"Could not click on Identifier Group link:" + identifierData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			identifierData.workSheetName = "IdentifiersAdmin";
			identifierData.testCaseId = "TC_IDA_003";
			identifierData.fetchHomeTestData();
			
			assertTrue(createIdGroup(selenium,identifierData),"Identifier Groups Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdType(selenium,identifierData),"Identifier Types Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			
			
			searchPatientNexia(selenium,identifierData.patientID);
			
			waitForPageLoad(selenium);
			click(selenium,lnkIdentifier);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Deleting existing identifier for the selected patient  //
			//--------------------------------------------------------------------//
			int counter =(Integer) selenium.getXpathCount(lnkDeleteIdentifier);
			while(isElementPresent(selenium,"//div[@id='PatientExternalIDList']/table/tbody/tr["+counter+"]/td[3]/div/a")){
				assertTrue(click(selenium,"//div[@id='PatientExternalIDList']/table/tbody/tr["+counter+"]/td[3]/div/a"),"", selenium, ClassName, MethodName);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
				counter--;
			
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Go to add identifiers and verify the default Group and Type//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddIdentifier),"Could not click on Add Identifers Button:"+identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!verifyDefaultValuesGroupAndType(selenium,identifierData)){
				waitForPageLoad(selenium);
				Assert.fail("Identifier details not saved properly; More Details :"+ identifierData.toString());
				returnValue=true;
			}else{
				return returnValue;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}		
}
