package com.nexia.selenium.testscripts.section.systemsettings.identifierstypes;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyIdentifierAccessLevels extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying different level of identifier access levels")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIdentifierPracticeLevelAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib idGroupData = new SystemSettingsLib();
		idGroupData.workSheetName = "CreateIdentifierGroups";
		idGroupData.testCaseId = "TC_IDG_001";
		idGroupData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createIdentifierGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an Identifier type")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyIdentifierEnterpriseLevelAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib idGroupData = new SystemSettingsLib();
		idGroupData.workSheetName = "CreateIdentifierGroups";
		idGroupData.testCaseId = "TC_IDG_001";
		idGroupData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createIdentifierGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
	}
	/*************************************************************************************************** 
	* @purpose        To verifying different level of identifier access levels
	* @action 		  verifying different level of identifier access levels
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 09, 2013
	***************************************************************************************************/
	public boolean createIdentifierGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib idGroupData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + idGroupData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, idGroupData.userName, idGroupData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,idGroupData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Identifier Types //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkSettings),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-3: Deleting existing Identifier Groups  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkIdentifierGroup),"Could not click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllIdentifiersGroup(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Add a new Identifier Group
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + idGroupData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdGroup(selenium,idGroupData),"Identifier Groups Creation failed", selenium, ClassName, MethodName);
			
			SystemSettingsLib idTypeData = new SystemSettingsLib();
			idTypeData.workSheetName = "CreateIdentifierTypes";
			idTypeData.testCaseId = "TC_IDT_001";
			idTypeData.fetchSystemSettingTestData();
			//---------------------------------------------------------- ----------//
			//  Step-5: Deleting existing Identifier Types  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkIdentifierType),"Could not click",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllIdentifiersTypes(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-6: Add a new Identifier Group
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkAddIdentifierType),"Could not click on Add Identifier Type link:" + idTypeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdType(selenium,idTypeData),"Identifier Types Creation failed", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkldenCloseArrow),"Could not click on Expand All button:" + idTypeData.toString(), selenium, ClassName, MethodName);

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
