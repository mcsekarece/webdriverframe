package com.nexia.selenium.testscripts.section.demographics.patientTimeLine;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddEditAndUpdateUserDetailsInCommentField extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test For Verifying Visit Type Details in Patient Time Line ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addCommentInCommentFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib patientTimeLineData = new SchedulingTestLib();
		patientTimeLineData.workSheetName = "PatientTimeLine";
		patientTimeLineData.testCaseId = "TC_PTL_003";
		patientTimeLineData.fetchSchedulingTestData();	
	    verifyAddEditComment(seleniumHost, seleniumPort, browser, webSite, userAccount, patientTimeLineData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test For Verifying Resource Details in Patient Time Line ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editCommentInCommentFiled(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib patientTimeLineData = new SchedulingTestLib();
		patientTimeLineData.workSheetName = "PatientTimeLine";
		patientTimeLineData.testCaseId = "TC_PTL_004";
		patientTimeLineData.fetchSchedulingTestData();	
		verifyAddEditComment(seleniumHost, seleniumPort, browser, webSite, userAccount, patientTimeLineData);
	} 
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test For Verifying Resource Details in Patient Time Line ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void commentWitMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib patientTimeLineData = new SchedulingTestLib();
		patientTimeLineData.workSheetName = "PatientTimeLine";
		patientTimeLineData.testCaseId = "TC_PTL_005";
		patientTimeLineData.fetchSchedulingTestData();	
		verifyAddEditComment(seleniumHost, seleniumPort, browser, webSite, userAccount, patientTimeLineData);
	} 
	/*************************************************************************************************** 
	* @purpose        To verify Add Edit Comment
	* @action 		  verify Add Edit Comment
	* @expected       To Ensure that the verify Add Edit Comment works fine    
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 26, 2013
	***************************************************************************************************/


	public boolean verifyAddEditComment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib patientTimeLineData) throws Exception{
		
		boolean returnValue = false;
		Selenium selenium = null;
		String time = null;
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
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
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
			//  Step-9 : Enter the comments				  //
			//--------------------------------------------------------------------//
			
			
			assertTrue(click(selenium,lblPatientTimeLine),"Could not click the time line details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExpandDetails),"Could not click the time line details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkHideComment),"Could not click the Hide Comment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("hh");
			time =DateFormat.format(cal.getTime());
			
			assertTrue(click(selenium,imgCommentTextPopUp),"Could not click the Comment popup", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtTLComment,patientTimeLineData.comments),"Could not type the patient name",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!patientTimeLineData.testCaseId.equals("TC_PTL_006")){
			assertTrue(click(selenium,btnDfSave),"Could not click the Default save button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-10 : Edit comments				  //
			//--------------------------------------------------------------------//
			if(patientTimeLineData.testCaseId.equals("TC_PTL_004")){
				
				patientTimeLineData.workSheetName = "PatientTimeLine";
				patientTimeLineData.testCaseId = "TC_PTL_003";
				patientTimeLineData.fetchSchedulingTestData();
				
				assertTrue(click(selenium,btnDfEdit),"Could not click the edit  button ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				SimpleDateFormat DateFormat1=new SimpleDateFormat("hh");
				time =DateFormat1.format(cal.getTime());
				
				assertTrue(type(selenium,txtTLComment,patientTimeLineData.comments),"Could not type the patient name",selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnDfSave),"Could not click the Default save button ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
			}
	
			//--------------------------------------------------------------------//
			//  Step-10 : Verify Comment details			  //
			//--------------------------------------------------------------------//
			
			if(patientTimeLineData.testCaseId.equals("TC_PTL_006")){
				if(getValue(selenium,txtTLComment).contains(patientTimeLineData.comments)){
					returnValue = false;
				}
			}
			
			if(patientTimeLineData.testCaseId.equals("TC_PTL_004")||patientTimeLineData.testCaseId.equals("TC_PTL_005")){
				if(!verifyCommentDetails(selenium,patientTimeLineData,time)){
					Assert.fail("Details not saved properly");
				}else{
					returnValue = true;
				}
			}
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyCommentDetails(Selenium selenium,SchedulingTestLib patientTimeLineData, String time) throws IOException{
		
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String providerName= providerNameTemp.replaceAll(","+patientTimeLineData.switchRole , "");
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MMMM dd, yyyy");
		String date=DateFormat.format(cal.getTime());
		
		assertTrue(!getText(selenium,lblComment).contains(providerName),"Verification failed", selenium, ClassName, MethodName);
		assertTrue(!getText(selenium,lblComment).contains(date),"Verification failed", selenium, ClassName, MethodName);
		assertTrue(!getText(selenium,lblComment).contains(time),"Verification failed", selenium, ClassName, MethodName);
		assertTrue(!getText(selenium,lblComment).contains(patientTimeLineData.comments),"Verification failed", selenium, ClassName, MethodName);
		
		return true;
	}
}
