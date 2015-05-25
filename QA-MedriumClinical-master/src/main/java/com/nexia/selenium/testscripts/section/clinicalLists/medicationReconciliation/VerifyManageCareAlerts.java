package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyManageCareAlerts extends AbstractClinicalList  {
	@Test(enabled=false)
	/*
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Create ManageCare Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})*/
	public void createManageCareAlerts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ManageCareAlerts";
		alertData.testCaseId = "TC_MCA_001";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	/**
	 * Create ManageCare Alerts
	 * function to verify Create  ManageCare Alerts
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 25, 2013    -- //6603
	 */

	public boolean createAlerts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib alertData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date =null;
		String time =null;
		String PatientName =null;
		
		try{

			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + alertData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, alertData.userName, alertData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//---------------------------------------------------------- ----------//
			//  Step-2:Create Patient  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickActions),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkRegNewPatient),"Could not click the Register Patient;More Deatils:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				cal.add(Calendar.DATE,1); 
				SimpleDateFormat DateFormat1=new SimpleDateFormat("hh:mm:ss");
				SimpleDateFormat DateFormat2=new SimpleDateFormat("dd/MM/yyyy");
			 	time=DateFormat1.format(cal.getTime());
				time =	"PN_"+ time;
			 	date=DateFormat2.format(cal.getTime());
			 	PatientName =  time;
			 	System.out.println(PatientName);
		    }else{
				Calendar cal=Calendar.getInstance();
				cal.add(Calendar.DATE,1); 
				SimpleDateFormat DateFormat1=new SimpleDateFormat("hh:mm:ss");
				SimpleDateFormat DateFormat2=new SimpleDateFormat("MM/dd/yyyy");
				time=DateFormat1.format(cal.getTime());
				time =	"PN_"+ time;
			 	date=DateFormat2.format(cal.getTime());
			 	PatientName =  time;
			 	System.out.println(PatientName);
			}
			
			assertTrue(createNewPatientWithoutDOb(selenium,alertData,date,time),"Patient Create Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			alertData.patientID = PatientName;
			
			//---------------------------------------------------------- ----------//
			//  Step-2:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,alertData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to ManageCare Alerts //
			//--------------------------------------------------------------------//
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: create ManageCare Alerts //
			//--------------------------------------------------------------------//
			
			assertTrue(createManageCareAlerts(selenium,alertData,date),"Create Manage Alert Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Medication Reconciliation Results //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAutomatedRecall),"Could not click on Automated Recallt link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPreview),"Could not click on link Preview", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify Medication Reconciliation in clinical lists
			//--------------------------------------------------------------------//
			
			assertTrue(verifyMedicationReconcillationResults(selenium,time,date),"verify MedicationReconcillation Results Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		return returnValue;
}		
		
   public boolean  verifyMedicationReconcillationResults(Selenium selenium,String time,String date ){
	   boolean returnValue=false;
       int counter=1; 
	   int count = (Integer) selenium.getXpathCount("//div[3]/table/tbody/tr/td/div/div");
	   waitForPageLoad(selenium);
	   for (counter=1; counter<=count;counter++){
		   waitForPageLoad(selenium);
				if(getText(selenium,"//div[3]/table/tbody/tr["+counter+"]/td/div/div").contains(time)){
				if(getText(selenium,"//div[3]/table/tbody/tr["+counter+"]/td/div/div").trim().contains(date)){
				if(!getText(selenium,"//div[3]/table/tbody/tr["+counter+"]/td/div/div").trim().contains("-1")){
				returnValue = true;
			}
	     }
	   }
	 }
		return returnValue;
	}
   
   public boolean createNewPatientWithoutDOb(Selenium selenium,ClinicalListLib searchData,String date,String time ) throws IOException{
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLastName,time),"Could not type the last name : More Details"+searchData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtFirstName,date),"Could not type the first Name : More Details"+searchData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxSexSuggestBox,"Female");
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnClinicalSave),"Could not click Save button More Dateils"+searchData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + searchData.toString());
		}
		return returnValue;
	}
	
}
