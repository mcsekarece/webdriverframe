package com.nexia.selenium.testscripts.section.chartprevisit.LabResult;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPrintAndSendOptionInLab extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrnitAndSendOptionForFlowSheetAndListView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_001";
		labData.fetchChartPreVisitTestData();
		verifyPrintAndSend(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Print / Send option For Lab View
	* @action 		  verifying Print / Send option For Lab View
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @defect		  #5180	
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 21, 2013
	***************************************************************************************************/
	public boolean verifyPrintAndSend(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
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
			//  Step-2: Create New Patient//
			//--------------------------------------------------------------------//
			
			assertTrue(goToRegisterPatient(selenium), "Could not go to register patient", selenium, ClassName, MethodName);
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_002";
			patientData.fetchHomeTestData();
			createNewPatientWithMandatory(selenium,patientData);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(fileReportWithMandatory(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			selenium.focus(lnkChartLabFlowSheet);
			selenium.clickAt(lnkChartLabFlowSheet, "");
			
			if(isElementPresent(selenium,lnkLabPrint)){
				Assert.fail("Print and send button is getting displayed");
			}
			
			selenium.focus(lnkLabtab);
			selenium.clickAt(lnkLabtab, "");
			
			if(!isElementPresent(selenium,lnkLabPrint)){
				Assert.fail("Print and send button is getting displayed");
			}else
				return true;
			
			return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
