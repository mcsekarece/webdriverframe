package com.nexia.selenium.testscripts.section.operations.CheckinAssistant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCheckInAssistantWithPatientTrackingDisabled  extends AbstractOperationsTest {
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "VerifyCheckInAssistantWithPatientTrackingDisabled")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCheckInAssistantWithPatientTrackingDisabled(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib checkInAssistantTestData = new  OperationsTestLib();
		checkInAssistantTestData.workSheetName = "VerifyCheckInAssistant";
		checkInAssistantTestData.testCaseId = "TC_VCA_001";
		checkInAssistantTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkInAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,checkInAssistantTestData);
	} 
	/**     
	  * @purpose      VerifyCheckInAssistantWithPatientTrackingDisabled
 *  @action          verify CheckInAssistant function With PatientTracking Disabled
 *  @expected        verify CheckInAssistant function With PatientTracking Disabled
 *  @author         Aspire QA
	 * @throws IOException 
 *  @state          Developing
 *  @useraccount    Both
	  * @since  	    Jun 26, 2013
	  * 
	  */


public boolean checkInAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib checkInAssistantTestData) throws IOException{
	Selenium selenium = null;
	String date = null;
	boolean returnValue= true;
	try{
		
		//--------------------------------------------------------------------//
		// Step 1:Login to the application//
		//--------------------------------------------------------------------//
		
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + checkInAssistantTestData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, checkInAssistantTestData.userName, checkInAssistantTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		//--------------------------------------------------------------------//
		//  Step-2: Navigate to SchedulingSettings //
		//--------------------------------------------------------------------//
		
		assertTrue(goToScheduling(selenium),"Could not click the link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-2:Check Calender Preferences Settings //
		//--------------------------------------------------------------------//
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkCalenderPreferences),"Could not click  Calender Preferences link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnEdit),"Could not click Edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isChecked(selenium,chkEnablePatientTracking)){
			assertTrue(click(selenium,chkEnablePatientTracking),"Could not click EnablePatientTracking Check Box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		assertTrue(click(selenium,btnSave),"Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3: Step-3: Navigate to Checkin Assistant //
		//--------------------------------------------------------------------//
		
		assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,lnkCheckInAssistant),"Could not click lnkCheckInAssistant link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//---------------------------------------------------------- ---------//
		//  Step-4: Verify Checkin Assistant                                  // 
		//--------------------------------------------------------------------//
		
		   
		 if(selenium.isTextPresent("I've got it. Don't show again.")){
			Assert.fail("The check in Assistant Failed");
		 }
		 
		 if(userAccount.equals(CAAccount)){
			  Calendar cal=Calendar.getInstance();
			  SimpleDateFormat DateFormat1=new SimpleDateFormat("MMM d, yyyy");
			  date=DateFormat1.format(cal.getTime());
			  if(!getText(selenium,vfyTodayDate).contains(date)){
					Assert.fail("The check in Assistant date not matched");
				} 
		  }else{
			  
			  Calendar cal=Calendar.getInstance();
			  SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
			  date=DateFormat1.format(cal.getTime());
			  if(!getText(selenium,vfyTodayDate).contains(date)){
					Assert.fail("The check in Assistant date not matched");
				}
			  
		  }
		 System.out.println(getText(selenium,vfyCheckinWizard1));
		 if(!getText(selenium,vfyCheckinWizard1).startsWith("Click on any patient to start the")){
				Assert.fail("The check in Assistant Failed");
			}
		
	}			
		catch (RuntimeException e){
			
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return returnValue;
}
}
