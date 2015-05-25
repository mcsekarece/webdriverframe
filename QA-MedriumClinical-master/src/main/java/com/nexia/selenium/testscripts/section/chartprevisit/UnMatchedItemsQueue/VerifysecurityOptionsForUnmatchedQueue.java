package com.nexia.selenium.testscripts.section.chartprevisit.UnMatchedItemsQueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifysecurityOptionsForUnmatchedQueue extends AbstractChartPreVisit {
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "VerifySecurityOption";
		ecData.testCaseId = "TC_VSP_001";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "VerifySecurityOption";
		ecData.testCaseId = "TC_VSP_002";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "VerifySecurityOption";
		ecData.testCaseId = "TC_VSP_003";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "VerifySecurityOption";
		ecData.testCaseId = "TC_VSP_004";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	} 
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib ecData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ecData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, ecData.userName, ecData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,ecData.switchRole),"Could not change the switch role;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,ecData)){
				Assert.fail("Security is not handled properly; More Details :"+ ecData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib ecData) throws IOException{
		boolean returnValue=true;
		if(ecData.testCaseId.equals("TC_VSP_001")){
			assertTrue(click(selenium,"//span/div/div[4]/div/div"),"Could not click on unmatched queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//div[2]/table/tbody/tr/td")){
			assertTrue(click(selenium,"//div[2]/table/tbody/tr/td"),"Could not click on unmatched queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=button.gwt-Button")){
				returnValue=false;
			}
			else return returnValue;
			
			if(isElementPresent(selenium,"//div[2]/div/div/div[2]/span/button")){
				returnValue=false;
			}
			else return returnValue;
			
			}
			else Assert.fail("No entry found");
		}
		if(ecData.testCaseId.equals("TC_VSP_002")){
			
			assertTrue(click(selenium,"//span/div/div[4]/div/div"),"Could not click on unmatched queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//div[2]/table/tbody/tr/td")){
			assertTrue(click(selenium,"//div[2]/table/tbody/tr/td"),"Could not click on unmatched queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,"searchTextBox")){
				return returnValue;
			}
			else returnValue=false;
			}
			else Assert.fail("No entry found");
			
		}
		if(ecData.testCaseId.equals("TC_VSP_003")){
					
			if (selenium.isVisible("//span/div/div[4]/div/div")){
				returnValue=false;
			} else
				return returnValue;
			
		}
		if(ecData.testCaseId.equals("TC_VSP_004")){
			assertTrue(click(selenium,"//span/div/div[4]/div/div"),"Could not click on unmatched queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//div[2]/table/tbody/tr/td")){
			assertTrue(click(selenium,"//div[2]/table/tbody/tr/td"),"Could not click on unmatched queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=button.gwt-Button")){
				return returnValue;
			}
			else returnValue=false;
			
			if(isElementPresent(selenium,"//div[2]/div/div/div[2]/span/button")){
				return returnValue;
			}
			else returnValue=false;
			
			}
			else Assert.fail("No entry found");
		}
		return returnValue;
	}
}
