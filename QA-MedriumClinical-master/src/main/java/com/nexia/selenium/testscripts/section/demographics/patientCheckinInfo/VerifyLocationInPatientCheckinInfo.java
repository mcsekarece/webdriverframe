package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyLocationInPatientCheckinInfo extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify the created location in patient checkin info")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLocationInPatientCheckinInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest practiceData = new SystemsSettingsUnitTest();
		practiceData.workSheetName = "UnitTest_SS_Practice";
		practiceData.testCaseId = "TC_SSPRAC_036";
		practiceData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocation(seleniumHost, seleniumPort, browser, webSite, userAccount, practiceData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify created location in patient checkin info
	* @action 		  Verifying created location in patient checkin info
	* @expected       After created location for the practice, patient checkin info should displays the added location in location dropdown
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 03, 2013
	***************************************************************************************************/
	public boolean verifyLocation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest practiceData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + practiceData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, practiceData.userName, practiceData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Provider //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			String practiceName1= getText(selenium, lblPracticeName);
			String practiceName=practiceName1.replaceAll("[.]", "");
			System.out.println(practiceName);
			
			assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			  if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose) ,"Could not click close button", selenium, ClassName, MethodName);

			assertTrue(click(selenium,lnkSystemSetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Search Practice//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(searchPractice(selenium,practiceName),"Could not click on System settings link:" + practiceData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!(getText(selenium, lblResultPractice).contains(practiceData.billingLocationName))){
				assertTrue(click(selenium, btnEdit1), "Could not click edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnNextFromPractice),"Could not click Next button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddNewPractice),"Could not click Add new button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				assertTrue(addLocation(selenium,practiceData,userAccount),"Location adding for practice failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, lnkQuickActions), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click on register patient link:" + practiceData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,ajxPrimaryLocation),"Could not click on register patient link:" + practiceData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			if(!(getText(selenium, ajkPopupBox).contains(practiceData.billingLocationName))){
				returnValue=false;
			}	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
