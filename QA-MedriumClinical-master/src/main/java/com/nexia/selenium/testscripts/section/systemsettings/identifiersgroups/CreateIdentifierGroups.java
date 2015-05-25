package com.nexia.selenium.testscripts.section.systemsettings.identifiersgroups;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateIdentifierGroups extends AbstractSystemSettingsTest  {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an Identifier group")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewIdentifierGroups(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib idGroupData = new SystemSettingsLib();
		idGroupData.workSheetName = "CreateIdentifierGroups";
		idGroupData.testCaseId = "TC_IDG_001";
		idGroupData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createIdentifierGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
	}
	/**
	 * createIdentifierGroup
	 * function to create Identifier Groups
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	     May 17, 2012
	 */
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
			assertTrue(switchRole(selenium,idGroupData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Identifier Groups//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, lnkSettings),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-3: Deleting existing Identifier Groups  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkIdentifierGroup),"Could not click identifier group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(deleteAllIdentifiersGroup(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-4: Add a new Identifier Group
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + idGroupData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdGroup(selenium,idGroupData),"Identifier Groups Creation failed", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnEditIdGroup),"Could not click on Edit Button:" + idGroupData.toString(), selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			
				if(!verifyStoredValues(selenium,idGroupData)){
					waitForPageLoad(selenium);
					Assert.fail("identifier group details not saved properly; More Details :"+ idGroupData.toString());
					returnValue=false;
				}else
					return returnValue;
		}
			
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			Thread.sleep(10000);
		}
		return returnValue;
	}
	
	public boolean verifyStoredValues(Selenium selenium, SystemSettingsLib idGroupData){
		waitForPageLoad(selenium);
		
		if(!getText(selenium, btnIdGroup).trim().contains(idGroupData.groupFor.trim())){
			return false;
		}
		if(!getValue(selenium,txtGroup ).trim().equals(idGroupData.groupName.trim())){
				return false;
		}
		if(!getValue(selenium,txtdescription ).trim().equals(idGroupData.groupDescription.trim())){
				return false;
		}
		return true;
	}
}

