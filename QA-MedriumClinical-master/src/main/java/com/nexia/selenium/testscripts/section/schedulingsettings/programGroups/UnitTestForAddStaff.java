package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForAddStaff extends AbstractSchedulingTest{
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Role with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRoleWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_001";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestAddStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Role with InValid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRoleWithInValid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_002";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestAddStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFirstNameWithInValid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_003";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestAddStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLastNameWithInValid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_004";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestAddStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	/*************************************************************************************************** 
	* @purpose        To verify unitTest_AddStaff
	* @action 		  verify unitTest_Program Series
	* @expected       To Ensure that the unit Test_Program Series works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES /   
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 16, 2013
	***************************************************************************************************/
	
	public boolean unitTestAddStaff(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingUnitTestLib pDGAdminTestData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = true;
		
		try{
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pDGAdminTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pDGAdminTestData.userName, pDGAdminTestData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pDGAdminTestData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to SchedulingSettings //
			//--------------------------------------------------------------------//
			
			assertTrue(goToScheduling(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkProgramGroup),"Could not click Resource Calender link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Progarm Group //
			//--------------------------------------------------------------------//

			SchedulingTestLib pDGData = new SchedulingTestLib();
			pDGData.workSheetName = "ProgramGroupAdmin";
			pDGData.testCaseId = "TC_PDG_009";
			pDGData.fetchSchedulingTestData();
			
			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData),"Could not delete Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			selectValueFromAjaxList(selenium,ajxProgramType,pDGData.programType);

			//--------------------------------------------------------------------//
			//  Step-5: Create Schedule Series //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create  Schedule series", selenium, ClassName, MethodName);		waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Create Schedule seires //
			//--------------------------------------------------------------------//
			pDGData.workSheetName = "ScheduleSeries";
			pDGData.testCaseId = "TC_SS_007";
			pDGData.fetchSchedulingTestData();

			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll( ", "+pDGData.switchRole, "");
			
			String location = getText(selenium,lnkLocationHeader) ;
			
			assertTrue(createScheduleSerieswithPersonalType(selenium,pDGData,uniqueName,providerName, location,userAccount),"Could not Create Schedule Series", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			// step 7:perform unit test for various fields in Add ResourceCalender //
			//--------------------------------------------------------------------//
			assertTrue(unitTestForAddStaff(selenium,pDGAdminTestData),"Add Staff", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			pDGAdminTestData.validationFieldID = pDGAdminTestData.validationFieldID == null ? pDGAdminTestData.validationFieldID ="" : pDGAdminTestData.validationFieldID.trim();
			if(!pDGAdminTestData.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium, pDGAdminTestData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium, pDGAdminTestData.validationFieldID).contains(pDGAdminTestData.validationMessage), "The expected validation message should contain the text - "+ pDGAdminTestData.validationMessage + " The actual validation message shown - " + getText(selenium, pDGAdminTestData.validationFieldID),selenium, ClassName, MethodName);
			}
		}
		catch  (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pDGAdminTestData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
}
