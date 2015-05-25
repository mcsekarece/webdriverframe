package com.nexia.selenium.testscripts.section.demographics.Identifiers;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyIdentifiersMaskValue extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Identifier Mask Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIdentifierMaskValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{
		HomeLib identifiersData= new HomeLib();
		identifiersData.workSheetName="CreateIdentifiersType";
		identifiersData.testCaseId="TC_IDT_001";
		identifiersData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyValidMaskValue(seleniumHost, seleniumPort, browser, webSite, userAccount, identifiersData);
	}

	/**************************************************************
	* @purpose        To verify Identifier Mask Value
	* @action 		  verifying Identifier Mask Value
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 27, 2012
	****************************************************************/
	public boolean verifyValidMaskValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib identifiersData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + identifiersData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, identifiersData.userName, identifiersData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,identifiersData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to System setting //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			
			 assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
			assertTrue(click(selenium,"systemSettingsAction"),"Could not click the System settings link;More Details:"+identifiersData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkIdentifierGroup),"Could not click on Identifier Group link:" + identifiersData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			identifiersData.workSheetName = "IdentifiersAdmin";
			identifiersData.testCaseId = "TC_IDA_001";
			identifiersData.fetchHomeTestData();
			
			//---------------------------------------------------------------------//
			//  Step-4: Deleting existing Identifier Groups//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllIdentifiersGroup(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-5: Create Identifier Groups//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + identifiersData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdGroup(selenium,identifiersData),"Identifier Groups Creation failed", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkIdentifierType),"Could not click on Identifier Group link:" + identifiersData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-6: Deleting existing Identifier Types//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllIdentifiersTypes(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			// Step-7: Add a new Identifier Types //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddIdentifierType),"Could not click on Add Identifier Type link:" + identifiersData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdentifierType(selenium,identifiersData),"Identifier Types Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			// Step-8: Search Patient Nexia//
			//--------------------------------------------------------------------//
			click(selenium,btnBackButton);
			
			searchPatientNexia(selenium,identifiersData.patientID);
			
			click(selenium,lnkIdentifier);
			waitForPageLoad(selenium);
			
			//----------------------------------------------------------------------//
			//  Step-9: Deleting existing Identifier  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllIdentifiers(selenium),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-10: Create a new Identifier //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddIdentifier),"Could not click the Add button;More Details:"+identifiersData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxGroup,identifiersData.groupName);
			
			selectValueFromAjaxList(selenium,ajxType,identifiersData.idType);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtValueMask,identifiersData.value),"could not enhter the Mask value;More Details:"+identifiersData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"could not click save button; More Details:"+identifiersData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		   if(isElementPresent(selenium,lblTitle)){
				return true;
			}else{
				return false;
			} 
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}	
}
