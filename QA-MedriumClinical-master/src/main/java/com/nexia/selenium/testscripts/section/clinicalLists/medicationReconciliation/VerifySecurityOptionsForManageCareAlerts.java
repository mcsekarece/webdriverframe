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

public class VerifySecurityOptionsForManageCareAlerts extends AbstractClinicalList {
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
//	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "VerifySecurityOption";
		alertData.testCaseId = "TC_VSP_002";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}@Test(enabled=false)
	
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
	}@Test(enabled=false)
	
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
	* @purpose        To verify Securtiy option for Manage Care Alerts 
	* @action 		  verify Securtiy option for Manage Care Alerts 
	* @expected       To Ensure that the Securtiy option for Manage Care Alerts 
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 24, 2013
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
			
			
			if(alertData.testCaseId.equals("TC_VSP_001")){
				assertTrue(verifySecurity(selenium,alertData,date), "Security option not show properly for Manage Care Alerts; More Details :", selenium, ClassName, MethodName);

				/*if(!verifySecurity(selenium,alertData,date)){
					Assert.fail("Security option not show properly for Manage Care Alerts; More Details :"+ alertData.toString());
				}else
					return true;*/
			}
			
			
			if(alertData.testCaseId.equals("TC_VSP_004")||alertData.testCaseId.equals("TC_VSP_003")){
			
				assertTrue(switchRole(selenium,alertData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(alertData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(searchPatientNexiaNoAccess(selenium,alertData.patientId),"Could search patient", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
	
				return returnValue;
				}
			
			}

			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//

			if(!alertData.testCaseId.equals("TC_VSP_002")){
				searchPatientNexiaForProviderHomePage(selenium,alertData.patientId);
				waitForPageLoad(selenium);
				assertTrue(verifySecurity(selenium,alertData,date), "Security option not show properly for Manage Care Alerts; More Details :", selenium, ClassName, MethodName);

				/*if(!verifySecurity(selenium,alertData,date)){
				Assert.fail("Security option not show properly for Manage Care Alerts; More Details :"+ alertData.toString());
				}else
				returnValue=true;*/
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
			
			
			//--------------------------------------------------------------------//
			//  Step-1: change the switch role to FULL Access //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,alertSecData.role), "Could not switch the role to limited Access", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Search Patient  //
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,alertSecData.patientID);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to ManageCare Alerts //
			//--------------------------------------------------------------------//
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: create ManageCare Alerts //
			//--------------------------------------------------------------------//
			assertTrue(createManageCareAlerts(selenium,alertSecData,date),"Create Manage Alert Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium, btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: change the switch role to Limited Access //
			//--------------------------------------------------------------------//
			ClinicalListLib alertsData = new ClinicalListLib();
			alertsData.workSheetName = "VerifySecurityOption";
			alertsData.testCaseId = "TC_VSP_001";
			alertsData.fetchClinicalListTestData();
			
			assertTrue(switchRole(selenium,alertsData.switchRole), "Could not switch the role to limited Access", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify  Edit Access
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,alertSecData.patientID);
			waitForPageLoad(selenium);
			
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			ClinicalListLib alertEditData = new ClinicalListLib();
			alertEditData.workSheetName = "ManageCareAlerts";
			alertEditData.testCaseId = "TC_MCA_001";
			alertEditData.fetchClinicalListTestData();
			
			assertTrue(createManageCareAlerts(selenium,alertEditData,alertEditData.editDate),"Create Manage Alert Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Add and Remove Access 
			//--------------------------------------------------------------------//
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(!selenium.isEditable(chkManageCare),"failed",selenium,ClassName,MethodName);

			
		/*	if(selenium.isEditable(chkManageCare)){
				return false;
			}else{
				return true;
			}*/
			
		}
		
	
		// Full Access
		
		if(alertData.testCaseId.equals("TC_VSP_004")){

			ClinicalListLib alertSecData = new ClinicalListLib();
			alertSecData.workSheetName = "ManageCareAlerts";
			alertSecData.testCaseId = "TC_MCA_002";
			alertSecData.fetchClinicalListTestData();
			
			//--------------------------------------------------------------------//
			//  Step-1: Navigate to ManageCare Alerts //
			//--------------------------------------------------------------------//
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: create ManageCare Alerts //
			//--------------------------------------------------------------------//
		
			assertTrue(createManageCareAlerts(selenium,alertSecData,date),"Create Manage Alert Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Verify  Edit Access
			//--------------------------------------------------------------------//
			
			ClinicalListLib alertEditData = new ClinicalListLib();
			alertEditData.workSheetName = "ManageCareAlerts";
			alertEditData.testCaseId = "TC_MCA_001";
			alertEditData.fetchClinicalListTestData();
			
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createManageCareAlerts(selenium,alertEditData,alertEditData.editDate),"Create Manage Alert Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-4: Verify  Delete manage alerts access
			//--------------------------------------------------------------------//
			
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteManageCareAlerts(selenium,alertEditData),"Verify delete manage alerts Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
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
			
			assertTrue(switchRole(selenium,alertsData.switchRole), "Could notswitch role to View Only Access", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			
			//---------------------------------------------------------- ----------//
			//  Step-4:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
		
			searchPatientNexiaForProviderHomePage(selenium,alertCreateData.patientID);
			waitForPageLoad(selenium); 
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify  Navigate to ManageCare Alerts //
			//--------------------------------------------------------------------//
			
			assertTrue(isElementPresent(selenium,lnkPatientOption),"Could not find patiet option  link",selenium,ClassName,MethodName);
			assertTrue(click(selenium,lnkPatientOption),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkManageCare),"Could not find tlnkManageCare link",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-5: Verify  ManageCare Alerts //
			//--------------------------------------------------------------------//
			
			assertTrue(getText(selenium,vfyManageAlertsInSummary).contains(date),"Date not present",selenium,ClassName,MethodName);
				
			assertTrue(getText(selenium,vfyManageAlertsInSummary).contains("Medication Reconciliation")," ",selenium,ClassName,MethodName);
				
			
			assertTrue(click(selenium,lnkClosedArrow),"Could not click the expand arrow in summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,vfyExpandDetails).contains("No previous Medication Reconciliation performed"),"not present",selenium,ClassName,MethodName);
				
			return true;
		}
}
