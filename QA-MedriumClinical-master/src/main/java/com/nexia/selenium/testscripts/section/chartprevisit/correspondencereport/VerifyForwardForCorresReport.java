package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyForwardForCorresReport extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for forward actions")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyForwardActionForSignedReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib CorresData = new ChartPreVisitLib();
		CorresData.workSheetName = "CreateCorresReport";
		CorresData.testCaseId = "TC_CCR_020";
		CorresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, CorresData);
	}
	

	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Switch role to full Access
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,corresData.switchRole),"Could not change the switch role;More Details:"+corresData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Create a Correspondence report 
			//--------------------------------------------------------------------//
			assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
			waitForPageLoad(selenium);
	    	assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Search the patient 
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblFirstCorresReport),"Refiles record is not found", selenium, ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Verify Forward function 
			//--------------------------------------------------------------------//
			assertTrue(verifyFwdActions(selenium,userAccount,corresData),"Refiles record is not found", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
		}
	catch(Exception e )
	{
		Assert.fail(e.getMessage());
	}
		return true;
}
	public boolean verifyFwdActions(Selenium selenium,String userAccount, ChartPreVisitLib corresData) throws IOException
	{
		assertTrue(click(selenium, lnkEncounterAction),"Could not click Action button in  corres report page", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnForward),"Could not click FWD link in  corres report page", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxRxProvider,corresData.provider),		"Could not select Docu type", selenium, ClassName,	MethodName);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium, send),"Could not click send link in  corres report page", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);		
		return true;		
	}
}
