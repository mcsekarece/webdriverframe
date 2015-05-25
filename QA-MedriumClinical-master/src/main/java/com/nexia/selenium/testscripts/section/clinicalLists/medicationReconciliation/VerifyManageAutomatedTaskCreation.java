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

public class VerifyManageAutomatedTaskCreation extends AbstractClinicalList  {
	@Test(enabled=false)
	/*
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify  Manage Automated Task Creation")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})*/
	public void createManageCareAlerts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ManageCareAlerts";
		alertData.testCaseId = "TC_MCA_007";
		alertData.fetchClinicalListTestData();
		manageAutomatedTaskCreation(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(enabled=false)
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify QuickList Manage Care Alerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})*/
	public void verifyQuickListManageCareAlerts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ManageCareAlerts";
		alertData.testCaseId = "TC_MCA_006";
		alertData.fetchClinicalListTestData();
		manageAutomatedTaskCreation(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	/**
	 * Verify  Manage Automated Task Creation
	 * function to Verify  Manage Automated Task Creation 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 26, 2013
	 */

	public boolean manageAutomatedTaskCreation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib alertData) throws IOException{
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
			//  Step-5: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Medication Reconciliation  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAutomatedRecall),"Could not click on Automated Recallt link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnEditRecall),"Could not click on link edit recall", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-7: Create Manage Automated Task Creation
			//--------------------------------------------------------------------//
			
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String providerName = null;
			alertData.switchRole = providerNameTemp.split(", ")[1];
			
			if(selenium.isTextPresent(alertData.switchRole)){
				providerName= providerNameTemp.replaceAll(", "+alertData.switchRole, "");
			}
			
			assertTrue(createManageAutomatedTask(selenium,alertData,date,providerName),"Create Manage Alert Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(alertData.testCaseId.equals("TC_MCA_006")){

				assertTrue(click(selenium,btnEditRecall),"Could not click on link edit recall", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(verifyQuickListManageAutomatedTaskCreation(selenium,alertData),"verify QuickList Manage Automated Task Creation Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				return true;
			}
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify Manage Automated Task Creation in clinical lists
			//--------------------------------------------------------------------//
			
			assertTrue(verifyManageAutomatedTaskCreation(selenium,alertData,date,providerName),"verify MedicationReconcillation Results Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		return returnValue;
}		
	
	public boolean  verifyManageAutomatedTaskCreation(Selenium selenium,ClinicalListLib alertData,String date,String providerName ) throws IOException{
			
		assertTrue(click(selenium,lnkClosedArrow),"Could not click the expand arrow in summary", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
			
		assertTrue(getText(selenium,lblAutomatedRecallListSummary).contains(providerName),"Provider name not present", selenium, ClassName, MethodName);
			
		assertTrue(getText(selenium,lblAutomatedRecallListSummary).contains(alertData.reason),"Reason not present", selenium, ClassName, MethodName);
		
			return true;
		}
	
	public boolean  verifyQuickListManageAutomatedTaskCreation(Selenium selenium,ClinicalListLib alertData) throws IOException{
		
		assertTrue(click(selenium,btnTaskName),"Could not click the quick list button", selenium, ClassName, MethodName);
		
		System.out.println(getText(selenium,vfyQuickList));
		assertTrue(getText(selenium,"//div[4]/div/div/div/div/div/div/span").contains(alertData.reason)," ", selenium, ClassName, MethodName);
			
			return true;
		}
}