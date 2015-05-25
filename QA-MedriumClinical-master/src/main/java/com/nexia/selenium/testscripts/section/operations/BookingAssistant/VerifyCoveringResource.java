package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCoveringResource extends AbstractOperationsTest {
	
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "Verify Covering Resource ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCoveringResource(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_006";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCoveringResource(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "verifyFourthcalenderPopUp")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFourthcalenderPopUp(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_007";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFourthcalenderPopUp(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	
	
  /**     
  * @purpose          VerifyCoveringResource 
  *  @action          Verify Covering Resource 
  *  @expected        Verify Covering Resource 
  *  @author          Aspire QA
  *  @state           Developing
  *  @useraccount     Both
  * @since  	      July 01, 2013
  * 
  */


	public boolean verifyCoveringResource(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData) throws Exception{
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
			//  Step-2: Create  Resource Calender //
			//--------------------------------------------------------------------//
			if(!createResourceForCalenderView(selenium,bookingAssistTestData,userAccount)){
				Assert.fail("create Resource for Calender View Failed");
			} 
			
     		//--------------------------------------------------------------------//
			//  Step-3: Navigate to Calender View //
			//--------------------------------------------------------------------//
						
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,lnkOperationsCalender),"Could not click operations Calender link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,txtSearchResources,bookingAssistTestData.resource),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
	 		//--------------------------------------------------------------------//
			//  Step-4: Covering Resource //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkActions),"Could not click actions", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAssignCoveringResource),"Could not click assigh covering resource", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBox,bookingAssistTestData.resource1),"Could not select the resource "+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,chkBlkcoverDaycheckbox),"Could not click Cover day", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkBlkSelectedResourcecheckbox),"Could not click Block Selected Resource checkbox", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkBlkCoveringResourcecheckbox),"Could not click Block Covering Resource checkbox", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkAdd),"Could not ADD button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSave),"Could not save button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if (!getText(selenium,"//td/div/div/div[3]/div").contains(bookingAssistTestData.resourceName1)){
				
				Assert.fail("Verify Covering Resource failed ");
			}
			
			
		}	
			catch (RuntimeException e){
				
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
				
			}
			return returnValue;
		
		}	

	public boolean verifyFourthcalenderPopUp(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData) throws Exception{
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
			//  Step-2: Navigate to Calender View //
			//--------------------------------------------------------------------//
						
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkOperationsCalender),"Could not click operations Calender link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
     		//--------------------------------------------------------------------//
			//  Step-2: Verify four Month //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkDate),"Could not click Date", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
			if(!isElementPresent(selenium,lnkFourMonth)){
				return false;
			}
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		}
		return returnValue;
	}	
	
	/**
	* createResourceForCalenderView
	* createResourceForCalenderView
	 * @throws IOException 
	* @since July 02, 2013
	*/ 
		
	public boolean createResourceForCalenderView(Selenium selenium,OperationsTestLib bookingAssistTestData, String userAccount) throws IOException {
		
		//--------------------------------------------------------------------//
		//  Step-1: Navigate to  Resource Calender //
		//--------------------------------------------------------------------//
	
		assertTrue(goToScheduling(selenium),"Could not click the link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-2: Delete all Resource Calender //
		//--------------------------------------------------------------------//
	  	
		assertTrue(deleteAllResourceCalendar(selenium),"Deletion failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
		//--------------------------------------------------------------------//
		//  Step-3: create Resource Calender//
		//--------------------------------------------------------------------//
		
		if(checkInactiveResource(selenium,bookingAssistTestData,userAccount)){
			
			System.out.println("NO need to Create the new resource");
		}else{
	    		System.out.println("Create the new resource");
	    		assertTrue(createResourceCalender(selenium, bookingAssistTestData,userAccount), "Create Resource Calender With Mandatory Fields failed", selenium, ClassName, MethodName);
	    		waitForPageLoad(selenium);
	    		if(bookingAssistTestData.testCaseId.equals("TC_SBA_006")){
	    			assertTrue(createResourceCalender(selenium, bookingAssistTestData,userAccount), "Create Resource Calender With Mandatory Fields failed", selenium, ClassName, MethodName);
	    			waitForPageLoad(selenium);
	    		}
		}
		 return true;

	}
}
