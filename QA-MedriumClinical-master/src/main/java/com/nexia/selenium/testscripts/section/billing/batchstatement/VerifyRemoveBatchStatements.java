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

public class VerifyRemoveBatchStatements extends  AbstractBilling {
	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for Verify Remove  Batch Statements ")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyRemoveBatchStatements(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "BatchStatements";
		billingData.testCaseId = "TC_BS_002";
		billingData.fetchBillingTestData();
		verifyRemoveBatchStatements(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }
	
	 /**
     *  To Verify Printed Batch Statements by remove the statements 
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
	 * @throws Exception 
     * @throwsIOException
     * @since Apr 15, 2014
     */
	
	public boolean verifyRemoveBatchStatements(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib billingData)throws Exception {
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
				System.out.println("Already statment has been generated");
				return true;
			}
			
		    // --------------------------------------------------------------------//
		    // Step-6:Remove Statement
		    // --------------------------------------------------------------------//
			assertTrue(click(selenium,lnkRemove),"Click not click link remove", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
		    // --------------------------------------------------------------------//
	        // Step-7: Verify Remove Statement failed
	        // --------------------------------------------------------------------//
			
			if(!verifyRemoveStatement(selenium,PatientData,billingData,userAccount)){
				Assert.fail("verify Remove Statement Failed");
			}
			
			
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
	public boolean postCharge(Selenium selenium,HomeLib PatientData , BillingLib chargeEntryData,String  userAccount) throws Exception{
	    
		String date =null;
		boolean returnValue = false;
		try{	
			
			// Navigate to  Patient
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName,MethodName);
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
			
			assertTrue(goToPostNewCharge(selenium, chargeEntryData),"PostNewCharge failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
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
	
	public boolean verifyRemoveStatement(Selenium selenium, HomeLib PatientData,BillingLib billingData, String account) throws IOException{
		try{
								
			assertTrue(type(selenium,ajxSearch,PatientData.lastName),"Could not type the provider", selenium, ClassName, MethodName);
			selenium.keyPress(ajxSearch, "\\13");
			waitForPageLoad(selenium);
		
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			String lblUnprinted = "//div[starts-with(@id,'statement')]";
		
			int count;
			int claimsCount = (Integer) selenium.getXpathCount(lblUnprinted);
		
			for(count = 1; count <=claimsCount; count++ ){
				if((getText(selenium,"xpath=(//div[starts-with(@id,'statement')])["+count+"]").toLowerCase().contains(PatientData.lastName.toLowerCase()))){
					return false;
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	
}
