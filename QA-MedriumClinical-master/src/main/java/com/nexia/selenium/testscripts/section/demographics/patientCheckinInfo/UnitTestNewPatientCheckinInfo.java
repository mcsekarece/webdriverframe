package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestNewPatientCheckinInfo extends AbstractHomeTest{

	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field PatientId chart with Special Charecters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPatientIdchartwithMorethentwentychar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVLPIC_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field PatientId chart with Combination Of Special Charecters and Alpha Numeric Values")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldLastNameWithBlankValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVLN_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field Last Name With Space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldLastNameWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVLN_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field Last Name With More then fiftychars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldLastNameWithMorethenfiftychars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVLN_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field First Name With Blank Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldFirstNameWithBlankValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVFN_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field First Name With Space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldFirstNameWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVFN_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field First Name With More then fiftychars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldFirstNameWithMorethenfiftychars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVFN_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field Dob With Invalid Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldDobWithInvalidDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVDOB_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field Dob With Future Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldDobWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVDOB_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field Dob With Future Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldDobWithdifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVDOB_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field Dob With Future Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldDobWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVDOB_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying  Field Status Date With Invalid Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldStatusDateWithInvalidDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVSD_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying  Field Status Date With Future Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldStatusDateWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVSD_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying  Field Status Date With Future Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldStatusDatewithDifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVSD_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying  Field Status Date With Future Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldStatusDatewithNumbers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVSD_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field Middle Name With More then fiftychars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldMiddleNamewithMorethanFiftyChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVMN_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
		
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Residential Street With Combination Of Alphanumeric And Special Charecters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldResidentialStreetWithSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVRAS_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Residential Street With Combination Of Alphanumeric And Special Charecters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldResidentialStreet2WithSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVRAS_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Residential Zip Code With Ten Digit Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldResidentialZipCodeWithTenDigitsNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVRAZC_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Residential Zip Code With Ten Digit Alphabet")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldResidentialZipCodeWithTenDigitAlphabet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVRAZC_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Residential City With Zip Code With Ten Digit Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldResidentialZipCodeWithTenDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVRAZC_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Residential Zip Code With Nine Digit Alphabet")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldResidentialZipCodeWithNineDigitAlphabet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVRAZC_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Residential Zip Code With Nine Digit SpecialChars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldResidentialZipCodeWithNineDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVRAZC_005";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Residential ZipCode With Eight Digit Number And One Special Charecter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldResidentialZipCodeWithEightDigitNumberAndOneSpecialChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVRAZC_006";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Residential County with Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldResidentialCountyWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVRACO_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Residential County with Alpha Numeric And Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldResidentialCountyWithAlphaNumericAndSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVRACO_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number One With Thirteen Digit Alphabet")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberOneWithThirteenDigitAlphabet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT1_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number One With Thirteen Digit Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberOneWithThirteenDigitNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT1_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number One With Thirteen Digit Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberOneWithThirteenDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT1_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number One With Ten Digit Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberOneWithTenDigitAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT1_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number One With Ten Digit Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberOneWithTenDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT1_005";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number One With Alpha Numeric And Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberOneWithAlphaNumericAndSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT1_006";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn One With five Digit Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnOneWithFiveDigitAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET1_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn One With five Digit Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnOneWithFiveDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET1_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn One With Alpha Numeric And Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnOneWithAlphaNumericAndSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET1_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn One With Alpha Numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnOneWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET1_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number Two With Thirteen Digit Alphabet")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberTwoWithThirteenDigitAlphabet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT2_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number Two With Thirteen Digit Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberTwoWithThirteenDigitNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT2_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number Two With Thirteen Digit Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberTwoWithThirteenDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT2_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number Two With Ten Digit Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberTwoWithTenDigitAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT2_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number Two With Ten Digit Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberTwoWithTenDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT2_005";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number Two With Alpha Numeric And Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberTwoWithAlphaNumericAndSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT2_006";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn Two With five Digit Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnTwoWithFiveDigitAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET2_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn Two With five Digit Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnTwoWithFiveDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET2_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn Two With Alpha Numeric And Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnTwoWithAlphaNumericAndSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET2_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn Two With Alpha Numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnTwoWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET2_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);	
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn Two With Alpha Numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberThreeWithThirteenDigitAlphabet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT3_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number Three With Thirteen Digit Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberThreeWithThirteenDigitNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT3_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number Three With Thirteen Digit Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberThreeWithThirteenDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT3_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number Three With Ten Digit Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberThreeWithTenDigitAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT3_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number Three With Ten Digit Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberThreeWithTenDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT3_005";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Number Three With Alpha Numeric And Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberThreeWithAlphaNumericAndSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT3_006";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn Three With five Digit Alphabets")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnThreeWithFiveDigitAlphabets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET3_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn Three With five Digit Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnThreeWithFiveDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET3_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn Three With Alpha Numeric And Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnThreeWithAlphaNumericAndSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET3_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Phone Extn Three With Alpha Numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneExtnThreeWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPET3_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Email With Invalid Email ID")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldEmailWithInvalidEmailID(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVEM_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Mailing Street With only Special Charecters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldMailingStreetWithOnlySpecialCharecters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVMAS_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Mailing Zip Code With Ten Digit Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldMailingZipCodeWithTenDigitsNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVMAZC_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Mailing Zip Code With Ten Digit Alphabet")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldMailingZipCodeWithTenDigitAlphabet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVMAZC_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Mailing City With Zip Code With Ten Digit Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldMailingZipCodeWithTenDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVMAZC_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Mailing Zip Code With Nine Digit Alphabet")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldMailingZipCodeWithNineDigitAlphabet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVMAZC_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Mailing Zip Code With Nine Digit SpecialChars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldMailingZipCodeWithNineDigitSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVMAZC_005";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Mailing ZipCode With Eight Digit Number And One Special Charecter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldMailingZipCodeWithEightDigitNumberAndOneSpecialChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVMAZC_006";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Comments with More then Thousand Char")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldCommentswithMorethenThousandChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLCOM_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Contact preferences With same name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldContactPreference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLCOP_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
/*	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Contact preferences With same name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberOneWithMiddleSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT1_007";
		patientData.fetchHomeTestData();
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Contact preferences With same name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberTwoWithMiddleSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT2_007";
		patientData.fetchHomeTestData();
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying field Contact preferences With same name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPhoneNumberThreeWithMiddleSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLVPNT3_007";
		patientData.fetchHomeTestData();
		verifyFieldForValidationForInvalidData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}*/

	/*************************************************************************************************** 
	* @purpose        To verify unit test for patient check in info
	* @action 		  verifying unit test for patient check in info
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 06, 2012
	***************************************************************************************************/
	public boolean verifyFieldForValidationForInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest patientData) throws Exception{
	
		Selenium selenium = null;
		try{			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application  								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify the Unit Test  									  // 
			//--------------------------------------------------------------------//			
			if(patientData.testCaseId.equals("TC_FLCOP_001")){
				searchPatientNexia(selenium, patientData.patientID);
				assertTrue(click(selenium,lnkPatientInfoView),"Could not click edit button"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnRegistrationEdit),"Could not click edit button"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createPatient_UnitTest(selenium,patientData),"Patient Check-in failed", selenium, ClassName, MethodName);
				if(!patientData.validationFieldID.equals("")){
					assertTrue(isElementPresent(selenium, patientData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
					assertTrue(getText(selenium, patientData.validationFieldID).contains(patientData.validationMessage), "The expected validation message should contain the text - "+ patientData.validationMessage + " The actual validation message shown - " + getText(selenium, patientData.validationFieldID), selenium, ClassName, MethodName);
				return true;
				}
			}
			assertTrue(goToNewPatientCheckIn(selenium), "Could not navigate to Patient information page", selenium, ClassName, MethodName);
			assertTrue(createPatient_UnitTest(selenium,patientData),"Patient Check-in failed", selenium, ClassName, MethodName);
			patientData.validationFieldID = patientData.validationFieldID == null ? patientData.validationFieldID = "" : patientData.validationFieldID.trim();
			if(!patientData.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium, patientData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
				assertTrue(getText(selenium, patientData.validationFieldID).contains(patientData.validationMessage), "The expected validation message should contain the text - "+ patientData.validationMessage + " The actual validation message shown - " + getText(selenium, patientData.validationFieldID), selenium, ClassName, MethodName);
			return true;
			}
		

		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}

	
}
