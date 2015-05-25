package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEncounterNotesOnChargeEntry extends AbstractBilling {
    	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Validate Displaying Of Claims")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void validateListingOfClaims(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillEntry";
		superBillData.testCaseId = "TC_SBE_005";
		superBillData.fetchBillingTestData();
		verifyValidateList(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Add Admin Super Bill Set Up
	* @action 		  verify Add Admin Super Bill Set Up
	* @expected       To Ensure that the Add Admin Super Bill Set Up works fine 
	* @Specification  SRS_BLG_Superbill Review Queue
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 11, 2014
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
			 assertTrue(navigateToPatientByPatientId(selenium,superBillData.patientID),"Search Patient failed",selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnkviewchart),"Search Patient failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkPatientOption),"Search Patient failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(selenium.isConfirmationPresent()){
					System.out.println(selenium.getConfirmation());
					//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
					selenium.chooseOkOnNextConfirmation();
					}
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkViewRegistration),"Search Patient failed",selenium, ClassName, MethodName);
				
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Patient Chart Page //
			//--------------------------------------------------------------------//
			assertTrue(goToPatientChart(selenium),"Could not navigate to Patient chart page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete All Encounter In Encounter tab //
			//--------------------------------------------------------------------//
			patientName = getText(selenium,lblpatientName);
			waitForPageLoad(selenium);
			superBillData.patientID = patientName;
			
			AbstractChartPreVisit chartVisit = new AbstractChartPreVisit();
			ChartPreVisitLib historyData = new ChartPreVisitLib();
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
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Encounter //
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib proData = new ChartPreVisitLib();
			proData.workSheetName = "CreateProcedure";
			proData.testCaseId = "TC_CP_001";
			proData.fetchChartPreVisitTestData();
			
			assertTrue(selenium.isVisible(chartVisit.lnkProcedure),"Procedure Link is Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,chartVisit.lnkProcedure),"Could not click the Procedure link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(chartVisit.createProcedure(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,chartVisit.btnSign),"Could not click the sign button", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create Complete Super Bill //
			//--------------------------------------------------------------------//
			
			assertTrue(completeSuperBill(selenium,superBillData,userAccount),"Complete Super Bill Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Complete super details in Super bill review Queue//
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 if(isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"Could not click the Close Button link",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9:Access Charge Entry//
			//--------------------------------------------------------------------//
			 
			assertTrue(click(selenium,lnkSuperBill),"could not click the Super Bill Review Queue", selenium,ClassName, MethodName );
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			int count=(Integer) selenium.getXpathCount("//div[contains(@id,'superbillQueueItem')]/div/div");
			assertTrue(click(selenium,"xpath=(//div[contains(@id,'superbillQueueItem')]/div/div)["+count+"]"),"could not click the Super Bill Review Queue", selenium,ClassName, MethodName );
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Verify Encounter Note//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkEncounterNote),"could not click the Super Bill Review Queue", selenium,ClassName, MethodName );
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent("Encounter Note"),"could not click the Super Bill Review Queue", selenium,ClassName, MethodName );
			waitForPageLoad(selenium);
			
			return returnValue;

		}catch (RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return returnValue;
	}
}
