package com.nexia.selenium.testscripts.section.operations.CheckinAssistant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.nexia.selenium.genericlibrary.operations.OperationsUnitTestlib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnitTestCheckInAssist extends AbstractOperationsTest{
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "verifyPaymentsWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPaymentsWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib checkInAssistTestData = new  OperationsUnitTestlib();
		checkInAssistTestData.workSheetName = "UnitTest_CheckInAssistant";
		checkInAssistTestData.testCaseId = "TC_UCA_001";
		checkInAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkInAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,checkInAssistTestData);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "verifyPaymentsWithMaximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPaymentsWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib checkInAssistTestData = new  OperationsUnitTestlib();
		checkInAssistTestData.workSheetName = "UnitTest_CheckInAssistant";
		checkInAssistTestData.testCaseId = "TC_UCA_002";
		checkInAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkInAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,checkInAssistTestData);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "verifyAuthorizationWithMaximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAuthorizationWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib checkInAssistTestData = new  OperationsUnitTestlib();
		checkInAssistTestData.workSheetName = "UnitTest_CheckInAssistant";
		checkInAssistTestData.testCaseId = "TC_UCA_003";
		checkInAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkInAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,checkInAssistTestData);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "verifyPaymentsWithNegative")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPaymentsWithNegative(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib checkInAssistTestData = new  OperationsUnitTestlib();
		checkInAssistTestData.workSheetName = "UnitTest_CheckInAssistant";
		checkInAssistTestData.testCaseId = "TC_UCA_004";
		checkInAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkInAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,checkInAssistTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Unit test in Patient CheckIn Assistant
	* @action 		  verifying Unit test in Patient CheckIn Assistant
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 04, 2013
	***************************************************************************************************/
	public boolean checkInAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsUnitTestlib checkInAssistTestData) throws IOException{
		Selenium selenium = null;
		boolean returnValue= true;
		try{
			
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + checkInAssistTestData.toString());
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, checkInAssistTestData.userName, checkInAssistTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to SchedulingSettings //
			//--------------------------------------------------------------------//
			
			assertTrue(goToScheduling(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all Resource Calender //
			//--------------------------------------------------------------------//
                
			assertTrue(deleteAllResourceCalendar(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Add New ResourceCalender //
			//--------------------------------------------------------------------//

			//---------------------------------------------------------------------------------//
			//  Note : In create New ResourceCalender Select Location and Visit type 		   //
			//          Manually in Block calendar area( Not able to automate). Use debug mode // 
			//---------------------------------------------------------------------------------//
            assertTrue(click(selenium,btnAddResCalandar),"Could not click add new button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			
			assertTrue(createPatternForResourceCalenderUnitTest(selenium, checkInAssistTestData,userAccount), "Create pattern for calender failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyStoreValues(selenium,checkInAssistTestData)){
			    Assert.fail("The Pattern Values are not stored properly");
			}
			 
			 
			 
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to BookingAssistant //
			//--------------------------------------------------------------------//
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ---------//
			//  Step-6: Select the required slot                                  // 
			//--------------------------------------------------------------------//
			OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
			bookingAssistTestData.workSheetName = "SearchBookingAssistant";
			bookingAssistTestData.testCaseId = "TC_SBA_015";
			bookingAssistTestData.fetchSchedulingSettingsTestData();	
		/*	
		    if(!selectRequiredSlot(selenium,bookingAssistTestData)){
			   Assert.fail("Could not select required slot");
		    }
		    */
		    assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationVisitType,bookingAssistTestData.visitType),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,vfyRequiredSlot)){
				System.out.println("No required slot is available. Please manually create it");
				return true;
			}
			
			assertTrue(click(selenium,vfyRequiredSlot),"Could not click  required slot link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		    
			//--------------------------------------------------------------------//
			//  Step-7: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
		    searchPatientForBookingVisit(selenium,bookingAssistTestData.patientName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-8: Visit Details//
			//--------------------------------------------------------------------//
			assertTrue(visitDetials(selenium,bookingAssistTestData), "Visit details failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to CheckIn Assistant //
			//--------------------------------------------------------------------//
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkCheckInAssistant),"Could not click Check in assistant link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Select the patient in the CheckIn Assistant //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxResourceList,checkInAssistTestData.resource),"Could not select Visit type"+checkInAssistTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxLocationList,checkInAssistTestData.location),"Could not select Visit type"+checkInAssistTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium, "//div[@id='AppointmentList']/table/tbody/tr/td/div/div/div[2]/div");
			
			click(selenium, lnkCollectPayment);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBox,"Credit"),"Could not select payment type"+checkInAssistTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]","Visa");
			
			if(checkInAssistTestData.testCaseId.equals("TC_UCA_003")){
				String s="sssssssssssssssssssssssssssssssssssssssssssssssssssdsad";
			type(selenium,"authorizationNumber",s);
			if(getText(selenium,"authorizationNumber").equals(s)){
				return false;
			}
			else{
				return true;
			}
			}
			
			if(checkInAssistTestData.testCaseId.equals("TC_UCA_001")){
				
			type(selenium,"totalPayment","add");
			assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBox,"Credit"),"Could not select payment type"+checkInAssistTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			else if(checkInAssistTestData.testCaseId.equals("TC_UCA_002")){
				
				type(selenium,"totalPayment","abcdefghijklumjihjh");
				assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBox,"Credit"),"Could not select payment type"+checkInAssistTestData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else if(checkInAssistTestData.testCaseId.equals("TC_UCA_004")){
				
				type(selenium,"totalPayment","-34");
				waitForPageLoad(selenium);
			}
			assertTrue(isElementPresent(selenium, bookingAssistTestData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, bookingAssistTestData.validationFieldID).contains(checkInAssistTestData.validationMessage), "The expected validation message should contain the text - "+ checkInAssistTestData.validationMessage + " The actual validation message shown - " + getText(selenium, checkInAssistTestData.validationFieldID), selenium, ClassName, MethodName);
			
		}			
		catch (RuntimeException e){
			
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
	
	public boolean  verifyStoreValues(Selenium selenium,OperationsUnitTestlib createResourceCalData){
		 
		  String date =null;
		  Calendar cal=Calendar.getInstance();
		  SimpleDateFormat DateFormat1=new SimpleDateFormat("MMM");
		  date=DateFormat1.format(cal.getTime());
		
		if(!getText(selenium,lblResourceCalendarSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.resource1.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		 }
		
		if(!getText(selenium,lblResourceCalendarSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		 }
		if(!getText(selenium,lblResourceCalendarSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.cycle.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		 }
		
		 return true;
		 
	 }
	
}
