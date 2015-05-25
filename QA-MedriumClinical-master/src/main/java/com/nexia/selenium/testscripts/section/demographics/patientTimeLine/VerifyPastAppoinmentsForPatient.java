package com.nexia.selenium.testscripts.section.demographics.patientTimeLine;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPastAppoinmentsForPatient extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test For Verifying  Past Appoinment For Patient ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pastApponimentForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib patientTimeLineData = new SchedulingTestLib();
		patientTimeLineData.workSheetName = "PatientTimeLine";
		patientTimeLineData.testCaseId = "TC_PTL_002";
		patientTimeLineData.fetchSchedulingTestData();	
		VerifyPastAppoinments(seleniumHost, seleniumPort, browser, webSite, userAccount, patientTimeLineData);
	} 
	
	/*************************************************************************************************** 
	* @purpose        To verify Past appoinments for patient
	* @action 		  verify Past appoinments for patient
	* @expected       To Ensure that the Past appoinments for patient works fine    
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 25, 2013
	***************************************************************************************************/


	public boolean VerifyPastAppoinments(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib patientTimeLineData) throws Exception{
		
		boolean returnValue = false;
		Selenium selenium = null;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientTimeLineData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, patientTimeLineData.userName, patientTimeLineData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Register Patient//
			//--------------------------------------------------------------------//
			assertTrue(goToRegisterPatient(selenium),"Could not navigate to Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create New Patient//
			//--------------------------------------------------------------------//
			
			patientTimeLineData.workSheetName = "NewPatientCheckIn";
			patientTimeLineData.testCaseId = "TC_NPC_002";
			patientTimeLineData.fetchSchedulingTestData();	
			
			assertTrue(createNewPatientWithMandatory(selenium,patientTimeLineData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String patientId = getText(selenium,lblPtientId);
			waitForPageLoad(selenium);

			//Robot robot = new Robot();
			//robot.mouseMove(30,172);
			//Thread.sleep(10000);
		    //robot.mouseMove(MyPoint1.getX()+10, MyPoint1.getY() + Integer.parseInt(findElement(By.xpath("//div[@class='g_headwrapper ']")).getCssValue("height").replace("px", "")));
			//click(selenium,"x0y0");
            // JavascriptExecutor executor = (JavascriptExecutor) selenium;
             //executor.executeScript("arguments[0].click();", "x0y0");

			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Booking Assistant//
			//--------------------------------------------------------------------//
			assertTrue(goToCalender(selenium),"Could not navigate to Booking Assistant", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: select slot//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkBookingAssistant),"Could not click the Booking Assistant",selenium , ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxVisitType,patientTimeLineData.visitType ),"Could not select the visit type ", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,lnkMore),"Could not click the More Option",selenium , ClassName,MethodName);
			//waitForPageLoad(selenium);
			if(selenium.isVisible(imgCalenderSlot)){
				assertTrue(click(selenium,imgCalenderSlot),"Could not click the slot",selenium , ClassName,MethodName);
				waitForPageLoad(selenium);
			}else{
				System.out.println("create New Slot");
				return true;
						
			}
			//Search Created Patient
			assertTrue(type(selenium,txtPatientSearch,patientId),"Could not type the patient name",selenium, ClassName,MethodName);
			selenium.keyPress(txtPatientSearch, "\\9");
			waitForPageLoad(selenium);
			click(selenium,lblPatient);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnBookSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step- 7: Search Created Patient//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8 : Navigate to Patient time Line 						  //
			//--------------------------------------------------------------------//
			assertTrue(goToTimeLine(selenium),"Could not navigate the time line", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9 : Verify the Patient time line 					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPatientTimeLine),"Could not click the time line", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "//div[@class='visits-list-item']/div[@class='visits-list-item-left-container arrow-closed']")){
				click(selenium, "//div[@class='visits-list-item']/div[@class='visits-list-item-left-container arrow-closed']");
			}
			
			assertTrue(getText(selenium,"//div[@class='visits-list-item']/div[@class='visits-list-item-expanded-details-container']").contains("Scheduled"),"Scheduled is not getting displayed",selenium,ClassName,MethodName);
				returnValue = true;

		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
