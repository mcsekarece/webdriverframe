package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectedProgramCheckedOff extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting a Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySelectedProgramCheckOff(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProgram";
		providerData.testCaseId = "TC_CP_002";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySelectedPgmCheckOff(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * verifySelectedPgmCheckOff
	 * function to verify Selected Program CheckOff
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @since  	    july 02,2012
	 */
	
	public boolean verifySelectedPgmCheckOff(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			// Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			/*assertTrue(switchRole(selenium,providerData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to Program 			  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
		    
		    //--------------------------------------------------------------------//
			//  Step-4:Create Program	 										  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal1; 
			cal1=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String uniqueName1=dateFormat.format(cal1.getTime());
			assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBoxProg ,providerData.department),"Could not select a department", selenium, ClassName, MethodName);
			assertTrue(type(selenium,typeProgramName ,providerData.program+uniqueName1),"Could not type a program name" + providerData .toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtdescription,providerData.description),"Could not type a description" + providerData .toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click on organizational structure link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:	select any existing Provider							  //
			//--------------------------------------------------------------------//
			SystemSettingsLib providerData1 = new SystemSettingsLib();
			providerData1.workSheetName = "CreateProvider";
			providerData1.testCaseId = "TC_PO_001";
			providerData1.fetchSystemSettingTestData();
			waitForPageLoad(selenium);			
			if (selenium.isElementPresent(lnkDeleteProvider))					
			{			
				assertTrue(deleteProvider(selenium,providerData1),"Could not delete the provider", selenium, ClassName, MethodName);						
			}
			
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Create Provider //
			//--------------------------------------------------------------------//

			assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProviderWithMandatory(selenium,providerData1),"Provider creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
		
			assertTrue(type(selenium,txtProFirstName,providerData1.firstName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			assertTrue(click(selenium,btnSearchOrg2),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);					
									
			assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium, btnAddButton);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:	Remove the existing Associated Programs					  //
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium,btnIdentifierTypeDel)){
				waitForPageLoad(selenium);
				click(selenium,btnIdentifierTypeDel);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------------------//
			//  Step-7: search the Created Program in the associate program in provider page  //
			//--------------------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			type(selenium, btnSearchProviderBox, providerData.program+uniqueName1);
			click(selenium, btnSearchOrg);
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//verify by default the created program state is not checked
			@SuppressWarnings("unused")
			String programName= null;
			if(!isChecked(selenium, "//input[contains(@id,'checkbox')]")){
				click(selenium, "//input[contains(@id,'checkbox')]");
				programName= getText(selenium, typeProgramName);
			}
			else{
				Assert.fail("by default the created program state is not checked off");
			} 
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//----------------------------------------------------------------------------//
			//  Step-8: verify the associated program added in the Selected Programs list //
			//----------------------------------------------------------------------------//
			if(isElementPresent(selenium,"//a[contains(text(),'Delete')")){
				Assert.fail("associated program does not add in the Selected Programs list");
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Remove the newly added Associated Programs 				  //
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium,btnIdentifierTypeDel)){
				waitForPageLoad(selenium);
				click(selenium,btnIdentifierTypeDel);
				waitForPageLoad(selenium);
			}
			
			//verify the deleted associated program state checked off
			if(isChecked(selenium, "//div[@class='listItem']/table/tbody/tr/td/span/input")){
				Assert.fail("deleted associated program state is still checked on");
			}
			
	
			//--------------------------------------------------------------------//
			//  Step-10: Delete the created Program								  //
			//--------------------------------------------------------------------//
			click(selenium,btnCancel);
			
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click on organizational structure link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			int counter1=(Integer)selenium.getXpathCount(lnkSelectedProgram1);
			while(getText(selenium,lnkSelectedProgram).contains(providerData.program+uniqueName1)){
				if(getText(selenium,"//div[@id='programs']/table/tbody/tr["+counter1+"]/td/div/div/span").contains(providerData.program+uniqueName1)){
					if(isElementPresent(selenium, "//div[@id='programs']/table/tbody/tr["+counter1+"]/td[2]/div/a")){
						click(selenium,"//div[@id='programs']/table/tbody/tr["+counter1+"]/td[2]/div/a");
						waitForPageLoad(selenium);
						click(selenium,btnYes);
						waitForPageLoad(selenium);
					}
				}
				counter1--;
			}
			
			if(getText(selenium,lnkSelectedProgram).contains(providerData.program+uniqueName1)){
				Assert.fail("Could not delete the created program");
			}
			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + providerData.toString(), selenium, ClassName, MethodName);
		}
		return true;
	
	}
}