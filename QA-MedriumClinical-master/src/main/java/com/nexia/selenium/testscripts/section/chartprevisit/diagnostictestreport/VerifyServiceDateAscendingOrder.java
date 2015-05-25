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

public class VerifyServiceDateAscendingOrder extends AbstractChartPreVisit{
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Service Date Ascending Order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyServiceDateAscendingOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_006";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}	
	
	/**
	 * Verify Service Date Ascending Order
	 * function to CreateDiagnosticTestReport
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
			//  Step-5 :Create another  Diagnostic  Report for the  patient 
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib diData1 = new ChartPreVisitLib();
			diData1.workSheetName = "CreateDiagnosticReport";
			diData1.testCaseId = "TC_CDR_007";
			diData1.fetchChartPreVisitTestData();
			diData1.patientId = diData.patientId;
			
			assertTrue(navigateToCorresReport(selenium,diData1),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(CreateDiagnosticReport(selenium,diData1,userAccount),"Creation of Diagnostic  Report failed ", selenium, ClassName,MethodName);  
	        waitForPageLoad(selenium);	
			
	        assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6 :Verify Service Date Ascending Order
			//--------------------------------------------------------------------//
			
			assertTrue(verifyServiceDateAscendingOrder(selenium,diData,diData1,userAccount),"Verify ServiceDate Ascending Order failed", selenium, ClassName,MethodName);
			
				
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return returnvalue;

}	
	
	public boolean verifyServiceDateAscendingOrder(Selenium selenium, ChartPreVisitLib diData, ChartPreVisitLib diData1,String userAccount) throws IOException{
		String date, date1 = null;
		
		if(userAccount.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("MMM dd,yyyy");
			date=dateFormat.format(cal.getTime());
			
			 cal.add(Calendar.DATE, -1);
			 cal.add(Calendar.MONTH, -1);
			 SimpleDateFormat dateFormat1=new SimpleDateFormat("MMM dd,yyyy");
			 date1=dateFormat1.format(cal.getTime());

		}else{
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MMM dd,yyyy");
			date=DateFormat1.format(cal1.getTime());	
			cal1.add(Calendar.DATE, -1);
			cal1.add(Calendar.MONTH, -1);
			SimpleDateFormat dateFormat1=new SimpleDateFormat("MMM dd,yyyy");
			date1=dateFormat1.format(cal1.getTime());
		}	
		
		assertTrue(click(selenium, queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
	   //Verify service Date 
		
		assertTrue(getText(selenium,vfyServicedate1).toLowerCase(new java.util.Locale("en","US")).trim().contains(date1.toLowerCase(new java.util.Locale("en","US"))),"Verify ServiceDate  failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,vfyServicedate2).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify ServiceDate failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		//Verify test name 	

		assertTrue(getText(selenium,vfyTestname1).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData1.labTestName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Test Name failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,vfyTestname2).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.labTestName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Test Name  failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		
		return true;
		
	}
	

}
