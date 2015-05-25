package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDuplicateEntryForDepartment extends AbstractSystemSettingsTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for creating a department ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void duplicateEntryForDepartment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib deptData = new SystemSettingsLib();
		deptData.workSheetName = "CreateDepartment";
		deptData.testCaseId = "TC_CD_001";
		deptData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyDuplicateEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, deptData);
	}
	/**
	 * createDepartment
	 * function to  create Department
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @defect      #8002
	 * @since  	    Jan 03, 2014
	 */
	public boolean VerifyDuplicateEntry(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib deptData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + deptData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, deptData.userName, deptData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			/*assertTrue(switchRole(selenium,deptData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings 									 //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
				
			//--------------------------------------------------------------------//
			//  Step-4: Delete Department									 //
			//--------------------------------------------------------------------//
		    assertTrue(deleteDepartment(selenium,deptData),"Could not delete the department", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);	
		    
		    //--------------------------------------------------------------------//
			//  Step-5:Add a new department 									//
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createDepartment(selenium,deptData,uniqueName),"Could not create the department", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-6:Add a new department 									//
			//--------------------------------------------------------------------//
			deptData.workSheetName = "CreateDepartment";
			deptData.testCaseId = "TC_CD_004";
			deptData.fetchSystemSettingTestData();
			assertTrue(createDepartment(selenium,deptData,uniqueName),"Could not create the department", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			if(!selenium.isTextPresent("Department already exists, please choose another.")){
				Assert.fail("Duplicate Warning is not getting displayed.");
			}
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + deptData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
