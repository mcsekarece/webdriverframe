package com.nexia.selenium.testscripts.section.chartprevisit.LabResultFillingManual;

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

public class VerifyGraphForLabReport extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Lab Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_001";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Lab Report with MultiPle Result")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabReportWithMultipleResults(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_005";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Lab Report with No Lab Lab Result")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabReportWithNoLabResult(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_002";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Lab Report with Cancel")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabReportWithCancel(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_006";
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
			//  Step-4:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: File new lab report//
			//--------------------------------------------------------------------//
			 assertTrue(fileReport(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMore),"Could not click more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.focus(lnkChartLabFlowSheet);
			selenium.click(lnkChartLabFlowSheet);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabtab ), "Could not click on lab link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Created Lab Report//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,elementLabReportEntry ), "Could not click on lab report entry", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Select lab results for graph//
			//--------------------------------------------------------------------//
			
			if(!labData.testCaseId.equals("TC_LR_002")){
				selenium.focus(elementLabResltCheckBox2);
			selenium.clickAt(elementLabResltCheckBox2, "");
				//assertTrue(selenium.clickAt(elementLabResltCheckBox2, ""), "Could not click on lab result entry", selenium, ClassName, MethodName);
				if(labData.testCaseId.equalsIgnoreCase("TC_LR_005")){
					selenium.focus(elementLabResltCheckBox1);
					selenium.clickAt(elementLabResltCheckBox1, "");
					//assertTrue(click(selenium, ), "Could not click on lab result entry", selenium, ClassName, MethodName);
				}
			}
			
			assertTrue(click(selenium,elementLabGraph ), "Could not click on lab result entry", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(labData.testCaseId.equals("TC_LR_002")){
				Assert.assertEquals(selenium.getAlert(), "You must select at least one test to graph.");
				return true;
			}
			if(labData.testCaseId.equals("TC_LR_006")){
				assertTrue(click(selenium,btnClose ), "Could not click on cancel lab result entry", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lnkBeginEncounterAction)){
					return true;
				}
				return false;
			}
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Graph//
			//--------------------------------------------------------------------//
			if(!verifyGraph(selenium,labData,userAccount)){
				Assert.fail("Lab reports graph is not displaying properly; More Details :"+ labData.toString());
				returnValue=false;
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyGraph(Selenium selenium, ChartPreVisitLib labData, String userAccount ){
		waitForPageLoad(selenium);
		boolean returnValue=true;
		
		String date="";
		
		if(userAccount.equals(CAAccount)){
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat1.format(cal1.getTime());
			
		}else{
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat1.format(cal1.getTime());
			
		}
		
		
		/*if(!getText(selenium,lblLabGraphMain).toLowerCase(new java.util.Locale("en","Us")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","Us")))){
			returnValue=false;
		}*/
		
		if(!getText(selenium,lblLabGraphMain).toLowerCase(new java.util.Locale("en","Us")).trim().contains(labData.testName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			returnValue=false;
		}
		
		if(!getText(selenium,lblLabGraphMain).toLowerCase(new java.util.Locale("en","Us")).trim().contains(labData.result.trim().toLowerCase(new java.util.Locale("en","Us")))){
			returnValue=false;
		}
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MMM yyyy");
		date=DateFormat.format(cal.getTime());
		
		/*if(!getText(selenium,lblLabGraphER).toLowerCase(new java.util.Locale("en","Us")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","Us")))){
			returnValue=false;
		}*/
		if(!getText(selenium,lblLabGraphER1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","Us")))){
			returnValue=false;
		}
		
		return returnValue;
	}
}
