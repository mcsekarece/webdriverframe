package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.internal.seleniumemulation.IsVisible;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValueofAssesmentSectionForSignedEncounter extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing whether Begin Encounter button present after saving an encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueOfSignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_013";
		encounterData.fetchChartPreVisitTestData();
		verifySignedEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	

	
	/**
	 * verifySignedEncounter
	 * function to verify whether Begin Encounter button present after saving an encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 24, 2012
	 */
	public boolean verifySignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		boolean retuenValue=true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			ChartPreVisitLib vitalsData = new ChartPreVisitLib();
			vitalsData.workSheetName = "NewPatientCheckIn";
			vitalsData.testCaseId = "TC_NP_001";
			vitalsData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter//
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			
						
			//--------------------------------------------------------------------//
			//  Step-5: Enter All Details//
			//--------------------------------------------------------------------//
			assertTrue(assesmentSectionForSignedEncounter(selenium,encounterData),"could not Enter the data", selenium, ClassName, MethodName);
			
	
			selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);
			waitForPageLoad(selenium);
		
			ChartPreVisitLib encounterData2 = new ChartPreVisitLib();
			encounterData2.workSheetName = "CreateProblemList";
			encounterData2.testCaseId = "TC_CPL_013";
			encounterData2.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Problem list//
			//--------------------------------------------------------------------//
			
			assertTrue(createProblemList(selenium,encounterData2,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,imbPrescribeIcon),"Could not click the Prescrbe Medication link", selenium, ClassName, MethodName);
			ChartPreVisitLib encounterData1 = new ChartPreVisitLib();
			encounterData1.workSheetName = "PrescribeMedi";
			encounterData1.testCaseId = "TC_PM_009";
			encounterData1.fetchChartPreVisitTestData();
			
			assertTrue(SearchPrescribeMed(selenium,encounterData1,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementVisible(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride,encounterData1.reason),"Could not type reason;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+encounterData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(addPrescribeMedication(selenium,encounterData1,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddToPending),"Could not click the print button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to chart Encounter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Stored value //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxRxShow,"Signed");
			if(getText(selenium,lblProDetails).contains(encounterData.medicalCondition1)){
				assertTrue(click(selenium,lnkExpand),"Could not click the arrow", selenium, ClassName, MethodName);
				if(!verifyStoredValue(selenium,encounterData,encounterData1,encounterData2,userAccount)){
					retuenValue = false;
					fail("Signed Encounter details not saved properly; More Details :"+ encounterData.toString());
				}else
				return true;
			}
		
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return retuenValue;
		}
		return retuenValue;
	}
	
	
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib encounterData,ChartPreVisitLib encounterData1,ChartPreVisitLib encounterData2,String account) throws IOException{
		//int count=1;
		String date=null;
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
				date=DateFormat.format(cal.getTime());
				int date1=Integer.parseInt(date);
				if(date1<10){
					SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
					date=DateForma1t.format(cal.getTime());
				
				}else{
					SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
					date=DateFormat2.format(cal.getTime());
					
				}
			}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			
			}
		
		
		
		//assertTrue(getText(selenium,lblSignedEncounter).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.provider1.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find Encounters button", selenium, ClassName, MethodName);
			
		assertTrue(getText(selenium,lblSignedEncounter).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.chief.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find Encounters button", selenium, ClassName, MethodName);
			
		assertTrue(getText(selenium,lblProDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find Encounters button", selenium, ClassName, MethodName);
			
		
		assertTrue(getText(selenium,lblSignedEncounter).trim().contains(date.trim()),"Could not find Encounters button", selenium, ClassName, MethodName);
			
			
		assertTrue(getText(selenium,lblSignedEncounter).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.vitals.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find Encounters button", selenium, ClassName, MethodName);
			
		
		assertTrue(getText(selenium,lblSignedEncounter).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.chief.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find Encounters button", selenium, ClassName, MethodName);
			

		assertTrue(getText(selenium,lblProDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.notes.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find Encounters button", selenium, ClassName, MethodName);
			
		
		if(account.equals(CAAccount)){
			assertTrue(getText(selenium,lblProDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData1.prescribeCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find Encounters button", selenium, ClassName, MethodName);
			
		}
		else{
			assertTrue(getText(selenium,lblProDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData1.prescribe.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find Encounters button", selenium, ClassName, MethodName);
			}
		return true;
	}
}
