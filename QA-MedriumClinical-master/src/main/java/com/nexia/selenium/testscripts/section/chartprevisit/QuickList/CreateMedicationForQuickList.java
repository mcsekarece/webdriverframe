/*************************************************************************************************** 
* @purpose 			This testcase Verification the Quick list save functionality for Medications
* @Specification 	Medical Summary - Save to QUICK LIST - Fields to be saved - Medications 
* @action 			Added the "Yes" fields values for the Medications and then save to Quick List   
* @expected  		On Clicking the Quick list button the "Yes" field value should show up
* 
* @author        AspireQA
* @state        Developing
* @useraccount  Canada and US
***************************************************************************************************/

package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateMedicationForQuickList extends AbstractChartPreVisit {
	
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createMedicationForQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib  medicationData = new ChartPreVisitLib();
		 medicationData.workSheetName = "CreateMedication";
		 medicationData.testCaseId = "TC_QLM_001";
		 medicationData.fetchChartPreVisitTestData();
		 ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		 quickListCheckForMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createMedicationAsFreeTextForQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib  medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_QLM_002";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		quickListCheckForMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify added quick list medication and details is displayed
	* @Specification  SRS_EMR_Med_Summary_Procedures_Rev0.0
	* @action 		  verifying added quick list medication and details is displayed
	* @expected       After add the medication and details, When click the quick list, It should shows the added medication and details
	* @author         Aspire QA
	* @throws        IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      March 21, 2013
	***************************************************************************************************/
	
	public boolean quickListCheckForMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Medication //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkMedication),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed",selenium,ClassName,MethodName);
			
			assertTrue(click(selenium,btnQuickMedication),"Could not click the QuickList button;More details:"+medicationData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			while(isElementPresent(selenium, lnkPrescribeDelete1)){
				assertTrue(click(selenium,lnkPrescribeDelete1),"Could not delete the QuickList value;More details:"+medicationData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnQuickMedication),"Could not click the QuickList button;More details:"+medicationData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnSaveMedication),"Could not click the Save button;More details:"+medicationData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedication),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			//This blog is used for turn off quick list, If it is on..
			String buttonState=selenium.getAttribute("//button[@id='medicationQuickListButton']/@class");
			if(!(buttonState.equalsIgnoreCase("quick-list-button gradient"))){
				assertTrue(click(selenium,btnQuickMedication),"Could not click the QuickList button;More details:"+medicationData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(createMedication(selenium,medicationData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Quick List View //
			//--------------------------------------------------------------------//
		    assertTrue(verifyQuickListViewForMedication(selenium, medicationData,userAccount),"Verify QuickListView Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnCancel),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,"Mathewaaf");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Delete Medication //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkMedication),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Quick List View //
			//--------------------------------------------------------------------//
		    assertTrue(verifyQuickListViewForMedication(selenium, medicationData,userAccount),"Verify QuickListView Failed",selenium,ClassName,MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			
		}
		return returnValue;
	}
	
}
