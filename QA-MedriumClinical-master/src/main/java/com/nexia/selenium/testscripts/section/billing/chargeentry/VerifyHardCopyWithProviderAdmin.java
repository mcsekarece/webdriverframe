package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHardCopyWithProviderAdmin extends AbstractSystemSettingsTest {
    	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify hard copy check box")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyHardCopyWithProviderAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	    SystemSettingsLib payerAdminData = new SystemSettingsLib();
    	    payerAdminData.workSheetName = "PayerAdmin";
    	    payerAdminData.testCaseId = "TC_PA_010";
    	    payerAdminData.fetchSystemSettingTestData();
    	    ClassName=this.getClass().getName().substring(39);		
    	    MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
    	    verifyhardCopy(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	
    	/**
	 * verifyhardCopy
	 * function to  associate Program For Internal Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 
	 *  @since  	    Feb 10, 2013
	 */
	public boolean  verifyhardCopy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
		    
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Provider //
			//--------------------------------------------------------------------//
			assertTrue(gotoSystemSetting(selenium),"",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,fstProvider),"Could not click first provider",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Remove existing payers
			//--------------------------------------------------------------------//
			int count=1;
			while(isElementPresent(selenium,"//div[3]/div/div/div[4]/div/div[2]/table/tbody/tr[1]/td[2]/div/a")){
			    click(selenium,"//div[3]/div/div/div[4]/div/div[2]/table/tbody/tr[1]/td[2]/div/a");
			    waitForPageLoad(selenium);
			    count++;
			    if(count>10){
				break;
			    }
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Associate Payer
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAssociateProvider),"Could not click Associate Provider link",selenium, ClassName, MethodName);
			SystemSettingsLib payerAdminData = new SystemSettingsLib();
			payerAdminData.workSheetName = "PayerAdmin";
			payerAdminData.testCaseId = "TC_PA_010";
			payerAdminData.fetchSystemSettingTestData();
			
			selectValueFromAjaxList(selenium,payerSearchSugguestBox,payerAdminData.payerName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,payerSearchSugguestBox,"paper");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnPRSave),"Could not click save",selenium, ClassName, MethodName);
			
			HomeLib payerData = new HomeLib();
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_023";
			payerData.fetchHomeTestData();
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Payer to the patient
			//--------------------------------------------------------------------//
			
			assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnMedicalPayersCA),"Could not click the Medical Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
//			assertTrue(click(selenium, btnPatientMedicalPayers), "Could not click New button", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			String date="";
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
			}else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			
			click(selenium,ajxPayerSelect);
			assertTrue(selectValueFromAjaxList(selenium,ajxPayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtPayerStartDate,date), "Could not enter start Date",selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxRelationShip,payerData.relationshipStatus),"Could not select Relationship Status"+ payerData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			BillingLib chargeEntryData = new BillingLib();
			chargeEntryData.workSheetName = "ChargeEntry";
			chargeEntryData.testCaseId = "TC_CE_016";
			chargeEntryData.fetchBillingTestData();
			
			assertTrue(switchRole(selenium, chargeEntryData.switchRole), "Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			    
			/*assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			// --------------------------------------------------------------------//
			// Step-9: Go to Post New Charge
			// --------------------------------------------------------------------//
			    
			assertTrue(goToPostNewCharge(selenium, chargeEntryData,payerData ),"Navigation Failed", selenium, ClassName, MethodName);
			
			// --------------------------------------------------------------------//
			// Step-10: Verify Hard Copy
			// --------------------------------------------------------------------//
			
			if(!isChecked(selenium,chkHardCopy)){
			    Assert.fail("Hard Copy Check Failed");
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
	