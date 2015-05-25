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

public class VerifySecuirtyOptionForChargeEntryWorkQueue extends AbstractBilling{
	@Test(groups = {"AdvancedSmoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "VerifySecurityOption";
		superBillData.testCaseId = "TC_VSP_001";
		superBillData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "VerifySecurityOption";
		superBillData.testCaseId = "TC_VSP_002";
		superBillData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "VerifySecurityOption";
		superBillData.testCaseId = "TC_VSP_003";
		superBillData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "VerifySecurityOption";
		superBillData.testCaseId = "TC_VSP_004";
		superBillData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Super Bill Entry To review 
	* @action 		  Verify Security Option For Super Bill Entry To review 
	* @expected       To Ensure that the Security Option For Super Bill Entry To review are works fine 
	* @Specification  SRS_BLG_Superbill Review Queue
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 11, 2014
	***************************************************************************************************/
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue = false;
		try{
			
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
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
			if(superBillData.testCaseId.equals("TC_VSP_003")){
				assertTrue(click(selenium,lnkQuickAction),"Navigation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lnkBillingSettings)){
					Assert.fail("Billing settings link is present in No access role");
				}else
					return true;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Full And  Limited Access role					 //
			//--------------------------------------------------------------------//
			if(superBillData.testCaseId.equals("TC_VSP_001")){
				if(!verifySecurityOption(selenium,superBillData,userAccount)){
					Assert.fail("Security option not show properly; More Details :"+superBillData.toString());
				}else
					returnValue = true; 
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify View only Access role					 //
			//--------------------------------------------------------------------//
			if(superBillData.testCaseId.equals("TC_VSP_002")){
				if(!verifyViewOnlyAccess(selenium,superBillData,userAccount)){
					Assert.fail("Security option not show properly; More Details :"+superBillData.toString());
				}else
					returnValue = true; 
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifySecurityOption(Selenium selenium,BillingLib superBillData, String account) throws IOException{
		
		//Limited Access
		if(superBillData.testCaseId.equals("TC_VSP_001")){
			BillingLib superBillData1 = new BillingLib();
			superBillData1.workSheetName = "SuperBillEntry";
			superBillData1.testCaseId = "TC_SBE_003";
			superBillData1.fetchBillingTestData();
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,superBillData1.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-1: Search patient//
			//--------------------------------------------------------------------//
			assertTrue(navigateToPatient(selenium, superBillData1),"Could not search the patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete All Encounter In Encounter tab //
			//--------------------------------------------------------------------//
			AbstractChartPreVisit chartVisit = new AbstractChartPreVisit();
			ChartPreVisitLib historyData = new ChartPreVisitLib();
			assertTrue(click(selenium,chartVisit.lnkChartView),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chartVisit.lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(chartVisit.deleteAllEncounters(selenium,historyData),"Could not delete", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Begin Encounter //
			//--------------------------------------------------------------------//
			assertTrue(chartVisit.goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+superBillData1.switchRole, "");
			System.out.println(providerName);
			String tempArray[]=providerName.split(" ");
			String provider=tempArray[1]+", "+tempArray[0];
			System.out.println(provider);
			
			selectValueFromAjaxList(selenium, chartVisit.ajxEncounterProvider,provider);
			
			historyData.workSheetName = "CreateProblemList";
			historyData.testCaseId = "TC_CPL_047";
			historyData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			
			assertTrue(chartVisit.createDiagnosisCodes(selenium,historyData,account),"Could not create the Assessment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Complete Super Bill //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,btnPost)){
				Assert.fail("Post button is getting present in Limited access role");
			}
			
			
			assertTrue(completeSuperBill(selenium,superBillData1,account),"Complete Super Bill Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: verify limited access  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			
			assertTrue(switchRole(selenium,superBillData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			
			
			assertTrue(click(selenium,lnkSuperBill),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			selenium.clickAt("//div[starts-with(@id,'superbillQueueItem')]/div/div","");
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,ajxServiceCodeCharge)){
				return false;
			}		
		}
		return true;
	}
	
	//View only
	public boolean verifyViewOnlyAccess(Selenium selenium,BillingLib superBillData, String account ) throws IOException{
		
		BillingLib superBillData1 = new BillingLib();
		superBillData1.workSheetName = "SuperBillEntry";
		superBillData1.testCaseId = "TC_SBE_003";
		superBillData1.fetchBillingTestData();
		
		//Full Access to View only
		assertTrue(switchRole(selenium,superBillData1.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-1: Search patient//
		//--------------------------------------------------------------------//
		assertTrue(navigateToPatient(selenium, superBillData),"Could not search the patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		//--------------------------------------------------------------------//
		//  Step-3: Delete All Encounter In Encounter tab //
		//--------------------------------------------------------------------//
		AbstractChartPreVisit chartVisit = new AbstractChartPreVisit();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		assertTrue(click(selenium,chartVisit.lnkChartView),"Could not click Nexia Logo", selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);
		 
		assertTrue(click(selenium,chartVisit.lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
		assertTrue(chartVisit.deleteAllEncounters(selenium,historyData),"Could not delete", selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-4: Navigate to Begin Encounter //
		//--------------------------------------------------------------------//
		assertTrue(chartVisit.goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String providerName= providerNameTemp.replaceAll(", "+superBillData.switchRole, "");
		String tempArray[]=providerName.split(" ");
		String provider=tempArray[1]+", "+tempArray[0];
		
		selectValueFromAjaxList(selenium, chartVisit.ajxEncounterProvider,provider);
		
		historyData.workSheetName = "CreateProblemList";
		historyData.testCaseId = "TC_CPL_047";
		historyData.fetchChartPreVisitTestData();
		waitForPageLoad(selenium);
		
		assertTrue(chartVisit.createDiagnosisCodes(selenium,historyData,account),"Could not create the Assessment", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-5: Create Complete Super Bill //
		//--------------------------------------------------------------------//
		assertTrue(completeSuperBill(selenium,superBillData,account ),"Complete Super Bill Creation Failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		//--------------------------------------------------------------------//
		//  Step-5: View only to Full Access //
		//--------------------------------------------------------------------//
		assertTrue(switchRole(selenium,superBillData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-6:Verify View only access details //
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkSuperBill),"Could not click the super bill to review queue", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click the queue details
		selenium.clickAt("//div[starts-with(@id,'superbillQueueItem')]/div/div","");
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,ajxServiceCodeCharge)){
			return false;
		}
	return true;
	}

}
