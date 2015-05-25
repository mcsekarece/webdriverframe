package com.nexia.selenium.testscripts.section.clinicalsettings.MUMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPrintOption extends AbstractClinicalSettings {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrintOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_001";
		muData.fetchClinicalSettingsTestData();
		verifyPrint(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrintOptionWithNoMetric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_002";
		muData.fetchClinicalSettingsTestData();
		verifyPrint(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrintOptionAfterLeavingFromScreen(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_003";
		muData.fetchClinicalSettingsTestData();
		verifyPrint(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	/**
	 * verifyPrint
	 * Test for Verify result 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @param muData
	 * @throws IOException 
	 * @since Dec 19, 2012
	 */
	public boolean verifyPrint(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib muData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + muData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, muData.userName, muData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Meaningful measures								  //
			//--------------------------------------------------------------------//
			assertTrue(goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(verifyMeasure(selenium, muData), "Could not enter required values",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Print Option
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnPrint), "Could not enter show result from date",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(muData.testCaseId.equals("TC_MU_003")){
				assertTrue(click(selenium, btnBack), "Could not enter show result from date",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
				assertTrue(verifyMeasure(selenium, muData), "Could not enter required values",selenium,ClassName,MethodName);
				if(isElementPresent(selenium,btnEditSave)){
					return false;
				}
				else return true;
			}
			
			if(isElementPresent(selenium,btnEditSave)){
				if(muData.testCaseId.equals("TC_MU_002")){
					assertTrue(click(selenium, btnEditSave), "Could not enter show result from date",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					if(getText(selenium,lblAlert).trim().contains("No Measure is selected, Please select Measures you want to print".trim())){
						return returnValue;
					}
					else returnValue=false;
				}
				else return returnValue;
			}
			else returnValue=false;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}
