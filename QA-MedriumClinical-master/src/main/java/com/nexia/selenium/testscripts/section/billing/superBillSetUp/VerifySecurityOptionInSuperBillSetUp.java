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

public class VerifySecurityOptionInSuperBillSetUp extends AbstractBilling{
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
	* @purpose        To Verify Security Option For Super Bill Review Queue
	* @action 		  Verify Security Option For Super Bill Review Queue
	* @expected       To Security Option For Super Bill Review Queue works fine 
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
				
				if(isElementPresent(selenium,lnkSuperBill)){
					Assert.fail("Super Bill Review Queue link is present in No access role");
				}else
					return true;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Full And  Limited Access role					 //
			//--------------------------------------------------------------------//
			if((superBillData.testCaseId.equals("TC_VSP_004"))){
				if(!verifySecurityOption(selenium,superBillData,userAccount)){
					Assert.fail("Security option not show properly; More Details :"+superBillData.toString());
				}else
					returnValue = true; 
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify View only Access role					 //
			//--------------------------------------------------------------------//
			if(superBillData.testCaseId.equals("TC_VSP_001")||superBillData.testCaseId.equals("TC_VSP_002")){
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
	
	public boolean verifySecurityOption(Selenium selenium,BillingLib superBillData, String userAccount) throws IOException{
		String uniqueName = null;
		//--------------------------------------------------------------------//
		//  Step-1: Go to Biller Settings//
		//--------------------------------------------------------------------//
		assertTrue(goToBillerSettings(selenium),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-2: Navigate to Super Bill Page//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Full Access
		
		if(superBillData.testCaseId.equals("TC_VSP_004")){
			
			superBillData.workSheetName = "SuperBillSetUp";
			superBillData.testCaseId = "TC_SBS_002";
			superBillData.fetchBillingTestData();
			
			//--------------------------------------------------------------------//
			//  Step-1: Delete Existing Super Bill Entry//
			//--------------------------------------------------------------------//
			assertTrue(deleteSuperBillEntry(selenium,superBillData),"Could not delete the record",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2 :  Create Bill Info//
			//-------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSBIAddNew),"Could not click the Add New link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=DateFormat.format(cal.getTime());
			
			//assertTrue(addSuperBillInfo(selenium,superBillData,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create Service code //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(btnServiceCodeDelete),"Delete button is not visible in the Servce code page",selenium, ClassName, MethodName);
			
			assertTrue(addServiceCode(selenium,superBillData,userAccount,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: verify Full access  //
			//--------------------------------------------------------------------//
			if(!(isElementPresent(selenium,lnkDeleteSuperBill))){
				return false;
			}
		}
		return true;
	}
	
	//View only and Limited Access
	public boolean verifyViewOnlyAccess(Selenium selenium,BillingLib superBillData, String userAccount) throws IOException{
	String uniqueName = null;
		BillingLib superBillData1 = new BillingLib();
		superBillData1.workSheetName = "SuperBillSetUp";
		superBillData1.testCaseId = "TC_SBS_002";
		superBillData1.fetchBillingTestData();
		
		//View only to Full Access
		assertTrue(switchRole(selenium,superBillData1.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-1: Go to Biller Settings//
		//--------------------------------------------------------------------//
		assertTrue(goToBillerSettings(selenium),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-2: Navigate to Super Bill Page//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3: Delete Existing Super Bill Entry//
		//--------------------------------------------------------------------//
		assertTrue(deleteSuperBillEntry(selenium,superBillData1),"Could not delete the record",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-4 :  Create Bill Info//
		//-------------------------------------------------------------------//
		assertTrue(click(selenium,lnkSBIAddNew),"Could not click the Add New link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
		uniqueName=DateFormat.format(cal.getTime());
		
		//assertTrue(addSuperBillInfo(selenium,superBillData1,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
		//waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-5: Create Service code //
		//--------------------------------------------------------------------//
		assertTrue(addServiceCode(selenium,superBillData1,userAccount,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		// Full to View only
		if(superBillData.testCaseId.equals("TC_VSP_002")){
			superBillData.workSheetName = "VerifySecurityOption";
			superBillData.testCaseId = "TC_VSP_002";
			superBillData.fetchBillingTestData();
			
			assertTrue(switchRole(selenium,superBillData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		//Full to limited access
		if(superBillData.testCaseId.equals("TC_VSP_001")){
			superBillData.workSheetName = "VerifySecurityOption";
			superBillData.testCaseId = "TC_VSP_001";
			superBillData.fetchBillingTestData();
			
			assertTrue(switchRole(selenium,superBillData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		assertTrue(goToBillerSettings(selenium),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-6: Navigate to Super Bill Page//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-7: verify View only  access  //
		//--------------------------------------------------------------------//
		if((isElementPresent(selenium,lnkDeleteSuperBill))){
			return false;
		}
		
	return true;
	}
	
}
