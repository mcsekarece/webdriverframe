package com.nexia.selenium.testscripts.section.chartprevisit.ProviderHomePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNexiaLogo extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Nexia Logo")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNexiaLogo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_004";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLogoAction(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Accessing unfinished tasks")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAccessToUnfinishedTasks(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_001";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLogoAction(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	 /* verifyLogoAction
	 * Function to verify nexia logo
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Sep 24, 2012
	 */
	
	public boolean verifyLogoAction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,historyData.switchRole),"Could not change the switch role;More Details:"+historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			/*assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);*/
			
			if(historyData.testCaseId.equals("TC_VSP_001")){
			if(isElementPresent(selenium,lnkUnfinshedTasks)){
			    assertTrue(click(selenium,lnkUnfinshedTasks),"Could not click on nexia logo;More Deatils:"+historyData.toString(), selenium, ClassName, MethodName);
			   
			    if(!selenium.isTextPresent("Delete")){
				Assert.fail("Accessing Unfinished item failed");
			    }
			    return true;
			}
			else{
			    Assert.fail("Accessing Unfinished item failed");
			}
			}
			if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"Could not click on error",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPatientBox,historyData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
			selenium.keyPress(txtPatientBox, "\\9");
			selenium.keyPress(txtPatientBox, "\\9");
			selenium.clickAt("searchPatientBox","");
			selenium.focus("searchPatientBox");			
			selenium.fireEvent("searchPatientBox","keypress");
			waitForElement(selenium,lblPatientResult,10000);		
			//@@@@@@@@@@@@@
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are displayed for the patient with ID :-"+historyData.patientId,selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,"patientName")){
				Assert.fail("Patient informaition not loaded");
			}
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click on error",selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click on nexia logo;More Deatils:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,appointmentFor)){
				Assert.fail("User is not navigated to home page");
			}
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}