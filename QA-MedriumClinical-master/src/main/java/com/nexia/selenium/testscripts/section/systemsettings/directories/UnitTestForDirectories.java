package com.nexia.selenium.testscripts.section.systemsettings.directories;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForDirectories extends AbstractSystemSettingsTest {
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Pharmacy name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPharmachyNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_001";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_002";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_003";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_004";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
//	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_005";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_006";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With AlphaNumeric And Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithAlphaNumericAndSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_007";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_008";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_009";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_010";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Alpha Numeric And Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithAlphaNumericAndSpecialcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_011";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With Minmum Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithMinmumLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_012";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_013";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Minmum Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithMinmumLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_014";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Minmum Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_015";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Zip code with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_016";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Zipcode with Specail character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithSpecailcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_017";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Zipcode with Alpha Numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_018";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Zipcode with Alpha Numeric And Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithAlphaNumericAndSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_019";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Zipcode with Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_020";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyZ ipcode with Less then Ten Chareacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithLessthenTenChareacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_021";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	/*@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with Minmum Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneExtenwithMinmumLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_022";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneExtenwithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_023";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}*/
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneExtenwithcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_022";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with Special character ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneExtenwithSpecialcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_023";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneExtenwithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_024";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with AlphaNumericandSpecialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneExtenwithAlphaNumericandSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_025";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Zipcode with space Between The Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithspaceBetweenTheCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_026";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Zipcode with Less then Five Chareacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithLessthenFiveCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_027";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Email with Space between Email Address")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEmailwithSpacebetweenEmailAddress(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_028";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Email with Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEmailwithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_029";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Email with Invaild Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEmailwithInvaildFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_030";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "verify webSite with Invaild Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifywebSitewithInvaildFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_031";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "verify webSite with Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifywebSitewithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_032";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	@Test(enabled=false)
	//@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "verify webSite with Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCommentsWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemsSettingsUnitTest pharmacyData= new SystemsSettingsUnitTest();
		pharmacyData.workSheetName = "UnitTest_SS_Directories";
		pharmacyData.testCaseId = "TC_DIR_033";
		pharmacyData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, pharmacyData);
	}
	
	/**
	 * addDirectories
	 * function to add Directories
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    Aug 27, 2012
	 */
	public void addDirectories(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemsSettingsUnitTest pharmacyData) throws Exception{
		
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pharmacyData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pharmacyData.userName, pharmacyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pharmacyData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Directories //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickLink),"Could not click on System settings link:" + pharmacyData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingLink),"Could not click on System settings link:" + pharmacyData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkDirectories),"Could not click the Directories link;More Details:"+pharmacyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------------Step-3: Verify the Unit Test-------------------// 
			//--------------------------------------------------------------------//	
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNew),"Could not click the add Directories; More details"+pharmacyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(UnitTest_Directories(selenium,pharmacyData, userAccount),"Validation Failed", selenium, ClassName, MethodName);
			pharmacyData.alert = pharmacyData.alert == null ? pharmacyData.alert= "" : pharmacyData.alert.trim();
			if(!pharmacyData.alert.equals("")){
			assertTrue(isElementPresent(selenium,pharmacyData.alert),"The Validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,pharmacyData.alert).contains(pharmacyData.alertMessage),"The expected validation message should contain the text - "+pharmacyData.alertMessage+ " The actual validation message shown - " +getText(selenium,pharmacyData.alert), selenium, ClassName, MethodName);
			}
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}	
}

