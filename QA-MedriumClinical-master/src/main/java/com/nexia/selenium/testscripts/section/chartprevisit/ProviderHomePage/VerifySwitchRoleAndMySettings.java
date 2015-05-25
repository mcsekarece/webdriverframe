package com.nexia.selenium.testscripts.section.chartprevisit.ProviderHomePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySwitchRoleAndMySettings extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Nexia Logo")
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
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Need Action")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNeedAction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_001";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLogoAction(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying patient search with patient id")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientSearchWithID(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_011";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLogoAction(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying patient search with patient Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientSearchWithName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_012";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLogoAction(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Online Help")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOnlineHelp(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_106";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLogoAction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	 /* verifyLogoAction
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
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
			/*assertTrue(switchrole(selenium,historyData),"Could not change the switch role;More Details:"+historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify View My Settings								  //
			//--------------------------------------------------------------------//
			
			if(historyData.testCaseId.equals("TC_PM_106")){
			if(isElementPresent(selenium,lnkHelp)){
				assertTrue(click(selenium,lnkHelp),"Could not click Help icon;More details :"+ historyData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkHowToUse),"Could not click How to Use;More details :"+ historyData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				String st1[]=selenium.getAllWindowNames();
				waitForPageLoad(selenium);
				switchto(st1[1]);
				selenium.selectWindow(st1[1]);
				selenium.windowFocus();
				if(isElementPresent(selenium,lnkHelp1)){
				return true;
				}
				else{
					Assert.fail("Navigation Failed");
				}
			}
			}
			
		/*	selenium.clickAt(lnkTopMenu, "");
			selenium.focus(lnkTopMenu);
			selenium.fireEvent(lnkTopMenu, "keypress");
			selenium.keyPress(lnkTopMenu, "\\13");
			click(selenium,"//div[5]/div/div");*/
			
			if(historyData.testCaseId.equals("TC_VSP_011")){
				searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);
				waitForPageLoad(selenium);
				String patId = getText(selenium, lblpatientname1);
				waitForPageLoad(selenium);
				System.out.println(patId);
				assertTrue(type(selenium,txtPatientBox,patId),"Could not type patient id",selenium, ClassName, MethodName);
				selenium.keyPress(txtPatientBox, "\\9");
				selenium.clickAt("searchPatientBox","");
				selenium.focus("searchPatientBox");			
				selenium.fireEvent("searchPatientBox","keypress");
				waitForPageLoad(selenium);
				waitForElement(selenium,lblPatientResult,10000);	
				assertTrue(selenium.isElementPresent(lblsearchResult),"Search Results are displayed for the patient with ID :-"+historyData.patientId,selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblsearchResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patId.trim().toLowerCase(new java.util.Locale("en","US"))),"Mathc failed",selenium, ClassName, MethodName);
				return true;
			}
			
			if(historyData.testCaseId.equals("TC_VSP_011")){
				searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);
				waitForPageLoad(selenium);
				return true;
			}
			
			if(historyData.testCaseId.equals("TC_VSP_001")){
			
				
			assertTrue(click(selenium,lnkTopMenu),"Could not click  Searcbh box;More details :"+ historyData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(!selenium.isTextPresent("Needs action:")){
				Assert.fail("Need action is not present");
			}
			return true;
			}
			
			int counter=0;
			while(!isElementPresent(selenium,lnkMySetting)){
				click(selenium,lnkTopMenu);
				
				counter++;
				
				if(counter>10){
					break;
				}
			}
			
			assertTrue(click(selenium,lnkMySetting),"Could not click the My setting link;More details :"+ historyData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnResetPassword),"Could not find the reset Password Link;More details :"+ historyData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnResetPassword),"Could not click the reset Password Link;More details :"+ historyData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,txtCurrentPassword),"Could not find the current Password;More details:"+historyData.toString(),selenium,ClassName,MethodName);
			assertTrue(isElementPresent(selenium,txtNewPassword),"Could not find the new Password;More details:"+historyData.toString(),selenium,ClassName,MethodName);
			assertTrue(isElementPresent(selenium,txtConfirmPassword),"Could not find the new confirm Password;More details:"+historyData.toString(),selenium,ClassName,MethodName);
			
			click(selenium,"cancel");
			waitForPageLoad(selenium);
			
			click(selenium,"yesButton");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkTopMenu),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignout),"Could not click the log out button",selenium,ClassName,MethodName);
			click(selenium,btnSignOutConfirmation);
			waitForPageLoad(selenium);
			click(selenium,"link=Yes");
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,txtAccount)){
				Assert.fail("Logout not success");
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}

	private void switchto(String string) {
		// TODO Auto-generated method stub
		
	}
}
