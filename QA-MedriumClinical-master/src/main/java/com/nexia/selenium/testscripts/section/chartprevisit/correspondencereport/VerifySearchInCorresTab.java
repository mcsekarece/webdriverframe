package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchInCorresTab extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Search functionality in corres tab")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchFunctionality(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib CorresData = new ChartPreVisitLib();
		CorresData.workSheetName = "CreateCorresReport";
		CorresData.testCaseId = "TC_CCR_024";
		CorresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, CorresData);
	}
	
	 /***************************************************************************************************
     * @purpose To verify the search functionality in Correspondence TAb
     * @author Aspire QA
     * @throws IOException
     * @state Developing
     * @useraccount Both (US and Canada)
     * @since Oct 28, 2014
     ***************************************************************************************************/
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
		try{
			String reportType1,reportType2,reportType3,reportType4;
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2:Delete All Correspondence report							 
			//--------------------------------------------------------------------//	
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(DeletecorrespondenceReport(selenium, corresData),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Create a correspondence report for the patient 						 
			//---------------------------------------------------------------------//
			assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(CreateCorrespondenceReportWithMandatDetails(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
			waitForPageLoad(selenium);
			reportType1=corresData.ReportType;
			corresData.workSheetName = "CreateCorresReport";
			corresData.testCaseId = "TC_CCR_025";
			corresData.fetchChartPreVisitTestData();	
			reportType2=corresData.ReportType;
			assertTrue(CreateCorrespondenceReportWithMandatDetails(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
			waitForPageLoad(selenium);
			corresData.workSheetName = "CreateCorresReport";
			corresData.testCaseId = "TC_CCR_026";
			corresData.fetchChartPreVisitTestData();	
			reportType3=corresData.ReportType;
			assertTrue(CreateCorrespondenceReportWithMandatDetails(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
			waitForPageLoad(selenium);
			corresData.workSheetName = "CreateCorresReport";
			corresData.testCaseId = "TC_CCR_027";
			corresData.fetchChartPreVisitTestData();	
			reportType4=corresData.ReportType;
			assertTrue(CreateCorrespondenceReportWithMandatDetails(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Go to Correspondence report				 
			//---------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Search by using Report type 
			//---------------------------------------------------------------------//
			assertTrue(searchreport(selenium,reportType1),"Could not search the report ", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(reportType1),"Could not find added report ", selenium, ClassName,MethodName);
			assertTrue(!selenium.isTextPresent(reportType2),"Search function is not working ", selenium, ClassName,MethodName);
			assertTrue(!selenium.isTextPresent(reportType3),"Search function is not working ", selenium, ClassName,MethodName);
			assertTrue(!selenium.isTextPresent(reportType4),"Search function is not working ", selenium, ClassName,MethodName);
			assertTrue(searchreport(selenium,reportType2),"Could not search the report ", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(reportType2),"Could not find added report ", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(reportType1),"Search function is not working  ", selenium, ClassName,MethodName);
			assertTrue(!selenium.isTextPresent(reportType3),"Search function is not working ", selenium, ClassName,MethodName);
			assertTrue(!selenium.isTextPresent(reportType4),"Search function is not working ", selenium, ClassName,MethodName);
			assertTrue(searchreport(selenium,reportType3),"Could not search the report ", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(reportType3),"Could not find added report ", selenium, ClassName,MethodName);
			assertTrue(!selenium.isTextPresent(reportType2),"Search function is not working  ", selenium, ClassName,MethodName);
			assertTrue(!selenium.isTextPresent(reportType1),"Search function is not working ", selenium, ClassName,MethodName);
			assertTrue(!selenium.isTextPresent(reportType4),"Search function is not working ", selenium, ClassName,MethodName);
			assertTrue(searchreport(selenium,reportType4),"Could not search the report ", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(reportType4),"Could not find added report ", selenium, ClassName,MethodName);
			assertTrue(!selenium.isTextPresent(reportType3),"Search function is not working ", selenium, ClassName,MethodName);
			assertTrue(!selenium.isTextPresent(reportType1),"Search function is not working ", selenium, ClassName,MethodName);
			assertTrue(!selenium.isTextPresent(reportType2),"Search function is not working ", selenium, ClassName,MethodName);
		}
	catch(Exception e)
	{
		
	}
	return true;	
	
}
	public Boolean searchreport(Selenium selenium,String report) throws IOException
	{
		assertTrue(type(selenium,txtMedsSearchTextBox,report),"Could not type patient id",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(clickAt(selenium,txtMedsSearchTextBox, ""),"Could not perform click At",selenium, ClassName, MethodName);
		assertTrue(focus(selenium,txtMedsSearchTextBox),"Could not perform focus",selenium, ClassName, MethodName);
		assertTrue(fireEvent(selenium,txtMedsSearchTextBox,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
		assertTrue(keyPress(selenium,txtMedsSearchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);	
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);		
		
		return true;
	}
}