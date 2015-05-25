package com.nexia.selenium.testscripts.section.chartprevisit.NotifyMeIn;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchField extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying present of Notofy me block in Lab order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyNotifyMeBlockInLab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderdata = new ChartPreVisitLib();
		orderdata.workSheetName = "OrderNotifyMe";
		orderdata.testCaseId = "TC_ON_006";
		ClassName=this.getClass().getName().substring(39);	
		orderdata.fetchChartPreVisitTestData();		
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		VerifySearchFieldInQueue(seleniumHost, seleniumPort, browser, webSite, userAccount, orderdata);
	}

	public boolean VerifySearchFieldInQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderdata) throws Exception{
		Selenium selenium=null;		
		try
				{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient 
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, orderdata.userName, orderdata.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2:Search in Queue 
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium,taskNotificationQueue),"Could not click on Task Notification Queue ", selenium, ClassName,MethodName);	
			 waitForPageLoad(selenium);
   			assertTrue(selenium.isElementPresent(Searchicon),"Could not find the Search icon ", selenium, ClassName,MethodName);		
			 waitForPageLoad(selenium);
			 assertTrue(type(selenium,txtSearchBox,"Mathew"),"Could not type the patient name", selenium, ClassName,MethodName);
				selenium.clickAt(txtSearchBox,"");
				//selenium.focus(ajxLab);
				selenium.keyDown(txtSearchBox, "\\13");
				selenium.keyUp(txtSearchBox, "\\13");
				selenium.keyPress(txtSearchBox, "\\13");

			 waitForPageLoad(selenium);
			 assertTrue(selenium.isElementPresent(SearchCloseicon),"Could not find the Search icon ", selenium, ClassName,MethodName);	
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium,SearchCloseicon),"Could not click on Search close ", selenium, ClassName,MethodName);	
			 waitForPageLoad(selenium);
			 assertTrue(!isElementPresent(selenium,SearchCloseicon),"Could not click on Search close ", selenium, ClassName,MethodName);			
			 assertTrue(isElementPresent(selenium,btnremovebutton),"could find the remove button ", selenium, ClassName,MethodName);	
			 return true;			
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
		return true;
	}










}
