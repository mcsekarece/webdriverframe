package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures.AdminPractice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteLocationInAdminPractice extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Delete a Location With Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteLocationWithPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_007";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteLocation(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Delete Location
	* @action 		  verifying Delete Location
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 17, 2013
	***************************************************************************************************/
	
	public boolean deleteLocation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
		
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
				//assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
				//waitForPageLoad(selenium);
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
				//  Step-4: Add Practice//
				//--------------------------------------------------------------------//	
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName=DateFormat.format(cal.getTime());
				
				Assert.assertTrue(click(selenium,btnAddPractice),"Could not find add practice button");
				waitForPageLoad(selenium);
				
				
				assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Navigate to Location Page//
				//--------------------------------------------------------------------//
				waitForPageLoad(selenium);
				assertTrue(addLocation(selenium,pracData,userAccount),"could not create the location", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkLocationEdit),"Could not click the edit button from location page", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-6: Verify the stored internal programs						//
				//--------------------------------------------------------------------//
				if(!verifyStoredValues(selenium,pracData,userAccount)){
					Assert.fail("Practice details not saved properly; More Details :"+ pracData.toString());
					returnValue=false;
				}
				assertTrue(click(selenium,btnLocationCancel),"Could not click on done button:" + pracData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				
				//--------------------------------------------------------------------//
				//  Step-7: delete created location in admin practice				//
				//--------------------------------------------------------------------//
				int count=0;
				while(isElementPresent(selenium, "link=Delete")){
					if(getText(selenium, "link=Delete").equalsIgnoreCase("Delete")){
						click(selenium, "link=Delete");
					}
					count++;
					if(count>20){
						break;
					}
				}
				if(getText(selenium,"//div[@id='AdminUserRoleList']/table/tbody/tr["+count+"]/td[3]/div/a").contains(pracData.locationName1)){
					Assert.fail("Location name is not delete properly");
				}else
					return true;
				
				
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	
	
	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib pracData,String account){
		
		if(!getValue(selenium,txtLocationName).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.locationName1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtBillingLocationName).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.locationName1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtnpi).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.groupNpi.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,txtAddr1).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.address1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtAddr1).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.address1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtAddr2).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.address2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(account.equals(CAAccount)){
			if(!getValue(selenium,txtZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.zipcodeCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}else
			if(!getValue(selenium,txtZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.zipcode.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		
		return true;
	}
}
