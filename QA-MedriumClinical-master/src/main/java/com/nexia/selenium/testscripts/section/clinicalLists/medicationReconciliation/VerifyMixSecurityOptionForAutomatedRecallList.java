package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForAutomatedRecallList extends AbstractClinicalList {

	@Test(enabled=false)/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Mixed security role")
	@Parameters({"seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})*/
	public void verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	ClinicalListLib caseData = new ClinicalListLib();
	caseData.workSheetName = "VerifySecurityOption";
	caseData.testCaseId = "TC_VSP_006";
	
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	caseData.fetchClinicalListTestData();
		
	verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		IOException 
	 * @since  	   	Nov 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,cdsData.switchRole),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_022";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.clinicalPatientList.contains("No Access")){				
			    assertTrue(noAccessUserClinicalList(selenium, cdsData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);				
			}			
			
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 							//
			//--------------------------------------------------------------------//
			
			if(!userRoleData.clinicalLists.contains("No Access")){
			    assertTrue(fullViewAccessUserClinicalList(selenium, cdsData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;				
			    assertTrue(verifySecurity(selenium,cdsData, userRoleData, userAccount),"Security option not show properly; More Details :"+ cdsData.toString(), selenium, ClassName, MethodName);				

			   /* if(!verifySecurity(selenium,cdsData, userRoleData, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ cdsData.toString());
				returnValue= false;
			    }else
				returnValue=true;*/
			}			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,ClinicalListLib cdsData,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;
		String date="";
		assertTrue(switchRole(selenium,"FULL"),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "VerifySecurityOption";
		alertData.testCaseId = "TC_VSP_001";
		alertData.fetchClinicalListTestData();
		
		searchPatientNexiaForProviderHomePage(selenium,alertData.patientId);
		waitForPageLoad(selenium);
		
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
		assertTrue(createManageCareAlerts(selenium,alertSecData,date),"Create Manage Alert Failed",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3: change the switch role to Limited Access //
		//--------------------------------------------------------------------//
		if(!waitForElement(selenium, lnkTopMenu, WAIT_TIME*3)){
			Assert.fail(" Top Menu Header not opened More Details; switchRole ");
		}
		click(selenium,lnkTopMenu);
		click(selenium,lnkSwitchrole);
		selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]","DFClinicalLists");
		click(selenium,ajxOption);
		click(selenium,"//div[7]/div/div/div/div/div");
		
		click(selenium,"//body/div[7]/div/div/div/div/div");
		click(selenium,ajxdeleteReason);
		waitForPageLoad(selenium);
		
		/*assertTrue(switchRole(selenium,"DFClinicalLists"), "Could not switch the role to limited Access", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);*/
		
		
		
		//Full Access Permission	
		if(userRoleData.clinicalPatientList.contains("Full Access")){
		    	
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
	
		//View Only Access Permission
		if(userRoleData.clinicalPatientList.contains("View Only")){
		    	
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
		  
		}
		 
		//Limited Access Permission
		if(userRoleData.clinicalPatientList.contains("Limited Access")){

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
		
		//No Access Permission
		if(userRoleData.clinicalPatientList.contains("No Access")){
		    assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists), "Could not click on Clinical settings",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!automatedRecallList"), "Could not click on Clinical settings",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,lblHeader).contains("Automated Recall Lists")," ",selenium,ClassName,MethodName);
			    
		}
		
		return returnValue;
	}

}
