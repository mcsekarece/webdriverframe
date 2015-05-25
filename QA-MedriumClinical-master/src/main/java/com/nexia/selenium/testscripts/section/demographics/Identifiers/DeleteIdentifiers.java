package com.nexia.selenium.testscripts.section.demographics.Identifiers;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteIdentifiers extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleteing Identifiers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "CreateIdentifiers";
		identifierTestData.testCaseId = "TC_ID_007";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		deleteIdentifier(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}
	
	
	
	/*************************************************************************************************** 
	* @purpose        To verify Delete Identifier
	* @action 		  verifying Delete Identifier
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean deleteIdentifier(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib identifierData)throws Exception{
		
		Selenium selenium = null;
		boolean returnValue=true;
		
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
			//  Step-3: Create Identifer Group and Type at Admin section  //
			//--------------------------------------------------------------------//
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
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID  //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,identifierData.patientID);
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
			assertTrue(click(selenium,btnAddIdentifier),"Could not click on Add Identifers Button:"+identifierData.toString(), selenium, ClassName, MethodName);
			assertTrue(createIdentifierCAView(selenium,identifierData,userAccount),"identifier creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkEditIdentifier);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesIdentifier(selenium,identifierData,userAccount)){
				Assert.fail("Identifier details not saved properly; More Details :"+ identifierData.toString());
				waitForPageLoad(selenium);
				returnValue=true;
			}else{
				return returnValue;
			}
			assertTrue(deleteAllIdentifiers(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	

