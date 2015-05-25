package com.nexia.selenium.testscripts.section.chartprevisit.ProviderHomePage;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyProviderHomePage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Provider Home Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void providerHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_106";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyProviderHomePage(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Provider Home Page 
	* @action 		  verifying Provider Home Page 
	* @author         Aspire QA
	* @state          Developing
	* @defect 		  #7935	
	* @useraccount    Both
	* @since  	      Sep 23, 2012
	***************************************************************************************************/
	
	public boolean verifyProviderHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=false;
		String notification = null;
		String needAction = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                         //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,prescribeData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Verify Provider Home Page For Notification                 //
			//--------------------------------------------------------------------//
			notification =  getText(selenium,lblNotification);
			
			if(!notification.contains(lblTaskNotification)){
				Assert.fail("Task Notification is not getting displayed");
			}
			
			if(!notification.contains(lblTransmissions)){
				Assert.fail("Transmissions have failed is not getting displayed");
			}
			
			//--------------------------------------------------------------------//
			//  Step-4:Verify Provider Home Page For Need Action                 //
			//--------------------------------------------------------------------//
			needAction = getText(selenium,lblAction);
			
			if(!selenium.isTextPresent(lblTask)){
				Assert.fail("Task  is not getting displayed");
			}
			
			if(!selenium.isTextPresent(lblRxrenewals)){
				Assert.fail("Rx renewals is not getting displayed");
			}
			
			if(!selenium.isTextPresent(lblReport)){
				Assert.fail("Report is not getting displayed");
			}
			
			if(!selenium.isTextPresent(lblEncounter)){
				Assert.fail("Encounter is not getting displayed");
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
