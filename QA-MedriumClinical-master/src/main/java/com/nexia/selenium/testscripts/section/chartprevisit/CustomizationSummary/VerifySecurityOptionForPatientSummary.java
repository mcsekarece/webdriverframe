package com.nexia.selenium.testscripts.section.chartprevisit.CustomizationSummary;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForPatientSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "VerifySecurityOption";
		allergyData.testCaseId = "TC_VSP_001";
		allergyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "VerifySecurityOption";
		allergyData.testCaseId = "TC_VSP_002";
		allergyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "VerifySecurityOption";
		allergyData.testCaseId = "TC_VSP_003";
		allergyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "VerifySecurityOption";
		allergyData.testCaseId = "TC_VSP_004";
		allergyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
		/*************************************************************************************************** 
		* @purpose        To verify Customize Setting PopUp
		* @action 		  verifying Customize Setting PopUp
		* @author         Aspire QA
		* @throws         IOException 
		* @state          Developing
		* @useraccount    Both (US and Canada)
		* @since  	      Aug 23, 2012
		***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLib customiszeData) throws IOException{
		boolean returnValue = false;
		Selenium selenium = null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + customiszeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, customiszeData.userName, customiszeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch Role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,customiszeData.switchRole),"Could not change the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Naviagte to my Setting //
			//--------------------------------------------------------------------//
			//assertTrue(navigateToPatientSummary(selenium),"Could not navigate the Patient Summary", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,customiszeData)){
				//fail("Security option not show properly; More Details :"+ customiszeData.toString());
				returnValue= true;
			}else
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib customiszeData){
		//No Access
		if(customiszeData.testCaseId.equals("TC_VSP_003")){
			if(!isElementPresent(selenium,btnErrorClose)){
				return false;
			}
		}
		return true;
	}
}
