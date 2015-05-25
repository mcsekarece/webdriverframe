package com.nexia.selenium.testscripts.section.demographics.patientSearch;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityForBookAppoinment extends AbstractOperationsTest {
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyBookingAssistantWithNoAccess")
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

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyBookingAssistantWithFullAccess")
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
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyBookingAssistantWithViewOnlyAccess")
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
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyBookingAssistantWithLimitedAccess")
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

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyWaitListWithFullAccess")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWaitListWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "VerifySecurityOption";
		bookingAssistTestData.testCaseId = "TC_VSP_005";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyWaitListWithFullAccess")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientChartWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "VerifySecurityOption";
		bookingAssistTestData.testCaseId = "TC_VSP_006";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Booking Assistant
	* @action 	  verifying Security Option For Booking Assistant
	* @expected       To Ensure that security option works fine for Booking Assistant     
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	  October 16, 2013
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
		
		//No Access User Role	
		if(bookingAssistTestData.testCaseId.equals("TC_VSP_001")){
			
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			assertTrue(searchPatientNexiaNoAccess(selenium,"Mathewaa"),"Could search patient", selenium, ClassName, MethodName);				
		}	
		
		//--------------------------------------------------------------------//
		//  Step-2: Navigate Book Appointment									 //
		//--------------------------------------------------------------------//
		
		if(!bookingAssistTestData.testCaseId.equals("TC_VSP_001")){
		    	try{
		    	    assertTrue(type(selenium,txtPatientBox,"Mathewaa"),"Could not type patient id",selenium,ClassName,MethodName);
			}catch(Exception e){
			    assertTrue(type(selenium,txtPatientBox,"Mathewaa"),"Could not type patient id",selenium,ClassName,MethodName);
			}
			selenium.clickAt("searchPatientBox","");
			selenium.focus("searchPatientBox");			
			selenium.fireEvent("searchPatientBox","keypress");	
			selenium.keyPress(txtPatientBox, "\\9");
			waitForElement(selenium,lblPatientResult,10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+bookingAssistTestData.patientID,selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains("Mathewaa".trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium,ClassName,MethodName);
			//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
			waitForPageLoad(selenium);
				
			selenium.mouseOver(lblPatientResult);
			waitForPageLoad(selenium);
				
			//if(getText(selenium,lblPatientAction).contains("Patient Actions")){
				    
			if(bookingAssistTestData.testCaseId.equals("TC_VSP_006")){
			    assertTrue(click(selenium,lnkViewChart),"Could not click book appointment link", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    
			    if(!isElementPresent(selenium,lnkTimeLine)){
				Assert.fail("Navigation failed");
			    }
			    else{
				return true;
			    }
			    
			}
			if(!isElementPresent(selenium, lnkBookAppont)){
				Assert.fail("book appointment link present");
			}
			
				
			assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
		}		
		
		//--------------------------------------------------------------------//
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
		
	    //Full Access	
	    if(bookingAssistTestData.testCaseId.equals("TC_VSP_002")){
		
			bookingAssistTestData.workSheetName = "SearchBookingAssistant";
			bookingAssistTestData.testCaseId = "TC_SBA_001";
			bookingAssistTestData.fetchSchedulingSettingsTestData();	
					
			//--------------------------------------------------------------------//
			//   Navigate to BookingAssistant //
			//--------------------------------------------------------------------//   
			assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
		
			//---------------------------------------------------------- ---------//
			//   Select the required slot                                  // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkBookAppont),"Could not click book appointment link", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			
			
		    assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationVisitType,bookingAssistTestData.visitType),"Could not select Visit type"+bookingAssistTestData.toString(),selenium,ClassName,MethodName);
		    waitForPageLoad(selenium);
		   
			
			if(!isElementPresent(selenium,vfyRequiredSlot)){
			    System.out.println("No slot available");
			    return true;
			}
	
			
			return true;
	     }
	    	
	    if(bookingAssistTestData.testCaseId.equals("TC_VSP_005")){
	    	
	    	OperationsTestLib bookingAssistTestData1 = new  OperationsTestLib();
			bookingAssistTestData1.workSheetName = "SearchBookingAssistant";
			bookingAssistTestData1.testCaseId = "TC_SBA_001";
			bookingAssistTestData1.fetchSchedulingSettingsTestData();	
					
			//--------------------------------------------------------------------//
			//   Navigate to BookingAssistant //
			//--------------------------------------------------------------------//   
		    assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
		    assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
			
		    //---------------------------------------------------------- ---------//
			//   Select the required slot                                  // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkBookAppont),"Could not click book appointment link", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			
			
		    assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationVisitType,bookingAssistTestData.visitType),"Could not select Visit type"+bookingAssistTestData.toString(),selenium,ClassName,MethodName);
		    waitForPageLoad(selenium);
		   
			
			if(!isElementPresent(selenium,vfyRequiredSlot)){
			    System.out.println("No slot available");
			    return true;
			}
	
			
			return true;
		}
	
	    //View Only Access
	
	    if(bookingAssistTestData.testCaseId.equals("TC_VSP_003")){					
		 
			 assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
			 assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
				
			 assertTrue(!selenium.isTextPresent("Booking Assistant"),"Booking Assistant is Present",selenium, ClassName, MethodName);
					
		}
		
		//Limited Access
		
		if(bookingAssistTestData.testCaseId.equals("TC_VSP_004")){			
	
		    	assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
							
		}
		
		
		return returnValue;
	}		
}