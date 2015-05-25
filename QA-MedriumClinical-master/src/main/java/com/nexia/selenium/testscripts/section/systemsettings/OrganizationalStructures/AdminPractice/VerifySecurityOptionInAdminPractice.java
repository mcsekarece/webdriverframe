package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures.AdminPractice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionInAdminPractice extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
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
			
			if(!verifySecurity(selenium,deptData,userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ deptData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib deptData, String userAccount) throws IOException{
		
		boolean returnValue=true;
		
		if(deptData.testCaseId.equals("TC_VSP_002")){
			if(getText(selenium,btnAddPractice).contains("Add New".trim())){
				returnValue= false;
			}else
				return returnValue;
			
			assertTrue(click(selenium,lnkSecPractices),"Could not click the link", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,btnEdit1)){
				returnValue=false;
			}else
				return returnValue;
			
		}
		
		
		if(deptData.testCaseId.equals("TC_VSP_004")){
			SystemSettingsLib pracData = new SystemSettingsLib();
			pracData.workSheetName = "CreatePractice";
			pracData.testCaseId = "TC_CPR_002";
			pracData.fetchSystemSettingTestData();
			type(selenium, txtSearchBox ,pracData.practiceName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSearchBox),"Could not click delete button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			int counter=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(pracData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}
				else {counter++;}
				if(counter>15)
					break;
			}
			//--------------------------------------------------------------------//
			//  Step-4: Add Practice//
			//--------------------------------------------------------------------//
		
			assertTrue(addPracticeWithMandatory(selenium,pracData,userAccount),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,"edit"),"Could not click the edit button"+pracData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search for the Existing Practice 	     				  //
			//--------------------------------------------------------------------//	
			String departCount=getText(selenium, "//span/span/span");
			System.out.println(departCount);
			
	        String splitStr1 = departCount.replaceAll("[()]","");
	        waitForPageLoad(selenium);
	        int practiceCount = Integer.parseInt(splitStr1);
			int count = 1;
			
			if(practiceCount<10){
				while(getText(selenium,vfyDelPractice).contains(deptData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td".toLowerCase(new java.util.Locale("en","US"))).contains(deptData.practiceName.toLowerCase(new java.util.Locale("en","US")))){
						returnValue = true;
						}else{
						counter++;
					}
				}
				
			}else{
				assertTrue(type(selenium,txtSearchBox,pracData.practiceName),"Could not type the first name; More Details"+pracData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnSearchBox),"Could not click delete button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Search for the Presence of Delete Button   				  //
			//--------------------------------------------------------------------//
			
			if(isElementPresent(selenium,lnkDeletePractice)){
				returnValue=true;
			}else{
				returnValue=false;
			}
								
		
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
							

				assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:", selenium, ClassName, MethodName);
				SystemSettingsLib pracData = new SystemSettingsLib();
				pracData.workSheetName = "CreatePractice";
				pracData.testCaseId = "TC_CPR_002";
				pracData.fetchSystemSettingTestData();
				type(selenium, txtSearchBox ,pracData.practiceName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSearchBox),"Could not click delete button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				int counter=1;
				while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
					if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(pracData.practiceName)){
						click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a");
						click(selenium,btnYes);
						waitForPageLoad(selenium);
						
					}
					else {counter++;}
					if(counter>15)
						break;
				}
				//--------------------------------------------------------------------//
				//  Step-4: Add Practice											 //
				//--------------------------------------------------------------------//
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName=DateFormat.format(cal.getTime());
				Assert.assertTrue(click(selenium,btnAddPractice),"Could not find add practice button");
				waitForPageLoad(selenium);
				assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(isElementPresent(selenium,"edit"),"Could not click the edit button"+pracData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				
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
				//  Step-8: Search for the Existing Practice 	     				  //
				//--------------------------------------------------------------------//	
				
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				String departCount=getText(selenium, "//span/span/span");
				System.out.println(departCount);
				
		        String splitStr1 = departCount.replaceAll("[()]","");
		        waitForPageLoad(selenium);
		        int practiceCount = Integer.parseInt(splitStr1);
				int count = 1;
				
				if(practiceCount<10){
					while(getText(selenium,vfyDelPractice).contains(deptData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
						waitForPageLoad(selenium);
						waitForPageLoad(selenium);
						if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td".toLowerCase(new java.util.Locale("en","US"))).contains(deptData.practiceName.toLowerCase(new java.util.Locale("en","US")))){
							returnValue = true;
							}else{
							counter++;
						}
					}
					
				}else{
					assertTrue(type(selenium,txtSearchBox,pracData.practiceName),"Could not type the first name; More Details"+pracData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					assertTrue(click(selenium,btnSearchBox),"Could not click delete button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				//--------------------------------------------------------------------//
				//  Step-9: Search for the Absence of Delete Button    				  //
				//--------------------------------------------------------------------//
				
				if(isElementPresent(selenium,lnkDeletePractice)){
					returnValue=false;
				}else{
					returnValue=true;
				}										
				
			}catch(RuntimeException e){
				e.printStackTrace();
			}
			return returnValue;
		}		
}
