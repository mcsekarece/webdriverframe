package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteProvider extends AbstractSystemSettingsTest{
	@Test(enabled=false)
	// Commenting the Delete testcases for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting a Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateIdentifierGroups";
		providerData.testCaseId = "TC_IDG_001";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * deleteProvider
	 * function to delete Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public boolean deleteProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
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
			assertTrue(click(selenium,lnkIdentifierGroup), "Identifier group failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllIdentifiersGroup(selenium), "Delete all indentifiers failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdGroup(selenium,providerData),"Identifier Groups Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			providerData.workSheetName = "CreateIdentifierTypes";
			providerData.testCaseId = "TC_IDT_003";
			providerData.fetchSystemSettingTestData();
			//---------------------------------------------------------- ----------//
			//  Step-5: Deleting existing Identifier Types  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkIdentifierType),"Idenitifiers tyoe failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllIdentifiersTypes(selenium),"Delete all indentifiers failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-6: Add a new Identifier Types
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddIdentifierType),"Could not click on Add Identifier Type link:" + providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdType(selenium,providerData),"Identifier Types Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Create Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			providerData.workSheetName = "CreateProvider";
			providerData.testCaseId = "TC_PO_001";
			providerData.fetchSystemSettingTestData();
			waitForPageLoad(selenium);
			assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddMMyyHHmm");
			String providerCodeUnique=DateFormat.format(cal.getTime());

			assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProviderCAView(selenium,providerData,providerCodeUnique,userAccount),"Provider creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Delete Provider //
			//--------------------------------------------------------------------//
			assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + providerData.toString(), selenium, ClassName, MethodName);
			}
			return returnValue;
		}
}
