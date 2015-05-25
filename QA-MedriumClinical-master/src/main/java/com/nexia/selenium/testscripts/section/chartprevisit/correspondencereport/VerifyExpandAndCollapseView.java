package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyExpandAndCollapseView extends AbstractChartPreVisit{
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Hide details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_016";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
		boolean returnvalue=true;
try
	{
	//--------------------------------------------------------------------//
	//  Step-1: Login to the application and search for the given patient //
	//--------------------------------------------------------------------//
	selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
	Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
	assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
	//--------------------------------------------------------------------//
	//  Step-2:Delete All Correspondence report							 //
	//--------------------------------------------------------------------//
	String corresQueue=getText(selenium,QueeCorrespondenace);
	System.out.println(corresQueue);
	String[] splitS = corresQueue.split(" ");
	int queueResult = Integer.parseInt(splitS[0]);
//--------------------------------------------------------------------//
	//  Step-3:Correspondence  Report for A patient 
	//--------------------------------------------------------------------//		
	assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);			
	assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
    waitForPageLoad(selenium);	
    String firstAssNumber=corresData.AccessionNumber;
	assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
    waitForPageLoad(selenium);	
	assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);	
	//--------------------------------------------------------------------//
	//  Step-4:Search the Patient
	//--------------------------------------------------------------------//	
	String corresQueue1=getText(selenium,QueeCorrespondenace);
	System.out.println(corresQueue1);
	String[] splitS1 = corresQueue1.split(" ");
	int queueResult1 = Integer.parseInt(splitS1[0]);
	System.out.println(queueResult1);
	if(queueResult1==queueResult)
	{
		return returnvalue=true;
	}
	else
	{
		assertTrue(false,"Addding signed corres report increasing the count in Queue", selenium, ClassName, MethodName);	
	}
	waitForPageLoad(selenium);
	assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
    assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	//--------------------------------------------------------------------//
	//  Step-4:Verify Expand and Expand All function
	//--------------------------------------------------------------------//	
	assertTrue(isElementPresent(selenium, lblFirstCorresReport),"Created Correspondence report not found", selenium, ClassName,MethodName);
	assertTrue(isElementPresent(selenium, lnkCollapseeMenuArrow),"Expand Arrow Not found", selenium, ClassName,MethodName);
	assertTrue(click(selenium, lnkCollapseeMenuArrow),"Could not click Expand Arrow ", selenium, ClassName,MethodName);
	assertTrue(selenium.isTextPresent(firstAssNumber),"In Expand View Accession not present", selenium, ClassName,MethodName);
	assertTrue(VerifySignedCorrespondenceReportInTab(selenium,corresData, userAccount),"Created Correspondence report not found", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	assertTrue(isElementPresent(selenium,lnkExpandAll ),"Expand All Arrow Not found", selenium, ClassName,MethodName);
	assertTrue(click(selenium, lnkExpandAll),"Could not click Expand All Arrow ", selenium, ClassName,MethodName);
	assertTrue(selenium.isTextPresent(firstAssNumber),"In Expand View Accession not present", selenium, ClassName,MethodName);
	assertTrue(selenium.isTextPresent(corresData.AccessionNumber),"In Expand View Accession not present", selenium, ClassName,MethodName);	
		
	}
	catch(Exception e)
	{
		assertTrue(false,"Verification of Expand and Expand all failed", selenium, ClassName, MethodName);		}
		
	return returnvalue;
	}
		
}
