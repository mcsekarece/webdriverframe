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

public class VerifyMixSecurityOptionForDepartment extends AbstractSystemSettingsTest {
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Mix Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminConsentData = new SystemSettingsLib();
		adminConsentData.workSheetName = "VerifySecurityOption";
		adminConsentData.testCaseId = "TC_VSP_006";
		adminConsentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminConsentData);
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib adminConsentData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminConsentData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, adminConsentData.userName, adminConsentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminConsentData.switchRole),"Could not change the switch role;More Details:"+adminConsentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
					
			//--------------------------------------------------------------------//
			//  Step-3: No access User Role 									  //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_016";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.departments.contains("No Access")){			
				assertTrue(noAccessMixSecuritySystemSetting(selenium, adminConsentData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isTextPresent("Departments"),"Department is present",selenium, ClassName, MethodName);
			}			
		
			//--------------------------------------------------------------------//
			//  Step-4: Full, View User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.departments.contains("No Access")){				
				assertTrue(fullViewAccessUserSystemSetting(selenium, adminConsentData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);						
			}
						
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,adminConsentData,userRoleData,userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ adminConsentData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib deptData, SystemSettingsLib userRoleData,String userAccount) throws IOException{
		boolean returnValue=true;
		// Limited Access
		if(userRoleData.departments.contains("Limited Access")){
		    	assertTrue(switchRole(selenium,"DFFullAccess"),"Could not change the switch role;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
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
			
			if (selenium.isElementPresent(lnkDeleteDepartment))					
			{			
				assertTrue(deleteDepartment(selenium,deptData),"Could not delete the department", selenium, ClassName, MethodName);				
			}			
			waitForPageLoad(selenium);
			assertTrue(createDepartment(selenium,deptData,uniqueName),"Could not create the department", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4:Verify the stored values										//
			//--------------------------------------------------------------------//
			assertTrue(searchDepartment(selenium,deptData,uniqueName),"Could not find the department", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		        		    
			//--------------------------------------------------------------------//
			//  Step-6: Switch to Limited Access					 			  //
			//--------------------------------------------------------------------//			
			
			SystemSettingsLib deptData2 = new SystemSettingsLib();
			deptData2.workSheetName = "VerifySecurityOption";
			deptData2.testCaseId = "TC_VSP_001";
			deptData2.fetchSystemSettingTestData();
			waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,deptData.switchRole),"Could not change the switch role;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Go to System Setting Options  and check for the Absence of Delete  //
			//--------------------------------------------------------------------//			
		
			assertTrue(fullViewAccessUserSystemSetting(selenium, deptData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;
			waitForPageLoad(selenium);
		    Assert.assertTrue(click(selenium,lnkOrgStructures),"Could not navigate to Org Structures");
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8: Search for the Absence of Delete 	     				  //
			//--------------------------------------------------------------------//
											
			assertTrue(searchDepartment(selenium,deptData,uniqueName),"Could not find the department", selenium, ClassName, MethodName);
			
			
				click(selenium,btnCancel);
				waitForPageLoad(selenium);
				if(getText(selenium,lblSearchDepartment,10000).toLowerCase(new java.util.Locale("en","US")).trim().contains("Delete")){
					returnValue=false;
				}
				else{
					returnValue=true;	
				}			
		}
		
		// View Only Access
		if(userRoleData.departments.contains("View Only")){
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
			
		// Full Access
		if(userRoleData.departments.contains("Full Access")){
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
}
