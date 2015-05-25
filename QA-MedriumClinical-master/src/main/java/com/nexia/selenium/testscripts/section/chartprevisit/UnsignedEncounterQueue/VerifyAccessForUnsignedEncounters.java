package com.nexia.selenium.testscripts.section.chartprevisit.UnsignedEncounterQueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAccessForUnsignedEncounters extends AbstractChartPreVisit {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyShowOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "UnsignedEncounterQueue";
		ecData.testCaseId = "TC_UEQ_002";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHideOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "UnsignedEncounterQueue";
		ecData.testCaseId = "TC_UEQ_003";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHideOptionInChartSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "UnsignedEncounterQueue";
		ecData.testCaseId = "TC_UEQ_004";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}
	/**
	 * verifyAccess
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 1, 2012
	 */
	
	public boolean verifyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib ecData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ecData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, ecData.userName, ecData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			assertTrue(switchRole(selenium,ecData.switchRole),"Could not change the switch role;More Details:"+ecData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-2: Verify Access option //
			//--------------------------------------------------------------------//
			
			if(!verifyAccessForEncounter(selenium,ecData)){
				Assert.fail("Problem in accessing unsigned encounters from home page; More Details :"+ ecData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifyAccessForEncounter(Selenium selenium,ChartPreVisitLib ecData) throws IOException{
		if(ecData.testCaseId.equals("TC_UEQ_002")){
			assertTrue(click(selenium,"Unsignedencounters"),"Could not click on encounter queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(selenium.isTextPresent("Show")){
				return true;
			}else
				return false;
		}
		if(ecData.testCaseId.equals("TC_UEQ_003")){
			assertTrue(click(selenium,"//div[3]/div/div/span[2]"),"Could not click on encounter queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			selectValueFromAjaxList(selenium,"suggestBox","All encounters");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"link=Hide"),"Could not click on hide button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"resourceCalendarsuggestBox")){
				return true;
			}else
				return false;
		}
		if(ecData.testCaseId.equals("TC_UEQ_004")){
			assertTrue(click(selenium,"//div[@id='Unsignedencounters']/div/span[2]"),"Could not click on encounter queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			//selectValueFromAjaxList(selenium,"suggestBox","All encounters");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForElement(selenium, lnkEncounterEntry, WAIT_TIME);
			if(!isElementPresent(selenium,lnkEncounterEntry)){
			    waitForElement(selenium, lnkEncounterEntry, WAIT_TIME);
			}
			if(!isElementPresent(selenium,lnkEncounterEntry)){
			    waitForElement(selenium, lnkEncounterEntry, WAIT_TIME);
			}
			assertTrue(click(selenium,lnkEncounterEntry),"Could not click on encounter;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"SlideWindowHideAnchor"),"Could not click on hide button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,ajxUnsignedEncounterQue)){
				return true;
			}else
				return false;
		}
		
		return true;
	}
}


