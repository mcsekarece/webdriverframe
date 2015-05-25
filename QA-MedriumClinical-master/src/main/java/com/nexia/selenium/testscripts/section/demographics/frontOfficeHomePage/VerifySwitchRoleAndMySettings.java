package com.nexia.selenium.testscripts.section.demographics.frontOfficeHomePage;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

	public class VerifySwitchRoleAndMySettings extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying switch Role and My Setings")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySwitchRoleandMySettings(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_014";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying online help")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOnlineHelp(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_001";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify create a New Patient entry
	* @action 		  verifying create a New Patient entry
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 23, 2012
	***************************************************************************************************/
	public boolean createNewPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Verify Switch Role  										  //
			//--------------------------------------------------------------------//
			/*assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			if(patientData.testCaseId.equals("TC_NPC_001")){
			/*if(isElementPresent(selenium,lnkHelp)){
				assertTrue(click(selenium,lnkHelp),"Could not click Help icon;More details :"+ patientData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkHowToUse),"Could not click How to Use;More details :"+ patientData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				String st1[]=selenium.getAllWindowNames();
				waitForPageLoad(selenium);
				switchto(st1[1]);
				selenium.selectWindow(st1[1]);
				selenium.windowFocus();
				if(isElementPresent(selenium,"css=h1")){
				return true;
				}
				else{
					Assert.fail("Navigation Failed");
				}
			}*/
			}
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify View My Settings								  //
			//--------------------------------------------------------------------//
			
		/*	selenium.clickAt(lnkTopMenu, "");
			selenium.focus(lnkTopMenu);
			selenium.fireEvent(lnkTopMenu, "keypress");
			selenium.keyPress(lnkTopMenu, "\\13");
			click(selenium,"//div[5]/div/div");*/
			
			int counter=0;
			while(!isElementPresent(selenium,lnkMySetting)){
				click(selenium,lnkTopMenu);
				
				counter++;
				
				if(counter>10){
					break;
				}
			}
			
			assertTrue(click(selenium,lnkMySetting),"Could not click the My setting link;More details :"+ patientData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnResetPassword),"Could not find the reset Password Link;More details :"+ patientData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnResetPassword),"Could not click the reset Password Link;More details :"+ patientData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,txtCurrentPassword),"Could not find the current Password;More details:"+patientData.toString(),selenium,ClassName,MethodName);
			assertTrue(isElementPresent(selenium,txtNewPassword),"Could not find the new Password;More details:"+patientData.toString(),selenium,ClassName,MethodName);
			assertTrue(isElementPresent(selenium,txtConfirmPassword),"Could not find the new confirm Password;More details:"+patientData.toString(),selenium,ClassName,MethodName);
			
			click(selenium,"cancel");
			waitForPageLoad(selenium);
			
			click(selenium,"yesButton");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkTopMenu),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignout),"Could not click the log out button",selenium,ClassName,MethodName);
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			click(selenium,"link=Yes");
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,txtAccount)){
				Assert.fail("Logout not success");
			}
			
			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	private void switchto(String string) {
		// TODO Auto-generated method stub
		
	}
}
