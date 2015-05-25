package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCorresQueuePanel extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyForAndShowSuggestBox(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_003";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyActionButtons(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_004";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_005";
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
		//  Step-2: verify Correspondence Queue  Panel  //
		//--------------------------------------------------------------------//	
		assertTrue(click(selenium,QueeCorrespondenace),"Could not click the correspondence Queue", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);		
		assertTrue(verifyCorrespondenceQueuePanel(selenium,corresData),"Verification Corres panel failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);			
		return true;
			
		}
	
	catch(Exception e)
	{
		assertTrue(false,"Test for verifying Correspondenace Queue Panel failed", selenium, ClassName, MethodName);	
	}
	return returnvalue; 
		
	}
	


public boolean verifyCorrespondenceQueuePanel(Selenium selenium, ChartPreVisitLib corresData) throws IOException
{
	if(corresData.testCaseId.equals("TC_CCR_003"))		{
		assertTrue(isElementPresent(selenium, forPickList),"After hiding Comment text box should not be visible", selenium, ClassName,MethodName);
		
		String defaultValue[]={"All for","Ordered by","Copied to","Forwarded to"};
		assertTrue(getValue(selenium,forPickList).toLowerCase(new java.util.Locale("en","US")).trim().contains(corresData.For.trim().toLowerCase(new java.util.Locale("en","US"))),"Default value for 'for Field MIssing' ",selenium, ClassName,MethodName);
		assertTrue(getValue(selenium,showPickList).toLowerCase(new java.util.Locale("en","US")).trim().contains(defaultValue[0].trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find entered comments",selenium, ClassName,MethodName);
		waitForPageLoad(selenium);	
		assertTrue(clickAt(selenium, showPickList,""),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(isTextPresent(selenium,defaultValue[0]),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(isTextPresent(selenium,defaultValue[1]),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(isTextPresent(selenium,defaultValue[2]),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(isTextPresent(selenium,defaultValue[3]),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
	return true;}
	
if(corresData.testCaseId.equals("TC_CCR_004"))		{
	
	assertTrue(isElementPresent(selenium,hideQueue),"Could not Find the hide button in Panel", selenium, ClassName,MethodName);
	assertTrue(isElementPresent(selenium,showPickList),"Could not Find show suggest box", selenium, ClassName,MethodName);
	assertTrue(isElementPresent(selenium,forPickList),"Could not Find For suggest box", selenium, ClassName,MethodName);
			
		
	return true;}
	
if(corresData.testCaseId.equals("TC_CCR_005"))		{
	
	assertTrue(isElementPresent(selenium,searchBox),"Could not Find the Search box", selenium, ClassName,MethodName);
	
	assertTrue(isElementPresent(selenium,Searchicon),"Could not Find the Search icon in Search box", selenium, ClassName,MethodName);
	
	assertTrue(type(selenium,searchBox,corresData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);	
	assertTrue(!isElementPresent(selenium,Searchicon),"Could not Find the Search icon in Search box", selenium, ClassName,MethodName);
	assertTrue(isElementPresent(selenium,SearchCloseicon),"Could not Find the Search icon in Search box", selenium, ClassName,MethodName);
	assertTrue(click(selenium,SearchCloseicon),"Could not Find the Search icon in Search box", selenium, ClassName,MethodName);
	assertTrue(isElementPresent(selenium,Searchicon),"Could not Find the Search icon in Search box", selenium, ClassName,MethodName);
	assertTrue(!isElementPresent(selenium,SearchCloseicon),"Could not Find the Search icon in Search box", selenium, ClassName,MethodName);
	assertTrue(!getText(selenium,searchBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(corresData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find entered comments",selenium, ClassName,MethodName);
	waitForPageLoad(selenium);	
return true;}

	
	
	return true;
}







}
