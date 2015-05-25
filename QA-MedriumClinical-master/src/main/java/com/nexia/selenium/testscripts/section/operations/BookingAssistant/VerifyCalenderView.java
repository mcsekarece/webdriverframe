package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCalenderView extends AbstractOperationsTest{
	
	
	/*@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithoutVisitType")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderViewWithoutVisitType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_005";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}

	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderViewWithVisitType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_006";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}*/
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyXmark(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_007";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifycurrentView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_008";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBackView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_009";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDayView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_010";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWeekView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_011";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelResourceAddition(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_012";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	

	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchResourceWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_013";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
		
	}
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyXmarkInSearch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_014";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	

	
  /**     
  * @purpose          VerifyCalenderView 
  *  @action          VerifyCalenderView through booking assistant
  *  @expected        VerifyCalenderView through booking assistant
  *  @author          Aspire QA
  *  @state           Developing
  *  @useraccount     Both
  * @since  	      July 01, 2013
  * 
  */


public boolean CalenderView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData) throws Exception{
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
		//  Step-2: Navigate to BookingAssistant //
		//--------------------------------------------------------------------//
			
		assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(bookingAssistTestData.testCaseId.equals("TC_SBA_006")){
		assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationVisitType,bookingAssistTestData.visitType),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		}

		//--------------------------------------------------------------------//
		//  Step-3: Navigate to Calender View //
		//--------------------------------------------------------------------//
		
		assertTrue(click(selenium,lnkOperationsCalender),"Could not click operations Calender link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-4: Verify Default Calender View //
		//--------------------------------------------------------------------//
	     
		if(bookingAssistTestData.testCaseId.equals("TC_SBA_007")){
			if(isElementPresent(selenium,btnClose)){
				assertTrue(click(selenium,btnClose),"Could not click x link", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				click(selenium,btnClose);
				if(isElementPresent(selenium,lnkActions)){
					Assert.fail("Calendar view not closed properly");
				}
			}
			
			else{
				assertTrue(selectValueFromAjaxList(selenium,txtSearchResources,bookingAssistTestData.resource1),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSearch),"Could not click search link", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnClose),"Could not click x link", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				click(selenium,btnClose);
				if(isElementPresent(selenium,lnkActions)){
					Assert.fail("Calendar view not closed properly");
				}
			}
			
			return true;
		}
		
		if(bookingAssistTestData.testCaseId.equals("TC_SBA_008")){
		     assertTrue(selectValueFromAjaxList(selenium,txtSearchResources,bookingAssistTestData.resource1),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSearch),"Could not click search link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkCurrentView),"Could not click current view link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblCalendarView).contains("My View")){
				return true;
			}
			else{
				Assert.fail("Current View setup failed");
			}
		}
		if(bookingAssistTestData.testCaseId.equals("TC_SBA_009")){
			
			
			assertTrue(selectValueFromAjaxList(selenium,txtSearchResources,bookingAssistTestData.resource1),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSearch),"Could not click search link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkBackView),"Could not click current view link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblCalendarView).contains("My View")){
				return true;
			}
			else{
				Assert.fail("Current View setup failed");
			}
		}
		
		if(bookingAssistTestData.testCaseId.equals("TC_SBA_010")){
			assertTrue(selectValueFromAjaxList(selenium,txtSearchResources,bookingAssistTestData.resource1),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSearch),"Could not click search link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkDay),"Could not click Day view link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lnkAction1)){
				Assert.fail("Day View not displayed properly");
			}
			return true;
		}
		
		if(bookingAssistTestData.testCaseId.equals("TC_SBA_011")){
			assertTrue(selectValueFromAjaxList(selenium,txtSearchResources,bookingAssistTestData.resource1),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSearch),"Could not click search link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkWeek),"Could not click Day view link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,lnkAction1)){
				Assert.fail("Week View not displayed properly");
			}
			return true;
		}
		
		if(bookingAssistTestData.testCaseId.equals("TC_SBA_012")){
			
			assertTrue(click(selenium,lnkAddResources),"Could not click Add Resources link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
					
		
			assertTrue(selectValueFromAjaxList(selenium,txtAddResources,bookingAssistTestData.resource),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkCancel),"Could not click Cancel link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,txtAddResources)){
				Assert.fail("Cancel button is not working properly");
			}
			return true;
		}
		
		if(bookingAssistTestData.testCaseId.equals("TC_SBA_013")){
			assertTrue(click(selenium,lnkAddResources),"Could not click Add Resources link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,txtAddResources,"sdfo"),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblNoResourceFound).contains("No resource found")){
				return true;
			}
			else{
				Assert.fail("Search Failed");
			}
		}
		
		if(bookingAssistTestData.testCaseId.equals("TC_SBA_014")){
			assertTrue(click(selenium,lnkAddResources),"Could not click Add Resources link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,txtAddResources,"sdfo"),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClose),"Could not click close link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!getText(selenium,lblNoResourceFound).contains("No resource found")){
				return true;
			}
			else{
				Assert.fail("Search Failed");
			}
		}
		
		  Calendar cal=Calendar.getInstance();
		 // int day = cal.get(Calendar.DAY_OF_WEEK); 
		 // If current day is Sunday, day=1
         // System.out.println(day);
		  SimpleDateFormat DateFormat1=new SimpleDateFormat("MMMM dd, yyyy");
		  date=DateFormat1.format(cal.getTime());
		  System.out.println(date);
		  if(!getText(selenium,VfyCalenderViewDate).contains(date)){
				Assert.fail("The current date is not correct");
			} 
		 
		  if(!getText(selenium,VfyCalenderView).contains("My View")){
				Assert.fail("The My view is not correct");
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
	
}
