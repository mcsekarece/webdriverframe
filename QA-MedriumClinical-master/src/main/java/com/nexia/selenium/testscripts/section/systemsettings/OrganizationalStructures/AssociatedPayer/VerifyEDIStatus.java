package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures.AssociatedPayer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEDIStatus extends AbstractSystemSettingsTest{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying EDI Status")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void eDIStatus(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_001";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEDIStatus(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify Add Admin Super Bill Set Up
	* @action 		  verify Add Admin Super Bill Set Up
	* @expected       To Ensure that the Add Admin Super Bill Set Up works fine 
	* @Specification  SRS_ADMIN_Provider_Maintenance_Rev0.3
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 17, 2014
	***************************************************************************************************/
	
	public boolean verifyEDIStatus(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to Provider //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			
			assertTrue(gotoSystemSetting(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-4: Search Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnSearchOrg2),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Assoociate Payer //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAddAssociatePayer),"Could not click the Add Associate Payer Link"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify EDI Status Pick List //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,ajxEDIStatus),"Could not click the EDI Status"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent("Electronic"),"Electronic Text is not Present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Paper"),"Paper Text is not Present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Hold"),"Hold Text is not Present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Do not Bill"),"Do not Bill Text is not Present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Electronic"),"Electronic Text is not Present", selenium, ClassName, MethodName);
			
			if(!(isChecked(selenium,chkProviderParticipates))&&(isChecked(selenium,chkProviderAccept))){
				Assert.fail("Check box is not checked ");
			}else
				returnValue = true;
			
			
			
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data" + providerData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
