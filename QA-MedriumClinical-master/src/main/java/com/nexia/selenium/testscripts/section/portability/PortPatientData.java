package com.nexia.selenium.testscripts.section.portability;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class PortPatientData extends AbstractHomeTest {
	
	boolean CreatePatient = false;	
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewpatient001(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "PatientData";
		PatientData.testCaseId = "TC_NPC_001";
		PatientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);	
		

	}		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient002(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_002";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient003(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_003";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient004(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_004";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient005(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_005";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient006(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_006";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient007(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_007";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient008(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_008";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient009(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_009";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient010(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_010";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient011(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_011";
			PatientData.fetchHomeTestData();ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient012(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_012";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient013(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_013";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient014(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_014";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient015(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_015";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient016(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_016";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient017(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_017";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient018(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_018";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient019(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_019";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient020(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_020";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient021(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_021";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient022(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_022";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient023(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_023";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient024(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_024";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient025(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_025";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient026(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_026";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient027(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_027";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient028(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_028";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient029(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_029";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient030(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_030";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient031(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_031";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient032(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_032";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient033(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_033";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient034(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_034";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient035(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_035";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient036(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_036";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient037(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_037";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient038(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_038";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient039(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_039";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient040(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_040";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient041(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_041";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient042(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_042";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient043(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_043";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient044(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_044";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient045(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_045";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient046(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_046";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient047(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_047";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient048(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_048";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient049(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_049";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient050(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_050";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient051(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_051";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient052(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_052";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient053(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_053";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient054(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_054";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient055(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_055";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient056(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_056";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient057(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_057";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient058(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_058";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient059(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_059";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient060(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_060";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient061(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_061";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient062(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_062";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient063(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_063";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient064(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_064";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient065(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_065";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient066(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_066";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient067(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_067";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient068(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_068";
			PatientData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient069(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_069";
			PatientData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient070(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_070";
			PatientData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient071(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_071";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient072(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_072";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient073(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_073";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient074(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_074";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient075(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_075";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient076(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_076";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient077(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_077";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient078(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_078";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient079(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_079";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient080(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_080";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient081(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_081";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient082(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_082";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient083(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_083";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }			
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient084(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_084";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }		
	  	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient085(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_085";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient086(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_086";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient087(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_087";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient088(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_088";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient089(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_089";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }		
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient090(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_090";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient091(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_091";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient092(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_092";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient093(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_093";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient094(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_094";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient095(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_095";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient096(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_096";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient097(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_097";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient098(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_098";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient099(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_099";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient100(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_100";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient101(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_101";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient102(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_102";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient103(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_103";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient104(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_104";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient105(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_105";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient106(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_106";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient107(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_107";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient108(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_108";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient109(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_109";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient110(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_110";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient111(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_111";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient112(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_112";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient113(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_113";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient114(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_114";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient115(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_115";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient116(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_117";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient118(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_118";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient119(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_119";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient120(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_120";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient121(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_121";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient122(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_122";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient123(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_123";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient124(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_124";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient125(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_125";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient126(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_126";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient127(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_127";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient128(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "PatientData";
			PatientData.testCaseId = "TC_NPC_128";
			PatientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	  }	
	public boolean checkPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
			Selenium selenium = null;
			boolean returnValue = false;
			CreatePatient=false;
			
			try{
				
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2: Advanced search with Patient ID//
				//--------------------------------------------------------------------//
				CreatePatient = searchPatientNexiaForHomePage(selenium,patientData.lastName);
				waitForPageLoad(selenium);		

				if (CreatePatient==true)				
					createNewPatient(selenium,patientData);				
				else				
					System.out.println("Patient with lastname " + patientData.lastName + " is already created");				
				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
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
		
		
		public boolean createNewPatient(Selenium selenium, HomeLib patientData) throws Exception{
		
			boolean returnValue = false;
			
			try{				
												
				//--------------------------------------------------------------------//
				//---------------  Step-3: Navigate to system setting   --------------//
				//--------------------------------------------------------------------//	

								
				assertTrue(click(selenium, txtSearchPatientBox),"Couldn't click search patient box",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkQuickActions),"Could not click on the quick action link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkShowMoreLink),"Could not click on the show more action link" ,selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSystemSettingAction),"Could not click the systemSettings link;More Deatils:" ,selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				
				//--------------------------------------------------------------------//
				//---------------  Step-4:Delete All Mandatory data   --------------//
				//--------------------------------------------------------------------//	
				assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllMandatory(selenium),"Couldn't delete all mandatory ",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//---------------  Step-5: Click New Patient Check-in   --------------//
				//--------------------------------------------------------------------//
				
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy");
				String uniqueName=DateFormat.format(cal.getTime());
				
				
				click(selenium,backbtn);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + patientData .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+patientData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				//assertTrue(createPatient(selenium,patientData),"Patient Checkin Failed");
				assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(selenium.isAlertPresent()){
					Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
				}
				
				if(!verifyStoredValuesinSummaryPage(selenium,patientData)){
					Assert.fail("Patient details are not saved properly; More Details :"+ patientData.toString());
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
				
				if(!verifyStoredValues(selenium,patientData)){
					Assert.fail("Patient details are not Create properly; More Details :"+ patientData.toString());
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
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
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
		