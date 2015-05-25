package com.nexia.selenium.testscripts.section.chartprevisit.ProviderHomePage;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForProviderHomePage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_001";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_002";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_010";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_004";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
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
			
			if(verifySecurity(selenium,historyData)){
				return returnValue;
			}else
				Assert.fail("Security option not show properly; More Details :"+ historyData.toString());
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib historyData) throws IOException{
	
		//No Access User Role	
		if(historyData.testCaseId.equals("TC_VSP_010")){
			/*assertTrue(selenium.isTextPresent("No Permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);*/
			assertTrue(searchPatientNexiaNoAccess(selenium,historyData.patientId),"Could search patient", selenium, ClassName, MethodName);
			
			return true;
		}	
		
		//--------------------------------------------------------------------//
		//  Step-4: Navigate to Notes 										 //
		//--------------------------------------------------------------------//
		
		if(!historyData.testCaseId.equals("TC_VSP_010")){		  	
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
				if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtPatientBox,historyData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
				selenium.keyPress(txtPatientBox, "\\9");
				
				selenium.clickAt("searchPatientBox","");
				selenium.focus("searchPatientBox");			
				selenium.fireEvent("searchPatientBox","keypress");
				waitForElement(selenium,lblPatientResult,10000);		
				assertTrue(selenium.isElementPresent(lblsearchResult),"Search Results are displayed for the patient with ID :-"+historyData.patientId,selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblsearchResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
				return true;
		  }
		
		return true;
		
	}
}