package com.nexia.selenium.testscripts.section.systemsettings.userroles;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForUserRole extends AbstractSystemSettingsTest{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "user With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUserWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest userRoleData = new SystemsSettingsUnitTest();
		userRoleData.workSheetName = "UitTest_SS_UserRole";
		userRoleData.testCaseId = "TC_UR_001";
		userRoleData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForUserRole(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Description With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDescriptionWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest userRoleData = new SystemsSettingsUnitTest();
		userRoleData.workSheetName = "UitTest_SS_UserRole";
		userRoleData.testCaseId = "TC_UR_001";
		userRoleData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForUserRole(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	/**
	 * verifyUserRoleInUser
	 * function to verify User Role In User
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	    Aug 30, 2012
	 */
	public boolean unitTestForUserRole(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemsSettingsUnitTest userRoleData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userRoleData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, userRoleData.userName, userRoleData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,userRoleData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to Security Settings and navigate to User Rules//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickLink), "Could not click Quick Actions link", selenium, ClassName, MethodName);

			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSecuritySettings1),"Could not click on Security settings link:" + userRoleData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkUserRole),"Could noy click the User Role link:"+userRoleData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Verify the User test //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddIdentifierType),"Could not click the add button;More details:"+userRoleData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(userRole_UnitTest(selenium,userRoleData),"User role Failed", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, userRoleData.alert), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, userRoleData.alert).contains(userRoleData.alertMessage), "The expected validation message should contain the text - "+ userRoleData.alertMessage + " The actual validation message shown - " + getText(selenium, userRoleData.alert), selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	/**
	 * userRole_UnitTest
	 * function to userRole_UnitTest
	 * @throws IOException 
	 * @since  	    Aug 30, 2012
	 */
	public boolean userRole_UnitTest(Selenium selenium,SystemsSettingsUnitTest userRole) throws IOException{ 
		 try{
			 assertTrue(type(selenium,txtUserRoleMore,userRole.userRole),"Could not type the user role;More details"+userRole.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtdescription,userRole.description),"Could not type the user role;More details"+userRole.toString() , selenium, ClassName, MethodName);
			 assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			 return true;
		 }catch(RuntimeException e){
			 e.printStackTrace();
			 return false;
		 }
		
	 }
}


