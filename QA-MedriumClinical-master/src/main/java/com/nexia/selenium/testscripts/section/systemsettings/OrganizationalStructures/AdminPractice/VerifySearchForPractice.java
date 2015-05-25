package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures.AdminPractice;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchForPractice extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice With Mandatory")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySearchPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	/**
	 * verifySearchPractice
	 * function to verifySearchPractice
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 31, 2012
	 */
	public boolean verifySearchPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
		
			Selenium selenium=null;
			boolean returnValue=true;
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
				/*assertTrue(switchRole(selenium,pracData.switchRole),"switch role failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);*/
				//--------------------------------------------------------------------//
				//  Step-3: Go to System Settings and navigate to Practices//
				//--------------------------------------------------------------------//
				 assertTrue(gotoSystemSetting(selenium),"", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);		
				//--------------------------------------------------------------------//
				//  Step-4: Delete Practice//
				//--------------------------------------------------------------------//
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				type(selenium, txtSearchBox ,pracData.practiceName);
				waitForPageLoad(selenium);
				click(selenium,btnSearchBox);
				waitForPageLoad(selenium);
				int counter=1;
				while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
					if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(pracData.practiceName)){
						assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a"),"", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnYes),"", selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						
					}
					else {counter++;}
					if(counter>15)
						break;
				}
				//--------------------------------------------------------------------//
				//  Step-5: Add Practice//
				//--------------------------------------------------------------------//
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName=DateFormat.format(cal.getTime());
				
				 assertTrue(click(selenium,btnAddPractice),"Could not find add practice button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Verify the Search Practice					//
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				type(selenium, txtSearchBox ,pracData.practiceName);
				waitForPageLoad(selenium);
				click(selenium,btnSearchBox);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				int count=1;
				while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div")){
					if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div").contains(pracData.practiceName)){
						return returnValue;
					}
					else {count++;}
					if(count>15)
						break;
				}	
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + pracData.toString(), selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	
	
}
