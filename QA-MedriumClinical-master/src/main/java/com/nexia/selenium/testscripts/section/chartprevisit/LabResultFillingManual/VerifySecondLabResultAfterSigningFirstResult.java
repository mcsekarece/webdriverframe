package com.nexia.selenium.testscripts.section.chartprevisit.LabResultFillingManual;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecondLabResultAfterSigningFirstResult extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying second lab result presence after signing the first lab result")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyShowLabReportDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_040";
		labData.fetchChartPreVisitTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify second lab result presence after signing the first lab result
	* @action 		  verifying second lab result presence after signing the first lab result
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 01, 2013
	***************************************************************************************************/
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
			//  Step-5: Create First File new lab report//
			//--------------------------------------------------------------------//
			 assertTrue(fileReport(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Second File new lab report//
			//--------------------------------------------------------------------//
			ChartPreVisitLib labData1 = new ChartPreVisitLib();
			labData1.workSheetName = "FileLabReport";
			labData1.testCaseId = "TC_LR_029";
			labData1.fetchChartPreVisitTestData();
			
			assertTrue(fileReport(selenium,labData1,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo ), "Could not click on back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: select the first lab report from lab queue//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,labReportQueue ), "Could not click lab report quee", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,forPickList, "Myself" ), "Could not select the provider on lab report", selenium, ClassName, MethodName);
		
			waitForPageLoad(selenium);
			assertTrue(click(selenium,firstLabReport), "Could not click on lab report", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify the second lab report presence//
			//--------------------------------------------------------------------//
			if(getText(selenium, lblTestName).contains(labData.testName)){
				assertTrue(click(selenium,btnSign ), "Could not click on lab report", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			if(!(getText(selenium, lblTestName).contains(labData.testName))){
				returnValue=true;
			}
			
			else{
				returnValue=false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
