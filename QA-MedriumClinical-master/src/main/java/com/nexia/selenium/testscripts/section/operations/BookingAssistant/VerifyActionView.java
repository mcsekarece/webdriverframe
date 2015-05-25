package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyActionView extends AbstractOperationsTest{
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyActionMenu(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_007";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		actionView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verifying Action menu in the calender
	* @action 		  verifying Action menu in the calender
	* @expected       To Ensure that the delete new calendar functionality to working fine    
	* @author         Aspire QA
	* @state          Developing
	* @defect 		  #4313	
	* @useraccount    Both
	* @since  	      Aug 08, 2013
	***************************************************************************************************/
	
	public boolean actionView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData) throws Exception{
		Selenium selenium = null;
		String date = null;
		boolean returnValue= true;
		try{
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + bookingAssistTestData.toString());
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, bookingAssistTestData.userName, bookingAssistTestData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Calender //
			//--------------------------------------------------------------------//
				
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkOperationsCalender),"Could not click Resource Calender link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,lnkActions)){
				Assert.fail("The Action menu is not present");
			}else
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
