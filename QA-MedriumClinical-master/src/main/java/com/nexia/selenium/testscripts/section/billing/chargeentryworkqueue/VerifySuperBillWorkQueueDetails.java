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

public class VerifySuperBillWorkQueueDetails extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test For Verify Super Work Queue Details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySuperBillQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillEntry";
		superBillData.testCaseId = "TC_SBE_004";
		superBillData.fetchBillingTestData();
		verifySuperBillReviewQueue(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Super Bill Review Queue Details
	* @action 		  verify Super Bill Review Queue Details
	* @expected       To Ensure that Super Bill Review Queue Details works fine 
	* @Specification  SRS_BLG_Superbill Review Queuek
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 14, 2014
	***************************************************************************************************/
	
	public boolean verifySuperBillReviewQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue=false;
		String patientName = null;
		int i;
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
			//  Step-4: Navigate to Patient Chart Page //
			//--------------------------------------------------------------------//
			/*assertTrue(goToPatientChart(selenium),"Could not navigate to Patient chart page", selenium, ClassName, MethodName);
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
			
			assertTrue(click(selenium,chartVisit.btnSign),"Could not click the sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Create Complete Super Bill //
			//--------------------------------------------------------------------//
			
			assertTrue(completeSuperBill(selenium,superBillData,userAccount),"Complete Super Bill Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Complete super details in Super bill review Queue//
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 if (isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"Could not click on Error Close Button",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: verify super bill queue  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSuperBill),"could not click the Super Bill Review Queue", selenium,ClassName, MethodName );
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSuperBillHide),"could not click the Hide button", selenium,ClassName, MethodName );
			waitForPageLoad(selenium);
			
			if(selenium.isTextPresent("Hide")){
				Assert.fail("Hide option is getting displayed");
			}
			//--------------------------------------------------------------------//
			//  Step-9: Tabbing Order Form the Queue  //
			//--------------------------------------------------------------------//
			
			for(i =0;i<cssPathBillQueue.length;i++){
				assertTrue(isElementPresent(selenium,cssPathBillQueue[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(cssPathBillQueue[i]);
				waitForElementToEnable(selenium,cssPathBillQueue[i]);
				selenium.keyPress(cssPathBillQueue[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(cssPathBillQueue[i]));
			}
			assertTrue(click(selenium,lnkSuperBill),"could not click the Super Bill Review Queue", selenium,ClassName, MethodName );
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lblClaimCount+"/div/div"),"Could not click the Queue data", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isTextPresent(serviceCode)){
				Assert.fail("Charge Entry Page is not getting displayed");
			}else
				returnValue = true;
	
			}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
