package com.nexia.selenium.testscripts.section.smoketest;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.smoketest.SmokeTestLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.thoughtworks.selenium.Selenium;

public class AboutBoxVerification extends AbstractSmokeTest {
	@Test(enabled=false)	
	//@Test(groups = {"firefox", "iexplore", "safari", "default" }, description = "Test for Verifying the About Box")
	//WebDriver driver =new FirefoxDriver();
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void aboutBoxDetailsVerification(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SmokeTestLib aboutData = new SmokeTestLib();
		aboutData.workSheetName = "AboutBox";
		aboutData.testCaseId = "TC_AB_001";
		aboutData.fetchSmokeTestData();		
		AboutBox(seleniumHost, seleniumPort, browser, webSite, userAccount, aboutData);
	}
	
	public boolean AboutBox(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SmokeTestLib aboutData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			//selenium = getSessionWebdriver(seleniumHost, seleniumPort, browser, webSite, driver);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + aboutData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, aboutData.userName, aboutData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Click on the Help Icon and About link//
			//--------------------------------------------------------------------//
			
					
			assertTrue(click(selenium, imghelp), "Could not click on the helpIcon",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lblPopup),"Dialog box not present",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkAboutNexia), "Could not click on the About Nexia link",selenium, ClassName, MethodName);
			//assertTrue(click(selenium, "link=About neXia emr™"), "Could not click on the About Nexia link");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify the few basic details e.g. Version and Release Date etc //
			//--------------------------------------------------------------------//
						
			assertTrue(selenium.isTextPresent("About NightingaleEHR"), " Text (About NightingaleEHR) is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Version:"), " Text (Version:) is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Release Date:"), " Text (Release Date:) is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Drug Database Information"), " Text (Drug Database Information) is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Coding System Information"), " Text (Coding System Information) is not present",selenium, ClassName, MethodName);
			//assertTrue(selenium.isTextPresent("cpt"), " Text (cpt) is not present");
			//assertTrue(selenium.isTextPresent("icd9"), " Text (icd9) is not present");
			if(userAccount.equals(CAAccount)){
				assertTrue(selenium.isTextPresent("drugs_canadian"), " Text (Drug canadian Information) is not present",selenium, ClassName, MethodName);
			}else
				assertTrue(selenium.isTextPresent("drugs_redbook_normalize"), " Text (Drug redbook normalize information) is not present",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Close the About Box //
			//--------------------------------------------------------------------//
					
			assertTrue(click(selenium, btnClose), "Could not click close button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
		}					
		catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" );
		}
		return returnValue;
	}	
}
