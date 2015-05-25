package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyReportLink extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify the report link in Queue ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReportLinkInHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_018";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
	
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2:Delete previous Correspondence report
			//--------------------------------------------------------------------//			
			assertTrue(goToRegisterPatient(selenium),"Could not navigated to register patient",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			ChartPreVisitLib patientData = new ChartPreVisitLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NP_007";
			patientData.fetchChartPreVisitTestData();		
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("MdHHmmss");
			String date=dateFormat.format(cal.getTime());
			patientData.lastName=patientData.lastName+date;			
			corresData.patientId=patientData.lastName;
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			//--------------------------------------------------------------------//
			//  Step-3:Correspondence  Report for A patient 
			//--------------------------------------------------------------------//
			assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
	        waitForPageLoad(selenium);		
	        assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
	    	assertTrue(click(selenium,QueeCorrespondenace),"Could not click the correspondence Queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			assertTrue(selectValueFromAjaxList(selenium, forPickList,corresData.For), "Could not select Docu type",	selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(selectValueFromAjaxList(selenium, showPickList,corresData.Show), "Could not select Docu type",	selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(type(selenium,searchBox,corresData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(clickAt(selenium,searchBox, ""),"Could not perform click At",selenium, ClassName, MethodName);
			assertTrue(focus(selenium,searchBox),"Could not perform focus",selenium, ClassName, MethodName);
			assertTrue(fireEvent(selenium,searchBox,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
			assertTrue(keyPress(selenium,searchBox, "\\9"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			assertTrue(	waitForElement(selenium,lblcorresQFirst,30000),"Element not present", selenium, ClassName,MethodName);
			assertTrue(click(selenium,lblcorresQFirst),"Could not click the correspondence Queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-4:Verify Whether the report opened .
			//--------------------------------------------------------------------//
		      assertTrue(isElementPresent(selenium,hideQueue),"Could not find the Queue Panel", selenium, ClassName,MethodName);
		      assertTrue(isElementPresent(selenium,TabSummaryMore),"Could not find Summary Tab for opend report", selenium, ClassName,MethodName);
		      assertTrue(selenium.isTextPresent("View Document "),"updated document is not present", selenium, ClassName,MethodName);
		      assertTrue(selenium.isTextPresent("Add Comments"),"Add comment icon is not present", selenium, ClassName,MethodName);
		      assertTrue(selenium.isTextPresent("Page"),"Page number foe uploaded document is not present", selenium, ClassName,MethodName);
		      
		}
		
		catch(Exception e)
		{
			
		}
		return true;
			
		
	}
	
	
}
