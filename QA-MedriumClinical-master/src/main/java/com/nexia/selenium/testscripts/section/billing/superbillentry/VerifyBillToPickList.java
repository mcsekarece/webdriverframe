package com.nexia.selenium.testscripts.section.billing.superbillentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyBillToPickList extends AbstractBilling{
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Bill to pick list with payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillEntry";
		superBillData.testCaseId = "TC_SBE_012";
		superBillData.fetchBillingTestData();
		verifyBillToDetails(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Bill to pick list with patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillEntry";
		superBillData.testCaseId = "TC_SBE_014";
		superBillData.fetchBillingTestData();
		verifyBillToDetails(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify Bill to Pick list in Super bill Entry page 
	* @action 		  verify Bill to Pick list in Super bill Entry page 
	* @expected       To Ensure that the Bill to Pick list in Super bill Entry page 
	* @Specification  SRS_BLG_Superbill Entry_Superbill Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Canada
	* @since  	      May 31, 2014
	***************************************************************************************************/
	
	public boolean verifyBillToDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue=false;
		
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
			assertTrue(chartVisit.deleteAllEncounters(selenium,historyData),"Could not delete", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Begin Encounter //
			//--------------------------------------------------------------------//
			assertTrue(chartVisit.goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+superBillData.switchRole, "");
			String tempArray[]=providerName.split(" ");
			String provider=tempArray[1]+", "+tempArray[0];
			
			selectValueFromAjaxList(selenium, chartVisit.ajxEncounterProvider,provider);
			waitForPageLoad(selenium);
			
			historyData.workSheetName = "CreateProblemList";
			historyData.testCaseId = "TC_CPL_047";
			historyData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			
			assertTrue(chartVisit.createDiagnosisCodes(selenium,historyData,userAccount),"Could not create the Assessment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify HCN Details //
			//--------------------------------------------------------------------//
			if(!verifyBillToDetails(selenium,superBillData,chartVisit)){
				Assert.fail("Bill To Details are not getting displayed properly");
			}
			
			assertTrue(!isChecked(selenium, chkManualReview),"manual review check box is currently checked", selenium, ClassName, MethodName);
			assertTrue(!isChecked(selenium, chkboxInpatient),"Inpatient check box is currently checked", selenium, ClassName, MethodName);
			assertTrue(!isChecked(selenium, chkBoxAccident),"accident related charge check box is currently checked", selenium, ClassName, MethodName);

/*			if(!(isChecked(selenium, chkManualReview))&& (isChecked(selenium, chkboxInpatient))&&(isChecked(selenium, chkBoxAccident))){
				Assert.fail("manual review, Inpatient and accident related charge check box is currently checked");
			}else
				returnValue = true;
*/			
			
		
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
	
	public boolean verifyBillToDetails(Selenium selenium,BillingLib superBillData, AbstractChartPreVisit chartVisit){
		String hcnDetails = "OHIP - Ontario Health Insurance Plan";
		String hcnPatient = "Patient";
		
		if(superBillData.testCaseId.equals("TC_SBE_012")){
			if(!getValue(selenium,chartVisit.ajxBillToPayer).contains(hcnDetails)){
				return false;
			}
		}
		
		if(superBillData.testCaseId.equals("TC_SBE_014")){
			if(getValue(selenium,chartVisit.ajxBillToPayer).contains(hcnDetails)){
				return false;
			}
			if(!getValue(selenium,chartVisit.ajxBillToPayer).contains(hcnPatient)){
				return false;
			}
		}
		return true;
	}
}
