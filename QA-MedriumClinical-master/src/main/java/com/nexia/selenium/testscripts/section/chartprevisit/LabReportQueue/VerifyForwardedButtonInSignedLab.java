package com.nexia.selenium.testscripts.section.chartprevisit.LabReportQueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyForwardedButtonInSignedLab extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Forwarded Lab Report in Queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyForwardedButtonInQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_004";
		labData.fetchChartPreVisitTestData();
		verifyForwardedButton(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	/**
	 * VerifyForwardedButton
	 * function to Verify Forwarded Button
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 12, 2012
	 */
	
	public boolean verifyForwardedButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
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
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,labData.switchRole),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
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
			 if(isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"Could not click the error close button", selenium, ClassName, MethodName);
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
			//  Step-6: Navigate to Lab Tag//
			//--------------------------------------------------------------------// 
			assertTrue(click(selenium, lnkMore),"Could not click on More  link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabReport),"Could not click the chart Lab link", selenium, ClassName, MethodName);
		
			assertTrue(click(selenium,lnkLabListView),"Could not click the List view", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			selenium.clickAt( btnSignActionLab, "");
			selenium.focus( btnSignActionLab);
			selenium.fireEvent( btnSignActionLab, "keyPress");
			//Assert.assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the action button");
			
			if(isElementPresent(selenium,forward)){
				returnValue=false;
			}else
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			int i=0;
			if(i==0)
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	
	}
}
