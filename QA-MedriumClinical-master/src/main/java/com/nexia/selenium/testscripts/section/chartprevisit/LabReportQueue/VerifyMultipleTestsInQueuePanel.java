package com.nexia.selenium.testscripts.section.chartprevisit.LabReportQueue;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMultipleTestsInQueuePanel extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify abnormal lab report in lab report queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleTestsInQueuePanel(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_011";
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
	 * @since  	    Dec 21, 2012
	 */
	public boolean verifyLabReportQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData)throws Exception {
		Selenium selenium=null;
		boolean returnValue=false;
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
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String pName= providerNameTemp.replaceAll(", "+labData.switchRole, "");
			String tempArray[]=pName.split(" ");
			String providerName=tempArray[1]+", "+tempArray[0];
			
			labData.rProvider=providerName;
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,forPickList,labData.rProvider);
			if(isElementPresent(selenium,"//div[4]/div/div/div/div/div"))
				click(selenium,"//div[4]/div/div/div/div/div");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div")){
			assertTrue(click(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div"),"Cold not click the report", selenium, ClassName, MethodName);
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton")," Could not click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),
					"Could not click on More  link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabs),
					"Could not click on Lab Report link link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 assertTrue(click(selenium,lnkLabListView),"Could not click the List view", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				while(isElementPresent(selenium,testResult)){
					//Assert.assertTrue(click(selenium,labReportCheckBox),"Cold not click the check box");
				assertTrue(click(selenium,lnkBeginEncounterAction),"Cold not click the check box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"deleteLabReports"),"Cold not click the check box", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtdeleteReason,labData.patientId),"Cold not click the check box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnDeleteReason),"Cold not click the check box", selenium, ClassName, MethodName);
				if(isElementPresent(selenium,"//a/img"))
					assertTrue(click(selenium,"//a/img"),"Cold not click the X button", selenium, ClassName, MethodName);
				 if(isElementPresent(selenium, "errorCloseButton"))
						assertTrue(click(selenium, "errorCloseButton")," ", selenium, ClassName, MethodName);
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
			ChartPreVisitLib labsData = new ChartPreVisitLib();
			labsData.workSheetName = "FileLabReport";
			labsData.testCaseId = "TC_LR_022";
			labsData.fetchChartPreVisitTestData();
			assertTrue(fileReport(selenium,labsData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: verify Created lab report//
			//--------------------------------------------------------------------//
			
			if(isElementPresent(selenium,"//div[@id='headerPanel']/table/tbody/tr/td")){
				 returnValue=true;
			}else
				return false;
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,forPickList,labData.rProvider);
			if(getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div").contains(labData.testName))
				returnValue=true;
			else
				return false;
			if(getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div").contains(labsData.testName))
				returnValue=true;
			else
				return false;
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:+injectionData.toString()");
		}
		return returnValue;
	}

}
