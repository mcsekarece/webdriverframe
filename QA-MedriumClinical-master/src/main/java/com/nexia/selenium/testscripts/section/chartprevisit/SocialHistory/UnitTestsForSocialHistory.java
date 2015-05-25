package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForSocialHistory extends AbstractChartPreVisit {
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Type With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void typeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest socialData = new ChartPreVisitLibUnitTest();
		socialData.workSheetName = "UnitTest_SocialHistory";
		socialData.testCaseId = "TC_USH_001";
		socialData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Type With Invalid Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void typeWithInvalidValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest socialData = new ChartPreVisitLibUnitTest();
		socialData.workSheetName = "UnitTest_SocialHistory";
		socialData.testCaseId = "TC_USH_002";
		socialData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Status With Invalid Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void statusWithInvalidValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest socialData = new ChartPreVisitLibUnitTest();
		socialData.workSheetName = "UnitTest_SocialHistory";
		socialData.testCaseId = "TC_USH_003";
		socialData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Details Num With alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void detailsNumWithalphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest socialData = new ChartPreVisitLibUnitTest();
		socialData.workSheetName = "UnitTest_SocialHistory";
		socialData.testCaseId = "TC_USH_004";
		socialData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Details period with invalid value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void detailsPeriodWithInvalidValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest socialData = new ChartPreVisitLibUnitTest();
		socialData.workSheetName = "UnitTest_SocialHistory";
		socialData.testCaseId = "TC_USH_005";
		socialData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Years With alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void yearsWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest socialData = new ChartPreVisitLibUnitTest();
		socialData.workSheetName = "UnitTest_SocialHistory";
		socialData.testCaseId = "TC_USH_006";
		socialData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Years With Special Charecters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void yearsWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest socialData = new ChartPreVisitLibUnitTest();
		socialData.workSheetName = "UnitTest_SocialHistory";
		socialData.testCaseId = "TC_USH_007";
		socialData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Start Age With alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void startAgeWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest socialData = new ChartPreVisitLibUnitTest();
		socialData.workSheetName = "UnitTest_SocialHistory";
		socialData.testCaseId = "TC_USH_008";
		socialData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Stopped with invalid values")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void startAgeWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest socialData = new ChartPreVisitLibUnitTest();
		socialData.workSheetName = "UnitTest_SocialHistory";
		socialData.testCaseId = "TC_USH_009";
		socialData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Stopped with invalid values")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void stoppedWithInvalidValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest socialData = new ChartPreVisitLibUnitTest();
		socialData.workSheetName = "UnitTest_SocialHistory";
		socialData.testCaseId = "TC_USH_010";
		socialData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "LifeStage With Invalid value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void lifeStageWithInvalidValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest socialData = new ChartPreVisitLibUnitTest();
		socialData.workSheetName = "UnitTest_SocialHistory";
		socialData.testCaseId = "TC_USH_011";
		socialData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	public boolean addSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest proTestData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proTestData.toString());
			loginForNexiaFromProviderSite(selenium, userAccount, proTestData.userName, proTestData.userPassword);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step 2:Advanced search with Patient ID 										//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,proTestData.patientID);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in Injection //
			//--------------------------------------------------------------------//
			assertTrue(unitTestForSocailHistory(selenium,proTestData),"Procedure Failed",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, proTestData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, proTestData.validationFieldID).contains(proTestData.validationMessage), "The expected validation message should contain the text - "+ proTestData.validationMessage + " The actual validation message shown - " + getText(selenium, proTestData.validationFieldID),selenium, ClassName, MethodName);
			returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + proTestData.toString());
			returnValue=false;
		}
		return returnValue;
	}
}