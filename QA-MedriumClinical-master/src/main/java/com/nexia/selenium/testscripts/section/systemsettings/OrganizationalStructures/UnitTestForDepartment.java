package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForDepartment extends AbstractSystemSettingsTest{
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "department With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void departmentNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest deptData = new SystemsSettingsUnitTest();
		deptData.workSheetName = "UnitTest_SS_Department";
		deptData.testCaseId = "TC_SSD_001";
		deptData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDepartment(seleniumHost, seleniumPort, browser, webSite, userAccount, deptData);
	}
	/**
	 * addDepartment
	 * function to add Department
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public boolean addDepartment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemsSettingsUnitTest deptData) throws Exception{
	
			Selenium selenium=null;
			boolean returnValue=true;
			String alertText="";
			
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
				assertTrue(switchRole(selenium,deptData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-2: Go to System Settings and navigate to Departments //
				//--------------------------------------------------------------------//
				Assert.assertTrue(gotoSystemSetting(selenium));
			    waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnAddDepartment),"Could not click on add a program link:" + deptData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-3: Fill the fields and check for alerts //
				//--------------------------------------------------------------------//
				try {
					if(!addDepartment(selenium, deptData) && deptData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
						if(isElementPresent(selenium,"//p")){
							alertText = getText(selenium, "//p");
							if(alertText.toLowerCase(new java.util.Locale("en", "US")).contains(deptData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US"))))
							{
								return returnValue;			
							}else{
								Assert.fail("An unexpected Alert is displayed with message; The Expected :"+deptData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + deptData.toString());
							}
						}else{
							Assert.fail("Alert is not getting displayed; The Expected :"+deptData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + deptData.toString());
						}	
					}else if(deptData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
						return returnValue;
					}else{
						Assert.fail("Expected Alert is not displayed; The Expected :"+deptData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + deptData.toString());
					}
				
			}catch (InterruptedException e) {
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + deptData.toString(), selenium, ClassName, MethodName);
				returnValue=false;
			}
		}	
		catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + deptData.toString(), selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}
	/**
	 * addDepartment
	 * function to add a Department
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @since  	     may 17, 2012
	 */  
	public boolean addDepartment(Selenium selenium, SystemsSettingsUnitTest deptData ) throws InterruptedException, IOException{
		try{
			assertTrue(type(selenium,txtDepartmentName,deptData.department),"could not type department name", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtdescription,deptData.description),"could not type description name", selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + deptData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "xpath=(//button[@id='add'])[3]")){
				return true;
			}else{
				return false;
			}
				
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + deptData.toString(), selenium, ClassName, MethodName);		
			return false;
		}
	}
}
