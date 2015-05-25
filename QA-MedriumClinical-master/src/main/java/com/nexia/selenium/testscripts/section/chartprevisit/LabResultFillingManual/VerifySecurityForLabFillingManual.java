package com.nexia.selenium.testscripts.section.chartprevisit.LabResultFillingManual;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityForLabFillingManual extends AbstractChartPreVisit {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "VerifySecurityOption";
		labData.testCaseId = "TC_VSP_001";
		labData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "VerifySecurityOption";
		labData.testCaseId = "TC_VSP_002";
		labData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "VerifySecurityOption";
		labData.testCaseId = "TC_VSP_003";
		labData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "VerifySecurityOption";
		labData.testCaseId = "TC_VSP_004";
		labData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 29, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,labData.switchRole),"Could not change the switch role;More Details:"+labData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,labData,userAccount)){
				Assert.fail("Security options are not showing properly; More Details :"+ labData.toString());
				returnValue= false;
			}else
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib labData,String account) throws IOException{
		boolean returnValue=true;
		String role = labData.switchRole;
		if(labData.testCaseId.equals("TC_VSP_001")){
			labData.workSheetName = "FileLabReport";
			labData.testCaseId = "TC_LR_001";
			labData.fetchChartPreVisitTestData();
			labData.switchRole =  role;
			
			assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEnterData),"Could not find enter data link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementVisible(selenium,btnSign)){
				return returnValue;
			}else{
				returnValue= false;}
			assertTrue(click(selenium, btnResendCancel),"Could not find sign button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(fileReport(selenium,labData,account),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lnkActionsLink)){
				return returnValue;
			}else
				returnValue= false;
		}
		
		if(labData.testCaseId.equals("TC_VSP_002")){
			assertTrue(click(selenium,lnkPatientOption ), "Could not click on patient options link", selenium, ClassName, MethodName);
			
			if(selenium.isElementPresent(lnkLabReportLink)){
				returnValue= false;
			}else
				return returnValue;
		}
		if(labData.testCaseId.equals("TC_VSP_003")){
			waitForPageLoad(selenium);
			if(isTextPresent(selenium,"No Permission"))
			{
				return returnValue;
			}
			assertTrue(click(selenium,lnkPatientOption ), "Could not click on patient options link", selenium, ClassName, MethodName);
			assertTrue(!isElementPresent(selenium,lnkLabReportLink ), "Lab report lind is present under patient option", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkQuickAction), "Could not click on patient options link", selenium, ClassName, MethodName);
			assertTrue(!isElementPresent(selenium,lnkFileDocu ), "Lab report lind is present under Quick Actions", selenium, ClassName, MethodName);
			/*else
			{	
				assertTrue(click(selenium,lnkPatientOption ), "Could not click on patient options link", selenium, ClassName, MethodName);
			
			if(selenium.isElementPresent(lnkLabReportLink)){
				returnValue= false;
			}else
			return returnValue;
			}*/
			return returnValue;
		}
		if(labData.testCaseId.equals("TC_VSP_004")){
			labData.workSheetName = "FileLabReport";
			labData.testCaseId = "TC_LR_004";
			labData.fetchChartPreVisitTestData();
			labData.switchRole =  role;
			
				assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(fileReport(selenium,labData,account),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		return returnValue;
		
	}
}


