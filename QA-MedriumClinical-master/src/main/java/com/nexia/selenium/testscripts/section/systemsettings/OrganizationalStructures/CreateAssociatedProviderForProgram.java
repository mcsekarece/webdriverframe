package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateAssociatedProviderForProgram extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Associate Provider for program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPrograms(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib programData = new SystemSettingsLib();
		programData.workSheetName = "CreateProviderForProgram";
		programData.testCaseId = "TC_CP_001";
		programData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProviderForProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	/**
	 * addProviderForProgram
	 * function to add Provider For Program
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     May 17, 2012
	 */
	public boolean addProviderForProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws IOException{
		boolean returnValue=false;
		Selenium selenium=null;
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
			//  Step-3: Go to System Settings and add a Program //
			//--------------------------------------------------------------------//
					
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-4: Delete Exiting  Program //
			//--------------------------------------------------------------------//
			assertTrue(deleteProgram(selenium,providerData),"Could not delete the program"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create Program //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createProgram(selenium,providerData,uniqueName),"Create Program Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Add provider for the program //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(addProviderToProgram(selenium,providerData),"Add Provider failed", selenium, ClassName, MethodName);
			/*assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the organizational structures link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchForProgram(selenium, providerData,uniqueName),"The searched program not found", selenium, ClassName, MethodName);*/
			//--------------------------------------------------------------------//
			//  Step-7: Verify  the saved provider for the program //
			//--------------------------------------------------------------------//
			if(selenium.isTextPresent(providerData.provider))
				returnValue= true;
			else
				returnValue= false;
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the organizational structures link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteProgram(selenium, providerData),"could not delete the program", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString(), selenium, ClassName, MethodName);
			return false;
		}
		return returnValue;
	}
}

