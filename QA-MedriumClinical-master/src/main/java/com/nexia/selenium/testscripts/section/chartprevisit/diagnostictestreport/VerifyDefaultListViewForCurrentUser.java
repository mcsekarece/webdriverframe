package com.nexia.selenium.testscripts.section.chartprevisit.diagnostictestreport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultListViewForCurrentUser extends AbstractChartPreVisit{
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Default List View for current user")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultListViewForCurrentUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_004";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}	
	
	/**
	 * VerifyDefaultListViewForCurrentUser
	 * function to VerifyDefaultListViewForCurrentUser
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 17, 2014
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
			
			//Verify Created Report 
			
			assertTrue(click(selenium, queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			String firstUserCheckValue= diData.facilityName;
			
			assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,vfyUnsignedDiReports).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"First User Diagnostic report not created successfully", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,vfyUnsignedDiReports).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.labTestName.trim().toLowerCase(new java.util.Locale("en","US"))),"First User Diagnostic report not created successfully", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
		    //  Step-5: Logout the first user   //
		    //--------------------------------------------------------------------//			
		  
			assertTrue(logoutofApplication(selenium),"Logout Application failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Login as  the Second user   //
			//--------------------------------------------------------------------//		
			
			diData.workSheetName = "CreateDiagnosticReport";
			diData.testCaseId = "TC_CDR_005";
			diData.fetchChartPreVisitTestData();
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, diData.userName, diData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Diagnostic Report
			//--------------------------------------------------------------------//			
			
			assertTrue(navigateToCorresReport(selenium,diData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-8 :Diagnostic  Report for the  patient 
			//--------------------------------------------------------------------//
		
			assertTrue(CreateDiagnosticReport(selenium,diData,userAccount),"Creation of Diagnostic  Report failed ", selenium, ClassName,MethodName);  
	        waitForPageLoad(selenium);	
			
	        assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			
           //Verify Created Report 
			
			
			assertTrue(click(selenium, queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			String secondUserCheckValue= diData.facilityName;
			
			assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,vfyUnsignedDiReports).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"Second user Diagnostic report not created successfully", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,vfyUnsignedDiReports).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.labTestName.trim().toLowerCase(new java.util.Locale("en","US"))),"Second user Diagnostic report not created successfully", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

           // Logout the second user 
			
			assertTrue(logoutofApplication(selenium),"Logout Application failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		   //Login as first user
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, diData.userName, diData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
		   //Verify Default list  value of first user 
			
			assertTrue(click(selenium, queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,searchTextBox, firstUserCheckValue),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,vfyUnsignedDiReports).toLowerCase(new java.util.Locale("en","US")).trim().contains(firstUserCheckValue.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify First user list value failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Verify List value of second user
			
			assertTrue(keyPress(selenium,searchTextBox, "\\b"),"Could not perform delete search value ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,forPickList,diData.Receivingprovider),"Could not select the second user provider  from pick list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,searchTextBox, secondUserCheckValue),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,vfyUnsignedDiReports).toLowerCase(new java.util.Locale("en","US")).trim().contains(secondUserCheckValue.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Second user list value failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			return returnvalue;
		
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return returnvalue;

}
}
