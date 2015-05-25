package com.nexia.selenium.testscripts.section.demographics.patientTimeLine;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionPatientTimeLine extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With View Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientTimeLineWithViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib PatientTimeLineData = new SchedulingTestLib();
		PatientTimeLineData.workSheetName = "VerifySecurityOption";
		PatientTimeLineData.testCaseId = "TC_VSP_002";
		PatientTimeLineData.fetchSchedulingTestData();
		verifySecurityForViewOnly(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientTimeLineData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientTimeLineWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib PatientTimeLineData = new SchedulingTestLib();
		PatientTimeLineData.workSheetName = "VerifySecurityOption";
		PatientTimeLineData.testCaseId = "TC_VSP_003";
		PatientTimeLineData.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientTimeLineData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientTimeLineWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib PatientTimeLineData = new SchedulingTestLib();
		PatientTimeLineData.workSheetName = "VerifySecurityOption";
		PatientTimeLineData.testCaseId = "TC_VSP_004";
		PatientTimeLineData.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientTimeLineData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Security details in PatientTimeLine
	* @action 		  verify Security details PatientTimeLine
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 24, 2013
	***************************************************************************************************/
	public boolean verifySecurity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib PatientTimeLineData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + PatientTimeLineData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, PatientTimeLineData.userName, PatientTimeLineData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,PatientTimeLineData.switchRole),"Could not change the switch role;More Details:"+PatientTimeLineData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify the security details//
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,PatientTimeLineData,userAccount)){
				fail("Security for" +PatientTimeLineData.switchRole+ "is not proper:"+ PatientTimeLineData.toString());
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + PatientTimeLineData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium, SchedulingTestLib PatientTimeLineData,String userAccount) throws IOException{
		boolean returnValue=false;
		
		//No Access
		if(PatientTimeLineData.testCaseId.equals("TC_VSP_003")){
			
			searchPatientNexiaNoAccess(selenium,PatientTimeLineData.patientId);
			waitForPageLoad(selenium);
			/*assertTrue(goToTimeLine(selenium),"Could not navigate the time line", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String patientTimeLine = selenium.getAttribute("//a[@id='!patientTimelineVisits']/@class");
			System.out.println(patientTimeLine);
			if( (patientTimeLine).contains("extralight")){
				returnValue = true;
			}else
			return false;*/
			return true;
		}
		
		//Full Access
		
		if(PatientTimeLineData.testCaseId.equals("TC_VSP_004")){
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Register Patient//
			//--------------------------------------------------------------------//
			assertTrue(goToRegisterPatient(selenium),"Could not navigate to Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create New Patient//
			//--------------------------------------------------------------------//
			SchedulingTestLib patientTimeLineData = new SchedulingTestLib();
			patientTimeLineData.workSheetName = "NewPatientCheckIn";
			patientTimeLineData.testCaseId = "TC_NPC_002";
			patientTimeLineData.fetchSchedulingTestData();	
			
			assertTrue(createNewPatientWithMandatory(selenium,patientTimeLineData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String patientId = getText(selenium,lblPtientId);
			waitForPageLoad(selenium);


			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Booking Assistant//
			//--------------------------------------------------------------------//
			assertTrue(goToCalender(selenium),"Could not navigate to Booking Assistant", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: select slot//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkBookingAssistant),"Could not click the Booking Assistant",selenium , ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxVisitType,patientTimeLineData.visitType ),"Could not select the visit type ", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			String pName = getText(selenium,lblProvider);
			String providerName = pName.replaceAll("Dr. ", "");
			String LocationName = getText(selenium,lblLocation);
			
			if(isElementPresent(selenium, lnkMore)){
				assertTrue(click(selenium,lnkMore),"Could not click the More Option",selenium , ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,imgCalenderSlot),"Could not click the slot",selenium , ClassName,MethodName);
				waitForPageLoad(selenium);
			}else{
				System.out.println("Create new slot");
				return true;
			}
			
			//Search Created Patient
			assertTrue(type(selenium,txtPatientSearch,patientId),"Could not type the patient name",selenium, ClassName,MethodName);
			selenium.keyPress(txtPatientSearch, "\\9");
			waitForPageLoad(selenium);
			click(selenium,lblPatient);
			
			assertTrue(click(selenium,btnBookSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step- 7: Search Created Patient//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8 : Navigate to Patient time Line 						  //
			//--------------------------------------------------------------------//
			assertTrue(goToTimeLine(selenium),"Could not navigate the time line", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9 : Verify the Patient time line 					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPatientTimeLine),"Could not click the time line", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyPatientTimeLine(selenium,patientTimeLineData,providerName , LocationName)){
				Assert.fail("Details not saved properly");
			}else{
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	
	
	/*************************************************************************************************** 
	* @purpose        To verify Security For ViewOnly in PatientTimeLine
	* @action 		  verify Security For View Only PatientTimeLine
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 24, 2013
	***************************************************************************************************/
	public boolean verifySecurityForViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib PatientTimeLineData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue = false;
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + PatientTimeLineData.toString());
		assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, PatientTimeLineData.userName, PatientTimeLineData.userPassword),"Login Failed", selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-1: Switch Role//
		//--------------------------------------------------------------------//
		PatientTimeLineData.workSheetName = "VerifySecurityOption";
		PatientTimeLineData.testCaseId = "TC_VSP_004";
		PatientTimeLineData.fetchSchedulingTestData();
		
		assertTrue(switchRole(selenium,PatientTimeLineData.switchRole),"Could not change the switch role;More Details:"+PatientTimeLineData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-2: Navigate to Register Patient//
		//--------------------------------------------------------------------//
		assertTrue(goToRegisterPatient(selenium),"Could not navigate to Register Patient", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3: Create New Patient//
		//--------------------------------------------------------------------//
		SchedulingTestLib patientTimeLineData = new SchedulingTestLib();
		patientTimeLineData.workSheetName = "NewPatientCheckIn";
		patientTimeLineData.testCaseId = "TC_NPC_002";
		patientTimeLineData.fetchSchedulingTestData();	
		
		assertTrue(createNewPatientWithMandatory(selenium,patientTimeLineData),"Patient Checkin Failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		String patientId = getText(selenium,lblPtientId);
		waitForPageLoad(selenium);


		//--------------------------------------------------------------------//
		//  Step-4: Navigate to Booking Assistant//
		//--------------------------------------------------------------------//
		assertTrue(goToCalender(selenium),"Could not navigate to Booking Assistant", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-5: select slot//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkBookingAssistant),"Could not click the Booking Assistant",selenium , ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selectValueFromAjaxList(selenium,ajxVisitType,patientTimeLineData.visitType ),"Could not select the visit type ", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium, lnkMore)){
			assertTrue(click(selenium,lnkMore),"Could not click the More Option",selenium , ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,imgCalenderSlot),"Could not click the slot",selenium , ClassName,MethodName);
			waitForPageLoad(selenium);
		}else{
			System.out.println("Create new slot");
			return true;
		}
		
		//Search Created Patient
		assertTrue(type(selenium,txtPatientSearch,patientId),"Could not type the patient name",selenium, ClassName,MethodName);
		selenium.keyPress(txtPatientSearch, "\\9");
		waitForPageLoad(selenium);
		click(selenium,lblPatient);
		
		assertTrue(click(selenium,btnBookSave),"Could not click the save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-6: Switch View only Role//
		//--------------------------------------------------------------------//
		
		PatientTimeLineData.workSheetName = "VerifySecurityOption";
		PatientTimeLineData.testCaseId = "TC_VSP_002";
		PatientTimeLineData.fetchSchedulingTestData();
		
		assertTrue(switchRole(selenium,PatientTimeLineData.switchRole),"Could not change the switch role;More Details:"+PatientTimeLineData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step- 7: Search Created Patient//
		//--------------------------------------------------------------------//
		searchPatientNexiaForProviderHomePage(selenium,patientId);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-8 : Navigate to Patient time Line 						  //
		//--------------------------------------------------------------------//
		assertTrue(goToTimeLine(selenium),"Could not navigate the time line", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-9 : Verify the Patient time line 					  //
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkPatientTimeLine),"Could not click the time line", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium,lnkAction)){
			returnValue = true;
		}
		
		assertTrue(click(selenium,lnkAction),"Could not click the Action link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(selenium.isTextPresent("Confirm Visit")&&selenium.isTextPresent("Reschedule Visit")&& selenium.isTextPresent("Cancel Visit") && selenium.isTextPresent("Edit Visit")){
			Assert.fail("Action option value is present");
		}else{
			returnValue = true;
		}
		return returnValue;
		
	}
	
}
