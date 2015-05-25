package com.nexia.selenium.testscripts.section.chartprevisit.diagnostictestreport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPrintAndFaxOption extends AbstractChartPreVisit{
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Print Option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrintOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_016";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Fax Option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_017";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	/** 
	 * Verify Print And Fax Option
	 * function to Verify Print And Fax Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 29, 2014
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
			//  Step-5 : Navigate to the report								      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, vfyUnsignedDiReports),"Could not click  diagnostic report in list ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkDiagnosticReports),"Patient Summary is not present on the left side", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// -------------------------------------------------------------------//
			//  Step-6 : Navigate to the Print function 	      //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkDiagnosticReports),"Could not click Diagnostic link report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnPrintOrSendButton),"Could not click Print/Send button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
		    assertTrue(click(selenium,btnSelectAll),"Not Select all check box", selenium, ClassName,MethodName);
		 	waitForPageLoad(selenium);
		 	
		 	assertTrue(click(selenium,btnFstDIReport)," Couldn't click First DI report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium); 
			
			// -------------------------------------------------------------------//
			//  Step-7 : Verify Print function 	      							//
			//--------------------------------------------------------------------//
			
			String date = null;
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat dateFormat=new SimpleDateFormat("MMM dd,yyyy");
				date=dateFormat.format(cal.getTime());
			}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat dateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				date=dateFormat1.format(cal1.getTime());		
			}	
			
			if (diData.testCaseId.equals("TC_CDR_016")){
				
			assertTrue(click(selenium,btnPrintButton),"Couldn't click the Print button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			assertTrue(verifyPrintOption(selenium,diData,date),"Verify Print Option failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			}
			// -------------------------------------------------------------------//
			//  Step-8 : Verify Fax function 	      							 //
			//--------------------------------------------------------------------//
			
			if (diData.testCaseId.equals("TC_CDR_017")){
				assertTrue(click(selenium,btnFaxButton),"Couldn't click the Fax button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(verifyFaxOption(selenium,diData,date),"Verify Fax Option failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
	    	 return returnvalue;
		
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return returnvalue;

}
	
public boolean verifyPrintOption(Selenium selenium, ChartPreVisitLib diData,String date) throws IOException{
	
	HomeLib patientData = new HomeLib();
	patientData.workSheetName = "PatientData";
	patientData.testCaseId = "TC_NPC_004";
	patientData.fetchHomeTestData();
	
	assertTrue(getText(selenium,lblDIPrintFrameTitle).toLowerCase(new java.util.Locale("en","US")).trim().contains("Diagnostic Imaging Report"),"Verify Print Function failed", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains(date),"Date printed not matched", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.patientId),"Patient Id not matched", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.patientId1),"Patient Id not matched", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
    assertTrue(isElementPresent(selenium,btnPrintClose),"Verify Print function failed", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	
	// other details
	assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.date),"Date printed not matched", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob),"DOB printed not matched", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet1),"DOB printed not matched", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrstate1),"DOB printed not matched", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.primaryPhoneNumber1),"DOB printed not matched", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);

	return true;
		
	}
	
public boolean verifyFaxOption(Selenium selenium, ChartPreVisitLib diData,String date) throws IOException{
	
	assertTrue(getText(selenium,lblDIPrintFrameTitle).toLowerCase(new java.util.Locale("en","US")).trim().contains("Diagnostic Imaging Report"),"Verify Print Function failed", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
    assertTrue(isElementPresent(selenium,btnPrintClose),"Verify Print function failed", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	
	
	return true;
		
	}
	
}
