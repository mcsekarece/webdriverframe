package com.nexia.selenium.testscripts.section.chartprevisit.CcdExport;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyExportPreviewForResult extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Export For Lab Result")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportForLabResult(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_001";
		labData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		exportPreview(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Export With Two LabResult")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportWithTwoLabResult(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_009";
		labData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		exportPreview(seleniumHost, seleniumPort, browser, webSite, userAccount,labData );
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Expor tWith Abnormal Result")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportWithAbnormalResult(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_006";
		labData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		exportPreview(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	/**
	 * exportPreview
	 * Function to verify export preview page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Jan 17, 2012
	 */
	public boolean exportPreview(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//-----------------------------------//
			//  Step-1: Login to the application //
			//---------------------------------- //
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------//
			//  Step-2: Register new patient details //
			//-------------------------------------- //
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib patientData = new ChartPreVisitLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NP_001";
			patientData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------//
			//  Step-3: File the report against the corresponding order //
			//--------------------------------------------------------- //
			assertTrue(click(selenium,lnkPatientOption),"Could not click the patient option link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkLabReportLink),"Could not click the file new reportlink",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			assertTrue(fileReport(selenium,labData,userAccount),"Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			
			if(labData.testCaseId.equals("TC_LR_009")){
				labData.workSheetName = "FileLabReport";
				labData.testCaseId = "TC_LR_001";
				labData.fetchChartPreVisitTestData();
				
				assertTrue(fileReport(selenium,labData,userAccount),"Creation Failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				labData.testCaseId = "TC_LR_009";
				labData.fetchChartPreVisitTestData();
			}
			
			//------------------------------------//
			//  Step-4: Click on the Export chart //
			//----------------------------------- //
			assertTrue(click(selenium,lnkPatientOption),"Could not click the patient option link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkExportChart),"Could not click the export chart link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(labData.testCaseId.equals("TC_LR_009")){
				labData.testCaseId = "TC_LR_001";
				labData.fetchChartPreVisitTestData();
				
				
				assertTrue(verifyExportChartPreviewForTwoLabResults(selenium,labData),"Allergy details not saved properly; More Details :"+ labData.toString(),selenium, ClassName, MethodName);
				
				
				labData.testCaseId = "TC_LR_009";
				labData.fetchChartPreVisitTestData();
			}
			
			//------------------------------------------------------------//
			//  Step-5: Verify the export chart with already entered data //
			//------------------------------------------------------------//
			if(!verifyExportChartPreview(selenium,labData)){
				Assert.fail("Lab details not saved properly; More Details :"+ labData.toString());
				returnValue= false;
			}else 
				returnValue=true;
			
		
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + labData.toString());
		}
		return returnValue;
	}
	
	public boolean verifyExportChartPreview(Selenium selenium , ChartPreVisitLib labData){
		try{
		
		assertTrue(getText(selenium,lblExport17).trim().contains(labData.testName.trim()),"testName not matched",selenium, ClassName, MethodName);
		
		
		
		assertTrue(getText(selenium,lblExport18).toLowerCase(new java.util.Locale("en","Us")).trim().contains("completed".trim().toLowerCase(new java.util.Locale("en","Us"))),"Value not equal to completed",selenium, ClassName, MethodName);
		
		
		
		assertTrue(getText(selenium,lblExport19).toLowerCase(new java.util.Locale("en","Us")).trim().contains(labData.result.trim().toLowerCase(new java.util.Locale("en","Us"))),"Result Value to matched",selenium, ClassName, MethodName);
		
		
		if(labData.testCaseId.equals("TC_LR_006")){
			
			assertTrue(getText(selenium,lblExport19).toLowerCase(new java.util.Locale("en","Us")).trim().contains("Abnormal".trim().toLowerCase(new java.util.Locale("en","Us"))),"Value not equal to abnormal",selenium, ClassName, MethodName);
			
		
		}
		else {
			
			assertTrue(getText(selenium,lblExport19).toLowerCase(new java.util.Locale("en","Us")).trim().contains("normal".trim().toLowerCase(new java.util.Locale("en","Us"))),"Value not equal to normal",selenium, ClassName, MethodName);
			
			
		}
		/*if(!getText(selenium,lblExport20).toLowerCase(new java.util.Locale("en","Us")).trim().contains(labData.comment.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
		
		assertTrue(getText(selenium,lblExport21).toLowerCase(new java.util.Locale("en","Us")).trim().contains(labData.high.trim().toLowerCase(new java.util.Locale("en","Us"))),"testdata not matched",selenium, ClassName, MethodName);
		
		
		
		assertTrue(getText(selenium,lblExport21).toLowerCase(new java.util.Locale("en","Us")).trim().contains(labData.low.trim().toLowerCase(new java.util.Locale("en","Us"))),"test data not matched",selenium, ClassName, MethodName);
		
		}catch(Exception e)
		{
		e.printStackTrace();
		}
		
		
		return true;
	}
	public boolean verifyExportChartPreviewForTwoLabResults(Selenium selenium , ChartPreVisitLib labData){
		
		try
		{
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,"ResultType_Div").trim().contains(labData.testName.trim()),"ResultType Data not matched",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,"ResultStatus_Div").toLowerCase(new java.util.Locale("en","Us")).trim().contains("completed".trim().toLowerCase(new java.util.Locale("en","Us"))),"Result data not matched",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblExport23).toLowerCase(new java.util.Locale("en","Us")).trim().contains(labData.result.trim().toLowerCase(new java.util.Locale("en","Us"))),"TestData Not matched",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblExport23).toLowerCase(new java.util.Locale("en","Us")).trim().contains("normal".trim().toLowerCase(new java.util.Locale("en","Us"))),"TestData Not matched",selenium, ClassName, MethodName);
		
		
		/*if(!getText(selenium,lblExport24).toLowerCase(new java.util.Locale("en","Us")).trim().contains(labData.comment.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
		assertTrue(getText(selenium,lblExport25).toLowerCase(new java.util.Locale("en","Us")).trim().contains(labData.high.trim().toLowerCase(new java.util.Locale("en","Us"))),"TestData Not matched",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblExport25).toLowerCase(new java.util.Locale("en","Us")).trim().contains(labData.low.trim().toLowerCase(new java.util.Locale("en","Us"))),"TestData Not matched",selenium, ClassName, MethodName);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
}
