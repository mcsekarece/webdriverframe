package com.nexia.selenium.testscripts.section.demographics.MySettings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySwitchLanguage extends AbstractHomeTest {
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing the switch Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySwitchLanguageFromEngToFrench(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib switchLangData = new HomeLib();
		switchLangData.workSheetName = "SwitchRole";
		switchLangData.testCaseId = "TC_SR_001";
		switchLangData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySwitchLanguage(seleniumHost, seleniumPort, browser, webSite, userAccount, switchLangData);
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing the switch Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySwitchLanguageFromFrenchToEng(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib switchLangData = new HomeLib();
		switchLangData.workSheetName = "SwitchRole";
		switchLangData.testCaseId = "TC_SR_001";
		switchLangData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySwitchLanguage(seleniumHost, seleniumPort, browser, webSite, userAccount, switchLangData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify create Identifier
	* @action 		  verifying create Identifier
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 09, 2010
	***************************************************************************************************/
	public boolean verifySwitchLanguage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib switchLangData) throws Exception{
		Selenium selenium = null;	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + switchLangData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, switchLangData.userName, switchLangData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to TOp Mean  and navigate to switch Language //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTopMenu),"Could not click top mean header;More Details:"+switchLangData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLanguageSwitch),"Could not click on switch language link;More Details:"+switchLangData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:  Verifying switched role   //
			//--------------------------------------------------------------------//
			if(!verifyStoreValue(selenium,switchLangData)){
				Assert.fail("Language is not Switched properly; More Details :"+ switchLangData.toString());
				return false;
			}
			
			if(switchLangData.testCaseId.equals("TC_SR_002")){
				assertTrue(click(selenium,lnkTopMenu),"Could not click top mean header;More Details:"+switchLangData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkLanguageSwitch),"Could not click on switch language link;More Details:"+switchLangData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(!verifyStoreValueForEnglish(selenium,switchLangData)){
					Assert.fail("Language is not Switched properly; More Details :"+ switchLangData.toString());
					return false;
				}
			}
			
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	
	public boolean verifyStoreValue(Selenium selenium,HomeLib switchLangData) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(!getText(selenium,lblHomePageContent1).toLowerCase(new java.util.Locale("en","US")).trim().contains("Needs action".trim().toLowerCase(new java.util.Locale("en","US"))),"Creation failed", selenium, ClassName, MethodName);
		assertTrue(!getText(selenium,lblTitle).toLowerCase(new java.util.Locale("en","US")).trim().contains("Announcements".trim().toLowerCase(new java.util.Locale("en","US"))),"Creation failed", selenium, ClassName, MethodName);
		assertTrue(!getText(selenium,lblHomePageContent2).toLowerCase(new java.util.Locale("en","US")).trim().contains("Appointments for".trim().toLowerCase(new java.util.Locale("en","US"))),"Creation failed", selenium, ClassName, MethodName);
		return true;
	}
	public boolean verifyStoreValueForEnglish(Selenium selenium,HomeLib switchLangData) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(!getText(selenium,lblHomePageContent1).toLowerCase(new java.util.Locale("en","US")).trim().contains("Needs action".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
		assertTrue(!getText(selenium,lblTitle).toLowerCase(new java.util.Locale("en","US")).trim().contains("Announcements".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
		assertTrue(!getText(selenium,lblHomePageContent2).toLowerCase(new java.util.Locale("en","US")).trim().contains("Appointments for".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
		return true;
	}
}
