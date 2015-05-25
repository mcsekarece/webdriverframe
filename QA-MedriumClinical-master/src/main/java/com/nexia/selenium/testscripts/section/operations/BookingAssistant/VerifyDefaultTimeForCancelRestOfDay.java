package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultTimeForCancelRestOfDay extends AbstractOperationsTest {
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "verify Default Time for Cancel Rest of day ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultTimeForCancelRestOfDay(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_007";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
	    ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDefaultTimeForCancelRestOfDay(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	
	  /**     
	  * @purpose          VerifyDefaultTimeForCancelRestOfDay
	  *  @action          To  Verify DefaultTime For Cancel RestOfDay
	  *  @expected         VerifyDefaultTimeForCancelRestOfDay
	  *  @author          Aspire QA
	  *  @state           Developing
	  *  @useraccount     Both
	  * @since  	       Aug 16, 2013
	  * 
	  */
	
	
	public boolean verifyDefaultTimeForCancelRestOfDay(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData) throws Exception{
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
			//  Step-4: Cancel Rest of Day //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkActions),"Could not click actions", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkCancelRestOfDay),"Could not click  cancel rest of day", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-5: Verify the default Time //
			//--------------------------------------------------------------------//
	      
			    String Time = null;
			    Calendar cal = Calendar.getInstance();
		    	SimpleDateFormat TimeFormat = new SimpleDateFormat("hh:mm:ss aa");
		    	Time = TimeFormat.format(cal.getTime());
		        System.out.println(Time);
		    	
		        String CurrentTime[] = Time.split(":");
		               
		    	String FormatAMorPM[] = Time.split(" ");
		    		    
		        if (!getValue(selenium,txtStartTime).contains(CurrentTime[0])){
					Assert.fail("Verify Default hour failed ");
				}
		      
		       if (!getValue(selenium,txtStartMin).contains(CurrentTime[1])){
					Assert.fail("Verify Default min  failed ");
				}

		       if (!getValue(selenium,txtStartFormat).contains(FormatAMorPM[1])){
			     	Assert.fail("Verify Default format failed ");
				}
				
			
		}	
			catch (RuntimeException e){
				
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
				
			}
			return returnValue;
		
		}
	
	/**
	* createResourceForCalenderViews
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
