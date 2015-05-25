package com.nexia.selenium.testscripts.section.demographics.MySettings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultRoleAndPractice extends AbstractHomeTest{
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing the switch Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultRole(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib roleData = new HomeLib();
		roleData.workSheetName = "SwitchRole";
		roleData.testCaseId = "TC_SR_002";
		roleData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyDefaultRoleAndPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, roleData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Default Role And Practice
	* @action 		  verifying Default Role And Practice
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 21, 2010
	***************************************************************************************************/
	public boolean verifyDefaultRoleAndPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib roleData) throws IOException{
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + roleData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, roleData.userName, roleData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,roleData.switchRole),"",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to User                //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSetting),"Could not click on System settings link:" + roleData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-4: Search for a user//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			type(selenium,txtUserSearch,roleData.userName1);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnUserSearch),"Could not click on search button:" + roleData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium,lblUserSearchResult)){
				assertTrue(click(selenium,chkIncludeInactiveUsers),"Could not click on include Inactive Users checkbox:" + roleData .toString(),selenium,ClassName,MethodName);
				assertTrue(isElementPresent(selenium,lblUserSearchResult),"Could not find the user",selenium,ClassName,MethodName);
				assertTrue(click(selenium,lblActivateAppleUser),"Could not click on activate button:" + roleData .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lblUserSearchResult),"Could not click on user link:" + roleData .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}else{
				assertTrue(click(selenium,lblUserSearchResult),"Could not click on user link:" + roleData .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				}
			
			//--------------------------------------------------------------------//
			//  Step-5:Go to Top Mean click Sign out//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnBackButton),"Could not click the back button;More Details:"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkTopMenu),"Could not click top mean header;More Details:"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignout),"Could not click the sign out link;More Details:"+roleData.toString(),selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnYesButton),"Could not click yes button;More Details"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-6: login New User//
			//--------------------------------------------------------------------//
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, roleData.userName1, roleData.userPassword1),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to system setting//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSetting),"Could not click on System settings link:" + roleData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnBackButton),"Could not click the back button;More Details:"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Go to Top Mean and Navigate to My setting//
			//--------------------------------------------------------------------//
			selenium.clickAt(lnkTopMenu, "");
			selenium.focus(lnkTopMenu);
			selenium.fireEvent(lnkTopMenu, "keypress");
			selenium.keyPress(lnkTopMenu, "\\13");
			click(selenium,"//div[5]/div/div");
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMySetting),"Could not click my setting link;More Detaila:"+roleData.toString(),selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-9: Edit My Setting//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPracticeAndRoles),"Could not click link;More Details:"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEdit),"Could not click edit Button;More details:"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkCheckBox),"Could not click radio button;More Details:"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click save button;More Details:"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnErrorClose)){
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnErrorClose),"Could not click error close button"+roleData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnCancl),"Could not click cancel button;More Details:"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-10:Logout and login as the created us//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnBackButton),"Could not click the back button;More Details:"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			selenium.focus(lnkTopMenu);
			assertTrue(click(selenium,lnkTopMenu),"Could not click top mean header;More Details:"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignout),"Could not click the sign out link;More Details:"+roleData.toString(),selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnYesButton),"Could not click yes button;More Details"+roleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, roleData.userName1, roleData.userPassword1),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11:Verifying Enter details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoreValue(selenium,roleData)){
				Assert.fail("Role is not saved properly; More Details :"+ roleData.toString());
				return false;
			}else
				return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	public boolean verifyStoreValue(Selenium selenium,HomeLib roleData ) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,lnkTopMenu).trim().contains(roleData.switchRole.trim()),"could not get text",selenium,ClassName,MethodName);
		return true;
	}
}
