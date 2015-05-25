package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForBookingAssistant extends AbstractOperationsTest {
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyBookingAssistantWithNoAccess")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBookingAssistantWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "VerifySecurityOption";
		bookingAssistTestData.testCaseId = "TC_VSP_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}

	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyBookingAssistantWithFullAccess")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBookingAssistantWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "VerifySecurityOption";
		bookingAssistTestData.testCaseId = "TC_VSP_002";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyBookingAssistantWithViewOnlyAccess")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBookingAssistantWithViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "VerifySecurityOption";
		bookingAssistTestData.testCaseId = "TC_VSP_003";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyBookingAssistantWithLimitedAccess")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBookingAssistantWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "VerifySecurityOption";
		bookingAssistTestData.testCaseId = "TC_VSP_004";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Booking Assistant
	* @action 		  verifying Security Option For Booking Assistant
	* @expected       To Ensure that security option works fine for Booking Assistant     
	* @author         Jagmit Singh
	 * @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 18, 2013
	***************************************************************************************************/


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
		//  Step-2: Switch Role//
		//--------------------------------------------------------------------//
	
		assertTrue(switchRole(selenium,bookingAssistTestData.switchRole),"Could not change the switch role;More Details:"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		//-----------------------------------------//
		//  Step-3: Verify Security//
		//--------------------------------------------------------------------//
		if(!verifySecurity(selenium,bookingAssistTestData,userAccount)){
			Assert.fail("Security for" +bookingAssistTestData.switchRole+ "is not proper:"+ bookingAssistTestData.toString());
		}else
			return returnValue;
		
	}			
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		}
		return returnValue;
}	

public boolean verifySecurity(Selenium selenium, OperationsTestLib bookingAssistTestData,String userAccount) throws Exception{
	boolean returnValue=true;
	
	//No Access
	if(bookingAssistTestData.testCaseId.equals("TC_VSP_001")){
		
	//--------------------------------------------------------------------//
	//   Navigate to Quick Actions                                     //
	//--------------------------------------------------------------------//		
		assertTrue(goToQuickActionNoAccess(selenium),"Could not Navigate to Quick Actions - No Access", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);				
	}

			
	//Full Access	
	if(bookingAssistTestData.testCaseId.equals("TC_VSP_002")){
		
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
				
	    //--------------------------------------------------------------------//
		//   Navigate to BookingAssistant //
		//--------------------------------------------------------------------//
		
		    assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
		
		    assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
		    
		    assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
		
		  //---------------------------------------------------------- ---------//
		  //   Select the required slot                                  // 
		  //--------------------------------------------------------------------//
		
		   if(!selectRequiredSlot(selenium,bookingAssistTestData)){
			   Assert.fail("Could not select required slot");
		   }
		   
		   //--------------------------------------------------------------------//
		   //   Advanced search with Patient ID//
		   //--------------------------------------------------------------------//
			
		    assertTrue( searchPatientForBookingVisit(selenium,bookingAssistTestData.patientName),"Search patient failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//   Visit Details//
			//--------------------------------------------------------------------//
			assertTrue(visitDetials(selenium,bookingAssistTestData), "Visit details failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

			}
	
	    //View Only Access
		if(bookingAssistTestData.testCaseId.equals("TC_VSP_003")){			
		//--------------------------------------------------------------------//
		//   Navigate to Calendar View                                       //
		//--------------------------------------------------------------------//			
		 assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
		 waitForPageLoad(selenium);
		 
		 assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
		 assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
			
		 assertTrue(!selenium.isTextPresent("Booking Assistant"),"Booking Assistant is Present",selenium, ClassName, MethodName);
				
		}
		
		//Limited Access
		if(bookingAssistTestData.testCaseId.equals("TC_VSP_004")){			
		//--------------------------------------------------------------------//
		//   Navigate to Calendar View                                       //
		//--------------------------------------------------------------------//			
		assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);		
		
		assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link", selenium, ClassName,MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
		assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
						
		}
	
	
	return returnValue;
}		
}