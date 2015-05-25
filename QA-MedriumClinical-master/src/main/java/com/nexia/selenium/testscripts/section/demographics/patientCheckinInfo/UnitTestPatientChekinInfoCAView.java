package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;


public class UnitTestPatientChekinInfoCAView extends AbstractHomeTest{
	
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field Canadian Province With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldCanadianProvinceWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_001";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Expire date with Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldExpireDateWithChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_002";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Expire date with number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldExpireDateWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_003";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Expire Date with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldExpireDateWithSpecialChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_004";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Expire Date with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldExpireDateWithDifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_005";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Alberta with Maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldAlbertaWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_006";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Alberta HCN with space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldAlbertaHCNWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_007";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyAlbertaHCNWithChar")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldAlbertaHCNWithChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_008";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify British Columbia with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldBritishColumbiaWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_009";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldBritishColumbiaWithSpacialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldBritishColumbiaWithSpacialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_010";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldBritishColumbiaWithSpacialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldBritishColumbiaWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_011";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldBritishColumbiaWithSpacialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldBritishColumbiaWithAlphanumberic(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_012";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldManitobaWithEmpty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldManitobaWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_013";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldManitobaWithMinmumLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldManitobaWithMinmumLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_014";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldManitobaWithSpecialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldManitobaWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_015";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldNewBrunswickWithMinmumLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldNewBrunswickWithMinmumLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_016";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldNewBrunswickWithSpacialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldNewBrunswickWithSpacialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_017";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldNorthwestTerritoriesWithMinLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldNorthwestTerritoriesWithMinLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_016";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldNorthwestTerritoriesWithSpecialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldNorthwestTerritoriesWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_018";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldNovascotiaWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldNovascotiaWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_020";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldNovascotiaWithSpecialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldNovascotiaWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_021";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldNunavutStartWithOne")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldNunavutStartWithOne(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_022";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldOntarioWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldOntarioWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_023";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldSaskatchewanWithMinLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldSaskatchewanWithMinLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_024";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldSaskatchewanWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldSaskatchewanWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_025";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyFieldYukonWithMinLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldYukonWithMinLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_026";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Zip Code with Alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldZipCodeWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_027";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Zip code with Alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldZipCodeWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_028";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Zip code with Space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldZipCodeWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientCAViewData = new HomeLibUnitTest();
		patientCAViewData.workSheetName = "UnitTest_FV_PC_InfoCAView";
		patientCAViewData.testCaseId = "TC_FLV_CA_029";
		patientCAViewData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForValidationForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientCAViewData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify unit test for patient check in info CA View
	* @action 		  verifying unit test for patient check in info CA View
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 27, 2012
	***************************************************************************************************/
	public void verifyFieldForValidationForCAView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest patientCAViewData) throws Exception{
	
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientCAViewData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientCAViewData.userName, patientCAViewData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Verify the Unit Test  									  //
			//--------------------------------------------------------------------//			
			assertTrue(goToNewPatientCheckIn(selenium), "Could not navigate to Patient information page", selenium, ClassName, MethodName);
			assertTrue(createPatientCAView_UnitTest(selenium,patientCAViewData),"Patient Check-in failed", selenium, ClassName, MethodName);
			
			patientCAViewData.validationFieldID = patientCAViewData.validationFieldID == null ? patientCAViewData.validationFieldID = "" : patientCAViewData.validationFieldID.trim();
			if(!patientCAViewData.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium, patientCAViewData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
				assertTrue(getText(selenium, patientCAViewData.validationFieldID).contains(patientCAViewData.validationMessage), "The expected validation message should contain the text - "+ patientCAViewData.validationMessage + " The actual validation message shown - " + getText(selenium, patientCAViewData.validationFieldID), selenium, ClassName, MethodName);
			}
				waitForPageLoad(selenium);
				
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
