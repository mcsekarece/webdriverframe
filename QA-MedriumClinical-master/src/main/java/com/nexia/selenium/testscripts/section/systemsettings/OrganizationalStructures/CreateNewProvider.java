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

public class CreateNewProvider extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateIdentifierGroups";
		providerData.testCaseId = "TC_IDG_001";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * createProvider
	 * function to create Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public boolean createProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		
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
				//  Step-3: Go to System Settings and navigate to Provider //
				//--------------------------------------------------------------------//
				
				waitForPageLoad(selenium);
				Assert.assertTrue(gotoSystemSetting(selenium));
				waitForPageLoad(selenium);	
				
				//--------------------------------------------------------------------//
				//  Step-4: Create Identifier Group //
				//--------------------------------------------------------------------//
			    assertTrue(click(selenium,lnkIdentifierGroup),"could not click Identifier group", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(deleteAllIdentifiersGroup(selenium),"Delete all indentifier group failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createIdGroup(selenium,providerData),"Identifier Groups Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-5: Create Identifier Type //
				//--------------------------------------------------------------------//
			
				providerData.workSheetName = "CreateIdentifierTypes";
				providerData.testCaseId = "TC_IDT_003";
				providerData.fetchSystemSettingTestData();
				//---------------------------------------------------------- ----------//
				//  Step-6: Deleting existing Identifier Types  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkIdentifierType),"Delete all identifiers failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(deleteAllIdentifiersTypes(selenium),"Delete all identifiers type failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//---------------------------------------------------------- ----------//
				//  Step-7: Add a new Identifier Types
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, btnAddIdentifierType),"Could not click on Add Identifier Type link:" + providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createIdType(selenium,providerData),"Identifier Types Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-8: Delete Provider //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
				providerData.workSheetName = "CreateProvider";
				providerData.testCaseId = "TC_PO_001";
				providerData.fetchSystemSettingTestData();
				waitForPageLoad(selenium);
				assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-9: Create Provider //
				//--------------------------------------------------------------------//
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("ddMMyyHHmm");
				String providerCodeUnique=DateFormat.format(cal.getTime());

				assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createProviderCAView(selenium,providerData,providerCodeUnique,userAccount),"Provider creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);

				assertTrue(type(selenium,txtProviderSearchbox,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);

				//--------------------------------------------------------------------//
				//  Step-10: Search Provider //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,btnSearchOrg2),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(isTextPresent(selenium,providerData.specialty.trim()),"Selected speciality not saved properly",selenium,ClassName,MethodName);
				//--------------------------------------------------------------------//
				//  Step-11: Verifying Entered Details are saved properly  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,btnEdit1),"Could not click the edit button"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!verifyStoredValues(selenium,providerData,providerCodeUnique)){
					Assert.fail("User details not saved properly; More Details :"+ providerData.toString());
					returnValue=false;
				}else
					return returnValue;
			
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data" + providerData.toString(), selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	
	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib providerData,String providerCodeUnique) throws IOException{
		try
		{
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
		assertTrue(isTextPresent(selenium,"Spanish"),"language not selected properly",selenium,ClassName,MethodName);
		assertTrue(getValue(selenium,ajxGendersuggestBox ).trim().contains(providerData.gender.trim())," ", selenium, ClassName, MethodName);
		
		if(true){}
		System.out.println(getText(selenium,ajxLanguagesuggestBox).trim());
		System.out.println(providerData.language.trim());
		
		assertTrue(isTextPresent(selenium,providerData.language)," ", selenium, ClassName, MethodName);
		
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
		
/*		assertTrue(getValue(selenium,  txtDea ).trim().contains(providerData.dEA.trim())," ", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,txtUpinPro).trim().contains(providerData.uPIN.trim())," ", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtNpi).trim().contains(providerData.nPI.trim())," ", selenium, ClassName, MethodName);*/
		
		//assertTrue(getValue(selenium,ajxReportMethodsuggestBox).trim().contains(providerData.reportMethod.trim())," ", selenium, ClassName, MethodName);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
}


