package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancel extends AbstractOperationsTest {

	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCancelInBookVisit")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelInBookVisit(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_002";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}

	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCancelVisitDetails")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelVisitDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_003";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}

	/**     
	  * @purpose      Verify Cancel In BookingAssistant
   *  @action         Verify Cancel In BookingAssistant
   *  @expected       Verify Cancel In BookingAssistant
   *  @author         Aspire QA
   *  @state          Developing
   *  @useraccount    Both
	  * @since  	    Jun 27, 2013
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
		//  Step-3: Select the required slot                                       // 
		//--------------------------------------------------------------------//
		
	  
	   if(!selectRequiredSlot(selenium,bookingAssistTestData)){
		   Assert.fail("Could not select required slot");
	   }
	   
	   if(bookingAssistTestData.testCaseId.equals("TC_SBA_002")){
	 
	     assertTrue(click(selenium,btnCancel),"Could not click cancel button ", selenium, ClassName,MethodName);
	     waitForPageLoad(selenium);
	   
	   if(!selenium.isElementPresent(lnkBookingAssistant)){
			Assert.fail("The cancel button not working");
		}
		
	   }
		//--------------------------------------------------------------------//
		//  Step-4: Advanced search with Patient ID//
		//--------------------------------------------------------------------//
		
	   if(bookingAssistTestData.testCaseId.equals("TC_SBA_003")){
	   	assertTrue( searchPatientForBookingVisit(selenium,bookingAssistTestData.patientName),"Search patient failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnCancel),"Could not click cancel button ", selenium, ClassName,MethodName);
	    waitForPageLoad(selenium);
		   
		   if(!selenium.isElementPresent(txtpatientsearch)){
				Assert.fail("The cancel button not working");
			}
	   }	
		
    
	}			
		catch (RuntimeException e){
			
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			
		}
		return returnValue;
	}
	
	
	public boolean selectRequiredSlot(Selenium selenium,OperationsTestLib bookingAssistTestData) throws IOException{
		
		
		assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationVisitType,bookingAssistTestData.visitType),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);

		assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationResource,bookingAssistTestData.resource),"Could not select resource type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selectValueFromAjaxList(selenium,ajxLocation,bookingAssistTestData.location),"Could not select location type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(getText(selenium,vfyRequiredSlot).toLowerCase(new java.util.Locale("en","Us")).trim().contains(bookingAssistTestData.resourceName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			assertTrue(click(selenium,vfyRequiredSlot),"Could not click  required slot link",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		 }else{
			 return false;
		 }
		if(!selenium.isElementPresent(txtpatientsearch)){
			return false;
		}
		return true;
		
	}
}
