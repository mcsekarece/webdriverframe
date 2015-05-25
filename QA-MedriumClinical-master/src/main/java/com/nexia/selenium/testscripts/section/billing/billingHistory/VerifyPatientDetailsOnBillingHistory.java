package com.nexia.selenium.testscripts.section.billing.billingHistory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientDetailsOnBillingHistory extends AbstractBilling {
    @Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Fee Schedule")
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingHistoryPatientDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "BillingHistory";
		billingData.testCaseId = "TC_BH_001";
		billingData.fetchBillingTestData();
		verifyBillingHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    
    @Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Fee Schedule")
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingInformation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "BillingHistory";
		billingData.testCaseId = "TC_BH_002";
		billingData.fetchBillingTestData();
		verifyBillingHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	/**
	 * verifyBillingHistory
	 * function to verify Billing History
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      	IOException 
	 * @since  	   	Jan 24, 2014
	 */
	
	public boolean verifyBillingHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Billing History //
			//--------------------------------------------------------------------//
			HomeLib patientData=new HomeLib();
			if(!billingData.testCaseId.equals("TC_BH_002")){
				patientData.workSheetName = "PatientData";
				patientData.testCaseId="TC_NPC_001";
				patientData.fetchHomeTestData();
				String date=null;
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());
				patientData.lastName=patientData.lastName+date;
				assertTrue(click(selenium,lnkQuickAction),"Could not click on System settings link:" + patientData .toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+patientData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(createNewPatientWithMandatoryCAView(selenium, patientData, userAccount),"", selenium, ClassName, MethodName);
				billingData.patientID=patientData.lastName;
			}
			assertTrue(goToBillingHistory(selenium,billingData),"Navigation Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify Billing History Screen//
			//--------------------------------------------------------------------//
		
			if(billingData.testCaseId.equals("TC_BH_002")){
			    assertTrue(verifyBillingInformation(selenium,userAccount),"Navigation Failed ", selenium, ClassName, MethodName);
			}
			else{
			    assertTrue(verifyPatientInfo(selenium,patientData),"Navigation Failed ", selenium, ClassName, MethodName);
			}
					
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}