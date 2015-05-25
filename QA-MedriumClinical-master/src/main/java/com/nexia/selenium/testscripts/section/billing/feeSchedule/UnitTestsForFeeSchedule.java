package com.nexia.selenium.testscripts.section.billing.feeSchedule;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForFeeSchedule extends AbstractBilling {
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "PayerWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitPayerWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_001";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "PayerWithEmpty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitPayerWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_002";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "PlanWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitPlanWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_003";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "PracticeWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitPracticeWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_004";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "LocationWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitLocationWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_005";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "SpecialityWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitSpecialityWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_006";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "ProviderWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitProviderWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_007";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "PayerWithoutFeeSchedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitPayerWithoutFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_008";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "ExistingPayerWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitExistingPayerWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_009";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "ExistingPayerWithEmpty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitExistingPayerWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_010";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "FeeScheduleWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitFeeScheduleWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_011";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "FeeScheduleWithEmpty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitFeeScheduleWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_012";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "IncreaseAmtWithInvalidData")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitIncreaseAmtWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_013";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "IncreaseAmtWithMaxlength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitIncreaseAmtWithMaxlength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_014";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "IncreaseAmtWithInvalidFormat")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitIncreaseAmtWithInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_015";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "IncreaseAmtWithEmpty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitIncreaseAmtWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_016";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "IncreaseTypeWithEmpty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitIncreaseTypeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_017";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "IncreaseTypeWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitIncreaseTypeWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_018";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
   	    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "CopyEffectiveDateWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitCopyEffectiveDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_019";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "CopyEffectiveDateWithFuture")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitCopyEffectiveDateWithFuture(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_020";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "AllowedAmtWithInvalidData")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitAllowedAmtWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_021";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "AllowedAmtWithMaxlength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitAllowedAmtWithMaxlength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_022";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "AllowedAmtWithInvalidFormat")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitAllowedAmtWithInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_023";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "EffectiveDateWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitEffectiveDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_024";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "EffectiveDateWithFuture")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitEffectiveDateWithFuture(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_025";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "BaseUnitsWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitBaseUnitsWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_026";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "BaseUnitsWithInvalidData")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitBaseUnitsWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_027";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "BaseUnitsWithInvalidFormat")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitBaseUnitsWithInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_028";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "AllowedUnitsWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitAllowedUnitsWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_029";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "AlloweUnitsWithInvalidData")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitAlloweUnitsWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_030";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "AlloweUnitsWithInvalidFormat")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitAlloweUnitsWithInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_FeeSchedule";
		billingData.testCaseId = "TC_UFS_031";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	/**
	 * addFeeSchedule
	 * function to add fee schedule
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      	IOException 
	 * @since  	   	Jan 06, 2014
	 */
	
	public boolean addFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingUnitTestLib billingData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Fee Schedule //
			//--------------------------------------------------------------------//
			
			assertTrue(goToFeeSchedule(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Add Fee Schedule //
			//--------------------------------------------------------------------//
			
			assertTrue(unitTestaddFeeSchedule(selenium,billingData),"Creation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Field validation //
			//--------------------------------------------------------------------//
			
			if(!billingData.alert.equals("")){
				assertTrue(isElementPresent(selenium,billingData.alert), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium,billingData.alert).contains(billingData.alertMessage), "The expected validation message should contain the text - "+billingData.alertMessage + " The actual validation message shown - " + getText(selenium,billingData.alert),selenium, ClassName, MethodName);
				return true;
			}
			else{
			    	return true;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}

