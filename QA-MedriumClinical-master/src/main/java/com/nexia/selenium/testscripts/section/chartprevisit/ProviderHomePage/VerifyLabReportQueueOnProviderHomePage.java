package com.nexia.selenium.testscripts.section.chartprevisit.ProviderHomePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLabReportQueueOnProviderHomePage extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify abnormal lab report in lab report queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAbnormalLabReportInQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_009";
		labData.fetchChartPreVisitTestData();
		verifyLabReportQueue(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify LabReportQueue
	* @action 		  verifying LabReportQueue
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 23, 2012
	***************************************************************************************************/

	public boolean verifyLabReportQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
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
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,labData.switchRole),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,forPickList,labData.rProvider);
			/*if(isElementPresent(selenium,"//div[4]/div/div/div/div/div"))
				click(selenium,"//div[4]/div/div/div/div/div");*/
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,firstLabReport)){
			assertTrue(click(selenium,firstLabReport),"Cold not click the report", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabReport),"Cold not click the check box", selenium, ClassName, MethodName);
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkLabListView),"Could not click the List view", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			while(isElementPresent(selenium,testResult)){
				//assertTrue(click(selenium,labReportCheckBox),"Cold not click the check box");
				assertTrue(click(selenium,lnkBeginEncounterAction),"Cold not click the check box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkLabReportDelete),"Cold not click Delete Link", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtdeleteReason,labData.patientId),"Cold not click the check box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnDeleteReason),"Cold not click the check box", selenium, ClassName, MethodName);
				if(isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"",selenium, ClassName, MethodName);
				if(isElementPresent(selenium,lnkVitals))
					break;
				}
			}
			searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing lab reports//
			//--------------------------------------------------------------------/
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
			if(labData.testCaseId.equals("TC_LR_002")){
			assertTrue(fileReportWithMandatory(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			else 
			assertTrue(fileReport(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify Created lab report//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkLabs),
					"Could not click on Lab Report link link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkLabListView),
					"Could not click the List view",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium,lnkActionsLink)){
				 returnValue=true;
			}else
				return false;
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Lab report queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if(!getText(selenium,"Labreports").toLowerCase(new java.util.Locale("en","US")).trim().contains("Abnormal".toLowerCase(new java.util.Locale("en","US")).trim())){
				Assert.fail("Abnormal lab reports are not getting displayed");
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: verify Count                                             //
			//--------------------------------------------------------------------//
			
			String resultList=getText(selenium,labReportQueue);
			System.out.println(resultList);
			String[] splitS = resultList.split(" ");
			int metricResult = Integer.parseInt(splitS[0]);

			if(metricResult>=0){
				returnValue=true;
			}
			else{
				Assert.fail("Could not find count of rx renewals queue");;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
