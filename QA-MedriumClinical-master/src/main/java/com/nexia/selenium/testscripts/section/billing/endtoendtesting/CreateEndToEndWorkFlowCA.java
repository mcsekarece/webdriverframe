package com.nexia.selenium.testscripts.section.billing.endtoendtesting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;

import com.thoughtworks.selenium.Selenium;

public class CreateEndToEndWorkFlowCA extends AbstractBilling {
	@Test(groups = {"SmokeCA","EndToEnd","Developing","firefox", "iexplore", "safari", "default" })//, description = "Verify add new claim in payer payments",dependsOnGroups = "BeforeCreatePatientAndPayerCA")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endToEndWorkFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ChargeEntry";
		billingData.testCaseId = "TC_CE_066";
		billingData.fetchBillingTestData();
		endToEndWorkFlow(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
	
	/*************************************************************************************************** 
	* @purpose        Verify End To end Work Flow For CA
	* @action 		  Verify End To end Work Flow in  Biller related 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @ticket		  #8759
	* @useraccount    US
	* @since  	      Feb 04, 2014	
	***************************************************************************************************/
	
	
	public boolean endToEndWorkFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		
		String patientName="Mathewaaz";
		String currentPayer="OHIP - Ontario Health Insurance Plan";
		String payTo="S - Patient";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//-----------------------------------------------------------------------------//
			//  Step-2: Search Patient and Adjust All Charges
			//----------------------------------------------------------------------------//
			assertTrue(navigateToPatientByPatientId(selenium,patientName),"Search Patient failed", selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkBillingHistory), "could not click billing History", selenium, ClassName, MethodName);
 			assertTrue(click(selenium, lnkChargeHistory), "could not click Charges", selenium, ClassName, MethodName);
			assertTrue(adjustAllCharges(selenium, billingData), "Adjustment Failed", selenium, ClassName, MethodName);
			
			//-----------------------------------------------------------------------------//
			//  Step-3: Search Patient and Navigate to Post Charge
			//----------------------------------------------------------------------------//
			assertTrue(navigateToPatientByPatientId(selenium,patientName),"Search Patient failed", selenium, ClassName, MethodName);
			assertTrue(goToPostNewCharge(selenium, billingData), "Navigation Failed", selenium, ClassName, MethodName);

			// --------------------------------------------------------------------//
			// Step-3: Post Charges 
			// --------------------------------------------------------------------//

			assertTrue(savePostChargeEntry(selenium, billingData,userAccount), "Post Charges Failed", selenium, ClassName, MethodName);
			selenium.mouseOver(serviceCode);
			String amount=getText(selenium,lblAmount);
			
			assertTrue(selectValueFromAjaxList(selenium, ajxPayToBox,payTo),"Not able to add Billing provider", selenium, ClassName,MethodName);

		    assertTrue(click(selenium, btnPostChargeEntry),"Not able to click Post Button", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent(currentPayer),"Not navigated to Summary page after Post Charge Entry", selenium,ClassName, MethodName);
			
			// --------------------------------------------------------------------//
			// Step-4: Verify the charges
			// --------------------------------------------------------------------//
			   
