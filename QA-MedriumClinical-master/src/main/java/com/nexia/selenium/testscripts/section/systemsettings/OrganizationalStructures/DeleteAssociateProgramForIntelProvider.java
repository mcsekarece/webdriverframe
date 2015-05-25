package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteAssociateProgramForIntelProvider extends AbstractSystemSettingsTest{
	@Test(enabled=false)
	// Commenting the Delete testcases for the Organization Structure only	
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting a Program in Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteAssociateProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_004";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteProgramInProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 *  deleteProgramInProvider
	 * function to delete Program InProvider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 
	 
	 * @since  	     June 06, 2010
	 */
	
public boolean  deleteProgramInProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws IOException{
		
		Selenium selenium=null;
		
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
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			
			
			//--------------------------------------------------------------------//
			//  Step-4:search and delete Provider //
			//--------------------------------------------------------------------//
			assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-:Add Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProviderWithMandatory(selenium,providerData),"Provider creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if((getText(selenium, btnSearchOrg2).equalsIgnoreCase("Search"))){
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtProFirstName,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnSearchOrg2), "Could not click on search button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else{
				int counter=1;
				while(isElementPresent(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div")){
					if(getText(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div").contains(providerData.practice)){
						click(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div");
						waitForPageLoad(selenium);
					}else {counter++;}
					if(counter>10){
						Assert.fail("Could not click the practice name");
					}
				}
				
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-6:Delete a program //
			//--------------------------------------------------------------------//
			assertTrue(addProgramInProvider(selenium,providerData),"Could not add program in provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteProgramInProvider(selenium,providerData),"Could not delete program in provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return false;
	}
}

