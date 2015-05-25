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

public class VerifyHoursFormatInLocationHours extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the 24 hr Format in Location section ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void twentyFourHrFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_009";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProviderInPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the 12 hr Format in Location section")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void twelveHrFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_010";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProviderInPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	/*************************************************************************************************** 
	* @purpose        verify Hours Format in Location Page
	* @action 		  verifying Hours Format in Location Page
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 30, 2013
	***************************************************************************************************/
	 
	public boolean addProviderInPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws IOException{
		boolean returnValue=false;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pracData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			//assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Program //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3: Delete Practice//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			type(selenium, txtSearchBox ,pracData.practiceName);
			waitForPageLoad(selenium);
			click(selenium,btnSearchBox);
			waitForPageLoad(selenium);
			int counter=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
				System.out.println(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div"));
				System.out.println(pracData.practiceName);
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.practiceName.toLowerCase(new java.util.Locale("en","US")).trim())){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td");
					waitForPageLoad(selenium);
				}else {counter++;}
				if(counter>10)
					break;
			}
			//--------------------------------------------------------------------//
			//  Step-4: Add Practice//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit1),"Could not click on edit button:" + pracData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(pracData.testCaseId.equals("TC_CPR_009")){
				if(!isChecked(selenium,chk24HrFormat)){
					Assert.assertTrue(click(selenium,chk24HrFormat),"Could not click the check box ");
					Assert.assertTrue(click(selenium,chkSchedul),"Could not click the scheduling check box check box ");
				}
			}
			
			assertTrue(click(selenium,btnNextFromPractice),"Could not click on next button:" + pracData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Exist Location 			//
			//--------------------------------------------------------------------//
//			assertTrue(click(selenium,btnLocationCancel),"Could not click on cancel button:" + pracData .toString(), selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
						
			int count =1;
			while(isElementPresent(selenium,btnDeleteLocation)){
			assertTrue(click(selenium,btnDeleteLocation),"Could not click on delete button:" + pracData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnYes),"Could not click on delete button:" + pracData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Create New Location			//
			//--------------------------------------------------------------------//
		    waitForPageLoad(selenium);
			assertTrue(click(selenium,AddLocation),"Could not click the edit button from location page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(addLocation(selenium,pracData,userAccount),"could not create the location", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnDonePratice),"could not click on done button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to location			//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "could not able to click the quick action link",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkScheduling), "could not able to click the Scheduling Setting link",selenium, ClassName, MethodName);
			
			selectValueFromAjaxList(selenium,txtSearchBox,pracData.locationName1);
			waitForPageLoad(selenium);
			/*if(!getText(selenium,lblLocationHoursDisplay).contains(pracData.locationName1)){
			    return false;
			}*/
			
			//--------------------------------------------------------------------//
			//  Step-6: Edit Location Hour						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkLocationEdit), "could not click the edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(pracData.testCaseId.equals("TC_CPR_009")){
				assertTrue(type(selenium,txtStartHour,pracData.startHour), "could not Enter the time",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSaveLocation), "could not click the save button",selenium, ClassName, MethodName);
			}else if(pracData.testCaseId.equals("TC_CPR_010")){
				assertTrue(type(selenium,txtStartHour,pracData.startHour), "could not Enter the time",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSaveLocation), "could not click the save button",selenium, ClassName, MethodName);
			}
			
		/*	if(pracData.testCaseId.equals("TC_CPR_010")){
				if(selenium.isTextPresent("Hours must be from 1 to 12")){
					returnValue = true;
				}else{
					Assert.fail("The text is not present");
				}
			}*/
			
			if(pracData.testCaseId.equals("TC_CPR_010")){
				selenium.mouseOver(txtStartHour);
				selenium.mouseOver(txtStartHour);
				selenium.mouseOver(txtStartHour);
				assertTrue(selenium.isTextPresent("Hours must be from 1 to 12"), "Hours must be from 1 to 12  alert is not present ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
}
