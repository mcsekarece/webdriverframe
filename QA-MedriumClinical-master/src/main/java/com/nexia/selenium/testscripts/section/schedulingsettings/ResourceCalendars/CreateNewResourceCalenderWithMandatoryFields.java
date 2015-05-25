package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceCalendars;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class CreateNewResourceCalenderWithMandatoryFields extends AbstractSchedulingTest {

	
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "CreateNewResourceCalenderWithMandatoryFields")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewResourceCalenderWithMandatoryFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "CreateResourceCalender";
		createResourceCalData.testCaseId = "TC_CRC_001";
		createResourceCalData.fetchSchedulingTestData();	
	    createResourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	} 
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyStoredValues")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "CreateResourceCalender";
		createResourceCalData.testCaseId = "TC_CRC_003";
		createResourceCalData.fetchSchedulingTestData();	
	    createResourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	} 
	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyCreateResourceCalender with end date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCreateResourceCalenderWithEnddate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "CreateResourceCalender";
		createResourceCalData.testCaseId = "TC_CRC_005";
		createResourceCalData.fetchSchedulingTestData();	
	    createResourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	}
	
	/**     
	  * @purpose        CreateNewResourceCalender
     *  @action         Create NewResourceCalender With MandatoryFields
     *  @expected       After Create NewResourceCalender ,details will be stored properly
     *  @author         Aspire QA
	 * @throws          IOException 
     *  @state          Developing
     *  @useraccount    Both
	  * @since  	    Jun 07, 2013
	*/
	
	
	
	public boolean createResourceCalender(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib createResourceCalData) throws IOException{
		Selenium selenium = null;
		boolean returnValue= true;
		try{
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + createResourceCalData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, createResourceCalData.userName, createResourceCalData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to SchedulingSettings //
			//--------------------------------------------------------------------//
			
			assertTrue(goToScheduling(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Resource Calender //
			//--------------------------------------------------------------------//
                
			//assertTrue(deleteAllResourceCalendar(selenium),"Deletion failed", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			 assertTrue(click(selenium,chkIncludeInactiveCheckbox),"Could not click IncludeInactiveCheckbox", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 			 
			 assertTrue(type(selenium,txtSearchResourceCal,createResourceCalData.search),"Could not select search resource"+createResourceCalData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 selenium.typeKeys(txtSearchResourceCal, "a");
			 waitForPageLoad(selenium);
			 	System.out.println(getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")));
			 if(getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				  if (selenium.isTextPresent("Activate")){				  
				  assertTrue(click(selenium,btnActivate),"Could not click Activate button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  assertTrue(click(selenium,btnYesButton),"Could not click Yes button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				 
				  }
				  assertTrue(click(selenium,chkIncludeInactiveCheckbox),"Could not click IncludeInactiveCheckbox", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  assertTrue(click(selenium,btnEdit),"Could not click Edit button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);	
				 
			  }else{  
				assertTrue(click(selenium,lnkResourceAddNew),"Could not click add new button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			  }
			 
			//--------------------------------------------------------------------//
			//  Step-4: Add New ResourceCalender //
			//--------------------------------------------------------------------//
		
			
			assertTrue(createResourceCalenderWithMandatoryFields(selenium, createResourceCalData,userAccount), "Create Resource Calender With Mandatory Fields failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(createResourceCalData.testCaseId.equals("TC_CRC_003")){
				  assertTrue(click(selenium,lnkResourceCalenderViewDetails),"Could not click View details", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				 
				  if(!verifyStoreValues(selenium,createResourceCalData)){
						fail("The Values are not stored Properly"); 
					}
			}else{
				
				return returnValue;
			}
			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + createResourceCalData.toString(), selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
	       
	
	public boolean  verifyStoreValues(Selenium selenium,SchedulingTestLib createResourceCalData) throws IOException{
		 assertTrue(getText(selenium,lnkResourceCalendarDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.resource.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification Failed", selenium, ClassName, MethodName);
		 assertTrue(getText(selenium,lnkResourceCalendarDetails).contains(createResourceCalData.cycle),"Verification Failed", selenium, ClassName, MethodName);
		
		 return true;
		 
	 }
	
}
