package com.nexia.selenium.testscripts.section.operations.CheckinAssistant;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForCheckinAssistant extends AbstractOperationsTest {
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "VerifyBookingAssistantWithNoAccess")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBookingAssistantWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib checkInAssistantTestData = new  OperationsTestLib();
		checkInAssistantTestData.workSheetName = "VerifyCheckInAssistant";
		checkInAssistantTestData.testCaseId = "TC_VCA_001";
		checkInAssistantTestData.fetchSchedulingSettingsTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CheckinAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,checkInAssistantTestData);
	}

	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "VerifyBookingAssistantWithFullAccess")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBookingAssistantWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib checkInAssistantTestData = new  OperationsTestLib();
		checkInAssistantTestData.workSheetName = "VerifyCheckInAssistant";
		checkInAssistantTestData.testCaseId = "TC_VCA_002";
		checkInAssistantTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CheckinAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,checkInAssistantTestData);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "VerifyBookingAssistantWithViewOnlyAccess")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBookingAssistantWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib checkInAssistantTestData = new  OperationsTestLib();
		checkInAssistantTestData.workSheetName = "VerifyCheckInAssistant";
		checkInAssistantTestData.testCaseId = "TC_VCA_003";
		checkInAssistantTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CheckinAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,checkInAssistantTestData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For CheckIn Assistant
	* @action 		  verifying Security Option For CheckIn Assistant
	* @expected       To Ensure that security option works fine for CheckinAssistant     
	* @author         Jagmit Singh
	 * @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 18, 2013
	***************************************************************************************************/


public boolean CheckinAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib checkInAssistantTestData) throws Exception{
	Selenium selenium = null;
	boolean returnValue= true;
	try{
		
		//--------------------------------------------------------------------//
		// Step 1:Login to the application//
		//--------------------------------------------------------------------//
		
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + checkInAssistantTestData.toString());
		
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, checkInAssistantTestData.userName, checkInAssistantTestData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-2: Switch Role//
		//--------------------------------------------------------------------//
	
		assertTrue(switchRole(selenium,checkInAssistantTestData.switchRole),"Could not change the switch role;More Details:"+checkInAssistantTestData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		//-----------------------------------------//
		//  Step-3: Verify Security//
		//--------------------------------------------------------------------//
		if(!verifySecurity(selenium,checkInAssistantTestData,userAccount)){
			Assert.fail("Security for" +checkInAssistantTestData.switchRole+ "is not proper:"+ checkInAssistantTestData.toString());
		}else
			return returnValue;
		
	}			
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + checkInAssistantTestData.toString(), selenium, ClassName,MethodName);
		}
		return returnValue;
}	

public boolean verifySecurity(Selenium selenium, OperationsTestLib checkInAssistantTestData,String userAccount) throws Exception{
	boolean returnValue=true;
	
	//No Access Permission
	if(checkInAssistantTestData.testCaseId.equals("TC_VSP_001")){
		
		assertTrue(goToQuickActionNoAccess(selenium),"Could not Navigate to Quick Actions", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
	}
	
	//Full Access Permission	
	if(checkInAssistantTestData.testCaseId.equals("TC_VSP_002")){
		
		
		
		checkInAssistantTestData.workSheetName = "SearchBookingAssistant";
		checkInAssistantTestData.testCaseId = "TC_SBA_001";
		checkInAssistantTestData.fetchSchedulingSettingsTestData();	
		
		
	 	//--------------------------------------------------------------------//
		//   Navigate to CheckinAssistant 									  //
		//--------------------------------------------------------------------//
		
		assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkCalenderPreferences),"Could not click  Calender Preferences link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		
		assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
		assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
		
		  //---------------------------------------------------------- ---------//
		  //   Select the required slot                                  // 
		  //--------------------------------------------------------------------//
		
		   if(!selectRequiredSlot(selenium,checkInAssistantTestData)){
			   Assert.fail("Could not select required slot");
		   }
		   
		   //--------------------------------------------------------------------//
		   //   Advanced search with Patient ID//
		   //--------------------------------------------------------------------//
			
		    assertTrue( searchPatientForBookingVisit(selenium,checkInAssistantTestData.patientName),"Search patient failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//   Visit Details//
			//--------------------------------------------------------------------//
			assertTrue(visitDetials(selenium,checkInAssistantTestData), "Visit details failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

	}
	
	//View Only Access Permission
	 if(checkInAssistantTestData.testCaseId.equals("TC_VSP_003")){
			
		 	assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkCalenderPreferences),"Could not click  Calender Preferences link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
		}
	
	return returnValue;
}
		
}