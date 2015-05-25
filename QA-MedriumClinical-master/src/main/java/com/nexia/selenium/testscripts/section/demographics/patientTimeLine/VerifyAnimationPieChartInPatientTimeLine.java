package com.nexia.selenium.testscripts.section.demographics.patientTimeLine;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAnimationPieChartInPatientTimeLine extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test For Verifying Edit Visit Details in Patient Time Line ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void animationPieChartInPatientTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib patientTimeLineData = new SchedulingTestLib();
		patientTimeLineData.workSheetName = "PatientTimeLine";
		patientTimeLineData.testCaseId = "TC_PTL_003";
		patientTimeLineData.fetchSchedulingTestData();	
		verifyAnimationPieChart(seleniumHost, seleniumPort, browser, webSite, userAccount, patientTimeLineData);
	} 
	
	/*************************************************************************************************** 
	* @purpose        To verify Animation pie chart
	* @action 		  verify animation Pie chart
	* @expected       To Ensure that the verify Animation pie chart works fine    
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 26, 2013
	***************************************************************************************************/


	public boolean verifyAnimationPieChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib patientTimeLineData) throws Exception{
		
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
			String pName = getText(selenium,lblProvider);
			String providerName = pName.replaceAll("Dr. ", "");
			String LocationName = getText(selenium,lblLocation);
			if(isElementPresent(selenium, lnkMore)){
				assertTrue(click(selenium,lnkMore),"Could not click the More Option",selenium , ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,imgCalenderSlot),"Could not click the slot",selenium , ClassName,MethodName);
				waitForPageLoad(selenium);
			}else{
				System.out.println("Create new slot");
				return true;
			}
			//Search Created Patient
			assertTrue(type(selenium,txtPatientSearch,patientId),"Could not type the patient name",selenium, ClassName,MethodName);
			selenium.keyPress(txtPatientSearch, "\\9");
			waitForPageLoad(selenium);
			click(selenium,lblPatient);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: verify the details//
			//--------------------------------------------------------------------//
			if(!verifyPatientDetails(selenium,patientTimeLineData,providerName , LocationName)){
				Assert.fail("Details not saved properly");
			}
			
			assertTrue(click(selenium,btnBookSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: search same Patient//
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxVisitType,patientTimeLineData.visitType ),"Could not select the visit type ", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkMore),"Could not click the More Option",selenium , ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,imgCalenderSlot),"Could not click the slot",selenium , ClassName,MethodName);
			waitForPageLoad(selenium);
	
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
			
			
			
			if(!verifyPatientTimeLine(selenium,patientTimeLineData,providerName , LocationName)){
				Assert.fail("Details not saved properly");
			}
			
			//--------------------------------------------------------------------//
			//  Step-10 : Edit visit type				  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAction),"Could not click the Action link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkEditVisit),"Could not click the Edit visit", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(editVisitPatientTimeLine(selenium,patientTimeLineData),"Edit Visit Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-10 : Edit visit type				  //
			//--------------------------------------------------------------------//
			patientTimeLineData.workSheetName = "PatientTimeLine";
			patientTimeLineData.testCaseId = "TC_PTL_004";
			patientTimeLineData.fetchSchedulingTestData();	
			
			assertTrue(click(selenium,lnkPatientAction),"Could not click the Action link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkEditVisit),"Could not click the Edit visit", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(editVisitPatientTimeLine(selenium,patientTimeLineData),"Edit Visit Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11 :Verify  edit Visit details //
			//--------------------------------------------------------------------//
			
			if(!verifyConfirmVistDetails(selenium,patientTimeLineData,providerName , LocationName)){
				Assert.fail("Details not saved properly");
			}else
				returnValue = true;
			

		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyConfirmVistDetails(Selenium selenium,SchedulingTestLib patientTimeLineData , String providerName, String location) throws IOException{
		if(!isElementPresent(selenium,imgCommentPopup)){
			return false;
		}
		
		assertTrue(click(selenium,lblPatientTimeLine),"Could not click the time line", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(!getText(selenium,lblExpandPatientTimeLine).contains("To be confirmed"),"could not get text",selenium,ClassName,MethodName);
		
		assertTrue(getText(selenium,lblExpandPatientTimeLine).contains("Completed"),"could not get text",selenium,ClassName,MethodName);
		
		assertTrue(getText(selenium,lblExpandPatientTimeLine).contains(patientTimeLineData.referredByVisit),"could not get text",selenium,ClassName,MethodName);
		
		assertTrue(getText(selenium,lblExpandPatientTimeLine).contains(patientTimeLineData.comments),"could not get text",selenium,ClassName,MethodName);
		
		return true;
	}
}
