package com.nexia.selenium.testscripts.section.systemsettings.externalproviders;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestExternalProviders extends AbstractSystemSettingsTest{
	public String CAAccount = fetchProperty("clinical", "CAAccount").trim().equals("") ? "0" : fetchProperty("clinical", "CAAccount").trim();
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReferringCodeWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_001";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLastNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_002";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFirstNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_003";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMiddleInitialWithNumericData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_004";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReportMethodWithUnknownData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_005";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySpecialityWithUnknownData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_006";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUpinWithUnknownData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_007";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
		}
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNpiWithUnknownData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_008";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
		}
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTaxonomyWithUnknownData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_009";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
		}
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCommentsWithMoreData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_010";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCityWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_011";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStateWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_012";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyZipCodeWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_013";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCountryWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_014";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneNumberWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_015";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneExtWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_016";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFaxWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_017";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEmailWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest externalData= new SystemsSettingsUnitTest();
		externalData.workSheetName = "UnitTest_SystemSettings_EP";
		externalData.testCaseId = "TC_SS_EP_018";
		externalData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, externalData);
	}
	public boolean addExternalProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest externalData) throws IOException{
	    Selenium selenium = null;
		String alertText="";
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			// Login to the application//
			//--------------------------------------------------------------------//			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrieve the New Selenium Session; More Details :" + externalData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, externalData.userName, externalData.userPassword);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,externalData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
								
			//--------------------------------------------------------------------//
			//  Step-2: Go to system settings  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			isElementPresent(selenium,lnkAdminOrgStructureLists);
			assertTrue(click(selenium,lnkExternalProviderList),"Could not go to External Providers.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			isElementPresent(selenium,lnkAddReferringProvider );
			assertTrue(click(selenium,lnkAddReferringProvider ),"Could not add External Providers.", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//
			try {
				if(!addsExternalProvider(selenium, externalData) && externalData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
					if(isElementPresent(selenium,"//p")){
						alertText = getText(selenium, "//p");
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(externalData.alertMessageCa.trim().toLowerCase(new java.util.Locale("en", "US")))
								|| alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(externalData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US")))){
				   			return returnValue;			
						}else{
							assertTrue( false , 
									"An unexpected Alert is displayed with message; The Expected :"+externalData.alertMessage+" ;The Actual:"+alertText + "; More Details :" 
									+ externalData.toString(), selenium, ClassName, MethodName);
						}
					}else{
						assertTrue( false , 
								"Alert is not getting displayed; The Expected :"+externalData.alertMessage+" ;The Actual:"+alertText + "; More Details :" 
								+ externalData.toString(), selenium, ClassName, MethodName);
					}	
				}else if(externalData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
					return returnValue;
				}else{
					assertTrue( false , "Expected Alert is not displayed; The Expected :"+externalData.alertMessage+" ;The Actual:"+alertText + "; More Details :" 
							+ externalData.toString(), selenium, ClassName, MethodName);
				}
			} catch (Exception e) {
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + externalData.toString(), selenium, ClassName, MethodName);
				returnValue=false;
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + externalData.toString(), selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}
	public boolean addsExternalProvider(Selenium selenium,SystemsSettingsUnitTest externalData) throws IOException{
		boolean returnValue=false;
		try{
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy mm:HH");
			String uniqueNo=DateFormat.format(cal.getTime());
			if(!externalData.testCaseId.equals("TC_SS_EP_001")){
				assertTrue(type(selenium, txtReferringCode,externalData.referringCode+uniqueNo),"Could not enter the  referring code; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
			}
		
		assertTrue(type(selenium,txtLastName,externalData.lastName),"Could not enter the last name; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtFirstName,externalData.firstName),"Could not enter the first name; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtMiddleInitials,externalData.middleInitial),"Could not enter the middle initial; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtCredentials,externalData.credentials),"Could not enter the credentials; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtStateLicNum,externalData.licenseNumber),"Could not enter the license number; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		selectValueFromAjaxListUsingTypeKeys(selenium,ajxReportMethod,externalData.reportMethod);
		selectValueFromAjaxListUsingTypeKeys(selenium,ajxSpecialtySuggestBox,externalData.speciality);
		waitForPageLoad(selenium);
		if(!externalData.billingExclusion.isEmpty())
			if(!externalData.billingExclusion.contains("No"))
				assertTrue(click(selenium,chkBillingExBox),"Could not click billing exclusion", selenium, ClassName, MethodName);
		
		if(!externalData.pecos.isEmpty())
			if(!externalData.pecos.contains("No"))
				click(selenium,chkPecoscheckbox);
		
		type(selenium,txtUpin,externalData.upin);
		type(selenium, txtNpi,externalData.npi);
		type(selenium,txtTaxonomyCode,externalData.taxonomyCode);
		assertTrue(type(selenium,txtComments,externalData.comments),"Could not enter the comments; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtPracticeName1,externalData.practiceName),"Could not enter the practise name; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtEpzipcode1,externalData.zipcode),"Could not enter the zipcode; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtEpstreet11,externalData.street),"Could not enter the street; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtEpcity1,externalData.city),"Could not enter the street; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium, ajxEpstate1,externalData.state),"Could not enter the state; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium, ajxEpCountry1,externalData.country),"Could not enter the country; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtEpPhone1,externalData.telephoneNo1),"Could not enter the phone no; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		//assertTrue(type(selenium,txtEpExtn1,externalData.telephoneextnNo1),"Could not enter the phone no extention; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtEpFax1,externalData.fax),"Could not enter the fax; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,"eMail1",externalData.email),"Could not enter the email; More Details :" + externalData.toString(), selenium, ClassName, MethodName);
		click(selenium,btnSave);
		waitForPageLoad(selenium);
			if(isElementPresent(selenium, lblTitle )){
				returnValue=true;
			}else{
			return returnValue;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
	
	
	
	
		