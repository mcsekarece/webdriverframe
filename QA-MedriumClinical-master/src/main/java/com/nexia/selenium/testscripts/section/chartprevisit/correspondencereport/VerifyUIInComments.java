package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUIInComments extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the UI in Comments ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyCommentSection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib CorresData = new ChartPreVisitLib();
		CorresData.workSheetName = "CreateCorresReport";
		CorresData.testCaseId = "TC_CCR_023";
		CorresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		CreateCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, CorresData);
	}
	
	public boolean CreateCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
	try{
		
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
		//--------------------------------------------------------------------//
		//  Step-2:Click first report in Queue  
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,QueeCorrespondenace),"Could not click the correspondence Queue", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lblcorresQFirst),"Could not click the correspondence Queue", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);		
		//--------------------------------------------------------------------//
		//  Step-3:Verify Comment Section lblCorresQue
		//--------------------------------------------------------------------//
		assertTrue(isElementPresent(selenium,elementCommentIcon),"Could not find the add comment field", selenium, ClassName,MethodName);
		assertTrue(selenium.isTextPresent("Add Comments"),"Could not find the add comment field", selenium, ClassName,MethodName);
		assertTrue(click(selenium,elementCommentIcon),"Could not find the add comment field", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);	
		assertTrue(isElementPresent(selenium,btncommentSave),"Could not find the sAVE IN  comment field", selenium, ClassName,MethodName);
		assertTrue(isElementPresent(selenium,btnEditcomments),"Could not find the Cancel in  comment field", selenium, ClassName,MethodName);
		
		
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	return true;
	}
	}
