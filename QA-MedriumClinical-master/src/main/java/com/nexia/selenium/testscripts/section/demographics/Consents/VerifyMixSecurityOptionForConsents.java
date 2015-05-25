package com.nexia.selenium.testscripts.section.demographics.Consents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForConsents extends AbstractHomeTest{
	
	@Test(groups = {"RegressionUS","Developing","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib consentData = new HomeLib();
		consentData.workSheetName = "VerifySecurityOption";
		consentData.testCaseId = "TC_VSP_006";
		consentData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, consentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify default values for consents
	* @action 		  Verifying default values for consents
	* @author         Jagmit Singh
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      Nov 05, 2013
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, consentData.userName, consentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,consentData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									 //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_014";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.consents.contains("No Access")){
				
				assertTrue(searchPatientNexiaMixSecurityNoAccess(selenium,consentData.patientId),"Could search patient", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkConsentsPatient),"Consent link is Visible", selenium, ClassName, MethodName);							
			}	
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to cases //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.consents.contains("No Access")){
				  
				searchPatientNexiaForProviderHomePage(selenium,consentData.patientId);
				waitForPageLoad(selenium);					
				assertTrue(click(selenium,lnkConsentsPatient),"Could not click the cases", selenium, ClassName, MethodName);	
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}	
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,userRoleData,consentData)){
				Assert.fail("Security option not show properly; More Details :"+ consentData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib userRoleData,HomeLib consentData) throws IOException{
		
		// Limited Access
		
		if(userRoleData.consents.contains("Limited Access")){
					
			assertTrue(selenium.isElementPresent(btnConsentsAdd),"Add Button is visible",selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(btnDeleteConsents),"Delete Button is visible",selenium, ClassName, MethodName);
		 }
				
		// View Only Access
				
		if(userRoleData.consents.contains("View Only")){
											
			assertTrue(!selenium.isElementPresent(btnAddConsents),"Add Button is visible",selenium, ClassName, MethodName);
		    assertTrue(!selenium.isElementPresent(btnDeleteConsents),"Delete Button is visible",selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(btnEditConsents),"Edit Button is visible",selenium, ClassName, MethodName);
		}
				
		// Full Access
				
		if(userRoleData.consents.contains("Full Access")){
			consentData.workSheetName = "NewConsent";
			consentData.testCaseId = "TC_NC_001";
			consentData.fetchHomeTestData();
					
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click on quick actions:" + consentData .toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSecuritysetting),"Could not click the System settings link;More Details:"+consentData.toString(), selenium, ClassName, MethodName);
			/*assertTrue(click(selenium,lnkSecuritySetting),"Could not click the System settings link;More Details:"+consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
					
			HomeLib ssConsentsData = new  HomeLib();
			ssConsentsData.workSheetName = "SSConsents";
			ssConsentsData.testCaseId = "TC_SSC_001";
			ssConsentsData.fetchHomeTestData();
			waitForPageLoad(selenium);
					
			assertTrue(click(selenium,lnkConsents),"Could not click the Admin consent; More details"+ssConsentsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			assertTrue(click(selenium,btnAddConsents),"Could not click the Admin consent; More details"+ssConsentsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			assertTrue(createSSConsents(selenium,ssConsentsData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,consentData.patientID);
			waitForPageLoad(selenium);
				
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			if(consentData.testCaseId.equalsIgnoreCase("TC_NC_002")){
			consentData.workSheetName = "NewConsent";
			consentData.testCaseId = "TC_NC_002";
			consentData.fetchHomeTestData();
			}
			//--------------------------------------------------------------------//
			//  Step-6: Create a new Consent                                        //
			//--------------------------------------------------------------------//
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createConsent(selenium,consentData),"Consents creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(selenium.isElementPresent(btnAddDemoConsents),"Add Button is visible",selenium, ClassName, MethodName);
			assertTrue(selenium.isElementPresent(btnDeleteConsents),"Delete Button is visible",selenium, ClassName, MethodName);
			assertTrue(selenium.isElementPresent(btnEditConsents),"Edit Button is visible",selenium, ClassName, MethodName);			
			
			}		
		
		return true;
	}
}