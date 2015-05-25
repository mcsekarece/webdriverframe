package com.nexia.selenium.testscripts.section.billing.superBillSetUp;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForServiceCode extends AbstractBilling{
	@Test(groups = {"RegressionUnit","firefox", "iexplore", "safari", "default" }, description = "section with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void sectionWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib superBillData = new BillingUnitTestLib();
		superBillData.workSheetName = "UnitTest_AdminSuperBill";
		superBillData.testCaseId = "TC_USBI_003";
		superBillData.fetchBillingTestData();
		unitTestForSBI(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	@Test(groups = {"RegressionUnit","firefox", "iexplore", "safari", "default" }, description = "service code with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void serviceCodeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib superBillData = new BillingUnitTestLib();
		superBillData.workSheetName = "UnitTest_AdminSuperBill";
		superBillData.testCaseId = "TC_USBI_004";
		superBillData.fetchBillingTestData();
		unitTestForSBI(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	@Test(groups = {"RegressionUnit","firefox", "iexplore", "safari", "default" }, description = "description  with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void descriptionWithWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib superBillData = new BillingUnitTestLib();
		superBillData.workSheetName = "UnitTest_AdminSuperBill";
		superBillData.testCaseId = "TC_USBI_005";
		superBillData.fetchBillingTestData();
		unitTestForSBI(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	@Test(groups = {"RegressionUnit","firefox", "iexplore", "safari", "default" }, description = "description  with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void sectionWithMoreChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib superBillData = new BillingUnitTestLib();
		superBillData.workSheetName = "UnitTest_AdminSuperBill";
		superBillData.testCaseId = "TC_USBI_006";
		superBillData.fetchBillingTestData();
		unitTestForSBI(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify unit Test for SuperBillInformationPage
	* @action 		  verify unit Test for SuperBillInformationPage
	* @expected       To Ensure that the unit Test for Super Bill Information Page works fine 
	* @Specification  SRS_BLG_ADMIN_Superbill_Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jan 21, 2014
	***************************************************************************************************/
	
	public boolean unitTestForSBI(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingUnitTestLib superBillData) throws IOException{
		
		Selenium selenium = null;
		//boolean returnValue=false;
		
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
			//  Step-5: Create Super Bill Info//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSBIAddNew),"Could not click the Add New link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(unitTest_addSuperBillInfo(selenium,superBillData)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-6: Create serivce code//
			//--------------------------------------------------------------------//
			assertTrue(unitTest_serviceCode(selenium,superBillData)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Verify Field validation 								  //
			//--------------------------------------------------------------------//
			
			if(!superBillData.alert.equals("")){
				selenium.mouseOver(superBillData.elementId);
				assertTrue(isElementPresent(selenium,superBillData.alert), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium,superBillData.alert).contains(superBillData.alertMessage), "The expected validation message should contain the text - "+superBillData.alertMessage + " The actual validation message shown - " + getText(selenium,superBillData.alert),selenium, ClassName, MethodName);
				return true;
			}else{
			    if(superBillData.testCaseId.equals("TC_USBI_006")){
					if(getValue(selenium,txtSectionLabel).toLowerCase(new java.util.Locale("en","US")).trim().contains(superBillData.sectionLabel.trim().toLowerCase(new java.util.Locale("en","US")))){
					       return false;
					}
			    }
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}
