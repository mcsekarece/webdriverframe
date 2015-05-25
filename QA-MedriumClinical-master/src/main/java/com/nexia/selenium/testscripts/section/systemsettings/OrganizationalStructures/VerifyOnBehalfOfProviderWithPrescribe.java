package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import static com.sharedlibrary.ThreadSafeSeleniumSessionStorage.session;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyOnBehalfOfProviderWithPrescribe extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderWithPrescribeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib prescribeData = new SystemSettingsLib();
		prescribeData.workSheetName = "CreatePractice";
		prescribeData.testCaseId = "TC_CPR_005";
		prescribeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyOnBehalfProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        DefctAutomation
	* @ticket         #1925
	* @action 		  VerifyOnBehalfOfProviderWithPrescribe
	* @expected       Provider should be not be show in the picklist
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Fixed
	* @useraccount    Both
	* @since  	      March 15, 2013
	***************************************************************************************************/
	
	public boolean verifyOnBehalfProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib prescribeData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Naviagte to System Setting//
			//--------------------------------------------------------------------//
			assertTrue(navigatetoSystemSetting(selenium),"could not navigate to ssytem settingss", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Search Practice//
			//--------------------------------------------------------------------//
			if(!searchPractice(selenium,prescribeData)){
			//--------------------------------------------------------------------//
			//-------------Step-4: Create New Practcice  -------------------------//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddPractice),"Could not find add practice button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			prescribeData.practiceName=prescribeData.practiceName+uniqueName;
			
			assertTrue(addAdminPractice(selenium,prescribeData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}else
				if(getText(selenium,"name").toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.practiceName.trim().toLowerCase(new java.util.Locale("en","US"))))
					returnValue=true;
				
			
			//--------------------------------------------------------------------//
			//-------------Step-5:Search User -------------------------//
			//--------------------------------------------------------------------//
			assertTrue(navigatetoSystemSetting(selenium),"could not navigate to ssytem settingss", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Assert.assertTrue(type(selenium,txtProFirstName,prescribeData.userName),"Could not type the last name");
			Assert.assertTrue(click(selenium,btnUserSearch),"Could not click the search button");
			waitForPageLoad(selenium);
			System.out.println(getText(selenium,txtLastName1));
			if(isElementPresent(selenium,"//a[starts-with(@id, 'DeleteUser')]")){
				Assert.assertTrue(click(selenium,txtLastName1));
				
			}
			else{
			    Assert.fail("search user failed");
			}
			
			if(isElementPresent(selenium,btnEdit1)){
				Assert.assertTrue(click(selenium,btnEdit1));
			}else{
				return false;
			}
			
			selectValueFromAjaxList(selenium,ajxPractise,prescribeData.practiceName);
			assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//-------------Step-6:Log out the application-------------------------//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				selenium.chooseOkOnNextConfirmation();
			}
			
			if(isElementPresent(selenium, btnErrorClose))
				Assert.assertTrue(click(selenium, btnErrorClose));
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkTopMenuHeader),"Could not click on the link" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignOutAction),"Could not click on System settings link:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(session(),btnYes);
			waitForPageLoad(selenium);
			click(selenium,"Yes");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//-------------Step-7:Login to the application-------------------------//
			//--------------------------------------------------------------------//
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,"Mathew");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Naviagte to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				Assert.assertTrue(click(selenium, btnErrorClose));
			//--------------------------------------------------------------------//
			//  Step-9:Verify Provider//
			//--------------------------------------------------------------------//
			System.out.println(ajxProviderListSuggestBox);
			if(!getValue(selenium,ajxProviderListSuggestBox).equals("")){
				Assert.fail("The Provider name is getting displayed");
				returnValue=false;
			}else
				returnValue = true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + prescribeData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
