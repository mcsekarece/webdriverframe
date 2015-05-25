package com.nexia.selenium.testscripts.section.chartprevisit.LabReFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeketeAndRestoreRefile extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying view lab report via filedocument section")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyDeleteInRefile(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "FileLabReport";
		orderData.testCaseId = "TC_LR_051";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying view lab report via filedocument section")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyRestoreRefile(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "FileLabReport";
		orderData.testCaseId = "TC_LR_052";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	public boolean verifyLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		{
			Selenium selenium=null;
		try
		{
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium);
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-3:File a lab report to the patient -----------//
			//--------------------------------------------------------------------//
			assertTrue(navigateToCorresReport(selenium,orderData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(CreateLabReportFromFileDocu(selenium,userAccount,orderData), "could not file the report ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
	           if(isElementPresent(selenium, btnErrorClose))
	      			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-4:Advance search the added lab report-----------//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,AdvDownarrow),"Could not click the down arrow under patient search box", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkTabLabs),"Could not click the lab icon", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-5:Search added lab report 			-----------//
			//--------------------------------------------------------------------//\
			assertTrue(type(selenium, txtAccessionNo,uniqueAccNumber),"Could not type patient id", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnAdvanceSearch),"Could not click the search button", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium, btnViewLabReport),"Could not click the View report button button", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);		waitForPageLoad(selenium);	
			assertTrue(click(selenium, lnkEncounterAction),"Could not click Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnDeleteCorres),"Could not click delet Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			assertTrue(type(selenium, txtdeleteReason, "reason"),"Could not type reason for deletion",selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnDeleteReason),"Could not click Delete button;More Details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
	        if(isElementPresent(selenium, btnErrorClose))
	      	assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			assertTrue(click(selenium,AdvDownarrow),"Could not click the down arrow under patient search box", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkTabLabs),"Could not click the lab icon", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtAccessionNo,uniqueAccNumber),"Could not type patient id", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnAdvanceSearch),"Could not click the search button", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat Form=new SimpleDateFormat("MMM dd, yyyy");
			String Date=Form.format(cal.getTime());					
			assertTrue(	selenium.isTextPresent("Deleted on "+Date+" by"),"Deletion statement is not present", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//Restore and Verify in patient lan tab			
			if(	orderData.testCaseId.equals("TC_LR_052"))			
			{			
				
				assertTrue(click(selenium, btnRestore),"Could not click the REstore button", selenium,ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(	selenium.isTextPresent("Restored on "+Date+" by"),"Deletion statement is not present", selenium,ClassName, MethodName);		
				//selenium.getText(selenium.getAttribute("extraInfoLabel@class")).contains("greenFont");
				assertTrue(click(selenium, btnViewLabReport),"Could not click the View report button button", selenium,ClassName, MethodName);
				waitForPageLoad(selenium);		
				Thread.sleep(10000);
				waitForPageLoad(selenium);		
				waitForPageLoad(selenium);		
				selenium.getText(lblpatientName).toLowerCase().contains(orderData.patientId.toLowerCase());
				assertTrue(	selenium.isTextPresent("Lab Report "+uniqueAccNumber),"Deletion statement is not present", selenium,ClassName, MethodName);
			}
		}
		catch(Exception e)
		{
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		}
		return true;
	
	
	
	}
	
}
