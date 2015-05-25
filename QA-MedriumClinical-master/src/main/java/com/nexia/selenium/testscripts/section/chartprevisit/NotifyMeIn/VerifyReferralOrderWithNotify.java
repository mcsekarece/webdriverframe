package com.nexia.selenium.testscripts.section.chartprevisit.NotifyMeIn;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyReferralOrderWithNotify extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying present of Notofy me block in Lab order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyNotifyMeBlockInLab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderdata = new ChartPreVisitLib();
		orderdata.workSheetName = "OrderNotifyMe";
		orderdata.testCaseId = "TC_ON_007";
		ClassName=this.getClass().getName().substring(39);	
		orderdata.fetchChartPreVisitTestData();		
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		VerifyNotifyMeBlock(seleniumHost, seleniumPort, browser, webSite, userAccount, orderdata);
	}
	/**
	 * Verify Create a Referral order with notify  
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
				//  Step-5: Navigate to Referral order
				//--------------------------------------------------------------------//	
				assertTrue(selenium.isVisible(imgReferralIcon),"Navigation Failed", selenium, ClassName, MethodName);
				assertTrue(clickReferralIcon(selenium,orderdata),"Navigation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-5:Create New Referral order with Nitify
				//--------------------------------------------------------------------//	
				ChartPreVisitLib ReferralData  = new ChartPreVisitLib();
				ReferralData.workSheetName = "CreateReferralOrder";
				ReferralData.testCaseId = "TC_OR_001";
				ReferralData.fetchChartPreVisitTestData();		
				orderNewReferralWithNotify(selenium,ReferralData);
				//assertTrue(SearchPatientInOrderQueue(selenium,orderdata.patientId),"Could not Search the patient", selenium, ClassName,MethodName);
		
		}
	
	catch(Exception e)
	{
		}
		return true;
	}
}
