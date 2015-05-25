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

public class VerifyLocationDetailsInSummaryPage extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Location Details ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addLocationWithPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_007";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addLocation(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Location Details ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addLocationWithPracticeAndLab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_014";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addLocation(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Location Details ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addLocationWithPracticeAndWithOutLab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_015";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addLocation(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Location Details ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addLocationWithPracticeAndLabArticle16(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_016";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addLocation(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Location Details ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addLocationWithPracticeAndLabArticle28(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_017";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addLocation(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Location Details ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addLocationWithPracticeWithSLI(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_018";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addLocation(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify  Location Details in Summary page 
	* @action 		  verifying Location Details in Summary page 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 30, 2013
	***************************************************************************************************/
	
	public boolean addLocation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
		
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
				//  Step-4: Add Practice//
				//--------------------------------------------------------------------//	
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName=DateFormat.format(cal.getTime());
				
				Assert.assertTrue(click(selenium,btnAddPractice),"Could not find add practice button");
				waitForPageLoad(selenium);
				
				assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5:add Location//
				//--------------------------------------------------------------------//
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				String date=DateFormat1.format(cal1.getTime());
				SimpleDateFormat DateFormat2=new SimpleDateFormat("HH:mm");
				String time=DateFormat2.format(cal1.getTime());
				
				waitForPageLoad(selenium);
				assertTrue(addLocation(selenium,pracData,userAccount),"could not create the location", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
			
				//--------------------------------------------------------------------//
				//  Step-6: Verify the stored in Location details in summary page				//
				//--------------------------------------------------------------------//
				
				
				if(!verifyStoredValues(selenium,pracData,userAccount,date,time)){
					Assert.fail("Practice details not saved properly; More Details :"+ pracData.toString());
					returnValue=false;
				}
				
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	
	
	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib pracData,String account, String date, String time) throws IOException{
		
		assertTrue(selenium.isTextPresent(pracData.locationName1.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
		if(account.equals(CAAccount)){
			assertTrue(selenium.isTextPresent(pracData.zipcodeCa.trim().toLowerCase(new java.util.Locale("en","US"))), "",selenium, ClassName, MethodName);
		}else
			assertTrue(selenium.isTextPresent(pracData.zipcode.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
		
		Assert.assertTrue(click(selenium,lblLocationDetails),"Could not click the expand arrow");
		waitForPageLoad(selenium);
		
		
		assertTrue(getText(selenium,lblLocationDet).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.mammography.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblLocationDet).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.locationName1.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblLocationDet).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.groupNpi.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
		
		/*if(!getText(selenium,lblLocationDet).toLowerCase(new java.util.Locale("en","US")).trim().contains(date)){
			return false;
		}*/
		return true;
	}
}
