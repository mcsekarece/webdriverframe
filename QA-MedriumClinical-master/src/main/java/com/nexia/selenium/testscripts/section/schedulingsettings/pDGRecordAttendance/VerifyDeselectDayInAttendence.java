package com.nexia.selenium.testscripts.section.schedulingsettings.pDGRecordAttendance;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeselectDayInAttendence extends AbstractSchedulingTest {
    @Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For verify update eparticipants in Attendance Group")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUpdateParticipantsInAttendanceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	    SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
	    pdgSeriesData.workSheetName = "ProgramAddSeries";
	    pdgSeriesData.testCaseId = "TC_PAS_002";
	    pdgSeriesData.fetchSchedulingTestData();
	    ClassName=this.getClass().getName().substring(39);	
	    MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    createProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify update participants in Attendance Group
	* @action 		  verify update participants in Attendance Group
	* @expected       To Ensure that the update participants in Attendance Group
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Nov 04, 2013
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
			
			assertTrue( selectValueFromAjaxList(selenium,ajxProgramType,pDGData.programType),
						"Not able to select program type ", selenium, ClassName, MethodName);		
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Add New Series											  //
			//--------------------------------------------------------------------//
			assertTrue(addNewSeries(selenium,pdgSeriesData),"Could not Create series", selenium, ClassName, MethodName);
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
			//  Step-9: Click First record in attendance group participants		  //
			//--------------------------------------------------------------------//
			/*assertTrue(click(selenium,lnkFirstRecordAttendance),"Could not click the first record in attendance group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Click update participants button			 			  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnUpdateParticipant),"could not click update participants button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-11: Select the patient name in patient search		  		  //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtPatientSearch,pdgSeriesData.patientName),"Could not type patient name", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtPatientSearch, "\\9");
			waitForElement(selenium,lblPatientResult,10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with name :-"+pdgSeriesData.patientName, selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),
					"Not able to find text " +pdgSeriesData.patientName ,selenium, ClassName, MethodName);
			
			selenium.mouseOver(lblPatientResult);
			waitForPageLoad(selenium);
			
			selenium.click(lblPatientResult);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkUpdateParticipantDaySelection),"could not click link Update Participant Day Selection", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isChecked(selenium,chk1)){
			    assertTrue(click(selenium,chk1),"could not click Monday check box", selenium, ClassName, MethodName);
			}
			if(isChecked(selenium,chk2)){
			    assertTrue(click(selenium,chk2),"could not click Tuesday check box", selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium,btnCloseSelection),"could not click Close Selection", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lblSelectionAlert), "The validation message field did not appear",selenium, ClassName, MethodName);//US
			assertTrue(getText(selenium, lblSelectionAlert).contains("Day selection cannot be empty"), "The expected validation message not found",selenium, ClassName, MethodName);
			
		}
			catch(RuntimeException e){	
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	}

			