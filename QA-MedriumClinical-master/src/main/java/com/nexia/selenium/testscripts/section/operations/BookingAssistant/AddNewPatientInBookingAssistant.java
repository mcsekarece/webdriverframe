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

public class AddNewPatientInBookingAssistant extends AbstractOperationsTest{
	
	@Test(groups = {"Smoke","Review","firefox", "iexplore", "safari", "default" }, description = "Test for verify add new patient in booking assistant")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addNewPatientInBookingAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}

	/*************************************************************************************************** 
	* @purpose        verify add new patient in booking assistant
	* @action 		  verifying add new patient in booking assistant
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 18, 2013
	***************************************************************************************************/

	public boolean bookingAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData)throws Exception{
		Selenium selenium = null;
		boolean returnValue= true;
		try{
			
			//--------------------------------------------------------------------//
			// Step 1:Login to the application									  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + bookingAssistTestData.toString());
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, bookingAssistTestData.userName, bookingAssistTestData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to BookingAssistant 							  //
			//--------------------------------------------------------------------//
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Select the required slot                                  // 
			//--------------------------------------------------------------------//
		    if(!selectRequiredSlot(selenium,bookingAssistTestData)){
			    System.out.println("Select required slot not available: create it manually");
			    return true;
		    }
	 
		    //--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//
			String date =null;
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if(userAccount.equalsIgnoreCase(CAAccount)){
				DateFormat=new SimpleDateFormat("dd/MM/YYYY");
			}
			else{
				DateFormat=new SimpleDateFormat("MM/dd/YYYY");
			}
			date=DateFormat.format(cal.getTime());
			
			bookingAssistTestData.patientName = bookingAssistTestData.patientName +date;
			
			
			
			assertTrue(type(selenium,txtpatientsearch,bookingAssistTestData.patientName),"Could not type patient id", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtpatientsearch, "\\9");
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "//body/div[4]/div/div/div/div[2]/div/div/div/div")){
				click(selenium, "//body/div[4]/div/div/div/div[2]/div/div/div/div");
			}else{
				Assert.fail("Add new patient is not available");
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Visit Details for new patient in booking assistant    //
			//--------------------------------------------------------------------//
		    assertTrue(visitDetialsForNewPatient(selenium,bookingAssistTestData,userAccount), "Visit details failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------------//
			//  Step-6: Verify the created temporary patient in global patient search   //
			//--------------------------------------------------------------------------//
			
			//Bug Id --> #5354
			assertTrue(type(selenium,txtPatientBox,bookingAssistTestData.patientName),"Could not type patient id", selenium, ClassName,MethodName);
			selenium.keyPress(txtPatientBox, "\\9");
			waitForElement(selenium,lblPatientResult,10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+bookingAssistTestData.patientName, selenium, ClassName,MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(bookingAssistTestData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"get text patient result failed", selenium, ClassName,MethodName);
			
			
		}			
		catch (RuntimeException e){
			
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			
		}
		return returnValue;
	}
		
}
