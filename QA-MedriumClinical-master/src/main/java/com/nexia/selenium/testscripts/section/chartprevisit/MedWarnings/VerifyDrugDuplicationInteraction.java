package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDrugDuplicationInteraction extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing drug duplication interaction") 
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDrugDuplicationInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_016";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		duplicationInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * duplicationInteraction
	 * Function to verify drug duplication interaction 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 13, 2012
	 */
	public boolean duplicationInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue = false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:delete the pending medication in the prescribe medication page
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPendingMedication(selenium,prescribeData),"Could not delete the pending medications", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit),"Edit is not present", selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-6: Again Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnPrint), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, imgDuplicateTherapy), "Drug duplication interaction is not displayed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
		
			return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}
