package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyInActiveAndActiveProgramGroup extends AbstractSchedulingTest{
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verifying InActive And Active Group")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyInActiveAndActiveProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_006";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyInActive_ActiveGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify InActive_Active Group
	* @action 		  verify InActive_Active Group
	* @expected       To Ensure that the InActive_Active Groupworks fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 21, 2013
	***************************************************************************************************/
	public boolean verifyInActive_ActiveGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData) throws Exception{
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
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
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
			//  Step-6: Verify Inactive Reocrd			  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,chkIncludeInactiveCheckboxNPR),"Could not click the check box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtSearchProgram,pDGData.groupName),"Could not type the Program name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.keyPress(txtSearchProgram, "\\13");
			waitForPageLoad(selenium);

			assertTrue(selenium.isTextPresent("Inactive"),"Inactive is  not present",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkProgramAction),"Could not click the Action",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: InActivate to Activate 		  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkGroupActivate),"Could not click the Activate",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnYesButton),"Could not click the Yes button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isChecked(selenium,chkIncludeInactiveCheckboxNPR)){
				assertTrue(click(selenium,chkIncludeInactiveCheckboxNPR),"Could not click the check box",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(type(selenium,txtSearchProgram,pDGData.groupName),"Could not type the Program name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.keyPress(txtSearchProgram, "\\13");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkProgramAction),"Could not click the Action",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Activate Details 		  //
			//--------------------------------------------------------------------//
			if(!isElementPresent(selenium,lnkGroupActivate)){
				returnValue = true;
			}else
				Assert.fail("Activate button is getting displayed");
		
			if(isElementPresent(selenium,lnkGroupEdit)){
				returnValue = true;
			}else
				Assert.fail("View Serious and Edit button is getting displayed");
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
