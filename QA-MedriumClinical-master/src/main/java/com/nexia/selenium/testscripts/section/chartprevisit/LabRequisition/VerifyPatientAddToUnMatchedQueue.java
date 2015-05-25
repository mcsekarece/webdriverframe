package com.nexia.selenium.testscripts.section.chartprevisit.LabRequisition;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientAddToUnMatchedQueue  extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Patient Add To Un Macthed Queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUnMatchedQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateLabOrder";
		orderData.testCaseId = "TC_OL_001";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyUnMatchedQueueDetails(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	
	/**
	 * verifyUnMatchedQueueDetails
	 * function to verify UnMatched Queue Details
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    May 24, 2014
	 */
	
	public boolean verifyUnMatchedQueueDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		String arrowPossition;
		String patientName="Mathewaaace";
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + orderData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,patientName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Delete Encounter from Encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,orderData),"", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-5: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete Existing Lab Orders//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteOrders(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Lab Order Page//
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(imgLabOrderIcon),"link is not visible", selenium, ClassName, MethodName);
			assertTrue(clickLabIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-8: Create Lab Order Page//
			//--------------------------------------------------------------------//
			assertTrue(orderNewLabs(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click the sign button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			if (selenium.isElementPresent(btnContinue)) {

				assertTrue(click(selenium, btnContinue),
						"Could not click on Save reason button",selenium, ClassName, MethodName); }
             waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			assertTrue(navigateTofileReport(selenium,orderData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat(
					"dd-MM-yyyy HH:mm");
			String uniqueAccNumber = DateFormat1.format(cal1.getTime());
			
			assertTrue(fileReportwithSearch(selenium,orderData,userAccount,uniqueAccNumber),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			arrowPossition = selenium.getAttribute("css=a.arrow-closed/@class");
			if(arrowPossition.equalsIgnoreCase("arrow-closed")){
				 assertTrue(click(selenium,"css=a.arrow-closed"),"Could not click the expand arrow of search Patient", selenium, ClassName, MethodName);
			 }
			
			//--------------------------------------------------------------------//
			//  Step-10 : Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkLab),"Could not click the lab link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(labAdvanceSearch(selenium,orderData,userAccount,uniqueAccNumber),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11 : Verify the Search the result details//
			//--------------------------------------------------------------------//
			if(!verifySearchResultDetails(selenium, orderData,patientName)){
				Assert.fail("lab result details are not displayed properly");
			}
			
			assertTrue(click(selenium,btnRefile),"Could not click the btn Refile", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-12 : Data Add to Unmatched Queue in provider page //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,chkReturnToUnMatch),"Could not click the return to un match radio button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSearchSavePatient),"Could not click the save button in search result page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent("Unmatched"),"Unmatched tect is not present in search result page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-13 : Navigate to Home page //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-14 : Verify Unmatched queue details //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkUnmatchedQueue),"Could not click the Unmacted Queue link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			
			
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
