package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures.AdminPractice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyBackButton extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying  Back Button")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void backbuttonInPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_007";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyBackButton(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        verify Back Button
	* @action 		  verifying Back Button
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 23, 2013
	***************************************************************************************************/
	 
	public boolean verifyBackButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
			Selenium selenium=null;
			boolean returnValue=false;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application //
				//--------------------------------------------------------------------//
			
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pracData .toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

				//--------------------------------------------------------------------//
				//---------------  Step-2:Change Switch Role  --------------//
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-2: Go to System Settings and navigate to Practices//
				//--------------------------------------------------------------------//
				Assert.assertTrue(gotoSystemSetting(selenium));
			    waitForPageLoad(selenium);		
				//--------------------------------------------------------------------//
				//  Step-3: Delete Practice//
				//--------------------------------------------------------------------//
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				type(selenium, txtSearchBox ,pracData.practiceName);
				waitForPageLoad(selenium);
				click(selenium,btnSearchBox);
				waitForPageLoad(selenium);
				int counter=1;
				while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
					if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(pracData.practiceName)){
						click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a");
						click(selenium,btnYes);
						waitForPageLoad(selenium);
						}
					else {counter++;}
					if(counter>15)
						break;
				}
				//--------------------------------------------------------------------//
				//  Step-3: Add Practice//
				//--------------------------------------------------------------------//
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName=DateFormat.format(cal.getTime());
				
				Assert.assertTrue(click(selenium,btnAddPractice),"Could not find add practice button");
				waitForPageLoad(selenium);
				
				assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnLocationCancel),"Could not click the cancel button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnPracticeBack),"Could not click the back button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(!isElementPresent(selenium,btnPracticeName)){
					Assert.fail("practice name is not getting displyed");
				}
				
				//--------------------------------------------------------------------//
				//  Step-4: search Practice//
				//--------------------------------------------------------------------//
				Assert.assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the system setting link");
				waitForPageLoad(selenium);
				type(selenium, txtSearchBox ,pracData.practiceName+uniqueName);
				waitForPageLoad(selenium);
				click(selenium,btnSearchBox);
				waitForPageLoad(selenium);
				
				return returnValue;
				
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
