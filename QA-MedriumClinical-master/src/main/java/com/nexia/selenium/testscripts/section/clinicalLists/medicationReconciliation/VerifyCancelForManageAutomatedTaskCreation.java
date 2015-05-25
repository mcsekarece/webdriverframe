package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelForManageAutomatedTaskCreation extends AbstractClinicalList  {
	@Test(enabled=false)
//	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Cancel for Manage Automated Task Creation")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelForManageAutomatedTaskCreation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ManageCareAlerts";
		alertData.testCaseId = "TC_MCA_008"; 
		alertData.fetchClinicalListTestData();
		manageAutomatedTaskCreation(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	/**
	 * Verify Cancel For Manage Automated Task Creation
	 * function to Verify Cancel For Manage Automated Task Creation
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 28, 2013
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
	
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Medication Reconciliation  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAutomatedRecall),"Could not click on Automated Recallt link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnEditRecall),"Could not click on link edit recall", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-4: Create Manage Automated Task Creation
			//--------------------------------------------------------------------//
			
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String providerName = null;
			
			alertData.switchRole = providerNameTemp.split(", ")[1];
			
			if(selenium.isTextPresent(alertData.switchRole)){
				providerName= providerNameTemp.replaceAll(", "+alertData.switchRole, "");
			}
			
			assertTrue(createManageAutomatedTask(selenium,alertData,date,providerName),"Create Manage Alert Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Cancel  Manage Automated Task Creation
			//--------------------------------------------------------------------//
						
			assertTrue(click(selenium,lnkClosedArrow),"Could not click the expand arrow in summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
			assertTrue(!getText(selenium,lblAutomatedRecallListSummary).contains(alertData.reason),"Verify Cancel For Manage Automated Task Creation failed", selenium, ClassName, MethodName);
				
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		return returnValue;
}	
}
	