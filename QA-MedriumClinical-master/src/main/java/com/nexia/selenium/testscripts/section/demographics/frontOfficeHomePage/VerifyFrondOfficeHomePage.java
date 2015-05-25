package com.nexia.selenium.testscripts.section.demographics.frontOfficeHomePage;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;
public class VerifyFrondOfficeHomePage extends AbstractHomeTest{
	HomeLib PatientData = new HomeLib();
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying Count of Appointment Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void frontOfficeHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_001";
		PatientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFrontOfficePage(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify appointment schedule on front office home page
	* @action 		  To verify appointment schedule on front office home page
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @defect         #5876
	* @since  	      Dec 30, 2013s
	***************************************************************************************************/
	public boolean verifyFrontOfficePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=false;
		String notification = null;
		String needAction = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                         //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,patientData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Verify Front Office Home Page For Notification             //
			//--------------------------------------------------------------------//
			AbstractChartPreVisit chart = new AbstractChartPreVisit();
			
			notification =  getText(selenium,chart.lblNotification);
			
			if(!notification.contains(chart.lblTaskNotification)){
				Assert.fail("Task Notification is not getting displayed");
			}
			
			if(!notification.contains(chart.lblTransmissions)){
				Assert.fail("Transmissions have failed is not getting displayed");
			}
			
			//--------------------------------------------------------------------//
			//  Step-4:Verify Provider Home Page For Need Action                 //
			//--------------------------------------------------------------------//
			needAction = getText(selenium,chart.lblAction);
			
			if(!needAction.contains(chart.lblTask)){
				Assert.fail("Task  is not getting displayed");
			}
			
			if(!needAction.contains(lblUnmatchedRecord)){
				Assert.fail("Unmatched Reocrd is not getting displayed");
			}
			
			if(!needAction.contains(lblBumpListRecord)){
				Assert.fail("Bump List is not getting displayed");
			}
			
			if(!needAction.contains(lblwailtList)){
				Assert.fail("Wait List Reocrd is not getting displayed");
			}
			
			if(!needAction.contains(lblUnConfirmed)){
				Assert.fail("Un Confirmed Reocrd is not getting displayed");
			}
			
			if(!needAction.contains(chart.lblReport)){
				Assert.fail("Report is not getting displayed");
			}
			
			if(!needAction.contains(chart.lblEncounter)){
				Assert.fail("Encounter is not getting displayed");
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
