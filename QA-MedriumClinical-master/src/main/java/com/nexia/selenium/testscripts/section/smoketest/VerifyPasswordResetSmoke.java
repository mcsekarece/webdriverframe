package com.nexia.selenium.testscripts.section.smoketest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.smoketest.SmokeTestLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;

import com.thoughtworks.selenium.Selenium;

public class VerifyPasswordResetSmoke extends AbstractSmokeTest {
	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting an User")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyForcePasswordResetForUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SmokeTestLib pwdData = new SmokeTestLib();		
		pwdData.workSheetName = "ForcePasswordReset";
		pwdData.testCaseId = "TC_PR_001";
		pwdData.fetchSmokeTestData();		
		verifyPasswordReset(seleniumHost, seleniumPort, browser, webSite, userAccount, pwdData);
	
	}
	
	/**
	 * verifyPasswordReset
	 * function to verify Force Password Reset
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @since  	    August 13, 2012
	 */
	public boolean verifyPasswordReset(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SmokeTestLib pwdData) throws Exception{
		
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pwdData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pwdData.userName, pwdData.userPassword),"Login Failed ",selenium,MethodName,ClassName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pwdData.switchRole),"selection failed",selenium,MethodName,ClassName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to User                //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(gotoSystemSetting(selenium),"selection failed",selenium,MethodName,ClassName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-3: Search for a patient//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			String countUser = getText(selenium,"//div[5]/div/div/div/div/span/span");
			String[] splitStr1 = countUser.split("[(^)]");
			int numerator1=Integer.parseInt(splitStr1[1]);
			waitForPageLoad(selenium);
			int count=1;
			if(numerator1 < 10){
			    while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td/div/div")){
				
				if(!getText(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td/div/div").toLowerCase(new java.util.Locale("en","US")).trim().contains("apple")){
				    count++;
				}
				else{
				    click(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td/div/div");
				    waitForPageLoad(selenium);
				    break;
				}
				
				if(count>15){
				    break;
				}
			    }
			    
			    
			}
			else{
				assertTrue(type(selenium,txtUserSearch,pwdData.userName1),"could not type", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnUserSearch),"Could not click on search button:" + pwdData .toString(),selenium,MethodName,ClassName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium,lbldescription)){
				
assertTrue(click(selenium,"includeInactiveUserscheckbox"),"Could not click on include Inactive Users checkbox:" + pwdData .toString(),selenium,MethodName,ClassName);
				assertTrue(isElementPresent(selenium,lbldescription), ""+ "Could not find the user", selenium, ClassName,MethodName);
				assertTrue(click(selenium,"ActivateUserAAAPPLE"),"Could not click on activate button:" + pwdData .toString(),selenium,MethodName,ClassName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lbldescription),"Could not click on user link:" + pwdData .toString(),selenium,MethodName,ClassName);
				waitForPageLoad(selenium);
			}else{
				assertTrue(click(selenium,lbldescription),"Could not click on user link:" + pwdData .toString(),selenium,MethodName,ClassName);
				waitForPageLoad(selenium);
				}
			}
			//--------------------------------------------------------------------//
			//  Step-4:Reset Password for the selected user//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not click on edit button:" + pwdData .toString(),selenium,MethodName,ClassName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("mm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			selectValueFromAjaxList(selenium,"externalEmrsuggestBox",pwdData.externalEmr);
			waitForPageLoad(selenium);
			click(selenium,"resetPasswordcheckbox");
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"password",pwdData.password1+uniqueName+"a"),"Could not type password" + pwdData .toString(),selenium,MethodName,ClassName);
			assertTrue(type(selenium,"confirmPassword",pwdData.password1+uniqueName+"a"),"Could not type confirmation password" + pwdData .toString(),selenium,MethodName,ClassName);
			assertTrue(click(selenium,btnSaveRecallReason),"Could not click on save button:" + pwdData .toString(),selenium,MethodName,ClassName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Logut and login as the created us//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not go to home page" + pwdData .toString(),selenium,MethodName,ClassName);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose)){
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			assertTrue(logoutofApplication(selenium),"Logout Application failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(loginForNexiaToVerifyForcePwdReset(selenium, userAccount, pwdData.userName1, pwdData.password1+uniqueName+"a"),"Login Failed ",selenium,MethodName,ClassName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,"currentPassword",pwdData.password1+uniqueName+"a"),"Could not type password" + pwdData .toString(),selenium,MethodName,ClassName);
			assertTrue(type(selenium,"newPassword",pwdData.password1+uniqueName+"a"),"Could not type confirmation password" + pwdData .toString(),selenium,MethodName,ClassName);
			assertTrue(type(selenium,"confirmNewPassword",pwdData.password1+uniqueName+"a"),"Could not type confirmation password" + pwdData .toString(),selenium,MethodName,ClassName);
			assertTrue(click(selenium,"continueButton"),"Could not click on continue Button" + pwdData .toString(),selenium,MethodName,ClassName);
			waitForPageLoad(selenium);
			
			
		}catch (RuntimeException e){
		e.printStackTrace();
		Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pwdData.toString());
		}
	return returnValue;
	}
}
		

