package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;



public class PortPatientDataCA1_35 extends AbstractHomeTest {
	
	boolean CreatePatient = false;
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewpatient001(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib patientcaData = new HomeLib();
		patientcaData.workSheetName = "PatientDataCAView";
		patientcaData.testCaseId = "TC_NPC_001";
		patientcaData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);	
		

	}		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient002(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_002";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient003(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_003";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient004(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_004";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient005(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_005";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient006(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_006";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient007(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_007";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient008(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_008";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient009(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_009";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient010(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_010";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient011(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_011";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient012(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_012";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient013(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_013";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient014(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_014";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient015(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_015";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient016(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_016";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient017(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_017";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient018(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_018";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient019(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_019";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient020(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_020";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient021(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_021";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient022(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_022";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient023(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_023";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient024(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_024";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient025(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_025";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient026(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_026";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient027(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_027";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient028(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_028";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient029(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_029";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient030(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_030";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient031(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_031";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient032(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_032";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient033(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_033";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient034(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_034";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient035(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_035";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	 
		
	  	
		
	public boolean checkPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientcaData) throws Exception{
			Selenium selenium = null;
			boolean returnValue = false;
			CreatePatient=false;
			
			try{
				
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientcaData.toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientcaData.userName, patientcaData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2: Advanced search with Patient ID//
				//--------------------------------------------------------------------//
				CreatePatient=searchPatientNexiaForHomePage(selenium,patientcaData.lastName);
				waitForPageLoad(selenium);		

				if (CreatePatient==true)					
				createPatientCA(selenium,patientcaData);	
								
				else				
				System.out.println("Patient with lastname " + patientcaData.lastName + " is already created");
				
				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientcaData.toString());
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
			if (!getText(selenium,lblPatientBorderBottom).contains(lastName) || !selenium.isElementPresent(lblPatientBorderBottom)){
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
		
		
		public boolean createPatientCA(Selenium selenium, HomeLib patientcaData) throws Exception{
		
			boolean returnValue = false;
			
			try{				
												
				//--------------------------------------------------------------------//
				//---------------  Step-3: Navigate to system setting   --------------//
				//--------------------------------------------------------------------//	

						
				assertTrue(click(selenium, "searchPatientBox"),"Couldn't navigate to System settings",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkQuickActions),"Could not click on the quick action link" + patientcaData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkShowMoreLink),"Could not click on the show more action link" + patientcaData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSystemSettingAction),"Could not click the systemSettings link;More Deatils:"+patientcaData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				
				//--------------------------------------------------------------------//
				//---------------  Step-4:Delete All Mandatory data   --------------//
				//--------------------------------------------------------------------//	
				assertTrue(click(selenium,"!adminMandatoryUserField"),"Could not click admin Mandatory",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllMandatory(selenium),"Couldn't delete all mandatory fields",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//---------------  Step-5: Click New Patient Check-in   --------------//
				//--------------------------------------------------------------------//
				
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("ddHHmm");
				String uniqueName=DateFormat.format(cal.getTime());
				
				
				click(selenium,btnBack);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"link=Quick actions"),"Could not click on the quick action link" + patientcaData .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"newPatientAction"),"Could not click the Register Patient;More Deatils:"+patientcaData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				//assertTrue(createPatientCAView(selenium,patientcaData,uniqueName),"Patient Checkin Failed");
				assertTrue(createNewPatientWithMandatoryCAView(selenium,patientcaData,uniqueName),"Patient Checkin Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);				
				assertTrue(waitForElement(selenium, "editButton", 10000),"Could not find the edit button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(selenium.isAlertPresent()){
					Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
				}
				
				if(!verifyStoredValuesinSummaryPage(selenium,patientcaData)){
					Assert.fail("Patient details are not saved properly; More Details :"+ patientcaData.toString());
					returnValue=false;
				}
				else{
					 returnValue=true;
				}
					waitForPageLoad(selenium);
					click(selenium,"editButton");
					waitForPageLoad(selenium);
					
				//--------------------------------------------------------------------//
				//  Step-4: Verifying Entered Details are saved properly  //
				//--------------------------------------------------------------------//
				
				if(!verifyStoredValues(selenium,patientcaData)){
					Assert.fail("Patient details are not Create properly; More Details :"+ patientcaData.toString());
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
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientcaData.toString());
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
		