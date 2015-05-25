package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteProgramGroup extends AbstractSchedulingTest{
	
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verifying Delete Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteProgramAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_002";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verifying delete Program With Schedule Series")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteProgramWithScheduleSeries(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_012";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To delete Program
	* @action 		  verify delete Program
	* @expected       To Ensure that the delete Program works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 21, 2013
	***************************************************************************************************/
	public boolean deleteProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pDGData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pDGData.userName, pDGData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pDGData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Progarm Group						  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not navigate to Calender Setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Program Group					  //
			//--------------------------------------------------------------------//
			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData),"Could not delete Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-4: Verify Program Type Details						  //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxProgramType,pDGData.programType);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			if(pDGData.testCaseId.equals("TC_PDG_012")){
				
				//--------------------------------------------------------------------//
				//  Step-6: Create Schedule Series				  //
				//--------------------------------------------------------------------//
				
				String providerNameTemp= getText(selenium, lnkTopMenu);
				String providerName= providerNameTemp.replaceAll( ", "+pDGData.switchRole, "");
				
				String location = getText(selenium,lnkLocationHeader).replace("...", "") ;
				
				SchedulingTestLib pDGScheduleSeriesData = new SchedulingTestLib();
				pDGScheduleSeriesData.workSheetName = "ScheduleSeries";
				pDGScheduleSeriesData.testCaseId = "TC_SS_002";
				pDGScheduleSeriesData.fetchSchedulingTestData();
				
				assertTrue(createScheduleSerieswithPersonalType(selenium,pDGScheduleSeriesData,uniqueName,providerName, location,userAccount),"Could not Create Schedule Series", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-7: Create Staff			  //
				//--------------------------------------------------------------------//
				
				SchedulingTestLib pDGCreateStaffData = new SchedulingTestLib();
				pDGCreateStaffData.workSheetName = "ScheduleSeries";
				pDGCreateStaffData.testCaseId = "TC_SS_002";
				pDGCreateStaffData.fetchSchedulingTestData();
				
				assertTrue(click(selenium,btnAddStaff),"Could not click add new button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(addStaff(selenium,pDGCreateStaffData,providerName),"Could not Create Staff", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
								
				assertTrue(click(selenium,btnSeriesNext),"Could not click next button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnDone),"Could not click done button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
			}
			
			//--------------------------------------------------------------------//
			//  Step-5:Delete Created Program					  //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtSearchProgram,pDGData.groupName),"Could not type the Program name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.keyPress(txtSearchProgram, "\\13");
			waitForPageLoad(selenium);
			
			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData),"Could not delete Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Rocord is present or not				  //
			//--------------------------------------------------------------------//
			
			if(selenium.isVisible(txtSearchProgram))
			{
			assertTrue(type(selenium,txtSearchProgram,pDGData.groupName),"Could not type the Program name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtSearchProgram, "\\13");
			waitForPageLoad(selenium);
			if(!selenium.isTextPresent(pDGData.groupName+uniqueName)){
				return true;
			}else{
				Assert.fail("Details are getting displayed.");
			}
			}
			else 
			{
				if(!selenium.isTextPresent(pDGData.groupName+uniqueName)){
					return true;
				}else{
					Assert.fail("Details are getting displayed.");
				}
				
			}
			
			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
