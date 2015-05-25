package com.nexia.selenium.testscripts.section.chartprevisit.diagnostictestreport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNextUnsignedReportQueueAfterSigned extends AbstractChartPreVisit{
 	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Next Unsigned Report Queue After Signed ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNextUnsignedReportQueueAfterSigned(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_015";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	/** 
	 * Verify Report View
	 * function to Verify Report View
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 31, 2014
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
				
	           if (diData.testCaseId.equals("TC_CDR_014")||diData.testCaseId.equals("TC_CDR_015")){
	        	   ChartPreVisitLib diData1 = new ChartPreVisitLib();			 
	        	   diData1.workSheetName = "CreateDiagnosticReport";
	       		   diData1.testCaseId = "TC_CDR_013";
	       		   diData1.fetchChartPreVisitTestData(); 
				   assertTrue(navigateToCorresReport(selenium,diData1),"Could not Navigate to File document",selenium, ClassName, MethodName);
				   waitForPageLoad(selenium);	
			       assertTrue(CreateDiagnosticReport(selenium,diData1,userAccount),"Creation of Diagnostic  Report failed ", selenium, ClassName,MethodName);  
			       waitForPageLoad(selenium);	
				}
				
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
				//  Step-5 : Navigate to the report								  //
				//--------------------------------------------------------------------//
				
				assertTrue(type(selenium,searchTextBox, diData.testName),"Could not type facility name", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, vfyUnsignedDiReports),"Could not click  diagnostic report in list ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				// -------------------------------------------------------------------//
				//  Step-6 : Verify the report	View							  //  
				//--------------------------------------------------------------------//
				
				assertTrue(isElementPresent(selenium,btnDISign),"Report is not present on the right side ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,lnkDiagnosticReports),"Patient Summary is not present on the left side", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(!isElementPresent(selenium,vfyUnsignedDiReports),"List View is not hide left side", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				// -------------------------------------------------------------------//
				//  Step-7 : Verify the Multiple report View							  //  
				//--------------------------------------------------------------------//
				
				 if (diData.testCaseId.equals("TC_CDR_014")){
					 
					assertTrue(click(selenium,hideQueue),"Could not click  hide link", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,vfyUnsignedDiReports1),"Could not click  diagnostic report in list ", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(isElementPresent(selenium,btnDISign),"Report is not present on the right side ", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					assertTrue(isElementPresent(selenium,lnkDiagnosticReports),"Patient Summary is not present on the left side", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(!isElementPresent(selenium,vfyUnsignedDiReports),"List View is not hide left side", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
				 }
				 
				// -------------------------------------------------------------------//
				//  Step-7 : Verify the print and fax button					      //  
				//--------------------------------------------------------------------//
					
				 if (diData.testCaseId.equals("TC_CDR_015")){
					 assertTrue(click(selenium, lnkDiagnosticReports),"Could not click  diagnostic test link", selenium, ClassName,MethodName);
					 waitForPageLoad(selenium);
					 assertTrue(click(selenium, btnPrintOrSendButton),"Could not click Print/Send button", selenium, ClassName,MethodName);
					 waitForPageLoad(selenium);
					 assertTrue(isElementPresent(selenium,btnPrintButton),"Print button is not present", selenium, ClassName,MethodName);
					 waitForPageLoad(selenium);
					 assertTrue(isElementPresent(selenium,btnFaxButton),"Fax button is not present", selenium, ClassName,MethodName);
					 waitForPageLoad(selenium);
					 assertTrue(isElementPresent(selenium,btnSelectAll),"Select all check box is not present", selenium, ClassName,MethodName);
					 waitForPageLoad(selenium);
					 assertTrue(!isChecked(selenium,btnFstDIReport),"First DI report is  checked", selenium, ClassName,MethodName);
					 waitForPageLoad(selenium); 
					 assertTrue(!isChecked(selenium,btnSecDIReport),"Second DI report is  checked", selenium, ClassName,MethodName);
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
