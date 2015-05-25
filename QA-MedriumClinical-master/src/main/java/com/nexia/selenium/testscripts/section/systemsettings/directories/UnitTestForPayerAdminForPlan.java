package com.nexia.selenium.testscripts.section.systemsettings.directories;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForPayerAdminForPlan extends AbstractSystemSettingsTest {
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Pharmacy name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPlanNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_001";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
		
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoPayWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_002";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoPayWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_003";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoPayWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_004";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With AlphaNumeric And Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoPayWithAlphaNumericAndSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_005";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySpecialistCoPayWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_006";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySpecialistCoPayWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_007";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySpecialistCoPayWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_008";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Alpha Numeric And Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySpecialistCoPayWithAlphaNumericAndSpecialcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_009";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Phone With Minmum Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoPayWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_010";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax With Minmum Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySpecialistCoPayWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_011";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeductiblewithcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_012";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with Special character ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeductiblewithSpecialcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_013";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeductiblewithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_014";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "PhoneExtene with AlphaNumericandSpecialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeductiblewithAlphaNumericandSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_015";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Email with Invaild Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeductibleWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_016";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	} 
		
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Email with Invaild Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoInsurancewithcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_017";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	} 

	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Email with Invaild Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoInsurancewithSpecialcharacter (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_018";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	} 

	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Email with Invaild Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoInsurancewithAlphaNumeric (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_019";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	} 

	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Email with Invaild Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoInsurancewithDecimalValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{

		SystemsSettingsUnitTest payerAdminData= new SystemsSettingsUnitTest();
		payerAdminData.workSheetName = "UnitTest_SS_PayerAdminPlan";
		payerAdminData.testCaseId = "TC_PA_020";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	} 
	/**
	 * addPayer Admin and Contact
	 * function to add Payer Admin and Contact
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 16, 2013
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
			assertTrue(switchRole(selenium,payerAdminData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
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
			//  Step-4:Delete existing PayerAdmin									 //
			//--------------------------------------------------------------------//
			//assertTrue(deletePayerAdmin(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//   Step-5: Create Mandatory Payers			   					 // 
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddNewPayer),"Could not click the add Payers; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			if(userAccount.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,payerAdminData.payerWizardCA), 
						"Could not select payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
			}else {
				assertTrue(selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,payerAdminData.payerWizard), 
						"Could not select payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(createPayersMandatory(selenium,payerAdminData, userAccount),"Payers Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// Step-5: Verify the Unit Test	for Payer Admin Plan				 // 
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnNext),"Could not click on next button; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNext),"Could not click on next button; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,btnAddNewPlan),"Could not click on next button; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
					
			assertTrue(UnitTest_PayerAdminPlan(selenium,payerAdminData, userAccount),"Validation failed", selenium, ClassName, MethodName);
			payerAdminData.alert = payerAdminData.alert == null ? payerAdminData.alert= "" : payerAdminData.alert.trim();
			if(!payerAdminData.alert.equals("")){
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

