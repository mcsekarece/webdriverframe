package com.nexia.selenium.testscripts.section.demographics.Identifiers;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class EditIdentifiers extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing patient for Identifers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNewIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "CreateIdentifiers";
		identifierTestData.testCaseId = "TC_ID_008";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editIdentifier(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify edit Identifier
	* @action 		  verifying edit Identifier
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 27, 2012
	***************************************************************************************************/
	public boolean editIdentifier(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib identifierTestData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + identifierTestData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, identifierTestData.userName, identifierTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,identifierTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create Identifer Group and Type at Admin section  //
			//--------------------------------------------------------------------//
			/*waitForPageLoad(selenium);
			click(selenium,lnkSystemSetting);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkIdentifierGroup),"Could not click on Identifier Group link:" + identifierTestData .toString());
			waitForPageLoad(selenium);
			
			identifierTestData.workSheetName = "IdentifiersAdmin";
			identifierTestData.testCaseId = "TC_IDA_001";
			identifierTestData.fetchHomeTestData();
			
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + identifierTestData.toString());
			waitForPageLoad(selenium);
			assertTrue(createIdGroup(selenium,identifierTestData),"Identifier Groups Creation failed");
			
			assertTrue(click(selenium,lnkIdentifierType),"Could not click on Identifier Group link:" + identifierTestData .toString());
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddIdentifierType),"Could not click on Add Identifier Type link:" + identifierTestData.toString());
			waitForPageLoad(selenium);
			
			assertTrue(createIdType(selenium,identifierTestData),"Identifier Types Creation failed");
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID  //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,identifierTestData.patientID);
			waitForPageLoad(selenium);
			click(selenium,lnkIdentifier);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Deleting existing identifier for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllIdentifiers(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Create a new Identifier //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddIdentifier),"Could not click on Add Identifers Button:"+identifierTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(createIdentifierCAView(selenium,identifierTestData,userAccount),"identifier creation failed", selenium, ClassName, MethodName);
			click(selenium,lnkEditIdentifier);
			waitForPageLoad(selenium);
			
			/*click(selenium,btnBackButton);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-7: Create Identifer Group and Type at Admin section  //
			//--------------------------------------------------------------------//
			/*waitForPageLoad(selenium);
			click(selenium,lnkSystemSetting);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkIdentifierGroup),"Could not click on Identifier Group link:" + identifierTestData .toString());
			waitForPageLoad(selenium);
			identifierTestData.workSheetName = "IdentifiersAdmin";
			identifierTestData.testCaseId = "TC_IDA_002";
			identifierTestData.fetchHomeTestData();
			
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + identifierTestData.toString());
			waitForPageLoad(selenium);
			
			assertTrue(createIdGroup(selenium,identifierTestData),"Identifier Groups Creation failed");
			assertTrue(click(selenium,lnkIdentifierType),"Could not click on Identifier Group link:" + identifierTestData .toString());
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddIdentifierType),"Could not click on Add Identifier Type link:" + identifierTestData.toString());
			
			waitForPageLoad(selenium);
			assertTrue(createIdType(selenium,identifierTestData),"Identifier Types Creation failed");
			
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Advanced search with Patient ID  //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,identifierTestData.patientID);
			waitForPageLoad(selenium);
			click(selenium,lnkIdentifier);
			waitForPageLoad(selenium);*/
			/*click(selenium,lnkEditIdentifier);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-9: Edit Created Identifier //
			//--------------------------------------------------------------------//
			assertTrue(editIdentifiers(selenium,identifierTestData,userAccount),"Idetifiers creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkEditIdentifier);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-10: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesIdentifier(selenium,identifierTestData,userAccount)){
				Assert.fail("Identifiers details not saved properly; More Details :"+ identifierTestData.toString());
				returnValue=true;
			}else{
				return returnValue;
			}
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}		
}

