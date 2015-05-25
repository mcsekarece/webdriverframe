package com.nexia.selenium.testscripts.section.clinicalsettings.MUMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;

import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForMUMeasures extends AbstractClinicalSettings{
	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "VerifySecurityOption";
		muData.testCaseId = "TC_VSP_003";
		muData.fetchClinicalSettingsTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "VerifySecurityOption";
		muData.testCaseId = "TC_VSP_001";
		muData.fetchClinicalSettingsTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "VerifySecurityOption";
		muData.testCaseId = "TC_VSP_002";
		muData.fetchClinicalSettingsTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "VerifySecurityOption";
		muData.testCaseId = "TC_VSP_004";
		muData.fetchClinicalSettingsTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 17, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib muData) throws IOException{
		Selenium selenium=null;
	
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + muData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, muData.userName, muData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,muData.switchRole),"Could not change the switch role;More Details:"+muData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to Meaningful measures								  //
			//--------------------------------------------------------------------//
			if(muData.testCaseId.equals("TC_VSP_003")){
				assertTrue(click(selenium, lnkQuickLink), "Could not click on Quick Actions",selenium,ClassName,MethodName);
				if(isElementPresent(selenium,lnkClinicalList)){
					Assert.fail("Clinical lists are visible to No Access user");
				}
				else
					return true;
				
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			}
			
			assertTrue(goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Security Option								  //
			//--------------------------------------------------------------------//
			if(!verifySecurityAccess(selenium,muData)){
				Assert.fail("Security option not show properly; More Details :"+ muData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	String resultList=null;
	public boolean verifySecurityAccess(Selenium selenium,ClinicalSettingLib muData){
		
		boolean returnValue=true;
		
		if(muData.testCaseId.equals("TC_VSP_004")){
			muData.workSheetName = "MUMeasures";
			muData.testCaseId = "TC_MU_001";
			muData.fetchClinicalSettingsTestData();
			try {
				assertTrue(verifyMeasure(selenium, muData), "Could not enter required values",selenium,ClassName,MethodName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(isElementPresent(selenium,lnkExpandAll))
			return returnValue;
			else
				returnValue=false;
		}
		
		if(muData.testCaseId.equals("TC_VSP_001")){
			muData.workSheetName = "MUMeasures";
			muData.testCaseId = "TC_MU_001";
			muData.fetchClinicalSettingsTestData();
			try {
				assertTrue(verifyMeasure(selenium, muData), "Could not enter required values",selenium,ClassName,MethodName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(isElementPresent(selenium,lnkExpandAll))
			return returnValue;
			else
				returnValue=false;
		}
		
		if(muData.testCaseId.equals("TC_VSP_002")){
			muData.workSheetName = "MUMeasures";
			muData.testCaseId = "TC_MU_001";
			muData.fetchClinicalSettingsTestData();
			try {
				assertTrue(verifyMeasure(selenium, muData), "Could not enter required values",selenium,ClassName,MethodName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(isElementPresent(selenium,lnkExpandAll))
			return returnValue;
			else
				returnValue=false;
		}
		
		
		
		return returnValue;
	}
}
