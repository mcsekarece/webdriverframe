package com.nexia.selenium.testscripts.section.systemsettings.directories;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreatePlanPayersAdmin  extends AbstractSystemSettingsTest {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding New Plan for Payer Admin")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPayerAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib payerAdminData = new SystemSettingsLib();
		payerAdminData.workSheetName = "PayerAdmin";
		payerAdminData.testCaseId = "TC_PA_004";
		payerAdminData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
    }
	
	/**
	 * createPlan PayerAdmin
	 * function to create PayerAdmin 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	   @throws      Jagmit Singh
	 * @since  	    July 10, 2013
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
			//  Step-4:Delete exist PayerAdmin									 //
			//--------------------------------------------------------------------//
			assertTrue(deletePayerAdmin(selenium,payerAdminData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//   Step-5: Create  Payers			   								 // 
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddNewPayer),"Could not click the add Payers; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createPayersMandatory(selenium,payerAdminData, userAccount),"Payers Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-6: Click Next button twice and Add Plan			  					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNext),"Could not click on next button; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNext),"Could not click on next button; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,btnAddNewPlan),"Could not click on next button; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createPayersPlan(selenium,payerAdminData, userAccount),"Payers Plan Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify the Saved Payers Plan		  					  //
			//--------------------------------------------------------------------//
			if(!verifyPayersPlanValuesInSummaryPage(selenium,payerAdminData, userAccount)){
				Assert.fail("Payer Admins details not saved proberly:"+payerAdminData.toString());
				return false;
			} 
			
			assertTrue(click(selenium,btnDone),"Could not click on Done button; More details"+payerAdminData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}	