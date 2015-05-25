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

public class VerifySignedRefileReporttoAnotherPatient extends  AbstractChartPreVisit{

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Signed Refile report to Another Patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySignedRefiletoAnotherPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_025";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}	
	
	/**
	 * Verify Signed Refile report  to Another Patient
	 * function to verify Signed Refile to Another Patient 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 11, 2014
	 */
	
	public boolean createDiagnosticTestReport(String seleniumHost,int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib diData) throws IOException{
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
			System.out.println(" queueValue" + queueValue);
			
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
			
			//--------------------------------------------------------------------//
			//  Step-5: Goto Diagnostic work queue 								 //
			//--------------------------------------------------------------------//			
		
			assertTrue(click(selenium, queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,vfyUnsignedDiReports).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"Diagnostic report not created successfully", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6 : Navigate to DI Report
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, vfyUnsignedDiReports),"Could not click  diagnostic report in list ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnDISign),"Could not navigate to diagnostic report page ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnDISign),"Could not click sign button ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,btnDISign),"Sign the diagnostic report failed ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium); 
			
			//--------------------------------------------------------------------//
			//  Step-7 : Navigate to Refile Page
			//--------------------------------------------------------------------//
			
					
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,diData.patientId),"Search patient failed", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
			
		    assertTrue(click(selenium,lnkMore),"Could not click more button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkDiagnosticReports),"Could not click Diagnostic link report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"Signed"),"Could not select Signed Status ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,searchTextBox,diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(keyPress(selenium,searchTextBox,"\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSignedAction),"Could not click action button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSignedViewReport),"Could not click link Signed View Report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, action),"Could not click  refile action button ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkRefileOption),"Could not click  Refile button ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7 : Refile Report
			//--------------------------------------------------------------------//

			ChartPreVisitLib diData1 = new ChartPreVisitLib();
			diData1.workSheetName = "CreateDiagnosticReport";
			diData1.testCaseId = "TC_CDR_005";
			diData1.fetchChartPreVisitTestData();
			
			assertTrue(type(selenium,txtSearchFileToPatient,diData1.patientId),"Could not type patient id",selenium, ClassName, MethodName);
        	waitForPageLoad(selenium);
        	
			assertTrue(clickAt(selenium,txtSearchFileToPatient, ""),"Could not perform click At",selenium, ClassName, MethodName);
			assertTrue(focus(selenium,txtSearchFileToPatient),"Could not perform focus",selenium, ClassName, MethodName);
			assertTrue(fireEvent(selenium,txtSearchFileToPatient,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
			assertTrue(keyPress(selenium,txtPatientBox, "\\9"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		
			waitForElement(selenium, txtSearchFileToPatient, 30000);
			assertTrue(isElementPresent(selenium,txtSearchFileToPatient),"Search Results are not displayed for the patient with ID :-"+ diData.patientId,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			System.out.println(getText(selenium,patientInfoWid));
     		assertTrue(getText(selenium,patientInfoWid).toLowerCase(new java.util.Locale("en", "US")).trim().contains(diData.patientId.trim().toLowerCase(new java.util.Locale("en", "US"))),"Could not get the text value",selenium, ClassName, MethodName);
			
     		assertTrue(selectValueFromAjaxList(selenium,ajxFiletosection,diData1.fileToSection), "Could not select file to section",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
     		
			assertTrue(click(selenium, btnSOSave),"Could not click  save button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!isElementPresent(selenium,btnSOSave),"Save refile failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium); 

			assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium); 
			 			 
			//--------------------------------------------------------------------//
		   //  Step-8 : verify Unsigned Refile to Another Patient                 //
		   //--------------------------------------------------------------------//

			assertTrue(verifySignedRefiletoAnotherPatient(selenium,diData,diData1,userAccount),"Verify Report Details failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			return returnvalue;
		
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return returnvalue;

}	

public boolean verifySignedRefiletoAnotherPatient(Selenium selenium,ChartPreVisitLib diData, ChartPreVisitLib diData1, String userAccount) throws IOException{
	
	
	assertTrue(searchPatientNexiaForProviderHomePage(selenium,diData1.patientId),"Search patient failed", selenium, ClassName,MethodName);
    waitForPageLoad(selenium);
	
    assertTrue(click(selenium,lnkMore),"Could not click more button", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(click(selenium,lnkDiagnosticReports),"Could not click Diagnostic link report", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"Signed"),"Could not select Unsigned Status ",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(type(selenium,searchTextBox,diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(keyPress(selenium,searchTextBox,"\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	// Verify Signed details is present in refiled report or not
	
	assertTrue(!getText(selenium,vfySignedDiReportExpand).toLowerCase(new java.util.Locale("en","US")).trim().contains
		("Signed by".trim()),"Signed details is present in refiled report", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
		
	assertTrue(click(selenium,vfySignedDiReportsChart),"Couldn't click the report", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);

	assertTrue(getText(selenium,vfySignedDiReportsChart).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"Refile to another patient not matched", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(getText(selenium,lblDIReportHeader).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.AccessionNumber),"Accession number not matched", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	
	
	return true;
				
	}


}
