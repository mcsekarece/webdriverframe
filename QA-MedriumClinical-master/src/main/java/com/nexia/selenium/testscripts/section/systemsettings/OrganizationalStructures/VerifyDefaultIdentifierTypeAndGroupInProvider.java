package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultIdentifierTypeAndGroupInProvider extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Default Identifier Types and Groups in Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultIdentifierTypeAndGroupInProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateIdentifierGroups";
		providerData.testCaseId = "TC_IDG_005";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDefaultTypeAndGroupInProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * verifyDefaultTypeAndGroupInProvider
	 * function to verify Default Identifier Types and Groups in Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public boolean verifyDefaultTypeAndGroupInProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		
			Selenium selenium=null;
			boolean returnValue=true;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
			
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
				
				//--------------------------------------------------------------------//
				//---------------  Step-2:Change Switch Role  --------------//
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,providerData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-2: Go to System Settings and navigate to Provider //
				//--------------------------------------------------------------------//
				Assert.assertTrue(gotoSystemSetting(selenium));
			    waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
				//  Step-3: Create Identifier Group //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkIdentifierGroup),"could not Indentifier Group", selenium, ClassName, MethodName);
				

				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				assertTrue(deleteAllIdentifiersGroup(selenium),"could not delete Indentifier Group", selenium, ClassName, MethodName);
				
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createIdGroup(selenium,providerData),"Identifier Groups Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-4: Create Identifier Type //
				//--------------------------------------------------------------------//
				SystemSettingsLib providerTypeData = new SystemSettingsLib();
				providerTypeData.workSheetName = "CreateIdentifierTypes";
				providerTypeData.testCaseId = "TC_IDT_006";
				providerTypeData.fetchSystemSettingTestData();
				//---------------------------------------------------------- ----------//
				//  Step-5: Deleting existing Identifier Types  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkIdentifierType),"Could not click IdentifierType", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				assertTrue(deleteAllIdentifiersTypes(selenium),"could not delete Indentifier type", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//---------------------------------------------------------- ----------//
				//  Step-6: Add a new Identifier Types
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, btnAddIdentifierType),"Could not click on Add Identifier Type link:" + providerTypeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createIdType(selenium,providerTypeData),"Identifier Types Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//---------------------------------------------------------- ----------//
				//  Step-6: Navigate to organizational Structure //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerTypeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerTypeData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnIdentifierButtonId),"Could not click on provider link:" + providerTypeData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//---------------------------------------------------------- ----------//
				//  Step-6: Verify Group and type values //
				//--------------------------------------------------------------------//
				if(!verifyDefaultValues(selenium,providerData,providerTypeData)){
					Assert.fail("Group and type details not saved properly; More Details :"+ providerData.toString());
					returnValue=false;
				}else
					return returnValue;
			
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString(), selenium, ClassName, MethodName);
			}
			return returnValue;
			}
	public boolean verifyDefaultValues(Selenium selenium,SystemSettingsLib providerData,SystemSettingsLib providerTypeData){
		if(!getValue(selenium,ajxGroupName).trim().contains(providerData.groupName.trim())){
			return false;
		}
		if(!getValue(selenium,ajxGroupFor).trim().contains(providerTypeData.idType.trim())){
			return false;
		}
		return true;
	}}
