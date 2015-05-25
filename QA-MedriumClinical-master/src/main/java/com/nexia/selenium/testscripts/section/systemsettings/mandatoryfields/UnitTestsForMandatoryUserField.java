package com.nexia.selenium.testscripts.section.systemsettings.mandatoryfields;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForMandatoryUserField extends AbstractSystemSettingsTest {
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Field Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUnitFieldEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest mandData = new SystemsSettingsUnitTest();
		mandData.workSheetName = "UnitTest_SS_MandatoryField";
		mandData.testCaseId = "TC_SSMF_001";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createMandatoryField(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Field Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest mandData = new SystemsSettingsUnitTest();
		mandData.workSheetName = "UnitTest_SS_MandatoryField";
		mandData.testCaseId = "TC_SSMF_002";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createMandatoryField(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Field With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUnitFieldWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest mandData = new SystemsSettingsUnitTest();
		mandData.workSheetName = "UnitTest_SS_MandatoryField";
		mandData.testCaseId = "TC_SSMF_003";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createMandatoryField(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Field With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest mandData = new SystemsSettingsUnitTest();
		mandData.workSheetName = "UnitTest_SS_MandatoryField";
		mandData.testCaseId = "TC_SSMF_004";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createMandatoryField(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	/**
	 * createMandatoryField
	 * function to create Mandatory Field
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    June 27, 2012
	 */
	
	public boolean createMandatoryField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemsSettingsUnitTest mandData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mandData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mandData.userName, mandData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mandData.switchRole),"Swicth role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Mandatory User Field //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminMandatoryUserField),"Could not click on Mandatory User Field link:" + mandData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-3: Deleting existing entries  //
			//--------------------------------------------------------------------//
			int count=(Integer) selenium.getXpathCount(lnkAdminMandatoryUserCount );
			while(isElementPresent(selenium,"//div[@id='adminMandatoryUserFieldList']/table/tbody/tr["+count+"]/td[2]/div/a")){
				waitForPageLoad(selenium);
				click(selenium,"//div[@id='adminMandatoryUserFieldList']/table/tbody/tr["+count+"]/td[2]/div/a");
				waitForPageLoad(selenium);
				click(selenium,btnYes);
				waitForPageLoad(selenium);
				int countAfterDeletion=(Integer) selenium.getXpathCount(lnkAdminMandatoryUserCount );
				if((count==countAfterDeletion)&&(countAfterDeletion!=0)){
					Assert.fail("Could not Delete the Identifier type;More Details:"+mandData.toString());
				}
				waitForPageLoad(selenium);
				count--;
			}
			//--------------------------------------------------------------------//
			//  Step-4: Add a new Mandatory User Field
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAddMandatoryUserField),"Could not click on Add Mandatory User Field link:" + mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//------------------------Step-4: Verify the Unit Test----------------// 
			//--------------------------------------------------------------------//			
			createMandatoryUserFieldUniTests(selenium,mandData);
			assertTrue(isElementPresent(selenium, mandData.alert), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, mandData.alert).contains(mandData.alertMessage), "The expected validation message should contain the text - "+ mandData.alertMessage + " The actual validation message shown - " + getText(selenium, mandData.alert), selenium, ClassName, MethodName);
			
		}catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			returnValue=false;
			}
		return returnValue;
	}
}
