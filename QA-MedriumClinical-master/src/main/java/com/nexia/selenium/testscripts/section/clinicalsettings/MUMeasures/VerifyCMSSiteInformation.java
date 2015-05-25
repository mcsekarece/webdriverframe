package com.nexia.selenium.testscripts.section.clinicalsettings.MUMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCMSSiteInformation extends AbstractClinicalSettings{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCmsSiteInformation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_001";
		muData.fetchClinicalSettingsTestData();
		verifyCMSSite(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	}
	
	/**
	 * verifyCMSSite
	 * function to verifyCMSSite
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 28, 2012
	 */
	
	public boolean verifyCMSSite(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib muData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + muData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, muData.userName, muData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Meaningful measures								  //
			//--------------------------------------------------------------------//
			assertTrue(goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Naviagte to CMS site							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkCMSinfo),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			String st1[]=selenium.getAllWindowNames();
			
			switchto(st1[1]);
			selenium.selectWindow(st1[1]);
			selenium.windowFocus();

			/*selenium.selectWindow("wrapper");
			selenium.windowFocus();*/
			
			if(isElementPresent(selenium,lnkMedicare)){
				returnValue=true;
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}

	private void switchto(String string) {
		// TODO Auto-generated method stub
		
	}
}

