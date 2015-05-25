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

public class DeleteAdminPractice extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Delete a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteNewPractices(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_001";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deletePractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        verify Delete Practice 
	* @action 		  verifying Delete Practice 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 16, 2013
	***************************************************************************************************/
	 
	public boolean deletePractices(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
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
				
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName=DateFormat.format(cal.getTime());
				
				assertTrue(addAdminPractice(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnEdit1),"Could not click the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-4: Verify the stored internal programs						//
				//--------------------------------------------------------------------//
				if(!verifyStoredValues(selenium,pracData,userAccount)){
					Assert.fail("Practice details not saved properly; More Details :"+ pracData.toString());
					returnValue=false;
				}
				assertTrue(click(selenium,btnDonePratice),"Could not click on done button:" + pracData .toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				type(selenium, txtSearchBox ,pracData.practiceName);
				waitForPageLoad(selenium);
				click(selenium,btnSearchBox);
				waitForPageLoad(selenium);
				
				int count=1;
				while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div")){
					if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div").contains(pracData.practiceName)){
						click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td[2]/div/a");
						click(selenium,btnYes);
						waitForPageLoad(selenium);
					}
					else {count++;}
					if(count>15)
						break;
				}
				
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	
	
	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib pracData,String account){
		
		
		/*assertTrue(type(selenium, txtSearchBox ,pracData.practiceName),"Could not type the practice Name");
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSearchBox),"Could not click the search button");
		waitForPageLoad(selenium);
		int count=1;
		while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div")){
			if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div").contains(pracData.practiceName)){
				click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div");
				break;
			}
			else {count++;}
			if(count>15)
				break;
		}*/
		
		
		if(!getValue(selenium,btnPracticeName).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!account.equals(CAAccount)){
		if(!getValue(selenium,btnTaxId).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.taxId.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		}
		if(!getValue(selenium,txtEmail ).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajxCommTy1suggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.primaryPhoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhone).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.verifyPhoneNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhoneExt).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.primaryPhoneExtn1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajxCommTy2suggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.primaryPhoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1 ).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.verifyPhoneNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1Extn).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.primaryPhoneExtn2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajxCommTy3suggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.primaryPhoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.verifyPhoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2Extn).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.primaryPhoneExtn3.trim().toLowerCase(new java.util.Locale("en","US")))){
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
