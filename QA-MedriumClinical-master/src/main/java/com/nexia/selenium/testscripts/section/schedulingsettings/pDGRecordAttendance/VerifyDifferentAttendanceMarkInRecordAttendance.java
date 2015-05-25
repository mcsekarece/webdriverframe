package com.nexia.selenium.testscripts.section.schedulingsettings.pDGRecordAttendance;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDifferentAttendanceMarkInRecordAttendance extends AbstractSchedulingTest{
	
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For verify Different Attendance Mark in record attendance")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDifferentAttendanceMarkInRecordAttendance(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		
		SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
	    pdgSeriesData.workSheetName = "ProgramAddSeries";
	    pdgSeriesData.testCaseId = "TC_PAS_002";
	    pdgSeriesData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify Different Attendance Mark in record attendance
	* @action 		  verify Different Attendance Mark in record attendance
	* @expected       To Ensure that Different Attendance Mark in record attendance
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Nov 05, 2013
	***************************************************************************************************/
	public boolean createProgramGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pdgSeriesData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pdgSeriesData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pdgSeriesData.userName, pdgSeriesData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pdgSeriesData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Program Group						 		  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not navigate to Calender Setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Program Group					 				  //
			//--------------------------------------------------------------------//
			assertTrue(deleteProgramForPDGAdmin(selenium,pdgSeriesData),"Could not delete Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-5: Create Program					 						  //
			//--------------------------------------------------------------------//
			SchedulingTestLib pDGData = new SchedulingTestLib();
			pDGData.workSheetName = "ProgramGroupAdmin";
			pDGData.testCaseId = "TC_PDG_010";
			pDGData.fetchSchedulingTestData();
			
			selectValueFromAjaxList(selenium,ajxProgramType,pDGData.programType);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Add New Series											  //
			//--------------------------------------------------------------------//
			assertTrue(addNewSeriesForAttendanceGroup(selenium,pdgSeriesData,userAccount),"Could not Create series", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Added Series										  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnSeriesAction),"Could not click Action ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkViewAllSeries),"Could not click View Series ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoredValuesForSeriesInSummary(selenium,pdgSeriesData),"Could not verify the Created series in the summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Navigate To record attendance							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToRecordAttendance(selenium, pdgSeriesData, pDGData),"Could not navigate to record attendance section", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: verify Created Program group in record attendance		  //
			//--------------------------------------------------------------------//
			/*assertTrue(verifyStoredValuesForRecordAttendanceSummary(selenium,pdgSeriesData, pDGData),"Could not verify the Created series in record attendance", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Click First record in attendance group participants	  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkFirstRecordAttendance),"Could not click the first record in attendance group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			assertTrue(click(selenium,lnkNextWeek),"Could not click the next week link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: Different Attendance Mark in attendance group			  //
			//--------------------------------------------------------------------//
			//verfy not applicable attendance mark
			if(!selenium.getAttribute(lblAttenSundayFirstRecordGroupParticipantName+"@class").equalsIgnoreCase("attendance-record-na")){
				return false;
			}
			
			//verify present attendance mark
			if(!selenium.getAttribute(lblAttenMondayFirstRecordGroupParticipantName+"@class").equalsIgnoreCase("attendance-record-present")){
				return false;
			}

			assertTrue(click(selenium,lblAttenMondayFirstRecordGroupParticipantName),"Could not click the first participant attendance in attendance group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isChecked(selenium, chkCenterClosedMonday)){
				assertTrue(click(selenium,chkCenterClosedMonday),"Could not check the reason for absent", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium,lnkSaveMondayAttendanceAbsent),"Could not save the reason for absent", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.mouseOver(lblAttenMondayFirstRecordGroupParticipantName);
			
			//verify absend attendance mark
			if(!selenium.getAttribute(lblAttenMondayFirstRecordGroupParticipantName+"@class").equalsIgnoreCase("attendance-record-absent")){
				return false;
			}
			
			assertTrue(click(selenium,lblAttenMondayFirstRecordGroupParticipantName),"Could not click the first participant attendance in attendance group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//verify '0' state attendance mark
			if(!selenium.getAttribute(lblAttenMondayFirstRecordGroupParticipantName+"@class").equalsIgnoreCase("attendance-record-void")){
				return false;
			}
			
			
			//to verify all the monday's for this series checked
			for(int count=1; count<=2; count++){
				if(!selenium.getAttribute(lblAttenMondayFirstRecordGroupParticipantName+"@class").equalsIgnoreCase("attendance-record-present")){
					return false;
				}
				
				assertTrue(click(selenium,lnkNextWeek),"Could not click the next week link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
