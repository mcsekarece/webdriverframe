package com.nexia.selenium.testscripts.section.clinicalLists.matchAll;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;

import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLibUnitTest;
import com.thoughtworks.selenium.Selenium;


public class UnitTestForMatchAll extends AbstractClinicalList{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search type with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchTypeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_001";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search type with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchTypeWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_002";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search type with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchTypeWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_003";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search type with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeachTypeWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_004";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Duration condition with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationCondWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_005";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Duration condition with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationConditionWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_006";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Duration condition with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationCondWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_007";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Duration condition with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDuractionWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_008";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Year with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyYearWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_009";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Year with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyYearWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_010";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Year with Special charcter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyYearWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_011";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Year with charcter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyYearWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_012";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Minimum year with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMinYearWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_013";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Minimum year with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMinYearWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_014";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Minimum year with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMinYearWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_015";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Minimum year with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMinYearWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_016";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Minimum is greate than maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMinIsGreaterThanMaxYear(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_017";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Sex condition with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexConditionWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_018";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Sex condition with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexConditionWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_019";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Sex condition with Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexCondWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_020";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Sex condition with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexCondWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_021";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Problem List with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPbmListWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_022";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Problem List with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPbmListWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_023";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Problem list with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPbmListWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_024";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Problem List with numeric charcter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPmbmListWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_025";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Time condition with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTimeCondWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_026";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Time condition with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTimeCondWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_027";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Time condtion with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTimeCondWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_028";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Time condition with numeric character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTimeCondWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_029";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Allergy with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergenWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_030";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Allergy with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergenWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_031";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Allergy with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergenWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_032";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Allergy with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergenWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_033";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period number with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodNumberWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_034";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period number with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodNumberWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_035";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period number with Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodNumberWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_036";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period number with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodNumberWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_037";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_038";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDateWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_039";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDateWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_040";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDateWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_041";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Lab result name with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabResultNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_042";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Lab result name with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabResultNameWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_043";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Lab result name with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabResultNameWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_044";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Lab result name with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabResultNameWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_045";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Medication with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_046";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Medication with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_047";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Medication with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_048";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Medication with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_049";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period condition with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodCondWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_050";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period condition with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodCondWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_051";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period condition with Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodCondWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_052";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period condition with numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodCondWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest matchAllData = new  ClinicalListLibUnitTest();
		matchAllData.workSheetName = "UnitTest_MatchAll";
		matchAllData.testCaseId = "TC_UMA_053";
		matchAllData.fetchClinicalListTestData();	
		unitTestForMatchAll(seleniumHost, seleniumPort, browser, webSite, userAccount, matchAllData);
	} 
	
	/**
	 * unitTestForMatchAll
	 * Function to test unit test for match All
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @param matchAllData
	 * @throws IOException 
	 * @since Nov 26, 2012
	 */
	public boolean unitTestForMatchAll(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLibUnitTest matchAllData) throws IOException{
		
		Selenium selenium=null;
		String data;
		int count=0;
		int count1=0;
		int possition = 1;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + matchAllData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, matchAllData.userName, matchAllData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium, lblError)){
				click(selenium, btnErrorClose);
			}
			//--------------------------------------------------------------------//
			//  Step-2: Go to Clinical List										  //
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalLists(selenium), "Could not open Clinical lists", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, btnNewSearch), "Could not click on New Search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Click on Add new under Match All Filter   			      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in Match All Filter    //
			//--------------------------------------------------------------------//
			assertTrue(unitTestForMatchAll(selenium,matchAllData,possition),"Match All Unit test Failed", selenium, ClassName, MethodName);
			matchAllData.validationFieldID=matchAllData.validationFieldID==null?matchAllData.validationFieldID = "" : matchAllData.validationFieldID.trim();
			if(!matchAllData.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium, matchAllData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
				assertTrue(getText(selenium, matchAllData.validationFieldID).contains(matchAllData.validationMessage), "The expected validation message should contain the text - "+ matchAllData.validationMessage + " The actual validation message shown - " + getText(selenium, matchAllData.validationFieldID), selenium, ClassName, MethodName);
				returnValue=true;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
