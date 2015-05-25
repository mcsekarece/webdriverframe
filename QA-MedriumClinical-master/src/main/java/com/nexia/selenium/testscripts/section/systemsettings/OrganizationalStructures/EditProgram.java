package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class EditProgram extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a External Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNewPrograms(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib programData = new SystemSettingsLib();
		programData.workSheetName = "CreateProgram";
		programData.testCaseId = "TC_CP_001";
		programData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	/**
	 * editProgram
	 * function to edit Program
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public boolean editProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib programData) throws Exception{
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
			/*assertTrue(switchRole(selenium,programData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Programs //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + programData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Create Program //
			//--------------------------------------------------------------------//
			assertTrue(createProgram(selenium,programData,uniqueName),"Create program failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			programData.workSheetName="EditProgram";
			programData.testCaseId="TC_EP_001";
			programData.fetchSystemSettingTestData();
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Edit Program //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit1),"Could not click on edit a program link:" + programData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(editProgram(selenium,programData,uniqueName),"Edit program failed" ,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Verify the stored values of the edited program //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit1),"Could not click on edit a program link:" + programData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!verifyStoredValues(selenium,programData,uniqueName)){
				Assert.fail("Program details not edited properly; More Details :"+ programData.toString());
				returnValue=false;
			}else
				return returnValue;
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+programData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteProgram(selenium,programData),"delete program failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString(), selenium, ClassName, MethodName);
			Thread.sleep(10000);
		}
	return returnValue;
	}


	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib programData,String uniqueName){
	
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

