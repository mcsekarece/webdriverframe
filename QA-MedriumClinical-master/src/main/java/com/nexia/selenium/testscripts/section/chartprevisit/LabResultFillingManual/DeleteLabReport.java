package com.nexia.selenium.testscripts.section.chartprevisit.LabResultFillingManual;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteLabReport extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for delete file New Lab Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deletefileNewLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_001";
		labData.fetchChartPreVisitTestData();
		deletefileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for delete labReport Test Result")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deletelabReportTestResult(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_003";
		labData.fetchChartPreVisitTestData();
		deletefileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "delete labReport From Report Display")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deletelabReportFromReportDisplay(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_002";
		labData.fetchChartPreVisitTestData();
		deletefileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	/**
	 * deletefileNewReport
	 * function to file new lab report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 07, 2012
	 */
	public boolean deletefileNewReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing lab reports//
			//--------------------------------------------------------------------//
			assertTrue(deletelabReport(selenium,labData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
				assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: File new lab report//
			//--------------------------------------------------------------------//
			assertTrue(fileReport(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete new lab report//
			//--------------------------------------------------------------------//
			
			if(labData.testCaseId.equals("TC_LR_002")){
			    	assertTrue(navigateTolabListView(selenium,labData),"Deletion Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,elementLabReportEntry ), "Could not click on lab report entry", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkBeginEncounterAction ), "Could not click on Actions entry", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,elementDeleteReports ), "Could not click on delete button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtdeleteReason,"Reason"), "Could not type reason", selenium, ClassName, MethodName);
				click(selenium,btnDeleteReason);
				waitForPageLoad(selenium);
				
				
			}
			assertTrue(deletelabReport(selenium,labData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify Created lab report//
			//--------------------------------------------------------------------//
			assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(labData.testCaseId.equals("TC_LR_001")){
				if(isElementPresent(selenium,lnkActionsLink)){
					return returnValue;
				}else
					returnValue = false;
			}
				else if(labData.testCaseId.equals("TC_LR_002")){
					if(isElementPresent(selenium,ajxLabTestName)){
						return returnValue;
					}else
						returnValue = false;
				}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
