package com.nexia.selenium.testscripts.section.chartprevisit.MedsQueue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityForMedsQueue extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedsQueueWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "VerifySecurityOption";
		medicationData.testCaseId = "TC_VSP_001";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With View Only User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedsQueueWithViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "VerifySecurityOption";
		medicationData.testCaseId = "TC_VSP_002";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedsQueueWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "VerifySecurityOption";
		medicationData.testCaseId = "TC_VSP_003";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedsQueueWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "VerifySecurityOption";
		medicationData.testCaseId = "TC_VSP_004";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	/**
	 * verifySecurity
	 * function to verify Security for the meds queue
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 19, 2012
	 */

	public boolean verifySecurity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Select Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,medicationData.switchRole),"Could not change the switch role;More Details:"+medicationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		
			//--------------------------------------------------------------------//
			//  Step-3: Verify Security//
			//--------------------------------------------------------------------//
			assertTrue(verifySecurity(selenium,medicationData),"Security for" +medicationData.switchRole+ "is not proper:"+ medicationData.toString(), selenium, ClassName, MethodName);
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium, ChartPreVisitLib proData) throws IOException{
		boolean returnValue=true;
		if(proData.testCaseId.equals("TC_VSP_003")){
			assertTrue(!isElementPresent(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
					}
		// View only
		if(proData.testCaseId.equals("TC_VSP_002")){
			ChartPreVisitLib prescribeData = new ChartPreVisitLib();
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_018";
			prescribeData.fetchChartPreVisitTestData();
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,showPickList,prescribeData.show);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]","Myself");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblRxqitem)){
				assertTrue(click(selenium,lblRxqitem),"Could not click the Meds queue", selenium, ClassName, MethodName);
			}else
				assertTrue(click(selenium,lblRxqitem),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,btnApproveBlue),"Appove button is unavailable", selenium, ClassName, MethodName);
		}
		//limited access
		if(proData.testCaseId.equals("TC_VSP_001")){
	
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ proData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			ChartPreVisitLib prescribeData = new ChartPreVisitLib();
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_018";
			prescribeData.fetchChartPreVisitTestData();
			prescribeData.provider = pName;
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,showPickList,"All");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]","Myself");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lblMedsQueue),"Meds Queue element is not present", selenium, ClassName, MethodName);
		
		}
		if(proData.testCaseId.equals("TC_VSP_004")){
			ChartPreVisitLib prescribeData = new ChartPreVisitLib();
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_018";
			prescribeData.fetchChartPreVisitTestData();
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,showPickList,prescribeData.show);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]","Myself");
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,lblRxqitem),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnRegistrationEdit),"Edit registration is unavailable", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
