package com.nexia.selenium.testscripts.section.chartprevisit.LabResult;

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

public class VerifyLabInFlowSheetView extends AbstractChartPreVisit {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabInFlowSheetView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_001";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabInFlowSheetViewWithMultipleTests(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_005";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyViewFullWidth(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_006";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyViewSplitWidth(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_008";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	/**
	 * fileNewReport
	 * function to file new lab report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 07, 2012
	 */
	public boolean fileNewReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
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
			if(labData.testCaseId.equals("TC_LR_002")){
				assertTrue(fileReportWithMandatory(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else 
			assertTrue(fileReport(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
//			selenium.isVisible(lnkChartLabFlowSheet);
//			selenium.focus(lnkChartLabFlowSheet);
//			selenium.clickAt(lnkChartLabFlowSheet, "");			
			selenium.isVisible(lnkLabs);
			selenium.focus(lnkLabs);
			selenium.clickAt(lnkLabs, "");			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkLabFlowSheetView),
					"Could not click the List view", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(labData.testCaseId.equals("TC_LR_006")){
				assertTrue(click(selenium,btnViewFullWidth),"Could not click on full width button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(selenium.isTextPresent("File Report")){
					Assert.fail("View FUll width is not working properly");
				}
				else{
					return true;
				}
			}
			if(labData.testCaseId.equals("TC_LR_008")){
				selenium.isVisible(btnViewFullWidth);
				
				assertTrue(click(selenium,btnViewFullWidth),"Could not click on full width button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnViewSplitWidth),"Could not click on split width button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(selenium.isTextPresent("File Lab Report")){
					return true;
				}
				else{
					Assert.fail("View Split width is not working properly");
				}
			}
			if(!verifyFlowSheetView(selenium,labData,userAccount)){
				Assert.fail("Flow sheet view details are not getting displayed properly");
			}
			
			return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyFlowSheetView(Selenium selenium,ChartPreVisitLib labData,String userAccount) throws IOException{
	boolean returnValue=true;
	String date="";
	if(userAccount.equals(CAAccount)){
		Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
			date=DateFormat.format(cal.getTime());
			int date1=Integer.parseInt(date);
			if(date1<10){
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
				date=DateForma1t.format(cal.getTime());
			}else{
				SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat2.format(cal.getTime());
			}
		}else{
		Calendar cal1=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
		date=DateFormat1.format(cal1.getTime());
		
	}
	assertTrue(click(selenium, lnkLabFlowSheetView),
	"Could not click the List view", selenium, ClassName, MethodName);
	
	waitForPageLoad(selenium);
	assertTrue(selenium.isTextPresent(date), ""	+ "In FlowSheet View Date Not Present", selenium, ClassName, MethodName);waitForPageLoad(selenium);
	
	waitForPageLoad(selenium);
	assertTrue(selenium.isTextPresent(labData.testName), ""	+ "In FlowSheet testName1 Not Present", selenium, ClassName, MethodName);waitForPageLoad(selenium);
	
	waitForPageLoad(selenium);
	assertTrue(selenium.isTextPresent(labData.result), ""	+ "In FlowSheet Result Not Present", selenium, ClassName, MethodName);waitForPageLoad(selenium);
	

	
	if(labData.testCaseId.equals("TC_LR_005")){
		
		if(!selenium.isTextPresent(labData.testName1)){
			return false;
		}
		
		if(!selenium.isTextPresent(labData.result)){
			return false;
			}
		}
	
	return returnValue;
	
	}
}
