package com.nexia.selenium.testscripts.section.billing.chargeentryworkqueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchWithDifferentProvider extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for search with Different Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifysearchWithLocation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillEntry";
		superBillData.testCaseId = "TC_SBE_005";
		superBillData.fetchBillingTestData();
		verifyValidateList(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify search with Different Provider in Super Bill Queue
	* @action 		  verify search with Different Provider in Super Bill Queue
	* @expected       To Ensure that  search with Different Provider in Super Bill Queue works fine 
	* @Specification  SRS_BLG_Superbill Review Queuek
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 17, 2014
	***************************************************************************************************/
	
	public boolean verifyValidateList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue=false;
		String patientName = null;
		
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
			
			/*//--------------------------------------------------------------------//
			//  Step-4: Navigate to Patient Chart Page //
			//--------------------------------------------------------------------//
			assertTrue(goToPatientChart(selenium),"Could not navigate to Patient chart page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete All Encounter In Encounter tab //
			//--------------------------------------------------------------------//
			patientName = getText(selenium,lblpatientName);
			waitForPageLoad(selenium);
			superBillData.patientID = patientName;
			
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
			//  Step-6: Create Complete Super Bill //
			//--------------------------------------------------------------------//
			
			assertTrue(completeSuperBill(selenium,superBillData,userAccount),"Complete Super Bill Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create Anther Complete Super Bill with different Provider //
			//--------------------------------------------------------------------//
			
			BillingLib superBillData1 = new BillingLib();
			superBillData1.workSheetName = "SuperBillEntry";
			superBillData1.testCaseId = "TC_SBE_006";
			superBillData1.fetchBillingTestData();
			
			
			//--------------------------------------------------------------------//
			//  Step-1: Navigate to Patient Chart Page //
			//--------------------------------------------------------------------//
			//assertTrue(goToPatientChart(selenium),"Could not navigate to Patient chart page", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Delete All Encounter In Encounter tab //
			//--------------------------------------------------------------------//
			patientName = getText(selenium,lblpatientName);
			waitForPageLoad(selenium);
			superBillData.patientID = patientName;
			
			assertTrue(click(selenium,chartVisit.lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(chartVisit.deleteAllEncounters(selenium,historyData),"Could not delete", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Begin Encounter //
			//--------------------------------------------------------------------//
			assertTrue(chartVisit.goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium, chartVisit.ajxEncounterProvider,provider);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib historyData1 = new ChartPreVisitLib();
			historyData1.workSheetName = "CreateProblemList";
			historyData1.testCaseId = "TC_CPL_047";
			historyData1.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			
			assertTrue(chartVisit.createDiagnosisCodes(selenium,historyData,userAccount),"Could not create the Assessment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Complete Super Bill //
			//--------------------------------------------------------------------//
			
			assertTrue(completeSuperBill(selenium,superBillData,userAccount),"Complete Super Bill Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Complete super details in Super bill review Queue//
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
 
			//--------------------------------------------------------------------//
			//  Step-8: verify Listing of Claims  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSuperBill),"could not click the Super Bill Review Queue", selenium,ClassName, MethodName );
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: verify Search result details  //
			//--------------------------------------------------------------------//
			if(!verifySearchResult(selenium,superBillData)){
				Assert.fail("Search results are not getting displayed properly");
			}else
				returnValue = true;

			}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
	
	public boolean verifySearchResult(Selenium selenium, BillingLib superBillData) throws IOException{
		
		int count;
		int claimsCount = (Integer) selenium.getXpathCount(lblClaimCount);
		
		
		
			assertTrue(type(selenium,txtSearch,superBillData.provider),"Could not type the provider", selenium, ClassName, MethodName);
			selenium.keyPress(txtSearch, "\\13");
			
			 int counter=0;
			 while(!isElementPresent(selenium, lblClaimCount)&&(counter<=10))
			 {
				 waitForPageLoad(selenium);
				 counter++;
			 }

		for(count =1; count <=claimsCount;count++ ){
			
			if((getText(selenium, "//div[4]/div/div/div["+count+"]/div").contains(superBillData.patientID))&&(getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(superBillData.dateoFService))){
				if(!getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(superBillData.dateoFService)){
					return false;
				}
				
				if(!getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(superBillData.rprovider)){
					return false;
				}
				
				if(!getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(superBillData.patientID)){
					return false;
				}
				
				if(!getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(superBillData.location)){
					return false;
				}
			}
			
		}
		return true;
	}
}
