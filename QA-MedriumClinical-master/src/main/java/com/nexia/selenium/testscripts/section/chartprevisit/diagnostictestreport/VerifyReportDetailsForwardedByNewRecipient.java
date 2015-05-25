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

public class VerifyReportDetailsForwardedByNewRecipient extends AbstractChartPreVisit{
	
	 @Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify  Report Details Forwarded by New Recipient")
	 @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifyForwardedReportDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_005";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	 
	 /**
		 * Verify  Report Details Forwarded by New Recipient
		 * function to Verify  Report Details Forwarded by New Recipient
		 * @param 		seleniumHost
		 * @param 		seleniumPort
		 * @param 		browser
		 * @param 		webSite
		 * @throws      IOException 
		 * @since  	    Nov 03, 2014
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
				waitForPageLoad(selenium);	
				
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

				//--------------------------------------------------------------------//
				//  Step-5: Navigate to the Corresponding Report
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
				
				//--------------------------------------------------------------------//
				//  Step-6 :Forward the Diagnostic  Report to another user
				//--------------------------------------------------------------------//
				
				Calendar cal=Calendar.getInstance();
			  	SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
				String time1= dateFormat.format(cal.getTime());
			
				assertTrue(click(selenium, action),"Could not click  action button ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkForwardAction),"Could not click the link Forward", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(getText(selenium,show).isEmpty(),"Show option is not blank as default", selenium, ClassName,MethodName);
		        waitForPageLoad(selenium);
		        assertTrue(getText(selenium,txtForwardedComments).isEmpty(),"Forwarded Commnet field is not blank as default", selenium, ClassName,MethodName);
		        waitForPageLoad(selenium);
		     
		        assertTrue(selectValueFromAjaxList(selenium,show,diData.forwardTo), "Could not select forward TO  provider",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtForwardedComments, diData.facilityName),"Could not forwarded comments", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, btnSend),"Could not click the Send button ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,btnDISign),"Could not navigate to diagnostic report page ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				
				//--------------------------------------------------------------------//
				//  Step-7 :Navigate to the Corresponding Forwarded Report
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selectValueFromAjaxList(selenium,showPickList,"Forwarded to"), "Could not select Forwarded TO  provider",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(selectValueFromAjaxList(selenium,forPickList,diData.forwardTo), "Could not select Forwarded TO  provider",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(getText(selenium,vfyForwardStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains("FORWARDED".trim().toLowerCase(new java.util.Locale("en","US"))),"Verify FORWARDED STATUS failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);

				//--------------------------------------------------------------------//
			    //  Step-8: Logout the first user   //
			    //--------------------------------------------------------------------//			
			  
				assertTrue(logoutofApplication(selenium),"Logout Application failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-9: Login as  the Recipient user   //
				//--------------------------------------------------------------------//		
				
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, diData.userName1, diData.userPassword1),"Login Failed ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-10: Navigate to the DI Report
				//--------------------------------------------------------------------//
							
				assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, vfyUnsignedDiReports),"Could not click  forwarded diagnostic report in list ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-11 :Forward the Diagnostic  Report to another user
				//--------------------------------------------------------------------//
		
				assertTrue(click(selenium, action),"Could not click  action button ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkForwardAction),"Could not click the link Forward", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
		        assertTrue(selectValueFromAjaxList(selenium,show,diData.Receivingprovider), "Could not select forward TO  provider",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtForwardedComments, diData.facilityName),"Could not forwarded comments", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, btnSend),"Could not click the Send button by new receipent ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,btnDISign),"Verify  Report Details Forwarded by New Recipient failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				
				// -------------------------------------------------------------------//
				//  Step-13 : Verify the New Recipient Forwarded report details	      // 
				//--------------------------------------------------------------------//
			
				assertTrue(verifyNewRecipientForwardedReportDetails(selenium,diData,userAccount, time1),"Verify the New Recipient Forwarded report details failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			
		}	catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnvalue;
	}
		
	public boolean verifyNewRecipientForwardedReportDetails(Selenium selenium, ChartPreVisitLib diData, String userAccount,String time1) throws IOException{
			
		assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,showPickList,"Forwarded to"), "Could not select Forwarded TO  provider",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(selectValueFromAjaxList(selenium,forPickList,diData.Receivingprovider), "Could not select Forwarded TO  provider",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(getText(selenium,vfyForwardStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains("FORWARDED".trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Recipient FORWARDED STATUS failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
							
		return true;
					
				}
}
