package com.nexia.selenium.testscripts.section.billing.batchstatement;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStatementInBillingHistory extends AbstractBilling {
		
	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for Verify Statement In Billing History")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyStatementInBillingHistory(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "BatchStatements";
		billingData.testCaseId = "TC_BS_009";
		billingData.fetchBillingTestData();
		verifyStatementInBillingHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }

	 /**
     *  To Verify Statement In Billing History
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
	 * @throws Exception 
     * @throwsIOException
     * @since Apr 15, 2014
     */
	

	public boolean verifyStatementInBillingHistory(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib billingData)throws Exception {
	    Selenium selenium = null;
	 
	    boolean returnValue = true;
	    try {
		    // --------------------------------------------------------------------//
		    // Step-1: Login to the application
		    // --------------------------------------------------------------------//
		   
		    selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		    Assert.assertNotNull(selenium, "Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
		    assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword), "Login Failed ", selenium,ClassName, MethodName);
		    
		     //Data Setup 
		    
		    // --------------------------------------------------------------------//
		    // Step-2:Create Unique patient
		    // --------------------------------------------------------------------//
			
		    HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NPC_025";
			PatientData.fetchHomeTestData();
			assertTrue(createNewPatient(selenium, PatientData),"Create Patient failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		    
			// --------------------------------------------------------------------//
		    // Step-3:Add a payer
		    // --------------------------------------------------------------------//
			
			HomeLib payerData = new HomeLib();
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_001";
			payerData.fetchHomeTestData();
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(addPayer(selenium, payerData,userAccount)," Add a payer failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
		    // Step-4:Post a charge for unique patient
		    // --------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnNexiaLogo),"Click Nexia Logo failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName,MethodName);
			 
			
			BillingLib chargeEntryData = new BillingLib();
			chargeEntryData.workSheetName = "ChargeEntry";
			chargeEntryData.testCaseId = "TC_CE_014";
			chargeEntryData.fetchBillingTestData();
						
			assertTrue(postCharge(selenium,PatientData, chargeEntryData,userAccount)," PostCharge for patient  failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
		    // --------------------------------------------------------------------//
		    // Step-5:Statement generation
		    // --------------------------------------------------------------------//
		   
			assertTrue(click(selenium,btnNexiaLogo),"Click not Nexia Logo failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName,MethodName);
			assertTrue(statmentTrigger(selenium, webSite),"Statment Trigger failed", selenium, ClassName,MethodName);
			
			//verifyStatementGenerated
			
			if(!verifyStatementGenerated(selenium,PatientData,billingData,userAccount)){
				System.out.println("Already statement has been generated");
				return true;
			}

			 // --------------------------------------------------------------------//
		    // Step-6: Go To Billing History
		   // --------------------------------------------------------------------//
			
			assertTrue(goToBillingHistory(selenium,billingData),"Navigation Failed ", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkStatementHistory),"Click not click link StatementHistory", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
		// --------------------------------------------------------------------//
		// Step-7: verify Statement In Billing History
		// --------------------------------------------------------------------//
			
			assertTrue(verifyStatementInBillingHistory(selenium,PatientData , chargeEntryData,userAccount),"Verify Statement In Billing History Failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
	     } catch (RuntimeException e) {
	     e.printStackTrace();
	     assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :" + e.getMessage() + "\n\t*)", selenium, ClassName, MethodName);
	}
	     
	return returnValue;
}

	public boolean createNewPatient(Selenium selenium, HomeLib patientData) throws Exception{
			boolean returnValue = true;
			try{				
				AbstractHomeTest CreatePatient = new AbstractHomeTest();
			    assertTrue(CreatePatient.createNewPatient_UnprintedStatements(selenium, patientData),"Create Patient failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
			}
			return returnValue;
		}
		
	public boolean addPayer(Selenium selenium, HomeLib payerData,String  userAccount) throws Exception{
		    String date =null;
			boolean returnValue = false;
			try{				
				AbstractHomeTest addPayerToPatient = new AbstractHomeTest();
				
				if(userAccount.equals(CAAccount)){
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
				  	date=DateFormat1.format(cal.getTime());
			    }else {
						Calendar cal=Calendar.getInstance();
						SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
						date=DateFormat1.format(cal.getTime());
				}
				assertTrue(addPayerToPatient.createEndToEndPayerList(selenium, payerData, date,userAccount)," Add a payer failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				returnValue = true;
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + payerData.toString());
			}
			return returnValue;
		}
	
public boolean verifyStatementInBillingHistory(Selenium selenium,HomeLib PatientData , BillingLib chargeEntryData,String  userAccount) throws Exception{
	    
		String date =null;
		boolean returnValue = false;
		try{	
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (userAccount.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			 date = DateFormat.format(cal.getTime());
			
			assertTrue(type(selenium, txtBlgStatementHistorySearch, PatientData.lastName),"Could not type patient name in statement search", selenium, ClassName,MethodName);
			selenium.clickAt(txtBlgStatementHistorySearch,"");
			selenium.focus(txtBlgStatementHistorySearch);			
			selenium.fireEvent(txtBlgStatementHistorySearch,"keypress");	
		
			String lblStatement = "xpath=//div[starts-with(@id,'statementData')]";
			
			if(((getText(selenium,lblStatement).contains(date)))&&(getText(selenium,lblStatement).contains(chargeEntryData.chargeAmount))){
				return true;
			}
			
			}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + chargeEntryData.toString());
		}
		return returnValue;
	}
	
public boolean postCharge(Selenium selenium,HomeLib PatientData , BillingLib chargeEntryData,String  userAccount) throws Exception{
	    
		String date =null;
		boolean returnValue = false;
		try{	
			
			// Navigate to  Patient
			
			assertTrue(type(selenium, txtPatientBox, PatientData.lastName),"Could not type patient last name", selenium, ClassName,MethodName);
			selenium.clickAt("searchPatientBox","");
			selenium.focus("searchPatientBox");			
			selenium.fireEvent("searchPatientBox","keypress");		
			waitForElement(selenium, lblPatientResult, 10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ PatientData.patientID, selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			selenium.mouseOver(lblPatientResult2);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			// Navigate to Post New charge
			
			assertTrue(click(selenium, lnkPostCharge),
					"Could not present Post charge link", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName,MethodName);
			 
			assertTrue(click(selenium, lnkPostNewCharge),
					"Could not click the Post new charge link", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		
			/*	assertTrue(goToPostNewCharge(selenium, chargeEntryData),"PostNewCharge failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);*/
			
			// Post New Charge for the patient
			
			assertTrue(savePostChargeEntry(selenium, chargeEntryData,userAccount)," Save Post New Charge Entry failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
			
			}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + chargeEntryData.toString());
		}
		return returnValue;
	}
	
	
}
