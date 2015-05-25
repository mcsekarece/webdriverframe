package com.nexia.selenium.testscripts.section.chartprevisit.UnMatchedItemsQueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnmatchedQueueRecords extends AbstractChartPreVisit {
	//@Test(enabled=false)
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUnmatchedQueueRecords(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "CreateAllergy";
		ecData.testCaseId = "TC_CA_018";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyUnmatchedQueue(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}
	
	/**
	 * verifyUnmatchedQueue
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    March 22, 2012
	 */
	
	public boolean verifyUnmatchedQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib ecData) throws IOException{
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
			//  Step-2: Get number of records//
			//--------------------------------------------------------------------//
			
			int numberOfUnmatchedRecords=Integer.parseInt(getText(selenium,"//div[4]/div/div/span"));
			
			System.out.println(numberOfUnmatchedRecords);
			//--------------------------------------------------------------------//
			//  Step-3: Verify Unmatched Queue//
			//--------------------------------------------------------------------//
			if(numberOfUnmatchedRecords > 0){
			assertTrue(click(selenium,"//div[4]/div/div/span[2]"),"Could not change the switch role;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,"//div[2]/div/span")){
				return returnValue=true;
			}
			else
				returnValue=false;
			}
			return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}
