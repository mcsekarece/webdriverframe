package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDuplicateEntryForUser  extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Duplicate Entery for User")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void duplicateEntryForUser (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "CreateUser";
		userData.testCaseId = "TC_CU_001";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDuplicateEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	/**
	 * verifyDuplicateEntry
	 * function to verifyDuplicateEntry
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @defect		#8002
	 * @throws 		InterruptedException 
	 * @since  	    June 05, 2010
	 */
	public boolean verifyDuplicateEntry(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib userData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		String uniqueName = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, userData.userName, userData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,userData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			Assert.assertTrue(gotoSystemSetting(selenium));
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Add User//
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createNewUser(selenium,userData,uniqueName),"Create new user failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(createNewUser(selenium,userData,uniqueName),"Create new user failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.mouseOver(txtUserName);
			//Assert.assertTrue(type(selenium,txtUserName,userData.userName1+uniqueName),"Could not type a user name" + userData .toString());
			
			if(!selenium.isTextPresent("This User Name already exists. Another User Name must be used.")){
				Assert.fail("Duplicate Warning is not getting displayed.");
			}
			
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + userData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
