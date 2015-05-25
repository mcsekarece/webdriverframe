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

public class VerifyValidateListingOfClaims extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Validate Listing Of Claims")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void validateListingOfClaims(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillEntry";
		superBillData.testCaseId = "TC_SBE_004";
		superBillData.fetchBillingTestData();
		verifyValidateList(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Validate Listing Of Claims
	* @action 		  Verify Validate Listing Of Claims
	* @expected       To Ensure that the Verify Validate Listing Of Claims works fine 
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
			//  Step-3: verify Listing of Claims  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSuperBill),"could not click the Super Bill Review Queue", selenium,ClassName, MethodName );
			waitForPageLoad(selenium);
			 
			if(!verifyListOfClaimsDetails(selenium)){
				Assert.fail("Super Bills to  review Queue is not getting displayed properly");
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify the Claims Counts  //
			//--------------------------------------------------------------------//
			String resultList=getText(selenium,lnkSuperBill);
			System.out.println(resultList);
			String[] afterSplitS = resultList.split(" ");
			int sBRResult = Integer.parseInt(afterSplitS[0]);
			System.out.println(sBRResult);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);

			 int claims = (Integer) selenium.getXpathCount(lblClaimCount);
			
			// int claimsCount = claims - sBRResult ;
			if(!(claims == sBRResult)){
				Assert.fail("Claims list count is not equal to super bill review link count");
			}else 
				returnValue = true;
			
			}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
	
	public boolean verifyListOfClaimsDetails(Selenium selenium) throws IOException{
		
		assertTrue(selenium.isTextPresent("Date of Service"),"", selenium,ClassName, MethodName );
		assertTrue(selenium.isTextPresent("Provider"),"", selenium,ClassName, MethodName );
		assertTrue(selenium.isTextPresent("Patient"),"", selenium,ClassName, MethodName );
		assertTrue(selenium.isTextPresent("Location"),"", selenium,ClassName, MethodName );
		return true;
		
	}
	
}
