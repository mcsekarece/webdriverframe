package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.thoughtworks.selenium.Selenium;

public class VerifyMedicationReconciliationPage extends AbstractClinicalList {
	@Test(enabled=false)
//	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Medication Reconcilation Page")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationReconcilationPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "CreateMedReconcilationList";
		alertData.testCaseId = "TC_CML_001";
		alertData.fetchClinicalListTestData();
		createMedicationReconcilation(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(enabled=false)
//	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Medication Reconcilation Page With PresMed")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationReconcilationPageWithPresMed(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "CreateMedReconcilationList";
		alertData.testCaseId = "TC_CML_001";
		alertData.fetchClinicalListTestData();
		createMedicationReconcilation(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	/**
	 * Verify Medication Reconcilation Page
	 * function to Verify Medication Reconcilation Page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	     Apr 28, 2014
	 */

	public boolean createMedicationReconcilation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib alertData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date =null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + alertData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, alertData.userName, alertData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//-------------------------------- ------------------------- ----------//
			//  Step-2:Advanced search with Patient ID//
			//--------------------------------------------------------------------//

			searchPatientNexiaForProviderHomePage(selenium,alertData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib medicationData = new ChartPreVisitLib();
			medicationData.workSheetName = "CreateMedication";
			medicationData.testCaseId = "TC_PSM_001";
			medicationData.fetchChartPreVisitTestData();
			AbstractChartPreVisit medication = new AbstractChartPreVisit();
			
			assertTrue(medication.createMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to ManageCare Alerts //
			//--------------------------------------------------------------------//
		
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-4: create ManageCare Alerts //
			//--------------------------------------------------------------------//
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				cal.add(Calendar.DATE,1); 
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			 	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					cal.add(Calendar.DATE,1); 
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			
			assertTrue(createManageCareAlerts(selenium,alertData,date),"Create Manage Alert Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		
			
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		return returnValue;
}		
		
public boolean verifyManageAlertsInsummary(Selenium selenium,ClinicalListLib alertData,String userAccount ) throws IOException{
	
	String date = null;
	if(userAccount.equals(CAAccount)){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,1); 
		SimpleDateFormat DateFormat1=new SimpleDateFormat("MMM d, yyyy");
	 	date=DateFormat1.format(cal.getTime());
    }else {
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.DATE,1); 
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat1.format(cal.getTime());
	}

	assertTrue(getText(selenium,vfyManageAlertsInSummary).contains(date)," ", selenium, ClassName, MethodName);
		 
	assertTrue(getText(selenium,vfyManageAlertsInSummary).contains("Medication Reconciliation")," ", selenium, ClassName, MethodName);
	
		assertTrue(click(selenium,lnkClosedArrow),"Could not click the expand arrow in summary", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,vfyExpandDetails).contains("No previous Medication Reconciliation performed")," ", selenium, ClassName, MethodName);
			
		return true;
	}
	
   public boolean  verifyMedicationReconcillationResults(Selenium selenium,ClinicalListLib alertData,String date ){
	   boolean returnValue=true;
       int counter=1; 
	   int count = (Integer) selenium.getXpathCount("//div[3]/table/tbody/tr/td/div/div");
	   waitForPageLoad(selenium);
	
	   for (counter=1; counter<=count;counter++){
		        waitForPageLoad(selenium);
		 		if(getText(selenium,"//div[3]/table/tbody/tr["+counter+"]/td/div/div").contains(alertData.lastName)){
				if(getText(selenium,"//div[3]/table/tbody/tr["+counter+"]/td/div/div").trim().contains(date)){
				returnValue = true;
			}
				returnValue = true;
		}
	   }
		return returnValue;
	}
	
}