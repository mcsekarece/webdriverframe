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

public class VerifySecurityOptionForDepartment extends AbstractSystemSettingsTest{
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib deptData = new SystemSettingsLib();
		deptData.workSheetName = "VerifySecurityOption";
		deptData.testCaseId = "TC_VSP_004";
		deptData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOptionForLimitedAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, deptData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib deptData = new SystemSettingsLib();
		deptData.workSheetName = "VerifySecurityOption";
		deptData.testCaseId = "TC_VSP_002";
		deptData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, deptData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib deptData = new SystemSettingsLib();
		deptData.workSheetName = "VerifySecurityOption";
		deptData.testCaseId = "TC_VSP_003";
		deptData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, deptData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib deptData = new SystemSettingsLib();
		deptData.workSheetName = "VerifySecurityOption";
		deptData.testCaseId = "TC_VSP_004";
		deptData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, deptData);
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 05, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib deptData) throws IOException{
		Selenium selenium=null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + deptData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, deptData.userName, deptData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,deptData.switchRole),"Could not change the switch role;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(deptData.testCaseId.equals("TC_VSP_003")){				
			assertTrue(noAccessUserSystemSetting(selenium, deptData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
					
			}
						
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!deptData.testCaseId.equals("TC_VSP_003")){
			assertTrue(fullViewAccessUserSystemSetting(selenium, deptData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;				
			
			}		
					
			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,deptData)){
				Assert.fail("Security option not show properly; More Details :"+ deptData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib deptData) throws IOException{
		boolean returnValue=true;
		   
		if(deptData.testCaseId.equals("TC_VSP_002")){
			if(getText(selenium,btnAddDepartment).contains("Add New".trim())){
				returnValue= false;
			}
			else
				return returnValue;
			
			assertTrue(click(selenium,lnkDepartment1),"Could not click the link", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,txtDepartmentName)){
				returnValue=false;
			}else
				return returnValue;
		}
		
		if(deptData.testCaseId.equals("TC_VSP_004")){
			
			deptData.workSheetName = "CreateDepartment";
			deptData.testCaseId = "TC_CD_001";
			deptData.fetchSystemSettingTestData();
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			if (selenium.isElementPresent(lnkDeleteDepartment))					
			{			
				assertTrue(deleteDepartment(selenium,deptData),"Could not delete the department", selenium, ClassName, MethodName);				
			}			
			waitForPageLoad(selenium);
			assertTrue(createDepartment(selenium,deptData,uniqueName),"Could not create the department", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchDepartment(selenium,deptData,uniqueName),"Could not find the department", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnCancel);
			waitForPageLoad(selenium);
			assertTrue(deleteDepartment(selenium,deptData),"Could not delete the department", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib deptData) throws IOException{		Selenium selenium=null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + deptData.toString());			
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, deptData.userName, deptData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,deptData.switchRole),"Could not change the switch role;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Setting Options 							  //
			//--------------------------------------------------------------------//			
		    assertTrue(fullViewAccessUserSystemSetting(selenium, deptData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;
						
		    //--------------------------------------------------------------------//
			//  Step-3:Add a new department 									//
			//--------------------------------------------------------------------//
		    deptData.workSheetName = "CreateDepartment";
			deptData.testCaseId = "TC_CD_001";
			deptData.fetchSystemSettingTestData();
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			
			if (selenium.isElementPresent(lnkDeleteDepartment))	{			
				assertTrue(deleteDepartment(selenium,deptData),"Could not delete the department", selenium, ClassName, MethodName);				
			}			
			waitForPageLoad(selenium);
			assertTrue(createDepartment(selenium,deptData,uniqueName),"Could not create the department", selenium, ClassName, MethodName);
			
		        		    
			//--------------------------------------------------------------------//
			//  Step-6: Switch to Limited Access					 			  //
			//--------------------------------------------------------------------//			
			
			SystemSettingsLib deptData2 = new SystemSettingsLib();
			deptData2.workSheetName = "VerifySecurityOption";
			deptData2.testCaseId = "TC_VSP_001";
			deptData2.fetchSystemSettingTestData();
			waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,deptData2.switchRole),"Could not change the switch role;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Go to System Setting Options  and check for the Absence of Delete  //
			//--------------------------------------------------------------------//			
		    assertTrue(fullViewAccessUserSystemSetting(selenium, deptData2, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;
		    waitForPageLoad(selenium);
		    Assert.assertTrue(click(selenium,lnkOrgStructures),"Could not navigate to Org Structures");
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8: Search for the Absence of Delete 	     				  //
			//--------------------------------------------------------------------//
		
			String departCount=getText(selenium, lnkDepartmentCount);
			System.out.println(departCount);
			
	        String splitStr1 = departCount.replaceAll("[()]","");
	        System.out.println(splitStr1);
	        waitForPageLoad(selenium);
	        int departmentCount = Integer.parseInt(splitStr1);
			
	        if(departmentCount > 0)
	        {		
			assertTrue(selenium.isVisible(lnkDeleteDepartment), ""	+ "Department Delete button is present", selenium, ClassName,MethodName);
			
	        }		
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}		
}
