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

public class VerifyDeleteManageCareAlerts extends AbstractClinicalList  {
	@Test(enabled=false)
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Delete ManageCare Alerts ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})*/
	public void deleteManageCareAlerts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ManageCareAlerts";
		alertData.testCaseId = "TC_MCA_002";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	/**
	 * Delete ManageCare Alerts
	 * function to verify delete  ManageCare Alerts
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 23, 2013
	 */

	public boolean createAlerts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib alertData) throws IOException{
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

			//---------------------------------------------------------- ----------//
			//  Step-2:Advanced search with Patient ID//
			//--------------------------------------------------------------------//

			searchPatientNexiaForProviderHomePage(selenium,alertData.patientID);
			waitForPageLoad(selenium);;
			
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
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify manage alerts
			//--------------------------------------------------------------------//
			
			assertTrue(verifyManageAlertsInsummary(selenium,alertData,userAccount),"Verify manage alerts Failed in Summary ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Delete manage alerts
			//--------------------------------------------------------------------//

			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteManageCareAlerts(selenium,alertData),"Delete manage alerts Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify manage alerts
			//--------------------------------------------------------------------//
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyDeleteManageAlertsInsummary(selenium,alertData,userAccount),"Verify  Delete manage alerts Failed in summary ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step8: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step9: Navigate to Medication Reconcillation Results //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAutomatedRecall),"Could not click on Automated Recallt link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPreview),"Could not click on link Preview", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Verify Medication Reconcillation in clinical lists
			//--------------------------------------------------------------------//
			
			assertTrue(verifyMedicationReconcillationResults(selenium,alertData,date),"Verify Medication Reconcillation Results in  clinical lists Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		return returnValue;
}		
		
	public boolean verifyManageAlertsInsummary(Selenium selenium,ClinicalListLib alertData,String userAccount) throws IOException{
		String date = null;
		
		if(userAccount.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.DATE,1); 
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MMM dd, yyyy");
		 	date=DateFormat1.format(cal.getTime());
	    }else {
				Calendar cal=Calendar.getInstance();
				cal.add(Calendar.DATE,1); 
				SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat1.format(cal.getTime());
		}
		
		assertTrue(getText(selenium,vfyManageAlertsInSummary).contains(date)," ",selenium,ClassName,MethodName);
			
		assertTrue(getText(selenium,vfyManageAlertsInSummary).contains("Medication Reconciliation")," ",selenium,ClassName,MethodName);
		
		assertTrue(click(selenium,lnkClosedArrow),"Could not click the expand arrow in summary", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,vfyExpandDetails).contains("No previous Medication Reconciliation performed")," ",selenium,ClassName,MethodName);
			
		return true;
	}
	
   public boolean verifyDeleteManageAlertsInsummary(Selenium selenium,ClinicalListLib alertData,String userAccount ) throws IOException{
	   waitForPageLoad(selenium);
	   String providerName = null;
	   String date =null;
	  
	   
	   if(userAccount.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MMM dd, yyyy");
		 	date=DateFormat1.format(cal.getTime());
	    }else {
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat1.format(cal.getTime());
		}
	   
	   	String providerNameTemp= getText(selenium, lnkTopMenu);
	   	
	   	alertData.switchRole = providerNameTemp.split(", ")[1];
	   	
		providerName= providerNameTemp.replaceAll(", "+alertData.switchRole, "");
		
		assertTrue(getText(selenium,vfyDeleteEManageAlertsInSummary).contains(date)," ",selenium,ClassName,MethodName);
		
		assertTrue(getText(selenium,vfyDeleteEManageAlertsInSummary).contains("Patient has been removed from this list")," ",selenium,ClassName,MethodName);
		
		assertTrue(getText(selenium,vfyDeleteEManageAlertsInSummary).contains(providerName)," ",selenium,ClassName,MethodName);

		
		assertTrue(getText(selenium,vfyDeleteEManageAlertsInSummary).contains(alertData.deleteReason)," ",selenium,ClassName,MethodName);
		
		return true;
	}
	
   public boolean  verifyMedicationReconcillationResults(Selenium selenium,ClinicalListLib alertData,String date ) throws IOException{
	   int counter=1; 
	   int count = (Integer) selenium.getXpathCount("//div[3]/table/tbody/tr/td/div/div");
		
		for (counter=1; counter<=count;counter++){
			assertTrue(!getText(selenium,"//div[3]/table/tbody/tr["+counter+"]/td/div/div").contains(alertData.lastName)," ",selenium,ClassName,MethodName);
				
		}
		return true;
	}
	
}
