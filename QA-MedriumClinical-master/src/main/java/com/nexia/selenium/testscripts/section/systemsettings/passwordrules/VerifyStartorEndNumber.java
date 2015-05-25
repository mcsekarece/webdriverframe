package com.nexia.selenium.testscripts.section.systemsettings.passwordrules;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyStartorEndNumber extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verifying Start or end number check box")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void startorEndNumberWithPasswordrules(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest pwdData = new SystemsSettingsUnitTest();
		pwdData.workSheetName = "UnitTest_SS_PassWordRules";
		pwdData.testCaseId = "TC_SSPR_006";
		pwdData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyPasswordrules(seleniumHost, seleniumPort, browser, webSite, userAccount, pwdData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verifying start or end end number with password rules
	* @action 		  verifying start or end end number with password rules
	* @author         Aspire QA
	 * @throws IOException 
	* @defect         Closed
	* defectId        3395
	* @useraccount    Both
	* @since  	      April 10, 2013
	***************************************************************************************************/
	
	public boolean verifyPasswordrules(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemsSettingsUnitTest pwdData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrieve the New Selenium Session; More Details :" + pwdData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pwdData.userName, pwdData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pwdData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-3:Navigate to Security setting  --------------//
			//--------------------------------------------------------------------//
			assertTrue(goToSecuritysetting(selenium),"Could not navigate to security setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-4:Navigate to Password rules  --------------//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPasswordRules),"Could not click the Password rules link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,btnPREdit),"Could not click the edit button", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			
			selenium.clickAt(btnPREdit, "");
			
			if(!isChecked(selenium,chkStartNumber)){
				assertTrue(click(selenium,chkStartNumber),"Could not check the check box", selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnPRSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-5:Verify store value  --------------//
			//--------------------------------------------------------------------//
			assertTrue(selenium.isTextPresent("Password cannot start or end with a number"), 
					"The Details is not getting displayed properly ", selenium, ClassName, MethodName);
			

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}	
}
