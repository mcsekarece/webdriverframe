package com.nexia.selenium.testscripts.section.smoketest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEnterpriseVariableList extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for deleting an Enterprise Vaiable")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void EnterpriseVariableList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib enterPriseData = new SystemSettingsLib();
		enterPriseData.workSheetName = "AdminEnterPriseVariables";
		enterPriseData.testCaseId = "TC_Pv_003";
		enterPriseData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyVariableList(seleniumHost, seleniumPort, browser, webSite, userAccount, enterPriseData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Variable List for Enter prise variable
	* @action 		  verifying Variable List for Enter prise variable
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @defect 		  #7035	
	* @useraccount    Both (US and Canada)
	* @since  	      Jan 06, 2014
	***************************************************************************************************/
	public boolean verifyVariableList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib enterPriseData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + enterPriseData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, enterPriseData.userName, enterPriseData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,enterPriseData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to Enterprise Variables //
			//----------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEnterpriseVariables),"Could not click the Enter prise Variable;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------------------//
			//  Step-4: Verify Varaible Pick list in Enterprise Variables //
			//----------------------------------------------------------------------//
			assertTrue(selenium.isTextPresent("absence reasons"),"absence reasons text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Address Book Contact Companies"),"Address Book Contact Companies text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("addressbook contact type"),"addressbook contact type text is not present in t`		he list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Age Groups"),"Age Groups text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Chart Inactivation Reason"),"Chart Inactivation Reason text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Chart Status"),"Chart Status text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("consent type"),"consent type reasons text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("contact type"),"contact type text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Correspondence Report Type"),"Correspondence Report Type text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Culture is"),"Culture is text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("gender"),"gender text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Group Objective"),"Group Objective text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Healthcare Team Reason for Deletion"),"Healthcare Team Reason for Deletion text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("healthcare team role"),"healthcare team role text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("living arrangement"),"living arrangement for Deletion text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("location type"),"location type text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Medication History Change Reason"),"Medication History Change Reason text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Note Type"),"Note Type text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Physical or mental Conditions"),"Physical or mental Conditions text is not present in the list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Planned activities"),"Planned activities text is not present in the list", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return returnValue;
	}
}
