package com.nexia.selenium.testscripts.section.clinicalsettings.MUMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForMUMeasures extends AbstractClinicalSettings{

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProvideWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_001";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_002";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_003";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_004";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "From Date with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFromDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_005";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "From date with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFromDateWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_006";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "From date with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFromDateWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_007";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "From date with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFromDateWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_008";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "To Date with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyToDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_009";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "To date with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyToDateWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_010";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "To date with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyToDateWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_011";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "To date with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyToDateWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_012";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "To date with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyToDateWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingUnitTest muData = new  ClinicalSettingUnitTest();
		muData.workSheetName = "UnitTest_MUMeasures";
		muData.testCaseId = "TC_MUM_013";
		muData.fetchClinicalSettingsTestData();	
		unitTestForMU(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 
	/**
	 * unitTestForMU
	 * function to test unit test for meaningful use measures
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @throws IOException 
	 * @since Nov 28, 2012
	 */
	public boolean unitTestForMU(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingUnitTest muData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + muData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, "testingtester", "aspire@55"),"Login Failed ");
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Meaningful measures								  //
			//--------------------------------------------------------------------//
			try {
				assertTrue(goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//--------------------------------------------------------------------------//
			// step 3:perform unit test for various fields in Meaningful use measures   //
			//--------------------------------------------------------------------------//
			try {
				assertTrue(unitTestForMU(selenium,muData),"Meaningful use measures Unit test Failed",selenium,ClassName,MethodName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			muData.validationFieldID=muData.validationFieldID==null?muData.validationFieldID = "" : muData.validationFieldID.trim();
			
			if(!muData.validationFieldID.equals("")){
			assertTrue(isElementPresent(selenium, muData.validationFieldID), "The validation message field did not appear",selenium,ClassName,MethodName);
			assertTrue(getText(selenium, muData.validationFieldID).contains(muData.validationMessage), "The expected validation message should contain the text - "+ muData.validationMessage + " The actual validation message shown - " + getText(selenium, muData.validationFieldID),selenium,ClassName,MethodName);
			returnValue=true;
			}
		
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}
