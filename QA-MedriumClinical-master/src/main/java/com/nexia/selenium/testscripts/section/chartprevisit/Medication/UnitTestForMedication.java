package com.nexia.selenium.testscripts.section.chartprevisit.Medication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForMedication extends AbstractChartPreVisit {
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Duraction With Charatcer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_003";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Duraction With Special Charatcer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_004";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Duraction With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_005";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Startedon With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartedonWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_006";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Startedon With Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartedonWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_007";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Startedon With Different Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartedonWithDifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_008";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Startedon With Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartedonWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_009";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Startedon With Future Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartedonWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_010";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_011";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillWithSpeicalCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_012";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrescribeonWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_013";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrescribeonWithDifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_014";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrescribeonWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_015";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLastRefillWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_016";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLastRefillWithDifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_017";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLastRefillWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_018";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCommentWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_019";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCommentWithMinmumLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_020";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Last Refill With Future Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLastRefillWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_021";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Medication With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_022";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Freetext With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFreetextWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_023";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Quanity With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillQuanityWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_024";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Unit With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillUnitWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_025";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Route With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillRouteWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_026";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Frequency With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillFrequencyWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_027";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Duraction With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillDurationWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_028";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Usage With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillUsageWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_029	";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Method With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillMethodWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_030";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Unit with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillQuanityWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_031";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Unit with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillQuanityWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_032";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Unit with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillUnitWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_033";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Unit with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillUnitWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_034";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Unit with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillRouteWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_035";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Unit with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillRouteWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_036";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Unit with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillFrequencyWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_037";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Unit with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillFrequencyWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_038";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Unit with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillDurationWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_039";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Refill Unit with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillDurationWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_040";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Supply On with Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySuppyOnWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_041";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Supply on With Special Charatcer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySuppyOnWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_042";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Supply on With Alpha Numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySuppyOnWithAlphaNumericCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_043";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Medication with Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_044";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Medication With Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_045";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Medication With Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUsageWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_046";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Medication With Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUsageWithSpecialCharater(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_047";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Medication With Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrescribeOnFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_048";
		medicationTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
		unitTestMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	public boolean unitTestMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLibUnitTest medicationData){
		
		Selenium selenium=null;
		boolean returnValue=true;
		String data;
		int count;
		int count1;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigtae to Medication //
			//--------------------------------------------------------------------//
			//assertTrue(isElementPresent(selenium,"//div[5]/div/a"),"Could not find the link");
			//assertTrue(click(selenium,"//div[5]/div/a"),"Could not click the link");			
			assertTrue(isElementPresent(selenium,lnkMedication),"Could not find the link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in  Family History//
			//--------------------------------------------------------------------//
			
			if(medicationData.maxLength.equals("")){
				assertTrue(unitTestForMedication(selenium, medicationData,userAccount),"", selenium, ClassName, MethodName);
				medicationData.validationFieldID = medicationData.validationFieldID == null ? medicationData.validationFieldID = "" : medicationData.validationFieldID.trim();
				if(medicationData.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium, medicationData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
				assertTrue(getText(selenium, medicationData.validationFieldID).contains(medicationData.validationMessage), "The expected validation message should contain the text - "+ medicationData.validationMessage + " The actual validation message shown - " + getText(selenium, medicationData.validationFieldID), selenium, ClassName, MethodName);
				returnValue=true;
				}
			}else{
				if(medicationData.test.contains("MaxLength")){
					assertTrue(medicationUnitTestForMaxLength(selenium,medicationData),"", selenium, ClassName, MethodName);
					data=getValue(selenium,medicationData.validationFieldID);
					count=data.length();
					waitForPageLoad(selenium);
					count1=Integer.parseInt(medicationData.maxLength);
					waitForPageLoad(selenium);
					if(count>count1)
						returnValue=false;
					else if(count==count1)
						returnValue=true;
					waitForPageLoad(selenium);
				}
				else if(medicationData.test.contains("MinLength")||medicationData.test.contains("ExactLength")){
					assertTrue(prescribeMedicationUnitTest(selenium,medicationData),"", selenium, ClassName, MethodName);
					assertTrue(isElementPresent(selenium,btnEdit),"Edit element is not present", selenium, ClassName, MethodName);
						
				}
			}
		
		}catch(IOException e){
			e.printStackTrace();
		}
		catch(RuntimeException e){
			e.printStackTrace();
			try{
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			catch (IOException IO) {
			}
		}
		return returnValue;
	}
	
	/**
	 * medicationUnitTestForMaxLength
	 * function to medication Unit Test For MaxLength
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */	
	public boolean medicationUnitTestForMaxLength(Selenium selenium,ChartPreVisitLibUnitTest medicationData) throws IOException{
		try{
			assertTrue(type(selenium,ajxSearchMedication,medicationData.prescribe),"Could not enter the Prescribe;More Details"+medicationData.toString(), selenium, ClassName, MethodName);
			if(medicationData.freeText.equals("Yes")){
				assertTrue(click(selenium,chkFreetextBox),"Could not click the check box;More Details:"+medicationData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,"css=div.marginTop10 > textarea.gwt-TextArea",medicationData.direction),"Could not enter the text;More Details:"+medicationData.toString(), selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,"//div[8]/div/div[2]"),"Could not click the show more Details link", selenium, ClassName, MethodName);
			assertTrue(type(selenium,"//div[2]/textarea",medicationData.comment),"Could not enter the comments;More Details:"+medicationData.toString(), selenium, ClassName, MethodName);
			//assertTrue(click(selenium,"add"),"Could not click add button;More Details"+medicationData.toString());
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}
