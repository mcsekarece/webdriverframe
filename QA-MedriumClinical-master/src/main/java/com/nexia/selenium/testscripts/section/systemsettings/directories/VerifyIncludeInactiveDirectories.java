package com.nexia.selenium.testscripts.section.systemsettings.directories;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyIncludeInactiveDirectories extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Include Inactive Directories")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncludeInactiveDirectories(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib payerAdminData = new SystemSettingsLib();
		payerAdminData.workSheetName = "PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_001";
		payerAdminData.fetchSystemSettingTestData();
		verifyIncludeInactiveDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify Include Inactive Directories
	* @action 		  Verifying Include Inactive Directories
	* @author         Aspire QA
	* @throws 	      IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 08, 2013
	***************************************************************************************************/

	public boolean verifyIncludeInactiveDirectories(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib payerAdminData) throws IOException{
		Selenium selenium =null;
		boolean returnValue=false;
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
			selectValueFromAjaxList(selenium,ajxDirectoryType,payerAdminData.directoryType);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Check for the pick list									 //
			//--------------------------------------------------------------------//
			assertTrue(checkPayerPicklist(selenium),"Picklist will show", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete existing PayerAdmin									 //
			//--------------------------------------------------------------------//
			assertTrue(deletePayerAdmin(selenium,payerAdminData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//   Step-5: Create New Payers			   							  // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddNewPayer),"Could not click the add Payers; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createPayers(selenium,payerAdminData, userAccount),"Payers Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify created payer Admin		  					     //
			//--------------------------------------------------------------------//
			assertTrue(verifyPayerAdminValuesInSummaryPage(selenium,payerAdminData, userAccount), 
					"Payer Admin details not saved properly:"+payerAdminData.toString(), selenium, ClassName, MethodName);
			 
			assertTrue(click(selenium,btnDone),"Could not click the done button; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-7:Delete the created PayerAdmin							  //
			//--------------------------------------------------------------------//
			assertTrue(deletePayerAdmin(selenium,payerAdminData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Activate include inactive     							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,chkIncludeInactivescheckbox),"Could not click the include inactive; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium, txtSearchBox,payerAdminData.payerName ),"Could not type the Payer name; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			selenium.focus(txtSearchBox);
			selenium.keyPress(txtSearchBox, "\\13");
			waitForPageLoad(selenium);
									
			assertTrue(click(selenium,lblInactiveEntry),"Could not find inactive entry; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnActivateInactive),"Could not activate the inactive payer; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify the Activated include inactive Payer  			  //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isTextPresent("Activate"), "Activation Failed", selenium, ClassName, MethodName);
						
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}	
