package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class EditProvider extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateIdentifierGroups";
		providerData.testCaseId = "TC_IDG_001";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * editProvider
	 * function to edit Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
public boolean editProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		
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
			//  Step-2: Go to System Settings and navigate to Provider //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3: Create Identifier Group //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkIdentifierGroup),"could not click indentifieer link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllIdentifiersGroup(selenium),"delete indentifiers failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdGroup(selenium,providerData),"Identifier Groups Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			providerData.workSheetName = "CreateIdentifierTypes";
			providerData.testCaseId = "TC_IDT_003";
			providerData.fetchSystemSettingTestData();
			//---------------------------------------------------------- ----------//
			//  Step-4: Deleting existing Identifier Types  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkIdentifierType),"could not click indentifier type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllIdentifiersTypes(selenium),"delete indentifiers failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-5: Add a new Identifier Types
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddIdentifierType),"Could not click on Add Identifier Type link:" + providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdType(selenium,providerData),"Identifier Types Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Delete Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			providerData.workSheetName = "CreateProvider";
			providerData.testCaseId = "TC_PO_001";
			providerData.fetchSystemSettingTestData();
			waitForPageLoad(selenium);
			assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Create Provider //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddMMyyHHmm");
			String providerCodeUnique=DateFormat.format(cal.getTime());

			assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProviderCAView(selenium,providerData,providerCodeUnique,userAccount),"Provider creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);

			
			if((getText(selenium, btnSearchOrg2).equalsIgnoreCase("Search"))){
				assertTrue(type(selenium,txtProviderSearchbox,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-8: Search Provider //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,btnSearchOrg2),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
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
			//  Step-9: Edit Details of the provider   //
			//--------------------------------------------------------------------//
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("ddMMyyHHmm");
			String providerCodeUnique1=DateFormat1.format(cal1.getTime());
			providerData.workSheetName = "CreateProvider";
			providerData.testCaseId = "TC_PO_002";
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,providerData.specialty.trim()),"Selected speciality not saved properly",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnEdit1),"Could not click the edit button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(editProvider(selenium,providerData,providerCodeUnique1,userAccount),"Provider Edited Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			
			
			
			//--------------------------------------------------------------------//
			//  Step-10: Search Provider //
			//--------------------------------------------------------------------//
			
			if((getText(selenium, btnSearchOrg2).equalsIgnoreCase("Search"))){
				assertTrue(type(selenium,txtProviderSearchbox,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSearchOrg2),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else{
				int counter=1;
				while(isElementPresent(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div")){
					if(getText(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div").contains(providerData.firstName)){
						click(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div");
						waitForPageLoad(selenium);
					}else {counter++;}
					if(counter>10){
						Assert.fail("Could not click the practice name");
					}
				}
				
			}
			
			//--------------------------------------------------------------------//
			//  Step-11: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(isTextPresent(selenium,providerData.specialty.trim()),"Selected speciality not saved properly",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnEdit1),"Could not click the edit button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!verifyStoredValues(selenium,providerData,userAccount)){
				Assert.fail("User details not saved properly; More Details :"+ providerData.toString());
				returnValue=false;
			}else
				return returnValue;
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib providerData, String userAccount) throws IOException{
		assertTrue(getValue(selenium,ajxProviderTypesuggestBox).trim().contains(providerData.providerType.trim())," ", selenium, ClassName, MethodName);
		/*if(!getValue(selenium,txtProviderCode).trim().contains(providerCodeUnique.trim())){
			return true;
		}*/
	
		assertTrue(getValue(selenium, ajxTitleSuggestBox).trim().contains(providerData.title.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtLastName).trim().contains(providerData.lastName.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium, txtFirstName).trim().contains(providerData.firstName.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtMiddleName).trim().contains(providerData.middleName.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtCredentials).trim().contains(providerData.credentials.trim())," ", selenium, ClassName, MethodName);
		
		//assertTrue(getValue(selenium,txtChosenSpecialitySuggBox).trim().contains(providerData.specialty.trim())," ", selenium, ClassName, MethodName);
		
		//assertTrue(getText(selenium,tabChosenLanguagePanel).trim().contains("Spanish"),"language not selected properly",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxGendersuggestBox ).trim().contains(providerData.gender.trim())," ", selenium, ClassName, MethodName);
		
		if(true){}
		System.out.println(getText(selenium,ajxLanguagesuggestBox).trim());
		System.out.println(providerData.language.trim());
		
		assertTrue(!isTextPresent(selenium,providerData.language)," ", selenium, ClassName, MethodName);
		
		try{
			String cell =getValue(selenium,txtCellPhone).trim();
			String temp=cell.replace("(", "");
			System.out.println(cell);
			temp=temp.replace(")","");
			temp=temp.replace("-","");
			assertTrue(temp.contains(providerData.cellPhone.trim())," ", selenium, ClassName, MethodName);
		}
		catch(Exception e)
		{
			System.out.println("Error");

		}
		
		String pager=getValue(selenium,txtPager).trim();
		String Pager= pager.replace("(", "");
		Pager=Pager.replace(")","");
		Pager=Pager.replace("-","");
		assertTrue(Pager.contains(providerData.pager.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtEmail ).trim().contains(providerData.email.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxMaximumFTESuggestBoxsuggestBox).trim().contains(providerData.maximumFte.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxHoursWorked).trim().contains(providerData.hoursWorked.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtcmt).trim().contains(providerData.comments.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium, txtMailingStreet1).trim().contains(providerData.address1.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtMailingStreet2 ).trim().contains(providerData.address2.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,"mailingOfficePhone").trim().contains(providerData.officePhone.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtMailingOfficePhoneExt).trim().contains(providerData.officePhone1.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtMailingFax).trim().contains(providerData.fax.trim())," ", selenium, ClassName, MethodName);
/*		
		assertTrue(getValue(selenium,  txtDea ).trim().contains(providerData.dEA.trim())," ", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,txtUpinPro).trim().contains(providerData.uPIN.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtNpi).trim().contains(providerData.nPI.trim())," ", selenium, ClassName, MethodName);*/
		
		//assertTrue(getValue(selenium,ajxReportMethodsuggestBox).trim().contains(providerData.reportMethod.trim())," ", selenium, ClassName, MethodName);
		return true;	
}
}		
