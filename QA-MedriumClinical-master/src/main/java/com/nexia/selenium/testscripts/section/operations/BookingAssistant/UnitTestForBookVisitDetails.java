package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsUnitTestlib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForBookVisitDetails extends AbstractOperationsTest{
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyDurationWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}

	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyDurationWithCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_002";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyDurationWithInvalidData")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_003";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyDurationWithMaximumCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithMaximumCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_004";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitDailyOccursWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitDailyOccursWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_005";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}

	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitDailyOccursInvalidData")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitDailyOccursInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_006";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	

	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitDailyOccursWithMaximumCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyRecurringVisitDailyOccursWithMaximumCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_007";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitEndAfterWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitEndAfterWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_008";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitEndAfterWithInvalidData")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitEndAfterWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_009";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitEndAfterWithMaximumCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitEndAfterWithMaximumCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_010";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitEndMonthWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitEndMonthWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_011";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitEndInvalidWithInvalidData")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitEndInvalidWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_012";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitMonthlyDayofMonthWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitMonthlyDayofMonthWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_013";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitMonthlyDayofMonthWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitMonthlyDayofMonthWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_014";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitMonthlyWeekofMonthOccurenceBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitMonthlyWeekofMonthOccurenceBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_015";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitMonthlyWeekofMonthOccurenceInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitMonthlyWeekofMonthOccurenceInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_016";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitMonthlyWeekofMonthDayBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitMonthlyWeekofMonthDayBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_017";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitMonthlyWeekofMonthDayInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitMonthlyWeekofMonthDayInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_018";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitYearlyDayBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitYearlyDayBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_019";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitYearlyDayInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitYearlyDayInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_020";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitYearlyMonthBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyRecurringVisitYearlyMonthBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_021";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringVisitYearlyMonthInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringVisitYearlyMonthInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_022";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringPatientCommentAlertBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringPatientAlertCommentBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_023";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}

	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringPatientStartDateBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringPatientStartDateBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_024";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyRecurringPatientStartDateInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringPatientStartDateInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookVisitDetails";
		bookingAssistTestData.testCaseId = "TC_UBV_025";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	/**
	* @purpose        BookingVisitDetails UnitTest
    * @action         perform unit test on Booking Visit Details 
    * @author         Aspire QA                                                   
    * @state          Developing
    * @useraccount    Both
	  * @since  	    July 02, 2013
	*/
	
	public boolean bookingAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsUnitTestlib bookingAssistTestData)throws Exception {
		Selenium selenium = null;
		boolean returnValue = true;
		try{
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + bookingAssistTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, bookingAssistTestData.userName, bookingAssistTestData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			
		    assertTrue(switchRole(selenium,bookingAssistTestData.switchRole),"Switch role failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to BookingAssistant //
			//--------------------------------------------------------------------//
			
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ---------//
			//  Step-4: Select the required slot                                  // 
			//--------------------------------------------------------------------//
			
			assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationVisitType,bookingAssistTestData.visitType),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,vfyRequiredSlot),"Could not click  required slot link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
		    assertTrue( searchPatientForBookingVisit(selenium,bookingAssistTestData.patientName),"Search patient failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Book Visit Details UnitTest   //
			//--------------------------------------------------------------------//
			
			assertTrue(bookingVisitDetailsUnitTest(selenium, bookingAssistTestData,userAccount), "Unit test failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

			assertTrue(isElementPresent(selenium, bookingAssistTestData.validationFieldID), "The validation message field did not appear", selenium, ClassName,MethodName);
			assertTrue(getText(selenium, bookingAssistTestData.validationFieldID).contains(bookingAssistTestData.validationMessage), "The expected validation message should contain the text - "+ bookingAssistTestData.validationMessage + " The actual validation message shown - " + getText(selenium, bookingAssistTestData.validationFieldID), selenium, ClassName,MethodName);
		
		}
		catch  (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			
		}
		return returnValue;
		}
}
