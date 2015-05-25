package com.nexia.selenium.testscripts.section.chartprevisit.LabResultFillingManual;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLabHistoryWithAbnormal extends AbstractChartPreVisit {
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify History for Lab report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHistoryForLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to lab history option//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkLabReport), "Could not click on patient options link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,elementLabReportEntry ), "Could not click on lab report entry", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkBeginEncounterAction),"Cold not click the actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,elementLabHistory),"Cold not click on lab history option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Count the number of records under lab history//
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,elementErrorClose)){
				click(selenium,elementErrorClose);
			}
			int count=1,counter=0;
			while(isElementPresent(selenium,"//a["+count+"]/div/div")){
				count++;
				if(getText(selenium,"//a["+count+"]/div/div").toLowerCase(new java.util.Locale("en","US")).trim().contains("ABNORMAL".trim().toLowerCase(new java.util.Locale("en","US")))){
					counter++;
				}
				if(count>35)
					break;
			}
			
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
			//  Step-6: Navigate to Created Lab Report//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,elementLabReportEntry ), "Could not click on lab report entry", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Lab History//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkBeginEncounterAction),"Cold not click the actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,elementLabHistory),"Cold not click on lab history option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Count the number of records under lab history//
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,elementErrorClose)){
				click(selenium,elementErrorClose);
			}
			int count1=1,counter1=0;
			while(isElementPresent(selenium,"//a["+count1+"]/div/div")){
				count1++;
				if(getText(selenium,"//a["+count1+"]/div/div").toLowerCase(new java.util.Locale("en","US")).trim().contains("ABNORMAL".trim().toLowerCase(new java.util.Locale("en","US")))){
					counter1++;
				}
				if(count1>35)
					break;
			}
			if(counter1>counter){
				 return returnValue;
			}
			else returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}