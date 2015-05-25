package com.nexia.selenium.testscripts.section.demographics.MySettings;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRecentPatientListAfterLogOut extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Recent Patient List After LogOut")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void checkSignOutSignInFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib mySettingsData = new HomeLib();
		mySettingsData.workSheetName = "MySettings";
		mySettingsData.testCaseId = "TC_NMS_001";
		mySettingsData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		checkSignoutFlow(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Recent Patient List After LogOut
	* @action 		  Verifying Recent Patient List After LogOut
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 27, 2012
	***************************************************************************************************/
	public boolean checkSignoutFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib mySettingsData) throws Exception{
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mySettingsData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mySettingsData.userName, mySettingsData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//   Step-2:Change Switch Role                                        //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mySettingsData.switchRole),"",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,"MATHEWAAB");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkTopMenu),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignout),"Could not click the log out button",selenium,ClassName,MethodName);
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,"link=Yes"),"Could not click on System settings link:" + mySettingsData .toString(),selenium,ClassName,MethodName);
			//waitForPageLoad(selenium);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mySettingsData.userName, mySettingsData.newPassword),"Login Failed while using the password which has been reset",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkShowRecentPatient),"Could not click recent patient list link;More Details"+mySettingsData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForElement(selenium,lblPatientBorderBottom,10000);
			assertTrue(!selenium.isElementPresent(lblPatientResult),"Search Results displayed for the patient with ID :- MATHEWAAB",selenium,ClassName,MethodName);
			assertTrue(!getText(selenium,lblPatientResult).contains("MATHEWAAB"),"",selenium,ClassName,MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}
