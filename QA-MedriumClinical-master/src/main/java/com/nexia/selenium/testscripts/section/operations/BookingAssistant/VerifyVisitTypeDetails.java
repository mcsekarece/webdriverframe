package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyVisitTypeDetails  extends AbstractOperationsTest{
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "SearchAppointmentInBookingAssistant")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVisitTypeDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	/**     
	 * @purpose     VerifyVisitTypeDetails
	 *  @action         VerifyVisitTypeDetails
	 *  @expected       VerifyVisitTypeDetails
	 *  @author         Aspire QA
	 *	@defect 		#4317
	 *  @state          Developing
	 *  @useraccount    Both
	 * @since  	    Jun 28, 2013
	 */


public boolean bookingAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData) throws Exception{
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
		//--------------------------------------------------------------------//
		//  Step-4: Advanced search with Patient ID//
		//--------------------------------------------------------------------//
		
	  	assertTrue(searchPatientForBookingVisit(selenium,bookingAssistTestData.patientName),"Search patient failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);

		//--------------------------------------------------------------------//
		//  Step-5: Verify Visit Type Details//
		//--------------------------------------------------------------------//
		if(!verifyVisitTypeDetails(selenium,bookingAssistTestData)){
		
			Assert.fail("The VisitTypeDetails are not stored properly ");
		}
		
	}			
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		}
		return returnValue;
}	
		
		
		public boolean verifyVisitTypeDetails(Selenium selenium,OperationsTestLib bookingAssistTestData){
		
		  System.out.println(selenium.getText(vfyVisitDetails));
			if(!getText(selenium,vfyVisitDetails).contains(bookingAssistTestData.resourceName1)){
				return false;
			}
			if(!getText(selenium,vfyVisitDetails).contains(bookingAssistTestData.visitType)){
				return false;
			}
			if(!getText(selenium,vfyVisitDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(bookingAssistTestData.location.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
	// Verify Instructions		
			if(!getText(selenium,vfyPatientInstructions).contains("Do not get break fast and come on time")){
				return false;
			}
			if(!getText(selenium,vfyBookInstructions).contains("Do not book after 10.00 pm")){
				return false;
			}
			
			
			
			return true;
		}
	}






