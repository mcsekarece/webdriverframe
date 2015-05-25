package com.nexia.selenium.testscripts.section.systemsettings.directories;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class EditPayerAdmin extends AbstractSystemSettingsTest {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing New Payer Admin")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPayerAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib payerAdminData = new SystemSettingsLib();
		payerAdminData.workSheetName = "PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_005";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
		
  }
	
	/**
	 * create PayerAdmin
	 * function to create PayerAdmin 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	   @throws      Jagmit Singh
	 * @since  	    July 11, 2013
	*/

	
	public boolean createPayerAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib payerAdminData) throws IOException{
		Selenium selenium =null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + payerAdminData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, payerAdminData.userName, payerAdminData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Directories  and Choose Payer Admin			 //
			//--------------------------------------------------------------------//
			
			assertTrue(goToDirectories(selenium, payerAdminData),"Could not navigate to Directories", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,payerAdminData.directoryType);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Check for the pick list									 //
			//--------------------------------------------------------------------//
			
			assertTrue(checkPayerPicklist(selenium),"Picklist will show", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Delete existing PayerAdmin									 //
			//--------------------------------------------------------------------//
			assertTrue(deletePayerAdmin(selenium,payerAdminData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//   Step-6: Create New Payers			   				   				  // 
			//--------------------------------------------------------------------//
						
			assertTrue(click(selenium,btnAddNewPayer),"Could not click the add Payers; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createPayers(selenium,payerAdminData, userAccount),"Payers Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//   Step-7: edit  Payers   						   				 // 
			//--------------------------------------------------------------------//
			
			payerAdminData.workSheetName = "PayerAdmin";
			payerAdminData.testCaseId = "TC_PA_006";
			payerAdminData.fetchSystemSettingTestData();
			
			assertTrue(click(selenium,btnEditPayerWizard),"Could not click the Edit Payers Button"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(createPayers(selenium,payerAdminData, userAccount),"Payers Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verifying edited payer Admin		  					  //
			//--------------------------------------------------------------------//
			assertTrue(verifyPayerAdminValuesInSummaryPage(selenium,payerAdminData, userAccount), 
					"Payer Admin details not saved proberly:"+payerAdminData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnDone),"Could not click on Done button; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	 }
}