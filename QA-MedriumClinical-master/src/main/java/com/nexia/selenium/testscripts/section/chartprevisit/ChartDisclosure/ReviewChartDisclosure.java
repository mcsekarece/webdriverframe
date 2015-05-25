package com.nexia.selenium.testscripts.section.chartprevisit.ChartDisclosure;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class ReviewChartDisclosure extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReviewChartDisclosure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreatePatientTask";
		allergyData.testCaseId = "TC_CD_029";
		allergyData.fetchChartPreVisitTestData();
		addAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	
	/**
	 * addAllergy
	 * function to add Allergy in Encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
	  * @since  	Oct 19, 2012
	 */
	
	public boolean addAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLib chartDisclosureData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MMddHHmm");
		date = DateFormat.format(cal.getTime());
		try{
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NPC_017";
			PatientData.fetchHomeTestData();
			ChartPreVisitLib allergyData = new ChartPreVisitLib();
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CAE_001";
			allergyData.fetchChartPreVisitTestData();
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: create new patient
			//--------------------------------------------------------------------//
					
			assertTrue(click(selenium,lnkSettings),"Could not click show more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingLink),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click on quick action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
		   			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		              waitForPageLoad(selenium);
			assertTrue(click(selenium,"newPatientAction"),"Could not click the Register Patient;More Deatils:"+PatientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createPatient(selenium,PatientData),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(selenium.isAlertPresent()){
				Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
			}
			assertTrue(click(selenium,lnkPatientOption),"Could not click Patient Option Link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkPatientChartView),"Could not click Chart Disclosure Link", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: create new Allergy//
			//--------------------------------------------------------------------//
			if (!chartDisclosureData.testCaseId.equals("TC_CE_025")) {
				assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
			
				//Click on Allergies Link
				assertTrue(selenium.isVisible(lnkEncounterAllergy),"Element is not visible", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
				assertTrue(isElementPresent(selenium,lnkEncounterAllergy),"Could not find the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
				selenium.clickAt(lnkEncounterAllergy,"");
				//selenium.focus(lnkAllergy);
				//selenium.fireEvent(lnkAllergy,"keypress");
			
				waitForPageLoad(selenium);
							
			
				//--------------------------------------------------------------------//
				//Add Allergy and verify it                                              //
				//--------------------------------------------------------------------//
				assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-4: Sign the Encounter						  //
				//--------------------------------------------------------------------//
				if(allergyData.testCaseId.equals("TC_CAE_001")){
					
					assertTrue(click(selenium, btnBeginEncounter)," ", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);		    
					assertTrue(isElementPresent(selenium,btnSign),"Could not find the link", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);			
					assertTrue(click(selenium,btnSign),"Could not click the sign link;More Details", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				//--------------------------------------------------------------------//
				//  Step-5: Create new Immunization  								  //
				//--------------------------------------------------------------------//	
				
				ChartPreVisitLib immunizationData = new ChartPreVisitLib();
				immunizationData.workSheetName = "CreateImmunization";
				immunizationData.testCaseId = "TC_CIM_030";
				immunizationData.fetchChartPreVisitTestData();
				assertTrue(goToBeginEncounter(selenium),"could not navigate", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selenium.isVisible(lnkEncounterImmunization),"Immunization Link Not Visible;More Details",selenium,ClassName,MethodName);
				assertTrue(click(selenium,lnkEncounterImmunization),"Immunization Link Not Visible;More Details",selenium,ClassName,MethodName);
				
				waitForPageLoad(selenium);
				assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Create Medication//
				//--------------------------------------------------------------------//
			
				ChartPreVisitLib medicationData = new ChartPreVisitLib();
				medicationData.workSheetName = "CreateMedication";
				medicationData.testCaseId = "TC_PSM_007";
				medicationData.fetchChartPreVisitTestData();
				assertTrue(goToBeginEncounter(selenium),"Could not navigate to begin encounter", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selenium.isVisible(lnkEncounterMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);		
				
				assertTrue(isElementPresent(selenium,lnkEncounterMedication),"Could not find the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				selenium.clickAt(lnkEncounterMedication,"");
				//selenium.focus(lnkEncounterMedication);
				//selenium.fireEvent(lnkEncounterMedication,"keypress");			
				waitForPageLoad(selenium);		
				assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}			
			
			assertTrue(click(selenium,lnkPatientOption),"Could not click Patient Option Link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkChartDisclosure),"Could not click Chart Disclosure Link", selenium, ClassName, MethodName);
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
				}
			
			//creating new Chart Disclosure
			chartDisclosureData.Instruction=chartDisclosureData.Instruction+date;
			assertTrue(createMandatoryChartDisclosureFromPC(selenium, chartDisclosureData, userAccount),"Could not create Chart Disclosure from Patient Option", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnCntnue),"Could not click Chart Disclosure Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,radIncludePartialChart),"Include Partial Chart Radio Button not Present", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getValue(selenium,lstShowSuggestBox).equals("All activities"),"Default Show is not All Activities", selenium , ClassName, MethodName);
			if (chartDisclosureData.testCaseId.equals("TC_CE_022")) {
				Integer cntAllActivities = (Integer) selenium.getXpathCount(lblContentPanel);
				assertTrue(cntAllActivities==4,"All Activities not Visible Correctly", selenium , ClassName, MethodName);
			}
			assertTrue(click(selenium,chkSelectAll),"Could not click Chart Disclosure Link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnContinueChartDis),"Could not click Chart Disclosure Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExpandCollapseAll),"Could not click Chart Disclosure Link", selenium, ClassName, MethodName);
			Integer cntReviewChartDisclosure = (Integer) selenium.getXpathCount(lnkRemove);
			assertTrue(cntReviewChartDisclosure==6,"All Activities not Visible Correctly", selenium , ClassName, MethodName);
		
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
