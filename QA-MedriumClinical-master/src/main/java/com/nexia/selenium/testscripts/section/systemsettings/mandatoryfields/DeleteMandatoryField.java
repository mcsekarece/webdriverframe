package com.nexia.selenium.testscripts.section.systemsettings.mandatoryfields;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteMandatoryField extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an Identifier type")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteMandatory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "CreateMandatoryField";
		mandData.testCaseId = "TC_MF_001";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteMandatoryField(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	
	/**
	 * deleteMandatoryField
	 * function to delete Mandatory Field
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    June 27, 2012
	 */
	
	public boolean deleteMandatoryField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib mandData) throws Exception{
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
			assertTrue(switchRole(selenium,mandData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
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
			assertTrue(deleteAllMandatoryUserField(selenium), "Delete mandatory failed",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Add a new Mandatory User Field
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAddMandatoryUserField),"Could not click on Add Mandatory User Field link:" + mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createMandatoryUserField(selenium,mandData),"Mandatory User Field Creation failed", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-5: Delete newly created Mandatory User Field
			//--------------------------------------------------------------------//
			assertTrue(deleteAllMandatoryUserField(selenium),"Delete all madatory failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValues(selenium,mandData)){
				Assert.fail("Mandatory User Field details not saved properly; More Details :"+ mandData.toString());
				returnValue=false;
			}else
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, SystemSettingsLib mandData){
		if(isElementPresent(selenium,lblPatientIdentifierGroup)){
				return false;
		}
		else return true;
	}
}

