package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyTheCaseAvailablity extends AbstractOperationsTest{
	
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "verify the Availablity Of Cases")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAvailablityOfCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		bookingAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Availablity Of Cases
	* @action 		  verifying Availablity Of Cases
	* @author         Aspire QA
	* @throws 	      IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 08, 2013
	***************************************************************************************************/
	public boolean bookingAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData)throws Exception
	{
		String date=null;
		String time=null;
		
		Selenium selenium = null;
		boolean returnValue= false;
		try{
			
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + bookingAssistTestData.toString());
			HomeLib casesData = new HomeLib();
			casesData.workSheetName = "NewCases";
			casesData.testCaseId = "TC_NC_001";
			casesData.fetchHomeTestData();
			
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, casesData.userName, casesData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                         //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,casesData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			searchPatientNexia(selenium,casesData.patientID);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Cases and deleting existing Cases             //
			//--------------------------------------------------------------------//
			assertTrue(goToCases(selenium), "Could not navigate to Cases Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(deleteAllCases(selenium), "Could not delete cases", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//---------------------------------------------------------- ---------//
			//  Step-4: Create a new case                                         //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ casesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createCases(selenium,casesData,userAccount),"Cases creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String createdCase= getText(selenium, "//div[@id=\"PatientCaseList\"]/table/tbody/tr/td/div/span/div/span");
			
			
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				 date=DateFormat.format(cal.getTime());
				 DateFormat=new SimpleDateFormat("HH");
				 time=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				 date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				 time=DateFormat.format(cal.getTime());
				}
			assertTrue(click(selenium,lnkExpandAll),"Could not click Expand All; More Details :" + casesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly              //
			//--------------------------------------------------------------------//
			click(selenium,lnkEdit);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValuesCreateCase(selenium,casesData,date,userAccount)){
				Assert.fail("Cases details not saved properly; More Details :"+ casesData.toString());
				returnValue=false;
			}
			
			click(selenium, btnCancel);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to BookingAssistant //
			//--------------------------------------------------------------------//
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ---------//
			//  Step-7: Select the required slot                                  // 
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationVisitType,bookingAssistTestData.visitType),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,vfyRequiredSlot),"Could not click  required slot link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-8: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
		    searchPatientForBookingVisit(selenium,bookingAssistTestData.patientName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-9: Visit Details//
			//--------------------------------------------------------------------//
		    assertTrue(click(selenium, "xpath=(//input[@id='suggestBox'])[7]"), "Could not click the cases drop down", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			if(getText(selenium, "//div[5]/div/div/div/div/div").equalsIgnoreCase(createdCase)){
				returnValue=true;
			}
			
		}			
		catch (RuntimeException e){
			
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			
		}
		return returnValue;
	}
		
}
