package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;

import com.thoughtworks.selenium.Selenium;

public class SearchAppointmentInBookingAssistant extends AbstractOperationsTest{
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "SearchAppointmentInBookingAssistant")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchAppointmentInBookingAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "SearchAppointmentWithDiffResAndLoc")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchAppointmentWithDiffResAndLoc(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistantWithResAndLoc(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "SearchAppointmentWithVisitTypeOnly")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchAppointmentWithVisitTypeOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_004";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistantWithResAndLoc(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	/**     
	  * @purpose      SearchAppointmentInBookingAssistant
   *  @action         SearchAppointmentInBookingAssistant
   *  @expected      SearchAppointmentInBookingAssistant 
   *  @author         Aspire QA
   *  @state          Developing
   *  @useraccount    Both
	  * @since  	    Jun 25, 2013
	  * 
	  */


public boolean bookingAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData)throws Exception{
	Selenium selenium = null;
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
		//  Step-2: Navigate to BookingAssistant //
		//--------------------------------------------------------------------//
		
		assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		//---------------------------------------------------------- ---------//
		//  Step-3: Select the required slot                                  // 
		//--------------------------------------------------------------------//
		
	   if(!selectRequiredSlot(selenium,bookingAssistTestData)){
		   System.out.println("Select required slot not available: create it manually");
		   return true;
	   }

		//--------------------------------------------------------------------//
		//  Step-4: Advanced search with Patient ID//
		//--------------------------------------------------------------------//
		
	    searchPatientForBookingVisit(selenium,bookingAssistTestData.patientName);
		waitForPageLoad(selenium);

		//--------------------------------------------------------------------//
		//  Step-5: Visit Details//
		//--------------------------------------------------------------------//
		
	    assertTrue(visitDetials(selenium,bookingAssistTestData), "Visit details failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
	}			
		catch (RuntimeException e){
			
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			
		}
		return returnValue;
	}
	
	
	
	
	public boolean bookingAssistantWithResAndLoc(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData) throws Exception{
		Selenium selenium = null;
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
			//  Step-2: Navigate to BookingAssistant //
			//--------------------------------------------------------------------//
			
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ---------//
			//  Step-3: Select the required slot                                       // 
			//--------------------------------------------------------------------//
			
		   if(!selectRequiredSlot(selenium,bookingAssistTestData)){
			   System.out.println("Select required slot not available: create it manually");
			   return true;
		   }
		}			
			catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
				
			}
			return returnValue;
		}
		

}
