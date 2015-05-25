package com.nexia.selenium.testscripts.section.demographics.patientTimeLine;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyBumpListRecordInPatientTimeLine  extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test For Verifying Resource Details in Patient Time Line ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithResource(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib patientTimeLineData = new SchedulingTestLib();
		patientTimeLineData.workSheetName = "PatientTimeLine";
		patientTimeLineData.testCaseId = "TC_PTL_002";
		patientTimeLineData.fetchSchedulingTestData();	
	    verifySearchVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, patientTimeLineData);
	} 
	
	/*************************************************************************************************** 
	* @purpose        To verify SearchVisitType
	* @action 		  verify Search Visit Type
	* @expected       To Ensure that the verify Search Visit Type works fine    
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 20, 2013
	***************************************************************************************************/


	public boolean verifySearchVisitType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib patientTimeLineData) throws Exception{
		
		boolean returnValue = false;
		Selenium selenium = null;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientTimeLineData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, patientTimeLineData.userName, patientTimeLineData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Register Patient//
			//--------------------------------------------------------------------//
			assertTrue(goToRegisterPatient(selenium),"Could not navigate to Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create New Patient//
			//--------------------------------------------------------------------//
			
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
			
			//--------------------------------------------------------------------//
			//  Step-6: verify the details//
			//--------------------------------------------------------------------//
			if(!verifyPatientDetails(selenium,patientTimeLineData,providerName , LocationName)){
				Assert.fail("Details not saved properly");
			}
			
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
			}
			
			//--------------------------------------------------------------------//
			//  Step-10 : Cancel the visit type				  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAction),"Could not click the Action link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkCancelVisit),"Could not click the Cancel visit", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtCancelTextArea, "Reason"),"Could not Enter the reason ", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,chkAddBumpList),"Could not click the Action link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCancelVisitSave),"Could not click the save button from cancel visit page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11 :Veridy  Cancel Visit details //
			//--------------------------------------------------------------------//
			
			if(!verifyBumListRecordDetails(selenium,patientTimeLineData,providerName , LocationName)){
				Assert.fail("Details not saved properly");
			}else
				returnValue = true;
			

		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyBumListRecordDetails(Selenium selenium,SchedulingTestLib patientTimeLineData , String providerName, String location) throws IOException{
		assertTrue(click(selenium,lblPatientTimeLine),"Could not click the time line", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,lblExpandPatientTimeLine).contains("To be confirmed"),"could not get text",selenium,ClassName,MethodName);
		
		assertTrue(getText(selenium,lblExpandPatientTimeLine).contains("Bump-Listed"),"could not get text",selenium,ClassName,MethodName);
		return true;
	}
}
