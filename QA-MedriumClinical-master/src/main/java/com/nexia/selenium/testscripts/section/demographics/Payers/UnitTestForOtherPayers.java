package com.nexia.selenium.testscripts.section.demographics.Payers;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;

import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForOtherPayers extends AbstractHomeTest {
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify PayerName with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})

	public void verifyPayerNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_001";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify PayerName with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})

	public void verifyPayerNameWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_002";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For verify StartDate With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_003";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For verify StartDate With Numerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithNumerals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_004";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For verify StartDate With Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_005";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For verify StartDate With SpecialCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_006";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For verify StartDate With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_007";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For verify EndDate With Numerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithNumerals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_008";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For verify EndDate With Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_009";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For verify EndDate With SpecialCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_010";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For verify EndDate With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_011";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Co-Pay With Negative Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoPayWithNegativeValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_013";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Co-Pay With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoPayWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_014";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify SpecialistCo-Pay With Negative Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifySpecialistCoPayWithNegativeValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_015";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify SpecialistCo-Pay With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifySpecialistCoPayWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_016";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Deductile with Negative Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeductilewithNegativeValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_017";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Deductile with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeductilewithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_018";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Co-Insurance With Negative Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoInsuranceWithNegativeValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_019";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Co-Insurance With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoInsuranceWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_020";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify BillingAddress1 with Special Charactres")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingAddress1withSpecialCharactres(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_021";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify BillingAddress2 with Special Charactres")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingAddress2withSpecialCharactres(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_022";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Billing State with Numerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingStatewithNumeralsCA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_023";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Billing State withSpecialCharactres")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyBillingStatewithSpecialCharactresCA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_024";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify BillingCountry with Numerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyBillingCountrywithNumerals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_025";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Billing Country with Special Charactres")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingCountrywithSpecialCharactres(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_026";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Billing Zipcode with Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingZipcodewithAlphabetsCA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_027";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Billing Zipcode with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingZipcodewithInvalidCA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_028";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify RelationShip Status Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationShipStatusEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_029";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify RelationShip Status with Numerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationShipStatuswithNumerals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_030";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify RelationShip Status with Special Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationShipStatuswithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_031";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify RelationAddress1 with Special Charactres")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationAddress1withSpecialCharactres(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_032";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify RelationAddress2 with Special Charactres")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationAddress2withSpecialCharactres(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_033";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For VerifyRelation State With Numerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationStateWithNumeralsCA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_034";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}

	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For VerifyRelation State With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationStateWithInvalidCA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_035";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Relation ZipCode With Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationZipCodeWithAlphabetsCA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_036";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Relation ZipCode With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationZipCodeWithInvalidCA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_037";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify RelationCountry With Numerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationCountryWithNumerals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_038";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify RelationCountry With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationCountryWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_039";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify RelationSex With Numerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationSexWithNumerals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_040";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify RelationSex With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationSexWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_041";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Date Of Birth With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDateOfBirthWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_042";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Date Of Birth With Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDateOfBirthWithAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_043";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify TypeofCoverage with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTypeofCoveragewithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_044";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify TypeofCoverage with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTypeofCoveragewithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_045";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Billing Address1 with AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingAddress1withAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_046";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Billing Address1 with AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingAddress2withAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_047";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For VerifyRelationAddress1withAlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationAddress1withAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_048";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For VerifyRelationAddress1withAlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationAddress2withAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_049";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = { "RegressionUnit", "Approved", "firefox", "iexplore", "safari","default" }, description = "Unit Test For VerifyRelationAddress1withAlphaNumeric")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite","userAccount" })
	public void verifyEndDateWithStartDate(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_059";
		payerData.fetchHomeTestData();
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount,payerData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify Unit Test For Payers
	* @action 		  Unit Test For Payers
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct  03, 2013
	***************************************************************************************************/
	
	public boolean createPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest payerData) throws IOException{
		Selenium selenium=null;
		String date =null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + payerData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, payerData.userName, payerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                         //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,payerData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2:Search Patient //
			//--------------------------------------------------------------------//
			
			assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Other Payers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnPatientOtherPayers),"Could not click the Other Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Payers //
			//--------------------------------------------------------------------//
			
				assertTrue(click(selenium, btnAddNewForOtherPayer), "Could not click New button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
						
//			for(int i =1;i<10;i++){
//			selenium.focus(btnAddNew);
//			selenium.clickAt(btnAddNew, "");
//			selenium.keyPress(btnAddNew, "\\13");
//		    }
				
			if (payerData.validationFieldID.equals("Date1")) {

				checkDateField(selenium, payerData, userAccount);

			} else {
				assertTrue(
						UnitTestForOtherPayers(selenium, payerData, date,
								userAccount),
						"Unit Test For Medical Payers failed", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
//			assertTrue(UnitTestForOtherPayers(selenium,payerData,date,userAccount),"Unit Test For Payers failed",selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			
            payerData.validationFieldID = payerData.validationFieldID == null ? payerData.validationFieldID ="" : payerData.validationFieldID.trim();
            if(!payerData.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium, payerData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium, payerData.validationFieldID).contains(payerData.validationMessage), "The expected validation message should contain the text - "+ payerData.validationMessage + " The actual validation message shown - " + getText(selenium, payerData.validationFieldID),selenium, ClassName, MethodName);
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	private void checkDateField(Selenium selenium, HomeLibUnitTest payerData,
			String account) throws IOException {
		
		txtPayerEndDate="xpath=(//input[@type='text'])[14]";
		txtRelationDob="xpath=(//input[@type='text'])[35]";
				
		assertTrue(selectValueFromAjaxList(selenium, ajxPayerSelect,payerData.payerName), "Could not select payer"+ payerData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		if (account.equals(CAAccount)) {
			assertTrue(enterDate(selenium, txtPayerStartDate,payerData.startDateCA),"Could not enter start Date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium, txtRelationDob, payerData.startDateCA),"Could not Date of birth Date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(enterDate(selenium, txtPayerEndDate, payerData.endDateCA),"Could not enter end Date", selenium, ClassName, MethodName);

		} else {
			assertTrue(enterDate(selenium, txtPayerStartDate,payerData.startDateUS),"Could not enter start Date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(enterDate(selenium, txtRelationDob, payerData.startDateUS),"Could not Date of birth Date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(enterDate(selenium, txtPayerEndDate, payerData.endDateUS),"Could not enter end Date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Billing State withSpecialCharactres")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyBillingStatewithSpecialCharactresUS(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_051";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Billing State with Numerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingStatewithNumeralsUS(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_050";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Billing Zipcode with Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingZipcodewithAlphabetsUS(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_057";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Billing Zipcode with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingZipcodewithInvalidUS(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_058";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For VerifyRelation State With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationStateWithInvalidUS(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_053";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For VerifyRelation State With Numerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationStateWithNumeralsUS(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_052";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Relation ZipCode With Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationZipCodeWithAlphabetsUS(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_054";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Relation ZipCode With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRelationZipCodeWithInvalidUS(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest payerData = new HomeLibUnitTest();
		payerData.workSheetName = "UnitTest_AddPayer";
		payerData.testCaseId = "TC_UCP_055";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
}
