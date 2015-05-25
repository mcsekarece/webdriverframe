package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForProgramGroups extends AbstractSchedulingTest{
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Program with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProgramWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_001";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 

	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Group with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGroupWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_002";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 

	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Group with Max 50 character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGroupWithMax50(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_003";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	} 

	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Description With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDescriptionWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_004";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Description with Max 500 character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDescriptionWithMax500(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_005";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Group Object With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGroupObjectWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_006";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Plan With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPlanWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_007";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Plan Activities With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPlanActivities(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_008";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Age Group With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifAgeGroupWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_009";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Gender With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGenderWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_010";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Primary Language With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrimaryLanguageWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_011";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Culture With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCultureWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_012";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Role With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRoleWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_013";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Physical or Menteal Condition With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhysicalOrMentealConditionWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_014";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Social Demo With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySocialDemoWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib pDGAdminTestData = new  SchedulingUnitTestLib();
		pDGAdminTestData.workSheetName = "UnitTest_ProgramGroup";
		pDGAdminTestData.testCaseId = "TC_PDG_015";
		pDGAdminTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    unitTestProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGAdminTestData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify unitTest_ProgramGroup
	* @action 		  verify unitTest_ProgramGroup
	* @expected       To Ensure that the unitTest_ProgramGroup Pop Up works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES /   
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 16, 2013
	***************************************************************************************************/
	
	public boolean unitTestProgramGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingUnitTestLib pDGAdminTestData) throws Exception{
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
			//  Step-3: Add Progarm Group //
			//--------------------------------------------------------------------//

            assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxProgramType,pDGAdminTestData.programType);
			
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in Add ResourceCalender //
			//--------------------------------------------------------------------//
			 assertTrue(unitTestForPDGAdmin(selenium, pDGAdminTestData), "Unit test failed", selenium, ClassName, MethodName);
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
