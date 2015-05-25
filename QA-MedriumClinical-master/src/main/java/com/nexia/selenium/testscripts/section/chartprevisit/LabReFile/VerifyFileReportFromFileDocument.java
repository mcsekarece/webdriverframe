package com.nexia.selenium.testscripts.section.chartprevisit.LabReFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyFileReportFromFileDocument extends AbstractChartPreVisit{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying view lab report via filedocument section")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyRefileToPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "FileLabReport";
		orderData.testCaseId = "TC_LR_049";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying view lab report via filedocument section")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyRefileToPatientDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "FileLabReport";
		orderData.testCaseId = "TC_LR_050";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	

	/**
	 * verifyLabReport
	 * function to verify view lab report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 6, 2014
	 */
	
	public boolean verifyLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		{Selenium selenium=null;
		String date;
			try
			{
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + orderData.toString());
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
				waitForPageLoad(selenium);		
				if (userAccount.equals(CAAccount)) {
					Calendar cal1 = Calendar.getInstance();
					SimpleDateFormat DateFormat1 = new SimpleDateFormat(
							"MMM d, yyyy");
					date = DateFormat1.format(cal1.getTime());
								
				} else {
					Calendar cal1 = Calendar.getInstance();
					SimpleDateFormat DateFormat1 = new SimpleDateFormat(
							"MM/dd/yyyy");
						date = DateFormat1.format(cal1.getTime());
								}
				assertTrue(selenium.isTextPresent(orderData.DocumentType),"Could not click the search button", selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent(uniqueAccNumber),"Could not find the added report in Advance search", selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Service date:"),"Could not filed the service date in added lab report", selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent(date),"Could not filed the service date in added lab report", selenium,ClassName, MethodName);
				
				assertTrue(selenium.isTextPresent("Recipient:"),"Could not find the recipient name in added report", selenium,ClassName, MethodName);
				waitForPageLoad(selenium);		
				
				if(	orderData.testCaseId.equals("TC_LR_049"))
				{
				assertTrue(click(selenium, btnRefile1),"Could not click Refile  button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(!selenium.isChecked(chkFileToPatient))
				{
					assertTrue(click(selenium, chkFileToPatient),"Could not click File to patient check box", selenium, ClassName,MethodName);
				}
				waitForPageLoad(selenium);
				ChartPreVisitLib orderData1 = new ChartPreVisitLib();
				orderData1.workSheetName = "CreateLabOrder";
				orderData1.testCaseId = "TC_OL_001";
				orderData1.fetchChartPreVisitTestData();
				assertTrue(searchPatientNexiaForCorrespondenceRefile(selenium,"a"),"Could not search patient",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnRefileSave),"Could not click save   button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);		
				assertTrue(selenium.isTextPresent("Lab report successfully refiled to"),"Conformation message is not present", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnConClose ),"Could not click view report   button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium, btnViewLabReport),"Could not click lab tab   button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				waitForPageLoad(selenium);	
				waitForPageLoad(selenium);	
				assertTrue(click(selenium, lnkLabtab),"Could not click lab tab   button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				waitForPageLoad(selenium);	
				assertTrue(selenium.isElementPresent(lnklabreport),"Added report is missing", selenium, ClassName,MethodName);
				assertTrue(selenium.isTextPresent(date),"Could not filed the service date in added lab report", selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent(uniqueAccNumber),"Could not find the added report in Refiled patient", selenium,ClassName, MethodName);
				}
				
			}
			catch(Exception e )
			{
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return true;
		}
	
	
	
	}	
}
