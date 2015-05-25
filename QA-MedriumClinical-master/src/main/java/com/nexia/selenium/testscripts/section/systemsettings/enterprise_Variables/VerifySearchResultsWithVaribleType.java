package com.nexia.selenium.testscripts.section.systemsettings.enterprise_Variables;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchResultsWithVaribleType extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for editing an Enterprise Vaiable")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEnterpriseVaribleInSEconomics(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib enterPriseData = new SystemSettingsLib();
		enterPriseData.workSheetName = "AdminEnterPriseVariables";
		enterPriseData.testCaseId = "TC_Pv_002";
		enterPriseData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editEnterpriseVariable(seleniumHost, seleniumPort, browser, webSite, userAccount, enterPriseData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for editing an Enterprise Vaiable")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchResultsUsingEnterKey(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib enterPriseData = new SystemSettingsLib();
		enterPriseData.workSheetName = "AdminEnterPriseVariables";
		enterPriseData.testCaseId = "TC_Pv_002";
		enterPriseData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySearchUsingEnterKey(seleniumHost, seleniumPort, browser, webSite, userAccount, enterPriseData);
	}
	
	/**
	 * editEnterpriseVariable
	 * function to edit an Enterprise Variable 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		: InterruptedException 
	 
	 * @since  	     June 20, 2010
	*/
	public boolean editEnterpriseVariable(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib enterPriseData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
	
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + enterPriseData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, enterPriseData.userName, enterPriseData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,enterPriseData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Enterprise Variables //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEnterpriseVariables),"Could not click the Enter prise Variable;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete exist Enterprise Variables //
			//--------------------------------------------------------------------//
			assertTrue(deleteEnterPrise(selenium,enterPriseData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-4:Add Enterprise Variables //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddenterprise),"Could not click the Add button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createEnterPrise(selenium,enterPriseData,uniqueName),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			SystemSettingsLib enterPrisesData = new SystemSettingsLib();
			enterPrisesData.workSheetName = "AdminEnterPriseVariables";
			enterPrisesData.testCaseId = "TC_Pv_003";
			enterPrisesData.fetchSystemSettingTestData();
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddenterprise),"Could not click the Add button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(ajxSuggestBox , "");
			selectValueFromAjaxList(selenium,ajxSuggestBox ,enterPrisesData.idType);
			assertTrue(type(selenium, txtVariableBox,enterPrisesData.idName+uniqueName),"Could not enter the IdName;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			type(selenium,txtSearchBox,enterPriseData.idType);
			waitForPageLoad(selenium);
			click(selenium,btnSearchBox);
			waitForPageLoad(selenium);
			
			assertTrue(!verifyStoredValues(selenium, enterPriseData,enterPrisesData), 
					"Socio-Economic details not saved properly; More Details :"+enterPriseData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
		e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, SystemSettingsLib  enterPriseData,SystemSettingsLib enterprisesData){
		waitForPageLoad(selenium);
		System.out.println(getText(selenium,vfyStoreEnterprise));
		if(!getText(selenium,vfyStoreEnterprise).contains(enterprisesData.idName)){
			return false;
		}
		
	return true;
	}
	/**
	 * verifySearchUsingEnterKey
	 * function to verify Search Using Enter Key
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		: InterruptedException 
	 
	 * @since  	    Sep 19, 2010
	*/
	public boolean verifySearchUsingEnterKey(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib enterPriseData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
	
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + enterPriseData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, enterPriseData.userName, enterPriseData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Enterprise Variables //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEnterpriseVariables),"Could not click the Enter prise Variable;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete exist Enterprise Variables //
			//--------------------------------------------------------------------//
			assertTrue(deleteEnterPrise(selenium,enterPriseData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-4:Add Enterprise Variables //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddenterprise),"Could not click the Add button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createEnterPrise(selenium,enterPriseData,uniqueName),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			SystemSettingsLib enterPrisesData = new SystemSettingsLib();
			enterPrisesData.workSheetName = "AdminEnterPriseVariables";
			enterPrisesData.testCaseId = "TC_Pv_003";
			enterPrisesData.fetchSystemSettingTestData();
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddenterprise),"Could not click the Add button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(ajxSuggestBox , "");
			selectValueFromAjaxList(selenium,ajxSuggestBox ,enterPrisesData.idType);
			waitForPageLoad(selenium);
			cal=Calendar.getInstance();
			DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=DateFormat.format(cal.getTime());
			assertTrue(type(selenium, txtVariableBox,enterPrisesData.idName+uniqueName),"Could not enter the IdName;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			type(selenium,txtSearchBox,enterPriseData.idType);
			waitForPageLoad(selenium);
			selenium.keyPress(txtSearchBox, btnEnter1);
			waitForPageLoad(selenium);
			}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}