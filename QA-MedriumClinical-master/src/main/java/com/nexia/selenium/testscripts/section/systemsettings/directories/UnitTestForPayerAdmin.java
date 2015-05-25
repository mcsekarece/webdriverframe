package com.nexia.selenium.testscripts.section.systemsettings.directories;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForPayerAdmin extends AbstractSystemSettingsTest {
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Pharmacy name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPayerNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_001";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPayerCodeWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_002";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_003";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_004";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_005";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With AlphaNumeric And Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithAlphaNumericAndSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_006";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_007";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_008";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_009";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Alpha Numeric And Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithAlphaNumericAndSpecialcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_010";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With Minmum Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithMinmumLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_011";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_012";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Minmum Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithMinmumLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_013";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Minmum Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_014";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Zip code with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_015";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Zipcode with Specail character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithSpecailcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_016";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Zipcode with Alpha Numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_017";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Zipcode with Alpha Numeric And Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithAlphaNumericAndSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_018";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Zipcode with Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_019";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyZ ipcode with Less then Ten Chareacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithLessthenTenChareacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_020";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneExtenwithcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_021";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with Special character ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneExtenwithSpecialcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_022";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneExtenwithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_023";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with AlphaNumericandSpecialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneExtenwithAlphaNumericandSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_024";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Zipcode with space Between The Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithspaceBetweenTheCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_025";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Zipcode with Less then Five Chareacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipcodewithLessthenFiveCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_026";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify webSite with Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifywebSitewithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_028";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}


	/**
	 * addPayer Admin
	 * function to add Payer Admin
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite

	 * @since  	    July 13, 2013
	 */
	public void addPayerAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemsSettingsUnitTest payerAdminData) throws Exception{

		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + payerAdminData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, payerAdminData.userName, payerAdminData.userPassword),"Login Failed ", selenium, ClassName, MethodName);


			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,payerAdminData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);


			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Directories  and Choose Payer Admin			 //
			//--------------------------------------------------------------------//

			assertTrue(click(selenium,lnkQuickLink),"Could not click on System settings link:" + payerAdminData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingLink),"Could not click on System settings link:" + payerAdminData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkDirectories),"Could not click the Directories link;More Details:"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,"Payers");
			waitForPageLoad(selenium);


			//--------------------------------------------------------------------//
			//  Step-3: Check for the pick list									 //
			//--------------------------------------------------------------------//
			assertTrue(checkPayerPicklist(selenium),"Picklist will show", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			// Step-4: Verify the Unit Test										 // 
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,btnAddNewPayer),"Could not click the add Payers; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if(userAccount.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,payerAdminData.payerWizardCA),
						"Could not select payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

			}else {
				assertTrue(selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,payerAdminData.payerWizard), 
						"Could not select Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}


			assertTrue(UnitTest_PayerAdmin(selenium,payerAdminData, userAccount),"Validation failed", selenium, ClassName, MethodName);
			payerAdminData.alert = payerAdminData.alert == null ? payerAdminData.alert= "" : payerAdminData.alert.trim();

			if(!payerAdminData.alert.equals("")){
				selenium.mouseOver(payerAdminData.elementId);
				assertTrue(isElementPresent(selenium,payerAdminData.alert),"The Validation message field did not appear", selenium, ClassName, MethodName);

				if(userAccount.equals(CAAccount)){			
					waitForPageLoad(selenium);
					assertTrue(getText(selenium,payerAdminData.alert).contains(payerAdminData.alertMessageCa),"The expected validation message should contain the text - "+payerAdminData.alertMessageCa+ " The actual validation message shown - " +getText(selenium,payerAdminData.alert), selenium, ClassName, MethodName);				

				}else {			
					waitForPageLoad(selenium);
					assertTrue(getText(selenium,payerAdminData.alert).contains(payerAdminData.alertMessage),"The expected validation message should contain the text - "+payerAdminData.alertMessage+ " The actual validation message shown - " +getText(selenium,payerAdminData.alert), selenium, ClassName, MethodName);
				}		

			}
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}	
}

