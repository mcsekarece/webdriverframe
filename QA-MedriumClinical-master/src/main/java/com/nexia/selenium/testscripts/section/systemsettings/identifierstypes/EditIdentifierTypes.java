package com.nexia.selenium.testscripts.section.systemsettings.identifierstypes;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class EditIdentifierTypes extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing an Identifier type")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNewIdentifierTypes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib idGroupData = new SystemSettingsLib();
		idGroupData.workSheetName = "CreateIdentifierGroups";
		idGroupData.testCaseId = "TC_IDG_001";
		idGroupData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editIdentifierType(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
	}
	/**
	 * editIdentifierType
	 * function to edit Identifier Types
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	     May 22, 2012
	 */
	public boolean editIdentifierType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib idGroupData) throws Exception{
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
			//  Step-2: Go to System Settings and navigate to External Providers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
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
			waitForPageLoad(selenium);
			
			
			SystemSettingsLib idTypeData = new SystemSettingsLib();
			idTypeData.workSheetName = "CreateIdentifierTypes";
			idTypeData.testCaseId = "TC_IDT_005";
			idTypeData.fetchSystemSettingTestData();
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Deleting existing Identifier Type  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkIdentifierType),"Could not click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllIdentifiersTypes(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-6: Add a new IdentifierType
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkAddIdentifierType),"Could not click on Add Identifier Type link:" + idTypeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdType(selenium,idTypeData),"Identifier Types Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Edit the created entry//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEditIdGroup),"Could not click on Edit button link:" + idTypeData.toString(), selenium, ClassName, MethodName);
			SystemSettingsLib editIdTypeData = new SystemSettingsLib();
			editIdTypeData.workSheetName = "CreateIdentifierTypes";
			editIdTypeData.testCaseId = "TC_IDT_002";
			editIdTypeData.fetchSystemSettingTestData();
			assertTrue(createIdType(selenium,editIdTypeData),"Identifier Types Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkldenCloseArrow),"Could not click on Expand All button:" + editIdTypeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			
				if(!verifyStoredValues(selenium,idTypeData,editIdTypeData)){
					Assert.fail("Identifier types details not saved properly; More Details :"+ editIdTypeData.toString());
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
	
	

	public boolean verifyStoredValues(Selenium selenium, SystemSettingsLib idTypeData,SystemSettingsLib editIdTypeData){
	
		
		if(!getText(selenium,vfyStoreIdGroupType).trim().contains(editIdTypeData.groupFor.trim())){
			return false;
		}
		if(!getText(selenium,vfyStoreIdGroupType).trim().contains(editIdTypeData.idType.trim())){
			return false;
		}
		if(!getText(selenium,vfyStoreIdGroupType).trim().contains(editIdTypeData.idGroup.trim())){
			return false;
		}
		
		if(!getText(selenium,vfyStoreIdGroupType).trim().contains(editIdTypeData.expDate.trim())){
			return false;
		}
		if(!getText(selenium,vfyStoreIdGroupType).trim().contains(editIdTypeData.restricted.trim())){
			return false;
		}
	/*	
		if(!getText(selenium,"//td[2]/div/div/div").trim().contains(idTypeData.identifier.trim())){
			return false;
		}
		if(!getText(selenium,"//td[2]/div/div/div").trim().contains(editIdTypeData.identifier.trim())){
			return false;
		}*/
		/*if(!getText(selenium,"//td[2]/div/div/div").trim().contains(editIdTypeData.typeDescription.trim())){
			return false;
		}*/
		return true;
	}
}

