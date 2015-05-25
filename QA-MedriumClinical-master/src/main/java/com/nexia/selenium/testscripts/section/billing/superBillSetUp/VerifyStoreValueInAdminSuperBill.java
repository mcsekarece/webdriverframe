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

public class VerifyStoreValueInAdminSuperBill extends AbstractBilling{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Adding Super Bill")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addSuperBill(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillSetUp";
		superBillData.testCaseId = "TC_SBS_002";
		superBillData.fetchBillingTestData();
		addAdminSuperBill(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Edit Super Bill ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editSuperBill(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillSetUp";
		superBillData.testCaseId = "TC_SBS_001";
		superBillData.fetchBillingTestData();
		editAdminSuperBill(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Add Admin Super Bill Value in summary page
	* @action 		  verify Add Admin Super Bill Value in summary page
	* @expected       To Ensure that the Add Admin Super Bill Value in summary page works fine 
	* @Specification  SRS_BLG_ADMIN_Superbill_Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jan 21, 2014
	***************************************************************************************************/
	
	public boolean addAdminSuperBill(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue=false;
		String uniqueName = null;
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
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Go to Biller Settings//
			//--------------------------------------------------------------------//
			assertTrue(goToBillerSettings(selenium),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"", selenium, ClassName, MethodName);
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
			//  Step-6: Create Bill Info//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSBIAddNew),"Could not click the Add New link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=DateFormat.format(cal.getTime());
			
			//assertTrue(addSuperBillInfo(selenium,superBillData,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create Service code //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(btnServiceCodeDelete),"Delete button is not visible in the Servce code page",selenium, ClassName, MethodName);
			
			assertTrue(addServiceCode(selenium,superBillData,userAccount,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Store Value //
			//--------------------------------------------------------------------//
			if(!verifyStoreValue(selenium,superBillData,userAccount)){
				Assert.fail("Details  are not fetched proerly");
			}
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Store Value  in Summary page//
			//--------------------------------------------------------------------//
			if(!verifyStoreValueInSummaryPage(selenium,superBillData,userAccount)){
				Assert.fail("Details  are not dispayed properly in summary page");
			}else
				returnValue = true;
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Edit Admin Super Bill Set Up
	* @action 		  verify Edit Admin Super Bill Set Up
	* @expected       To Ensure that the Edit Admin Super Bill Set Up works fine 
	* @Specification  SRS_BLG_ADMIN_Superbill_Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jan 21, 2014
	***************************************************************************************************/
	
	public boolean editAdminSuperBill(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue=false;
		String uniqueName = null;
		//String templateName = null;
		int count;
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
			//  Step-6: Create Bill Info//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSBIAddNew),"Could not click the Add New link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=DateFormat.format(cal.getTime());
			
			//assertTrue(addSuperBillInfo(selenium,superBillData,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create Service code //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(btnServiceCodeDelete),"Delete button is not visible in the Servce code page",selenium, ClassName, MethodName);
			
			assertTrue(addServiceCode(selenium,superBillData,userAccount,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Click on Edit button //
			//--------------------------------------------------------------------//
			selenium.isElementPresent("//a[contains(text(),'Edit')]");
			selenium.click("//a[contains(text(),'Edit')]");
			waitForPageLoad(selenium);
		
					if(!getValue(selenium,txtTempletaName).contains(superBillData.templateName)){
						Assert.fail("Cretaed Details are not getting displayed");
					}else
						returnValue = true;
		
			//--------------------------------------------------------------------//
			//  Step-9: Edit Service code //
			//--------------------------------------------------------------------//
			
			superBillData.workSheetName = "SuperBillSetUp";
			superBillData.testCaseId = "TC_SBS_009";
			superBillData.fetchBillingTestData();
			
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=DateFormat1.format(cal.getTime());
			
			//assertTrue(addSuperBillInfo(selenium,superBillData,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(selenium.isVisible(btnServiceCodeDelete),"Delete button is not visible in the Servce code page",selenium, ClassName, MethodName);
			
			assertTrue(addServiceCode(selenium,superBillData,userAccount,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Store Value //
			//--------------------------------------------------------------------//
			if(!verifyStoreValue(selenium,superBillData,userAccount)){
				Assert.fail("Details  are not fetched proerly");
			}//--------------------------------------------------------------------//
			//  Step-8: Verify Store Value  in Summary page//
			//--------------------------------------------------------------------//
			if(!verifyStoreValueInSummaryPage(selenium,superBillData,userAccount)){
				Assert.fail("Details  are not dispayed properly in summary page");
			}else
				returnValue = true;
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	//Verify StoreValue
	public boolean verifyStoreValue(Selenium selenium,BillingLib superBillData, String  userAccount) throws IOException{
		selenium.isElementPresent("//a[contains(text(),'Edit')]");
		selenium.click("//a[contains(text(),'Edit')]");
		waitForPageLoad(selenium);
		assertTrue(getValue(selenium,txtTempletaName).contains(superBillData.templateName),"",selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,txtSectionLabel).contains(superBillData.sectionLabel),"",selenium, ClassName, MethodName);
		
		if(userAccount.equals(CAAccount)){
			assertTrue(getValue(selenium,ajxSCServiceCode).contains(superBillData.serviceCodeCA),"",selenium, ClassName, MethodName);
		}else
			assertTrue(getValue(selenium,ajxSCServiceCode).contains(superBillData.serviceCode),"",selenium, ClassName, MethodName);
		
		if(!userAccount.equals(CAAccount)){
			assertTrue(getValue(selenium,ajxSCModifiers1).contains(superBillData.modifiers),"",selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,ajxSCModifiers2).contains(superBillData.modifiers1),"",selenium, ClassName, MethodName);
		}
		assertTrue(click(selenium,btnSBINext),"Could not click the Next button", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,btnSBIDone),"Could not click the Done button", selenium, ClassName, MethodName);
		
		return true;
	}
	
	
	//Verify Store Value in summary page
	
	public boolean verifyStoreValueInSummaryPage(Selenium selenium,BillingLib superBillData, String  uniqueName) throws IOException{
		
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String providerName= providerNameTemp.replaceAll(", "+superBillData.switchRole, "");
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
		String date=DateFormat.format(cal.getTime());
		waitForPageLoad(selenium);
		//selenium.click("menuArrow");
		//waitForPageLoad(selenium);
		assertTrue(getText(selenium,lblSummerySuperBill).contains(superBillData.templateName),"",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblSummerySuperBill).contains( providerName),"",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblSummerySuperBill).contains(date),"",selenium, ClassName, MethodName);		
		return true;
	}
}
