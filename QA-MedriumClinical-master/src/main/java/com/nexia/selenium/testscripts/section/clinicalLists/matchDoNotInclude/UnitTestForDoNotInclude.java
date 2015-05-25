package com.nexia.selenium.testscripts.section.clinicalLists.matchDoNotInclude;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForDoNotInclude extends AbstractClinicalList{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search type with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchTypeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_001";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search type with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchTypeWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_002";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search type with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchTypeWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_003";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search type with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeachTypeWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_004";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Duration condition with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationCondWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_005";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Duration condition with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationConditionWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_006";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Duration condition with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationCondWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_007";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Duration condition with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDuractionWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_008";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Year with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyYearWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_009";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Year with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyYearWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_010";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Year with Special charcter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyYearWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_011";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Year with charcter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyYearWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_012";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Minimum year with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMinYearWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_013";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Minimum year with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMinYearWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_014";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Minimum year with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMinYearWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_015";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Minimum year with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMinYearWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_016";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Minimum is greate than maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMinIsGreaterThanMaxYear(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_017";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Sex condition with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexConditionWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_018";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Sex condition with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexConditionWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_019";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Sex condition with Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexCondWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_020";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Sex condition with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexCondWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_021";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Problem List with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPbmListWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_022";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Problem List with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPbmListWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_023";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Problem list with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPbmListWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_024";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Problem List with numeric charcter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPmbmListWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_025";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Time condition with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTimeCondWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_026";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Time condition with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTimeCondWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_027";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Time condtion with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTimeCondWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_028";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Time condition with numeric character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTimeCondWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_029";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Allergy with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergenWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_030";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Allergy with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergenWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_031";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Allergy with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergenWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_032";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Allergy with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergenWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_033";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period number with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodNumberWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_034";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period number with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodNumberWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_035";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period number with Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodNumberWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_036";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period number with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodNumberWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_037";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_038";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDateWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_039";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDateWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_040";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDateWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_041";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Lab result name with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabResultNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_042";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Lab result name with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabResultNameWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_043";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Lab result name with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabResultNameWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_044";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Lab result name with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabResultNameWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_045";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Medication with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_046";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Medication with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_047";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Medication with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_048";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Medication with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_049";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period condition with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodCondWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_050";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period condition with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodCondWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_051";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period condition with Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodCondWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_052";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Period condition with numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPeriodCondWithNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLibUnitTest doNotIncludeData = new  ClinicalListLibUnitTest();
		doNotIncludeData.workSheetName = "UnitTest_DoNotInclude";
		doNotIncludeData.testCaseId = "TC_DNI_053";
		doNotIncludeData.fetchClinicalListTestData();	
		unitTestForMatchOneOrMore(seleniumHost, seleniumPort, browser, webSite, userAccount, doNotIncludeData);
	} 
	
	/**
	 * unitTestForMatchOneOrMore
	 * Function to test unit test for Match One or more Filter
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @param doNotIncludeData
	 * @throws IOException 
	
	 
	 * @since Nov 26, 2012
	 */
	public boolean unitTestForMatchOneOrMore(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLibUnitTest doNotIncludeData) throws IOException {
		
		Selenium selenium=null;
		boolean returnValue=true;
		int possition = 1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + doNotIncludeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, doNotIncludeData.userName, doNotIncludeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
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
			assertTrue(click(selenium, btnAddNewCriteria2), "Could not click on Add New button for Match All Filter", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in Match All Filter    //
			//--------------------------------------------------------------------//
			
			assertTrue(unitTestForDoNotInclude(selenium,doNotIncludeData,possition),"Match All Unit test Failed", selenium, ClassName, MethodName);
			doNotIncludeData.validationFieldID=doNotIncludeData.validationFieldID==null?doNotIncludeData.validationFieldID = "" : doNotIncludeData.validationFieldID.trim();
			if(!doNotIncludeData.validationFieldID.equals("")){
			assertTrue(isElementPresent(selenium, doNotIncludeData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, doNotIncludeData.validationFieldID).contains(doNotIncludeData.validationMessage), "The expected validation message should contain the text - "+ doNotIncludeData.validationMessage + " The actual validation message shown - " + getText(selenium, doNotIncludeData.validationFieldID), selenium, ClassName, MethodName);
			returnValue=true;
			}
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
