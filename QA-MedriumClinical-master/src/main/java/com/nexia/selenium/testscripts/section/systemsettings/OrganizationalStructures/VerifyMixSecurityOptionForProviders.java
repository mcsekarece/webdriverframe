package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForProviders  extends AbstractSystemSettingsTest {
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
			
			if(userRoleData.providers.contains("No Access")){			
				assertTrue(noAccessMixSecuritySystemSetting(selenium, adminConsentData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isTextPresent("Providers"),"Providers are present",selenium, ClassName, MethodName);
			}			
		
			//--------------------------------------------------------------------//
			//  Step-4: Full, View User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.providers.contains("No Access")){				
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
		if(userRoleData.providers.contains("Limited Access")){
		  //--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,userRoleData.switchRole),"Could not change the switch role;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Setting Options 							  //
			//--------------------------------------------------------------------//			
			assertTrue(fullViewAccessUserSystemSetting(selenium, deptData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;
						

			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:", selenium, ClassName, MethodName);
			SystemSettingsLib providerData = new SystemSettingsLib();
			providerData.workSheetName = "CreateProvider";
			providerData.testCaseId = "TC_PO_001";
			providerData.fetchSystemSettingTestData();
			waitForPageLoad(selenium);
			
			if (selenium.isElementPresent(lnkDeleteProvider)){			
				assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
			}			
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Create Provider //
			//--------------------------------------------------------------------//

			assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProviderWithMandatory(selenium,providerData),"Provider creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			
			if(selenium.isVisible(txtProviderSearchbox)){
				
				//--------------------------------------------------------------------//
				//  Step-9: Search Provider //
				//--------------------------------------------------------------------//
				assertTrue(type(selenium,txtProviderSearchbox,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
				assertTrue(click(selenium,btnProviderSearch),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);					
				
			}				

			assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,btnEdit1),"Could not click the edit button"+providerData.toString(), selenium, ClassName, MethodName);
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
							
			if(selenium.isVisible(txtProviderSearchbox)){					
			//--------------------------------------------------------------------//
			//  Step-8: Search Provider //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtProviderSearchbox,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			assertTrue(click(selenium,btnProviderSearch),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);					
			}				

			//--------------------------------------------------------------------//
			//  Step-9: Search for the Absence of Delete 	     				  //
			//--------------------------------------------------------------------//			
			
			assertTrue(!isElementPresent(selenium,lnkDeleteProv),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			
		}
		
		// View Only Access
		if(userRoleData.providers.contains("View Only")){
		    if(getText(selenium,btnDelete2).contains("Delete".trim())){
			returnValue= false;
		    }
		    else
			return returnValue;
		
		    assertTrue(click(selenium,lnkSecProviders),"Could not click the link", selenium, ClassName, MethodName);
		
		    if(isElementPresent(selenium,btnEdit1)){
			returnValue=false;
		    }else
			return returnValue;
		}
			
		// Full Access
		if(userRoleData.providers.contains("Full Access")){

			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:", selenium, ClassName, MethodName);
			SystemSettingsLib providerData = new SystemSettingsLib();
			providerData.workSheetName = "CreateProvider";
			providerData.testCaseId = "TC_PO_001";
			providerData.fetchSystemSettingTestData();
			waitForPageLoad(selenium);			
			if (selenium.isElementPresent(lnkDeleteProvider)){			
				assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);						
			}
			
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Create Provider //
			//--------------------------------------------------------------------//

			assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProviderWithMandatory(selenium,providerData),"Provider creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			
			if(selenium.isVisible(txtProFirstName)){
				
			//--------------------------------------------------------------------//
			//  Step-9: Search Provider //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtProFirstName,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			assertTrue(click(selenium,btnSearchOrg2),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);					
				
			}
									
			if(getText(selenium,txtFirstName2,10000).trim().contains("Delete")){
				returnValue=true;	
			}
			else{
				returnValue=false;
			}	
			
			assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,btnEdit1),"Could not click the edit button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
		}
		
		return returnValue;
	}
}
