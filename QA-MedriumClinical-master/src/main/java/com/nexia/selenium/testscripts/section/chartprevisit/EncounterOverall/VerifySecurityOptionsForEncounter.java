package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionsForEncounter extends AbstractChartPreVisit {
	@Test(groups =  {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_001";
		historyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}

	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_002";
		historyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_003";
		historyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_004";
		historyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
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
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,historyData.switchRole),"Could not change the switch role;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(historyData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,historyData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//
						
			if(!historyData.testCaseId.equals("TC_VSP_003")){
				  
				searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);
				waitForPageLoad(selenium);	
				
				if(isElementPresent(selenium,"errorCloseButton")){
					click(selenium,"errorCloseButton");
				}
				waitForPageLoad(selenium);						
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}	
												
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,historyData)){
				fail("Security option not show properly; More Details :"+ historyData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib historyData) throws IOException{
		
		boolean returnValue=true;
		//Limited Access
		if(historyData.testCaseId.equals("TC_VSP_001")){
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSaveEncounter),"Could not click on encounter's link;", selenium, ClassName, MethodName);
			
//			selenium.focus("saveEncounter");
//			selenium.clickAt("saveEncounter","");
//			
			
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium, lblEncounterSave),"Could not click the save button", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			//assertTrue(click(selenium, "//*[@id='yesButton']"),"Could not click Yes button", selenium, ClassName, MethodName);
		
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click on encounter's link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	        if(isElementPresent(selenium, btnErrorClose))
               assertTrue(click(selenium, btnErrorClose)," ", selenium, ClassName, MethodName);

			assertTrue(click(selenium,inkUnSignedEnCounterAction),"Could not click on Actions button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lnkPendingSign).toLowerCase(new java.util.Locale("en","US")).trim().contains("Delete".trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
			else 
				return returnValue;
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,btnSign)){
				returnValue=false;
			}else
				return returnValue;
			
			}
		//ViewOnlyAccess
		if(historyData.testCaseId.equals("TC_VSP_002")){
			assertTrue(click(selenium,lnkencounterTab),"Could not click on encounter's link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			if(getText(selenium,inkUnSignedEnCounterAction).toLowerCase(new java.util.Locale("en","US")).trim().contains("Actions".trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue=false;
			}
			else 
				return returnValue;
			

			if(selenium.isVisible(BeginEncounter)){
				returnValue=false;
			}else
				return returnValue;
			
			if(selenium.isVisible(lnlPrintsend)){
				returnValue= false;
			}else
				return returnValue;
			
			click(selenium,btnBack);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkUnsignedEncounter),"Could not click on encounter's link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"css=div.reallyLighter.smallPlus"),"Could not click on encounter's link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		
			
			if(selenium.isVisible(lnkencounterTab)){
				returnValue= false;
			}else
				return returnValue;
			
			
		}
		
		//Full Access
		if(historyData.testCaseId.equals("TC_VSP_004")){
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,btnSign)){
				return returnValue;
			}else
				returnValue=false;
			
		}
		return returnValue;
	}
}
