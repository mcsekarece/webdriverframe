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

public class VerifyAdvanceSearchLabFileToPatient extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Lab Advanced Search Details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabFileToPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateLabOrder";
		orderData.testCaseId = "TC_OL_001";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLabFileToPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	/**
	 * verifyLabSearchDetails
	 * function to verify Lab Search Details
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    May 20, 2014
	 */
	
	public boolean verifyLabFileToPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
	
		Selenium selenium=null;
		boolean returnValue=false;
		String arrowPossition;
		String patientName="Mathewaaace";
		String date ="";
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
			SimpleDateFormat DateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueAccNumber = DateFormat1.format(cal1.getTime());
			assertTrue(fileReportwithSearch(selenium,orderData,userAccount,uniqueAccNumber),"Creation Failed", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//FIXME EMR-1418
			arrowPossition = selenium.getAttribute("css=a.arrow-closed/@class");
			if(arrowPossition.equalsIgnoreCase("arrow-closed")){
				 assertTrue(click(selenium,"css=a.arrow-closed"),"Could not click the expand arrow of search Patient", selenium, ClassName, MethodName);
			 }
			
			//--------------------------------------------------------------------//
			//  Step-10 : Navigation to File new lab report//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkLab),"Could not click the lab link", selenium, ClassName, MethodName);
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
			
			assertTrue(click(selenium,chkFileToPatient),"Could not click the File to Patient link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12 :Search patient//
			//--------------------------------------------------------------------//
			assertTrue(searchFileToPatient(selenium),"Could not search the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
			date=DateFormat.format(cal.getTime());
			System.out.println(date);
			int date1=Integer.parseInt(date);
			if(date1<10){
			SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
			date=DateForma1t.format(cal.getTime());
			}else{
			SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
			date=DateFormat2.format(cal.getTime());
			}
		
			assertTrue(selenium.isTextPresent("Lab report successfully refiled to Thomas Mathewaag on "+date+" by "+orderData.provider),"Lab report successfully message is not getting displayed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean searchFileToPatient(Selenium selenium) throws IOException{
		assertTrue(selectValueFromAjaxList(selenium,txtSearchFileToPatient,"MATHEWAAG"),"Could not type patient name", selenium, ClassName, MethodName);
		selenium.typeKeys(txtSearchFileToPatient, "a");
		selenium.keyPress(txtSearchFileToPatient, "\\9");
		waitForElement(selenium,lblPatientResult,10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with name :-"+"MATHEWAAG", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains("MATHEWAAG".trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
		
		selenium.mouseOver(lblPatientResult);

		waitForPageLoad(selenium);
		selenium.click(lblPatientResult);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnSearchSavePatient),"Could not click the save patient", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		
		return true;
	}
}
