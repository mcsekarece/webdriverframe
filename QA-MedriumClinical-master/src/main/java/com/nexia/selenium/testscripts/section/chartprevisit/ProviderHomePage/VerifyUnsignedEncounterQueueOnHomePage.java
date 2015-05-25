package com.nexia.selenium.testscripts.section.chartprevisit.ProviderHomePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnsignedEncounterQueueOnHomePage  extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing access to unsigned encounter queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterQueueOnHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_106";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/**
	 * verifyAccess
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Sep 26, 2012
	 */
	
	public boolean verifyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                         //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,prescribeData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Verify Count                                               //
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib ecData = new ChartPreVisitLib();
			ecData.workSheetName = "UnsignedEncounterQueue";
			ecData.testCaseId = "TC_UEQ_002";
			ecData.fetchChartPreVisitTestData();
			
			String resultList=getText(selenium,lblUns);
			String[] splitS = resultList.split(" ");
			int metricResult1 = Integer.parseInt(splitS[0]);
			System.out.println(metricResult1);
			
			if(metricResult1>=0){
				returnValue=true;
			}
			else{
				Assert.fail("Could not find count of rx renewals queue");;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Access for unsigned encounter queue               //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkUnsignedEncounterQueue),"Could not find encounter queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxRxShow,"All encounters");
			
			assertTrue(click(selenium,lnkUnsignedEncounterQueue),"Could not click on encounter queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxRxShow,"All encounters");
			assertTrue(click(selenium,hide),"Could not click on hide button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,hide)){
				return true;
			}else
				return false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}
