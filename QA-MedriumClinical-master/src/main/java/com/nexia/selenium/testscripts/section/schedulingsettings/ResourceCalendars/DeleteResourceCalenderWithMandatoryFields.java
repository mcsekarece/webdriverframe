package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceCalendars;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteResourceCalenderWithMandatoryFields extends AbstractSchedulingTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "DeleteResourceCalenderWithMandatoryFields")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteResourceCalenderWithMandatoryFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "CreateResourceCalender";
		createResourceCalData.testCaseId = "TC_CRC_004";
		createResourceCalData.fetchSchedulingTestData();	
	    createResourceCalender(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	} 

	
	/**     
	* @purpose       Delete ResourceCalender With MandatoryFields
    *  @action         Delete ResourceCalender With MandatoryFields
    *  @expected       Create NewResourceCalender ,Calender will be deleted properly
    *  @author         Aspire QA
	* @throws          IOException 
    *  @state          Developing
    *  @useraccount    Both
	* @since  	   Jun 12, 2013
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
               
			assertTrue(deleteAllResourceCalendar(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,chkIncludeInactiveCheckbox),"Could not click IncludeInactiveCheckbox", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 			 
			 assertTrue(selectValueFromAjaxList(selenium,txtSearchResourceCal,createResourceCalData.search),"Could not select search resource"+createResourceCalData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 	
			 selenium.typeKeys(txtSearchResourceCal, "a");
			 waitForPageLoad(selenium);
			 
			 if(getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				  if (selenium.isTextPresent("Activate")){				  
				  assertTrue(click(selenium,btnActivate),"Could not click Activate button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  assertTrue(click(selenium,btnYesButton),"Could not click Yes button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  
				  }
				  assertTrue(click(selenium,btnEdit),"Could not click Edit button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);			 			 
			  }		
			  else {  
				assertTrue(click(selenium,btnAdd),"Could not click add new button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			  }
			
			//--------------------------------------------------------------------//
			//  Step-4: Add New ResourceCalender //
			//--------------------------------------------------------------------//
        	
			assertTrue(createResourceCalenderWithMandatoryFields(selenium, createResourceCalData,userAccount), "Create Resource Calender With Mandatory Fields failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Delete  Created ResourceCalender //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnDelete),"Could not click delete button", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			
		    assertTrue(click(selenium, btnYesButton), "Could not click the yes button in delete pop up", selenium, ClassName, MethodName);
		    
			if(isChecked(selenium, chkIncludeInactiveCheckbox)){
				assertTrue(click(selenium,chkIncludeInactiveCheckbox),"Could not click IncludeInactiveCheckbox", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
		    
			 if(getText(selenium,lblResourceCalendarDetials).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				Assert. fail("The resource calender deletion failed");
			 }
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + createResourceCalData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}