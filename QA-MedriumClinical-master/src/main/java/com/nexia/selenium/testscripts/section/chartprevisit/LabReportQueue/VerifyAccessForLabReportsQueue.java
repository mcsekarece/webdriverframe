package com.nexia.selenium.testscripts.section.chartprevisit.LabReportQueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAccessForLabReportsQueue extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the show option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyShowOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labReportData = new ChartPreVisitLib();
		labReportData.workSheetName = "FileLabReport";
		labReportData.testCaseId = "TC_LR_011";
		labReportData.fetchChartPreVisitTestData();
		verifyAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the hide option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHideOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labReportData = new ChartPreVisitLib();
		labReportData.workSheetName = "FileLabReport";
		labReportData.testCaseId = "TC_LR_014";
		labReportData.fetchChartPreVisitTestData();
		verifyAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	/**
	 * verifyAccess
	 * Function to verify access for the lab reports queue
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 26, 2012
	 */
	public boolean verifyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labReportData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labReportData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labReportData.userName, labReportData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,labReportQueue),"Could not click the Meds queue button;More Deatils:"+labReportData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(labReportData.testCaseId.equals("TC_LR_011")){
			assertTrue(isElementPresent(selenium,show),"Could not find the Lab queue show suggest box", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,forProviderSuggestBox),"Could not find the Lab queue for suggest box", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,searchTextBox),"Could not find the lab queue search box", selenium, ClassName, MethodName);	
			}else if(labReportData.testCaseId.equals("TC_LR_014")){
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,labReportQueue),"Could not click the Meds queue button;More Deatils:"+labReportData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,hide),"Could not click the Hide button;More Deatils:"+labReportData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,medsQueueFrame),"Can find the meds queue", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,appointmentFor),"Could not find the Appointment For box", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,day),"Could not find the day suggest box", selenium, ClassName, MethodName);
				}
		
			}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return returnValue;
	}
}
