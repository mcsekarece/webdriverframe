package com.nexia.selenium.testscripts.section.systemsettings.directories;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForPayerAdmin extends AbstractSystemSettingsTest {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role for Payer Admin")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib paData = new SystemSettingsLib();
		paData.workSheetName = "VerifySecurityOption";
		paData.testCaseId = "TC_VSP_001";
		paData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, paData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role for Payer Admin")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib paData = new SystemSettingsLib();
		paData.workSheetName = "VerifySecurityOption";
		paData.testCaseId = "TC_VSP_002";
		paData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, paData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role for Payer Admin")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib paData = new SystemSettingsLib();
		paData.workSheetName = "VerifySecurityOption";
		paData.testCaseId = "TC_VSP_003";
		paData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, paData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role for Payer Admin")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib paData = new SystemSettingsLib();
		paData.workSheetName = "VerifySecurityOption";
		paData.testCaseId = "TC_VSP_004";
		paData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, paData);
	} 

	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    July 10,2013
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib paData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + paData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, paData.userName, paData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,paData.switchRole),"Could not change the switch role;More Details:"+paData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
							
					
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role  									  //
			//--------------------------------------------------------------------//
						
			if(paData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(noAccessUserSystemSetting(selenium, paData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Only  Access User Role  									  //
			//--------------------------------------------------------------------//
			
			if(!paData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(goToDirectories(selenium, paData),"Could not navigate to Directories", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,paData.directoryType);
				waitForPageLoad(selenium);				
				assertTrue(selenium.isTextPresent("Manage Directories"),"Text not present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("No permission"),"Text not present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text not present", selenium, ClassName, MethodName);			
						
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Security 										  //
			//--------------------------------------------------------------------//
			assertTrue(verifySecurity(selenium,paData, userAccount), 
					"Security option not show properly; More Details :"+ paData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib paData, String userAccount ) throws IOException{
		boolean returnValue=true;
		
		// Limited Access
		if(paData.testCaseId.equals("TC_VSP_001")){
			
			paData.workSheetName = "PayerAdmin";
			paData.testCaseId = "TC_PA_003";
			paData.fetchSystemSettingTestData();
			
			assertTrue(click(selenium,btnAddNewPayer ),"Could not click the Add New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(createPayersMandatory(selenium,paData,userAccount),"Payer Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnDone ),"Could not click the Done Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Delete button should be not be Visible
			assertTrue(!selenium.isTextPresent("Delete"), "Delete Button is visible", selenium, ClassName, MethodName);

			// Edit Button is be Visible 
			assertTrue(selenium.isTextPresent("Edit"), "Edit Button is not visible", selenium, ClassName, MethodName);
						
		}
			
		
		// View Only Access
		if(paData.testCaseId.equals("TC_VSP_002")){
			
			// Edit, Add New and Delete Button should be hidden
			assertTrue(!selenium.isVisible(btnAddNewPayer), "Add Button is visible", selenium, ClassName, MethodName);
			// Delete button should be not be Visible
			assertTrue(!selenium.isTextPresent("Delete"), "Delete Button is visible", selenium, ClassName, MethodName);
			// Edit Button should not be Visible 
			assertTrue(!selenium.isTextPresent("Edit"), "Edit Button is not visible", selenium, ClassName, MethodName);
		}
		
		// Full Access
		if(paData.testCaseId.equals("TC_VSP_004")){
			paData.workSheetName = "PayerAdmin";
			paData.testCaseId = "TC_PA_003";
			paData.fetchSystemSettingTestData();
			
			assertTrue(deletePayerAdmin(selenium,paData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddNewPayer ),"Could not click the Add New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(createPayersMandatory(selenium,paData,userAccount),"Payer Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnDone ),"Could not click the Done Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isVisible(btnDeletePayer), "Delete Button is not visible", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
	
  }