package com.nexia.selenium.testscripts.section.chartprevisit.EncounterReference;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionInReferenceQA extends AbstractChartPreVisit{
	@Test(groups = {"Developing","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib referenceData = new ChartPreVisitLib();
		referenceData.workSheetName = "VerifySecurityOption";
		referenceData.testCaseId = "TC_VSP_001";
		referenceData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyReferrenceSecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, referenceData);
	}

	@Test(groups = {"Developing","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib referenceData = new ChartPreVisitLib();
		referenceData.workSheetName = "VerifySecurityOption";
		referenceData.testCaseId = "TC_VSP_002";
		referenceData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyReferrenceSecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, referenceData);
	}
	
	@Test(groups = {"Developing","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib referenceData = new ChartPreVisitLib();
		referenceData.workSheetName = "VerifySecurityOption";
		referenceData.testCaseId = "TC_VSP_003";
		referenceData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyReferrenceSecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, referenceData);
	}
	
	@Test(groups = {"Developing","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib referenceData = new ChartPreVisitLib();
		referenceData.workSheetName = "VerifySecurityOption";
		referenceData.testCaseId = "TC_VSP_004";
		referenceData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyReferrenceSecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, referenceData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Security Option
	* @action 		  verifying Security Option 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Completed
	* @defect		  #5771
	* @useraccount    Both(Us and Canada)
	* @since  	      July 18, 2014
	***************************************************************************************************/
	
	public boolean verifyReferrenceSecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib referenceData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + referenceData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, referenceData.userName, referenceData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,referenceData.switchRole),"Could not change the switch role;More Details:"+referenceData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
			if(referenceData.testCaseId.equals("TC_VSP_003")){
				assertTrue(click(selenium,lnkQuickAction),"Could not Click on Quick action"+ referenceData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(isElementPresent(selenium,lnkReferences),"Could not Find the element", selenium, ClassName, MethodName);
			
			}		

			//--------------------------------------------------------------------//
			//  Step-5: Verify security option 									  //
			//--------------------------------------------------------------------//
			
			//Navigate to References
			assertTrue(goToReference(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifySecurity(selenium,referenceData),"security verification failed", selenium, ClassName, MethodName);
			
		
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib referenceData) throws IOException{
		
		boolean returnValue=false;
		
		//Limited Access
		if(referenceData.testCaseId.equals("TC_VSP_001")){
			referenceData.workSheetName = "CreateEncounterReference";
			referenceData.testCaseId = "TC_ER_008";
			referenceData.fetchChartPreVisitTestData();
			assertTrue(createEncounterReference(selenium,referenceData),"Refernece is not created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!getText(selenium,"css=div.popupContent").toLowerCase(new java.util.Locale("en","US")).trim().contains(referenceData.bookMark.toLowerCase(new java.util.Locale("en","US")).trim())){
				Assert.fail("Details are not getting displayed");
			}
			
			if(selenium.isTextPresent("Delete")){
				return false;
			}
			
			if(!(isElementPresent(selenium,btnCancel))&&(selenium.isTextPresent("Edit"))){
				return false;
			}else
				return true;
		}
		
		//View only Access
		if(referenceData.testCaseId.equals("TC_VSP_002")){
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ referenceData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			if(!isElementPresent(selenium,btnCancel)){
				returnValue=false;
			}
			
			if(!(selenium.isTextPresent("Delete")&&(selenium.isTextPresent("Edit")))){
				return false;
			}else
				return true;
		}
			
		//Full Access
		if(referenceData.testCaseId.equals("TC_VSP_004")){
			
			referenceData.workSheetName = "CreateEncounterReference";
			referenceData.testCaseId = "TC_ER_008";
			referenceData.fetchChartPreVisitTestData();
			assertTrue(createEncounterReference(selenium,referenceData),"Refernece is not created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!getText(selenium,"//div[4]/div/div/div[2]/div/div[3]").toLowerCase(new java.util.Locale("en","US")).trim().contains(referenceData.bookMark.toLowerCase(new java.util.Locale("en","US")).trim())){
				Assert.fail("Details are not getting displayed");
			}
			
			if(!(selenium.isTextPresent("Delete"))&&(isElementPresent(selenium,btnCancel))&&(selenium.isTextPresent("Edit"))){
				return true;
			}else
				return false;
		}
		return returnValue;
	}
}
