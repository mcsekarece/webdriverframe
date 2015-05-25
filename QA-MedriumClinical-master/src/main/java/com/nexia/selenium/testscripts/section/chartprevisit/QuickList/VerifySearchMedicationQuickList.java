package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchMedicationQuickList extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
	 * @throws IOException 
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
			
			while((Integer) selenium.getXpathCount("//body/div[4]/div/div/div/div/div")>0){
				assertTrue(click(selenium,"link=Delete"),"Could not delete the QuickList value;More details:"+medicationData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnQuickMedication),"Could not click the QuickList button;More details:"+medicationData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnQuickMedication),"Could not click the QuickList button;More details:"+medicationData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			
			assertTrue(createMedication(selenium,medicationData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Quick List View //
			//--------------------------------------------------------------------//
			
			if(userAccount.equals(CAAccount)){
				type(selenium,ajxSearchMedication,medicationData.prescribeCa);
			}
			else{
				type(selenium,ajxSearchMedication,medicationData.prescribe);
			}
			
			assertTrue(click(selenium,btnQuickMedication),"Could not click the QuickList button;More details:"+medicationData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			int count=(Integer) selenium.getXpathCount("//div[5]/div/div/div/div/div/div/span");
			
			int counter=1;
			while(isElementPresent(selenium,"//div[4]/div/div/div/div/div"+counter+"/div/a")){
				
				counter++;
				
				if(counter>25){
					break;
				}
			}
			
			if(count==(counter-1)){
				return returnValue;
			}
			else{
				Assert.fail("Search quicklist failied");
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			
		}
		return returnValue;
	}
	
}