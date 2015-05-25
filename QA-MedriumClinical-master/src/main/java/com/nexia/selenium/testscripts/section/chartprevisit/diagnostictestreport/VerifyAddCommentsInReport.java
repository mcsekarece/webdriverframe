package com.nexia.selenium.testscripts.section.chartprevisit.diagnostictestreport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddCommentsInReport extends AbstractChartPreVisit{
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Add Comments In Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAddCommentsInReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	
		Calendar cal=Calendar.getInstance();
		// Get the time comment entered
		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
		String time1= dateFormat.format(cal.getTime());
		System.out.println(time1);
		
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_001";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Edited Comments History In Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditedCommentsHistoryInReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_002";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Add Comments Cancel In Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAddCommentsCancel(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_003";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Cancel Are You Sure Popup In Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelAreYouSurePopup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_004";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Hide Comments Default In Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHideComments(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_006";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	/**
	 * VerifyStoredValuesInListView
	 * function to verify Stored Values In List View
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 30, 2014
	 */
	
	public boolean createDiagnosticTestReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib diData) throws IOException{
		Selenium selenium=null;	
		boolean returnvalue=true;
	try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + diData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, diData.userName, diData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Verify Diagnostic Report Q count before adding Report
			//--------------------------------------------------------------------//			
	
			String dIQueue=getText(selenium,queDiagnosticReport);
			System.out.println(dIQueue);
			String[] splitS = dIQueue.split(" ");
			int  queueValue = Integer.parseInt(splitS[0]);
			System.out.println( queueValue);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Diagnostic Report
			//--------------------------------------------------------------------//			
			
			assertTrue(navigateToCorresReport(selenium,diData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-4 :Diagnostic  Report for the  patient 
			//--------------------------------------------------------------------//
		
			assertTrue(CreateDiagnosticReport(selenium,diData,userAccount),"Creation of Diagnostic  Report failed ", selenium, ClassName,MethodName);  
	        waitForPageLoad(selenium);	
			
	        assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			
	        // Verify the DI Report created or not
			
			String dIQueue1=getText(selenium,queDiagnosticReport);
			System.out.println(dIQueue1);
			String[] splitS1 = dIQueue1.split(" ");
			int  queueValue1 = Integer.parseInt(splitS1[0]);
			System.out.println(" queueValue1 - " +  queueValue1);
			
			if( queueValue1 >  queueValue){
				returnvalue=true;
			}else{
				assertTrue(false,"After save the report  the Count in the Q not updated Before Count=+"+ queueValue+",After Count=="+ queueValue1+"", selenium, ClassName, MethodName);
			}
            
			// -------------------------------------------------------------------//
			//  Step-5 : Navigate to Report									     //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, vfyUnsignedDiReports),"Could not click  diagnostic report in list ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnDISign),"Could not navigate to diagnostic report page ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// -------------------------------------------------------------------//
			//  Step-7 : Verify the default setting option 								  //
			//--------------------------------------------------------------------//
			
			assertTrue(isElementPresent(selenium,btnAddComments),"Add comments button not present as default ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("MMM dd,yyyy");
			String date1=dateFormat.format(cal.getTime());
			
			// Get the time comment entered
			SimpleDateFormat dateFormat1=new SimpleDateFormat("HH:mm:ss");
			String time1= dateFormat1.format(cal.getTime());
			
			// -------------------------------------------------------------------//
			//  Step-6 : Add the Comments									  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddComments),"Could not click add comments button in report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,elementCommentText1,diData.comments),"Could not type comments", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if (diData.testCaseId.equals("TC_CDR_006")){
				
				assertTrue(click(selenium,btnHidecomments),"Could not click Hide comments  button ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,elementCommentText1),"Verify Hide Comment failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				return true;
			}
			if (diData.testCaseId.equals("TC_CDR_004")){
				
			     assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
				 waitForPageLoad(selenium);
				 assertTrue(isTextPresent(selenium,"Are you sure"),"Are you sure alert not present", selenium, ClassName,MethodName);
				 waitForPageLoad(selenium);
				 return true;
			}
			
			if (!diData.testCaseId.equals("TC_CDR_003")){
				assertTrue(click(selenium,btncommentSave),"Could not click save the comments", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}else{
				assertTrue(click(selenium,btnCancelComment),"Could not click cancel the comments", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(!getText(selenium,elementCommentText1).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.comments.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify added comments failed", selenium, ClassName,MethodName);
			    waitForPageLoad(selenium);
			    return true;
			}
			
			// -------------------------------------------------------------------//
			//  Step-7 : Verify the added comments							  //
			//--------------------------------------------------------------------//
			
			if (diData.testCaseId.equals("TC_CDR_001")){
				
				assertTrue(isElementPresent(selenium,IconShowComments),"Could not saved properly ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,btnEditcomments),"Could not show edit button ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,lnkViewHistory),"Could not show View history  button ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,btnHidecomments),"Could not show Hide comments  button ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(getText(selenium,elementCommentText1).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.comments.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify added comments failed", selenium, ClassName,MethodName);
			    waitForPageLoad(selenium);
			    assertTrue(getText(selenium,elementCommentText1).toLowerCase(new java.util.Locale("en","US")).trim().contains(date1.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Time stamp Failed", selenium, ClassName,MethodName);
			    waitForPageLoad(selenium);
			    assertTrue(getText(selenium,elementCommentText1).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.Receivingprovider.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Time stamp Failed", selenium, ClassName,MethodName);
			    waitForPageLoad(selenium);
			    return true;
			}			
			
			// -------------------------------------------------------------------//
			//  Step-8 : Verify the Edited  comments History						  //
			//--------------------------------------------------------------------//
			
			if (diData.testCaseId.equals("TC_CDR_002")){
				
			assertTrue(click(selenium,btnEditcomments),"Could not click edit comments", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			String editedComment = diData.comments + "Edited";
			
			// Get the Date and time comment Edited 
			
			String date2=dateFormat.format(cal.getTime());
			
			String time2= dateFormat1.format(cal.getTime());
			
			assertTrue(type(selenium,elementCommentText1,editedComment),"Could not type comments", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btncommentSave),"Could not click save the comments", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkViewHistory),"Could not click View History ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,vfycomments).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.comments.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Edited comments history  failed", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(getText(selenium,vfycomments).toLowerCase(new java.util.Locale("en","US")).trim().contains(date1.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Edited comments history  failed", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(getText(selenium,vfycomments).toLowerCase(new java.util.Locale("en","US")).trim().contains(time1.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Edited comments history  failed", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
		    
		    assertTrue(getText(selenium,vfycomments1).toLowerCase(new java.util.Locale("en","US")).trim().contains(editedComment.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Edited comments history failed", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(getText(selenium,vfycomments1).toLowerCase(new java.util.Locale("en","US")).trim().contains(time2.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Edited comments history  failed", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(getText(selenium,vfycomments1).toLowerCase(new java.util.Locale("en","US")).trim().contains(date2.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Edited comments history  failed", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
			
			}
			return returnvalue;
		
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return returnvalue;

}

}
