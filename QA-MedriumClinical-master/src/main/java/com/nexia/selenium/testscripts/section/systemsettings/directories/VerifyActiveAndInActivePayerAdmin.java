package com.nexia.selenium.testscripts.section.systemsettings.directories;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyActiveAndInActivePayerAdmin extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Active and InActive Payer Admin")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void activeAndInActivePayerAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib payerAdminData = new SystemSettingsLib();
		payerAdminData.workSheetName = "PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_001";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		activeAndInActivePayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);

    }
	
	/*************************************************************************************************** 
	* @purpose        To verify active And InActive PayerAdmin 
	* @action 		  verify active And InActive PayerAdmin 
	* @expected       To Ensure that the active And InActive PayerAdmin  works fine    
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both (US and Canada)
	* @since  	      Dec 17, 2013
	***************************************************************************************************/
	
	public boolean activeAndInActivePayerAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib payerAdminData) throws IOException{
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
			//  Step-2: Navigate to Directories  and Choose Payer Admin			 //
			//--------------------------------------------------------------------//			
			assertTrue(goToDirectories(selenium, payerAdminData),"Could not navigate to Directories", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,payerAdminData.directoryType);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Check for the pick list									 //
			//--------------------------------------------------------------------//
			assertTrue(checkPayerPicklist(selenium),"Picklist will show", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete existing PayerAdmin									 //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,txtSearchBox,payerAdminData.payerName),"Could not seacrh the payer name", selenium, ClassName, MethodName);
			selenium.focus(txtSearchBox);
			selenium.fireEvent(txtSearchBox, "\\13");
			selenium.typeKeys(txtSearchBox, "a");
			
			 Assert.assertTrue(click(selenium, btnDeletePayerAdmin), "Could not click the delete button");
			 Assert.assertTrue(click(selenium, btnYes), "Could not click the yes button in delete pop up");
			
			//--------------------------------------------------------------------//
			//   Step-5: Create New Payers			   							  // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddNewPayer),"Could not click the add Payers; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createPayers(selenium,payerAdminData, userAccount),"Payers Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnDone),"Could not click on Done button; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//   Step-6: delete Created Payers			   						 // 
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,txtSearchBox,payerAdminData.payerName),"Could not seacrh the payer name", selenium, ClassName, MethodName);
			selenium.focus(txtSearchBox);
			selenium.fireEvent(txtSearchBox, "\\13");
			selenium.typeKeys(txtSearchBox, "a");
			
			 assertTrue(click(selenium, btnDeletePayerAdmin), "Could not click the delete button", selenium, ClassName, MethodName);
			
			 assertTrue(click(selenium, btnYes), "Could not click the yes button in delete pop up" , selenium, ClassName, MethodName);
			 
			//--------------------------------------------------------------------//
			//   Step-7: Verify Deleted Payers Details			   				// 
			//--------------------------------------------------------------------//
			 assertTrue(getText(selenium, lblPayerSummary).contains(payerAdminData.payerName), 
					 "Record is not deleted Properly", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//   Step-8: Verify Inactive Payers Details			   				// 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, chkIncludeInactivescheckbox), "could not able to click  for Inactive Directies check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(getText(selenium, lblPayerSummary).contains(payerAdminData.payerName), 
					"Record is not deleted Properly", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//   Step-9:Change Inactive to Active Payers Details			   	 // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnActivateInactive) ,"could not able to click the Activate Payers ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium, btnYesButton) , "could not able to click the yes in the activate Payers", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);	
			
			//Verify Active Payer Details
			
			assertTrue(click(selenium, chkIncludeInactivescheckbox), "could not able to click  for Inactive Directies check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(getText(selenium,lblPayerSummary).trim().contains("Inactive"), 
					"The Include inactive details are getting displayed", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
