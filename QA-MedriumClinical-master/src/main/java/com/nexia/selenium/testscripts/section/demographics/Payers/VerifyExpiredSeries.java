package com.nexia.selenium.testscripts.section.demographics.Payers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyExpiredSeries extends AbstractHomeTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify ExpiredSeries WithoutEndDate")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExpiredSeriesWithoutEndDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_009";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChangeBillingOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        VerifyExpiredSeries
	* @action 		  Test for  Verify Expired Series
	* @author         Aspire QA
	 * @throws Exception 
	 * @state          Developing
	* @useraccount    Both
	* @since  	      Oct 01, 2013
	***************************************************************************************************/
	
	public boolean ChangeBillingOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws Exception{
		Selenium selenium=null;
		String date =null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + payerData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, payerData.userName, payerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                         //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,payerData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-2:Search Patient //
			//--------------------------------------------------------------------//
			assertTrue(navigateToNewPatientRegistration(selenium),"unable to navigate to patient registration page",selenium,ClassName,MethodName);
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();
			assertTrue(createPatientMandatory(selenium,patientData),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Payers //
			//--------------------------------------------------------------------//
		
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllPayers(selenium),"Delete All Payers failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium); 	
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			//--------------------------------------------------------------------//
			//  Step-6: Create another Payers //
			//--------------------------------------------------------------------//

				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_039";
				payerData.fetchHomeTestData();
			
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:  Create the Expired Series //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnChangeBillingOrder), "Could not click change billing order button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSaveWithNewDates), "Could not click save with NewDates  button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium,txtPayerStartDate,payerData.newSeriesStartDate ), "Could not enter new series start date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    assertTrue(click(selenium, btnlnkNewDateSave), "Could not click Save button ", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:  Verify the Expired Series //
			//--------------------------------------------------------------------//
		
			 assertTrue(verifyExpiredSeries(selenium, payerData,userAccount), "verify Expired Series failed", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
public boolean verifyExpiredSeries(Selenium selenium,  HomeLib payerData,String account) throws IOException{
		
    String date =null;
	if(account.equals(CAAccount)){
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
		date=DateFormat.format(cal.getTime());
		System.out.println(date);
		int date1=Integer.parseInt(date);
         
		if(date1<10){
		SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
		date=DateForma1t.format(cal.getTime());
		}else{
		SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
		date=DateFormat2.format(cal.getTime());
		}
	  	System.out.println(date);
	  	System.out.println(getText(selenium,vfyCurrentPayerDetails1));
		assertTrue(getText(selenium,vfyCurrentPayerDetails1).contains(date),"Could not get effective date", selenium, ClassName, MethodName);
    }else {
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat1.format(cal.getTime());
			System.out.println(getText(selenium,vfyCurrentPayerDetails1));
			assertTrue(getText(selenium,vfyCurrentPayerDetails1).contains(date),"Could not get text", selenium, ClassName, MethodName);
	}
	
	// Verify Current Series

	assertTrue(getText(selenium,vfyCurrentPayerDetails1).contains("Current payers"),"Could not get text", selenium, ClassName, MethodName);
	
	// Expired Sereis
	
	System.out.println(getText(selenium,vfyEndDateExpiredSeries1));
	assertTrue(getText(selenium,vfyEndDateExpiredSeries1).contains("Expired Series"),"Could not get text", selenium, ClassName, MethodName);
   // assertTrue(getText(selenium,vfyExpiredSeries4).contains(payerData.newSeriesStartDate),"Could not get text", selenium, ClassName, MethodName);
   
    if(account.equals(CAAccount)){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
		date=DateFormat.format(cal.getTime());
		System.out.println(date);
		int date1=Integer.parseInt(date);
         
		if(date1<10){
		SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
		date=DateForma1t.format(cal.getTime());
		}else{
		SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");

		date=DateFormat2.format(cal.getTime());
		}
	  	System.out.println(date);
	  	System.out.println(getText(selenium,vfyEndDateExpiredSeries1));
		assertTrue(getText(selenium,vfyEndDateExpiredSeries1).contains("May 5, 2013"),"Could not get text", selenium, ClassName, MethodName);
    }else {
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat1.format(cal.getTime());
			System.out.println(getText(selenium,vfyExpiredSeries4));
			assertTrue(getText(selenium,vfyExpiredSeries4).contains(date),"Could not get text", selenium, ClassName, MethodName);
	}
    assertTrue(click(selenium, vfyEndDateExpiredSeries1), "Could not click Expired Details button ", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	selenium.focus(vfyEndDateExpiredSeries1);
	selenium.clickAt(vfyEndDateExpiredSeries1, "");
	selenium.keyPress(vfyEndDateExpiredSeries1, "\\13");
	assertTrue(!getText(selenium,vfyEndDateExpiredSeries1).contains(payerData.payerName),"Could not get text", selenium, ClassName, MethodName);
	payerData.workSheetName = "AddPayers";
	payerData.testCaseId = "TC_CP_009";
	payerData.fetchHomeTestData();
	
   assertTrue(getText(selenium,vfyMedPayer).contains(payerData.payerName),"Could not get text", selenium, ClassName, MethodName);
		return true;
}
	
}
