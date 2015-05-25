package com.nexia.selenium.testscripts.section.systemsettings.enterprise_Variables;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForEnterpriseVariable extends AbstractSystemSettingsTest{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Id type with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIdTypeWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest enterpriseData= new SystemsSettingsUnitTest();
		enterpriseData.workSheetName = "UnitTest_SS_EnterpriseVariable";
		enterpriseData.testCaseId = "TC_SSEP_001";
		enterpriseData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addEnterpriseVariable(seleniumHost, seleniumPort, browser, webSite, userAccount, enterpriseData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Id Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIdNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest enterpriseData= new SystemsSettingsUnitTest();
		enterpriseData.workSheetName = "UnitTest_SS_EnterpriseVariable";
		enterpriseData.testCaseId = "TC_SSEP_002";
		enterpriseData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addEnterpriseVariable(seleniumHost, seleniumPort, browser, webSite, userAccount, enterpriseData);
	}	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Id Name with Max Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIdNameWithMaxCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest enterpriseData= new SystemsSettingsUnitTest();
		enterpriseData.workSheetName = "UnitTest_SS_EnterpriseVariable";
		enterpriseData.testCaseId = "TC_SSEP_003";
		enterpriseData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addEnterpriseVariable(seleniumHost, seleniumPort, browser, webSite, userAccount, enterpriseData);
	}	
	public boolean addEnterpriseVariable(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest externalData) throws IOException{
		Selenium selenium = null;
		String alertText="";
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			// Login to the application//
			//--------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + externalData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, externalData.userName, externalData.userPassword);
			waitForPageLoad(selenium);


			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,externalData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to system settings  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkEnterpriseVariables),"Could click enterpriseID.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddenterprise),"Could click add enter prise id", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			try {
				if(!addsEnterpriseVariable(selenium, externalData) && externalData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
					if(isElementPresent(selenium,"//p")){
						alertText = getText(selenium, "//p");
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(externalData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US"))))
						{
							return returnValue;			
						}else{
							assertTrue(false, "An unexpected Alert is displayed with message; The Expected :"+externalData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + externalData.toString(), selenium, ClassName, MethodName);							
						}
					}else{
						assertTrue(false, "Alert is not getting displayed; The Expected :"+externalData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
					}	
				}else if(externalData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
					return returnValue;
				}else{
					assertTrue(false,"Expected Alert is not displayed; The Expected :"+externalData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + externalData.toString() , selenium, ClassName, MethodName);					
				}
			} catch (RuntimeException e) {
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)",selenium, ClassName, MethodName);
				returnValue=false;
			}
		}catch(RuntimeException e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean addsEnterpriseVariable(Selenium selenium,SystemsSettingsUnitTest enterpriseData) throws IOException{
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxSuggestBox, enterpriseData.idType);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtVariableBox,enterpriseData.idName),"Could not type the enterprise Name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,lblAdminSettings )){
			return true;
		}
		else{
			return false;
		}
	}
}
