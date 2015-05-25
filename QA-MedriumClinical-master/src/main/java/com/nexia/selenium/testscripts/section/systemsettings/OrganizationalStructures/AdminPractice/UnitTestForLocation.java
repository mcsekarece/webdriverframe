package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures.AdminPractice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForLocation extends AbstractSystemSettingsTest{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "location Code With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void locationCodeWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_008";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		//addPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "In location section,phone Number 1 With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void locationphoneNumber1WithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_024";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "In location section,phone Number 1 Extention With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void locationphoneNumber1ExtnWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_025";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "In location section,phone Number 2 With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void locationphoneNumberWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_027";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "In location section,phone Number 2 Extention With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void locationphoneNumberExtnWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_028";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "In location section,phone Number 3 With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void locationphoneNumber3WithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_030";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "In location section,phone Number 3 Extention With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void locationphoneNumberExtn3WithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_031";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "business practice Name With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void businessaddress1WithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_032";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "business city With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void businessaddressCityWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_033";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "business Address State With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void businessaddressStateWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_034";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "bussiness Address Zip code With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void businessaddressZipWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_035";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	
	/**
	 * addPractice
	 * function to perform unit test on practice fields
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	    August 13, 2012
	 */
	public boolean addPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest practiceData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + practiceData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, practiceData.userName, practiceData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
		
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			//assertTrue(switchRole(selenium,practiceData.switchRole), "Switch role failed",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Program //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			//click(selenium, lnkSystemSettings);
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,btnAddPractice),"Could not click on add a practice link:" + practiceData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createAdminPacticeUnitTest(selenium,practiceData,uniqueName,userAccount),"Provider failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//
			assertTrue(addLocation_Unit(selenium,practiceData),"Provider failed", selenium, ClassName, MethodName);
			practiceData.alert=practiceData.alert==null?practiceData.alert="":practiceData.alert.trim();
			
			if(!practiceData.alert.equals("")){
				
				if(userAccount.equalsIgnoreCase(CAAccount)){
				    	assertTrue(isElementPresent(selenium, practiceData.alertCA), "The validation message field did not appear", selenium, ClassName, MethodName);
					assertTrue(getText(selenium, practiceData.alertCA).contains(practiceData.alertMessageCa), "The expected validation message should contain the text - "+ practiceData.alertMessage + " The actual validation message shown - " + getText(selenium, practiceData.alert), selenium, ClassName, MethodName);
				}
				else{
				    	assertTrue(isElementPresent(selenium, practiceData.alert), "The validation message field did not appear", selenium, ClassName, MethodName);
					assertTrue(getText(selenium, practiceData.alert).contains(practiceData.alertMessage), "The expected validation message should contain the text - "+ practiceData.alertMessage + " The actual validation message shown - " + getText(selenium, practiceData.alert), selenium, ClassName, MethodName);
				}
			}
			
			/*if(!practiceData.alert.equals("")){
			assertTrue(isElementPresent(selenium, practiceData.alert), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, practiceData.alert).contains(practiceData.alertMessage), "The expected validation message should contain the text - "+ practiceData.alertMessage + " The actual validation message shown - " + getText(selenium, practiceData.alert), selenium, ClassName, MethodName);
			}	*/
		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + practiceData.toString(), selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}
}
