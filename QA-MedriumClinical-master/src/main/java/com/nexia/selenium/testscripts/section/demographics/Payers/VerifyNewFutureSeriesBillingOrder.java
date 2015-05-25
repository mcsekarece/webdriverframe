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

public class VerifyNewFutureSeriesBillingOrder  extends AbstractHomeTest {


	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify NewSeries For Billing Order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNewSeriesForBillingOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_001";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChangeBillingOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        VerifyNewSeriesForBillingOrder
	* @action 		  Test for  Verify NewSeries For BillingOrder
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
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();
			assertTrue(createPatientMandatory(selenium,patientData),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
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
			payerData.testCaseId = "TC_CP_010";
			payerData.fetchHomeTestData();
			
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:  Create the Expired Series //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnChangeBillingOrder), "Could not click change billing order button", selenium, ClassName, MethodName);//CA
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSaveWithNewDates), "Could not click save with NewDates  button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			
			
			//--------------------------------------------------------------------//
			//  Step-7:  Verify the Expired Series //
			//--------------------------------------------------------------------//
			
			assertTrue(verifyNewFutureSeries(selenium, payerData,date,userAccount), "verify Expired Series failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
public boolean verifyNewFutureSeries(Selenium selenium,HomeLib payerData,String date,String account) throws IOException{

	assertTrue(enterDate(selenium,txtPayerStartDate,payerData.newSeriesStartDate ), "Could not enter new series start date", selenium, ClassName, MethodName);
	selenium.keyPress(txtPayerStartDate, "\\13");
	selenium.keyPress(txtPayerStartDate, "\\13");
	selenium.click(txtPayerNewSeriesEndDate);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);

	assertTrue(click(selenium, btnlnkNewDateSave), "Could not click Save button ", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	System.out.println(getText(selenium,vfyCurrentPayerDetails));
	assertTrue(getText(selenium,vfyCurrentPayerDetails1).contains("Current payers"),"Could not get text", selenium, ClassName, MethodName);
	//assertTrue(getText(selenium,vfyCurrentPayerDetails).contains(payerData.newSeriesStartDate),"Could not get text", selenium, ClassName, MethodName);
	assertTrue(getText(selenium,vfyFirstPayer).contains(payerData.payerName),"Could not get text", selenium, ClassName, MethodName);
	payerData.workSheetName = "AddPayers";
	payerData.testCaseId = "TC_CP_001";
	payerData.fetchHomeTestData();
	assertTrue(getText(selenium,vfyFirstPayer).contains(payerData.payerName),"Could not get text", selenium, ClassName, MethodName);
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
	  	System.out.println(getText(selenium,vfyFirstPayer));
		assertTrue(getText(selenium,vfyFirstPayer).contains(date),"Could not get text", selenium, ClassName, MethodName);
   		}else {
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat1.format(cal.getTime());
			System.out.println(getText(selenium,vfyExpiredSeries));
			assertTrue(getText(selenium,vfyExpiredSeries).contains(date),"Could not get text", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,vfyExpiredSeries).contains(payerData.defaultEndDateUS),"Could not get text", selenium, ClassName, MethodName);
   		}
		return true;
	}

}

