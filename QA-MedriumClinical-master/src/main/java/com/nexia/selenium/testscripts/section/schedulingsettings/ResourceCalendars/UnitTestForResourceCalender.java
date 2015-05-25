package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceCalendars;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingUnitTestLib;
import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForResourceCalender extends AbstractSchedulingTest{
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "SearchResourceWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchResourceWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_001";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CycleWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCycleWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_002";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CycleWithDecimal")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCycleWithDecimal(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_003";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CycleWithSpecialCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCycleWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_004";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CycleWithCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCycleWithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_005";
		resourceCalTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EffectiveDateWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEffectiveDateWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_006";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EffectiveDateWithSpecialCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEffectiveDateWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_007";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EffectiveDateWithCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEffectiveDateWithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_008";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EffectiveDateWithNumeral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEffectiveDateWithNumeral(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_009";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EndDateWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_010";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EndDateWithNumeral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithNumeral(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_011";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EndDateWithSpecialCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_012";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EndDateWithCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_013";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyEndDateWithPastDate")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithPastDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_014";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyPatternStartsDateWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatternStartsDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_015";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyPatternStartsDateWithCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatternStartsDateWithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_016";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyPatternStartsMonthWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatternStartsMonthWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_017";
		resourceCalTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyPatternStartsMonthWithNumber")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatternStartsMonthWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_018";
		resourceCalTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyPatternEndDateWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyPatternEndDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingUnitTestLib resourceCalTestData = new  SchedulingUnitTestLib();
		resourceCalTestData.workSheetName = "UnitTest_ResourceCalender";
		resourceCalTestData.testCaseId = "TC_RC_019";
		resourceCalTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    resourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceCalTestData);
	}
	
	/**
	  * @purpose        resourceCalenderUnitTest
      * @action         perform unit test on addnew resourcecalender section
      * @author         Aspire QA                                                   
      * @state          Developing
      * @useraccount    Both
	  * @since  	    Jun 06, 2013
	*/
	
	public boolean resourceCalender(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingUnitTestLib resourceCalTestData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = true;
		
		try{
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + resourceCalTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, resourceCalTestData.userName, resourceCalTestData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to SchedulingSettings //
			//--------------------------------------------------------------------//
			
			assertTrue(goToScheduling(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Add New ResourceCalender //
			//--------------------------------------------------------------------//

            assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(addResourceCalUnitTest(selenium, resourceCalTestData,userAccount), "Unit test failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in Add ResourceCalender //
			//--------------------------------------------------------------------//
			
			resourceCalTestData.validationFieldID = resourceCalTestData.validationFieldID == null ? resourceCalTestData.validationFieldID ="" : resourceCalTestData.validationFieldID.trim();
			if(!resourceCalTestData.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium, resourceCalTestData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium, resourceCalTestData.validationFieldID).contains(resourceCalTestData.validationMessage), "The expected validation message should contain the text - "+ resourceCalTestData.validationMessage + " The actual validation message shown - " + getText(selenium, resourceCalTestData.validationFieldID),selenium, ClassName, MethodName);
			}
		}
		catch  (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + resourceCalTestData.toString(),selenium,ClassName,MethodName);
			
		}
		
		return returnValue;
		
	}
	
	
	

}
