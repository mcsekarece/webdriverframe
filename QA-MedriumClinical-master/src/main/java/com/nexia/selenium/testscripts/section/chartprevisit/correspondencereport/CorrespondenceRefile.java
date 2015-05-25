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

public class CorrespondenceRefile extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","SingleThread","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefiletoSection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_001";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefiletoUnmatchedQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {	
	ChartPreVisitLib corresData = new ChartPreVisitLib();	
	corresData.workSheetName = "CreateCorresReport";
	corresData.testCaseId = "TC_CCR_002";
	corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
		int queueResult = 0;
		boolean returnvalue=true;		
		try
		{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and added corres report 				 //
			//--------------------------------------------------------------------//
			assertTrue(goToRegisterPatient(selenium),"Could not navigated to register patient",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			ChartPreVisitLib patientData = new ChartPreVisitLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NP_007";
			patientData.fetchChartPreVisitTestData();		
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("MdHHmmss");
			SimpleDateFormat dateFormat1=new SimpleDateFormat("msH");
			String date=dateFormat.format(cal.getTime());
			String date1=dateFormat1.format(cal.getTime());
			patientData.lastName=patientData.lastName+date;			
			corresData.patientId=patientData.lastName;
			corresData.AccessionNumber=date1;			
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Correspondence  Report for A patient 
			//--------------------------------------------------------------------//		
			assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
	
	    	assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			if(corresData.testCaseId.equals("TC_CCR_002"))	{
				String unmatchedQueue=getText(selenium,lnkUnmatchedQueue1);
				System.out.println(unmatchedQueue);
				String[] splitS = unmatchedQueue.split(" ");
				
				queueResult = Integer.parseInt(splitS[0]);
				System.out.println(queueResult);
			}
			//--------------------------------------------------------------------//
			//  Step-04: Navigation to File new Correspondence report//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			//FIXME EMR-1418
			String arrowPossition = selenium.getAttribute("css=a.arrow-closed/@class");
			if(arrowPossition.equalsIgnoreCase("arrow-closed")){
				 assertTrue(click(selenium,"css=a.arrow-closed"),"Could not click the expand arrow of search Patient", selenium, ClassName, MethodName);
			 }			
			assertTrue(click(selenium, lblCorres),"Could not click Correspondence option  button", selenium, ClassName,MethodName);
	        waitForPageLoad(selenium);		
			assertTrue(CorrespondenceAdvanceSearch( selenium, corresData) ,"Could not click the lab link", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);	
			assertTrue(isElementPresent(selenium, btnRefile1),"Search result not found", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnRefile1),"Could not click Refile  button", selenium, ClassName,MethodName);
			
			
			if(corresData.testCaseId.equals("TC_CCR_001"))
			{
				assertTrue(verifyFiletoSection(selenium,corresData),"Refile to other section failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			if(corresData.testCaseId.equals("TC_CCR_002"))
			{
				
				assertTrue(verifyFiletoUnmatchQueue(selenium,corresData, queueResult),"Refile to other section failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}	
		}
	catch(Exception e)
	{
		assertTrue(false,"Test for verifying Correspondenace Queue Panel failed", selenium, ClassName, MethodName);	
	}
		return returnvalue;
	}
	
	
	public boolean verifyFiletoSection(Selenium selenium, ChartPreVisitLib corresData) throws IOException
	{
		if(!isChecked(selenium,chkFiletosection))			
		{
			assertTrue(click(selenium, chkFiletosection),"Could not click File to Section Radio button button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		corresData.DocumentType="Correspondence";
		assertTrue(selectValueFromAjaxList(selenium, ajxFiletosection,corresData.DocumentType),"Could not select Docu type", selenium, ClassName,	MethodName);
		waitForPageLoad(selenium);		
		assertTrue(selectValueFromAjaxList(selenium, ajxFileTocategory,corresData.ReportType1),"Could not select Section type", selenium, ClassName,	MethodName);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium, btnRefileSave),"Could not click Save button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);	
		assertTrue(isTextPresent(selenium,"Matched to"),"The text 'Matched to' not present ", selenium, ClassName,MethodName);
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMore),
			"Could not click on More  link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, CorresTab),"Could not click Correspondence button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lblFirstCorresReport),"Added correspondence report not present", selenium, ClassName,MethodName);
		assertTrue(getText(selenium,lblFirstCorresReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(corresData.ReportType1.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName,MethodName);
		assertTrue(!getText(selenium,lblFirstCorresReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(corresData.ReportType.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName,MethodName);
		return true;
	}
	
	
	public boolean verifyFiletoUnmatchQueue(Selenium selenium, ChartPreVisitLib corresData,int queueResult  ) throws IOException
	{
		boolean returnvalue=true;
		if(!isChecked(selenium,chkReturnToUnMatch))			
		{
			assertTrue(click(selenium, chkReturnToUnMatch),"Could not click File to Section Radio button button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		assertTrue(click(selenium, btnRefileSave),"Could not click Save button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(isTextPresent(selenium,"Unmatched"),"The text 'unmatched' not present ", selenium, ClassName,MethodName);
		assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);	
		String unmatchedQueue=getText(selenium,lnkUnmatchedQueue1);
		System.out.println(lnkUnmatchedQueue1);
		String[] splitS = unmatchedQueue.split(" ");
		int queueResult1 = Integer.parseInt(splitS[0]);
		System.out.println(queueResult1);
		if(queueResult1>queueResult)
		{
			 returnvalue=true;			
		}
		else
		{
			assertTrue(false,"After Moved corredpondence record to unmatch the count is Same as befor", selenium, ClassName, MethodName);
		}
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, CorresTab),"Could not click Correspondence button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(!isElementPresent(selenium,lblFirstCorresReport),"The moved corred report is visible under Corres Tab", selenium, ClassName,MethodName);
		
		
		return returnvalue;
	}
	
	
	
	
	
	
	
}