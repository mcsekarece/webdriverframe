package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class CreateAdminSuperBillPortability extends AbstractBilling{
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Super Bill")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addSuperBill(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillSetUp";
		superBillData.testCaseId = "TC_SBS_012";
		superBillData.fetchBillingTestData();
		addAdminSuperBill(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify Add Admin Super Bill Set Up
	* @action 		  verify Add Admin Super Bill Set Up
	* @expected       To Ensure that the Add Admin Super Bill Set Up works fine 
	* @Specification  SRS_BLG_ADMIN_Superbill_Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jan 07, 2014
	***************************************************************************************************/
	
	public boolean addAdminSuperBill(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue=false;
		
		String uniqueName ="";
		boolean verifyCreatedBill=false;
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
			
			if(!searchAdminSuperBill(selenium, superBillData)){
				//--------------------------------------------------------------------//
				//  Step-5: Create Bill Info//
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkSBIAddNew),"Could not click the Add New link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//assertTrue(addSuperBillInfo(selenium,superBillData,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
				//waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Create Service code //
				//--------------------------------------------------------------------//
				assertTrue(addServiceCode(selenium,superBillData,userAccount,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				verifyCreatedBill = true;
				waitForPageLoad(selenium);
			}else{
				if(!verifyStoreValue(selenium,superBillData,userAccount)){
					waitForPageLoad(selenium);
					assertTrue(click(selenium,lnkEditSuperBill),"Could not click the Edit link",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					//assertTrue(addSuperBillInfo(selenium,superBillData,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
					//waitForPageLoad(selenium);
					
					assertTrue(addServiceCode(selenium,superBillData,userAccount,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					verifyCreatedBill = true;
				}
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Store Value//
			//--------------------------------------------------------------------//
			if(verifyCreatedBill){
				if(!verifyStoreValue(selenium,superBillData,userAccount)){
					Assert.fail("Super Bill details are not Create properly; More Details :"+ superBillData.toString());
					
				}else
					returnValue = true;
			}
			

			}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean searchAdminSuperBill(Selenium selenium, BillingLib superBillData ) throws IOException{
		boolean superDataPresent = false; 
		assertTrue(type(selenium,ajxSearch,superBillData.templateName),"Could not type the template Name", selenium, ClassName, MethodName);
		selenium.keyPress(ajxSearch, "\\13");
		waitForPageLoad(selenium);
		if(getText(selenium,lblSummerySuperBill).contains(superBillData.templateName)){
			superDataPresent = true;
			
		}else{
			assertTrue(click(selenium,chkInactiveSuperBill),"Could not check the inactive Super Bill check box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium,lblSummerySuperBill).toLowerCase().contains(superBillData.templateName.toLowerCase())){
				assertTrue(click(selenium,"//a[contains(text(),'Activate')]"),"Could not click  the Activate Button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnYes),"Could not click the yes button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				superDataPresent = true;
			}
		}

		return superDataPresent;
	}
	
	
	
	//Verify Store Value Details in Summary and Edit page
	public boolean verifyStoreValue(Selenium selenium, BillingLib superBillData, String account) throws IOException{
		if(!getText(selenium,lblSummerySuperBill).toLowerCase().contains(superBillData.templateName.toLowerCase())){
			return false;
		}
		
		if(!getText(selenium,lblSummerySuperBill).toLowerCase().contains(superBillData.specialty.toLowerCase())){
			return false;
		}
		
		
		
		assertTrue(click(selenium,lnkEditSuperBill),"Could not click the Edit link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!getValue(selenium,txtTempletaName).contains(superBillData.templateName)){
			return false;
		}
		
		if(!getValue(selenium,ajxSpecialty).contains(superBillData.specialty)){
			return false;
		}
		
		assertTrue(click(selenium,btnSBINext),"Could not click the next button", selenium, ClassName, MethodName);
		
		if(!getValue(selenium,txtSectionLabel).contains(superBillData.sectionLabel)){
			return false;
		}
		
		if(account.equals(CAAccount)){
			if(!getValue(selenium,ajxSCServiceCode).contains(superBillData.serviceCodeCA)){
				return false;
			}
		}else{
			if(!getValue(selenium,ajxSCServiceCode).contains(superBillData.serviceCode)){
				return false;
			}
		}
		if(!getValue(selenium,ajxSCModifiers1).contains(superBillData.modifiers)){
			return false;
		}
		
		if(!getValue(selenium,ajxSCModifiers2).contains(superBillData.modifiers1)){
			return false;
		}
		
		assertTrue(click(selenium,btnSBINext),"Could not click the Next button", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,btnSBIDone),"Could not click the Done button", selenium, ClassName, MethodName);
		
		return true;
	}
	
}
