package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsUnitTestlib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForBookingAssistant extends AbstractOperationsTest{
	

	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyDurationWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyDurationWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_002";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyDurationWithMaximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_003";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyStartDateWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_004";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyStartDateWithCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_005";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyStartDateWithSpecialCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_006";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyStartDateWithNumerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithSpecialNumerals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_007";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyEndDateWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyEndDateWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_008";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyEndDateWithCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyEndDateWithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_009";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyEndDateWithSpecialCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyEndDateWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_010";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyEndDateWithNumerals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithNumerals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_011";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyStartDateWithPastDate")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithPastDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_012";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyEndDateWithPastDate")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithPastDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_013";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyStartDateWithInvalidFormat")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartDateWithInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_014";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyEndDateWithInvalidFormat")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDateWithInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_015";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyDurationWithSpecialCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDurationWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_BookingAssistant";
		bookingAssistTestData.testCaseId = "TC_UBA_016";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	/**
	  * @purpose       BookingAssistant
     * @action         perform unit test on booking Assistant
     * @author         Aspire QA                                                   
     * @state          Developing
     * @useraccount    Both
	  * @since  	    Jun 20, 2013
	*/
	
	public boolean bookingAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsUnitTestlib bookingAssistTestData) throws Exception {
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
			assertTrue(switchRole(selenium,bookingAssistTestData.switchRole),"switchrole filed",selenium, ClassName,MethodName);
 			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to BookingAssistant //
			//--------------------------------------------------------------------//
			
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: BookingAssistant UnitTest   //
			//--------------------------------------------------------------------//
			
			assertTrue(bookingAssistantUnitTest(selenium, bookingAssistTestData,userAccount), "Unit test failed", selenium, ClassName,MethodName);
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
