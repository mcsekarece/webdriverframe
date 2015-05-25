package com.nexia.selenium.testscripts.section.chartprevisit.diagnostictestreport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyShowAndForFilterConjunction extends AbstractChartPreVisit{
		
		@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Show And For Filter Conjunction Orderedby")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void verifyShowAndForFilterConjunctionOrderedby(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ChartPreVisitLib diData = new ChartPreVisitLib();
			diData.workSheetName = "CreateDiagnosticReport";
			diData.testCaseId = "TC_CDR_012";
			diData.fetchChartPreVisitTestData();		
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
			createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
		}	

		@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Show And For Filter Conjunction CopiedTo")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void verifyShowAndForFilterConjunctionCopiedTo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ChartPreVisitLib diData = new ChartPreVisitLib();
			diData.workSheetName = "CreateDiagnosticReport";
			diData.testCaseId = "TC_CDR_010";
			diData.fetchChartPreVisitTestData();		
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
			createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
		}	

		/**
		 * VerifyShowFilter
		 * function to Verify Show Filter
		 * @param 		seleniumHost
		 * @param 		seleniumPort
		 * @param 		browser
		 * @param 		webSite
		 * @throws      IOException 
		 * @since  	    Oct 21, 2014
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

				
				//--------------------------------------------------------------------//
				//  Step-5 :Verify Show filter
				//--------------------------------------------------------------------//
				
				assertTrue(verifyShowFilter(selenium,diData,userAccount),"Verify Show filter failed", selenium, ClassName,MethodName);
				
				return returnvalue;
			
		}	catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		return returnvalue;

	}
		
	public boolean verifyShowFilter(Selenium selenium, ChartPreVisitLib diData,String userAccount) throws IOException{
			
			assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if (diData.testCaseId.equals("TC_CDR_012")){
				assertTrue(selectValueFromAjaxList(selenium,showPickList,"Ordered by"), "Could not select ordered by option",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selectValueFromAjaxList(selenium,forPickList,diData.Orderingprovider), "Could not select Ordered by provider",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			} else {
				assertTrue(selectValueFromAjaxList(selenium,showPickList,"Copied to"), "Could not select Copied TO  provider",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selectValueFromAjaxList(selenium,forPickList,diData.copiedTo), "Could not select Copied To provider",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			} 
			assertTrue(getText(selenium,vfyServicedate1).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify show filter failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			return true;
			
		}
		
}
