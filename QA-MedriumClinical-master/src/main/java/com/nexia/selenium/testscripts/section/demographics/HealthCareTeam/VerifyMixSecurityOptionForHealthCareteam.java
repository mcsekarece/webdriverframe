package com.nexia.selenium.testscripts.section.demographics.HealthCareTeam;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForHealthCareteam extends AbstractHomeTest{	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib healthTestData = new HomeLib();
		healthTestData.workSheetName = "VerifySecurityOption";
		healthTestData.testCaseId = "TC_VSP_006";
		healthTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option In Health Care Team
	* @action 		  Verifying Security Option In Health Care Team
	* @author         Jagmit Singh
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 5th, 2013
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib healthTestData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + healthTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, healthTestData.userName, healthTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,healthTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									 //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_014";
			userRoleData.fetchSystemSettingTestData();
							
			if(userRoleData.healthCareTeam.contains("No Access")){
				assertTrue(searchPatientNexiaMixSecurityNoAccess(selenium,healthTestData.patientId),"Could search patient", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkPatientHealthcare),"Healthcare team link is Visible", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);								
			}				
		
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Health Care Team							  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.healthCareTeam.contains("No Access")){				
				searchPatientNexiaForProviderHomePage(selenium,healthTestData.patientId);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkPatientHealthcare),"Could not click the Health care team", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}		
				
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,userRoleData,healthTestData, healthTestData,userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ healthTestData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib userRoleData, HomeLib healthTestData,HomeLib epData, String userAccount) throws IOException{
				
		// Limited Access
		if(userRoleData.healthCareTeam.contains("Limited Access")){			
			healthTestData.workSheetName = "EditHealthCareTeam";
			healthTestData.testCaseId = "TC_HCT_001";
			healthTestData.fetchHomeTestData();
			assertTrue(click(selenium,btnEdit),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "link=Continue")){
				click(selenium, "link=Continue");
			}
			
			assertTrue(createHealthCare(selenium,healthTestData,epData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			if(isElementPresent(selenium,"//a[contains(text(),'Delete')]")){
				return false;
			}else
				return true;
		}
		
		// View Only Access
		if(userRoleData.healthCareTeam.contains("View Only")){
			if(selenium.isVisible(btnEdit)){	
				return false;
			}else
				return true;
		}
		
		// Full Access
		if(userRoleData.healthCareTeam.contains("Full Access")){
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			
			HomeLib epData1 = new  HomeLib();
			epData1.workSheetName = "AdminHealthCareTeam";
			epData1.testCaseId = "TC_HCTA_001";
			epData1.fetchHomeTestData();
			
			//---------------------------------------------------------- ----------//
			//  Step-4:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,healthTestData.patientId);
			waitForPageLoad(selenium);
			
			
			//Create a new Health Care Team
			click(selenium,lnkPatientHealthcare);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllHealthCareteam(selenium,epData1,userAccount),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEdit),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			healthTestData.workSheetName = "EditHealthCareTeam";
			healthTestData.testCaseId = "TC_HCT_001";
			healthTestData.fetchHomeTestData();
			assertTrue(createHealthCare(selenium,healthTestData,epData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//a[contains(text(),'Delete')]")){
				 return true;
			}else
				return false;
		}
		return true;
	}
}