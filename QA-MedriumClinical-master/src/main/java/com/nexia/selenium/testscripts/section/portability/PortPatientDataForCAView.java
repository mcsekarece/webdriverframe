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



public class PortPatientDataForCAView extends AbstractHomeTest {
	
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
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient006(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_006";
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient007(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_007";
			patientcaData.fetchHomeTestData();
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
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient026(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_026";
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient027(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_027";
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient028(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_028";
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient029(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_029";
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient030(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_030";
			patientcaData.fetchHomeTestData();
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
	 
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient036(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_036";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient037(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_037";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient038(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_038";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient039(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_039";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient040(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_040";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient041(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_041";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient042(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_042";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient043(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_043";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient044(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_044";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient045(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_045";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient046(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_046";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient047(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_047";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient048(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_048";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient049(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_049";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient050(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_050";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient051(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_051";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient052(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_052";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient053(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_053";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient054(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_054";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient055(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_055";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient056(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_056";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient057(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_057";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient058(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_058";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient059(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_059";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient060(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_060";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient061(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_061";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient062(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_062";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient063(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_063";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient064(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_064";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient065(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_065";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient066(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_066";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient067(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_067";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient068(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_068";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient069(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_069";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient070(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_070";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  	
	  	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient071(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_071";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient072(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_072";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient073(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_073";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient074(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_074";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient075(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_075";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient076(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_076";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient077(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_077";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
	  	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient078(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_078";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient079(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_079";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient080(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_080";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }		
	  	
	  	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient081(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_081";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient082(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_082";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient083(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_083";
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient084(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_084";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient085(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_085";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient086(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_086";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient087(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_087";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient088(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_088";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient089(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_089";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient090(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_090";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient091(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_091";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	 	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient092(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_092";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient093(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_093";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient094(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_095";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient096(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_096";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	 	  	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient097(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_097";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  	      	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient098(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_098";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient099(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_099";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient100(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_100";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
	  		  	 	  	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient101(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_101";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	  	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient102(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_102";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient103(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_103";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient104(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_104";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	 	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient105(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_105";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient106(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_106";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient107(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_107";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }		
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient108(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_108";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient109(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_109";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient110(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_110";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient111(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_111";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient112(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_112";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient113(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_113";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient114(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_114";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient115(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_115";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient116(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_116";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient117(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_117";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient118(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_118";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient119(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_119";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient120(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_120";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient121(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_121";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient122(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_122";
			patientcaData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient123(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_123";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient124(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_124";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient125(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_125";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient126(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_126";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient127(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_127";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient128(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_128";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient129(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_129";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient130(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_130";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			patientcaData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	  }	
		@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient131(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib patientcaData = new HomeLib();
			patientcaData.workSheetName = "PatientDataCAView";
			patientcaData.testCaseId = "TC_NPC_131";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			patientcaData.fetchHomeTestData();
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

						
				assertTrue(click(selenium, "searchPatientBox"),"Couldn't click search patient",selenium,ClassName,MethodName);
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
				assertTrue(deleteAllMandatory(selenium),"Could not click delete all mandatory fields button",selenium,ClassName,MethodName);
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
		