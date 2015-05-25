package com.nexia.selenium.testscripts.section.chartprevisit.NotifyMeIn;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDIorderWithNotify extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying present of Notofy me block in DI order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyNotifyMeBlockInLab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderdata = new ChartPreVisitLib();
		orderdata.workSheetName = "OrderNotifyMe";
		orderdata.testCaseId = "TC_ON_006";
		ClassName=this.getClass().getName().substring(39);	
		orderdata.fetchChartPreVisitTestData();		
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		VerifyNotifyMeBlock(seleniumHost, seleniumPort, browser, webSite, userAccount, orderdata);
	}
	/**
	 * Verify Create a DI order with notify  
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	  Nov 12,2014
	 */
	public boolean VerifyNotifyMeBlock(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderdata) throws Exception{
		Selenium selenium=null;			
			try
		{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium);
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, orderdata.userName, orderdata.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
				//--------------------------------------------------------------------//
				//  Step-2:Search Patient in Application 
				//--------------------------------------------------------------------//
				assertTrue(searchPatientNexiaForProviderHomePage(selenium,orderdata.patientId),"Could not search the patient", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
				//  Step-3:Delete all encounter in encounter tab//
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
				assertTrue(deleteAllEncounters(selenium,orderdata),"could not delete the record", selenium, ClassName, MethodName);
				//--------------------------------------------------------------------//
				//  Step-4: Navigate to Encounter and Pop up//
				//--------------------------------------------------------------------//
				assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);			
				//--------------------------------------------------------------------//
				//  Step-5: Navigate to DI order
				//--------------------------------------------------------------------//
				assertTrue(selenium.isVisible(imgDiOrderIcon),"link is not visible", selenium, ClassName, MethodName);
				assertTrue(clickDiIcon(selenium,orderdata),"Navigation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-5: Create a new DI order with Notify field 
				//--------------------------------------------------------------------//
				ChartPreVisitLib DIData = new ChartPreVisitLib();
				DIData.workSheetName = "CreateDiganosticImaging";
				DIData.testCaseId = "TC_ODI_001";
				DIData.fetchChartPreVisitTestData();
				assertTrue(orderNewDiWithNotify(selenium,DIData),"Creation of lab order failed", selenium, ClassName, MethodName);
				//--------------------------------------------------------------------//
				//  Step-7:Sign the Encounter 
				//--------------------------------------------------------------------//
				assertTrue(isElementPresent(selenium,btnSign),"Could not find encounter sign button", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSign),"Navigation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-8:Search added Lad order in 'Order Notification Queue'
				//--------------------------------------------------------------------//
				//assertTrue(SearchPatientInOrderQueue(selenium,orderdata.patientId),"Could not Search the patient", selenium, ClassName,MethodName);
		
		
		
		
		
		}
	
	catch(Exception e)
	{
		}
		return true;
	}
}