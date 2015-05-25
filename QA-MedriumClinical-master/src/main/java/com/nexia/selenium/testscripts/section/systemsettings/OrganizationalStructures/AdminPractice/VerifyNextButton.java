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

public class VerifyNextButton extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying  Back Button")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void nextButtonInPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyNextButton(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
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
	 
	public boolean verifyNextButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
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
				assertTrue(gotoSystemSetting(selenium),"could not navigate to system setting", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);		
				//--------------------------------------------------------------------//
				//  Step-3: Delete Practice//
				//--------------------------------------------------------------------//
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName=DateFormat.format(cal.getTime());
				assertTrue(type(selenium, txtSearchBox ,pracData.practiceName+uniqueName),"could not type in search box", selenium, ClassName, MethodName);
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
				assertTrue(click(selenium,btnAddPractice),"Could not find add practice button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				pracData.testCaseId = "TC_CPR_007";
				assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnLocationCancel),"Could not click cancel location"+ pracData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnNextOne),"Could not click on Next button at Additional Location page"+ pracData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(btnNextOne),"Next button is present at Centralized Billing Address page"+ pracData.toString(),selenium, ClassName, MethodName);
				
				assertTrue(click(selenium,btnDonePratice),"Could not click the cancel button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-4: search Practice//
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the system setting link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtSearchBox ,pracData.practiceName+uniqueName),"could not type in search box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				click(selenium,btnSearchBox);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr[1]/td/div"),"Practice not added",selenium,ClassName,MethodName);
				return returnValue;
				
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
