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

public class CreateManageCareAlerts extends AbstractClinicalList  {
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for create ManageCare Alerts")
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
			
			//-------------------------------- ------------------------- ----------//
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
			
//			assertTrue(verifyManageAlertsInsummary(selenium,alertData,userAccount),"Verify manage alerts Failed",selenium,ClassName,MethodName);
//			waitForPageLoad(selenium);
			
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
			
			assertTrue(verifyMedicationReconcillationResults(selenium,alertData,date),"verify MedicationReconcillation Results Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		return returnValue;
}		
		
public boolean verifyManageAlertsInsummary(Selenium selenium,ClinicalListLib alertData,String userAccount ) throws IOException{
	
	String date = null;
	
//	if(userAccount.equals(CAAccount)){
//		Calendar cal=Calendar.getInstance();
//		cal.add(Calendar.DATE,1); 
//		SimpleDateFormat DateFormat1=new SimpleDateFormat("MMM d, yyyy");
//	 	date=DateFormat1.format(cal.getTime());
//    }else {
//			Calendar cal=Calendar.getInstance();
//			cal.add(Calendar.DATE,1); 
//			SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
//			date=DateFormat1.format(cal.getTime());
//	}
//
//	 if(!getText(selenium,vfyManageAlertsInSummary).contains(date)){
//			return false;
//		}
//		if(!getText(selenium,vfyManageAlertsInSummary).contains("Medication Reconciliation")){
//			return false;
//		}
//	
//		assertTrue(click(selenium,lnkClosedArrow),"Could not click the expand arrow in summary", selenium, ClassName, MethodName);
//		waitForPageLoad(selenium);
//		
//		if(!getText(selenium,vfyExpandDetails).contains("No previous Medication Reconciliation performed")){
//			return false;
//		}
		
		return true;
	}
	
   public boolean  verifyMedicationReconcillationResults(Selenium selenium,ClinicalListLib alertData,String date ) throws IOException{
	   boolean returnValue=true;
	   assertTrue(selenium.isTextPresent("Age is between 18 and 25 months(s) old and gender is all sexes who have not received all of the immunizations mentioned"), "" 	+ "Could not find the Automated Recall", selenium, ClassName, MethodName);
		
//       int counter=1; 
//	   int count = (Integer) selenium.getXpathCount("//div[3]/table/tbody/tr/td/div/div");
//	   waitForPageLoad(selenium);
//	
//	   for (counter=1; counter<=count;counter++){
//		        waitForPageLoad(selenium);
//		 		if(getText(selenium,"//div[3]/table/tbody/tr["+counter+"]/td/div/div").contains(alertData.lastName)){
//				if(getText(selenium,"//div[3]/table/tbody/tr["+counter+"]/td/div/div").trim().contains(date)){
//				returnValue = true;
//			}
//				returnValue = true;
//		}
//	   }
		return returnValue;
	}
	
}
