package com.nexia.selenium.testscripts.section.systemsettings.healthcareteam;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class TabbingOrderForHealthCareTeam extends AbstractHomeTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Tabbing a Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabibgOrderHealthCareTeamForAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib HealthCareTaborder = new SystemSettingsLib();
		HealthCareTaborder.workSheetName="CreateHealthCareTeam";
		HealthCareTaborder.testCaseId="TC_HCT_001";
		HealthCareTaborder.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbibgOrderForHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, HealthCareTaborder);
	}
	/**
	 * verifyTabbingOrderForAdminHealthCareTeam
	 * function to verify Tabbing Order For Admin Health Care Team
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     Mar 16, 2012
	 */	
	public void verifyTabbibgOrderForHealthCareTeam(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,SystemSettingsLib HealthCareTaborder) throws IOException{
		 
		Selenium selenium=null;
		String csspaths[]={"//span/input","//span[2]/input","css=#teamName","css=#notes","css=button.secondary-button"};
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + HealthCareTaborder.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, HealthCareTaborder.userName, HealthCareTaborder.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,HealthCareTaborder.switchRole), "Switch role failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkSystemSettingLink ),"Could not click on link System Settings", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			
			//Step-4: Go to Health Care Team //
			assertTrue(click(selenium,lnkAdminHealthcareTeamList),"Could not click on Health Care Team link:" + HealthCareTaborder.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnAddHealthcareTeam),"Could not click on Add Health Care Datalink:" + HealthCareTaborder.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			for(int i =0;i<csspaths.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
			
			}click(selenium,"//div/button");
				waitForPageLoad(selenium);
				for(int i =0;i<csspaths.length;i++){
					assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
					selenium.focus(csspaths[i]);
					waitForElementToEnable(selenium,csspaths[i]);
					selenium.keyPress(csspaths[i], "\\9");
					Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
				}
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
		
