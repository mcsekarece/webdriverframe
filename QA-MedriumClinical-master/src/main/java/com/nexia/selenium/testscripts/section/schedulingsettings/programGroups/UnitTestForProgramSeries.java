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

public class UnitTestForProgramSeries extends AbstractSchedulingTest{
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Series with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeriesWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_005";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "GroupSizeWithCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGroupSizeWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_006";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 

	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "GroupSizeWithInvaildData")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGroupSizeWithInvaildData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_007";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 

	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "StartDateWithInCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithInCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_008";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "StartDateWithInVaildFormat")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithInVaildFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_009";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "HoursWithInValid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHoursWithInValid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_010";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EveryDay With InValid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEveryDayWithInValid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_011";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Day of Month Is Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDayOfMonthIsEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_012";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Month Qualifier is empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMonthQualifieIsempty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_013";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "day Selection Is empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifydaySelectionIsempty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_014";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Occurrence With Less then 2")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOccurrenceWithLessthen2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_015";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Occurrence With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOccurrenceWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_016";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "End Date With Charcter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithCharcter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_017";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "End Date With InValid Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithInValidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_018";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Duration With Less Then 5 min")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithLessThen5min(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_019";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Duration With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_020";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Individual Start Date With InValid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIndividualStartDateWithInValid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_021";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Individual Start Date With InValid format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIndividualStartDateWithInValidformat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_022";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "IndividualDurationWithLessThen5")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIndividualDurationWithLessThen5(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_023";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "IndividualDurationWithcharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIndividualDurationWithCharatcer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_024";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "IndividualDurationWithdecimal")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIndividualDurationWithdecimal(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_025";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "DurationWithdecimalValue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithdecimalValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ScheduleSeries";
		pDGAdminTestData.testCaseId = "TC_SS_026";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestScheduleSeries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 
	
	/*************************************************************************************************** 
	* @purpose        To verify unitTest_Program Series
	* @action 		  verify unitTest_Program Series
	* @expected       To Ensure that the unit Test_Program Series works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES /   
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 28, 2013
	***************************************************************************************************/
	
	public boolean unitTestScheduleSeries(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingUnitTestLib pDGAdminTestData) throws Exception{
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
			//  Step-2: Navigate to SchedulingSettings //
			//--------------------------------------------------------------------//
			
			assertTrue(goToScheduling(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkProgramGroup),"Could not click Resource Calender link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Progarm Group //
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
			//  Step-4: Create Progarm Group //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in Add ResourceCalender //
			//--------------------------------------------------------------------//
			 assertTrue(unitTestForScheduleSeries(selenium, pDGAdminTestData), "Unit test failed", selenium, ClassName, MethodName);
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



