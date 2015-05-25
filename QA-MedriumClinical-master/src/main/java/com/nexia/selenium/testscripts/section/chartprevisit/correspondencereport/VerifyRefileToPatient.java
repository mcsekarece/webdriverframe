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

public class VerifyRefileToPatient extends AbstractChartPreVisit{

	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefiletoSection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_019";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
		//--------------------------------------------------------------------//
		//  Step-2:Delete All Correspondence report							 
		//--------------------------------------------------------------------//	
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(DeletecorrespondenceReport(selenium, corresData),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);	
		//Delete old report in Second Patient 
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.RefilePatient),"Could not search patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(DeletecorrespondenceReport(selenium, corresData),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);	
		//--------------------------------------------------------------------//
		//  Step-3:Create a correspondence report for the patient 						 
		//-------------------------------------------------------------------
		assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateFormat1=new SimpleDateFormat("mssH");
		String date1=dateFormat1.format(cal.getTime());
		corresData.AccessionNumber=date1;		
		assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
		waitForPageLoad(selenium);
    	assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-4:NAvigate to Advance Search 						 
		//-------------------------------------------------------------------//
		assertTrue(click(selenium, AdvDownarrow),"Could not click Advance search down arrow", selenium, ClassName,MethodName);
        waitForPageLoad(selenium);		
		assertTrue(click(selenium, lblCorres),"Could not click Correspondence option  button", selenium, ClassName,MethodName);
        waitForPageLoad(selenium);		
		assertTrue(CorrespondenceAdvanceSearch( selenium, corresData) ,"Could not click the lab link", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);	
		assertTrue(isElementPresent(selenium, btnRefile1),"Search result not found", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnRefile1),"Could not click Refile  button", selenium, ClassName,MethodName);
		//--------------------------------------------------------------------//
		//  Step-4:Re file  to patient 			 
		//-------------------------------------------------------------------//
		assertTrue(VerifyREfileToPatient( selenium, corresData,userAccount) ,"Could not click the lab link", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);	
		
	return true;
	}
	public boolean VerifyREfileToPatient(Selenium selenium, ChartPreVisitLib corresData,String userAccount) throws IOException
		{
		if(!selenium.isChecked(chkFileToPatient))
		{
			assertTrue(click(selenium, chkFileToPatient),"Could not click File to patient check box", selenium, ClassName,MethodName);
		}
		waitForPageLoad(selenium);
		assertTrue(searchPatientNexiaForCorrespondenceRefile(selenium,corresData.RefilePatient),"Could not search patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnRefileSave),"Could not click save   button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);		
		assertTrue(selenium.isTextPresent("Lab report successfully refiled to"),"Conformation message is not present", selenium, ClassName,MethodName);
		assertTrue(click(selenium,btnConClose ),"Could not click view report   button", selenium, ClassName,MethodName);
		assertTrue(click(selenium,btnReport ),"Could not click view report   button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium, lblFirstCorresReport),"Refiles record is not found", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(	corresData.AccessionNumber),"Refiles record is not found", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);	
		assertTrue(searchPatientNexiaForCorrespondenceRefile(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium, lblFirstCorresReport),"Refiles record is not found", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
			return true;
	}
	
	
	
	
}
