package com.nexia.selenium.testscripts.section.chartprevisit.NotifyMeIn;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNotefyMeInBlock extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying present of Notofy me block in Lab order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyNotifyMeBlockInLab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderdata = new ChartPreVisitLib();
		orderdata.workSheetName = "OrderNotifyMe";
		orderdata.testCaseId = "TC_ON_001";
		ClassName=this.getClass().getName().substring(39);	
		orderdata.fetchChartPreVisitTestData();		
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		VerifyNotifyMeBlock(seleniumHost, seleniumPort, browser, webSite, userAccount, orderdata);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying present of Notofy me block in DI order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyNotifyMeBlockInDI(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderdata = new ChartPreVisitLib();
		orderdata.workSheetName = "OrderNotifyMe";
		orderdata.testCaseId = "TC_ON_002";
		orderdata.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		VerifyNotifyMeBlockInDI(seleniumHost, seleniumPort, browser, webSite, userAccount, orderdata);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying present of Notofy me block in Referral order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyNotifyMeBlockInReferral(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderdata = new ChartPreVisitLib();
		orderdata.workSheetName = "OrderNotifyMe";
		orderdata.testCaseId = "TC_ON_003";
		orderdata.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		VerifyNotifyMeBlockInReferral(seleniumHost, seleniumPort, browser, webSite, userAccount, orderdata);
	}
	/**
	 * Verify notify me block in 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	  Nov 10,2014
	 */

	public boolean VerifyNotifyMeBlock(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderdata) throws Exception{
		Selenium selenium=null;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, orderdata.userName, orderdata.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,orderdata.patientId),"Could not search the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Lab Order Page//
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(imgLabOrderIcon),"link is not visible", selenium, ClassName, MethodName);
			assertTrue(clickLabIcon(selenium,orderdata),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Verify Default value and Notify me block 
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,ajxNotifyDuration),"Verification on Notify block failed", selenium, ClassName, MethodName);
			assertTrue(selenium.getValue(ajxDurationUnit).contains("Day(s)"),"Verification on Notify block failed", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,chkboxUrgent),"Urgent field is missing ", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,ajxLabFacility),"Sendto field is missing lab order ", selenium, ClassName, MethodName);
			
				
		}
		catch(Exception e )
		{
			Assert.fail(e.getMessage());
		}
		return true;
	}

	public boolean VerifyNotifyMeBlockInDI(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderdata) throws Exception{
		{	Selenium selenium=null;
			try {
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium);
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, orderdata.userName, orderdata.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				//--------------------------------------------------------------------//
				//  Step-2: Advanced search with Patient ID//
				//--------------------------------------------------------------------//
				assertTrue(searchPatientNexiaForProviderHomePage(selenium,orderdata.patientId),"Could not search the patient", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				//  Step-3: Navigate to Encounter and Pop up//
				//--------------------------------------------------------------------//
				assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
				//  Step-4: Navigate to Diganostic Imaging Page//
				//--------------------------------------------------------------------//
				assertTrue(selenium.isVisible(imgDiOrderIcon),"link is not visible", selenium, ClassName, MethodName);
				assertTrue(clickDiIcon(selenium,orderdata),"Navigation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-4:Verify Default value and Notify me block 
				//--------------------------------------------------------------------//				
				assertTrue(isElementPresent(selenium,ajxNotifyDuration),"Verification on Notify block failed", selenium, ClassName, MethodName);
				assertTrue(selenium.getValue(ajxDurationUnit).contains("Day(s)"),"Verification on Notify block failed", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,chkboxUrgent),"Urgent field is missing ", selenium, ClassName, MethodName);
				
			
			}
		
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
		
		
		}
		return true;
	}
	public boolean VerifyNotifyMeBlockInReferral(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderdata) throws Exception{
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
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,orderdata.patientId),"Could not search the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Order referral Page//
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(imgReferralIcon),"Navigation Failed", selenium, ClassName, MethodName);			
			assertTrue(clickReferralIcon(selenium,orderdata),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Verify Default value and Notify me block 
			//--------------------------------------------------------------------//	
			assertTrue(selectValueFromAjaxList(selenium, ajxSearchReferral,"A"),"Selecting external provider failed", selenium, ClassName, MethodName);			
			assertTrue(isElementPresent(selenium,ajxNotifyDuration),"Verification on Notify block failed", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,chkboxUrgent),"Urgent field is missing ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,ajxDurationUnit),"Could not click duration unit", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lstUnsignedEncShow).contains("Day(s)"),"Verification on Notify block failed", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lstUnsignedEncShow1).contains("Month(s)"),"Verification on Notify block failed", selenium, ClassName, MethodName);
			assertTrue(selenium.getValue(ajxDurationUnit).contains("Day(s)"),"Verification on Notify block failed", selenium, ClassName, MethodName);

		}
			catch(Exception e)
			{
				Assert.fail(e.getMessage());
			}
						return true;
		
	}
}
