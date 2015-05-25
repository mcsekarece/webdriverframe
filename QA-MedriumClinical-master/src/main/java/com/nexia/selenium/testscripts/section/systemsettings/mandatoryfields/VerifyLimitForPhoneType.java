package com.nexia.selenium.testscripts.section.systemsettings.mandatoryfields;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLimitForPhoneType extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an Identifier type")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLimitForMandatory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "CreateMandatoryField";
		mandData.testCaseId = "TC_MF_002";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLimitForMandatoryField(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	
	/**
	 * verifyLimitForMandatoryField
	 * function to verify Limit For Mandatory Field
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 16, 2012
	 */
	
	public boolean verifyLimitForMandatoryField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib mandData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mandData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mandData.userName, mandData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mandData.switchRole),"Swicth role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Mandatory User Field //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminMandatoryUserField),"Could not click on Mandatory User Field link:" + mandData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-3: Deleting existing entries  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllMandatoryUserField(selenium),"Delete AllMandatoryUserField failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Add more than three phone types and check validation
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAddMandatoryUserField),"Could not click on Add Mandatory User Field link:" + mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createMandatoryUserField(selenium,mandData),"Mandatory User Field Creation failed", selenium, ClassName, MethodName);
			
			mandData.workSheetName = "CreateMandatoryField";
			mandData.testCaseId = "TC_MF_003";
			mandData.fetchSystemSettingTestData();
			assertTrue(click(selenium,lnkAddMandatoryUserField),"Could not click on Add Mandatory User Field link:" + mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createMandatoryUserField(selenium,mandData),"Mandatory User Field Creation failed", selenium, ClassName, MethodName);
			
			mandData.workSheetName = "CreateMandatoryField";
			mandData.testCaseId = "TC_MF_004";
			mandData.fetchSystemSettingTestData();
			assertTrue(click(selenium,lnkAddMandatoryUserField),"Could not click on Add Mandatory User Field link:" + mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createMandatoryUserField(selenium,mandData),"Mandatory User Field Creation failed", selenium, ClassName, MethodName);
			
			mandData.workSheetName = "CreateMandatoryField";
			mandData.testCaseId = "TC_MF_005";
			mandData.fetchSystemSettingTestData();
			assertTrue(click(selenium,lnkAddMandatoryUserField),"Could not click on Add Mandatory User Field link:" + mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			createMandatoryUserField(selenium,mandData);
			
			//--------------------------------------------------------------------//
			//  Step-5: Check Validation //
			//--------------------------------------------------------------------//
			if(!isElementPresent(selenium,lblPatientIdentifierGroup)){
				if(isElementPresent(selenium,"errorCloseButton")){
					waitForPageLoad(selenium);
					if(getText(selenium,"css=li > div").equals("You can not have more than 3 mandatory phone types")){
						 returnValue=true;
					}
					else returnValue=false;
					}
			}else
				Assert.fail("Mandatory fields section does't limit the number of phone types  :" + mandData.toString());
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}

