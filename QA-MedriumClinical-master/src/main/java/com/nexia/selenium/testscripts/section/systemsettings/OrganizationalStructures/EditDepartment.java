package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class EditDepartment extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for editing a created department ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editDepartment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib deptData = new SystemSettingsLib();
		deptData.workSheetName = "CreateDepartment";
		deptData.testCaseId = "TC_CD_001";
		deptData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editDepartment(seleniumHost, seleniumPort, browser, webSite, userAccount, deptData);
	}
	/**
	 * editDepartment
	 * function to editDepartment
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public boolean editDepartment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib deptData) throws Exception{
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
				//  Step-2: Go to System Settings and navigate to Departments //
				//--------------------------------------------------------------------//				
				Assert.assertTrue(gotoSystemSetting(selenium));
			    waitForPageLoad(selenium);					
				//--------------------------------------------------------------------//
				//  Step-3: Create a department //
				//--------------------------------------------------------------------//
				assertTrue(deleteDepartment(selenium,deptData),"Could not delete the department", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName=DateFormat.format(cal.getTime());
				assertTrue(createDepartment(selenium,deptData,uniqueName),"Could not create the department", selenium, ClassName, MethodName);
				
				deptData.workSheetName="EditDepartment";
				deptData.testCaseId="TC_ED_001";
				deptData.fetchSystemSettingTestData();
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-4:Edit the department //
				//--------------------------------------------------------------------//
				assertTrue(searchDepartment(selenium,deptData,uniqueName),"Could not find the department", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			    cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName1=DateFormat.format(cal.getTime());
				assertTrue(editDepartment(selenium,deptData,uniqueName1),"Could not edit the department", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-5:Verify the stored values in the department //
				//--------------------------------------------------------------------//
				assertTrue(searchDepartment(selenium,deptData,uniqueName1),"Could not find the department", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!verifyStoredValues(selenium,deptData)){
					Assert.fail("Program details not edited properly; More Details :"+ deptData.toString());
					returnValue=false;
				}else
					return returnValue;
			}
			catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"+ deptData.toString(), selenium, ClassName, MethodName);
			}
		return returnValue;
		}
	
	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib programData){

		if(!getValue(selenium,txtDepartmentName).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.department.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtdescription).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
			return true;
		}
	}

