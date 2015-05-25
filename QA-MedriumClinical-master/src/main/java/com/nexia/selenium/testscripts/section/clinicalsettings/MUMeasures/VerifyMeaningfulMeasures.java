package com.nexia.selenium.testscripts.section.clinicalsettings.MUMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;


public class VerifyMeaningfulMeasures extends AbstractClinicalSettings {
	@Test(groups = {"AdvancedSmokeSingle","SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_001";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_002";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_003";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForRecordDemographics(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_004";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForPatientEducationResources(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_005";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForSmokingStatus(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_007";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForTimelyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_010";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForPatientSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_012";
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
	int metricResult=0;
	String resultList=null;
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
		try {
			assertTrue(verifyMeasure(selenium, muData), "Could not enter required values",selenium,ClassName,MethodName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//--------------------------------------------------------------------//
		//  Step-4: Connect with database						              //
		//--------------------------------------------------------------------//
		if(isElementPresent(selenium, btnErrorClose))
        {
			assertTrue(click(selenium, btnErrorClose),"Could not click ",selenium, ClassName, MethodName);
			}

		metricResult=connectPostgres(metricResult,muData,webSite);
		
		if(muData.testCaseId.equals("TC_MU_001")){
			resultList = getText(selenium, lblResultList2);
			Assert.assertTrue(click(selenium, lblResultList2), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
			
		}
		else if(muData.testCaseId.equals("TC_MU_002")){
			resultList = getText(selenium, lblResultList3);
			Assert.assertTrue(click(selenium, lblResultList3), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_003")){
			resultList = getText(selenium, lblResultList1);
			Assert.assertTrue(click(selenium, lblResultList1), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_004")){
			resultList = getText(selenium,lblResultList4);
			Assert.assertTrue(click(selenium, lblResultList4), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_005")){
			resultList = getText(selenium, lblResultList5);
			Assert.assertTrue(click(selenium, lblResultList5), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_006")){
			resultList = getText(selenium, lblResultList9);
			Assert.assertTrue(click(selenium, lblResultList9), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_007")){
			resultList = getText(selenium, lblResultList10);
			Assert.assertTrue(click(selenium, lblResultList10), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_008")){
			resultList = getText(selenium, lblResultList7);
			Assert.assertTrue(click(selenium, lblResultList7), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_009")){
			resultList = getText(selenium, lblResultList12);
			Assert.assertTrue(click(selenium, lblResultList12), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_010")){
			resultList = getText(selenium, lblResultList6);
			Assert.assertTrue(click(selenium, lblResultList6), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_011")){
			resultList = getText(selenium, lblResultList13);
			Assert.assertTrue(click(selenium, lblResultList13), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_012")){
			resultList = getText(selenium, lblResultList14);
			Assert.assertTrue(click(selenium, lblResultList14), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_013")){
			resultList = getText(selenium, lblResultList8);
			Assert.assertTrue(click(selenium, lblResultList8), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		else if(muData.testCaseId.equals("TC_MU_015")){
			resultList = getText(selenium, lblResultList11);
			Assert.assertTrue(click(selenium, lblResultList11), "Could not enter required values");
			if(!getText(selenium,lblMeasureInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(muData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
		}
		System.out.println("Active medication list = "+resultList);
		String[] splitS = resultList.split("%");
		int metricResult1 = Integer.parseInt(splitS[0]);
		System.out.println("UImetricResult="+metricResult1);
		
		//--------------------------------------------------------------------//
		//  Step-4: Verify the metric result						          //
		//--------------------------------------------------------------------//
		
		if(metricResult==metricResult1){
			if(metricResult1<100){
			returnValue=true;
			}
			else {
			  Assert.fail("Metric result is incorrect");
			}		
		}
		else {
		    Assert.fail("Metric result is incorrect");
		    returnValue=false;
		}
		
	}catch(RuntimeException e){
		e.printStackTrace();
	}
	return returnValue;
}

}


