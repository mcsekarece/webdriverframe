package com.nexia.selenium.testscripts.section.systemsettings.mandatoryfields;



import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMandatoryAlertinRegisterPatinet extends AbstractSystemSettingsTest {
	
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "TicketNo: #4607")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewMandatory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "CreateMandatoryField";
		mandData.testCaseId = "TC_MF_006";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createMandatoryField(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	
	/**
	 *  Verify Mandatory Alert in Register Patinet
	 * function to  Verify Mandatory Alert in Register Patinet
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @Ticket      #4207  
	 * @since  	    June 27, 2012
	 */
	
	public boolean createMandatoryField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib mandData) throws Exception{
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
			
			assertTrue(switchRole(selenium,mandData.switchRole), "Switch role failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Mandatory User Field //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, lnkSettings),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAdminMandatoryUserField),"Could not click on Mandatory User Field link:" + mandData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-3: Deleting existing entries  //
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllMandatoryUserField(selenium),"Delete mandatory failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Add a new Mandatory User Field
			//--------------------------------------------------------------------//
		
			assertTrue(click(selenium,lnkAddMandatoryUserField),"Could not click on Add Mandatory User Field link:" + mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createMandatoryUserField(selenium,mandData),"Mandatory User Field Creation failed", selenium, ClassName, MethodName);
				
			
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Mandatory Alerts  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave1),"Could not click the button Save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isTextPresent("preference cannot be empty")){
				Assert.fail("Verify Mandatory Alert in Register Patinet");
			}else
				returnValue = true;
			
			assertTrue(click(selenium, btnPatientCancel),"Could not click on cancel button on register Patient page ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Mandatory User Field //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkSettings),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminMandatoryUserField),"Could not click on Mandatory User Field link:" + mandData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-3: Deleting existing entries  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllMandatoryUserField(selenium), "Delete mandatory failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a")){
				Assert.fail("Verify Delete Mandatory Details");
			}else
				returnValue = true;
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
	