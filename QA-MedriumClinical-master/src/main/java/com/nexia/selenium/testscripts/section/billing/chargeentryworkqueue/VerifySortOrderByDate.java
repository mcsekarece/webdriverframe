package com.nexia.selenium.testscripts.section.billing.chargeentryworkqueue;

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

public class VerifySortOrderByDate extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Sort Order By Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void sortOrderByDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillEntry";
		superBillData.testCaseId = "TC_SBE_004";
		superBillData.fetchBillingTestData();
		verifySortOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Sort Order By Date With Super Bill Queue
	* @action 		  verify Sort Order By Date With Super Bill Queue
	* @expected       To Ensure that Sort Order By Date With Super Bill Queue works fine 
	* @Specification  SRS_BLG_Superbill Review Queuek
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 15, 2014
	***************************************************************************************************/
	
	public boolean verifySortOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		
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
			//  Step-7:Verify Complete super details in Super bill review Queue//
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			 waitForPageLoad(selenium);
			  
			//--------------------------------------------------------------------//
			//  Step-8: verify Listing of Claims  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSuperBill),"could not click the Super Bill Review Queue", selenium,ClassName, MethodName );
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: verify Search result details  //
			//--------------------------------------------------------------------//
			if(!verifySordOrder(selenium,superBillData)){
				Assert.fail("Search results are not getting displayed properly");
			}else
				returnValue = true;
			
			
			
			}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
	
	public boolean verifySordOrder(Selenium selenium, BillingLib superBillData){
	
		int count;
		String currentDate;
		
		int claimsCount = (Integer) selenium.getXpathCount(lblClaimCount);
		
		//Current Date
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
		currentDate=DateFormat.format(cal.getTime());

		
		
		for(count =1; count <=claimsCount; count++){
			if(getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(currentDate)){
				
				if(getText(selenium,"//div["+count+"]/div/div/div/div[2]/span").contains(currentDate))
				count--;
				
				String date = getText(selenium,"//div[4]/div/div/div["+count+"]/div");
				if(!getText(selenium,"//div[4]/div/div/div["+count+"]/div").contains(date)){
					return false;
				}else
					return true;
			}
		}
		
		
		return true;
	
	}
		
		
}