			 assertTrue(click(selenium, lnkChargeHistory), "could not click Charges", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			    
			 assertTrue(verifyCharges(selenium,billingData,userAccount,currentPayer,amount),"Charges are not getting displayed properly", selenium, ClassName, MethodName);
			   

			// --------------------------------------------------------------------//
			// Super Bill Part
			// --------------------------------------------------------------------//
			 
			// --------------------------------------------------------------------//
			// Step-5: Search for a patient
			// --------------------------------------------------------------------//
			 assertTrue(navigateToViewChartByID(selenium,patientName),"Could not serach the patient", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			 AbstractChartPreVisit chartVisit = new AbstractChartPreVisit();
			 ChartPreVisitLib encounterData = new ChartPreVisitLib();
			 HomeLib payerData = new HomeLib();
			 payerData.payerName=currentPayer;
			 
			 assertTrue(chartVisit.goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 String providerNameTemp= getText(selenium, lnkTopMenu);
		     String providerName= providerNameTemp.replaceAll(", "+billingData.switchRole, "");
			 String tempArray[]=providerName.split(" ");
			 String provider=tempArray[1]+", "+tempArray[0];
				
			 assertTrue(selectValueFromAjaxList(selenium, chartVisit.ajxEncounterProvider,provider),"Select Failed", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 assertTrue(click(selenium, chartVisit.btnSign), "Could not click the sign button",
			 selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-4: Create Complete Super Bill Template //
			//--------------------------------------------------------------------//
			billingData.workSheetName = "SuperBillEntry";
			billingData.testCaseId = "TC_SBE_006";
			billingData.fetchBillingTestData();
			 
			assertTrue(endToEndCompleteSuperBill(selenium,billingData,payerData,userAccount),"Could not serach the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
		}catch (Exception e ){
			e.printStackTrace();
		}		
	return true;
	}
	
	public boolean verifyCharges(Selenium selenium,BillingLib billingData,String userAccount,String currentPayer,String amount) throws IOException {
		String date="";
		int count=0;
		count=(Integer) selenium.getXpathCount("//a[contains(text(),'View')]");
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		if(userAccount.equals(CAAccount)){
			DateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		date = DateFormat.format(cal.getTime());
		assertTrue(getText(selenium,lblDateValiue+"["+count+"]").contains(date),"Date is incorrect", selenium, ClassName, MethodName);
		if(userAccount.equals(CAAccount)){
		assertTrue(getText(selenium,lblServiceCodeForCharges+"["+count+"]").contains(billingData.serviceCodeCA),"Service code is incorrect", selenium, ClassName, MethodName);
		}else{
		assertTrue(getText(selenium,lblServiceCodeForCharges+"["+count+"]").contains(billingData.serviceCode),"Service code is incorrect", selenium, ClassName, MethodName);	
		}
		assertTrue(getText(selenium,lblChargeAmountCharges+"["+count+"]").contains(amount),"Charge Amount is incorrect", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblAmountDue+"["+count+"]").contains(amount),"Due Amount is incorrect", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblCurrentPayer+"["+count+"]").contains(currentPayer),"Current payer is incorrect", selenium, ClassName, MethodName);
		return true;
	}
	
	/**
	 * function to endToEndCompleteSuperBill
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 27,2014
	 */
	
	public boolean endToEndCompleteSuperBill(Selenium selenium,BillingLib entryData,HomeLib payerData,String account) throws IOException{
		try{
			selectValueFromAjaxList(selenium, ajxCodingSystem,entryData.templateName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			
			if(entryData.testCaseId.equals("TC_SBE_009")|| entryData.testCaseId.equals("TC_SBE_010")){
				assertTrue(click(selenium,entryData.serviceCode+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode2+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode3+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
			}if(entryData.testCaseId.equals("TC_SBE_011")){
				assertTrue(click(selenium,entryData.serviceCode+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode2+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
			}
			if(entryData.testCaseId.equals("TC_SBE_006")){
				assertTrue(click(selenium,entryData.serviceCode+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode2+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode3+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode4+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode5+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode6+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(verifyCompleteSuperBillData(selenium,entryData),"Unit and fee details are not displayed properly",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
	
			selectValueFromAjaxList(selenium,ajxBillTo,payerData.payerName);
			waitForPageLoad(selenium);
			
			if(!isChecked(selenium,chkCSBHardCopy)){
				return false;
			}
			
			if(entryData.testCaseId.equals("TC_SBE_009")|| entryData.testCaseId.equals("TC_SBE_010")){
				assertTrue(click(selenium, btnSave), "Could not click the Save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(entryData.testCaseId.equals("TC_SBE_009")){
					if(!selenium.isTextPresent("Service code ETS001 is not valid for current date of service"))
					return false;
				}
				
				if(entryData.testCaseId.equals("TC_SBE_010")){
					if(!selenium.isTextPresent("Service code ETE004 is not valid for current date of service"))
					return false;
				}
				
				return true;
			}
			assertTrue(completeSuperBill(selenium,entryData,account),"Complete Super Bill Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
