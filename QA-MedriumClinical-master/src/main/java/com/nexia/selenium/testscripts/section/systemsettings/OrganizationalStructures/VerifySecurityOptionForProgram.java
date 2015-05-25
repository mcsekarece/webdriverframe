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

public class VerifySecurityOptionForProgram extends AbstractSystemSettingsTest{
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
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, deptData.userName, deptData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
						
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
			if(getText(selenium,btnAddProgram).contains("Add New".trim())){
				returnValue= false;
			}else
				return returnValue;
			
			assertTrue(click(selenium,"//div[3]/div/div/div/div[4]/div/div[2]/table/tbody/tr/td/div/div"),"Could not click the link", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,btnEdit1)){
				returnValue=false;
			}else
				return returnValue;
		}
		
		// Full Access		
		if(deptData.testCaseId.equals("TC_VSP_004")){
			SystemSettingsLib programData = new SystemSettingsLib();
			programData.workSheetName = "CreateProgram";
			programData.testCaseId = "TC_CP_001";
			programData.fetchSystemSettingTestData();			
			
			if (selenium.isElementPresent(lnkDeleteProgram))			
			{	
				assertTrue(deleteProgram(selenium,programData),"Could not delete the programs", selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + programData .toString(), selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createProgram(selenium,programData,uniqueName),"Create program failed", selenium, ClassName, MethodName);
			
			Assert.assertTrue(click(selenium,lnkOrgStructures),"Could not navigate to Org Structures");
			waitForPageLoad(selenium);
			
			// Check for Presence of Delete Option
			
			Assert.assertTrue(selenium.isElementPresent(lnkDeleteProgram), "Delete Button Not Present");
			
			
			}
		
		return returnValue;
	}
	
	
	   public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib deptData) throws IOException{
			Selenium selenium=null;
			
			boolean returnValue=true;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + deptData.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, deptData.userName, deptData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
							
				//--------------------------------------------------------------------//
				//  Step-2: change the switch role //
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,deptData.switchRole),"Could not change the switch role;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3: Go to System Setting Options 							  //
				//--------------------------------------------------------------------//			
			    assertTrue(fullViewAccessUserSystemSetting(selenium, deptData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;
							
			    SystemSettingsLib programData = new SystemSettingsLib();
				programData.workSheetName = "CreateProgram";
				programData.testCaseId = "TC_CP_001";
				programData.fetchSystemSettingTestData();
				
				if (selenium.isElementPresent(lnkDeleteProgram))			
				{	
					assertTrue(deleteProgram(selenium,programData),"Could not delete the programs", selenium, ClassName, MethodName);
				}	
				
				assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + programData .toString(), selenium, ClassName, MethodName);

				waitForPageLoad(selenium);
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName=DateFormat.format(cal.getTime());
				waitForPageLoad(selenium);
				assertTrue(createProgram(selenium,programData,uniqueName),"Create program failed", selenium, ClassName, MethodName);	
							        		    
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
								
				Assert.assertTrue(!selenium.isElementPresent(lnkDeleteProgram),"Delete Button is Present");			
				
				
			}catch(RuntimeException e){
				e.printStackTrace();
			}
			return returnValue;
		}		
}
