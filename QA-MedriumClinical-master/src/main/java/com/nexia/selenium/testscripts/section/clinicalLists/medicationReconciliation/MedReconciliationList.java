package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class MedReconciliationList extends AbstractClinicalList  {
	
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
	//@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void createManageCareAlerts001(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_001";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
//	
//	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void createManageCareAlerts002(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_002";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
//	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts003(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_003";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
//	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts004(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_004";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
//	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts005(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_005";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
//	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts006(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_006";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
//	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts007(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_007";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
//	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts008(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_008";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
//	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts009(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_009";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
//	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts010(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_010";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts011(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_011";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts012(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_012";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts013(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_013";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts014(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_014";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts015(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_015";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts016(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_016";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts017(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_017";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts018(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_018";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts019(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_019";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts020(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_020";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts021(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_021";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts022(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_022";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts023(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_023";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts024(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_024";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts025(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_025";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts026(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_026";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts027(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_027";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts028(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_028";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts029(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_029";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts030(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_030";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts031(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_031";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts032(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_032";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts033(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_033";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts034(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_034";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts035(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_035";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts036(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_036";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts037(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_037";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts038(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_038";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts039(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_039";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts040(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_040";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts041(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_041";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts042(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_042";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts043(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_043";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts044(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_044";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts045(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_045";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts046(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_046";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts047(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_047";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts048(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_048";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts049(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_049";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts050(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_050";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts051(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_051";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts052(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_052";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts053(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_053";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts054(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_054";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts055(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_055";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts056(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_056";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts057(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_057";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts058(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_058";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts059(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_059";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts060(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_060";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts061(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_061";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts062(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_062";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts063(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_063";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts064(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_064";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts065(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_065";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts066(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_066";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts067(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_067";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts068(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_068";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts069(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_069";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts070(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_070";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts071(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_071";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts072(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_072";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts073(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_073";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts074(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_074";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts075(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_075";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts076(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_076";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts077(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_077";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts078(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_078";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts079(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_079";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts080(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_080";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts081(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_081";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts082(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_082";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts083(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_083";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts084(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_084";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts085(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_085";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts086(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_086";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts087(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_087";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts088(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_088";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts089(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_089";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts090(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_090";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts091(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_091";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts092(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_092";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts093(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_093";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts094(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_094";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts095(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_095";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts096(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_096";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts097(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_097";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts098(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_098";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts099(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_099";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts100(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_100";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts101(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_101";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts102(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_102";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts103(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_103";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts104(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_104";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts105(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_105";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts106(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_106";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts107(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_107";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts108(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_108";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}

	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts109(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_109";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts110(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_110";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts111(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_111";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts112(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_112";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts113(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_113";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts114(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_114";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts115(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_115";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts116(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_116";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts117(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_117";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts118(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_118";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts119(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_119";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts120(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_120";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts121(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_121";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts122(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_122";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts123(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_123";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts124(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_124";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts125(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_125";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts126(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_126";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts127(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_127";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"Portability","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareAlerts128(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ReconciliationList";
		alertData.testCaseId = "TC_RL_128";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
		
	/**
	 * Create ManageCare Alerts
	 * function to verify Create  ManageCare Alerts
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 23, 2013
	 */

	public boolean createAlerts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib alertData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date =null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + alertData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, alertData.userName, alertData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//-------------------------------- ------------------------- ----------//
			//  Step-2:Advanced search with Patient ID//
			//--------------------------------------------------------------------//

			searchPatientNexiaForProviderHomePage(selenium,alertData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to ManageCare Alerts //
			//--------------------------------------------------------------------//
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: create ManageCare Alerts //
			//--------------------------------------------------------------------//
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				cal.add(Calendar.DATE,1); 
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			 	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					cal.add(Calendar.DATE,1); 
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			
			assertTrue(createManageCareAlerts(selenium,alertData,date),"Create Manage Alert Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify manage alerts
			//--------------------------------------------------------------------//
			
			assertTrue(verifyManageAlertsInsummary(selenium,alertData,userAccount),"Verify manage alerts Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Medication Reconciliation Results //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAutomatedRecall),"Could not click on Automated Recallt link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPreview),"Could not click on link Preview", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify Medication Reconciliation in clinical lists
			//--------------------------------------------------------------------//
			
			assertTrue(verifyMedicationReconcillationResults(selenium,alertData,date),"verify MedicationReconcillation Results Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		return returnValue;
}		
		
public boolean verifyManageAlertsInsummary(Selenium selenium,ClinicalListLib alertData,String userAccount ) throws IOException{
	
	String date = null;
	if(userAccount.equals(CAAccount)){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,1); 
		SimpleDateFormat DateFormat1=new SimpleDateFormat("MMM d, yyyy");
	 	date=DateFormat1.format(cal.getTime());
    }else {
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.DATE,1); 
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat1.format(cal.getTime());
	}

	assertTrue(getText(selenium,vfyManageAlertsInSummary).contains(date)," ", selenium, ClassName, MethodName);
			
	assertTrue(getText(selenium,vfyManageAlertsInSummary).contains("Medication Reconciliation")," ", selenium, ClassName, MethodName);
			
	
		assertTrue(click(selenium,lnkClosedArrow),"Could not click the expand arrow in summary", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,vfyExpandDetails).contains("No previous Medication Reconciliation performed")," ", selenium, ClassName, MethodName);
			
		
		return true;
	}
	
   public boolean  verifyMedicationReconcillationResults(Selenium selenium,ClinicalListLib alertData,String date ){
	   boolean returnValue=false;
       int counter=1; 
	   int count = (Integer) selenium.getXpathCount("//div[3]/table/tbody/tr/td/div/div");
	   waitForPageLoad(selenium);
	
	   for (counter=1; counter<=count;counter++){
		        waitForPageLoad(selenium);
		 		if(getText(selenium,"//div[3]/table/tbody/tr["+counter+"]/td/div/div").contains(alertData.lastName)){
				if(getText(selenium,"//div[3]/table/tbody/tr["+counter+"]/td/div/div").trim().contains(date)){
				returnValue = true;
			}
				returnValue = true;
		}
	   }
		return returnValue;
	}
	
}
