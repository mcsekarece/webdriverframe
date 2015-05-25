package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteNewProgram extends AbstractSystemSettingsTest{
	@Test(enabled=false)
	// Commenting the Delete testcases for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting a program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deletePrograms(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib programData = new SystemSettingsLib();
		programData.workSheetName = "CreateProgram";
		programData.testCaseId = "TC_CP_001";
		programData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	/**
	 * deleteProgram
	 * function to deleteProgram
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public boolean deleteProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib programData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + programData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, programData.userName, programData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,programData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Exit Program //
			//--------------------------------------------------------------------//
			assertTrue(deleteProgram(selenium,programData),"Could not delete the Program", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Program //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + programData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());

			assertTrue(createProgram(selenium,programData,uniqueName),"Create program failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEdit1),"Could not click on edit a program link:" + programData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Store Value //
			//--------------------------------------------------------------------//
			if(!verifyStoredValues(selenium,programData,uniqueName)){
				Assert.fail("Program details not saved properly; More Details :"+ programData.toString());
				returnValue=false;
			}else
				click(selenium,btnCancel);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Program //
			//--------------------------------------------------------------------//
			click(selenium,lnkAdminOrgStructureLists);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProgram(selenium, programData),"could not delete the program", selenium, ClassName, MethodName);
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + programData.toString(), selenium, ClassName, MethodName);
		}
	return returnValue;
	}

	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib programData,String uniqueName){
		waitForPageLoad(selenium);
		if(!getText(selenium,lblProgram).contains(programData.program+uniqueName)){
			return false;
		}
		if(!getValue(selenium,ajxSuggestBoxProg ).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.department.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtdescription).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}

