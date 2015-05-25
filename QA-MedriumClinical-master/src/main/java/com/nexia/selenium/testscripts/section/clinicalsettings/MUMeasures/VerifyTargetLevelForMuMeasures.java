package com.nexia.selenium.testscripts.section.clinicalsettings.MUMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTargetLevelForMuMeasures extends AbstractClinicalSettings {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_001";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_002";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_003";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForRecordDemographics(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_004";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForPatientEducationResources(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_005";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForVitalSigns(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_006";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForSmokingStatus(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_007";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForCPOE(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_008";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForPatientHealthInformation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_009";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForTimelyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_010";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForClinicalSummaries(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{ 
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_011";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForPatientSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_012";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForeRx(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_013";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTargetLevelForLabs(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_015";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	/**
	 * verifyMeasure
	 * Test for Verify result 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @param muData
	 * @return
	 * @throws IOException 
	 * @since Nov 30, 2012
	 */
	public boolean verifyMeasure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib muData) throws IOException{
		
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
			//  Step-4:Verify Target Level					              //
			//--------------------------------------------------------------------//
			
			if(muData.testCaseId.equals("TC_MU_001")){
				if(!getText(selenium,lbltargetLevel2).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
				
			}
			else if(muData.testCaseId.equals("TC_MU_002")){
				if(!getText(selenium,lbltargetLevel3).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_003")){
				if(!getText(selenium,lbltargetLevel1).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_004")){
				if(!getText(selenium,lbltargetLevel4).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_005")){
				if(!getText(selenium,lbltargetLevel5).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_006")){
				if(!getText(selenium,lbltargetLevel9).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_007")){
				if(!getText(selenium,lbltargetLevel10).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_008")){
				if(!getText(selenium,lbltargetLevel7).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_009")){
				if(!getText(selenium,lbltargetLevel12).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_010")){
				if(!getText(selenium,lbltargetLevel6).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_011")){
				if(!getText(selenium,lbltargetLevel13).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_012")){
				if(!getText(selenium,lbltargetLevel14).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_013")){
				if(!getText(selenium,lbltargetLevel8).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			else if(muData.testCaseId.equals("TC_MU_015")){
				if(!getText(selenium,lbltargetLevel11).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.targetLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue=false;
				}
			}
			
			}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}
