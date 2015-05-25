package com.nexia.selenium.testscripts.section.chartprevisit.LabReportQueue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifynavigationOfOfLabReportList extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Final as Report status for Lab Report in Queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifFinalLabReportInQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_045";
		labData.fetchChartPreVisitTestData();
		verifyLabReportQueue(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	/**
	 * verifyLabReportQueue
	 * function to file new lab report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 12, 2012
	 */
	public boolean verifyLabReportQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData)throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Neixa Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,forPickList,labData.rProvider);
			if(isElementPresent(selenium,"//div[4]/div/div/div/div/div"))
				click(selenium,"//div[4]/div/div/div/div/div");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,firstLabReport)){
			assertTrue(click(selenium,firstLabReport),"Cold not click the report", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMoreTab),"Cold not click the check box", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Cold not click the check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"", selenium, ClassName, MethodName);
			while(isElementPresent(selenium,testResult)){
				assertTrue(click(selenium,labReportCheckBox),"Cold not click the check box", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnkBeginEncounterAction),"Cold not click the check box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"deleteLabReports"),"Cold not click the check box", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtdeleteReason,labData.patientId),"Cold not click the check box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnDeleteReason),"Cold not click the check box", selenium, ClassName, MethodName);
				 if(isElementPresent(selenium, "errorCloseButton"))
						assertTrue(click(selenium, "errorCloseButton"),"", selenium, ClassName, MethodName);
				if(isElementPresent(selenium,lnkVitals))
					break;
				}
			}
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
		//  Step-6: verify Created lab report//
			//--------------------------------------------------------------------//
			ChartPreVisitLib labsData = new ChartPreVisitLib();
			labsData.workSheetName = "FileLabReport";
			labsData.testCaseId = "TC_LR_045";
			labsData.fetchChartPreVisitTestData();
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,labsData.patientId),"Could not select", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Delete Existing lab reports//
			//--------------------------------------------------------------------//
			assertTrue(deletelabReport(selenium,labsData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateTofileReport(selenium,labsData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: File new lab report//
			//--------------------------------------------------------------------//
			assertTrue(fileReport(selenium,labsData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, lnkEnterData),
					"Could not find enter data link",selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Neixa Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(clickAt(selenium,searchBox,""),"Could not click At", selenium, ClassName, MethodName);
			assertTrue(type(selenium,searchBox,labData.patientId),"Cold not click the check box", selenium, ClassName, MethodName);
			assertTrue(focus(selenium,searchBox),"Could not focus", selenium, ClassName, MethodName);
			assertTrue(keyPress(selenium,searchBox, "\\13"),"Could not key press", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,forPickList,labData.rProvider),"Could not select the receiving provider in text box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);	
			if(!verifyStoredValues(selenium,labData,labsData,userAccount)){
				return false;
			}else
				returnValue=true;
			assertTrue(click(selenium,firstLabReport),"Cold not click the check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,"patientName").equals(labData.patientId),"Could not Find the patient name", selenium, ClassName, MethodName);
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib labData,ChartPreVisitLib labsData,String account) throws IOException{
		String date=null;
		
		String Temp[]=labData.oProvider.split(",");
		labData.oProvider=Temp[0];	
		assertTrue(getText(selenium,firstLabReport).toLowerCase(new java.util.Locale("en","US")).trim().contains("Manually filled panel".trim().toLowerCase(new java.util.Locale("en","US"))),"Could not Find the Added details in Queue" , selenium, ClassName, MethodName);
		
		
		assertTrue(getText(selenium,firstLabReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not Find the Added details in Queue" , selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,firstLabReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.labNameCA.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not Find the Added details in Queue" , selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,firstLabReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.oProvider.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not Find the Added details in Queue" , selenium, ClassName, MethodName);
		
		
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
			 date=DateFormat.format(cal.getTime());
			 if(!getText(selenium,firstLabReport).trim().contains(date.trim())){
					return false;
				}
		}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());
				if(!getText(selenium,firstLabReport).trim().contains(date.trim())){
					return false;
				}
		}
		assertTrue(getText(selenium,secondLabReport).toLowerCase(new java.util.Locale("en","US")).trim().contains("Manually filled panel".trim().toLowerCase(new java.util.Locale("en","US"))),"Could not Find the Added details in Queue" , selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,secondLabReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(labsData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not Find the Added details in Queue" , selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,secondLabReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(labsData.labNameCA.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not Find the Added details in Queue" , selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,secondLabReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.oProvider.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not Find the Added details in Queue" , selenium, ClassName, MethodName);
		
	return true;
	}	
}
