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

public class VerifyCentralizedBillingDetails extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Centralized Billing Address ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void centralizedBillingDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_007";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyBillingDetails(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Centralized Billing Details
	* @action 		  verifying Centralized Billing Details
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 17, 2013
	***************************************************************************************************/
	
	public boolean verifyBillingDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
		
			Selenium selenium=null;
			boolean returnValue=false;
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
				//  Step-4: Add Practice//
				//--------------------------------------------------------------------//	
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName=DateFormat.format(cal.getTime());
				
				Assert.assertTrue(click(selenium,btnAddPractice),"Could not find add practice button");
				waitForPageLoad(selenium);
				
				SimpleDateFormat DateFormat2=new SimpleDateFormat("HH:mm");
				String time=DateFormat2.format(cal.getTime());
				
				assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Navigate to Centrailized page//
				//--------------------------------------------------------------------//	
				//assertTrue(click(selenium,btnNextOne),"could not click on next button",selenium, ClassName, MethodName);
				//waitForPageLoad(selenium);
				
				assertTrue(addLocation(selenium,pracData,userAccount),"could not create the location", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnNextOne),"could not click on next button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(!isChecked(selenium,chkCentralised)){
					assertTrue(click(selenium,chkCentralised),"Could not click on centralised check box :" + pracData .toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				
				
				//--------------------------------------------------------------------//
				//  Step-6: Verify billing Details//
				//--------------------------------------------------------------------//	
				/*if(!verifyBillingDetails(selenium, pracData, userAccount)){
					Assert.fail("Billing Details are not saved properly");
				}else{
					returnValue = true;
				}*/
				
				//--------------------------------------------------------------------//
				//  Step-7: Update billing Details//
				//--------------------------------------------------------------------//	
				Assert.assertTrue(type(selenium,txtBillingLocationName,pracData.locationName1),"Could not enter Billing location"+ pracData.toString());
				Assert.assertTrue(type(selenium,txtBillingAddr1,pracData.billlingaddress1),"Could not enter address1"+ pracData.toString());
				Assert.assertTrue(type(selenium,txtBillingAddr2,pracData.billingaddress2),"Could not enter address2"+ pracData.toString());
				Assert.assertTrue(type(selenium,txtCityPro ,pracData.billingcity),"Could not enter city"+ pracData.toString());
				selectValueFromAjaxList(selenium, txtBillingStateSuggestBox,"Alberta");
				if(userAccount.equals(CAAccount)){
					Assert.assertTrue(type(selenium,txtBillingZip,pracData.billingzipcodeCA),"Could not enter zipcode"+ pracData.toString());
				}else
					Assert.assertTrue(type(selenium,txtBillingZip,pracData.billingzipcode),"Could not enter zipcode"+ pracData.toString());
				click(selenium,btnYes);
				selectValueFromAjaxList(selenium,ajxBillingCountrySuggestBox,pracData.billingcountry);
			
				assertTrue(click(selenium,btnDonePratice),"could not click on done button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-8: Verify Store Value Details//
				//--------------------------------------------------------------------//	
				
				if(!verifyStoreValueDetails(selenium,pracData,userAccount,time)){
					Assert.fail("Details is not saved properly");
				}else{
					returnValue = true;
				}
				
				
			
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	

	public boolean verifyBillingDetails(Selenium selenium,SystemSettingsLib pracData,String account){
		
		if(!getValue(selenium,txtAddr1).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.address1)){
			return false;
		}
		if(!getValue(selenium,txtAddr1).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.address1)){
			return false;
		}
		if(!getValue(selenium,txtAddr2).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.address2)){
			return false;
		}
		
		if(account.equals(CAAccount)){
			if(!getValue(selenium,txtZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.zipcodeCa)){
				return false;
			}
		}else
			if(!getValue(selenium,txtZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.zipcode)){
				return false;
			}
		
		return true;
	}
	
	public boolean verifyStoreValueDetails(Selenium selenium,SystemSettingsLib pracData,String account, String time){
		
		if(!selenium.isTextPresent(pracData.practiceName)){
			return false;
		}
		if(!selenium.isTextPresent(pracData.address1)){
			return false;
		}
		if(!selenium.isTextPresent(pracData.address2)){
			return false;
		}
		
		if(account.equals(CAAccount)){
			if(!selenium.isTextPresent(pracData.zipcodeCa)){
				return false;
			}
		}else
			if(!selenium.isTextPresent(pracData.zipcode)){
				return false;
			}
		
		if(!selenium.isTextPresent(pracData.billlingaddress1)){
			return false;
		}
		/*if(!selenium.isTextPresent(pracData.billingaddress2)){
			return false;
		}*/
		
		if(account.equals(CAAccount)){
			if(!selenium.isTextPresent(pracData.billingzipcodeCA)){
				return false;
			}
		}else
			if(!selenium.isTextPresent(pracData.billingzipcode)){
				return false;
			}
		
		if(!selenium.isTextPresent(time)){
			return false;
		}
		
		return true;
	}
	
	
}
