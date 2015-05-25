package com.nexia.selenium.testscripts.section.demographics.Identifiers;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectOptionForIdentifiers extends AbstractHomeTest{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the selected options in the select fields")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySelectOptionForIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "CreateIdentifiers";
		identifierTestData.testCaseId = "TC_ID_013";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySelectOption(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the selected options in the select fields")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySelectOptionForIdentifiersCAview(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "CreateIdentifiers";
		identifierTestData.testCaseId = "TC_ID_006";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySelectOption(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify select option in the select fields
	* @action 		  verifying select option in the select fields
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 06, 2012
	***************************************************************************************************/
	public boolean verifySelectOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib identifierData) throws Exception{
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
			
			//Create Identifer Group and Type at Admin section
			/*waitForPageLoad(selenium);
			click(selenium,lnkSystemSetting);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkIdentifierGroup),"Could not click on Identifier Group link:" + identifierData .toString());
			waitForPageLoad(selenium);
			identifierData.workSheetName = "IdentifiersAdmin";
			identifierData.testCaseId = "TC_IDA_001";
			identifierData.fetchHomeTestData();
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + identifierData.toString());
			waitForPageLoad(selenium);
			assertTrue(createIdGroup(selenium,identifierData),"Identifier Groups Creation failed");
			
			assertTrue(click(selenium,lnkIdentifierType),"Could not click on Identifier Group link:" + identifierData .toString());
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddIdentifierType),"Could not click on Add Identifier Type link:" + identifierData.toString());
			waitForPageLoad(selenium);
			assertTrue(createIdType(selenium,identifierData),"Identifier Types Creation failed");
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			*/
			//Advanced search with Patient ID
			searchPatientNexia(selenium,identifierData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkIdentifier);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Deleting existing identifier for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllIdentifiers(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: verify the select option display for identifiers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddIdentifier),"Could not click on Add Identifers Button:"+identifierData.toString(), selenium, ClassName, MethodName);
			if(verifySelectOptionIdentifiers(selenium,identifierData))
				returnValue=true;
			else{
				Assert.fail("Select options not displaying properly");
				returnValue=false;
			}
		}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}		
}
