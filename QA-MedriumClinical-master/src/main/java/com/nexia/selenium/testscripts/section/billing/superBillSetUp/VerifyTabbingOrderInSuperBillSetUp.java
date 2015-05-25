package com.nexia.selenium.testscripts.section.billing.superBillSetUp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderInSuperBillSetUp extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Tabbing Order In SuperBillSetUp")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void tabbingOrderInSuperBillSetUp(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillSetUp";
		superBillData.testCaseId = "TC_SBS_001";
		superBillData.fetchBillingTestData();
		verifyTabbingOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify Tabbing Order InSuper Bill SetUp
	* @action 		  verify Edit Admin Super Bill Set Up
	* @expected       To Ensure that the Edit Admin Super Bill Set Up works fine 
	* @Specification  SRS_BLG_ADMIN_Superbill_Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jan 15, 2014
	***************************************************************************************************/
	
	public boolean verifyTabbingOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		Selenium selenium = null;
		boolean returnValue=false;
		String uniqueName = null;
		//String templateName = null;
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
			//  Step-3: Go to Biller Settings//
			//--------------------------------------------------------------------//
			assertTrue(goToBillerSettings(selenium),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Super Bill Page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Existing Super Bill Entry//
			//--------------------------------------------------------------------//
			assertTrue(deleteSuperBillEntry(selenium,superBillData),"Could not delete the record",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Click on Add New//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSBIAddNew),"Could not click the Add New link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*//Tab order For Super Bill information 
			for(i =0;i<cssPathSBI.length;i++){
				assertTrue(isElementPresent(selenium,cssPathSBI[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(cssPathSBI[i]);
				waitForElementToEnable(selenium,cssPathSBI[i]);
				selenium.keyPress(cssPathSBI[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(cssPathSBI[i]));
			}
			
			// Create SBI
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(addSuperBillInfo(selenium,superBillData,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			//Tab order For Service code
			for(i =0;i<cssPathServiceCode.length;i++){
				assertTrue(isElementPresent(selenium,cssPathServiceCode[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(cssPathServiceCode[i]);
				waitForElementToEnable(selenium,cssPathServiceCode[i]);
				selenium.keyPress(cssPathServiceCode[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(cssPathServiceCode[i]));
			}
			
			// Add another one Service code
			assertTrue(click(selenium,btnSCAddNew),"Could not click the Add New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			for(i =0;i<cssPathServiceCode1.length;i++){
				assertTrue(isElementPresent(selenium,cssPathServiceCode1[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(cssPathServiceCode1[i]);
				waitForElementToEnable(selenium,cssPathServiceCode1[i]);
				selenium.keyPress(cssPathServiceCode1[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(cssPathServiceCode1[i]));
			}
			
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}
