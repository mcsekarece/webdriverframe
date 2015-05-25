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

public class VerifyCancelOptionforCreateManageCareAlert extends AbstractClinicalList  {
	@Test(enabled=false)
/*	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Cancel Option for Create ManageCare Alert ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})*/
	public void verifyCancelOptionforCreateManageCareAlert(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ManageCareAlerts";
		alertData.testCaseId = "TC_MCA_005";
		alertData.fetchClinicalListTestData();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	/**
	 * Verify Cancel Option for Create ManageCare Alert
	 * function to Verify Cancel Option for Create ManageCare Alert
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 25, 2013
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
			//  Step-4: Verify Cancel Option //
			//--------------------------------------------------------------------//
					
			assertTrue(!isElementPresent(selenium,chkManageCare),"Verify Cancel Option for Create ManageCare Alert Failed",selenium,ClassName,MethodName);
     			 
		 	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		return returnValue;
}		
}
	
