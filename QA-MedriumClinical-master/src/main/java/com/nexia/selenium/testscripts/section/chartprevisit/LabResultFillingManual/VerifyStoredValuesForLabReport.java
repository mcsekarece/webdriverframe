package com.nexia.selenium.testscripts.section.chartprevisit.LabResultFillingManual;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValuesForLabReport extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Stored Value For Final")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueForFinal(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_001";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Stored Value For Partial")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueForPartial(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
			//  Step-6: verify Created lab report//
			//--------------------------------------------------------------------//
			
			if(!verifyStoredValues(selenium,labData,userAccount)){
				returnValue = false;
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib labData,String account){
		String date=null;
		waitForPageLoad(selenium);
	
		if(labData.testCaseId.equals("TC_LR_008")){
			if(!getText(selenium,elementLabReportEntryOnSummery).toLowerCase(new java.util.Locale("en","US")).trim().contains("Partial".trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}else if(!getText(selenium,elementLabReportEntryOnSummery).toLowerCase(new java.util.Locale("en","US")).trim().contains("Final".trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		/*if(!getText(selenium,elementLabReportEntryOnSummery).toLowerCase(new java.util.Locale("en","US")).trim().contains("Manually filled panel".trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		if(!getText(selenium,elementLabReportEntryOnSummery).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.labName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd,yyyy");
			 date=DateFormat.format(cal.getTime());
			 if(!getText(selenium,elementLabReportEntryOnSummery).trim().contains(date.trim())){
					return false;
				}
		}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());
				if(!getText(selenium,elementLabReportEntryOnSummery).trim().contains(date.trim())){
					return false;
				}
		}
		if(!getText(selenium,elementLabReportEntryOnSummery).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.cTime.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,elementLabReportEntryOnSummery).toLowerCase(new java.util.Locale("en","US")).trim().contains("Abnormal".trim().toLowerCase(new java.util.Locale("en","US")))){
			return true;
		}
		
		return true;
	}	
}

