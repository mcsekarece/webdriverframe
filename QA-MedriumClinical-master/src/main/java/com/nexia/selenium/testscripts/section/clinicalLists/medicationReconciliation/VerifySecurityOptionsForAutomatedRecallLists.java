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

public class VerifySecurityOptionsForAutomatedRecallLists extends AbstractClinicalList {
	@Test(enabled=false)
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})*/
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "VerifySecurityOption";
		alertData.testCaseId = "TC_VSP_001";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(enabled=false)
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})*/
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "VerifySecurityOption";
		alertData.testCaseId = "TC_VSP_002";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(enabled=false)
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})*/
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "VerifySecurityOption";
		alertData.testCaseId = "TC_VSP_003";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	@Test(enabled=false)
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})*/
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "VerifySecurityOption";
		alertData.testCaseId = "TC_VSP_004";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Security Options For AutomatedRecall Lists
	* @action 		 Verify Security Options For AutomatedRecall Lists
	* @expected       To Ensure that Security Options For AutomatedRecall Lists
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 26, 2013
	***************************************************************************************************/

	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib alertData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date = null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + alertData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, alertData.userName, alertData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
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
			
			if(alertData.testCaseId.equals("TC_VSP_004")||alertData.testCaseId.equals("TC_VSP_003")){
			
				assertTrue(switchRole(selenium,alertData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(alertData.testCaseId.equals("TC_VSP_003")){
					
				assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!isElementPresent(selenium,lnkClinicalLists),"Clinical lists button is available",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
	
				return returnValue;
				}
			
			}

			//---------------------------------------------------------- ----------//
			//  Step-3:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
		
			
		
			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//
			
			
			if(!alertData.testCaseId.equals("TC_VSP_002")){
				searchPatientNexiaForProviderHomePage(selenium,alertData.patientId);
				waitForPageLoad(selenium);
				assertTrue(verifySecurity(selenium,alertData,date), "Security option not show properly for Manage Care Alerts; More Details :", selenium, ClassName, MethodName);

			}else{
			
			assertTrue(verifySecurityForViewOnly(selenium,alertData,date), "Security option not show properly for Manage Care Alerts; More Details :", selenium, ClassName, MethodName);
        	waitForPageLoad(selenium);
			  
		  }
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
public boolean verifySecurity(Selenium selenium,ClinicalListLib alertData,String date) throws IOException{
		
		// Limited Access
		
		if(alertData.testCaseId.equals("TC_VSP_001")){	
			
			ClinicalListLib alertSecData = new ClinicalListLib();
			alertSecData.workSheetName = "ManageCareAlerts";
			alertSecData.testCaseId = "TC_MCA_002";
			alertSecData.fetchClinicalListTestData();
	/*		
			//--------------------------------------------------------------------//
			//  Step-1: Navigate to ManageCare Alerts //
			//--------------------------------------------------------------------//
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: create ManageCare Alerts //
			//--------------------------------------------------------------------//
			assertTrue(createManageCareAlerts(selenium,alertSecData,date),"Create Manage Alert Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-3: change the switch role to Limited Access //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,alertData.switchRole), "Could not switch the role to limited Access", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Medication Reconciliation Results //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAutomatedRecall),"Could not click on Automated Recallt link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,btnEditRecall),"Edit button is available",selenium,ClassName,MethodName);
			
			assertTrue(click(selenium,lnkPreview),"Could not click on link Preview", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify search fields //
			//--------------------------------------------------------------------//
			
			assertTrue(selectValueFromAjaxList(selenium,ajxFirstCriteria,"Patient"), "Could not type FirstCriteria", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxSecondCriteria,"Patient"), "Could not type Second Criteria", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnCancelId),"Cancel button is not available",selenium,ClassName,MethodName);
				
		}
		
	
		// Full Access
		
		if(alertData.testCaseId.equals("TC_VSP_004")){

		
		}
		
		return true;
	}
		
        public boolean verifySecurityForViewOnly(Selenium selenium,ClinicalListLib alertData,String date) throws IOException{
			
        	ClinicalListLib alertCreateData = new ClinicalListLib();
			alertCreateData.workSheetName = "ManageCareAlerts";
			alertCreateData.testCaseId = "TC_MCA_001";
			alertCreateData.fetchClinicalListTestData();
			
			//--------------------------------------------------------------------//
			//  Step-1: change the switch role to full //
			//--------------------------------------------------------------------//
		
			assertTrue(switchRole(selenium,alertCreateData.role), "Could not switch the role to View only Access", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
        	
			
			searchPatientNexiaForProviderHomePage(selenium,alertCreateData.patientID);
			waitForPageLoad(selenium);
        	//--------------------------------------------------------------------//
			//  Step-1: Navigate to ManageCare Alerts //
			//--------------------------------------------------------------------//
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: create ManageCare Alerts //
			//--------------------------------------------------------------------//
			assertTrue(createManageCareAlerts(selenium,alertCreateData,date),"Create Manage Alert Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: change the switch role to View Only Access //
			//--------------------------------------------------------------------//
			ClinicalListLib alertsData = new ClinicalListLib();
			alertsData.workSheetName = "VerifySecurityOption";
			alertsData.testCaseId = "TC_VSP_002";
			alertsData.fetchClinicalListTestData();
			
			assertTrue(switchRole(selenium,alertsData.switchRole), "Could not switch the role to View only Access", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			searchPatientNexiaForProviderHomePage(selenium,alertCreateData.patientID);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Medication Reconciliation Results //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAutomatedRecall),"Could not click on Automated Recallt link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!isElementPresent(selenium,btnEditRecall),"Edit button is available",selenium,ClassName,MethodName);
			
			assertTrue(click(selenium,lnkPreview),"Could not click on link Preview", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify search fields //
			//--------------------------------------------------------------------//
			
			assertTrue(selectValueFromAjaxList(selenium,ajxFirstCriteria,"Patient"), "Could not type FirstCriteria", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxSecondCriteria,"Patient"), "Could not type Second Criteria", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnCancelId),"Cancel button is not available",selenium,ClassName,MethodName);
			
			return true;
		}


}
