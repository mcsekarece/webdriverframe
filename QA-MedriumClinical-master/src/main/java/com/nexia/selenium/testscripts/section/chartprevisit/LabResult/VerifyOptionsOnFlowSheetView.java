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

public class VerifyOptionsOnFlowSheetView extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGraphSelected(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
	public void verifyGraphSelectedWithNolabEntrySelected(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
	public void verifyGraphStoredValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
	public void verifyCloseButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_010";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecatogorizedWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_011";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecatogorized(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_012";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMergeWithoutLabSelected(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_032";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMergeWitLabSelected(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_033";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMergeInFlowSheet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_034";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMergeGraph(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_035";
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
			
			selenium.focus(lnkChartLabFlowSheet);
			selenium.clickAt(lnkChartLabFlowSheet, "");
		
			//--------------------------------------------------------------------//
			//  Step-4: Verify Options//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnLabOptions),"Unable to click on options button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(labData.testCaseId.equals("TC_LR_032")||labData.testCaseId.equals("TC_LR_033")||labData.testCaseId.equals("TC_LR_034")||labData.testCaseId.equals("TC_LR_035")){
				if(verifyMerge(selenium,labData,userAccount)){
				return true;
				}
				else{
					fail("Merge selected failed");
				}
			}
			
			if(labData.testCaseId.equals("TC_LR_011")){
				selectValueFromAjaxList(selenium,ajxReCatogorize,"Chemistry");
				waitForPageLoad(selenium);
				
				if(getText(selenium,lblAlert).contains("Please select one or more test(s) to recategorize")){
					return true;
				}
				else{
					fail("Alert didn't appear");
				}
			}
			
			if(labData.testCaseId.equals("TC_LR_005")){
				
				assertTrue(click(selenium,btnGraph),"Unable to click on Graph button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				Assert.assertEquals(selenium.getAlert(), "You must select at least one test to graph.");
				return true;
			}
			assertTrue(click(selenium,chkLabEntry),"Unable to click on options button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(labData.testCaseId.equals("TC_LR_012")){
				selectValueFromAjaxList(selenium,ajxReCatogorize,"Chemistry");
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnOkButton),"Unable to click on ok button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(getText(selenium,lblCategory).contains("Chemistry")){
					return true;
				}
				else{
					fail("Catogorization failed");
				}
				
				if(getText(selenium,lblCategoryTestName).contains(labData.testName)){
					return true;
				}
				else{
					fail("Catogorization failed");
				}
				
				
		}
			
			assertTrue(click(selenium,btnGraph),"Unable to click on Graph button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblGraphPopup)){
				return true;
			}
			else{
				fail("Graph didn't appear");
			}
			
			if(labData.testCaseId.equals("TC_LR_010")){
				assertTrue(click(selenium,btnClose),"Unable to click on close button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium,lblGraphPopup)){
					fail("Graph pop up didn't close properly");
				}
				else{
					return true;
				}
			}
			
			if(!verifyGraph(selenium,labData,userAccount)){
				fail("Flow sheet view details are not getting displayed properly");
			}
			return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyMerge(Selenium selenium,ChartPreVisitLib labData,String userAccount) throws IOException{
		boolean returnValue=true;
		if(labData.testCaseId.equals("TC_LR_032")){
			assertTrue(click(selenium,btnMergeSelected),"Unable to click on Merge button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblAlert).contains("More than one test result must be selected")){
				return returnValue;
			}
			else{
				fail("Alert didn't appear");
			}
		}
		
		if(labData.testCaseId.equals("TC_LR_033")){
			
			assertTrue(click(selenium,chkLabEntry),"Unable to click on options button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnMergeSelected),"Unable to click on Merge button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblAlert).contains("More than one test result must be selected")){
				return returnValue;
			}
			else{
				fail("Alert didn't appear");
			}
		}
		if(labData.testCaseId.equals("TC_LR_034")||labData.testCaseId.equals("TC_LR_035")){
			
			assertTrue(click(selenium,chkLabEntry),"Unable to click on options button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,chkLabEntry1)){
			click(selenium,chkLabEntry1);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnMergeSelected),"Unable to click on Merge button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,rdoFstLabTest),"Unable to click on lab test result button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkContinue),"Unable to click on Continue button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			
			if(!verifyGraphForMerge(selenium,labData,userAccount)){
				fail("Flow sheet view details are not getting displayed properly");
			}
		
		}
		
		return returnValue;
		
		}
	
	public boolean verifyGraph(Selenium selenium,ChartPreVisitLib labData,String userAccount) throws IOException{
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
		
		if(!getText(selenium,lblGraph).contains(date)){
			return false;
		}
		
		if(!getText(selenium,lblGraph).contains(labData.testName)){
			return false;
		}
		
		if(!getText(selenium,lblGraph).contains(labData.result)){
			return false;
		}
				/*if(labData.testCaseId.equals("TC_LR_005")){
			
			if(!getText(selenium,lbFlowSheetView).contains(labData.testName1)){
				return false;
			}
			
			if(!getText(selenium,lbFlowSheetView).contains(labData.result)){
				return false;
			}
		}
		*/
		return returnValue;
		
		}
	public boolean verifyGraphForMerge(Selenium selenium,ChartPreVisitLib labData,String userAccount) throws IOException{
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
		
		assertTrue(isTextPresent(selenium,date),"Unable to find date in Lab tab", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,labData.testName),"Unable to find test naem in  Lab tab", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,labData.result),"Unable to find test result in  Lab tab", selenium, ClassName, MethodName);
		if(labData.testCaseId.equals("TC_LR_035")){
		
			if(!isChecked(selenium,chkLabEntry)){
				assertTrue(click(selenium,chkLabEntry),"Unable to click on options button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
		
		
		assertTrue(click(selenium,btnGraph),"Unable to click on Graph button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		}
		
		assertTrue(isTextPresent(selenium,date),"Unable to find date in graph pop", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,labData.testName),"Unable to find test naem in graph pop", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,labData.result),"Unable to find test result in graph pop", selenium, ClassName, MethodName);
		
		/*if(labData.testCaseId.equals("TC_LR_005")){
			
			if(!getText(selenium,lbFlowSheetView).contains(labData.testName1)){
				return false;
			}
			
			if(!getText(selenium,lbFlowSheetView).contains(labData.result)){
				return false;
			}
		}
		*/
		return returnValue;
		
	}
}
