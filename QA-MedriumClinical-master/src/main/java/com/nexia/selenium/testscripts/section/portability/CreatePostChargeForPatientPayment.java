package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class CreatePostChargeForPatientPayment extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry001(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_001";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry002(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_002";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry003(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_003";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry004(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_004";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry005(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_005";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry006(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_006";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry007(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_007";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry008(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_008";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry009(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_009";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry010(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_010";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry011(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_011";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry012(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_012";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry013(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_013";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry014(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_014";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry015(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_015";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry016(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_016";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry017(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_017";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry018(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_018";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry019(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_019";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry020(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_020";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry021(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_021";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry022(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_022";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry023(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_023";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry024(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_024";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry025(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_025";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry026(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_026";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry027(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_027";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry028(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_028";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry029(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_029";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Charge Entry For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createchargeEntry030(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		BillingLib postChargeEntry = new BillingLib();
		postChargeEntry.workSheetName = "PostChargePortablity";
		postChargeEntry.testCaseId = "TC_PCP_030";
		postChargeEntry.fetchBillingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, postChargeEntry);
	}
	
	public boolean postChargeEntry(String seleniumHost, int seleniumPort,
		String browser, String webSite, String userAccount,
		BillingLib chargeEntryData) throws IOException {
		Selenium selenium = null;
		boolean returnValue = true;

		try {

			// --------------------------------------------------------------------//
			// Step-1: Login to the application and search for the given patient//
			// --------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :"+ chargeEntryData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount,chargeEntryData.userName,chargeEntryData.userPassword), "Login Failed ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-2: Switch role
			// --------------------------------------------------------------------//
			assertTrue(switchRole(selenium, chargeEntryData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			// --------------------------------------------------------------------//
			// Step-3: Patient search
			// --------------------------------------------------------------------//
			assertTrue(navigateToPatient(selenium,chargeEntryData),"Could not search the patient", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-4: Go To New Charge
			// --------------------------------------------------------------------//
			goToPostNewCharge(selenium, chargeEntryData);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-5: post Charge For Patient Payment SetUp
			// --------------------------------------------------------------------//
			postChargeForPatientPaymentSetUp(selenium, chargeEntryData,userAccount);
			waitForPageLoad(selenium);
			

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}
}
