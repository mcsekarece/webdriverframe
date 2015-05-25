package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures.AssociatedPayer;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class EditAssociatepayerInProvider extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Remove a Associate Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editAssociatePayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_004";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPayer(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * editPayer
	 * function to 	edit Payer
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @since  	    Feb 20, 2010
	 */
	public boolean editPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		
		Selenium selenium=null;
		boolean returnValue=false;
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
			//  Step-3: Go to System Settings and navigate to Provider //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			
			assertTrue(gotoSystemSetting(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create Provider //
			//--------------------------------------------------------------------//
			

			assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProviderWithMandatory(selenium,providerData),"Provider creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtProFirstName,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Search Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnSearchOrg2),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Add Assoociate Payer //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAddAssociatePayer),"Could not click the Add Associate Payer Link"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Search Payer //
			//--------------------------------------------------------------------//
			SystemSettingsLib payerData = new SystemSettingsLib();
			payerData.workSheetName = "PortAddPayers";
			payerData.testCaseId = "TC_AP_001";
			payerData.fetchSystemSettingTestData();
			
			assertTrue(addPayer(selenium,payerData,providerData ),"Could not add the Payer", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Edit Payer //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEditAssociatePayer1),"Could not click the edit button button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			providerData.workSheetName = "CreateProvider";
			providerData.testCaseId = "TC_PO_004";
			providerData.fetchSystemSettingTestData();
			if(userAccount.equals("US2000")){
			assertTrue(selectValueFromAjaxList(selenium,ajxEDIStatus,providerData.eDIStatus),"", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtProviderId,providerData.providerId ),"Could not enter the Provider id", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxAlernateProvider,providerData.alernateProvider),"", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtGroupId,providerData.groupId ),"Could not enter the Group id", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtTaxonomy,providerData.providerId ),"Could not enter the Taxonomy Id", selenium, ClassName,MethodName);
			}
			
			assertTrue(click(selenium,APayerSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data" + providerData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
