package com.nexia.selenium.testscripts.section.demographics.Identifiers;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyIdentifierAccessLevels extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying different level of identifier access levels")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIdentifierPracticeLevelAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib idTypeData = new SystemSettingsLib();
		idTypeData.workSheetName = "CreateIdentifierTypes";
		idTypeData.testCaseId = "TC_IDT_007";
		idTypeData.fetchSystemSettingTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createIdentifierGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an Identifier type")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyIdentifierEnterpriseLevelAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib idTypeData = new SystemSettingsLib();
		idTypeData.workSheetName = "CreateIdentifierTypes";
		idTypeData.testCaseId = "TC_IDT_008";
		idTypeData.fetchSystemSettingTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createIdentifierGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	/*************************************************************************************************** 
	* @purpose        To verifying different level of identifier access levels
	* @action 		  verifying different level of identifier access levels
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 09, 2013
	***************************************************************************************************/
	public boolean createIdentifierGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib idTypeData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + idTypeData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, idTypeData.userName, idTypeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,idTypeData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to Identifier Types 	  //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			 assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
			assertTrue(click(selenium,"systemSettingsAction"),"Could not click the System settings link;More Details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Deleting existing Identifier Groups  					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkIdentifierGroup),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllIdentifiersGroup(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Add a new Identifier Group
			//--------------------------------------------------------------------//
			SystemSettingsLib idGroupData = new SystemSettingsLib();
			idGroupData.workSheetName = "CreateIdentifierGroups";
			idGroupData.testCaseId = "TC_IDG_006";
			idGroupData.fetchSystemSettingTestData();
			
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + idGroupData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdGroup(selenium,idGroupData),"Identifier Groups Creation failed", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-6: Deleting existing Identifier Types  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkIdentifierType),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllIdentifiersTypes(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-7: Add a new Identifier Group
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddIdentifierType),"Could not click on Add Identifier Type link:" + idTypeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdType(selenium,idTypeData),"Identifier Types Creation failed", selenium, ClassName, MethodName);
			//assertTrue(click(selenium,lnkCloseArrow),"Could not click on Expand All button:" + idTypeData.toString(), selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-8: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			/*if(!verifyStoredValuesIdentifierAccessLevel(selenium,idTypeData)){
				Assert.fail("Identifier types details not saved properly; More Details :"+ idTypeData.toString());
				returnValue=false;
			}*/
			
			
			//---------------------------------------------------------- -----------------------------//
			//  Step-9: Verify Identifier type presence in demographics identifier for practice level 
			//----------------------------------------------------------------------------------------//
			
			HomeLib identifierTestData = new HomeLib();
			identifierTestData.workSheetName = "CreateIdentifiers";
			identifierTestData.testCaseId = "TC_ID_011";
			identifierTestData.fetchHomeTestData();
			
			navigateToIdentifiers(selenium,identifierTestData);
			
			assertTrue((getText(selenium, lblAjaxList2).contains(identifierTestData.typeCA)),"Could not get text",selenium, ClassName, MethodName);
			
			
			assertTrue(click(selenium,btnCancel),"Could not  cancel button :"+identifierTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Select some other practice  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkLocationMenuHeader),"Could not click on practice:"+identifierTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lblSecondPractice1),"Could not click on second practice from practce list:"+identifierTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//---------------------------------------------------------- -------------------------------//
			//  Step-11: Verify Identifier type presence in demographics identifier for Enterprise level 
			//------------------------------------------------------------------------------------------//
			navigateToIdentifiers(selenium, identifierTestData);
			
	
			assertTrue(isTextPresent(selenium,identifierTestData.typeCA),"Identifier Type not present", selenium, ClassName, MethodName);
			
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public void navigateToIdentifiers(Selenium selenium, HomeLib identifierTestData) throws IOException{
		
		//--------------------------------------------------------------------//
		//  Step-1: Advanced search with Patient ID  //
		//--------------------------------------------------------------------//
		searchPatientNexia(selenium,identifierTestData.patientID);
		waitForPageLoad(selenium);
		
		click(selenium,lnkIdentifier);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-2: Create a new Identifier //
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,btnAddIdentifier),"Could not click on Add Identifers Button:"+identifierTestData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		selectValueFromAjaxList(selenium,ajxGroup,identifierTestData.group);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,ajxType),"Could not click on type suggest box:"+identifierTestData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	}
}
