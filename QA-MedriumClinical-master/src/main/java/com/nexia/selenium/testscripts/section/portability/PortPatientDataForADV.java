package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class PortPatientDataForADV extends AbstractHomeTest {
	
	boolean CreatePatient = false;	
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewpatient001(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib PatientDataADV = new HomeLib();
		PatientDataADV.workSheetName = "PatientDataADV";
		PatientDataADV.testCaseId = "TC_NPC_001";
		PatientDataADV.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);	
		

	}		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient002(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_002";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient003(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_003";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient004(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_004";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient005(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_005";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient006(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_006";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient007(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_007";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient008(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_008";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient009(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_009";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient010(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_010";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient011(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_011";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient012(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_012";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient013(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_013";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient014(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_014";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient015(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_015";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient016(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_016";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient017(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_017";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient018(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_018";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient019(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_019";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient020(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_020";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient021(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_021";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient022(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_022";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient023(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_023";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient024(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_024";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient025(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_025";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient026(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_026";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient027(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_027";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient028(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_028";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient029(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_029";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient030(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_030";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient031(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_031";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient032(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_032";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient033(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_033";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient034(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_034";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient035(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_035";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient036(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_036";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient037(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_037";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient038(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_038";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient039(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_039";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient040(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_040";
			PatientDataADV.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }		
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient041(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataADV = new HomeLib();
			PatientDataADV.workSheetName = "PatientDataADV";
			PatientDataADV.testCaseId = "TC_NPC_041";
			PatientDataADV.fetchHomeTestData();ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataADV);
	  }		
	  	
	public boolean checkPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib PatientDataADV) throws Exception{
			Selenium selenium = null;
			boolean returnValue = false;
			CreatePatient=false;
			
			try{
				
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + PatientDataADV.toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, PatientDataADV.userName, PatientDataADV.userPassword),"Login Failed ",selenium,ClassName,MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2: Advanced search with Patient ID//
				//--------------------------------------------------------------------//
				CreatePatient = searchPatientNexiaForHomePage(selenium,PatientDataADV.lastName);
				waitForPageLoad(selenium);		

				if (CreatePatient==true)				
					createNewPatient(selenium,PatientDataADV);				
				else				
					System.out.println("Patient with lastname " + PatientDataADV.lastName + " is already created");				
				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + PatientDataADV.toString());
			}
			return returnValue;
		}	
		
		
		/**
		 * searchPatientNexiaForProviderHomePage
		 * function for Searching a patient in the Nexia application   
		 * @param 		selenium
		 * @param 		patientID (Patient ID to be searched)
		 * @throws IOException 
		 
		 * @since  	    Sep 29, 2012
		 */
		public boolean searchPatientNexiaForHomePage(Selenium selenium,String lastName) throws IOException{
			
			boolean returnValue = false;
			assertTrue(type(selenium,txtSearchPatientBox,lastName),"Could not type patient id",selenium,ClassName,MethodName);
		
			selenium.keyPress(txtSearchPatientBox, "\\9");
			waitForElement(selenium,lblPatientBorderBottom,10000);
			//assertTrue(selenium.isElementPresent(lblPatientBorderBottom),"Search Results are not displayed for the patient with ID :-"+lastName);
			System.out.println(getText(selenium,lblPatientBorderBottom));
			if (!getText(selenium,lblPatientBorderBottom).contains(lastName)){
				returnValue=true;
				System.out.println("Patient with lastName " + lastName + " Not created,  create a new one");
			}else{			
				System.out.println("Patient with lastname " + lastName + " is already created, No More Work");				
				returnValue = false;
			}
			return returnValue;
		}	
			
		
		
		/**
		 * createNewPatient
		 * function to create a New Patient entry
		 * @param 		seleniumHost
		 * @param 		seleniumPort
		 * @param 		browser
		 * @param 		webSite
		 * @since  	     Jan 17, 2013
		 */	
		
		
		public boolean createNewPatient(Selenium selenium, HomeLib PatientDataADV) throws Exception{
		
			boolean returnValue = false;
			
			try{				
												
				//--------------------------------------------------------------------//
				//---------------  Step-3: Navigate to system setting   --------------//
				//--------------------------------------------------------------------//	

								
				assertTrue(click(selenium, txtSearchPatientBox),"Could not click search patient box",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + PatientDataADV .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkShowMoreLink),"Could not click on the show more action link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSystemSettingAction),"Could not click the systemSettings link;More Deatils:"+PatientDataADV.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				
				//--------------------------------------------------------------------//
				//---------------  Step-4:Delete All Mandatory data   --------------//
				//--------------------------------------------------------------------//	
				assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllMandatory(selenium),"Could not delete all mandatory fields",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//---------------  Step-5: Click New Patient Check-in   --------------//
				//--------------------------------------------------------------------//
				
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy");
				String uniqueName=DateFormat.format(cal.getTime());
				
				
				click(selenium,btnBack);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + PatientDataADV.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+PatientDataADV.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				//assertTrue(createPatient(selenium,PatientDataADV),"Patient Checkin Failed");	
				assertTrue(createNewPatientWithMandatory(selenium,PatientDataADV),"Patient Checkin Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(selenium.isAlertPresent()){
					Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
				}
				
				if(!verifyStoredValuesinSummaryPage(selenium,PatientDataADV)){
					Assert.fail("Patient details are not saved properly; More Details :"+ PatientDataADV.toString());
					returnValue=false;
				}
				else{
					 returnValue=true;
				}
					waitForPageLoad(selenium);
					click(selenium,btnRegistrationEdit);
					waitForPageLoad(selenium);
					
				//--------------------------------------------------------------------//
				//  Step-4: Verifying Entered Details are saved properly  //
				//--------------------------------------------------------------------//
				
				if(!verifyStoredValues(selenium,PatientDataADV)){
					Assert.fail("Patient details are not Create properly; More Details :"+ PatientDataADV.toString());
					returnValue=false;
				}
				else{
					returnValue=true;
					}
				
				waitForPageLoad(selenium);
				click(selenium,"saveButton");
				waitForPageLoad(selenium);				
				
				
				//assertTrue(goEncounter(selenium),"Could not click the link");
				//waitForPageLoad(selenium);
				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + PatientDataADV.toString());
			}
			return returnValue;
		}
		
public boolean verifyStoredValues(Selenium selenium, HomeLib patientData) {
			
			waitForPageLoad(selenium);
			if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
					
			
			if(!getValue(selenium,"dob").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			
			
			if(!getValue(selenium,"statusSuggestBoxsuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			
			return true;
			}
			
		
		
		public boolean verifyStoredValuesinSummaryPage(Selenium selenium,HomeLib patientData){
			waitForPageLoad(selenium);
		
			waitForPageLoad(selenium);
			
			if(!getText(selenium,"patientName").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,"patientName").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			if(!getText(selenium,txtDOB).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,lblStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			return true;
			
			}
			
}
		