package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures.AssociatedPayer;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDoNotBillStatus  extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Do not bill a Associate Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void doNotBillClaimsPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_009";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDoNotBillClaim(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	/**
	 * verifyDoNotBillCliam
	 * function to verify Do Not Bill Cliam
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @since  	    Feb 22, 2014
	 */
	public boolean verifyDoNotBillClaim(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		
		Selenium selenium=null;
		boolean returnValue=false;
		String date = null;
		String patientName = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to Provider //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			
			assertTrue(gotoSystemSetting(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProviderWithMandatory(selenium,providerData),"Provider creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtProFirstName,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Search Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnSearchOrg2),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Add Assoociate Payer //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAddAssociatePayer),"Could not click the Add Associate Payer Link"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Search Payer //
			//--------------------------------------------------------------------//
			SystemSettingsLib providerPayerData = new SystemSettingsLib();
			providerPayerData.workSheetName = "PortAddPayers";
			providerPayerData.testCaseId = "TC_AP_001";
			providerPayerData.fetchSystemSettingTestData();
			
			assertTrue(addPayer(selenium,providerPayerData,providerData ),"Could not add the Payer", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Search any Patient//
			//--------------------------------------------------------------------//
			AbstractHomeTest payerList = new AbstractHomeTest();
			HomeLib payerData = new HomeLib();
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_001";
			payerData.fetchHomeTestData();
			
			assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Navigate to Payers //
			//--------------------------------------------------------------------//
			patientName = getText(selenium,lblpatientName);
			waitForPageLoad(selenium);
			payerData.patientID = patientName;
			
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-11: Delete all Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(payerList.deleteAllPayers(selenium),"Delete All Payers failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium); 	
			
			//--------------------------------------------------------------------//
			//  Step-12: Create Payers //
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat1.format(cal.getTime());
			}
			
			assertTrue(payerList.addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			
			//--------------------------------------------------------------------//
			//  Step-13: Navigate to Charge entry //
			//--------------------------------------------------------------------//
			AbstractBilling billingData = new AbstractBilling();
			BillingLib postChargeEntry = new BillingLib();
			postChargeEntry.workSheetName = "PostChargePortablity";
			postChargeEntry.testCaseId = "TC_PCP_024";
			postChargeEntry.fetchBillingTestData();
			
			assertTrue(billingData.navigateToPatient(selenium,postChargeEntry),"Could not search the patient", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-14: Go To New Charge
			// --------------------------------------------------------------------//
			billingData.goToPostNewCharge(selenium, postChargeEntry);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-15: post Charge For Payer Payment
			// --------------------------------------------------------------------//
			if(userAccount.equals(USAccount)){
				assertTrue(selenium.isChecked(billingData.chkHardCopy),"Hard Copy Check box is not checked",selenium, ClassName, MethodName);
			}
			billingData.postChargeForPatientPaymentSetUp(selenium, postChargeEntry,userAccount);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-16: Naviage to Hold Queue
			// --------------------------------------------------------------------//
			assertTrue(click(selenium,billingData.lnkClaimsRejection),"Could not click the On Claims Rejection Queue",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-17: Search Hold Details
			// --------------------------------------------------------------------//
			assertTrue(type(selenium,billingData.txtPaperSearchPatient,payerData.patientId),"Could not enter the patient name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-18: Verify Hold Details
			// --------------------------------------------------------------------//
			if(!verifyDoNotClaimsDetails(selenium, postChargeEntry,payerData,providerPayerData, providerData)){
				Assert.fail("Do not Claims Details are not saved");
			}else
				returnValue = true;
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data" + providerData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyDoNotClaimsDetails(Selenium selenium,BillingLib postChargeEntry,HomeLib payerData,SystemSettingsLib providerPayerData,SystemSettingsLib providerData ){
		AbstractBilling billingData = new AbstractBilling();
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat;
		DateFormat = new SimpleDateFormat("MMM dd, YYYY");
		String date = DateFormat.format(cal.getTime());
		
		postChargeEntry.fromDate = date;
		int count;
		int claimsCount = (Integer) selenium.getXpathCount(billingData.lblClaimCount);
		
		for(count =1; count <=claimsCount;count++ ){
			if((getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(payerData.patientId))&& ((getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(providerPayerData.payerName)))
					&& (getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(postChargeEntry.fromDate))){
				
				if(!getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(payerData.patientId)){
					return false;
				}
				
				if(!getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(providerPayerData.payerName)){
					return false;
				}
				
				if(!getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(providerData.providerName)){
					return false;
				}
				
				if(!getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(postChargeEntry.fromDate)){
					return false;
				}
			}
		}
		return true;
	}
}
