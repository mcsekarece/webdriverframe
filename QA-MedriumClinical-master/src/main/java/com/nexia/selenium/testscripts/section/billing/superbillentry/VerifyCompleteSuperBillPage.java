package com.nexia.selenium.testscripts.section.billing.superbillentry;

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
import com.thoughtworks.selenium.Selenium;

public class VerifyCompleteSuperBillPage extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Complete Super Bill Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void completeSuperBillPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillEntry";
		superBillData.testCaseId = "TC_SBE_012";
		superBillData.fetchBillingTestData();
		verifyCSBPage(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Action Button Details In CompleteSuperBill
	* @action 		  Verify Action Button Details In CompleteSuperBill
	* @expected       To Ensure that the Verify Action Button Details In CompleteSuperBill works fine 
	* @Specification  SRS_BLG_Superbill Entry_Superbill Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 03, 2014
	***************************************************************************************************/
	
	public boolean verifyCSBPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		String provider=null;
		Selenium selenium = null;
		//boolean returnValue=false;
		
		try {
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + superBillData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, superBillData.userName, superBillData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch to Biller role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,superBillData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Search patient //
			//--------------------------------------------------------------------//
			assertTrue(navigateToPatient(selenium, superBillData),"Could not search the patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete All Encounter In Encounter tab //
			//--------------------------------------------------------------------//
			AbstractChartPreVisit chartVisit = new AbstractChartPreVisit();
			ChartPreVisitLib historyData = new ChartPreVisitLib();
			
			assertTrue(click(selenium,chartVisit.lnkChartView),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,chartVisit.lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(chartVisit.deleteAllEncounters(selenium,historyData),"Could not delete", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Begin Encounter //
			//--------------------------------------------------------------------//
			assertTrue(chartVisit.goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+superBillData.switchRole, "");
			String tempArray[]=providerName.split(" ");
			 provider=tempArray[1]+", "+tempArray[0];
			
			selectValueFromAjaxList(selenium, chartVisit.ajxEncounterProvider,provider);
			waitForPageLoad(selenium);
			
			historyData.workSheetName = "CreateProblemList";
			historyData.testCaseId = "TC_CPL_047";
			historyData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			
			assertTrue(chartVisit.createDiagnosisCodes(selenium,historyData,userAccount),"Could not create the Assessment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Complete Super Bill Page //
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				assertTrue(selenium.isTextPresent("Pay to"),"Pay to text is not present", selenium, ClassName, MethodName);
				//assertTrue(selenium.isTextPresent("Group Number"),"Group Number text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Payment Program"),"Payment Program text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Bill to"),"Bill to text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Manual Review"),"Manual Review text is not present", selenium, ClassName, MethodName);
				
			}
			
			assertTrue(selenium.isTextPresent("Rendering Provider"),"Rendering Provider text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Specialty"),"Specialty text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Billing Provider"),"Billing Provider text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Referring Provider"),"Referring Provider text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Location"),"Location text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Place of Service"),"Place of Service text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Date of Service"),"Date of Service text is not present", selenium, ClassName, MethodName);
			
			
			if(!verifyStoreDetails(selenium, providerName, historyData)){
				Assert.fail("Details are not stored");
			}
			
			
			
			
			}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	
	public boolean verifyStoreDetails(Selenium selenium, String providerName,ChartPreVisitLib historyData){
		String date = null;
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
		date=DateFormat.format(cal.getTime());
		String providerNameTemp= getText(selenium, lnkTopMenu);
		 providerName= providerNameTemp.replaceAll(", "+"BILLER", "");
		String tempArray[]=providerName.split(" ");
		String provider=tempArray[1].toUpperCase()+", "+tempArray[0].toUpperCase();	
		
		System.out.println(selenium.getValue(dateOfService));
		System.out.println(provider);
		System.out.println(getValue(selenium,"renderingProvidersuggestBox"));
		if(!getValue(selenium,dateOfService).contains(date)){
			return false;
		}
		if(!getValue(selenium,"renderingProvidersuggestBox").toLowerCase().contains(provider.toLowerCase())){
			return false;
		}
		if(!getText(selenium,"//span[contains(text(),'Diagnosis Codes')]/parent::div/parent::div/div/div").contains(historyData.medicalCondition1)){
			return false;
		}
		return true;
	}
}
