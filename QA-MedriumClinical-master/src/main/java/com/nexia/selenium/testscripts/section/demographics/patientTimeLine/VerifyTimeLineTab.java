package com.nexia.selenium.testscripts.section.demographics.patientTimeLine;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTimeLineTab extends AbstractSchedulingTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test For Verify Time Line tab")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "PatientTimeLine";
		createResourceCalData.testCaseId = "TC_PTL_001";
		createResourceCalData.fetchSchedulingTestData();	
	    verifyTimeLine(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	} 
	
	/*************************************************************************************************** 
	* @purpose        To verify Time Line Fields
	* @action 		  verify Time Line Fields
	* @expected       To Ensure that the Time Line works fine    
	* @author         aspireQa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 20, 2013
	***************************************************************************************************/

	public boolean verifyTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib resourceGroup) throws Exception{
		
		boolean returnValue = false;
		Selenium selenium = null;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + resourceGroup.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, resourceGroup.userName, resourceGroup.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,resourceGroup.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3 : Navigate to Patient time Line 						  //
			//--------------------------------------------------------------------//
			assertTrue(goToTimeLine(selenium),"Could not navigate the time line", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4 : Verify the Patient time line 					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPatientTimeLine),"Could not click the time line", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyTimeLine(selenium)){
				Assert.fail("Tab is not getting displayed");
			}else
				returnValue = true;
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
	
	public boolean verifyTimeLine(Selenium selenium) throws IOException{
		
		if(!isElementPresent(selenium,"css=div.gwt-HTML")){
			return false;
		}
		
	/*	if(!isElementPresent(selenium,lnkBooking)){
			return false;
		}
		
		if(!isElementPresent(selenium,lnkContact)){
			return false;
		}*/
		
		assertTrue(click(selenium,ajxshowFillter),"Could not click the Show Fillter", selenium, ClassName, MethodName);
		
		if(!selenium.isTextPresent("All visits")&& selenium.isTextPresent("Attended") && selenium.isTextPresent("Cancelled") && selenium.isTextPresent("Confirmed")&& selenium.isTextPresent("No show")){
			return false;
		}
		
		
		return true;
	}
}
