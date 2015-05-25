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

public class VerifyReportCommentsForCorresReport extends AbstractChartPreVisit {


	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveCommets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_003";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Edit comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditCommets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_004";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Cancel comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelCommets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_005";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Show and Hide comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHideAndShowCommets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_006";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);

	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Cancel comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHistoryForComments(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_022";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
		boolean returnvalue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and added corres report 				 //
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
	        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(DeletecorrespondenceReport(selenium, corresData),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3:Correspondence  Report for A patient 
			//--------------------------------------------------------------------//		
			assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
	        waitForPageLoad(selenium);		
	    	assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-4:Search the Patient
			//--------------------------------------------------------------------//	
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
	        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblFirstCorresReport),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, btncorressign),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-5:Verify Lab report comments
			//--------------------------------------------------------------------//	
			assertTrue(verifyReportCommentsIconForCorresReport(selenium,corresData ),"VerificTION FOR  lab report comment failed", selenium, ClassName,MethodName);
					
		}
	catch(Exception e)	{
		assertTrue(false,"Test for verifying Correspondenace Queue Failed", selenium, ClassName, MethodName);
	}
		return returnvalue;
	}

	public boolean verifyReportCommentsIconForCorresReport(Selenium selenium, ChartPreVisitLib corresData) throws IOException
	{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat("MMMM dd, YYYY");
		String commentDate=dateFormat.format(cal.getTime());
		if(corresData.testCaseId.equals("TC_CCR_003"))		{
			   try {
				assertTrue(click(selenium, elementReportCommentsIcon),"Could not click File button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, elementCommentText1,corresData.comments1),"Could not type comments in text box", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btncommentSave),"Could not click File button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);				
				assertTrue(getValue(selenium,elementCommentText1).toLowerCase(new java.util.Locale("en","US")).trim().contains(corresData.comments1.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find entered comments",selenium, ClassName,MethodName);
				waitForPageLoad(selenium);				
				assertTrue(selenium.isTextPresent(commentDate),"Could not find entered comment's date",selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
							} catch (IOException e) {
				
				assertTrue(false,"Test for verifying Correspondenace Queue Failed"+e.getMessage(), selenium, ClassName, MethodName);
			}	
			
			return true;
			
		}
		
		if(corresData.testCaseId.equals("TC_CCR_004"))		{
			try{
				assertTrue(click(selenium, elementReportCommentsIcon),"Could not click File button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, elementCommentText1,corresData.comments1),"Could not type comments in text box", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btncommentSave),"Could not click File button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);				
				assertTrue(getValue(selenium,elementCommentText1).toLowerCase(new java.util.Locale("en","US")).trim().contains(corresData.comments1.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find entered comments",selenium, ClassName,MethodName);
				waitForPageLoad(selenium);		
				assertTrue(click(selenium, btnEditcomments),"Could not click Edit button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, elementCommentText1,corresData.comments2),"Could not type comments in text box", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btncommentSave),"Could not click File button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);			
				assertTrue(getValue(selenium,elementCommentText1).toLowerCase(new java.util.Locale("en","US")).trim().contains(corresData.comments2.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find entered comments",selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				assertTrue(!getValue(selenium,elementCommentText1).toLowerCase(new java.util.Locale("en","US")).trim().contains(corresData.comments1.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find entered comments",selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				assertTrue(selenium.isTextPresent(commentDate),"Could not find entered comment's date",selenium, ClassName,MethodName);
			}
			catch(Exception e)
			{
				assertTrue(false,"Test for verifying Correspondenace Queue Failed"+e.getMessage(), selenium, ClassName, MethodName);
			}
			
			
			return true;
		}
		
		
		if(corresData.testCaseId.equals("TC_CCR_005"))		{
			assertTrue(click(selenium, elementReportCommentsIcon),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, elementCommentText1,corresData.comments1),"Could not type comments in text box", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnCancelComment),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(!getValue(selenium,elementCommentText1).toLowerCase(new java.util.Locale("en","US")).trim().contains(corresData.comments1.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find entered comments",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			
			
			return true;
		}
		if(corresData.testCaseId.equals("TC_CCR_006"))		{
			//To verify Hide comments
			assertTrue(click(selenium, elementReportCommentsIcon),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, elementCommentText1,corresData.comments1),"Could not type comments in text box", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btncommentSave),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);		
			assertTrue(click(selenium, btnHidecomments),"Could not click Hide comments button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			assertTrue(!isElementPresent(selenium, elementCommentText1),"After hiding Comment text box should not be visible", selenium, ClassName,MethodName);
			assertTrue(!isElementPresent(selenium, btnHidecomments),"After Click hide button ,it shoult not have hide button", selenium, ClassName,MethodName);
			assertTrue(isElementPresent(selenium, btnShowcomments),"After Click hide button ,it shoult have Show button", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnShowcomments),"Could not click Show comments button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			assertTrue(isElementPresent(selenium, btnHidecomments),"After Click Show button ,it shoult have hide button", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(commentDate),"Could not find entered comment's date",selenium, ClassName,MethodName);
			return true;	}
		
			if(corresData.testCaseId.equals("TC_CCR_022"))		{
			assertTrue(click(selenium, elementReportCommentsIcon),"Could not click File button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, elementCommentText1,corresData.comments1),"Could not type comments in text box", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btncommentSave),"Could not click File button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);				
				assertTrue(getValue(selenium,elementCommentText1).toLowerCase(new java.util.Locale("en","US")).trim().contains(corresData.comments1.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find entered comments",selenium, ClassName,MethodName);
				waitForPageLoad(selenium);		
				assertTrue(click(selenium, btnEditcomments),"Could not click Edit button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, elementCommentText1,corresData.comments2),"Could not type comments in text box", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btncommentSave),"Could not click File button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);		
				assertTrue(click(selenium, lnkViewHistory),"Could not click History comment button button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);		
				assertTrue(selenium.isTextPresent(corresData.comments2),"Could not Added comment in history section", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				assertTrue(selenium.isTextPresent(corresData.comments1),"Could not Added comment in history section", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				assertTrue(selenium.isTextPresent(commentDate),"Could not find entered comment's date",selenium, ClassName,MethodName);
				
				return true;	}
		return true;
	}
}
