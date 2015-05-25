package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class AddResourceInCalender extends AbstractOperationsTest{

	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "SearchResourceInCalender")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchResourceInCalender(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_005";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "AddResourceInCalender")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addResourceInCalender(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_006";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	/**     
	  * @purpose      SearchResourceInCalender 
 *  @action          searchResourceInCalender through booking assistant
 *  @expected        searchResourceInCalender through booking assistant
 *  @author         Aspire QA
 *  @state          Developing
 *  @useraccount    Both
	  * @since  	    July 01, 2013
	  * 
	  */


public boolean CalenderView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData) throws Exception{
	Selenium selenium = null;

	boolean returnValue= true;
	try{
		
		//--------------------------------------------------------------------//
		// Step 1:Login to the application//
		//--------------------------------------------------------------------//
		
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + bookingAssistTestData.toString());
		
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, bookingAssistTestData.userName, bookingAssistTestData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-2: Create  Resource Calender //
		//--------------------------------------------------------------------//
		
		if(!createResourceForCalenderView(selenium,bookingAssistTestData,userAccount)){
			Assert.fail("create Resource for Calender View Failed");
		} 
		
		/*if(bookingAssistTestData.testCaseId.equals("TC_SBA_006")){
	
			if(!createResourceForCalenderView(selenium,bookingAssistTestData,userAccount)){
				Assert.fail("create Resource for Calender View Failed");
			} 
		}
		*/
		//--------------------------------------------------------------------//
		//  Step-2: Navigate to BookingAssistant //
		//--------------------------------------------------------------------//
		
		assertTrue(goToOperations(selenium),"Could not click the Operations link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-3: Navigate to Calender View //
		//--------------------------------------------------------------------//
		
		assertTrue(click(selenium,lnkOperationsCalender),"Could not click operations Calender link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-4: Search Resource Calender View//
		//--------------------------------------------------------------------//
	     
		assertTrue(selectValueFromAjaxList(selenium,txtSearchResources,bookingAssistTestData.resource),"Could not select resource type"+bookingAssistTestData.toString(),selenium,ClassName,MethodName);
	
		waitForPageLoad(selenium);
		//assertTrue(click(selenium,lnkSearch),"Could not click search link", selenium, ClassName,MethodName);
		//waitForPageLoad(selenium);
		if(bookingAssistTestData.testCaseId.equals("TC_SBA_006")){
		
		assertTrue(click(selenium,lnkAddResources),"Could not click AddResources  link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selectValueFromAjaxList(selenium,txtAddResources,bookingAssistTestData.resource1),"Could not select resource1 type"+bookingAssistTestData.toString(),selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,chkProvider),"Could not click check box",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnAdd),"Could not click Add button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		}
		
		if(!verifyValue(selenium,bookingAssistTestData)){
			Assert.fail("The VerifyValues are not correct");
		} 
		
	}			
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		}
		return returnValue;
	}
	


	public boolean createResourceForCalenderView(Selenium selenium,OperationsTestLib bookingAssistTestData, String userAccount) throws Exception{
	
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

	public boolean verifyValue(Selenium selenium,OperationsTestLib bookingAssistTestData){
	  
 	
		if(bookingAssistTestData.testCaseId.equals("TC_SBA_006")){
			if(!getText(selenium,VfyResource1).contains(bookingAssistTestData.resourceName1)){
				return false;
			}
			if(!getText(selenium,VfyResource).contains(bookingAssistTestData.resourceName)){
				return false;
			}}else{
				 if(!getText(selenium,VfyCalenderView).contains(bookingAssistTestData.resourceName)){
					 return false;
					} 
			}
		
		
		return true;
	}
}
