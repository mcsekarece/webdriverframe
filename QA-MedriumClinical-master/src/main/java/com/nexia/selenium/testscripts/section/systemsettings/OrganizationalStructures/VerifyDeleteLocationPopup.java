package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteLocationPopup extends AbstractSystemSettingsTest {

	@Test(enabled=false)
	// Commenting the Delete testcases for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteLocationPopup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_006";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDeleteLocationPopup(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	/**
	 * createPractices
	 * function to verify DeleteLocation Popup
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    Aug 19, 2012
	 */
	public boolean verifyDeleteLocationPopup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
		{
			Selenium selenium=null;
			boolean returnValue=true;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application //
				//--------------------------------------------------------------------//
			
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pracData .toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
				
				//--------------------------------------------------------------------//
				//---------------  Step-2:Change Switch Role  --------------//
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-2: Go to System Settings and navigate to Practices//
				//--------------------------------------------------------------------//
				Assert.assertTrue(gotoSystemSetting(selenium));
			    waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
				//  Step-3: Delete Practice//
				//--------------------------------------------------------------------//
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				type(selenium, txtSearchBox ,pracData.practiceName);
				waitForPageLoad(selenium);
				click(selenium,btnSearchBox);
				waitForPageLoad(selenium);
				int counter=1;
				while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
					if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(pracData.practiceName)){
						click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a");
						click(selenium,btnYes);
						waitForPageLoad(selenium);
						}
					else {counter++;}
					if(counter>15)
						break;
				}
				
				//--------------------------------------------------------------------//
				//  Step-3: Add Practice//
				//--------------------------------------------------------------------//
			
				assertTrue(click(selenium,btnAddPractice),"Could not find add practice button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(addPractice(selenium,pracData,userAccount),"Practice Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
				//--------------------------------------------------------------------//
				//  Step-3: Add Location //
				//--------------------------------------------------------------------//
				
				SystemSettingsLib pracLocData = new SystemSettingsLib();
				pracLocData.workSheetName = "PortPractice";
				pracLocData.testCaseId = "TC_CPR_006";
				pracLocData.fetchSystemSettingTestData();
				//Add first location for the created practice
				Assert.assertTrue(click(selenium,txtAddLocationButton),"Could not click add location button");
				
				
				Assert.assertTrue(type(selenium,txtLocationName0,pracData.locationCode),"Could not enter location code"+ pracLocData.toString());
				Assert.assertTrue(type(selenium,txtLocationDescription0,pracData.locationName1),"Could not location description"+ pracLocData.toString());
				Assert.assertTrue(type(selenium,txtBillingLocationName0,pracData.locationName1),"Could not enter location name"+ pracLocData.toString());
				
				Assert.assertTrue(type(selenium,txtAddr1Loc1,pracData.address1),"Could not enter address1"+ pracLocData.toString());
				Assert.assertTrue(type(selenium,txtAddr2Loc1,pracData.address2),"Could not enter address2"+ pracLocData.toString());
				Assert.assertTrue(type(selenium,txtCityLoc1 ,pracData.city),"Could not enter city"+ pracLocData.toString());
				
				if(userAccount.equals(CAAccount)){
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBoxLoc1,pracData.stateCA);
					Assert.assertTrue(type(selenium,txtZipLoc1,pracData.zipcodeCa),"Could not enter zipcode"+ pracLocData.toString());
				}else{
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBoxLoc1,pracData.state);
					Assert.assertTrue(type(selenium,txtZipLoc1,pracData.zipcode),"Could not enter zipcode"+ pracLocData.toString());
				}
				click(selenium,btnYes);
				selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBoxLoc1,pracLocData.country);
				
		/*		
				assertTrue(addLocation(selenium,locationData,userAccount),"Add Location  Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);*/
			
				//--------------------------------------------------------------------//
				//  Step-4: Add another Location //
				//--------------------------------------------------------------------//		
			
				
				Assert.assertTrue(click(selenium,txtAddLocationButton),"Could not click add location button");
				Assert.assertTrue(type(selenium,txtLocationName1,pracData.locationCode),"Could not enter location code"+ pracLocData.toString());
				Assert.assertTrue(type(selenium,txtLocationDescription1,pracData.locationName2),"Could not location description"+ pracLocData.toString());
				Assert.assertTrue(type(selenium,txtBillingLocationName1,pracData.locationName2),"Could not enter location name"+ pracLocData.toString());
				
				Assert.assertTrue(type(selenium,txtAddr1Loc2,pracData.address1),"Could not enter address1"+ pracLocData.toString());
				Assert.assertTrue(type(selenium,txtAddr2Loc2,pracData.address2),"Could not enter address2"+ pracLocData.toString());
				Assert.assertTrue(type(selenium,txtCityLoc2 ,pracData.city),"Could not enter city"+ pracLocData.toString());
				if(userAccount.equals(CAAccount)){
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBoxLoc2,pracData.stateCA);
					Assert.assertTrue(type(selenium,txtZipLoc2,pracData.zipcodeCa),"Could not enter zipcode"+ pracLocData.toString());
				}else{
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBoxLoc2,pracData.state);
					Assert.assertTrue(type(selenium,txtZipLoc2,pracData.zipcode),"Could not enter zipcode"+ pracLocData.toString());
				}
				click(selenium,btnYes);
				selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBoxLoc2,pracLocData.country);
				
			  /*assertTrue(addLocation(selenium,locationData,userAccount),"Add Location Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);*/
				
				Assert.assertTrue(click(selenium,btnSave),"Could not click on save button"+ pracData.toString());
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Delete  Location //
				//--------------------------------------------------------------------//	
				Assert.assertTrue(click(selenium,btndelete),"Could not click delete button"+ pracData.toString());
				waitForPageLoad(selenium);
				
				
				if (isElementPresent(selenium,"css=div.popupContent > div")){
					
					return true;
				}
				return false;
				
				
				
				
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	}
	

}


